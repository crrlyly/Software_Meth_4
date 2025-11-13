package com.example.software_meth_4.rudonuts;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class SandwichTest {

    /**
     * Test a single Chicken sandwich on Wheatbread with Cheese and Tomato.
     */
    @Test
    void testPrice_ChickenSandwichWithCheeseAndTomato() {
        ArrayList<AddOns> addOns = new ArrayList<>();
        addOns.add(AddOns.CHEESE);
        addOns.add(AddOns.TOMATO);

        Sandwich sandwich = new Sandwich(
                1,                      // quantity
                Bread.WHEATBREAD,       // bread type
                Protein.CHICKEN,        // protein
                addOns                  // add-ons
        );
        double expectedPrice = (Protein.CHICKEN.getPrice() + AddOns.CHEESE.getPrice() + AddOns.TOMATO.getPrice()) * 1;
        assertEquals(expectedPrice, sandwich.price(), 0.001);
    }

    /**
     * Test two Salmon sandwiches on Sourdough with Lettuce and Onion.
     */
    @Test
    void testPrice_SalmonSandwichWithLettuceAndOnion_TwoQuantity() {
        ArrayList<AddOns> addOns = new ArrayList<>();
        addOns.add(AddOns.LETTUCE);
        addOns.add(AddOns.ONION);

        Sandwich sandwich = new Sandwich(
                2,                      // quantity
                Bread.SOURDOUGH,        // bread type
                Protein.SALMON,         // protein
                addOns
        );
        double expectedPrice = (Protein.SALMON.getPrice()
                + AddOns.LETTUCE.getPrice()
                + AddOns.ONION.getPrice()) * 2;

        assertEquals(expectedPrice, sandwich.price(), 0.001);
    }
}

