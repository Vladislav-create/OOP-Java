package org.example.chars;

import java.util.List;

public class Sniper extends Unit {

    private int shoots;

    public Sniper(List<Unit> gang, int x, int y) {
        super(12, 10, new int[] { 8, 10 }, 15, 8, "Снайпер","Stand");
        shoots = 32;
        super.gang = gang;
        super.position = new PositionUnit(x, y);
    }

    @Override
    public String getInfo() {return super.name + ": " + super.getInfo() + ", выстрелы: " + shoots + ", " + state;}

}
