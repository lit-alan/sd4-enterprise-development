
package sd4.com.repository;


import org.springframework.data.jpa.repository.Query;
import sd4.com.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {


    //Find all books and allow pagination and sorting
    //I dont need to define this as Spring Data will provide an implementation for me
    Page<Book> findAll(Pageable pageable);

    //Find books by publisher with pagination and sorting
    Page<Book> findByPublisher(String publisher, Pageable pageable);

    //Find books with a price greater than a certain value, with pagination and sorting
    Page<Book> findByPriceGreaterThan(Double price, Pageable pageable);



     @Procedure(procedureName = "calculate_total_value")
     Double calculateTotalValue(@Param("publisherName") String publisherName);

    @Query("SELECT b.publisher, AVG(b.price) FROM Book b GROUP BY b.publisher HAVING AVG(b.price) > :minAvgPrice")
    List<Object[]> publishersWithHighAveragePrice(@Param("minAvgPrice") Double minAvgPrice);


    @Query("SELECT b.publisher, AVG(b.price) FROM Book b GROUP BY b.publisher")
    List<Object[]> averagePricePerPublisher();


    @Query("SELECT MAX(b.price) FROM Book b")
    Double findMaxBookPrice();



    @Query("SELECT MIN(b.price) FROM Book b")
    Double findMinBookPrice();


    @Query("SELECT AVG(b.price) FROM Book b WHERE b.publisher = :publisher")
    Double averagePriceByPublisher(@Param("publisher") String publisher);

//    @Query("SELECT SUM(b.price) FROM Book b WHERE b.publisher = :publisher")
//    Double sumPricesByPublisher(@Param("publisher") String publisher);
//
//    @Query("SELECT COUNT(b) FROM Book b WHERE b.publisher = :publisher")
//    long countBooksByPublisher(@Param("publisher") String publisher);
//
//    @Query("SELECT b FROM Book b WHERE b.price > :price ORDER BY b.title ASC")
//    List<Book> findBooksMoreExpensiveThan(@Param("price") Double price);
//
//    //Find Books by Publisher
//    @Query("SELECT b FROM Book b WHERE b.publisher = :publisher ORDER BY b.title ASC")
//    List<Book> findBooksByPublisher(@Param("publisher") String publisher);
//
//    //Find Books within a Price Range
//    @Query("SELECT b FROM Book b WHERE b.price BETWEEN :minPrice AND :maxPrice ORDER BY b.title ASC")
//    List<Book> findBooksInPriceRange(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice);
//
//    //Find Books Published After a Certain Date
//    @Query("SELECT b FROM Book b WHERE b.publicationDate > :date ORDER BY b.title ASC")
//    List<Book> findBooksPublishedAfter(@Param("date") Date date);

}
