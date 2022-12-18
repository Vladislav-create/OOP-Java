package org.example.chars;

import java.util.List;
import java.util.Random;

public class Wizard extends Unit {

    private boolean magic;

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
        float minHealth = Integer.MAX_VALUE;
        int minHealthIndex = -1;
        for (int i = 0; i < gang.size(); i++) {
            if (gang.get(i).health < gang.get(i).maxHealth) {
                if (gang.get(i).health < minHealth) {
                    minHealth = gang.get(i).health;
                    minHealthIndex = i;
                }
            }
        }
        if (minHealthIndex >= 0) {
            gang.get(minHealthIndex).health -= this.damage[0];
            if (gang.get(minHealthIndex).health > gang.get(minHealthIndex).maxHealth) {
                gang.get(minHealthIndex).health = gang.get(minHealthIndex).maxHealth;
            }
        }
    }
}
