package com.example.chatapp.views;

import com.example.chatapp.ChatApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.stereotype.Controller;

@Controller
public class Chat2 extends AbstractController{



    @FXML
    public void addUserToChat() {
        AddUserToChat.showView();
    }




}
