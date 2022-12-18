package org.example.chars;

import java.util.List;
import java.util.Random;

public abstract class Unit implements UnitInterface {
    protected String name;
    protected int attack;
    protected int protect;
    protected int[] damage;
    protected float health;
    protected final float maxHealth;
    protected int speed;
    protected String state;
    protected List<Unit> gang, side;
    protected PositionUnit position;
    protected int quantity;

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
            return ((this.damage[0] + this.damage[1]) / 2.0f) * quantity;
        }
        if (unit.protect - this.attack < 0) {
            return this.damage[1] * quantity;
        }
        return this.damage[0] * quantity;
    }

    public void getDamage(float damage) {
        double tmpHealth = (quantity - 1) * maxHealth + health;
        tmpHealth -= damage;
        if (tmpHealth <= 0) {
            this.health = 0;
            state = "Погиб мучительной смертью";
            quantity = 0;
        } else {
            quantity = (int) (tmpHealth / maxHealth);
            health = maxHealth;
            if (tmpHealth % maxHealth > 0) {
                quantity++;
                health = (float) (tmpHealth % maxHealth);
            }
        }
    }

    @Override
    public String getInfo() {
        return "Кол-во: " + quantity + "   а:" + attack + ", з:" + protect + ", у:" + ((damage[0] + damage[1]) / 2) * quantity + ", зд:"
                + (health * quantity) + ", с:" + speed;
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
