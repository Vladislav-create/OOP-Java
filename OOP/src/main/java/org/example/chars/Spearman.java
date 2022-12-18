package org.example.chars;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Spearman extends Unit {

    public Spearman(List<Unit> gang, List<Unit> side, int x, int y) {
        super(4, 5, new int[]{1, 3}, 10, 4, "Копейщик", "Stand");
        super.gang = gang;
        super.position = new PositionUnit(x, y);
        super.side = side;
        quantity = new Random().nextInt(1, 21);
    }

    @Override
    public String getInfo() {
        return super.name + ": " + super.getInfo() + ", " + state;
    }

    @Override
    public void step() {
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
            if (dist < 2) {
                side.get(index).getDamage(calcDamage(side.get(index)));
            } else {
                PositionUnit enemyPos = side.get(index).getPositionUnit();
                PositionUnit newPos = new PositionUnit(0, 0);
                if (enemyPos.y == position.y) {
                    newPos.y = position.y;
                    if (position.x - enemyPos.x < 0) {
                        newPos.x = position.x + 1;
                    } else {
                        newPos.x = position.x - 1;
                    }
                } else {
                    newPos.x = position.x;
                    if (enemyPos.y - position.y > 0) {
                        newPos.y = position.y + 1;
                    } else {
                        newPos.y = position.y - 1;
                    }
                }


                AtomicBoolean empty = new AtomicBoolean(true);
                gang.forEach(unit -> {
                    if (unit.getPositionUnit().equals(newPos)) {
                        empty.set(false);
                    }
                });
                if (empty.get()) {
                    position = newPos;
                }
            }
        }
    }
}
