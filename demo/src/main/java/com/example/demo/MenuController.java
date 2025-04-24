package com.example.demo;

import com.google.gson.Gson;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuController {
    @FXML
    private Button CreateButt;
    @FXML
    private Button ChangeButt;
    @FXML
    private Button DeleteButt;
    @FXML
    private Button OpenButt;
    @FXML
    private Button AnalysButt;
    @FXML
    private Button LoadButt;
    @FXML
    private ImageView CloseButt;
    @FXML
    private ListView<MainInfo> MainList;

    private ObservableList<MainInfo> MainInfoList;




    public void CreateNew() throws IOException {
        HelloApplication.CreateWindow();
    }
    public void Load(){
        Gson gson = new Gson();
        MainInfo mainInfo = new MainInfo();
        try (FileReader reader = new FileReader("data.json")) {
             mainInfo = gson.fromJson(reader, MainInfo.class); // Десериализация
            //System.out.println("Отчет " + mainInfo.getClientsInfo().);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MainInfoList = FXCollections.observableArrayList();

        MainInfoList.add(mainInfo);
        MainList.setItems(MainInfoList);
    }
    public void Change(){

    }
    public void Delate(){

    }
    public void Open(){

    }
    public void Close(){
        Stage stage = (Stage) CloseButt.getScene().getWindow();
        stage.close();
    }
    public void Analys(){

    }

}