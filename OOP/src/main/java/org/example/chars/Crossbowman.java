package org.example.chars;

import java.util.List;
import java.util.Random;

public class Crossbowman extends Unit {

    private int shoots;

    public Crossbowman(List<Unit> gang, List<Unit> side, int x, int y) {
        super(6, 3, new int[]{2, 3}, 10, 4, "Арбалетчик", "Stand");
        shoots = 16;
        super.gang = gang;
        super.position = new PositionUnit(x, y);
        super.side = side;
        quantity = new Random().nextInt(1, 5);
    }

    @Override
    public String getInfo() {
        return super.name + ": " + super.getInfo() + ", выстрелы: " + shoots + ", " + state;
    }

    @Override
    public void step() {
        for (Unit unit : super.gang) {
            if (unit.getName().equals("крестьянин")) {
                if (!unit.getState().equals("Занят Я!!!") && !unit.getState().equals("Погиб мучительной смертью")) {
                    shoots++;
                    unit.setState("Занят Я!!!");
                    break;
                }

            }
        }
        if (shoots > 0) {
            double dist = Double.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < side.size(); i++) {
                double v = side.get(i).getPositionUnit().getDistace(this.position);
                if (dist > v && !side.get(i).getState().equals("Погиб мучительной смертью")) {
                    dist = v;
                    index = i;
                }
            }

            if (index >= 0) {
                side.get(index).getDamage(speed > dist ? calcDamage(side.get(index)) : calcDamage(side.get(index)) / 2);
                shoots--;

            }
        }
    }
}
