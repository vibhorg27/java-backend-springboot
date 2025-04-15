package com.example.SpringIntro;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestControllerPostMapping {
    @PostMapping("/hello/post")
    public String sayHello(@RequestBody User user){
        return "Hello" + user.getFirstName() + user.getLastName();
    }

}
