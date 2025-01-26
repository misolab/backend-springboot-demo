package com.example.demo.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.common.ApiResponse;
import com.example.demo.config.CustomProperties;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
@Tag(name = "Sample", description = "샘플 API")
public class SampleController {

    @Value("${spring.profiles.active:default}")
    private String activeProfile;

    @Autowired
    private CustomProperties customProperties;

    @Operation(summary = "Hello API", description = "프로파일과 커스텀 설정값을 반환합니다.")
    @GetMapping("/")
    public ResponseEntity<ApiResponse<SampleResponse>> hello(@Valid SampleRequest request) {
        log.debug("Debug log message");
        log.info("Info log message - name: {}, email: {}, age: {}",
                request.getName(), request.getEmail(), request.getAge());
        log.warn("Warn log message");
        log.error("Error log message");

        SampleResponse sampleResponse = new SampleResponse();
        sampleResponse.setProfile(activeProfile);
        sampleResponse.setCustom(customProperties.getCustom());
        sampleResponse.setMessage(String.format("Back-end Spring Boot Demo + %s(%s)",
                request.getName(), request.getEmail()));

        if (request.getAge() < 18) {
            return ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR, "나이가 18보다 작습니다.", "500");
        }
        return ApiResponse.success(sampleResponse);
    }

}