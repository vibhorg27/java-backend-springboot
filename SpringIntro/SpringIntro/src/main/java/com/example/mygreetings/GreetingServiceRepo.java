package com.example.mygreetings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingServiceRepo {

    @Autowired
    private GreetingRepository repository;

    public GreetingEntity saveGreeting(String message) {
        GreetingEntity greeting = new GreetingEntity(message);
        return repository.save(greeting);
    }

    public Optional<GreetingEntity> findGreetingById(Long id) {
        return repository.findById(id);
    }


    public List<GreetingEntity> findAllGreetings() {
        return repository.findAll();
    }


    public GreetingEntity updateGreeting(Long id, String newMessage) {
        Optional<GreetingEntity> existingGreeting = repository.findById(id);
        if (existingGreeting.isPresent()) {
            GreetingEntity greeting = existingGreeting.get();
            greeting.setMessage(newMessage);
            return repository.save(greeting);
        } else {
            return null; // if null
        }
    }


    public void deleteGreeting(Long id) {
        repository.deleteById(id);
    }
}
