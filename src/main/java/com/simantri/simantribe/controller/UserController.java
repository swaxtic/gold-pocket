package com.simantri.simantribe.controller;

import com.simantri.simantribe.model.response.RestResponse;
import com.simantri.simantribe.model.response.UserLoginResponse;
import com.simantri.simantribe.model.request.UserLoginRequest;
import com.simantri.simantribe.service.user.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserLoginService userLoginService;

    @PostMapping("/login")
    public RestResponse login (@RequestBody UserLoginRequest userLoginRequest) {
        UserLoginResponse userLoginResponse = userLoginService.execute(userLoginRequest);
        return new RestResponse(userLoginResponse, "Welcome to Simantri", true);
    }

}
