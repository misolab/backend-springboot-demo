package com.example.demo.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Schema(description = "API 응답")
public class ApiResponse<T> {

    @Schema(description = "성공 여부")
    private final boolean success;

    @Schema(description = "응답 메시지")
    private final String message;

    @Schema(description = "응답 데이터")
    private final T data;

    @Schema(description = "에러 코드")
    private final String errorCode;

    public static <T> ResponseEntity<ApiResponse<T>> success(T data) {
        ApiResponse<T> response = ApiResponse.<T>builder()
                .success(true)
                .message("Success")
                .data(data)
                .build();
        return ResponseEntity.ok(response);
    }

    public static <T> ResponseEntity<ApiResponse<T>> error(HttpStatus status, String message, String errorCode) {
        ApiResponse<T> response = ApiResponse.<T>builder()
                .success(false)
                .message(message)
                .errorCode(errorCode)
                .build();
        return ResponseEntity.status(status).body(response);
    }
}