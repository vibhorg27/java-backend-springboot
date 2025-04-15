package com.example.mygreetings;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingServiceRequest {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/helloservice")
    public String sayHello() {
        return greetingService.getGreetingMessage();
    }
}
