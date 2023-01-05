package com.ty.blog.service.impl;

import com.ty.blog.domain.entity.Post;
import com.ty.blog.domain.entity.Tag;
import com.ty.blog.domain.request.TagDataRequest;
import com.ty.blog.helper.TagHelper;
import com.ty.blog.repository.PostRepository;
import com.ty.blog.repository.TagRepository;
import com.ty.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private PostRepository postRepository;
    @Override
    public void saveTagData(TagDataRequest request) {
            Tag tag = TagHelper.TagEntityConverter(request);
            tagRepository.save(tag);
    }
}
