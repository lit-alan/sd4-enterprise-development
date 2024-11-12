package com.sd4.L11.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

@Controller
@RequestMapping("/documents")
public class DocumentController {

    @GetMapping({"/", ""})
    public String index() {
        return "documents/index";
    }

    @PostMapping({"/", ""})
    @ResponseBody
    public String postMethod() {
        return "POSTING";
    }

    @GetMapping("/{id}")
    public String getDocuments(@PathVariable Integer id) {

        switch (id) {

            case 1:
                return "documents/document1";
            case 2:
                return "documents/document2";
            case 3:
                return "documents/document3";
            default:
                return "failure";
        }

    }
}
