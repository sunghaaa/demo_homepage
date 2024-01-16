package com.example.demo_homepage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/sidebar")
    public String sidebar() {
        return "sidebar";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/newMember")
    public String newMemberGet(){
        return "newMember";
    }

    @GetMapping("/account")
    public String selectUser(){
        return "account";
    }

}
