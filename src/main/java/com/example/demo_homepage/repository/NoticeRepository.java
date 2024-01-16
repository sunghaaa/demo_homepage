package com.example.demo_homepage.repository;

import com.example.demo_homepage.domain.entity.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<NoticeEntity, Long> {
    List<NoticeEntity> findAll();
}
