package sd4.com.application;

import com.github.javafaker.Faker;
import sd4.com.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import sd4.com.service.BookService;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SpringBootApplication
@ComponentScan({"sd4.com.service", "sd4.com.controllers"})
@EntityScan("sd4.com.model")
@EnableJpaRepositories("sd4.com.repository")
public class L9_Sessions_And_Cookies implements CommandLineRunner {

    @Autowired
    public BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(L9_Sessions_And_Cookies.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Date startDate = new GregorianCalendar(2007, Calendar.JANUARY, 1).getTime();
        Date today = new Date();
        Faker faker = new Faker();

        for (int i = 1; i <=100 ; i++) {
            bookService.saveBook(new Book(Long.valueOf(i), faker.book().title(), faker.book().publisher(),faker.date().between(startDate, today) , faker.number().randomDouble(2,5,35), faker.code().isbn13(true) ,faker.number().numberBetween(1,15)));
        }
    }

}
