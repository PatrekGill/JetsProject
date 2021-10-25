package com.skilldistillery.jets.entities.menus;

import com.skilldistillery.jets.entities.*;
import java.util.List;
import java.util.Scanner;

public class FlySpecificJetMenu extends IndexMenu<Jet> {

    public FlySpecificJetMenu(List<Jet> listToIndex, Scanner scanner) {
        super(listToIndex,scanner);
    }

    protected void onIndexSelected(int index) {
        Jet jetToFly = listToIndex.get(index);
        System.out.println("\nFlying Jet...");
        jetToFly.fly();
    }
}
