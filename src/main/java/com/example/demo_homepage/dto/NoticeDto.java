package com.example.demo_homepage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoticeDto {

    public Long created_number;
    public String detail_title;
    public String member_id;
    public String detail_content;
    public String category;
    public LocalDate created_date;

    @Builder
    public NoticeDto(String detail_title, String member_id, String detail_content, String category, LocalDate created_date) {
        this.detail_title = detail_title;
        this.member_id = member_id;
        this.detail_content = detail_content;
        this.category = category;
        this.created_date = created_date;
    }
}
