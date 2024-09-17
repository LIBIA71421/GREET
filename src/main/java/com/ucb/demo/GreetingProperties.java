package com.ucb.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "greeting")
public class GreetingProperties {
    public Map<String, String> greetings;
    public Map<String, String> getGreetings(){
        return greetings;
    }
    public void setGreetings(Map<String, String> greetings)
    {
        this.greetings= greetings;
    }

    public String getNameInGreetings(String name, String lang) {
        String greeting = greetings.get(lang);
        return (greeting != null) ? name + ", " + greeting : "Greeting not found";
    }
}
