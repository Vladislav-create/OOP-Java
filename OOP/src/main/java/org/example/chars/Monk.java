package org.example.chars;

import org.example.Unit;

import java.util.List;

public class Monk extends Unit {

    private boolean magic;

    public Monk(List<Unit> gang) {
        super(12, 7, new int[] { -4, -4 }, 30, 5, "Stand");
        magic = true;
        super.gang = gang;
    }

    @Override
    public String getInfo() {
        return "Monk:  " + super.getInfo() + ", магия, " + state + "\n";
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
