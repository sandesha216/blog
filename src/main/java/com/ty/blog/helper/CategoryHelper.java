package com.ty.blog.helper;

import com.ty.blog.domain.entity.Category;
import com.ty.blog.domain.entity.Tag;
import com.ty.blog.domain.request.CategoryDataRequest;
import com.ty.blog.domain.request.TagDataRequest;

public class CategoryHelper {

    public static Category categoryEntityConverter(CategoryDataRequest request) {
        Category category= new Category();
        category.setContent(request.content());
        category.setSlug(request.slug());
        category.setTitle(request.title());
        category.setMetaTitle(request.metaTitle());
        if(null != request.parentId()) {
            category.setParentId(request.parentId());
        }
        category.setMyParentId(PostHelper.setMyParentId());
        return category;
    }
}
