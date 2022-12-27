package com.example.chatapp.utils;

public enum Menu {
    Chat1Global("POS Dashboard......Chat1Global"),
    Chat2("Tiny POS"),
    Chat3("Sales History"),
    Category("Category Management"),
    Product("Products Management");

    private  String title;

    Menu(String title) {
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public String getFxml(){
        return String.format("%s.fxml",name());
    }
}
