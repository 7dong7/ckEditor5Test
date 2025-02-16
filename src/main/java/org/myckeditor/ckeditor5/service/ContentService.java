package org.myckeditor.ckeditor5.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.myckeditor.ckeditor5.dto.SaveDTO;
import org.myckeditor.ckeditor5.entity.ContentEntity;
import org.myckeditor.ckeditor5.repository.ContentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public List<ContentEntity> selectContent() {
        return contentRepository.findAll();
    }

    public ContentEntity selectOneContent(Integer contentId) {
        return contentRepository.findById(contentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
    }

    @Transactional
    public void deleteOneContent(Integer contentId) {
        contentRepository.deleteById(contentId);
    }

    @Transactional
    public void updateOneContent(SaveDTO saveDTO, Integer contentId) {

        ContentEntity content1 = new ContentEntity();
        content1.setId(contentId);
        content1.setTitle(saveDTO.getTitle());
        content1.setContent(saveDTO.getContent());

        contentRepository.save(content1);
    }

}
