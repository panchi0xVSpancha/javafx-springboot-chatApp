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

    public enum Role{
        Admin, GeneralUser
    }

//    @Override
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
