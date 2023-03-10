package com.example.chatapp.model.service;

import com.example.chatapp.model.entity.*;
import com.example.chatapp.model.repo.Chat1MessageRepo;
import com.example.chatapp.model.repo.Chat2MessageRepo;
import com.example.chatapp.model.repo.GeneralMessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private GeneralMessageRepo generalMessageRepo;
    @Autowired
    private Chat1MessageRepo chat1MessageRepo;
    @Autowired
    private Chat2MessageRepo chat2MessageRepo;


    public void sendMessage(MessageBody messageBody){
        if(messageBody.getGroup().equals(MessageBody.Group.general)){
            GeneralMessage message = new GeneralMessage();
            message.setMessage(messageBody.getMessage());
            message.setType(messageBody.getType());
            message.setGroup(messageBody.getGroup());
            message.setSender(messageBody.getSender());
            generalMessageRepo.save(message);
        }else if(messageBody.getGroup().equals(MessageBody.Group.chat1)) {
            Chat1Message message =new Chat1Message();
            message.setMessage(messageBody.getMessage());
            message.setType(messageBody.getType());
            message.setGroup(messageBody.getGroup());
            message.setSender(messageBody.getSender());
            chat1MessageRepo.save(message);
        }else if(messageBody.getGroup().equals(MessageBody.Group.chat2)){
            Chat2Message message =new Chat2Message();
            message.setMessage(messageBody.getMessage());
            message.setType(messageBody.getType());
            message.setGroup(messageBody.getGroup());
            message.setSender(messageBody.getSender());
            chat2MessageRepo.save(message);
        }

//        change here


//        change here with logic
    }

    public List getMessages(MessageBody.Group group){

        if(group.equals(MessageBody.Group.general)){
            List<GeneralMessage> messages = generalMessageRepo.findAll();
            return messages;

        }else if(group.equals(MessageBody.Group.chat1)) {
            List<Chat1Message> messages = chat1MessageRepo.findAll();
            return messages;

        }else if(group.equals(MessageBody.Group.chat2)){
            List<Chat2Message> messages = chat2MessageRepo.findAll();
            return messages;
        }else {
            List list = new ArrayList<>();
            return list;
        }
    }

    public String getLastMessageChat1(){
         Optional<Chat1Message> message =chat1MessageRepo.findFirstByOrderByCreatedTimeDesc();
         if(message.isPresent()){
             return message.get().getMessage();
         }else {
             return "";
         }
    }

    public String func(){
        return "message service calling";
    }




}
