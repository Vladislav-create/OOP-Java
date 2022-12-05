package org.example;

import org.example.chars.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int GANG_SIZE = 5;
    public static List<Unit> whiteSide;
    public static List<Unit> darkSide;


    public static void main(String[] args) {

        init();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            ConsoleView.view();

            whiteSide.forEach(unit -> unit.step(darkSide));
            darkSide.forEach(unit -> unit.step(whiteSide));

            scanner.nextLine();

        }



    }

    public static void init() {
        int x = 1;
        int y = 1;

        whiteSide = new ArrayList<>();
        darkSide = new ArrayList<>();

        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case 0 -> {
                    whiteSide.add(new Crossbowman(whiteSide, x, y++));
                    break;
                }
                case 1 -> {
                    whiteSide.add(new Monk(whiteSide, x, y++));
                    break;
                }
                case 2 -> {
                    whiteSide.add(new Spearman(whiteSide, x, y++));
                    break;
                }
                default -> whiteSide.add(new Peasant(whiteSide, x, y++));
            }
        }
        x = GANG_SIZE;
        y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case 0 -> {
                    darkSide.add(new Robber(darkSide, x, y++));
                    break;
                }
                case 1 -> {
                    darkSide.add(new Wizard(darkSide, x, y++));
                    break;
                }
                case 2 -> {
                    darkSide.add(new Sniper(darkSide, x, y++));
                    break;
                }
                default -> darkSide.add(new Peasant(darkSide, x, y++));
            }
        }

//        whiteSide.forEach(unit -> System.out.println(unit.getInfo()));

    }
}

