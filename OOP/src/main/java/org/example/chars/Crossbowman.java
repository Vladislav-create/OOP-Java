package org.example.chars;

import java.util.List;

public class Crossbowman extends Unit {

    private int shoots;

    public Crossbowman(List<Unit> gang, int x, int y) {
        super(6, 3, new int[] { 2, 3 }, 10, 4, "Арбалетчик", "Stand");
        shoots = 16;
        super.gang = gang;
        super.position = new PositionUnit(x, y);
    }

    @Override
    public String getInfo() {
        return super.name + ": " + super.getInfo() + ", выстрелы: " + shoots + ", " + state;
    }

}
