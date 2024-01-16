package com.example.demo_homepage.category;

import lombok.Getter;

@Getter
public enum NoticeCategory {
    //소식 출시 이벤트 발표

    NEWS("소식"),
    RELEASE("출시"),
    EVENT("이벤트"),
    ANNOUNCEMENT("발표");

    private final String value;

    NoticeCategory(String value) {
        this.value = value;
    }
}
