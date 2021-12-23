package com.example.govtech;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/users")
    public String GetUsers() {
        return "Greetings from users path";
    }

    @GetMapping("/upload")
    public String PostUpload() {
        return "upload path";
    }

}