package com.example.software_meth_4;

import com.example.software_meth_4.rudonuts.MenuItem;
import com.example.software_meth_4.rudonuts.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This class stores the global variables used in the controllers.
 *
 * @author Carly Chick
 */
public class GlobalData {
    public static ObservableList<Order> allOrders = FXCollections.observableArrayList();
    public static ObservableList<MenuItem> currentOrder = FXCollections.observableArrayList();
    public static int orderNumber = 0;
}
