package com.example.software_meth_4.controllers;

import com.example.software_meth_4.Main;
import com.example.software_meth_4.rudonuts.*;
import com.example.software_meth_4.rudonuts.MenuItem;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.text.DecimalFormat;

import static com.example.software_meth_4.GlobalData.currentOrder;


//FINISHED!!!

public class DonutController{

    @FXML private Button mainMenuBtn;
    @FXML private ComboBox<DonutType> typeDropDown;
    @FXML private ListView<Flavor> displayFlavors;
    @FXML private ComboBox<Integer> quantity;
    @FXML private Button add;
    @FXML private Button remove;
    @FXML private ListView<MenuItem> displayOrder;
    @FXML private TextArea displaySubTotal;
    @FXML private Button addToOrderBtn;

    private final DecimalFormat df = new DecimalFormat("0.00");

    public void initialize(){
        initDonutTypeDropDown();
        initQuantityDropDown();
        displayFlavors.setDisable(false);
        displayFlavors.setMouseTransparent(false);
        displayFlavors.toFront();
        displayOrder.setCellFactory(param -> new ListCell<MenuItem>() {
            @Override
            protected void updateItem(MenuItem item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    if (item instanceof Donut donut) {
                        setText(donut.getQuantity() + " × "
                                + donut.getFlavor() + " (" + donut.getType() + ")");
                    } else {
                        setText(item.toString());
                    }
                }
            }
        });
    }

    @FXML
    private void initDonutTypeDropDown(){
        typeDropDown.getItems().addAll(DonutType.values());
        typeDropDown.setCellFactory(param -> new ListCell<DonutType>() {
            @Override
            protected void updateItem(DonutType item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText("Donut Type");
                } else {
                    switch (item) {
                        case YEAST -> setText("Yeast Donut");
                        case CAKE -> setText("Cake Donut");
                        case DONUTHOLE -> setText("Donut Hole");
                        case SEASONAL -> setText("Seasonal Donut");
                        default -> setText(item.toString());
                    }
                }
            }
        });
    }

    @FXML
    private void initQuantityDropDown(){
        Integer[] nums = {1,2,3,4,5,6,7,8,9,10};
        quantity.getItems().addAll(nums);
    }

    //TODO
    @FXML
    private void addDonut(){
        //checks for empty stuff

        //

        MenuItem donut = new Donut(quantity.getValue(), typeDropDown.getValue(),
                displayFlavors.getSelectionModel().getSelectedItem());

        for (int i = 0; i < displayOrder.getItems().size(); i++) {
            MenuItem item = displayOrder.getItems().get(i);
            if (item.equals(donut)) {
                item.setQuantity(item.getQuantity() + donut.getQuantity());
                displayOrder.getItems().set(i, item);
                return;
            }
        }
        displayOrder.getItems().addAll(donut);
        displaySubTotal.setText("$" + df.format(getPrice()));
    }

    @FXML
    private void removeDonut(){
        displayOrder.getItems().remove(displayOrder.getSelectionModel().getSelectedItem());
        displaySubTotal.setText("$" + df.format(getPrice()));
    }

    @FXML
    private double getPrice(){
        double total = 0;
        for (int i = 0; i < displayOrder.getItems().size(); i++) {
            total = total + displayOrder.getItems().get(i).price();
        }
        return total;
    }

    @FXML
    private void onMainMenuBtnClick() throws IOException {
        Main.switchRoot("main-view.fxml");
    }

    @FXML
    private void displayDonutTypeFlavors(){
        displayFlavors.getItems().clear();
        DonutType selectedType = typeDropDown.getValue();
        displayFlavors.getItems().addAll(Flavor.byType(selectedType));
    }

    @FXML
    private void clickAddToOrderBtn() {
        var dest = currentOrder;
        var src  = displayOrder.getItems();

        for (MenuItem incoming : src) {
            int idx = dest.indexOf(incoming);
            if (idx >= 0) {
                MenuItem existing = dest.get(idx);
                existing.setQuantity(existing.getQuantity() + incoming.getQuantity());
            } else {
                dest.add(incoming);
            }
        }

        src.clear();
        showItemAddedPopup();
        clearAll();
    }

    @FXML
    private void showItemAddedPopup() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Item Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Your item(s) has been added successfully!");
        alert.showAndWait();
    }

    @FXML
    private void clearAll() {
        // Clear all ComboBoxes
        typeDropDown.getSelectionModel().clearSelection();
        typeDropDown.setValue(null);
        quantity.getSelectionModel().clearSelection();
        quantity.setValue(null);

        // Clear all ListViews
        displayFlavors.getItems().clear();
        displayOrder.getItems().clear();

        // Clear all TextAreas
        displaySubTotal.clear();
    }
}
