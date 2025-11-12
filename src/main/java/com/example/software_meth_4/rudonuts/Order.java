package com.example.software_meth_4.rudonuts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This class represents a person's order.
 *
 * @author Carly Chick
 */
public class Order {
    private int orderNumber;
    private ObservableList<MenuItem> listOfItems;

    public Order(int orderNumber, ObservableList<MenuItem> listOfItems) {
        this.orderNumber = orderNumber;
        this.listOfItems = FXCollections.observableArrayList(listOfItems);
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public ObservableList<MenuItem> getListOfItems() {
        return listOfItems;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Order order){
            return this.orderNumber == order.orderNumber;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(orderNumber);
    }
}
