package com.example.SpringIntro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestControllerPathVariable {
    @GetMapping("/hellorest/param/{name}")// this is the difference between a passing as a path variable and passing as a query parameter
    public String getHello(@PathVariable String name){
        return "Hello " + name;
    }
}
