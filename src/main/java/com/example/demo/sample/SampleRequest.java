package com.example.demo.sample;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "샘플 요청")
public class SampleRequest {

    @Schema(description = "이름", example = "홍길동")
    @NotBlank(message = "이름은 필수 입력값입니다")
    @Size(min = 2, max = 10, message = "이름은 2자 이상 10자 이하로 입력해주세요")
    private String name;

    @Schema(description = "이메일", example = "test@example.com")
    @jakarta.validation.constraints.Email(message = "올바른 이메일 형식이 아닙니다")
    private String email;

    @Schema(description = "나이", example = "20")
    @jakarta.validation.constraints.Min(value = 0, message = "나이는 0보다 작을 수 없습니다")
    @jakarta.validation.constraints.Max(value = 150, message = "나이는 150보다 클 수 없습니다")
    private Integer age;
}
