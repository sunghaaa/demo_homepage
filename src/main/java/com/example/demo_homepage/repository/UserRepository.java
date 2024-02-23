package com.example.demo_homepage.repository;

import com.example.demo_homepage.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<TestEntity, Long> {

    Optional<TestEntity> findById(Long id);

}
