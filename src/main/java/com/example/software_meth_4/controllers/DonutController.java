package com.example.software_meth_4.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class DonutController{

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
