package com.ty.blog.domain.request;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;

public record PostSaveRequest(
        @NotBlank Long authorId,
        @NotBlank String title,
        @NotBlank String metaTitle,
        @NotBlank String slug,
        @NotBlank String summary,
        @NotBlank Boolean published,
        String parentId,
        String content,
        HashSet<Long> tagId,
        HashSet<Long> categoryId
) {
}
