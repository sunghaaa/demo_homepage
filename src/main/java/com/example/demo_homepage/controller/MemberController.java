package com.example.demo_homepage.controller;

import com.example.demo_homepage.domain.entity.MemberEntity;
import com.example.demo_homepage.dto.MemberDto;
import com.example.demo_homepage.repository.MemberRepository;
import com.example.demo_homepage.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemberController {
    public final MemberRepository memberRepository;
    public final MemberService memberService;

    public MemberController(MemberRepository memberRepository, MemberService memberService) {
        this.memberRepository = memberRepository;
        this.memberService = memberService;
    }

    @GetMapping("/signup")
    public String signupGet(Model model) {
        model.addAttribute("memberDto", new MemberDto());
        return "signup";
    }

    @PostMapping("/signup")
    public String signupPost(@ModelAttribute MemberEntity memberEntity, Model model) {
        model.addAttribute("memberDto", memberEntity);
        memberRepository.save(memberEntity);

        return "redirect:/newMember";
    }

    @GetMapping("/confirmMember")
    public String confirmMember(@ModelAttribute MemberEntity memberEntity, Model model) {
        model.addAttribute("memberDto", memberEntity);
        memberRepository.findAll();

        return "memberList";
    }

    @GetMapping("/login")
    public String loginGet(Model model) {
        model.addAttribute("loginDto", new MemberDto());
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@ModelAttribute MemberEntity memberEntity, Model model) {
        model.addAttribute("loginDto", memberEntity);
        return "main";
    }
}
