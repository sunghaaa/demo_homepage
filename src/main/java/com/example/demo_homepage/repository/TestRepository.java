package com.example.demo_homepage.repository;

import com.example.demo_homepage.domain.entity.TestEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public TestRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Long save(TestEntity testEntity){
        entityManager.persist(testEntity);
        return testEntity.getId();
    }

    public TestEntity find(Long id){
        return entityManager.find(TestEntity.class, id);
    }

}
