package com.example.software_meth_4.rudonuts;

public class Donut extends MenuItem{
    private DonutType type;
    private Flavor flavor;

    public Donut(DonutType type, Flavor flavor) {
        super();
        if (flavor.getType() != type) {
            throw new IllegalArgumentException("Flavor " + flavor + " is not valid for type " + type); //catch this
        }
        this.type = type;
        this.flavor = flavor;
    }

    //no tax
    public double price(){
        return (type.getPrice() * quantity);
    };

    public DonutType getType() { return type; }
    public Flavor getFlavor() { return flavor; }
}
