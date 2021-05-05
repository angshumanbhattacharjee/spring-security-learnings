package com.demo.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

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
