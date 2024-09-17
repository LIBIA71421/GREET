package com.ucb.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    @Autowired
    private GreetingProperties greetingProperties;

    public String getGreeting() {
        return greetingProperties.getGreetings().get("es");
    }

    public String getNameInGreeting(String name, String lang) {
        String greet = greetingProperties.getGreetings().get(lang);
        return (greet != null) ? name + ", " + greet : "Greeting not found";
    }
}
