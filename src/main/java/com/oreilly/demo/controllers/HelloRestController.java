package com.oreilly.demo.controllers;

import com.oreilly.demo.entities.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // REST controllers will serialize and deserialize Java classes into JSON data using the Jackson 2 JSON library, which is currently on the classpath by default.
public class HelloRestController {

    @GetMapping("/rest")
    public Greeting greet(@RequestParam(value="name",required = false,defaultValue = "World") String name){
        return new Greeting(String.format("Hello, %s!",name));
    }
}
