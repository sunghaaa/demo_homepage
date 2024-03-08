package com.example.demo_homepage.service;

import com.example.demo_homepage.dto.NoticeDto;
import com.example.demo_homepage.entity.NoticeEntity;
import com.example.demo_homepage.repository.NoticeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Page<NoticeEntity> pageTest(Pageable pageable){
        return noticeRepository.findAll(pageable);
    }

    public Page<NoticeDto> paging(Pageable pageable){
        int page = pageable.getPageNumber() -1;
        int pageLimit = 10;

        Page<NoticeEntity> noticeEntities =
                noticeRepository.findAll(PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.DESC, "createdNumber")));
        Page<NoticeDto> noticeDtos = noticeEntities.map(noticeEntity -> NoticeDto.builder()
                //번호 분류 제목 이름 작성일
                .createdNumber(noticeEntity.getCreatedNumber())
                .category(noticeEntity.getCategory())
                .detailTitle(noticeEntity.getDetailTitle())
                .memberId(noticeEntity.getMemberId())
                .createdDate(noticeEntity.getCreatedDate())
                .build());

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
