package com.example.software_meth_4.rudonuts;
import java.util.ArrayList;

/**
 * This class represents a coffee menu item.
 *
 * @author Carly Chick
 */
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

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Coffee coffee){
            return this.size.equals(coffee.size) && this.addIns.equals(coffee.addIns);
        }
        return false;
    }

    @Override
    public String toString(){
        String addInsString = (addIns.isEmpty()) ? "nothing" : addIns.toString();
        return size.name() + " coffee (" + quantity + ") with " + addInsString;
    }
}
