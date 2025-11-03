package com.example.software_meth_4;

import java.util.ArrayList;
import java.util.List;
import com.example.software_meth_4.rudonuts.MenuItem;
import com.example.software_meth_4.rudonuts.Order;
import javafx.fxml.FXML;

public class GlobalData {
    public static Order[] allOrders = {new Order(1, new ArrayList<MenuItem>())};
}
