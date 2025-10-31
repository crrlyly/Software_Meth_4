package com.example.software_meth_4.controllers;

import com.example.software_meth_4.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainController {

    // to switch views do Main.switchRoot("donutView.fxml");

    @FXML private AnchorPane donutContainer;
    @FXML private AnchorPane sandwichContainer;
    @FXML private AnchorPane coffeeContainer;
    @FXML private AnchorPane ordersPlacedContainer;
    @FXML private AnchorPane currentOrderContainer;

    public void initialize(){
    }

    //Page switching
    @FXML
    private void onDonutContainerClick() throws IOException {
        Main.switchRoot("donut-view.fxml");
    }
    @FXML
    private void onSandwichContainerClick() throws IOException {
        Main.switchRoot("sandwich-view.fxml");
    }
    @FXML
    private void onCoffeeContainerClick() throws IOException {
        Main.switchRoot("coffee-view.fxml");
    }
    @FXML
    private void onCurrentOrdersContainerClick() throws IOException {
        Main.switchRoot("current-orders-view.fxml");
    }
    @FXML
    private void onOrdersPlacedContainerClick() throws IOException {
        Main.switchRoot("orders-placed-view.fxml");
    }
}
