package com.ty.blog.domain.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ty.blog.domain.entity.Category;
import com.ty.blog.domain.entity.Tag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonSerialize
@AllArgsConstructor
public class PostDataResponse {
    private Long id;
    private Long authorId;
    private String MyParentId;
    private String parentId;
    private String title;
    private String metaTitle;
    private String slug;
    private String summary;
    private Boolean published;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime publishedAt;
    private String content;
    private List<Category> categories;
    private List<Tag> tags;
}
