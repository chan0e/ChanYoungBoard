package com.nhnacademy.chanyoungboard.login.service;

import com.nhnacademy.chanyoungboard.user.domain.User;
import com.nhnacademy.chanyoungboard.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private  final UserService userService;

    public User doLogin(String id, String password){
        User user = userService.getUser(id);
        if(user.getId().equals(id) && user.getPassword().equals(password)){
            return user;
        }

        return null;
    }

}
