package com.example.demo_homepage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String start() {
        return "main";
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/index")
    public String index(){
        return "main";
    }
}
