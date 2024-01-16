package com.example.demo_homepage.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberDto {

    public Long member_number;
    public String member_type;
    public String member_id;
    public String member_password;
    public String member_email;
    public Long member_phone_number;
    public Long member_birthday;
    public Long zip_code;
    public String first_address;
    public String second_address;
}
