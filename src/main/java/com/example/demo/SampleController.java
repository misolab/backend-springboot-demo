package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.CustomProperties;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@Tag(name = "Sample", description = "샘플 API")
public class SampleController {

    @Value("${spring.profiles.active:default}")
    private String activeProfile;

    @Autowired
    private CustomProperties customProperties;

    @Operation(summary = "Hello API", description = "프로파일과 커스텀 설정값을 반환합니다.")
    @GetMapping("/")
    public Map<String, String> hello() {
        log.debug("Debug log message");
        log.info("Info log message");
        log.warn("Warn log message");
        log.error("Error log message");

        Map<String, String> response = new HashMap<>();
        response.put("profile", activeProfile);
        response.put("custom", customProperties.getCustom());
        response.put("message", "Back-end Spring Boot Demo");
        return response;
    }

}