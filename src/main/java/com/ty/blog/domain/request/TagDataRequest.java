package com.ty.blog.domain.request;

import javax.validation.constraints.NotBlank;

public record TagDataRequest(
        @NotBlank String title,
        @NotBlank String metaTitle,
        @NotBlank String slug,
        @NotBlank String content
) {
}
