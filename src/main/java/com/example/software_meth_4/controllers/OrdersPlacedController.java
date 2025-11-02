package com.example.software_meth_4.controllers;


import com.example.software_meth_4.Main;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;


public class OrdersPlacedController{

    @FXML private Button mainMenuBtn;

    public void initialize(){
    }

    @FXML
    private void onMainMenuBtnClick() throws IOException {
        Main.switchRoot("main-view.fxml");
    }
}
