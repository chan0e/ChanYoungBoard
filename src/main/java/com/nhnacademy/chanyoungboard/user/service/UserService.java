package com.nhnacademy.chanyoungboard.user.service;


import com.nhnacademy.chanyoungboard.pagenation.Page;
import com.nhnacademy.chanyoungboard.user.domain.User;
import com.nhnacademy.chanyoungboard.user.repositroy.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {
    private  final UserRepository userRepository;


    public User getUser(String id){
        User user = userRepository.getUser(id);
        if(Objects.isNull(user)){
            throw new RuntimeException();
        }

        return user;
    }

    public Page<User> getUserList(int page, int size){
        return userRepository.getPagedList(page, size);
    }


}
