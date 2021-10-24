package com.skilldistillery.jets.entities.menus;

import java.util.Scanner;

import com.skilldistillery.jets.entities.Airfield;
import com.skilldistillery.jets.entities.Jet;


public class AddJetMenu extends SelectionMenu {
    private final Airfield airfield;

    public AddJetMenu(Airfield airfield, Scanner scanner) {
        super(scanner);
        this.airfield = airfield;
    }

    @Override
    protected void printMainMenu() {
        System.out.println("\n==================================");
        System.out.println("1. Input new jet");
        System.out.println("2. Return to main airfield menu");
        System.out.println("==================================");
    }

    @Override
    protected boolean selectMainMenuOption(int optionNumber) {
        boolean quit = false;
        switch (optionNumber) {
            case 1: {
                inputJetMenu();
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

    private void inputJetMenu() {
        System.out.println("\nJet Input Menu:");
        String type = null;
        int selectedOption;
        do {
            printJetTypeMenu();
            selectedOption = getNextInt("Select Jet Type: ");
            type = getJetType(selectedOption);
        } while (type == null);

        String model = getNextLine("Enter in the jet's Model (no commas): ");
        double speed = getNextDouble("Enter in the jet's speed in MPH: ");
        int range = getNextInt("Enter in the jet's range in miles: ");
        long price = getNextLong("Enter in the jet's price in USD: ");

        Jet jet = airfield.createJetOfType(type, model, speed, range, price);
        if (jet != null) {
            System.out.println("Created Jet:");
            System.out.println(jet);

        } else {
            System.out.println("An error occurred creating the jet...");

        }

        System.out.println();// space
    }

    private void printJetTypeMenu() {
        System.out.println("\n==================================");
        System.out.println("Jet Types Menu");
        System.out.println("1. Cargo");
        System.out.println("2. VTOL");
        System.out.println("3. Passenger");
        System.out.println("4. Generic");
        System.out.println("==================================");
    }

    private String getJetType(int optionNumber) {
        String type = null;
        switch (optionNumber) {
            case 1: {
                type = "passenger";
                break;
            }
            case 2: {
                type = "vtol";
                break;
            }
            case 3: {
                type = "cargo";
                break;
            }
            case 4: {
                type = "generic";
                break;
            }

            default: {
                System.out.println("Did not recognize option number: " + optionNumber + "\n");
            }
        }

        return type;
    }
}

