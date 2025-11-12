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
 * This controller stores the methods for the sandwich page.
 *
 * @author Carly Chick
 */
public class SandwichController{

    @FXML private RadioButton bagelRadioBtn;
    @FXML private RadioButton wheatRadioBtn;
    @FXML private RadioButton sourRadioBtn;

    @FXML private RadioButton beefRadioBtn;
    @FXML private RadioButton chickenRadioBtn;
    @FXML private RadioButton salmonRadioBtn;

    @FXML private CheckBox lettuceCheck;
    @FXML private CheckBox cheeseCheck;
    @FXML private CheckBox tomatoCheck;
    @FXML private CheckBox onionCheck;

    @FXML private CheckBox[] checkBoxes;

    @FXML private TextField price;
    @FXML private ComboBox<Integer> quantityDropDown;

    private ToggleGroup breadGroup;
    private ToggleGroup proteinGroup;

    private final DecimalFormat df = new DecimalFormat("0.00");

    /**
     * Initializes the sandwich page.
     */
    @FXML
    public void initialize(){
        initializeBreadGroup();
        initializeProteinGroup();
        initializeQuantityDropDown();
        checkBoxes = new CheckBox[]{lettuceCheck, cheeseCheck, tomatoCheck, onionCheck};
        displayPrice();
    }

    /**
     * Brings user back to main menu
     * @throws IOException error thrown if fails
     */
    @FXML
    private void onMainMenuBtnClick() throws IOException {
        Main.goTo("/com/example/software_meth_4/main-view.fxml", "RU Cafe");
    }

    /**
     * Initializes the breads
     */
    @FXML
    private void initializeBreadGroup(){
        breadGroup = new ToggleGroup();
        bagelRadioBtn.setToggleGroup(breadGroup);
        wheatRadioBtn.setToggleGroup(breadGroup);
        sourRadioBtn.setToggleGroup(breadGroup);
        breadGroup.selectToggle(bagelRadioBtn);
    }

    /**
     * Initializes the proteins.
     */
    @FXML
    private void initializeProteinGroup(){
        proteinGroup = new ToggleGroup();
        beefRadioBtn.setToggleGroup(proteinGroup);
        chickenRadioBtn.setToggleGroup(proteinGroup);
        salmonRadioBtn.setToggleGroup(proteinGroup);
        proteinGroup.selectToggle(beefRadioBtn);
    }

    /**
     * Initializes the quantity dropdown.
     */
    @FXML
    private void initializeQuantityDropDown(){
        Integer[] nums = {1,2,3,4,5,6,7,8,9,10};
        quantityDropDown.getItems().addAll(nums);
        quantityDropDown.getSelectionModel().selectFirst();
    }

    /**
     * Creates a list of the addons the user chose.
     *
     * @return the list the user chose
     */
    @FXML
    private ArrayList<AddOns> getAddOns(){
        ArrayList<AddOns> addIns = new ArrayList<>();
        for (CheckBox box : checkBoxes) {
            if (box != null && box.isSelected()) {
                if (box == lettuceCheck) {
                    addIns.add(AddOns.LETTUCE);
                } else if (box == cheeseCheck) {
                    addIns.add(AddOns.CHEESE);
                } else if (box == tomatoCheck) {
                    addIns.add(AddOns.TOMATO);
                } else if (box == onionCheck) {
                    addIns.add(AddOns.ONION);
                }
            }
        }
        return addIns;
    }

    /**
     * Calculates and displays the price.
     */
    @FXML
    private void displayPrice(){
        RadioButton selected1 = (RadioButton) breadGroup.getSelectedToggle();
        Bread bread = Bread.parseBread(selected1.getText());

        RadioButton selected2 = (RadioButton) proteinGroup.getSelectedToggle();
        Protein protein = Protein.parseProtein(selected2.getText());

        MenuItem sandwich = new Sandwich(quantityDropDown.getValue(), bread, protein, getAddOns());
        price.setText("$" + df.format(sandwich.price()));
    }

    /**
     * Adds the sandwich to the current order.
     */
    @FXML
    private void clickAddToOrderBtn(){
        RadioButton selected1 = (RadioButton) breadGroup.getSelectedToggle();
        Bread bread = Bread.parseBread(selected1.getText());

        RadioButton selected2 = (RadioButton) proteinGroup.getSelectedToggle();
        Protein protein = Protein.parseProtein(selected2.getText());

        MenuItem sandwich = new Sandwich(quantityDropDown.getValue(), bread, protein, getAddOns());
        for (int i = 0; i < currentOrder.size(); i++) {
            MenuItem item = currentOrder.get(i);
            if (item.equals(sandwich)) {
                item.setQuantity(item.getQuantity() + sandwich.getQuantity());
                currentOrder.set(i, item);
                showItemAddedPopup();
                clearAll();
                return;
            }
        }
        currentOrder.add(sandwich);
        showItemAddedPopup();
        clearAll();
    }

    /**
     * Once sandwich was added, popup will show.
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
     * Clears all user input.
     */
    @FXML
    private void clearAll() {
        quantityDropDown.getSelectionModel().clearSelection();
        quantityDropDown.getSelectionModel().selectFirst();

        breadGroup.selectToggle(bagelRadioBtn);
        proteinGroup.selectToggle(beefRadioBtn);

        for(CheckBox box: checkBoxes){
            box.setSelected(false);
        }

        displayPrice();
    }
}
