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

//    public User login(String loginId, String password) throws ChatException {
    public User login(String loginId) throws ChatException {

        if(StringUtils.isEmpty(loginId)){
            throw new ChatException("Please enter Login Id.");
        }

//        if(StringUtils.isEmpty(password)){
//            throw new ChatException("Please enter Password.");
//        }
        User account = repo.findById(loginId)
                .orElseThrow(()->new ChatException("Please check your Login Id"));

//        if(!password.equals(account.getPassword())){
//            throw new ChatException("Please check your password.");
//        }

        return account;
    }

}
