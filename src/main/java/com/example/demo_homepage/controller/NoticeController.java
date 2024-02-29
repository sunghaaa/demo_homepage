package com.example.demo_homepage.controller;

import com.example.demo_homepage.dto.NoticeDto;
import com.example.demo_homepage.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NoticeController {

    private final NoticeService noticeService;

    private NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("/notice")
    public String noticeList(Model model) {
        List<NoticeDto> noticeList = noticeService.findAllDesc();
        model.addAttribute("noticeList", noticeList);
        return "notice";
    }

    @GetMapping("/detailPageWrite")
    public String detailPageWriteGet(Model model) {
        List<String> categories = new ArrayList<>();
        categories.add("소식");
        categories.add("뉴스");
        categories.add("이벤트");
        categories.add("발표");
        model.addAttribute("noticeDto", new NoticeDto());
        model.addAttribute("category", categories);

        return "detailPageWrite";
    }

    //게시글 저장
    @PostMapping("/detailPageWrite")
    public String saveNoticePost(NoticeDto noticeDto) {
        noticeService.saveNoticePost(noticeDto);
        //noticeService.savePost(noticeDto); //createdNumber
        return "redirect:/notice";
    }

    //상세 게시글 조회
    @GetMapping("/detailPageView/{createdNumber}")
    public String detailPageWriteView(Model model, @PathVariable("createdNumber") Long createdNumber) {
        List<String> categories = new ArrayList<>();
        categories.add("소식");
        categories.add("뉴스");
        categories.add("이벤트");
        categories.add("발표");
        model.addAttribute("category", categories);
        NoticeDto noticeDto = noticeService.findById(createdNumber);
        model.addAttribute("noticeDto", noticeDto);
        return "detailPageView";
    }

    //게시글 삭제
    @PostMapping("/detailPageView/{createdNumber}")
    public String deleteNoticePost(@PathVariable("createdNumber") Long createdNumber) {
        noticeService.deleteNoticePost(createdNumber);
        return "redirect:/notice";
    }

    @GetMapping("/detailPageView/edit/{createdNumber}")
    public String editGet(@PathVariable("createdNumber") Long createdNumber, Model model){
        NoticeDto noticeDto = noticeService.findById(createdNumber);
        model.addAttribute("category");
        model.addAttribute("noticeDto", noticeDto);
        return "edit";
    }

    @PostMapping("/detailPageView/edit/{createdNumber}")
    public String editPut(@PathVariable("createdNumber") Long createdNumber, NoticeDto editDto) {
        NoticeDto noticeDto = noticeService.findById(createdNumber);
        noticeDto.setCreatedNumber(editDto.getCreatedNumber());
        noticeDto.setDetailTitle(editDto.getDetailTitle());
        noticeDto.setMemberId(editDto.getMemberId());
        noticeDto.setDetailContent(editDto.getDetailContent());
        noticeDto.setCategory(editDto.getCategory());
        noticeDto.setCreatedDate(editDto.getCreatedDate());

        noticeService.saveNoticePost(noticeDto);
        return "redirect:/notice";
    }
}
