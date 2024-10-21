package sd4.com.validators.isbn_and_date;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import sd4.com.model.Book;

import java.util.Calendar;
import java.util.Date;

public class IsbnPublicationDateValidator implements ConstraintValidator<ValidIsbnForPublicationDate, Book> {

    @Override
    public void initialize(ValidIsbnForPublicationDate constraintAnnotation) {
    }

    @Override
    public boolean isValid(Book book, ConstraintValidatorContext context) {
        // I dont need any validation if fields are null
        if (book.getIsbn() == null || book.getPublicationDate() == null) {
            return true;
        }

        /*
        Create a Date object representing 1/1/2007
        This date is significant because it marks the transition from the 10-digit ISBN format to the 13-digit format.
        Essentially this Date object is  a reference date for comparing other dates
         */
        Calendar c = Calendar.getInstance();
        c.set(2007, Calendar.JANUARY, 1);
        Date isbnChangeDate = c.getTime();

       if (book.getPublicationDate().before(isbnChangeDate)) {
            return book.getIsbn().replaceAll("-", "").length() == 10;
        } else {
            return book.getIsbn().replaceAll("-", "").length() == 13;
        }
    }
}

