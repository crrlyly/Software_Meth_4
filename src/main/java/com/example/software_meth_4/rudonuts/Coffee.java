package com.example.software_meth_4.rudonuts;
import java.util.ArrayList;

public class Coffee extends MenuItem{
    private CupSize size;
    private ArrayList<AddIns> addIns;
    private final static double ADDIN_COST = 0.25;

    public Coffee(int quantity, CupSize size, ArrayList<AddIns> addIns) {
        super(quantity);
        this.size = size;
        this.addIns = addIns;
    }



    public double price(){
        return (size.getBasePrice() + (addIns.toArray().length * ADDIN_COST)) * quantity;
    };
}
