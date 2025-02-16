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
public class EditorController {

    private final ContentService contentService;


    @GetMapping("/editor")
    public String editorPage() {
        return "editor";
    }

    @GetMapping("/editor/{id}")
    public String updatePage(@PathVariable("id") Integer contentId,
                             Model model) {
        ContentEntity contentEntity = contentService.selectOneContent(contentId);
        model.addAttribute("data", contentEntity);
        return "editor";
    }
}
