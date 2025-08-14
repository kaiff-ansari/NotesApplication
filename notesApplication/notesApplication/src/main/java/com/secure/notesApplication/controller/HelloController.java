package com.secure.notesApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("/hii")
    public String sayHii(){
        return "Hii!";
    }

    @GetMapping("/contact")
    public String say(){
        return "contact!";
    }

}
