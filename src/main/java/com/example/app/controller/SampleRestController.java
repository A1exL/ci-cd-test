package com.example.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class SampleRestController {

    @GetMapping
    public Map<Object, Object> testMethod() {
        log.info("testMethod");
        return Map.of("hello", "world", "i1", 1247, "b1", true);
    }
}
