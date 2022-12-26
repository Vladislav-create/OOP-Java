package org.example.chars;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Wizard extends Unit {

    private boolean magic;

    static int tmpInt = -1;

    public Wizard(List<Unit> gang, List<Unit> side, int x, int y) {
        super(17, 12, new int[]{-5, -5}, 30, 9, "Некромант", "Stand");
        magic = true;
        super.gang = gang;
        super.position = new PositionUnit(x, y);
        super.side = side;
        quantity = new Random().nextInt(1, 3);
    }

    @Override
    public String getInfo() {
        return super.name + ": " + super.getInfo() + ", магия, " + state;
    }

    @Override
    public void step() {
        Map<Integer, Double> healths = new HashMap<>();
        for (int i = 0; i < gang.size(); i++) {
            healths.put(i, (double) (gang.get(i).health / gang.get(i).maxHealth));
        }
        List<Double> a = new ArrayList<>(healths.values().stream().toList());
        Collections.sort(a);
        AtomicInteger minHealthIndex = new AtomicInteger(-1);
        healths.forEach((index, value) -> {
            if (value.equals(a.get(0))) {
                tmpInt = index;
            }
        });
        if (a.get(0) > 0.5) {
            double dist = 1;
            int index = -1;
            for (int i = 0; i < side.size(); i++) {
//                double v = side.get(i).getPositionUnit().getDistace(this.position);
                if (side.get(i).getState().equals("Погиб мучительной смертью")) {
                    continue;
                }
                if (side.get(i).health / side.get(i).maxHealth < dist) {
                    dist = side.get(i).health / side.get(i).maxHealth;
                    index = i;
                }
            }
            if (index < 0) {
                index = 0;
            }
            side.get(index).getDamage(damage[0] * -1);
            state = "Выстрелил в " + index;
            return;
        }
        if (a.get(0).equals(0.0)) {
            tmpInt = -1;
            healths.forEach((index, value) -> {
                if (value.equals(0.0)) {
                    if (gang.get(index).getName().equals("Снайпер") || gang.get(index).getName().equals("Некромант")) {
                        tmpInt = index;
                    }
                }
            });
            if (tmpInt >= 0) {
                gang.get(tmpInt).health = 1;
                gang.get(tmpInt).state = "Стоит";
                gang.get(tmpInt).quantity = 1;
                state = "Возродил " + tmpInt;
            }
            return;
        }
        if (a.get(0) <= 0.5) {
            gang.get(tmpInt).health -= this.damage[0];
            if (gang.get(tmpInt).health > gang.get(tmpInt).maxHealth) {
                gang.get(tmpInt).health = gang.get(tmpInt).maxHealth;
            }
            state = "Полечил " + tmpInt;
        }
    }
}
