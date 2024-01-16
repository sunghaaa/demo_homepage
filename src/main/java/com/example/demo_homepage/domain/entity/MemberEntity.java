package com.example.demo_homepage.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
@Table(name = "member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_number")
    public Long member_number;

    @Column(name = "member_type")
    private String member_type;

    @Column(name = "member_id")
    private String member_id;

    @Column(name = "member_password")
    private String member_password;

    @Column(name = "member_email")
    private String member_email;

    @Column(name = "member_phone_number")
    private String member_phone_number;

    @Column(name = "member_birthday")
    private String member_birthday;

    @Column(name = "zip_code")
    private String zip_code;

    @Column(name = "first_address")
    private String first_address;

    @Column(name = "second_address")
    private String second_address;

}
