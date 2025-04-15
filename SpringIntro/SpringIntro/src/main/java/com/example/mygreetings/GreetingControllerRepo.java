package com.example.mygreetings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/greetingrepo")
public class GreetingControllerRepo {

    @Autowired
    private GreetingServiceRepo service;

    @PostMapping("/save")
    public GreetingEntity saveGreeting(@RequestParam String message) {
        return service.saveGreeting(message);
    }

    @GetMapping("/find/{id}")
    public Optional<GreetingEntity> findGreetingById(@PathVariable Long id) {
        return service.findGreetingById(id);
    }

    @GetMapping("/all")
    public List<GreetingEntity> findAllGreetings() {
        return service.findAllGreetings();
    }

    @PutMapping("/update/{id}")
    public GreetingEntity updateGreeting(@PathVariable Long id, @RequestParam String message) {
        return service.updateGreeting(id, message);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        service.deleteGreeting(id);
        return "Greeting with ID " + id + " deleted successfully.";
    }
}
