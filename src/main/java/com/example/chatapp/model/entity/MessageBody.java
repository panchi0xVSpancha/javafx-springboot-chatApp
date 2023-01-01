package com.example.chatapp.model.entity;

import lombok.Data;


@Data

public class MessageBody {

    private String message;
    private String sender;
    private Type type;
    private Group group;
    private String time;


    public enum Group{
        general , chat1 , chat2
    }

    public enum Type{
        normal , special
    }



}
