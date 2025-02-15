package org.myckeditor.ckeditor5.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.myckeditor.ckeditor5.dto.SaveDTO;
import org.myckeditor.ckeditor5.entity.ContentEntity;
import org.myckeditor.ckeditor5.repository.ContentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class ContentService {

    private final ContentRepository contentRepository;

    // 게시글 저장 메소드
    @Transactional
    public void saveContent(SaveDTO saveDTO) {
        String title = saveDTO.getTitle();
        String content = saveDTO.getContent();

        ContentEntity content1 = new ContentEntity();

        content1.setTitle(title);
        content1.setContent(content);

        contentRepository.save(content1);
    }


}
