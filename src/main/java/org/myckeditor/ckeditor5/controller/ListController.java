package org.myckeditor.ckeditor5.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.myckeditor.ckeditor5.entity.ContentEntity;
import org.myckeditor.ckeditor5.service.ContentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ListController {

    private final ContentService contentService;

    @GetMapping("/list")
    public String listPage(Model model) {

        List<ContentEntity> contentEntities = contentService.selectContent();

        model.addAttribute("ContentList", contentEntities);
        return "list";
    }

}
