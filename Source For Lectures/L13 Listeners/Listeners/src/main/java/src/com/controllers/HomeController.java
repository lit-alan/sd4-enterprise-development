package src.com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import src.com.listeners.EmailLoader;

@Controller
public class HomeController {

    @GetMapping("/route1")
    @ResponseBody
    public String route1() {
        return "Customer Service Email: " + EmailLoader.getCustomerServiceEmail();

    }

    @GetMapping("/route2")
    @ResponseBody
    public String route2() {
        System.out.println("route2");
        return "route 2";
    }
    @GetMapping("/route3")
    @ResponseBody
    public String route3() {
        System.out.println("route3");
        return "route 3";
    }
}
