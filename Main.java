import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        List<Unit> units = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            units.add(getUnit());
        }
        getType(units, "МОНАХ:");
        // units.forEach(unit -> System.out.println(unit.toString()));
    }

    private static Unit getUnit() {
        int num = new Random().nextInt(7);
        return switch (num) {
            case 0 -> new Peasant();
            case 1 -> new Robber();
            case 2 -> new Sniper();
            case 3 -> new Wizard();
            case 4 -> new Spearman();
            case 5 -> new Crossbowman();
            default -> new Monk();
        };
    }

    private static void getType(List<Unit> units, String type){
        List<Unit> result = new ArrayList<>();
        for (Unit unit : units) {
            if (unit.toString().split(" ")[0].equals(type)){
                result.add(unit);
                System.out.println(unit);
            }
        }
        
    }
}