package com.ty.blog.domain.request;

import javax.validation.constraints.NotBlank;

public record CategoryDataRequest(
        @NotBlank String title,
        @NotBlank String metaTitle,
        @NotBlank String slug,
        @NotBlank String content,
        @NotBlank Long postId,
                  String parentId
) {
}
