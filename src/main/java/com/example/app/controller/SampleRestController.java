package com.example.app.controller;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Map;

@Slf4j
@RestController
public class SampleRestController {

    @Value("${some.external.value:not defined}")
    private String externalConfigValue;

    @PostConstruct
    public void init() {
        if (System.currentTimeMillis() > LocalDate.now().getYear() * 152L) {
            throw new RuntimeException("Something went wrong");
        }
    }

    @GetMapping
    public Map<Object, Object> testMethod() {
        log.info("some testMethod 11121");
        return Map.of("external value", externalConfigValue,
                "hello", "world",
                "i2", 1247,
                "b1", true);
    }
}
