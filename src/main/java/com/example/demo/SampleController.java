package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.CustomProperties;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SampleController {

    @Value("${spring.profiles.active:default}")
    private String activeProfile;

    @Autowired
    private CustomProperties customProperties;

    @GetMapping("/")
    public String hello() {
        log.debug("Debug log message");
        log.info("Info log message");
        log.warn("Warn log message");
        log.error("Error log message");

        return String.format("[%s] custom: %s", activeProfile, customProperties.getCustom());
    }

}