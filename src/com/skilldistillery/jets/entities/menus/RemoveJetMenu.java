package com.skilldistillery.jets.entities.menus;

import com.skilldistillery.jets.entities.*;

import java.util.Scanner;


public class RemoveJetMenu extends SelectionMenu {
    private final Airfield airfield;

    public RemoveJetMenu(Airfield airfield, Scanner scanner) {
        super(scanner);
        this.airfield = airfield;
    }

    @Override
    protected void printMainMenu() {
        System.out.println("\n==================================");
        System.out.println("1. Remove a jet from the airfield");
        System.out.println("2. Return to main airfield menu");
        System.out.println("==================================");
    }

    @Override
    protected boolean selectMainMenuOption(int optionNumber) {
        boolean quit = false;
        switch (optionNumber) {
            case 1: {
                removeJetMenu();
                break;
            }
            case 2: {
                quit = true;
                break;
            }

            default: {
                System.out.println("Did not recognize option number: " + optionNumber + "\n");
            }
        }

        return quit;
    }

    private void removeJetMenu() {
        if (!airfield.getListOfJets().isEmpty()) {
            Jet removedJet = null;
            int index;

            do {
                airfield.printAirfieldFleetIndexMenu();
                System.out.println("\nType -1 to quit removal menu");
                index = getNextInt("Index to remove: ");

                if (index == -1) {
                    break;

                } else if (index >= airfield.getListOfJets().size() || index < 0) {
                    System.out.println("That index is not available to remove...");

                } else {
                    removedJet = airfield.getListOfJets().remove(index);
                    System.out.printf("\nRemoved Jet: %s\n",removedJet);
                }

            } while (removedJet == null);

        } else {
            System.out.println("The airfield has no jets to remove...\n");
        }

    }
}

