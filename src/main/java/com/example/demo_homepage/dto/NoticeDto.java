package com.example.demo_homepage.dto;

import com.example.demo_homepage.entity.NoticeEntity;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class NoticeDto {

    private Long createdNumber;
    private String detailTitle;
    private String memberId;
    private String detailContent;
    private String category;
    private LocalDate createdDate;

    @Builder
    public NoticeDto(Long createdNumber, String detailTitle, String memberId, String detailContent, String category, LocalDate createdDate) {
        this.createdNumber = createdNumber;
        this.detailTitle = detailTitle;
        this.memberId = memberId;
        this.detailContent = detailContent;
        this.category = category;
        this.createdDate = createdDate;
    }

    public NoticeEntity toEntity() {
        return NoticeEntity.builder()
                .createdNumber(createdNumber)
                .detailTitle(detailTitle)
                .memberId(memberId)
                .detailContent(detailContent)
                .category(category)
                .createdDate(createdDate)
                .build();
    }
}
