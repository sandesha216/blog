package com.ty.blog.contraller;

import com.ty.blog.domain.request.UserDataRequest;
import com.ty.blog.domain.response.UserDataResponse;
import com.ty.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public UserDataResponse getUser(@RequestParam String email) throws Exception {
        return userService.getUserByEmail(email);
    }
    @PostMapping("/signup")
    public UserDataResponse signUp(@RequestBody UserDataRequest request) throws Exception {
        return userService.saveUserData(request);
    }
}
