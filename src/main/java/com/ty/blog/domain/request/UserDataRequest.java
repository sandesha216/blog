package com.ty.blog.domain.request;

import javax.validation.constraints.NotBlank;

public record UserDataRequest(
       @NotBlank String firstName,
                 String middleName,
       @NotBlank String lastName,
       @NotBlank String mobile,
       @NotBlank String email,
       @NotBlank String intro,
       @NotBlank String profile,
       @NotBlank String password
) {
}
