package org.example.chars;

import java.util.List;

public class Spearman extends Unit {

    public Spearman(List<Unit> gang, int x, int y) {
        super(4, 5, new int[]{1, 3}, 10, 4, "Копейщик","Stand");
        super.gang = gang;
        super.position = new PositionUnit(x, y);
    }

    @Override
    public String getInfo() {
        return super.name + ": " + super.getInfo() + ", " + state;
    }
}
