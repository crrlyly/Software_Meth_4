package com.example.software_meth_4.controllers;

import com.example.software_meth_4.Main;
import javafx.fxml.FXML;
import java.io.IOException;

/**
 * This controller stores the methods for the main page.
 *
 * @author Carly Chick, Alec Cotler
 */
public class MainController {

    /**
     * Initializes the main menu.
     */
    @FXML
    public void initialize(){

    }

    /**
     * Brings user to donut page
     *
     * @throws IOException throws error if fails
     */
    @FXML
    private void onDonutContainerClick() throws IOException {
        Main.goTo("/com/example/software_meth_4/donut-view.fxml", "RU Cafe - Donuts");

    }

    /**
     * Brings user to sandwich page
     *
     * @throws IOException throws error if fails
     */
    @FXML
    private void onSandwichContainerClick() throws IOException {
        Main.goTo("/com/example/software_meth_4/sandwich-view.fxml", "RU Cafe - Sandwiches");

    }

    /**
     * Brings user to coffee page
     *
     * @throws IOException throws error if fails
     */
    @FXML
    private void onCoffeeContainerClick() throws IOException {
        Main.goTo("/com/example/software_meth_4/coffee-view.fxml", "RU Cafe - Coffee");

    }

    /**
     * Brings user to current orders page
     *
     * @throws IOException throws error if fails
     */
    @FXML
    private void onCurrentOrdersContainerClick() throws IOException {
        Main.goTo("/com/example/software_meth_4/current-orders-view.fxml", "RU Cafe - Current Order");

    }

    /**
     * Brings user to orders placed page
     *
     * @throws IOException throws error if fails
     */
    @FXML
    private void onOrdersPlacedContainerClick() throws IOException {
        Main.goTo("/com/example/software_meth_4/orders-placed-view.fxml", "RU Cafe - Orders Placed");

    }
}
