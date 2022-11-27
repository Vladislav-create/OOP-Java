package org.example.chars;

import org.example.Unit;

public class Crossbowman extends Unit {

    private int shoots;

    public Crossbowman() {
        super(6, 3, new int[] { 2, 3 }, 10, 4, "Stand");
        shoots = 16;
    }

    @Override
    public String getInfo() {
        return "Crossbowman:  " + super.getInfo() + ", выстрелы: " + shoots + ", " + state + "\n";
    }

}
