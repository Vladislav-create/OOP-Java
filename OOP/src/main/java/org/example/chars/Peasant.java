package org.example.chars;

import org.example.Unit;

public class Peasant extends Unit {

    private boolean delivery;

    public Peasant() {
        super(1, 1, new int[] { 1, 1 }, 1, 3, "Stand");
        delivery = true;
    }

    @Override
    public String getInfo() {
        return "Peasant:  " + super.getInfo() + ", доставка, " + state + "\n";
    }

}
