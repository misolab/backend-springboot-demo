package com.example.demo.sample;

import java.util.List;

public interface SampleService {

    Long saveSample(String name, String email, Integer age);

    SampleEntity getSample(Long id);

    List<SampleEntity> list();

}
