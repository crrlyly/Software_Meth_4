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

    /**
     * Constructor for an order.
     * @param orderNumber order number
     * @param listOfItems list of menu items in order
     */
    public Order(int orderNumber, ObservableList<MenuItem> listOfItems) {
        this.orderNumber = orderNumber;
        this.listOfItems = FXCollections.observableArrayList(listOfItems);
    }

    /**
     * Get the order number
     * @return order number
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * Returns a copy of the list of items
     * @return the list of items in order
     */
    public ObservableList<MenuItem> getListOfItems() {
        return listOfItems;
    }

    /**
     * Checks to see if orders are the same
     * @param obj   the reference object with which to compare.
     * @return true if the same; otherwise false
     */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Order order){
            return this.orderNumber == order.orderNumber;
        }
        return false;
    }

    /**
     * Changes order number to string
     * @return order number
     */
    @Override
    public String toString() {
        return String.valueOf(orderNumber);
    }
}
