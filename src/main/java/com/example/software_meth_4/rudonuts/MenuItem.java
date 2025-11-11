package com.example.software_meth_4.rudonuts;

/**
 * This class represents a menu item.
 *
 * @author Carly Chick
 */
public abstract class MenuItem {
    protected int quantity;

    public MenuItem(int quantity) {
        this.quantity = quantity;
    }

    public abstract double price();

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
