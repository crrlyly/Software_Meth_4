package com.example.software_meth_4.rudonuts;

/**
 * This enum class stores the cup sizes for a coffee.
 *
 * @author Carly Chick
 */
public enum CupSize {
    SHORT(2.39),
    TALL(2.99),
    GRANDE(3.59),
    VENTI(4.19);

    private final double basePrice;

    CupSize(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getBasePrice() {
        return basePrice;
    }
}
