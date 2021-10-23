package com.skilldistillery.jets.entities;

public abstract class SelectionMenu extends Menu {

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