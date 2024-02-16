package com.example.demo_homepage.service;

import com.example.demo_homepage.dto.NoticeDto;
import com.example.demo_homepage.entity.NoticeEntity;
import com.example.demo_homepage.repository.NoticeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public void saveNoticePost(NoticeDto noticeDto){
        noticeRepository.save(noticeDto.toEntity());
    }

    public List<NoticeDto> findAllDesc() {
        List<NoticeEntity> noticeEntities = noticeRepository.findAllDesc();
        List<NoticeDto> noticeDtos = new ArrayList<>();

        for (NoticeEntity noticeEntity : noticeEntities) {
            noticeDtos.add(noticeEntity.toDto());
        }

        return noticeDtos;
    }
}
