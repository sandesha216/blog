package com.ty.blog.domain.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@JsonSerialize
public class UserDataResponse {
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobile;
    private String email;
    private LocalDateTime registeredAt;
    private LocalDateTime lastLogin;
    private String intro;
    private String profile;
}
