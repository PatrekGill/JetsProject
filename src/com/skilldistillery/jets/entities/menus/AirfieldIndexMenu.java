package com.skilldistillery.jets.entities.menus;

import com.skilldistillery.jets.entities.*;
import java.util.Scanner;


public abstract class AirfieldIndexMenu extends SelectionMenu {
    protected final Airfield airfield;

    protected AirfieldIndexMenu(Airfield airfield, Scanner scanner) {
        super(scanner);
        this.airfield = airfield;
    }

    @Override
    protected void printMainMenu() {
        System.out.println("\n==================================");
        System.out.println("1. Go to index based airfield menu");
        System.out.println("2. Return to main airfield menu");
        System.out.println("==================================");
    }

    @Override
    protected boolean selectMainMenuOption(int optionNumber) {
        boolean quit = false;
        switch (optionNumber) {
            case 1: {
                openIndexMenu();
                break;
            }
            case 2: {
                quit = true;
                break;
            }

            default: {
                printInvalidOptionSelected(optionNumber);
            }
        }

        return quit;
    }

    private void openIndexMenu() {
        if (!airfield.getListOfJets().isEmpty()) {
            int index;

            do {
                airfield.printAirfieldFleetIndexMenu();
                System.out.println("\nType -1 to quit index menu");
                index = getNextInt("Index to select: ");

                if (index == -1) {
                    break;

                } else if (index >= airfield.getListOfJets().size() || index < 0) {
                    printInvalidOptionSelected(index);

                } else {
                    onIndexSelected(index);
                }

            } while (!airfield.getListOfJets().isEmpty());

        } else {
            System.out.println("The airfield has no jets...\n");
        }

    }

    protected abstract void onIndexSelected(int index);
}
