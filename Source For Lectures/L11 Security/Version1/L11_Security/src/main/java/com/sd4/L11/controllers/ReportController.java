package com.sd4.L11.controllers;


import com.sd4.L11.exceptions.ForbiddenException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reports")

public class ReportController {

//    @GetMapping({"", "/"})
//    public String index(HttpServletRequest req) {
//        if (!req.isUserInRole("MANAGER"))
//            throw new ForbiddenException();
//        else
//            return "reports/index";
//    }

   @GetMapping({"", "/"})
    public String index() {
            return "reports/index";
    }

   @PostMapping ({"", "/"})
   public String doIt() {
        return "reports/index";
    }

    @GetMapping("/{id}")
    public String getReports(@PathVariable Integer id) {

        switch (id) {

            case 1:
                return "reports/reports1";
            case 2:
                return "reports/reports2";
            case 3:
                return "reports/reports3";
            default:
                return "failure";
        }
    }
}
