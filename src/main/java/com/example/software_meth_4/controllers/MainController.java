package com.example.software_meth_4.controllers;

import com.example.software_meth_4.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class MainController {

    // to switch views do Main.switchRoot("donutView.fxml");

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws IOException {
        Main.switchRoot("donut-view.fxml");
    }
}
