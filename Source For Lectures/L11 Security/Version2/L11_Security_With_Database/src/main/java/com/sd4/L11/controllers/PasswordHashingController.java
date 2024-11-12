package com.sd4.L11.controllers;

import com.sd4.L11.service.PasswordHashingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class PasswordHashingController {

    @Autowired
    private PasswordHashingService passwordHashingService;

    @GetMapping("/hash-passwords")
    @ResponseBody
    public String hashPasswords() {
        passwordHashingService.hashExistingPasswords();
        return "Passwords hashed successfully.";
    }
}
