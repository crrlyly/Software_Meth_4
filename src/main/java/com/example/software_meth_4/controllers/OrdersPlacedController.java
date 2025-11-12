package com.example.software_meth_4.controllers;

import com.example.software_meth_4.Main;
import com.example.software_meth_4.rudonuts.MenuItem;
import com.example.software_meth_4.rudonuts.Order;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import static com.example.software_meth_4.GlobalData.*;

/**
 * This controller stores the methods for the orders placed page.
 *
 * @author Carly Chick
 */
public class OrdersPlacedController{

    @FXML private ComboBox<Order> orderNumberDropDown;
    @FXML private TextField totalTextField;
    @FXML private ListView<MenuItem> listView;

    private final DecimalFormat df = new DecimalFormat("0.00");


    public void initialize(){
        initOrderDropDown();
    }

    @FXML
    private void initOrderDropDown(){
        orderNumberDropDown.setItems(allOrders);
        orderNumberDropDown.setCellFactory(param -> new ListCell<Order>() {
            @Override
            protected void updateItem(Order item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText("Order Number");
                } else {
                    setText(String.valueOf(item.getOrderNumber()));
                }
            }
        });
    }

    @FXML
    private void onMainMenuBtnClick() throws IOException {
        Main.switchRoot("main-view.fxml", "RU Cafe");
    }

    @FXML
    private void getOrderInfo(){
        clearAll();
        Order order = orderNumberDropDown.getValue();
        if (order == null) return;
        listView.getItems().setAll(order.getListOfItems());
        double subTotal = 0;
        for(MenuItem item: order.getListOfItems()){
            subTotal = subTotal + item.price();
        }
        double salesTax = subTotal * 0.06625;
        double total = salesTax + subTotal;
        totalTextField.setText("$" + df.format(total));
    }

    @FXML
    private void cancelOrder(){
        Order order = orderNumberDropDown.getValue();
        if (order == null) return;
        allOrders.remove(order);

        orderNumberDropDown.getSelectionModel().clearSelection();
        orderNumberDropDown.setValue(null);

        showCancelOrderPopup();
        clearAll();
    }

    @FXML
    private void showCancelOrderPopup(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Order was cancelled.");
        alert.showAndWait();
    }

    @FXML
    private void clearAll() {
        listView.getItems().clear();
        listView.getItems().clear();
        totalTextField.clear();
    }

    @FXML
    private void exportOrders() {
        if(allOrders.isEmpty()){
            showExportPopup("No orders in list. Please order some items.");
            return;
        }
        try {
            File file = new File("orders.txt");
            FileWriter writer = new FileWriter(file);

            for (Order order : allOrders) {
                double subTotal = 0;
                for(MenuItem item: order.getListOfItems()){
                    subTotal = subTotal + item.price();
                }
                double salesTax = subTotal * 0.06625;
                double total = salesTax + subTotal;
                writer.write("Order #" + order.getOrderNumber()
                        + "\nSub-Total (no tax): $" + df.format(subTotal)
                        + "\nTax: $" + df.format(salesTax)
                        + "\nTotal (w tax): $" + df.format(total) + "\n");
                for (MenuItem item : order.getListOfItems()) {
                    writer.write(" - " + item.toString() + "\n");
                }
                writer.write("\n");
            }

            writer.close();
            showExportPopup("Orders exported to " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            showExportPopup("Error exporting orders.");
        }
    }

    private void showExportPopup(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Export Orders Status");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}
