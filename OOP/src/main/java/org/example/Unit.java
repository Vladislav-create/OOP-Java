package org.example;

import org.example.chars.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Unit implements UnitInterface {
    public int attack;
    public int protect;
    public int[] damage;
    public float health;
    public final float maxHealth;
    public int speed;
    public String state;
    public List<Unit> gang;

    public Unit(int attack, int protect, int[] damage, float health, int speed, String state) {
        this.attack = attack;
        this.protect = protect;
        this.damage = damage;
        this.health = health / 2;
        this.maxHealth = health;
        this.speed = speed;
        this.state = state;
    }

    @Override
    public String getInfo() {
        return "атака:" + attack + ", защита:" + protect + ", урон:" + (damage[0] + damage[1]) / 2 + ", здоровье:"
                + health + ", скорость:" + speed;
    }

    @Override
    public void step() {

    }

}
