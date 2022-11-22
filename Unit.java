public class Unit {
    protected int attack;
    protected int protect;
    protected int [] damage;
    protected float health;
    protected int speed;
    protected String state;

    public Unit(int attack, int protect, int [] damage, float health, int speed, String state) {
        this.attack = attack;
        this.protect = protect;
        this.damage = damage;
        this.health = health;
        this.speed = speed;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Атака:" + attack + ", Защита:" + protect + ", Урон:" + (damage[0]+damage[1])/2 + ", Здоровье:" + health + ", Скорость:" + speed;
    }
}
