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
    private Long createdNumber;

    @Column(name = "detail_title", nullable = false)
    private String detailTitle;

    @Column(name = "member_id", nullable = false, updatable = false)
    private String memberId;

    @Column(name = "detail_content", nullable = false)
    private String detailContent;

    @Column(name = "category", nullable = false)
    private String category;

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDate createdDate;


    @Builder
    public NoticeEntity(Long createdNumber, String detailTitle, String memberId, String detailContent, String category, LocalDate createdDate) {
        this.createdNumber = createdNumber;
        this.detailTitle = detailTitle;
        this.memberId = memberId;
        this.detailContent = detailContent;
        this.category = category;
        this.createdDate = createdDate;
    }

    public NoticeDto toDto() {
        return NoticeDto.builder()
                .createdNumber(createdNumber)
                .detailTitle(detailTitle)
                .memberId(memberId)
                .detailContent(detailContent)
                .category(category)
                .createdDate(createdDate)
                .build();
    }
}