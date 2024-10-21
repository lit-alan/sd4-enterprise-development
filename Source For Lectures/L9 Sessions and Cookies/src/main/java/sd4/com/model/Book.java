package sd4.com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.ISBN;
import org.springframework.format.annotation.DateTimeFormat;
import sd4.com.validators.isbn.ValidISBN;
import sd4.com.validators.isbn_and_date.ValidIsbnForPublicationDate;

import java.util.Date;

/**
 *
 * @author Alan.Ryan
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ValidIsbnForPublicationDate
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    @NotBlank(message = "Title cannot be empty")
    private String title;

    @NotBlank(message="Publisher cannot be empty")
    @Size(min = 3, message="Publisher must be at least 3 characters")
    private String publisher;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publicationDate;

    @NotNull(message="Price cannot be empty")
    @DecimalMin("1.0")
    private Double price;

    @NotBlank(message="ISBN cannot be null")
    //@ISBN(type = ISBN.Type.ISBN_10)
    @ISBN(type = ISBN.Type.ISBN_13) //can't combine the requirement to support both ISBN 10 and ISBN 13
    //@ValidISBN(message = "The provided ISBN is invalid. Please enter a valid ISBN-10 or ISBN-13.")
    private String isbn;

    private long authorID;

}


