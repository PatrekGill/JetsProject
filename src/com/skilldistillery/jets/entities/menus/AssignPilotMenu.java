package com.skilldistillery.jets.entities.menus;

import com.skilldistillery.jets.entities.*;

import java.util.List;
import java.util.Scanner;



public class AssignPilotMenu extends IndexMenu<Pilot> {
    private final Airfield airfield;

    protected AssignPilotMenu(Airfield airfield, Scanner scanner) {
        super(airfield.getListOfPilots(), scanner);
        this.airfield = airfield;
    }

    @Override
    protected void onIndexSelected(int index) {
        Pilot selectedPilot = listToIndex.get(index);
        Jet jetToAssign = selectJetToPilot();

        if (jetToAssign != null) {

            System.out.println(); // space

            Pilot previousPilot = jetToAssign.getPilot();
            if (previousPilot != null) {
                System.out.println("Unassigning jet from pilot: " + previousPilot.getName());
                previousPilot.setJet(null);
            }
            jetToAssign.setPilot(selectedPilot);


            Jet previousJet = selectedPilot.getJet();
            if (previousJet != null) {
                System.out.println("Unassigning pilot from jet: " + previousJet);
                previousJet.setPilot(null);
            }
            selectedPilot.setJet(jetToAssign);

        }
    }

    private Jet selectJetToPilot() {
        Jet jetToAssign = null;
        int index;
        while (true) {

            System.out.println("\nSelect Jet: (-1 to cancel)");
            List <Jet> listOfJets = airfield.getListOfJets();
            for (int i = 0; i < listOfJets.size(); i++) {
                System.out.printf("%s. %s\n",i,listOfJets.get(i));
            }

            index = getNextInt("Index to select: ");

            if (index == -1) {
                break;

            } else if (index >= listOfJets.size() || index < 0) {
                System.out.println("Invalid option");

            } else {
                jetToAssign = listOfJets.get(index);
                break;
            }

        };

        return jetToAssign;
    }
}
