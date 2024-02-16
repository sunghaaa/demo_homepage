package com.example.demo_homepage.entity;

import com.example.demo_homepage.dto.NoticeDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
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
    public NoticeEntity(Long created_number, String detail_title, String member_id, String detail_content, String category, LocalDate created_date) {
        this.created_number = created_number;
        this.detail_title = detail_title;
        this.member_id = member_id;
        this.detail_content = detail_content;
        this.category = category;
        this.created_date = created_date;
    }

    public NoticeDto toDto() {
        return NoticeDto.builder()
                .created_number(created_number)
                .detail_title(detail_title)
                .member_id(member_id)
                .detail_content(detail_content)
                .category(category)
                .created_date(created_date)
                .build();
    }
}