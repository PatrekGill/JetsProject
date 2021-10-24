package com.skilldistillery.jets.entities.menus;

import com.skilldistillery.jets.entities.*;
import java.util.Scanner;


public class RemoveJetMenu extends IndexMenu<Jet> {
    private final Airfield airfield;

    public RemoveJetMenu(Airfield airfield, Scanner scanner) {
        super(airfield.getListOfJets(),scanner);
        this.airfield = airfield;
    }

    protected void onIndexSelected(int index) {
        Jet removedJet = airfield.getListOfJets().remove(index);
        System.out.printf("\nRemoved Jet: %s\n",removedJet);

        Pilot pilot = removedJet.getPilot();
        if (pilot != null) {
            pilot.setJet(null);
            System.out.println("Removed jet from pilot: " + pilot.getName());
        }
    }
}
