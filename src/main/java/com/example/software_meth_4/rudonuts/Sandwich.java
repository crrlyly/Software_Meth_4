package com.example.software_meth_4.rudonuts;
import java.util.ArrayList;
import java.util.ArrayList;

public class Sandwich extends MenuItem{
    protected Bread bread;
    protected Protein protein;
    protected ArrayList<AddOns> addOns;

    //no tax, dont forget to multiply by quantity
    public double price(){
        double price = 0;
        price = price + protein.getPrice();
        //loop through addons and add to price
        //return price
        return price;
    };
}
