package com.example.demo_homepage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {


    @GetMapping("/notice")
    public String notice() {
        return "notice";
    }

    @GetMapping("/slide")
    public String slide() {
        return "slide";
    }

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


}
