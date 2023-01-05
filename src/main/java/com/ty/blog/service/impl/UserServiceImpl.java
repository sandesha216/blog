package com.ty.blog.service.impl;

import com.ty.blog.domain.entity.User;
import com.ty.blog.domain.request.UserDataRequest;
import com.ty.blog.domain.response.UserDataResponse;
import com.ty.blog.helper.UserHelper;
import com.ty.blog.repository.UserRepository;
import com.ty.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

import static com.ty.blog.constant.ErrorMassage.EXCEPTION_WHILE_RETRIEVING_THE_USER_DETAILS;
import static com.ty.blog.constant.ErrorMassage.USER_ALREADY_PRESENT_EXCEPTION;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDataResponse getUserByEmail(String email) throws Exception {
        Optional<User> user;
        try {
            user = userRepository.findByEmail(email);
        } catch (Exception e) {
            throw new Exception(EXCEPTION_WHILE_RETRIEVING_THE_USER_DETAILS);
        }
        return user.isPresent() == true ? UserHelper.UserResponseConverter(user.get()) : null;
    }

    @Override
    public UserDataResponse saveUserData(UserDataRequest request) throws Exception {
       boolean isPresent = userDedupe(request.email());
       if (!isPresent) {
           User user = userRepository.save(UserHelper.UserEntityConverter(request));
           return UserHelper.UserResponseConverter(user);
       } else {
           throw new Exception(USER_ALREADY_PRESENT_EXCEPTION);
       }
    }

    private boolean userDedupe(String email) {
        boolean isPresent = Boolean.FALSE;
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()) {
            isPresent = Boolean.TRUE;
        }
        return isPresent;
    }
}
