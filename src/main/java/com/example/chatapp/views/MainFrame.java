package com.example.chatapp.views;

import com.example.chatapp.ChatApplication;
import com.example.chatapp.model.entity.User;
import com.example.chatapp.utils.Menu;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.chatapp.views.Login.getLoggedUser;

@Component
public class MainFrame  {

    @FXML
    private Label recentChatLabel1;
    @FXML
    private Label recentChatLabel2;
    @FXML
    private Label recentChatLabel3;
    @FXML
    private VBox Chat1Global;
    @FXML
    private VBox Chat2;
    @FXML
    private VBox Chat3;
    @FXML
    private VBox sideBar;
    @FXML
    private StackPane contentView;
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
//        @FXML
//    private void initialize(){
//        User user =getLoggedUser();
//            System.out.println(user);
//            if(!user.isChat1()){
//                Chat2.getChildren().clear();
//                Chat2.getStyleClass().add("side-bar-menu-no-styles");
//            }
//            if (!user.isChat2()){
//                Chat3.getChildren().clear();
//                Chat3.getStyleClass().add("side-bar-menu-no-styles");
//            }
//    }

}
