package org.example.chars;

import java.util.List;

public class Peasant extends Unit {

    private boolean delivery;

    public Peasant(List<Unit> gang, List<Unit> side, int x, int y) {
        super(1, 1, new int[] { 1, 1 }, 1, 3, "крестьянин","Stand");
        delivery = true;
        super.gang = gang;
        super.position = new PositionUnit(x, y);
        super.side = side;
    }

    @Override
    public void step() {
        if (state.equals("Занят Я!!!")){
            state = "Стоит";
        }
    }

    @Override
    public String getInfo() {
        return super.name + ": " + super.getInfo() + ", доставка, " + state;
    }

}
