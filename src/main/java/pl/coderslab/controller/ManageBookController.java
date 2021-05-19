package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.Book;
import pl.coderslab.app.BookServices;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {

    private final BookServices bookServices;


    public ManageBookController(final BookServices bookServices) {
        this.bookServices = bookServices;
    }

    @GetMapping ("/all")
    public String showBooks(Model model){
        List<Book> books = bookServices.getBooks();
        model.addAttribute("books",books);
        return "/books/all";
    }

    @GetMapping("/add")
    public String createBook(Model model){
        model.addAttribute("book", new Book());
        return "/books/form";
    }
    @PostMapping("/add")
    public String createBookPost(@ModelAttribute @Valid Book book){
        bookServices.creatBook(book);
        return "redirect:all";
    }

    @GetMapping ("/delete/{id}")
    public String deleteBookByID(@PathVariable long id){
        bookServices.deleteBookByID(id);
        return "redirect:../all";
    }

    @GetMapping ("/show/{id}")
    public String showBookByID(Model model, @PathVariable long id) {
        Book book = bookServices.getBookByID(id).orElseThrow(() -> {throw new NoSuchElementException("Book not found");});
        model.addAttribute("book",book);
        return "/books/showBook";
    }


    @GetMapping ("/update/{id}")
    public String upDateBook(@PathVariable long id, Model model){
        model.addAttribute("book", bookServices.getBookByID(id));
        return "/books/form";
    }
    @PostMapping ("/update/{id}")
    public String upDateBookPost (@ModelAttribute @Valid Book book, BindingResult violations){
        if(violations.hasErrors()) {
            return "/books/form";
        }
        this.bookServices.updateBook(book);
        return "redirect:../all";
    }

}
