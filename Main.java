import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final int GANG_SIZE = 5;

    public static void main(String[] args) {
        List<Unit> darkSide = new ArrayList<>();
        List<Unit> whiteSide = new ArrayList<>();

        while (whiteSide.size() < GANG_SIZE) {
            darkSide.add(getUnit(0, darkSide));
            whiteSide.add(getUnit(3, whiteSide));
        }

        System.out.println();
        darkSide.forEach(unit -> System.out.println(unit.getInfo()));
        System.out.println();
        whiteSide.forEach(unit -> System.out.println(unit.getInfo()));
        System.out.println();
        System.out.println();
        darkSide.forEach(Unit::step);
        whiteSide.forEach(Unit::step);
        
        darkSide.forEach(unit -> System.out.println(unit.getInfo()));
        System.out.println();
        whiteSide.forEach(unit -> System.out.println(unit.getInfo()));
        System.out.println();
    }

    private static Unit getUnit(int origin, List<Unit> side) {

        int num = new Random().nextInt(origin, origin + 4);
        return switch (num) {

            case 0 -> new Robber();
            case 1 -> new Sniper();
            case 2 -> new Wizard(side);
            case 3 -> new Peasant();
            case 4 -> new Spearman();
            case 5 -> new Crossbowman();
            default -> new Monk(side);
        };
    }

    // private static void getType(List<Unit> units, String type) {
    // List<Unit> result = new ArrayList<>();
    // for (Unit unit : units) {
    // if (unit.toString().split(" ")[0].equals(type)) {
    // result.add(unit);
    // System.out.println(unit);
    // }
    // }

    // }
}