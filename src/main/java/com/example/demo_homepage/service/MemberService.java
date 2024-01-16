package com.example.demo_homepage.service;

import com.example.demo_homepage.domain.entity.MemberEntity;
import com.example.demo_homepage.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    public MemberRepository memberRepository;

    public MemberEntity saveMember(MemberEntity memberEntity) {
        return memberRepository.save(memberEntity);
    }
}
