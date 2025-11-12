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

/**
 * This controller stores the methods for the coffee page.
 *
 * @author Carly Chick
 */
public class CoffeeController{
    @FXML private ComboBox<CupSize> sizeDropDown;
    @FXML private ComboBox<Integer> quantityDropDown;
    @FXML private TextField price;

    @FXML private CheckBox creamCheckBox;
    @FXML private CheckBox vanillaCheckBox;
    @FXML private CheckBox milkCheckBox;
    @FXML private CheckBox mochaCheckBox;
    @FXML private CheckBox caramelCheckBox;

    private CheckBox[] checkBoxes;
    private final DecimalFormat df = new DecimalFormat("0.00");

    /**
     * Initializes the Coffee page.
     */
    @FXML
    public void initialize(){
        initializeSizeTypeDropDown();
        initializeQuantityDropDown();
        checkBoxes = new CheckBox[]{creamCheckBox, vanillaCheckBox, milkCheckBox, mochaCheckBox, caramelCheckBox};
        displayPrice();
    }

    /**
     * Adds the coffee to the current order.
     */
    @FXML
    private void clickAddToOrderBtn(){
        MenuItem coffee = new Coffee(quantityDropDown.getValue(), sizeDropDown.getValue(), getAddIns());
        for (int i = 0; i < currentOrder.size(); i++) {
            MenuItem item = currentOrder.get(i);
            if (item.equals(coffee)) {
                item.setQuantity(item.getQuantity() + coffee.getQuantity());
                currentOrder.set(i, item);
                showItemAddedPopup();
                clearAll();
                return;
            }
        }
        currentOrder.add(coffee);
        showItemAddedPopup();
        clearAll();
    }

    /**
     * Shows the pop-up once a coffee was added.
     */
    @FXML
    private void showItemAddedPopup() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Item Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Your item(s) has been added successfully!");
        alert.showAndWait();
    }

    /**
     * Clears all inputs
     */
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

    /**
     * Initializes the coffee size drop down.
     */
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

    /**
     * Initializes the quantity drop down.
     */
    @FXML
    private void initializeQuantityDropDown(){
        Integer[] nums = {1,2,3,4,5,6,7,8,9,10};
        quantityDropDown.getItems().addAll(nums);
        quantityDropDown.getSelectionModel().selectFirst();
    }

    /**
     * Brings back to main page once main menu button is clicked.
     *
     * @throws IOException if button fails
     */
    @FXML
    private void onMainMenuBtnClick() throws IOException {
//        Main.switchRoot("main-view.fxml", "RU Cafe");
        Main.goTo("/com/example/software_meth_4/main-view.fxml", null, "RU Cafe");
    }

    /**
     * gets an array of all selected add-ins.
     * @return list of addins
     */
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

    /**
     * Displays the price.
     */
    @FXML
    private void displayPrice(){
        MenuItem coffee = new Coffee(quantityDropDown.getValue(), sizeDropDown.getValue(), getAddIns());
        price.setText("$" + df.format(coffee.price()));
    }
}
