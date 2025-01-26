package com.example.demo.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService {

    @Autowired
    private SampleRepository sampleRepository;

    @Override
    public Long saveSample(String name, String email, Integer age) {
        SampleEntity sampleEntity = new SampleEntity();
        sampleEntity.setName(name);
        sampleEntity.setEmail(email);
        sampleEntity.setAge(age);
        return sampleRepository.save(sampleEntity).getId();
    }

    @Override
    public SampleEntity getSample(Long id) {
        return sampleRepository.getReferenceById(id);
    }

    @Override
    public List<SampleEntity> list() {
        return sampleRepository.findAll();
    }
}
