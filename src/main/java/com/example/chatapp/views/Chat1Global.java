package com.example.chatapp.views;

import com.example.chatapp.model.entity.User;
import com.example.chatapp.model.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.SVGPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.function.Consumer;

@Controller
public class Chat1Global extends AbstractController{
    @FXML
    private VBox dContainer;
    @FXML
private VBox vContainer;

@FXML
private Button addBtn;

@FXML
private Button deleteBtn;

@FXML
private Label detailsLabel;

    @FXML
    private Label detailsLabel1;


@Autowired
    private UserService userService;

private User selectedUser;



private String currentChat="chat1";

    @FXML
    private void initialize(){
        vContainer.getChildren().clear();
        userService.findNotChatUsersList(currentChat).stream()
                .forEach(user-> vContainer.getChildren().add(new UserInChat(user)));
        userService.findChatUsersList(currentChat).stream()
                .forEach(user-> dContainer.getChildren().add(new UserInChat(user)));
    }

    public void addToChat() {
        System.out.println("add button function \""+ selectedUser.getName()+"\" adding");
        System.out.println(selectedUser.getName());
        System.out.println(selectedUser.getUsername());
        System.out.println(selectedUser.getRole());
//        selectedUser.setChat1(true);
        userService.updateUserChat(selectedUser.getUsername(),currentChat);

    }
    public void deleteFromChat() {
        System.out.println("delete button function");
        userService.removeUserFromChat(selectedUser.getUsername(),currentChat);
    }

    private void reload(){
        vContainer.getChildren().clear();
        userService.findNotChatUsersList(currentChat).stream()
                .forEach(user-> vContainer.getChildren().add(new UserInChat(user)));
    }
//    private void addUserToChat(User user){
//
//    }
//


    private class UserInChat extends HBox {
        private User user;
        public UserInChat(User user){
            SVGPath icon =new SVGPath();
            icon.setContent("M30.5 0h-12c-0.825 0-1.977 0.477-2.561 1.061l-14.879 14.879c-0.583 0.583-0.583 1.538 0 2.121l12.879 12.879c0.583 0.583 1.538 0.583 2.121 0l14.879-14.879c0.583-0.583 1.061-1.736 1.061-2.561v-12c0-0.825-0.675-1.5-1.5-1.5zM23 12c-1.657 0-3-1.343-3-3s1.343-3 3-3 3 1.343 3 3-1.343 3-3 3z");
            Label name=new Label();
            name.setText(user.getName());
            System.out.println(user.getName());
            getChildren().addAll(icon,name);
            getStyleClass().add("category-item");

            setOnMouseClicked(event-> {
                System.out.println("clicked");
                if(event.getClickCount()==1){
                    System.out.println("Selected user:"+ user.getName());
                    System.out.println("he assigned to chat1 :"+ user.isChat1());
                    detailsLabel.setText(user.getName());
                    detailsLabel1.setText(String.valueOf(user.isChat2()));
                    selectedUser=user;
                }
            });

        }
    }





}
