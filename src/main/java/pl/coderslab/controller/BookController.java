package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.app.Book;
import pl.coderslab.app.BookServices;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookServices bookServices;

    @Autowired
    public BookController(BookServices bookServices) {
        this.bookServices = bookServices;
    }

    @GetMapping("")
    public List<Book> showList() {
        return bookServices.getBooks();
    }

    @GetMapping("/{idList}")
    public Book showBookByID(@PathVariable Long idList) {
        return this.bookServices.getBookByID(idList).orElseThrow(() -> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Book not found");
        });
    }

    @PostMapping("")
    public void creatBook(@RequestBody Book book) { // trzeba pamiętać, żeby przysyłać JSONa bo tak to będzie missing body przy obiekcie
        bookServices.creatBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookServices.deleteBookByID(id);
    }

    @PutMapping("")
    public void updateBook(@RequestBody Book book) {
        bookServices.updateBook(book);
    }

   /* @PostMapping({"/add", ""})
    public List<Book> createBook (@RequestParam String isbn, @RequestParam String title, @RequestParam String author, @RequestParam String publisher, @RequestParam String type){
        bookServices.creatBook(isbn, title, author, publisher, type);
        return bookServices.getBooks();
    }*/
}
