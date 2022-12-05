package org.example.chars;

import java.util.List;

public class Monk extends Unit {

    private boolean magic;

    public Monk(List<Unit> gang, int x, int y) {
        super(12, 7, new int[] { -4, -4 }, 30, 5, "Монах","Stand");
        magic = true;
        super.gang = gang;
        super.position = new PositionUnit(x, y);
    }

    @Override
    public String getInfo() {
        return super.name + ": " + super.getInfo() + ", магия, " + state;
    }

    @Override
    public void step(List<Unit> gang) {
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
