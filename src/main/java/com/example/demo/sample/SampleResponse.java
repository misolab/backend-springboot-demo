package com.example.demo.sample;

import lombok.Data;

@Data
public class SampleResponse {
    private String name;
    private String email;
    private Integer age;

    // 생성자
    public SampleResponse(SampleEntity sampleEntity) {
        this.name = sampleEntity.getName();
        this.email = sampleEntity.getEmail();
        this.age = sampleEntity.getAge();
    }
}
