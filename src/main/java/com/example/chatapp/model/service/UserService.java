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

    public User updateUserChat(User user, User.Chats chat){
        System.out.println("service got chat number :"+chat+ " to replace "+user.getChat());
        if (user.getChat()== User.Chats.c0 && (chat== User.Chats.c2|chat== User.Chats.c2)){
            user.setChat(chat);
            System.out.println("new value :"+chat);
        }else if((user.getChat()== User.Chats.c2 |user.getChat()== User.Chats.c2)) {
            user.setChat(User.Chats.c4);
            System.out.println("new value :"+User.Chats.c4);
        }else {
            user.setChat(User.Chats.c4);
            System.out.println("new value :"+User.Chats.c4);
        }
        return userRepo.save(user);
    }


}
