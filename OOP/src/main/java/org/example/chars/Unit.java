package org.example.chars;

import java.util.List;

public abstract class Unit implements UnitInterface {
    public String name;
    public int attack;
    public int protect;
    public int[] damage;
    public float health;
    public final float maxHealth;
    public int speed;
    public String state;
    public List<Unit> gang;

    public PositionUnit position;

    public Unit(int attack, int protect, int[] damage, float health, int speed, String name, String state) {
        this.attack = attack;
        this.protect = protect;
        this.damage = damage;
        this.health = health / 2;
        this.maxHealth = health;
        this.speed = speed;
        this.state = state;
        this.name = name;
    }

    public PositionUnit getPositionUnit() {
        return position;
    }

    @Override
    public String getInfo() {
        return "а:" + attack + ", з:" + protect + ", у:" + (damage[0] + damage[1]) / 2 + ", зд:"
                + health + ", с:" + speed;
    }

    @Override
    public void step(List<Unit> gang) {
//        int insex = 0;
//        float distance  = Float.MAX_VALUE;
//        for (int i = 0; i < gang.size(); i++) {
//
//        }
//        position.x++;
    }

    public String getName() {
        return name;
    }

    public float getHealth() {
        return health;
    }

}
