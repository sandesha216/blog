package com.ty.blog.service;

import com.ty.blog.domain.request.UserDataRequest;
import com.ty.blog.domain.response.UserDataResponse;

public interface UserService {
    UserDataResponse getUserByEmail(String email) throws Exception;
    UserDataResponse saveUserData(UserDataRequest email) throws Exception;
}
