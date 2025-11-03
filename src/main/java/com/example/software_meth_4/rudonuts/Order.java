package com.example.software_meth_4.rudonuts;
import java.util.ArrayList;

public class Order {

    private int orderNumber;    //unique for each order
    private ArrayList<MenuItem> listOfItems;

    public Order(int orderNumber, ArrayList<MenuItem> listOfItems) {
        this.orderNumber = orderNumber;
        this.listOfItems = listOfItems;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public ArrayList<MenuItem> getListOfItems() {
        return listOfItems;
    }

    public void setListOfItems(ArrayList<MenuItem> listOfItems) {
        this.listOfItems = listOfItems;
    }
}
