package com.oreilly.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // Designed to handle HTTP Requests and return HTTP Response
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(
            @RequestParam(value = "name", required = false,
                    defaultValue = "World") String name, Model model){ //Model is a Java Map with key-value pairs that allows us to pass values from controller to view(Thymeleaf)
        model.addAttribute("user", name);
        return "hello"; // forward to: src/main/resources/templates/hello.html
    }
}
