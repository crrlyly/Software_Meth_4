package com.example.software_meth_4.rudonuts;
import java.util.ArrayList;

/**
 * This class represents a person's order.
 *
 * @author Carly Chick
 */
public class Order {
    private int orderNumber;
    private ArrayList<MenuItem> listOfItems;

    public Order(int orderNumber, ArrayList<MenuItem> listOfItems) {
        this.orderNumber = orderNumber;
        this.listOfItems = new ArrayList<>(listOfItems);
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public ArrayList<MenuItem> getListOfItems() {
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
