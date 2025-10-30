package com.example.software_meth_4.rudonuts;

public enum AddOns {
    LETTUCE(0.30),
    TOMATO(0.30),
    CHEESE(1.00),
    ONION(0.30);

    private final double price;

    AddOns(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
