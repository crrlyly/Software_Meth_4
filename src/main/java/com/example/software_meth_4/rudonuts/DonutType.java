package com.example.software_meth_4.rudonuts;

/**
 * This enum class stores the donut types for a donut.
 *
 * @author Carly Chick
 */
public enum DonutType {
    YEAST(1.99, "YeastDonut.png"),
    CAKE(2.19, "CakeDonut.png"),
    DONUTHOLE(0.39, "DonutHole.png"),
    SEASONAL(2.49, "SeasonalDonut.png");

    private final double price;
    private final String img;

    DonutType(double price, String img) {
        this.price = price;
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public String getImg() {
        return img;
    }
}
