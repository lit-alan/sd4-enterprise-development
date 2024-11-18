package src.com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/")
    @ResponseBody
    public String admin() {
        return "admin section";
    }

    @GetMapping("/editprofile")
    @ResponseBody
    public String editprofile() {
        return "edit profile";
    }

    @GetMapping("/adduser")
    @ResponseBody
    public String adduser() {
        return "add user";
    }
    @GetMapping("/deleteprofile")
    @ResponseBody
    public String route3() {
        return "delete profile";
    }
}
