package sd4.com.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import sd4.com.model.Book;
import sd4.com.service.BookService;

import java.util.Optional;

@Controller
public class HomeController {

    private BookService bookService;


    // Add a global attribute to all views
    @ModelAttribute("greeting")
    public String greetingMessage() {
        return "Welcome to the site!";
    }

    @GetMapping("/home")
    public String homePage() { return "home"; }

    @GetMapping("/profile")
    public String profilePage() { return "profile"; }

    @GetMapping("/edit/{id}")
    public String showEditBookForm(@PathVariable("id") long id, Model model) {
        if (bookService.findOne(id).isEmpty()) {
            model.addAttribute("errorMsg", "Book not found");
            return "/error";
        }
        else {
            model.addAttribute("aBook", bookService.findOne(id).get());
            return "/editBook";
        }
    }


}

