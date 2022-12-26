package org.example;

import org.example.chars.*;

import java.util.*;

public class Main {
    public static final int GANG_SIZE = 6;
    public static List<Unit> whiteSide;
    public static List<Unit> darkSide;


    public static void main(String[] args) {
        init();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            ConsoleView.view();

            turnMove();

            scanner.nextLine();

        }
    }

    private static void turnMove() {
        List<Unit> allUnits = new ArrayList<>();
        allUnits.addAll(whiteSide);
        allUnits.addAll(darkSide);
        allUnits.sort(new Comparator<Unit>() {
            @Override
            public int compare(Unit o1, Unit o2) {
                int tmp = o2.getSpeed() - o1.getSpeed();
                return tmp;
            }
        });
        allUnits.forEach(UnitInterface::step);
    }

    public static void init() {
        int x = 1;
        int y = 1;

        whiteSide = new ArrayList<>();
        darkSide = new ArrayList<>();

        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case 0 -> {
                    whiteSide.add(new Crossbowman(whiteSide, darkSide, x, y++));
                    break;
                }
                case 1 -> {
                    whiteSide.add(new Monk(whiteSide, darkSide, x, y++));
                    break;
                }
                case 2 -> {
                    whiteSide.add(new Spearman(whiteSide, darkSide, x, y++));
                    break;
                }
                default -> whiteSide.add(new Peasant(whiteSide, darkSide, x, y++));
            }
        }
        x = GANG_SIZE;
        y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case 0 -> {
                    darkSide.add(new Robber(darkSide, whiteSide, x, y++));
                    break;
                }
                case 1 -> {
                    darkSide.add(new Wizard(darkSide, whiteSide, x, y++));
                    break;
                }
                case 2 -> {
                    darkSide.add(new Sniper(darkSide, whiteSide, x, y++));
                    break;
                }
                default -> darkSide.add(new Peasant(darkSide, whiteSide, x, y++));
            }
        }

//        whiteSide.forEach(unit -> System.out.println(unit.getInfo()));

    }
}

