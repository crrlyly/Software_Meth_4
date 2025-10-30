package com.example.software_meth_4.rudonuts;

public enum CupSize {
    LETTUCE(2.39),
    TOMATO(2.99),
    CHEESE(3.59),
    ONION(4.19);

    private final double basePrice;

    CupSize(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getBasePrice() {
        return basePrice;
    }
}
