package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "custom")
public class CustomProperties {

    private String common;
    private String message;

    @Override
    public String toString() {
        return String.format("common: %s, message: %s", common, message);
    }
}