package com.example.software_meth_4;

import java.util.ArrayList;
import java.util.List;
import com.example.software_meth_4.rudonuts.MenuItem;
import com.example.software_meth_4.rudonuts.Order;
import javafx.fxml.FXML;

public class GlobalData {
    public static ArrayList<Order> allOrders = new ArrayList<>();
    public static ArrayList<MenuItem> currentOrder = new ArrayList<>();
    public static int orderNumber = 0;
}
