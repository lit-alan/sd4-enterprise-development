
package sd4.com.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sd4.com.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {



    @Query("SELECT b FROM Book b WHERE b.publisher = :publisher")
    List<Book> findBookByPublisher(String publisher);
}
