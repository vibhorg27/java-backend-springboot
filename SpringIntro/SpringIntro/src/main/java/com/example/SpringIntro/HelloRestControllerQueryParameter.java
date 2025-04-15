package com.example.SpringIntro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestControllerQueryParameter {

    @GetMapping("/hellorest/query")
    public String getHello(@RequestParam String name){
        return "Hello " + name;
    }
}
