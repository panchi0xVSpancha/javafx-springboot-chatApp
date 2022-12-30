package com.example.chatapp.model.service;

import com.example.chatapp.model.ChatException;
import com.example.chatapp.model.entity.User;
import com.example.chatapp.model.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LoginService {
    @Autowired
    private UserRepo repo;
    public User login(String username) throws ChatException {

        if(StringUtils.isEmpty(username)){
            throw new ChatException("Please enter Login Id.");
        }
        User account = repo.findByUsername(username)
                .orElseThrow(()->new ChatException("Please check your Login Id"));

        return account;
    }

}
