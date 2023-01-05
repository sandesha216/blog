package com.ty.blog.helper;

import com.ty.blog.domain.entity.Tag;
import com.ty.blog.domain.request.TagDataRequest;

public class TagHelper {

    public static Tag TagEntityConverter(TagDataRequest request) {
        Tag tag = new Tag();
        tag.setContent(request.content());
        tag.setSlug(request.slug());
        tag.setTitle(request.title());
        tag.setMetaTitle(request.metaTitle());
        return tag;
    }
}
