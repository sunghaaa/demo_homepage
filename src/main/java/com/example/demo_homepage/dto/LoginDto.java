package com.example.demo_homepage.dto;

import com.example.demo_homepage.domain.entity.MemberEntity;
import lombok.Builder;

public class LoginDto {

    public String member_id;
    public String member_password;

    @Builder
    public LoginDto(MemberEntity memberEntity) {
        this.member_id = memberEntity.getMember_id();
        this.member_password = memberEntity.getMember_password();
    }
}
