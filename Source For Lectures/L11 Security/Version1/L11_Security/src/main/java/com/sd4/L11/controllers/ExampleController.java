package com.sd4.L11.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Public Content";
    }

    @PreAuthorize("hasRole('user')")
    @GetMapping("/user")
    public String userOnlyEndpoint() {
        return "User Content";
    }

    @PreAuthorize("hasRole('manager')")
    @GetMapping("/manager")
    public String managerOnlyEndpoint() {
        return "Manager Content";
    }
}



