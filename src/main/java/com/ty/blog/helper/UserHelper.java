package com.ty.blog.helper;

import com.ty.blog.domain.entity.User;
import com.ty.blog.domain.request.UserDataRequest;
import com.ty.blog.domain.response.UserDataResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
public class UserHelper {

   private final static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static UserDataResponse UserResponseConverter(User user) {
        UserDataResponse response = new UserDataResponse();
        response.setEmail(user.getEmail());
        response.setMobile(user.getMobile());
        response.setIntro(user.getIntro());
        response.setProfile(user.getProfile());
        response.setLastLogin(user.getLastLogin());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setMiddleName(user.getMiddleName());
        response.setRegisteredAt(user.getRegisteredAt());
        return response;
    }

    public static User UserEntityConverter(UserDataRequest request) {
        User user = new User();
        user.setEmail(request.email());
        user.setIntro(request.intro());
        user.setMobile(request.mobile());
        user.setLastLogin(LocalDateTime.now());
        user.setProfile(request.profile());
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setMiddleName(request.middleName());
        user.setRegisteredAt(LocalDateTime.now());
        user.setPasswordHash(bCryptPasswordEncoder.encode(request.password()));
        return user;
    }
}
