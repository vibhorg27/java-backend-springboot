package com.example.mygreetings;


import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/greet")
public class GreetingHttpRequests {

    @GetMapping
    public String getGreeting(){
        return "Hello - GET";
    }

    @PostMapping
    public String postGreeting(){
        return "Hello - POST";
    }

    @PutMapping
    public String putGreeting(){
        return "Hello - PUT";
    }

    @DeleteMapping
    public String deleteGreeting(){
        return "Hello - DELETE";
    }
}
