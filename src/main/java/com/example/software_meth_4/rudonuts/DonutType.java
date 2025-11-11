package com.example.software_meth_4.rudonuts;

/**
 * This enum class stores the donut types for a donut.
 *
 * @author Carly Chick
 */
public enum DonutType {
    YEAST(1.99),
    CAKE(2.19),
    DONUTHOLE(0.39),
    SEASONAL(2.49);

    private final double price;

    DonutType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
