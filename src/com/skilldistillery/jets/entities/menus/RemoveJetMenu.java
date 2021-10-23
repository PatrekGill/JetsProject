package com.skilldistillery.jets.entities.menus;

import com.skilldistillery.jets.entities.*;
import java.util.Scanner;


public class RemoveJetMenu extends AirfieldIndexMenu {

    public RemoveJetMenu(Airfield airfield, Scanner scanner) {
        super(airfield,scanner);
    }

    protected void onIndexSelected(int index) {
        Jet removedJet = airfield.getListOfJets().remove(index);
        System.out.printf("\nRemoved Jet: %s\n",removedJet);
    }
}
