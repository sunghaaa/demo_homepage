package com.example.demo_homepage.service;

import com.example.demo_homepage.dto.NoticeDto;
import com.example.demo_homepage.entity.NoticeEntity;
import com.example.demo_homepage.repository.NoticeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public void saveNoticePost(NoticeDto noticeDto) {
        noticeRepository.save(noticeDto.toEntity());
    }

    public List<NoticeDto> findAllDesc() {
        List<NoticeEntity> noticeEntities = noticeRepository.findAllDesc();
        List<NoticeDto> noticeDtos = noticeEntities.stream()
                .map(NoticeEntity::toDto)
                .collect(Collectors.toList());

        return noticeDtos;
    }

    public NoticeDto findById(Long createdNumber) {
        NoticeEntity noticeEntity = noticeRepository.findById(createdNumber).get();

        return NoticeDto.builder()
                .createdNumber(noticeEntity.getCreatedNumber())
                .memberId(noticeEntity.getMemberId())
                .detailTitle(noticeEntity.getDetailTitle())
                .detailContent(noticeEntity.getDetailContent())
                .category(noticeEntity.getCategory())
                .createdDate(noticeEntity.getCreatedDate())
                .build();
    }

    public void deleteNoticePost(Long createdNumber) {
        noticeRepository.deleteById(createdNumber);
    }

}
