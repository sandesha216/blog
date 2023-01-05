package com.ty.blog.contraller;

import com.ty.blog.domain.request.TagDataRequest;
import com.ty.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @PostMapping("/save")
    public void saveTag(@RequestBody TagDataRequest request) {
        tagService.saveTagData(request);
    }
}
