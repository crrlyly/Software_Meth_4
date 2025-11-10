package com.example.software_meth_4.controllers;

import com.example.software_meth_4.Main;
import com.example.software_meth_4.rudonuts.*;
import com.example.software_meth_4.rudonuts.MenuItem;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static com.example.software_meth_4.GlobalData.currentOrder;

//FINISHED!!!

public class CoffeeController{

    @FXML private CheckBox creamCheckBox;
    @FXML private CheckBox vanillaCheckBox;
    @FXML private CheckBox milkCheckBox;
    @FXML private CheckBox mochaCheckBox;
    @FXML private CheckBox caramelCheckBox;

    private CheckBox[] checkBoxes;

    @FXML private ComboBox<CupSize> sizeDropDown;
    @FXML private ComboBox<Integer> quantityDropDown;
    @FXML private TextField price;

    private final DecimalFormat df = new DecimalFormat("0.00");

    public void initialize(){
        initializeSizeTypeDropDown();
        initializeQuantityDropDown();
        checkBoxes = new CheckBox[]{creamCheckBox, vanillaCheckBox, milkCheckBox, mochaCheckBox, caramelCheckBox};
        displayPrice();
    }

    @FXML
    private void clickAddToOrderBtn(){
        MenuItem coffee = new Coffee(quantityDropDown.getValue(), sizeDropDown.getValue(), getAddIns());
        for (int i = 0; i < currentOrder.size(); i++) {
            MenuItem item = currentOrder.get(i);
            if (item.equals(coffee)) {
                item.setQuantity(item.getQuantity() + coffee.getQuantity());
                showItemAddedPopup();
                clearAll();
                return;
            }
        }

        currentOrder.add(coffee);
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
        sizeDropDown.getSelectionModel().clearSelection();
        sizeDropDown.getSelectionModel().selectFirst();
        quantityDropDown.getSelectionModel().clearSelection();
        quantityDropDown.getSelectionModel().selectFirst();

        for(CheckBox box: checkBoxes){
            box.setSelected(false);
        }

        displayPrice();
    }

    @FXML
    private void initializeSizeTypeDropDown(){
        sizeDropDown.getItems().addAll(CupSize.values());
        sizeDropDown.setCellFactory(param -> new ListCell<CupSize>() {
            @Override
            protected void updateItem(CupSize item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText("Sizes");
                } else {
                    switch (item) {
                        case SHORT -> setText("Short");
                        case TALL -> setText("Tall");
                        case GRANDE -> setText("Grande");
                        case VENTI -> setText("Venti");
                        default -> setText(item.toString());
                    }
                }
            }
        });
        sizeDropDown.getSelectionModel().selectFirst();
    }

    @FXML
    private void initializeQuantityDropDown(){
        Integer[] nums = {1,2,3,4,5,6,7,8,9,10};
        quantityDropDown.getItems().addAll(nums);
        quantityDropDown.getSelectionModel().selectFirst();
    }

    @FXML
    private void onMainMenuBtnClick() throws IOException {
        Main.switchRoot("main-view.fxml", "RU Cafe");
    }

    @FXML
    private ArrayList<AddIns> getAddIns(){
        ArrayList<AddIns> addIns = new ArrayList<>();
        for (CheckBox box : checkBoxes) {
            if (box != null && box.isSelected()) {
                if (box == creamCheckBox) {
                    addIns.add(AddIns.WHIPPEDCREAM);
                } else if (box == milkCheckBox) {
                    addIns.add(AddIns.MILK);
                } else if (box == caramelCheckBox) {
                    addIns.add(AddIns.CARAMEL);
                } else if (box == vanillaCheckBox) {
                    addIns.add(AddIns.VANILLA);
                } else if (box == mochaCheckBox) {
                    addIns.add(AddIns.MOCHA);
                }
            }
        }
        return addIns;
    }

    @FXML
    private void displayPrice(){
        MenuItem coffee = new Coffee(quantityDropDown.getValue(), sizeDropDown.getValue(), getAddIns());
        price.setText("$" + df.format(coffee.price()));
    }
}
