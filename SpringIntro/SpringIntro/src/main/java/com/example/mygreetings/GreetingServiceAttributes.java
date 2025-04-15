package com.example.mygreetings;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceAttributes {

    public Greeting getGreetingMessage(String firstName, String lastName) {
        String message;

        if (firstName != null && lastName != null) {
            message = "Hello " + firstName + " " + lastName;
        } else if (firstName != null) {
            message = "Hello " + firstName;
        } else if (lastName != null) {
            message = "Hello " + lastName;
        } else {
            message = "Hello World";
        }

        return new Greeting(message);
    }
}
