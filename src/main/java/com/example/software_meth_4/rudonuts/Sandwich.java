package com.example.software_meth_4.rudonuts;
import java.util.ArrayList;
import java.util.ArrayList;

public class Sandwich extends MenuItem{
    protected Bread bread;
    protected Protein protein;
    protected ArrayList<AddOns> addOns;

    public Sandwich(int quantity, Bread bread, Protein protein, ArrayList<AddOns> addOns) {
        super(quantity);
        this.bread = bread;
        this.protein = protein;
        this.addOns = addOns;
    }

    public double price(){
        double price = 0;
        price = price + protein.getPrice();
        for(AddOns add: addOns){
            price = price + add.getPrice();
        }
        return price * quantity;
    };

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Sandwich sandwich){
            return this.bread.equals(sandwich.bread) && this.protein.equals(sandwich.protein) && this.addOns.equals(sandwich.addOns);
        }
        return false;
    }

    @Override
    public String toString(){
        return protein.name() + " sandwich (" + quantity + ") on " + bread.name() + " with " + addOns.toString();
    }
}
