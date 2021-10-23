package com.skilldistillery.jets.entities;

public class AddJetMenu extends SelectionMenu {
    private Airfield airfield;

    public AddJetMenu(Airfield airfield) {
        this.airfield = airfield;
    }

    protected void printMainMenu() {
        System.out.println("==================================");
        System.out.println("1. Input new jet");
        System.out.println("2. Return to main airfield menu");
        System.out.println("==================================");
    }

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
        String model = getNextLine("Enter in the jet's Model: ");
        double speed = getNextDouble("Enter in the jet's speed in MPH: ");
        int range = getNextInt("Enter in the jet's range in miles: ");
        long price = getNextLong("Enter in the jet's price in USD: ");


        airfield.createJetOfType(model);
    }

    private void printJetTypeMenu() {
        System.out.println("==================================");
        System.out.println("Jet Types Menu");
        System.out.println("1. Cargo");
        System.out.println("2. VTOL");
        System.out.println("3. Passenger");
        System.out.println("4. Generic");
        System.out.println("==================================");
    }
}

