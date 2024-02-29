package com.example.demo_homepage.repository;

import com.example.demo_homepage.entity.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<NoticeEntity, Long> {

    @Query(value = "select * from notice order by created_number desc", nativeQuery = true)
    List<NoticeEntity> findAllDesc();

}

