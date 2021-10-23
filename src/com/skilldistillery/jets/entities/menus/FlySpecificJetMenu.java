package com.skilldistillery.jets.entities.menus;

import com.skilldistillery.jets.entities.*;
import java.util.Scanner;

public class FlySpecificJetMenu extends AirfieldIndexMenu {

    public FlySpecificJetMenu(Airfield airfield, Scanner scanner) {
        super(airfield,scanner);
    }

    protected void onIndexSelected(int index) {
        Jet jetToFly = airfield.getListOfJets().get(index);
        System.out.println("Flying Jet...");
        jetToFly.fly();
    }
}
