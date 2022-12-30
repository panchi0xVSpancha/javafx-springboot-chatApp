package com.example.chatapp.model.service;

import com.example.chatapp.model.ChatException;
import com.example.chatapp.model.entity.User;
import com.example.chatapp.model.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public String updateUserChat(String username,String chat){
        Optional<User> optionalUser = userRepo.findByUsername(username);
        if(optionalUser.isPresent()){
            if(chat.equals("chat1")){
                optionalUser.get().setChat1(true);
            }else{
                optionalUser.get().setChat2(true);
            }
            userRepo.save(optionalUser.get());
            return "Add user to chat Success!";

        }else {
            return "Add user to chat Unsuccess!";
        }

    }

    public String removeUserFromChat(String username, String chat) {
        Optional<User> optionalUser = userRepo.findByUsername(username);
        if(optionalUser.isPresent()){
            if(chat.equals("chat1")){
                optionalUser.get().setChat1(false);
            }else{
                optionalUser.get().setChat2(false);
            }
            userRepo.save(optionalUser.get());
            return "Remove user from chat Success!";

        }else {
            return "Remove user from chat Unsuccess!";
        }
    }


    public List<User> findChatUsersList(String chat){
        return userRepo.findChatUsersList(chat);
    }

    public List<User> findNotChatUsersList(String chat){
        return userRepo.findNotChatUsersList(chat);
    }

}
