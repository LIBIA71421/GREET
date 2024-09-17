package com.ucb.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @Autowired
    private GreetingProperties greetingProperties;

    @GetMapping
    public String greeting(@RequestParam(defaultValue = "en") String lang) {
        return greetingProperties.getGreetings().get(lang);
    }

    @GetMapping("/name")
    public String nameInGreeting(@RequestParam String name, @RequestParam(defaultValue = "en") String lang) {
        String greet = greetingProperties.getGreetings().get(lang);
        return greetingProperties.getNameInGreetings(name, greet);
    }
}