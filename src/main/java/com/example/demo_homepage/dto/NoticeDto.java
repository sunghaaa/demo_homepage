package com.example.demo_homepage.dto;

import com.example.demo_homepage.entity.NoticeEntity;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class NoticeDto {

    private Long created_number;
    private String detail_title;
    private String member_id;
    private String detail_content;
    private String category;
    private LocalDate created_date;

    @Builder
    public NoticeDto(Long created_number, String detail_title, String member_id, String detail_content, String category, LocalDate created_date) {
        this.created_number = created_number;
        this.detail_title = detail_title;
        this.member_id = member_id;
        this.detail_content = detail_content;
        this.category = category;
        this.created_date = created_date;
    }

    public NoticeEntity toEntity() {
        return NoticeEntity.builder()
                .created_number(created_number)
                .detail_title(detail_title)
                .member_id(member_id)
                .detail_content(detail_content)
                .category(category)
                .created_date(created_date)
                .build();
    }
}
