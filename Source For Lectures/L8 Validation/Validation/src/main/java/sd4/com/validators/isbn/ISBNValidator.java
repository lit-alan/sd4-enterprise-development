package sd4.com.validators.isbn;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ISBNValidator implements ConstraintValidator<ValidISBN, String> {

    @Override
    public void initialize(ValidISBN validISBN) {
    }

    @Override
    public boolean isValid(String isbn, ConstraintValidatorContext context) {
        if (isbn == null) {
            return false;
        }

        // Remove hyphens from isbn
        isbn = isbn.replaceAll("-", "");

        // Check if ISBN is either 10 or 13 digits long
        if (isbn.length() == 10) {
            return isValidISBN10(isbn);
        } else if (isbn.length() == 13) {
            return isValidISBN13(isbn);
        }

        return false;
    }

    private boolean isValidISBN10(String isbn) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = isbn.charAt(i) - '0';
            if (0 > digit || 9 < digit) return false;
            sum += (digit * (10 - i));
        }

        char lastChar = isbn.charAt(9);
        if (lastChar != 'X' && (lastChar < '0' || lastChar > '9')) return false;

        sum += (lastChar == 'X') ? 10 : (lastChar - '0');

        return (sum % 11 == 0);
    }

    private boolean isValidISBN13(String isbn) {
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            int digit = isbn.charAt(i) - '0';
            sum += (digit * ((i % 2 == 0) ? 1 : 3));
        }

        int checksum = 10 - (sum % 10);
        if (checksum == 10) {
            checksum = 0;
        }

        return checksum == isbn.charAt(12) - '0';
    }
}
