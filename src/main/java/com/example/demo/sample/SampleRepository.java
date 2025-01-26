package com.example.demo.sample;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<SampleEntity, Long> {
    Optional<SampleEntity> findByEmail(String email);
}
