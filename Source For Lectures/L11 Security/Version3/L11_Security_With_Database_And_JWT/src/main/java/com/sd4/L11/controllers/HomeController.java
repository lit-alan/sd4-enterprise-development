package com.sd4.L11.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/content")
    public String contentIndex() {
        return "content/index";
    }


    @GetMapping("/content/more")
    public String content() {
        return "content/content1";
    }

    @GetMapping("/content/even-more")
    public String moreContent() {
        return "content/content2";
    }
}