package com.example.chatapp.views;

import com.example.chatapp.ChatApplication;
import com.example.chatapp.model.entity.User;
import com.example.chatapp.model.service.UserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class Chat2 extends AbstractController{

    @FXML
    private StackPane contentView;
    @FXML
    private VBox addUserToChatBtn;

    @Autowired
    private UserService userService;

    @Autowired
    private AddUserToChat addUserToChat;
    private String currentChat="chat1";

    @FXML
    public void addUserToChat() {
        System.out.println("add user to list function");
        List<User> users =userService.findNotChatUsersList(currentChat);
        addUserToChat.showView(users);
    }






}
