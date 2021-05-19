package pl.coderslab.app;

import java.util.List;
import java.util.Optional;


public interface BookServices {
    List<Book> getBooks();

    void creatBook(Book book);

    Optional<Book> getBookByID(Long id);

    void updateBook(Book book);

    void deleteBookByID(Long id);
}
