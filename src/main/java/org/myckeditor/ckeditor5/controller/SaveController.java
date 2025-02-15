package org.myckeditor.ckeditor5.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.myckeditor.ckeditor5.dto.SaveDTO;
import org.myckeditor.ckeditor5.service.ContentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class SaveController {

    private final ContentService contentService;

    @PostMapping("/save")
    public String saveFunc(SaveDTO saveDTO) {
        log.info("dto: {}", saveDTO);

        contentService.saveContent(saveDTO);

        return "redirect:/";
    }
}
