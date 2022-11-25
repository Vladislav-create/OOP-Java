import java.util.List;

public class Wizard extends Unit {

    private boolean magic;

    public Wizard(List<Unit> gang) {
        super(17, 12, new int[] { -5, -5 }, 30, 9, "Stand");
        magic = true;
        super.gang = gang;
    }

    @Override
    public String getInfo() {
        return "КОЛДУН:  " + super.getInfo() + ", Магия, " + state + "\n";
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
