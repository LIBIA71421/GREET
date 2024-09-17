package com.ucb.demo;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class GreetingServiceTest {

    @Mock
    private GreetingProperties greetingProperties;

    @InjectMocks
    private GreetingService greetingService;

    public GreetingServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetNameInGreeting() {
        Map<String, String> greetings = new HashMap<>();
        greetings.put("es", "Pregúntate si lo que estás haciendo hoy te acerca al lugar en el que quieres estar mañana.");
        greetings.put("en", "Ask yourself if what you are doing today takes you to the place where you want to be tomorrow.");

        when(greetingProperties.getGreetings()).thenReturn(greetings);

        String resultEs = greetingService.getNameInGreeting("Juan", "es");
        assertEquals("Juan, Pregúntate si lo que estás haciendo hoy te acerca al lugar en el que quieres estar mañana.", resultEs);

        String resultEn = greetingService.getNameInGreeting("John", "en");
        assertEquals("John, Ask yourself if what you are doing today takes you to the place where you want to be tomorrow.", resultEn);

        String resultNotFound = greetingService.getNameInGreeting("Doe", "fr");
        assertEquals("Greeting not found", resultNotFound);
    }
}