package com.example.demo_homepage.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "notice")
public class NoticeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "created_number", nullable = false)
    private Long created_number;

    @Column(name = "detail_title", nullable = false)
    private String detail_title;

    @Column(name = "member_id", nullable = false)
    private String member_id;

    @Column(name = "detail_content", nullable = false)
    private String detail_content;

    @Column(name = "category", nullable = false)
    private String category;

    @CreatedDate
    @Column(name = "created_date", nullable = false)
    private LocalDate created_date;

    @Builder
    public NoticeEntity(String detail_title, String member_id, String detail_content, String category, LocalDate created_date) {
        this.detail_title = detail_title;
        this.member_id = member_id;
        this.detail_content = detail_content;
        this.category = category;
        this.created_date = created_date;
    }

}
