package com.skilldistillery.jets.entities.menus;

import java.util.Scanner;

public abstract class Menu {
    private final Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public Scanner getScanner() {
        return scanner;
    }

    protected abstract void openMenu();

    protected void printInvalidEntry() {
        System.out.println("Invalid entry, try again please...\n");
    }

    protected int getNextInt(String prompt) {
        int input;
        boolean hasNext;
        while (true) {
            System.out.print(prompt);

            hasNext = scanner.hasNextInt();
            if (hasNext) {
                input = scanner.nextInt();
                scanner.nextLine();

                break;

            } else {
                printInvalidEntry();
                scanner.nextLine();

            }
        }
        return input;
    }

    protected double getNextDouble(String prompt) {
        double input;
        boolean hasNext;
        while (true) {
            System.out.print(prompt);

            hasNext = scanner.hasNextDouble();
            if (hasNext) {
                input = scanner.nextDouble();
                scanner.nextLine();

                break;

            } else {
                printInvalidEntry();
                scanner.nextLine();

            }
        }

        return input;
    }

    protected long getNextLong(String prompt) {
        long input;
        boolean hasNext;
        while (true) {
            System.out.print(prompt);

            hasNext = scanner.hasNextLong();
            if (hasNext) {
                input = scanner.nextLong();
                scanner.nextLine();

                break;

            } else {
                printInvalidEntry();
                scanner.nextLine();

            }
        }

        return input;
    }

    protected String getNextLine(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextLine()) {
                input = scanner.nextLine();
                break;

            } else {
                printInvalidEntry();

            }
        }

        return input;
    }
}

