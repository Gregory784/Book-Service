package pl.coderslab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// był to pomocniczy kontroler przy testowaniu zanim wprowadziałem przyjmowanie JSON z postmana metodą POST
@Controller
@RequestMapping("/books")
public class CreatBookController {
    @GetMapping("/add")
    public String addBook() {
        return "/form.jsp";
    }
}
