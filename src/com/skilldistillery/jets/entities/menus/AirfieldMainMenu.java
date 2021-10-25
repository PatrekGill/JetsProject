package com.skilldistillery.jets.entities.menus;

import com.skilldistillery.jets.entities.*;
import java.util.Scanner;

public class AirfieldMainMenu extends SelectionMenu {
    private final Airfield airfield;

    public AirfieldMainMenu(Airfield airfield, Scanner scanner) {
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
        System.out.println("10. Fly specific jet in Fleet");
        System.out.println("11. Assign pilots to jets");
        System.out.println("12. Save jets to file");
        System.out.println("13. Quit");
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
                openRemoveJetMenu();
                break;
            }
            case 10: {
                openFlySpecificJetMenu();
                break;
            }
            case 11: {
                openAssignPilotsMenu();
                break;
            }
            case 12: {
            	openSaveJetsMenu();
                break;
            }
            case 13: {
                quit = true;
                System.out.println("System stopping, goodbye.");
                break;
            }

            default: {
                printInvalidOptionSelected(optionNumber);
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
            System.out.println(fastestJet);
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
            System.out.println(jetWithLongestRange);
        }
    }

    private void loadAllCargoJets() {
        if (airfield.getListOfJets().isEmpty()){
            printEmptyListMessage();

        } else {
            boolean foundCargoJet = false;
            for (Jet aircraft : airfield.getListOfJets()) {
                if (aircraft instanceof CargoCarrier) {
                    ((CargoCarrier) aircraft).loadCargo();
                    foundCargoJet = true;
                }
            }

            if (!foundCargoJet) {
                System.out.println("Found no cargo jets to load...");
            }
        }
    }

    private void tellAllVtolToTakeoff() {
        if (airfield.getListOfJets().isEmpty()){
            printEmptyListMessage();

        } else {
            boolean foundVtolJet = false;
            for (Jet aircraft : airfield.getListOfJets()) {
                if (aircraft instanceof VtolInterface) {
                    ((VtolInterface) aircraft).enterVerticalMode();
                    foundVtolJet = true;
                }
            }

            if (!foundVtolJet) {
                System.out.println("Found no VTOL jets to takeoff...");
            }
        }
    }

    private void boardAllPassengerJets() {
        if (airfield.getListOfJets().isEmpty()){
            printEmptyListMessage();

        } else {
            boolean foundPassengerJet = false;
            for (Jet aircraft : airfield.getListOfJets()) {
                if (aircraft instanceof PassengerInterface) {
                    ((PassengerInterface) aircraft).boardPassengers();
                    foundPassengerJet = true;
                }
            }

            if (!foundPassengerJet) {
                System.out.println("Found no passenger jets for passengers to board...");
            }
        }
    }

    private void openAddJetMenu() {
        AddJetMenu addJetMenu = new AddJetMenu(airfield, getScanner());
        addJetMenu.openMenu();
    }

    private void openRemoveJetMenu() {
    	if (airfield.getListOfJets().isEmpty()) {
    		printEmptyListMessage();
    		
    	} else {
    		RemoveJetMenu removeJetMenu = new RemoveJetMenu(airfield, getScanner());
            removeJetMenu.openMenu();
            
    	}
        
    }

    private void openFlySpecificJetMenu() {
    	if (airfield.getListOfJets().isEmpty()) {
    		printEmptyListMessage();
    		
    	} else {
    		FlySpecificJetMenu flySpecificJetMenu = new FlySpecificJetMenu(airfield.getListOfJets(), getScanner());
            flySpecificJetMenu.openMenu();
    		
    	}
        
    }

    private void openAssignPilotsMenu() {
        if (airfield.getListOfJets().isEmpty()) {
            System.out.println("The jets menu does not have any jets...");
            return;
        }
        if (airfield.getListOfPilots().isEmpty()) {
            System.out.println("There are no pilots to assign to jets...");
            return;
        }

        AssignPilotMenu assignPilotMenu = new AssignPilotMenu(airfield,getScanner());
        assignPilotMenu.openMenu();
    }
    
    private void openSaveJetsMenu() {
    	if (airfield.getListOfJets().isEmpty()) {
    		printEmptyListMessage();
    		
    	} else {
    		SaveJetsMenu saveJetsMenu = new SaveJetsMenu(airfield.getListOfJets(), getScanner());
        	saveJetsMenu.openMenu();
        	
    	}
    	
    }

    private void printEmptyListMessage() {
        System.out.println("This list is empty...");
    }

}

