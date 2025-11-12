package com.example.software_meth_4.controllers;

import com.example.software_meth_4.GlobalData;
import com.example.software_meth_4.Main;
import com.example.software_meth_4.rudonuts.*;
import com.example.software_meth_4.rudonuts.MenuItem;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import java.text.DecimalFormat;
import static com.example.software_meth_4.GlobalData.*;

/**
 * This controller stores the methods for the current orders page.
 *
 * @author Carly Chick
 */
public class CurrentOrdersController{

   @FXML private ListView<MenuItem> listView;
   @FXML private TextField subTotalTextField;
   @FXML private TextField salesTaxTextField;
   @FXML private TextField totalTextField;

    private final DecimalFormat df = new DecimalFormat("0.00");

    /**
     * Initializes the elements on the CurrentOrders page.
     */
    @FXML
    public void initialize(){
        listView.setItems(GlobalData.currentOrder);
        displayPrice();
    }

    /**
     * Switches the page to the main menu when button clicked.
     *
     * @throws IOException exception thrown if failed
     */
    @FXML
    private void onMainMenuBtnClick() throws IOException {
//        Main.switchRoot("main-view.fxml", "RU Cafe");
        Main.goTo("/com/example/software_meth_4/main-view.fxml", "RU Cafe");

    }

    /**
     * Displays the price of the items.
     */
    @FXML
    private void displayPrice(){
        double subTotal = 0;
        for(MenuItem item: currentOrder){
            subTotal = subTotal + item.price();
        }
        double salesTax = subTotal * 0.06625;
        double total = salesTax + subTotal;
        subTotalTextField.setText("$" + df.format(subTotal));
        salesTaxTextField.setText("$" + df.format(salesTax));
        totalTextField.setText("$" + df.format(total));
    }

    /**
     * Removes the order item.
     */
    @FXML
    private void removeItem(){
        MenuItem selectedItem = listView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) currentOrder.remove(selectedItem);
        displayPrice();
    }

    /**
     * Places the order.
     */
    @FXML
    private void placeOrder(){
        if(currentOrder.isEmpty()){
            showNoOrdersPopup();
            return;
        }
        orderNumber += 1;
        Order order = new Order(orderNumber, currentOrder);
        allOrders.add(order);
        currentOrder.clear();
        showOrderAddedPopup();
        clearAll();
    }

    /**
     * Once the order is added, a popup will show.
     */
    @FXML
    private void showOrderAddedPopup() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Your order has been added successfully!");
        alert.showAndWait();
    }

    /**
     * If no items in the order, popup will show.
     */
    @FXML
    private void showNoOrdersPopup() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("No items in order. Please add some items and try again.");
        alert.showAndWait();
    }

    /**
     * Clears the listview and resets the price.
     */
    @FXML
    private void clearAll() {
        listView.getItems().clear();
        displayPrice();
    }

}
