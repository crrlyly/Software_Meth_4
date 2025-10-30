package com.example.software_meth_4.rudonuts;
import java.util.ArrayList;

public class Coffee extends MenuItem{
    private CupSize size;
    private ArrayList<AddIns> addIns;
    private final static double ADDIN_COST = 0.25;

    public Coffee(CupSize size) {
        this.size = size;
    }

    public double price(){ return 1.0; };
}
