package org.example;

import org.example.chars.PositionUnit;

import java.util.Collections;
import java.util.Locale;

public class ConsoleView {

    private static int step = 1;
    private static final String topTable = formatDiv("a") + String.join("", Collections.nCopies(Main.GANG_SIZE - 1, formatDiv("-b"))) + formatDiv("-c");
    private static final String midTable = formatDiv("d") + String.join("", Collections.nCopies(Main.GANG_SIZE - 1, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottomTable = formatDiv("g") + String.join("", Collections.nCopies(Main.GANG_SIZE - 1, formatDiv("-h"))) + formatDiv("-i");


    public static void view() {

        if (step == 1) {
            System.out.println(AnsiColors.CIAN + "Первый ход" + AnsiColors.ANSI_RESET);
        } else {
            System.out.println(AnsiColors.CIAN + "Шаг " + step + AnsiColors.ANSI_RESET);
        }

        step++;

        System.out.println(ConsoleView.topTable);
        String space = "    ";
        for (int i = 1; i <= Main.GANG_SIZE - 1; i++) {

            String dataUnit = space + AnsiColors.ANSI_GREEN + Main.whiteSide.get(i - 1).getInfo() + space + AnsiColors.ANSI_BLUE + Main.darkSide.get(i - 1).getInfo() + AnsiColors.ANSI_RESET;


            for (int j = 1; j <= Main.GANG_SIZE; j++) {
                System.out.print(iconUnit(new PositionUnit(j, i)));
            }
            System.out.println("|" + dataUnit);

            System.out.println(ConsoleView.midTable);
        }
        for (int j = 1; j <= Main.GANG_SIZE; j++) {
            System.out.print(iconUnit(new PositionUnit(j, Main.GANG_SIZE)));
        }
        String dataLastUnit = space + AnsiColors.ANSI_GREEN + Main.whiteSide.get(Main.GANG_SIZE - 1).getInfo() + space + AnsiColors.ANSI_BLUE + Main.darkSide.get(Main.GANG_SIZE - 1).getInfo() + AnsiColors.ANSI_RESET;
        System.out.println("|" + dataLastUnit);

        System.out.println(ConsoleView.bottomTable);
        System.out.println("Нажмите Enter для продолжения.");
    }

    private static String iconUnit(PositionUnit position) {
        String str = "| ";
        for (int i = 0; i < Main.GANG_SIZE; i++) {

            if (Main.whiteSide.get(i).getPositionUnit().isEquals(position))
                str = "|" + AnsiColors.ANSI_GREEN + Main.whiteSide.get(i).getName().charAt(0) + AnsiColors.ANSI_RESET;
            if (Main.darkSide.get(i).getPositionUnit().isEquals(position))
                str = "|" + AnsiColors.ANSI_BLUE + Main.darkSide.get(i).getName().charAt(0) + AnsiColors.ANSI_RESET;
        }
        return str;
    }

    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }
}
