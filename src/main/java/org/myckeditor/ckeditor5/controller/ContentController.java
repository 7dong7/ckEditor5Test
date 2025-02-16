package org.myckeditor.ckeditor5.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.myckeditor.ckeditor5.entity.ContentEntity;
import org.myckeditor.ckeditor5.service.ContentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ContentController {

    private final ContentService contentService;

    @GetMapping("/content/{id}")
    public String contentPage(@PathVariable("id") Integer contentId,
                              Model model) {
        log.info("contentId : {}", contentId);

        ContentEntity content = contentService.selectOneContent(contentId);
        model.addAttribute("Content", content);
        return "content";
    }

}
