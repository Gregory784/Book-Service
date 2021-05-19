package pl.coderslab.app;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MemoryBookService implements BookServices {
    private static Long nextId = 4L;
    private List<Book> booksList;

    public MemoryBookService() {
        booksList = new ArrayList<>();
      /*  booksList.add(new Book(1L, "9788324631766", "Thiniking in Java", "Bruce Eckel", "Helion", "programming"));
        booksList.add(new Book(2L, "9788324627738", "Rusz glowa Java.", "Sierra Kathy, Bates Bert", "Helion",
                "programming"));
        booksList.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion",
                "programming"));*/
    }

    @Override
    public List<Book> getBooks() {
        return booksList;
    }

    @Override
    public void creatBook(Book book) {
        book.setId(nextId++);
        booksList.add(book);
    }

    @Override
    public Optional<Book> getBookByID(Long id) {
        return booksList.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();
    }

    @Override
    public void updateBook(Book book) {
        if (this.getBookByID(book.getId()).isPresent()) {
            int bookToChange = booksList.indexOf((this.getBookByID(book.getId()).get()));
            booksList.set(bookToChange, book);
        }
    }

    @Override
    public void deleteBookByID(Long id) {
        if (getBookByID(id).isPresent()) {
            booksList.remove(this.getBookByID(id).get());
        }
    }
}
