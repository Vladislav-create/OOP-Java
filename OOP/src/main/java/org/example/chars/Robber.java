package org.example.chars;

import java.util.List;

public class Robber extends Unit {

    public Robber(List<Unit> gang, int x, int y) {
        super(8, 3, new int[] { 2, 4 }, 10, 6, "Разбойник","Stand");
        super.gang = gang;
        super.position = new PositionUnit(x, y);
    }

    @Override
    public String getInfo() {
        return super.name + ": " + super.getInfo() + ", " + state;
    }
}
