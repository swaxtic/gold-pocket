package com.simantri.simantribe.service.user;

import com.simantri.simantribe.model.response.UserLoginResponse;
import com.simantri.simantribe.model.request.UserLoginRequest;
import com.simantri.simantribe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserLoginService {

    @Autowired
    private UserRepository userRepository;

    public UserLoginResponse execute(UserLoginRequest request) {
        UserLoginResponse userLoginResponse = UserLoginResponse.builder().build();
        userRepository.getUserByAuth(request.getUsername(), request.getPassword()).ifPresentOrElse(data -> {
            userLoginResponse.setId(data.getId());
            userLoginResponse.setUsername(data.getUsername());
            userLoginResponse.setRole(data.getRole());
        }, ()-> {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized Access");
        });
        return userLoginResponse;
    }

}
