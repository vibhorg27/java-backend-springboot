package com.example.mygreetings;

import jakarta.persistence.*;

@Entity
public class GreetingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    public GreetingEntity() {}

    public GreetingEntity(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}