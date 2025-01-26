package com.example.demo.sample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.common.ApiResponse;
import com.example.demo.config.CustomProperties;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j @Validated @RestController @Tag(name = "Sample", description = "샘플 API")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @Value("${spring.profiles.active:default}")
    private String activeProfile;

    @Autowired
    private CustomProperties customProperties;

    @Operation(summary = "Hello API", description = "프로파일과 커스텀 설정값을 반환합니다.") @GetMapping("/")
    public ResponseEntity<ApiResponse<Map<String, String>>> hello(@Valid SampleRequest request) {
        log.debug("Debug log message");
        log.info("Info log message - name: {}, email: {}, age: {}",
                request.getName(), request.getEmail(), request.getAge());
        log.warn("Warn log message");
        log.error("Error log message");

        Map<String, String> response = new HashMap<>();
        response.put("profile", activeProfile);
        response.put("custom", customProperties.getCustom());
        response.put("message", String.format("Back-end Spring Boot Demo + %s(%s)",
                request.getName(), request.getEmail()));

        if (request.getAge() < 18) {
            return ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR, "나이가 18보다 작습니다.", "500");
        }
        return ApiResponse.success(response);
    }

    @Operation(summary = "샘플 목록 조회", description = "등록된 모든 샘플 데이터를 조회합니다.") @GetMapping("/sample")
    public ResponseEntity<ApiResponse<List<SampleResponse>>> list() {
        List<SampleEntity> sampleEntities = sampleService.list();
        List<SampleResponse> sampleResponses = sampleEntities.stream()
                .map(SampleResponse::new)
                .collect(Collectors.toList());
        return ApiResponse.success(sampleResponses);
    }

    @Operation(summary = "샘플 데이터 등록", description = "새로운 샘플 데이터를 등록합니다.", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "샘플 등록 요청 데이터", required = true, content = @Content(schema = @Schema(implementation = SampleRequest.class)))) @PostMapping("/sample")
    public ResponseEntity<ApiResponse<Long>> postSample(@Valid @RequestBody SampleRequest request) {
        if (request.getAge() < 18) {
            return ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR, "나이가 18보다 작습니다.", "500");
        }
        Long savedId = sampleService.saveSample(request.getName(), request.getEmail(), request.getAge());
        return ApiResponse.success(savedId);
    }

    @Operation(summary = "샘플 상세 조회", description = "ID로 특정 샘플 데이터를 조회합니다.", parameters = {
            @Parameter(name = "id", description = "샘플 ID", required = true, example = "1", schema = @Schema(type = "integer", format = "int64"))
    }) @GetMapping("/sample/{id}")
    public ResponseEntity<ApiResponse<SampleResponse>> getSample(@PathVariable(name = "id") Long id) {
        SampleEntity sampleEntity = sampleService.getSample(id);
        SampleResponse sampleResponse = new SampleResponse(sampleEntity);
        return ApiResponse.success(sampleResponse);
    }

}