package com.example.mygreetings;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingServiceAttributes greetingServiceAttributes;

    @GetMapping
    public Greeting sayHello(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        return greetingServiceAttributes.getGreetingMessage(firstName, lastName);
    }
}