package com.example.SpringIntro;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloControllerPut {

    @PutMapping("/put/{firstName}")
    public String sayHelloPut(@PathVariable String firstName, @RequestParam String lastName) {
        return "Hello " + firstName + " " + lastName + " from BridgeLabz";
    }
}

