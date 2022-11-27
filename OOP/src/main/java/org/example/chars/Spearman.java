package org.example.chars;

import org.example.Unit;

public class Spearman extends Unit {

    public Spearman() {
        super(4, 5, new int[] { 1, 3 }, 10, 4, "Stand");
    }

    @Override
    public String getInfo() {
        return "Spearman:  " + super.getInfo() + ", " + state + "\n";
    }
}
