package pl.coderslab.app;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class JpaBookServices implements BookServices {

    private final BookRepository bookRepository;

    public JpaBookServices(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
       return bookRepository.findAll();
    }

    @Override
    public void creatBook(final Book book) {
        bookRepository.save(book);
    }

    @Override
    public Optional<Book> getBookByID(final Long id) {
       return this.bookRepository.findById(id);
    }

    @Override
    public void updateBook(final Book book) {
        if (this.getBookByID(book.getId()).isPresent()) {
            bookRepository.save(book);
        }
    }

    @Override
    public void deleteBookByID(final Long id) {
        bookRepository.deleteById(id);

    }
}
