package com.example.chatapp.controller;

import com.example.chatapp.model.entity.User;
import com.example.chatapp.model.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
@CrossOrigin

public class UserController {

    private UserService service;

    @GetMapping("/users")
    public List<User> getUser(){
        return service.findAll();
    }

    @PostMapping("/updateUserChat")
    @ResponseBody
    public String updateUserChat(@RequestParam("username") String username){
        return "update user :"+username;
//        return service.updateUserChat(username, chat);
    }
}
