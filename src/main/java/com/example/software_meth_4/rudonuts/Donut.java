package com.example.software_meth_4.rudonuts;

/**
 * This class represents a donut menu item.
 *
 * @author Carly Chick
 */
public class Donut extends MenuItem{
    private DonutType type;
    private Flavor flavor;

    public Donut(int quantity, DonutType type, Flavor flavor) {
        super(quantity);
        this.type = type;
        this.flavor = flavor;
    }

    public double price(){
        return (type.getPrice() * quantity);
    };

    public DonutType getType() { return type; }
    public Flavor getFlavor() { return flavor; }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Donut donut){
            return this.type.equals(donut.type) && this.flavor.equals(donut.flavor);
        }
        return false;
    }

    @Override
    public String toString(){
        return flavor.name() + " " + type.name() + " donut (" + quantity + ")";
    }
}
