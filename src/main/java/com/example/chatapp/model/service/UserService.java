package com.example.chatapp.model.service;

import com.example.chatapp.model.entity.User;
import com.example.chatapp.model.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

//    public List<User> findAll(){
//        return userRepo.findAll();
//    }

    public List<User> findAll(){
        return userRepo.findAll();
    }


}
