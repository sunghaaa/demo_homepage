package com.example.demo_homepage.controller;

import com.example.demo_homepage.category.NoticeCategory;
import com.example.demo_homepage.domain.entity.NoticeEntity;
import com.example.demo_homepage.dto.NoticeDto;
import com.example.demo_homepage.repository.NoticeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NoticeController {

    public NoticeRepository noticeRepository;

    public NoticeController(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @GetMapping("/notice")
    public String findNoticeList(Model model) {
        model.addAttribute("noticeList", noticeRepository.findAll());
        return "notice";
    }

    @GetMapping("/detailPageWrite")
    public String detailPageWrite(Model model) {
        model.addAttribute("noticeEntity", new NoticeDto());
        return "detailPageWrite";
    }

    @ModelAttribute("category")
    public NoticeCategory[] noticeCategories() {
        return NoticeCategory.values();
    }

    @PostMapping("/detailPageWrite")
    public String detailPagePost(Model model, @ModelAttribute NoticeEntity noticeEntity) {
        model.addAttribute("noticeEntity", noticeEntity);
        noticeRepository.save(noticeEntity);
        return "redirect:/notice";
    }

    @ModelAttribute("category")
    public String test(Model model, @ModelAttribute NoticeEntity noticeEntity) {
        model.addAttribute("noticeEntity", noticeEntity);
        noticeRepository.save(noticeEntity);
        return "redirect:/notice";

    }

    @GetMapping("/detailPageView")
    public String detailPageView(Model model, @RequestParam Long created_number) {
        model.addAttribute("detailPageView", noticeRepository.findById(created_number).orElse(null));
        System.out.println(created_number + "::::상세페이지_글번호");
        return "detailPageView";
    }

    @GetMapping("/deleteDetailPage")
    public String deletePage(@ModelAttribute NoticeEntity noticeEntity, Model model) {
        model.addAttribute("noticeEntity", noticeEntity);
        noticeRepository.delete(noticeEntity);
        return "redirect:/notice";
    }
}
