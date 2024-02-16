package com.example.demo_homepage.controller;

import com.example.demo_homepage.dto.NoticeDto;
import com.example.demo_homepage.repository.NoticeRepository;
import com.example.demo_homepage.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NoticeController {

    private final NoticeRepository noticeRepository;
    private final NoticeService noticeService;

    private NoticeController(NoticeRepository noticeRepository, NoticeService noticeService) {
        this.noticeService = noticeService;
        this.noticeRepository = noticeRepository;
    }

    @GetMapping("/notice")
    public String noticeList(Model model) {
        List<NoticeDto> noticeList = noticeService.findAllDesc();
        model.addAttribute("noticeList", noticeList);
        return "notice";
    }

    @GetMapping("/detailPageWrite")
    public String populateList(Model model) {
        List<String> categories = new ArrayList<>();
        categories.add("소식");
        categories.add("뉴스");
        categories.add("이벤트");
        categories.add("발표");
        model.addAttribute("noticeDto", new NoticeDto());
        model.addAttribute("category", categories);
        return "detailPageWrite";

    }

    @PostMapping("/detailPageWrite")
    public String detailPagePost(NoticeDto noticeDto) {
        noticeService.saveNoticePost(noticeDto);
        return "redirect:/notice";
    }

    @GetMapping("/detailPageView")
    public String detailPageView(Model model, @RequestParam Long created_number) {
        model.addAttribute("detailPageView", noticeRepository.findById(created_number).orElse(null));
        System.out.println(created_number + "::::상세페이지_글번호");
        return "detailPageView";
    }
}
