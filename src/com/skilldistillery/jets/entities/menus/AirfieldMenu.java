package com.skilldistillery.jets.entities.menus;

import java.util.Scanner;

import com.skilldistillery.jets.entities.Airfield;
import com.skilldistillery.jets.entities.CargoCarrier;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.PassengerInterface;
import com.skilldistillery.jets.entities.VtolInterface;

public class AirfieldMenu extends SelectionMenu {
    private Airfield airfield;

    public AirfieldMenu(Airfield airfield, Scanner scanner) {
        super(scanner);
        this.airfield =  airfield;
    }

    @Override
    protected void printMainMenu() {
        System.out.println("\n==============================");
        System.out.println("Main Menu:");
        System.out.println("1. List fleet");
        System.out.println("2. Fly all jets");
        System.out.println("3. View fastest jet");
        System.out.println("4. View jet with longest range");
        System.out.println("5. Load all Cargo Jets");
        System.out.println("6. Board Passenger Jets");
        System.out.println("7. Tell VTOL Jets to takeoff");
        System.out.println("8. Add a jet to Fleet");
        System.out.println("9. Remove a jet from Fleet");
        System.out.println("10. Quit");
        System.out.println("==============================\n");
    }

    @Override
    protected boolean selectMainMenuOption(int optionNumber) {
        boolean quit = false;
        switch (optionNumber) {
            case 1: {
                printFleetList();
                break;
            }
            case 2: {
                flyAllJets();
                break;
            }
            case 3: {
                printFastestJet();
                break;
            }
            case 4: {
                printJetWithLongestRange();
                break;
            }
            case 5: {
                loadAllCargoJets();
                break;
            }
            case 6: {
                boardAllPassengerJets();
                break;
            }
            case 7: {
                tellAllVtolToTakeoff();
                break;
            }
            case 8: {
                openAddJetMenu();
                break;
            }
            case 9: {

                break;
            }
            case 10: {
                quit = true;
                System.out.println("System stopping, goodbye.");
                break;
            }

            default: {
                System.out.println("Did not recognize option number: " + optionNumber + "\n");
            }

        }

        return quit;
    }

    private void printFleetList() {
        if (airfield.getListOfJets().isEmpty()){
            printEmptyListMessage();

        } else {
            for (Jet aircraft : airfield.getListOfJets()) {
                System.out.println(aircraft);
            }
        }
    }

    private void flyAllJets() {
        if (airfield.getListOfJets().isEmpty()){
            printEmptyListMessage();

        } else {
            for (Jet aircraft : airfield.getListOfJets()) {
                aircraft.fly();
            }
        }
    }

    private void printFastestJet() {
        if (airfield.getListOfJets().isEmpty()){
            printEmptyListMessage();

        } else {
            Jet fastestJet = airfield.getListOfJets().get(0);
            double fastestSpeed = fastestJet.getSpeed();

            for (Jet aircraft : airfield.getListOfJets()) {
                if (aircraft.getSpeed() > fastestSpeed) {
                    fastestSpeed = aircraft.getSpeed();
                    fastestJet = aircraft;
                }
            }

            System.out.printf("The fastest jet is the: %s with a top speed of: %s MPH\n",fastestJet.getModel(),fastestSpeed);
        }
    }

    private void printJetWithLongestRange() {
        if (airfield.getListOfJets().isEmpty()){
            printEmptyListMessage();

        } else {
            Jet jetWithLongestRange = airfield.getListOfJets().get(0);
            int longestRange = jetWithLongestRange.getRange();

            for (Jet aircraft : airfield.getListOfJets()) {
                if (aircraft.getRange() > longestRange) {
                    jetWithLongestRange = aircraft;
                }
            }

            System.out.printf("The jet with the longest range is the: %s with a range of: %s miles\n", jetWithLongestRange.getModel(), longestRange);
        }
    }

    private void loadAllCargoJets() {
        if (airfield.getListOfJets().isEmpty()){
            printEmptyListMessage();

        } else {
            for (Jet aircraft : airfield.getListOfJets()) {
                if (aircraft instanceof CargoCarrier) {
                    ((CargoCarrier) aircraft).loadCargo();
                }
            }
        }
    }

    private void tellAllVtolToTakeoff() {
        if (airfield.getListOfJets().isEmpty()){
            printEmptyListMessage();

        } else {
            for (Jet aircraft : airfield.getListOfJets()) {
                if (aircraft instanceof VtolInterface) {
                    ((VtolInterface) aircraft).enterVerticalMode();
                }
            }
        }
    }

    private void boardAllPassengerJets() {
        if (airfield.getListOfJets().isEmpty()){
            printEmptyListMessage();

        } else {
            for (Jet aircraft : airfield.getListOfJets()) {
                if (aircraft instanceof PassengerInterface) {
                    ((PassengerInterface) aircraft).boardPassengers();
                }
            }
        }
    }

    private void openAddJetMenu() {
        AddJetMenu addJetMenu = new AddJetMenu(airfield, getScanner());
        addJetMenu.openMenu();
    }

    private void printEmptyListMessage() {
        System.out.println("This list is empty...");
    }

}
