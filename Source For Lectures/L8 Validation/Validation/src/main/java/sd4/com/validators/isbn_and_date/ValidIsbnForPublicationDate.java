package sd4.com.validators.isbn_and_date;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;


@Documented
@Constraint(validatedBy = IsbnPublicationDateValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidIsbnForPublicationDate {

    String message() default "Invalid ISBN for the given publication date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
