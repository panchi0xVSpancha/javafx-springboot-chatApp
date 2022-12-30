package com.example.chatapp.views;

import com.example.chatapp.ChatApplication;
import com.example.chatapp.model.entity.User;
import com.example.chatapp.utils.Menu;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

@Component
public class MainFrame  {

    @FXML
    private VBox sideBar;
    @FXML
    private StackPane contentView;
    @FXML
    private VBox Chat1Global;
    public User loginUser=new User();

    public void show(User loginUser) {
        try {

            Stage stage = new Stage();
            Parent root = FXMLLoader.load(ChatApplication.class.getResource("MainFrame.fxml"));
            stage.setScene((new Scene(root)));
            this.loginUser=loginUser;
            stage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void clickMenu(MouseEvent mouseEvent) {
        try{
            Node node =(Node) mouseEvent.getSource();
            if(node.getId().equals("Exit")){
                sideBar.getScene().getWindow().hide();
            }else{
                Menu menu = Menu.valueOf(node.getId());
                contentView.getChildren().clear();
                FXMLLoader loader=new FXMLLoader((ChatApplication.class.getResource(menu.getFxml())));
                loader.setControllerFactory(ChatApplication.getApplicationContext()::getBean);
                Parent view=loader.load();
                contentView.getChildren().add(view);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public void getLoginUser(User loginUser){
        this.loginUser=loginUser;
    }

}
