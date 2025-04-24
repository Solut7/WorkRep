package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Log.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 360, 300);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    public static void Create() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("Menu.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load(),580,420);
        Stage stg = new Stage();
        stg.setTitle("Главная");
        stg.setScene(scene1);
        stg.show();
        //launch();
    }
    public static void CreateWindow() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("Create.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load(),580,420);
        Stage stg = new Stage();
        stg.setTitle("Создать");
        stg.setScene(scene1);
        stg.show();
        launch();
    }
    /*public static void ChangeWindow() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("Cr.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load(),580,420);
        Stage stg = new Stage();
        stg.setTitle("Изменить");
        stg.setScene(scene1);
        stg.show();
        launch();
    }*/
    public static void main(String[] args) {
        launch();
    }
}