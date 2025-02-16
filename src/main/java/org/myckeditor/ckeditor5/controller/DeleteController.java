package org.myckeditor.ckeditor5.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.myckeditor.ckeditor5.service.ContentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Slf4j
@RequiredArgsConstructor
public class DeleteController {

    private final ContentService contentService;

    @GetMapping("/delete/{id}")
    public String deletePage(@PathVariable("id") Integer contentId) {

        contentService.deleteOneContent(contentId);

        return "redirect:/list";
    }
}
