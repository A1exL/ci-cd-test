package com.example.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class SampleRestController {

    @Value("${some.external.value:not defined}")
    private String externalConfigValue;

    @GetMapping
    public Map<Object, Object> testMethod() {
        log.info("some testMethod 1");
        return Map.of("external value", externalConfigValue,
                "hello", "world",
                "i2", 1247,
                "b1", true);
    }
}
