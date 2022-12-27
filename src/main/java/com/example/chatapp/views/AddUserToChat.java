package com.example.chatapp.views;


import com.example.chatapp.ChatApplication;
import com.example.chatapp.model.ChatException;
import com.example.chatapp.model.entity.User;
import com.example.chatapp.model.repo.UserRepo;
import com.example.chatapp.model.service.LoginService;
import com.example.chatapp.model.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AddUserToChat extends AbstractController {


    @FXML
    private HBox item;

    @FXML
    private Button cancelBtn;

    @FXML
    private VBox vContainer;

    @Autowired
    private UserService userService;



   public static void showView(){
       try {
           System.out.println("loginUser");
           Stage stage = new Stage(StageStyle.UNDECORATED);
           stage.initModality(Modality.APPLICATION_MODAL);
           FXMLLoader loader = new FXMLLoader(ChatApplication.class.getResource("AddUserToChat.fxml"));
           stage.setScene(new Scene(loader.load()));
           stage.show();
       }catch (Exception e){
           e.printStackTrace();
       }
   }


    @FXML
    private void initialize(){
        vContainer.getChildren().clear();
        vContainer.getChildren().add(new ItemAddUserToChat());
        System.out.println("initialized");
//        userService.findAll().stream().forEach(user -> vContainer.getChildren().add(new ItemAddUserToChat(user)));

    }

    public void itemClicked(MouseEvent mouseEvent) {
    }

    public void cancel(ActionEvent actionEvent) {
        cancelBtn.getScene().getWindow().hide();
    }

    public void add(ActionEvent actionEvent) {
    }

    private class ItemAddUserToChat extends HBox{
        private User user;
        public ItemAddUserToChat(){
            //        public ItemAddUserToChat(User user){
                    Label name = new Label();
                name.setText("Anuki Anuki");
                getChildren().addAll(name);
                getStyleClass().add("item");
            }
        }
}
