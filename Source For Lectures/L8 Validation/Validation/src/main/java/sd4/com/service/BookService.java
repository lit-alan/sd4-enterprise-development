package sd4.com.service;

import sd4.com.model.Book;
import sd4.com.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepo;

    Pageable pageable = PageRequest.of(0, 5, Sort.by("price").descending());
    Page<Book> pagedBooks = bookRepository.findAll(pageable);

    for (Book book : pagedBooks.getContent()) {
        System.out.println(book.getTitle() + " - " + book.getPrice());
    }


    public void getSortedBooks() {
        //Sort by price in descending order
        Sort sort = Sort.by("price").descending();

        Sort sort = Sort.by("publisher").ascending().and(Sort.by("price").descending());

        List<Book> books = bookRepository.findAll(sort);

        for (Book book : books) {
            System.out.println(book.getTitle() + " - " + book.getPrice());
        }
    }


    public void getPagedBooks() {
        Pageable pageable = PageRequest.of(0, 5);  // First page, 5 records per page

        Page<Book> pagedBooks = bookRepository.findAll(pageable);

        //Get data from the page
        List<Book> books = pagedBooks.getContent();
        int totalPages = pagedBooks.getTotalPages();
        long totalElements = pagedBooks.getTotalElements();
        boolean isFirstPage = pagedBooks.isFirst();
        boolean isLastPage = pagedBooks.isLast();

        //Log the title and price of each book
        for (Book book : books) {
            System.out.println(book.getTitle() + " - " + book.getPrice());
        }
    }



    List<Object[]> results = bookRepo.averagePricePerPublisher();

    for (Object[] result : results) {
            String publisher = (String) result[0];  //First element: publisher
            Double avgPrice = (Double) result[1];   //Second element: average price
            System.out.println("Publisher: " + publisher + ", Average Price: " + avgPrice);
    }


    public List<Book> getExpensiveBooks(double priceThreshold) {
        List<Book> expensiveBooks = bookRepo.findBooksMoreExpensiveThan(priceThreshold);
        return expensiveBooks;
    }

    public Optional<Book> findOne(Long id) {
        return bookRepo.findById(id);
    }

    public List<Book> findAll() {
        return (List<Book>) bookRepo.findAll();
    }
    
    public long count() {
        return bookRepo.count();
    }

    public void deleteByID(long authorID) {
        bookRepo.deleteById(authorID);
    }

    public void saveBook(Book a) {
        bookRepo.save(a);
    }

    public Book updateBook(Book updatedBook) {
        Optional<Book> existingBook = bookRepo.findById(updatedBook.getBookId());

        if (existingBook.isPresent()) {
            Book book = existingBook.get();

            // Set new values for the book attributes you want to change
            book.setTitle(updatedBook.getTitle());
            book.setPublisher(updatedBook.getPublisher());
            book.setIsbn(updatedBook.getIsbn());
            book.setPublicationDate(updatedBook.getPublicationDate());
            book.setPrice(updatedBook.getPrice());

            // Save the book back to the database
            bookRepo.save(book);

            return book;
        } else {
            // Handle the case where the book is not found
            throw new EntityNotFoundException("Book not found with id " + updatedBook.getBookId());
        }
    }

}//end class

