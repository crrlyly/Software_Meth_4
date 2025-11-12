package com.example.software_meth_4.controllers;

import com.example.software_meth_4.Main;
import javafx.fxml.FXML;
import java.io.IOException;

/**
 * This controller stores the methods for the main page.
 *
 * @author Carly Chick
 */
public class MainController {

    @FXML
    public void initialize(){

    }

    @FXML
    private void onDonutContainerClick() throws IOException {
//        Main.switchRoot("donut-view.fxml", "RU Cafe - Donuts");
        Main.goTo("/com/example/software_meth_4/donut-view.fxml", null, "RU Cafe - Donuts");

    }
    @FXML
    private void onSandwichContainerClick() throws IOException {
//        Main.switchRoot("sandwich-view.fxml", "RU Cafe - Sandwiches");
        Main.goTo("/com/example/software_meth_4/sandwich-view.fxml", null, "RU Cafe - Sandwiches");

    }
    @FXML
    private void onCoffeeContainerClick() throws IOException {
//        Main.switchRoot("coffee-view.fxml", "RU Cafe - Coffee");
        Main.goTo("/com/example/software_meth_4/coffee-view.fxml", null, "RU Cafe - Coffee");

    }
    @FXML
    private void onCurrentOrdersContainerClick() throws IOException {
//        Main.switchRoot("current-orders-view.fxml", "RU Cafe - Current Order");
        Main.goTo("/com/example/software_meth_4/current-orders-view.fxml", null, "RU Cafe - Current Order");

    }
    @FXML
    private void onOrdersPlacedContainerClick() throws IOException {
//        Main.switchRoot("orders-placed-view.fxml", "RU Cafe - Orders Placed");
        Main.goTo("/com/example/software_meth_4/orders-placed-view.fxml", null, "RU Cafe - Orders Placed");

    }
}
