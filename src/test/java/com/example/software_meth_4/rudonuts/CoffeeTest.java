package com.example.software_meth_4.rudonuts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUNIT test class to test price method for Coffee.
 *
 * @author Alec Cotler
 */
class CoffeeTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testShortCoffeeNoAddIns() {
        ArrayList<AddIns> addIns = new ArrayList<>();
        Coffee coffee = new Coffee(
                1,               // quantity
                CupSize.SHORT,   // size
                addIns
        );
        double expectedPrice = CupSize.SHORT.getBasePrice() * 1;
        assertEquals(expectedPrice, coffee.price(), 0.001);
    }


    /**
     * Test a TALL coffee with two add-ins (e.g., Milk and Vanilla).
     */
    @Test
    void testTallCoffeeTwoAddIns() {
        ArrayList<AddIns> addIns = new ArrayList<>();
        addIns.add(AddIns.MILK);
        addIns.add(AddIns.VANILLA);
        Coffee coffee = new Coffee(
                1,
                CupSize.TALL,
                addIns
        );


        double expectedPrice = (CupSize.TALL.getBasePrice() + (2 * 0.25)) * 1;
        assertEquals(expectedPrice, coffee.price(), 0.001);
    }


    /**
     * Test two VENTI coffees with three add-ins (e.g., Milk, Mocha, Caramel).
     */
    @Test
    void testVentiCoffeeThreeAddInsTwoQuantity() {
        ArrayList<AddIns> addIns = new ArrayList<>();
        addIns.add(AddIns.MILK);
        addIns.add(AddIns.MOCHA);
        addIns.add(AddIns.CARAMEL);
        Coffee coffee = new Coffee(
                2,               // quantity
                CupSize.VENTI,
                addIns
        );
        double expectedPrice = (CupSize.VENTI.getBasePrice() + (3 * 0.25)) * 2;
        assertEquals(expectedPrice, coffee.price(), 0.001);
    }

}