package com.example.software_meth_4.rudonuts;

public enum Protein {
    BEEF(12.99),
    CHICKEN(10.99),
    SALMON(14.99);

    private final double price;

    Protein(double price){
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
