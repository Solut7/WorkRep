package com.example.demo;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateController {
    @FXML
    private Button Count;
    @FXML
    private Button Save;
    @FXML
    private Button InitButt;
    @FXML
    private Button CloseButt;
    @FXML
    private TextField ClientsAmount;
    @FXML
    private TextField NewClients;
    @FXML
    private TextField LeftClients;
    @FXML
    private TextField ActiveClients;
    @FXML
    private TextField Visitors;
    @FXML
    private TextField Converted;
    @FXML
    private TextField Period;

    @FXML
    private TextField MarketingExp;
    @FXML
    private TextField SellExp;
    @FXML
    private TextField DevelopExp;
    @FXML
    private TextField ProtoExp;
    @FXML
    private TextField AllExp;

    @FXML
    private TextField SubInc;
    @FXML
    private TextField SellInc;
    @FXML
    private TextField InApp;
    @FXML
    private TextField AllInc;

    @FXML
    private TextField CAC;
    @FXML
    private TextField CR;
    @FXML
    private TextField RR;
    @FXML
    private TextField ConvR;
    @FXML
    private TextField ROI;
    @FXML
    private TextField ARPU;
    @FXML
    private TextField LTV;
    @FXML
    private TextField Name;

    private List<MainInfo> mainInfoList = new ArrayList<>();

    MainInfo mainInfo = new MainInfo();
    ClientsInfo clientsInfo = new ClientsInfo();
    ExpensesInfo expensesInfo = new ExpensesInfo();
    IncomeInfo incomeInfo = new IncomeInfo();


    public void Initialize(){

        clientsInfo.setCurrentAmountClients(Integer.valueOf(ClientsAmount.getText()));
        clientsInfo.setNewClientsNumber(Integer.valueOf(NewClients.getText()));
        clientsInfo.setLeftClientsNumber(Integer.valueOf(LeftClients.getText()));
        clientsInfo.setActiveClientsNumber(Integer.valueOf(ActiveClients.getText()));
        clientsInfo.setVisitors(Integer.valueOf(Visitors.getText()));
        clientsInfo.setConvertedUsers(Integer.valueOf(Converted.getText()));
        clientsInfo.setCustomerLifetime(Integer.valueOf(Period.getText()));
        mainInfo.setClientsInfo(clientsInfo);

        expensesInfo.setMarketingExpenses(Float.parseFloat(MarketingExp.getText()));
        expensesInfo.setSaleExpenses(Float.parseFloat(SellExp.getText()));
        expensesInfo.setDevelopExpenses(Float.parseFloat(DevelopExp.getText()));
        expensesInfo.setPrototypeExpenses(Float.parseFloat(ProtoExp.getText()));
        expensesInfo.setAllExpenses(Float.parseFloat(AllExp.getText()));
        mainInfo.setExpensesInfo(expensesInfo);

        incomeInfo.setSubInc(Float.parseFloat(SubInc.getText()));
        incomeInfo.setSellInc(Float.parseFloat(SellInc.getText()));
        incomeInfo.setInAPP(Float.parseFloat(InApp.getText()));
        incomeInfo.setAllIncome(Float.parseFloat(AllInc.getText()));
        mainInfo.setIncomeInfo(incomeInfo);

        mainInfo.setName(Name.getText());

        mainInfo.SetCR();
        mainInfo.SetConvR();
        mainInfo.SetARPU();
        mainInfo.SetCAC();
        mainInfo.SetRetR();
        mainInfo.SetLTV();
        mainInfo.SetRoI();
    }
    public void CountStuff(){
        CR.setText(String.valueOf(mainInfo.getCR()));
        ConvR.setText(String.valueOf(mainInfo.getConvR()));
        RR.setText(String.valueOf(mainInfo.getRetR()));
        CAC.setText(String.valueOf(mainInfo.getCac()));
        ROI.setText(String.valueOf(mainInfo.getROI()));
        ARPU.setText(String.valueOf(mainInfo.getARPU()));
        LTV.setText(String.valueOf(mainInfo.getLTV()));
    }
    public void SaveStuff() throws IOException {
                mainInfoList.add(mainInfo);
                saveToJson();

    }
    private void saveToJson() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("data.json")) {
            gson.toJson(mainInfo, writer); // Сериализация в файл
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Close(){
        Stage stage = (Stage) CloseButt.getScene().getWindow();
        stage.close();
    }

}