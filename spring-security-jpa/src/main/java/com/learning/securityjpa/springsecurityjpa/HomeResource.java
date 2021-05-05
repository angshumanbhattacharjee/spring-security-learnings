package com.learning.securityjpa.springsecurityjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping("/")
    public String welcome() {
        return "Welcome Guest";
    }

    @GetMapping("/admin")
    public String welcomeAdmin() {
        return "Welcome Admin";
    }

    @GetMapping("/user")
    public String welcomeUser() {
        return "Welcome User";
    }
}
