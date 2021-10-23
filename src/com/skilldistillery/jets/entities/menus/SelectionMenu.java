package com.skilldistillery.jets.entities.menus;

import java.util.Scanner;

public abstract class SelectionMenu extends Menu {

    public SelectionMenu(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void openMenu() {
        int selectedOption;
        boolean quit;
        do {
            printMainMenu();
            selectedOption = getNextInt("Select Menu Option: ");
            quit = selectMainMenuOption(selectedOption);
        } while (!quit);
    }

    protected abstract void printMainMenu();

    protected abstract boolean selectMainMenuOption(int optionNumber);
}
