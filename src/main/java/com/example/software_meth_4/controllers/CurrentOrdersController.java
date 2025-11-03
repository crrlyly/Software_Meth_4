package com.example.software_meth_4.controllers;

import com.example.software_meth_4.GlobalData;
import com.example.software_meth_4.Main;
import com.example.software_meth_4.rudonuts.*;
import com.example.software_meth_4.rudonuts.MenuItem;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.text.DecimalFormat;

import static com.example.software_meth_4.GlobalData.currentOrder;


public class CurrentOrdersController{

   @FXML private ListView<MenuItem> listView;
   @FXML private TextField subTotalTextField;
   @FXML private TextField salesTaxTextField;
   @FXML private TextField totalTextField;

    private final DecimalFormat df = new DecimalFormat("0.00");

    public void initialize(){
        displayItems();
        displayPrice();
    }

    @FXML
    private void displayItems() {
        listView.getItems().clear();
        for (MenuItem item : currentOrder) {
            listView.getItems().add(item);
        }
    }

    @FXML
    private void onMainMenuBtnClick() throws IOException {
        Main.switchRoot("main-view.fxml");
    }

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

    @FXML
    private void removeItem(){
        MenuItem selectedItem = listView.getSelectionModel().getSelectedItem();
        currentOrder.remove(selectedItem);
        displayPrice();
        displayItems();
    }

    @FXML
    private void placeOrder(){
        showOrderAddedPopup();
    }

    @FXML
    private void showOrderAddedPopup() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Your order has been added successfully!");
        alert.showAndWait();
    }

    @FXML
    private void clearAll() {
        sizeDropDown.getSelectionModel().clearSelection();
        sizeDropDown.getSelectionModel().selectFirst();
        quantityDropDown.getSelectionModel().clearSelection();
        quantityDropDown.getSelectionModel().selectFirst();

        for(CheckBox box: checkBoxes){
            box.setSelected(false);
        }

        displayPrice();
    }

}
