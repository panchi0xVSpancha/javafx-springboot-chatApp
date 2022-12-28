package com.example.chatapp.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    private String loginId;
    private String name;
    private Role role;

//    private String password;

//    private boolean chat1;
//    private boolean chat2;

    private Chats chat;
//    c0 <- No chat
//    c2 <- Chat 2
//    c3 <- Chat 3
//    c4 <- Chat 2, 3 both




    public enum Role{
        Admin, GeneralUser
    }

    public enum Chats{
        c0,c2,c3,c4
    }







    //    public String toString() {
//        return name;
//    }
//
//    public User() {
//    }
//
//    public User(String loginId) {
//        this.loginId = loginId;
//    }
}
