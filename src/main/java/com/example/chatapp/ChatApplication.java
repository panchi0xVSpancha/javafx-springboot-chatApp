package com.example.chatapp;

import javafx.application.Application;
import javafx.stage.Stage;
import com.example.chatapp.views.Login;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class ChatApplication extends Application{
    private static ConfigurableApplicationContext applicationContext;

    @Override
    public void init() throws Exception {
        this.applicationContext= SpringApplication.run(ChatApplication.class);
    }

    @Override
    public void stop() throws Exception {
        applicationContext.close();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Login.loadView(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static ConfigurableApplicationContext getApplicationContext() {
        return applicationContext;
    }
}