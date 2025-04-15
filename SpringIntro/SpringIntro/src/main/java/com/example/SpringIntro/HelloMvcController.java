package com.example.SpringIntro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloMvcController {

    @GetMapping("/hellomvc")
    public String showHello(@RequestParam(name = "name", defaultValue = " Guest") String name, Model model){

        String message = "Hello " + name;
        model.addAttribute("message", message);
        return "hello";
    }
}
