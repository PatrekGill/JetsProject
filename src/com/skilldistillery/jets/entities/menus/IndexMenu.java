package com.skilldistillery.jets.entities.menus;

import java.util.List;
import java.util.Scanner;

public abstract class IndexMenu<T> extends Menu {
    protected final List<T> listToIndex;

    protected IndexMenu(List<T> listToIndex, Scanner scanner) {
        super(scanner);
        this.listToIndex = listToIndex;
    }

    public void openMenu() {
        if (!listToIndex.isEmpty()) {
            int index;

            do {
                printSelectionMenu();
                index = getNextInt("Index to select: ");

                if (index == -1) {
                    break;

                } else if (index >= listToIndex.size() || index < 0) {
                    System.out.println("Invalid option");

                } else {
                    onIndexSelected(index);
                }

            } while (!listToIndex.isEmpty());

        } else {
            System.out.println("The list is empty...\n");
        }

    }

    private void printSelectionMenu() {
        System.out.println(); // space
        for (int i = 0; i < listToIndex.size(); i++) {
            System.out.printf("%s. %s\n",i,listToIndex.get(i));
        }
        System.out.println("\nType -1 to quit index menu");
    }

    protected abstract void onIndexSelected(int index);
}
