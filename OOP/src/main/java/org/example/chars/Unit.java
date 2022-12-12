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
    public List<Unit> gang, side;

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
        this.state = "Стоит";
    }

    public PositionUnit getPositionUnit() {
        return position;
    }

    public float calcDamage(Unit unit) {
        if (unit.protect - this.attack == 0) {
            return (this.damage[0] + this.damage[1]) / 2.0f;
        }
        if (unit.protect - this.attack < 0) {
            return this.damage[1];
        }
        return this.damage[0];
    }

    public void getDamage(float damage) {
        health -= damage;
        if (health<=0){
            health=0;
            state = "Погиб мучительной смертью";
        }
    }

    @Override
    public String getInfo() {
        return "а:" + attack + ", з:" + protect + ", у:" + (damage[0] + damage[1]) / 2 + ", зд:"
                + health + ", с:" + speed;
    }

    @Override
    public void step() {
//        int insex = 0;
//        float distance  = Float.MAX_VALUE;
//        for (int i = 0; i < gang.size(); i++) {
//
//        }
//        position.x++;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public float getHealth() {
        return health;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
