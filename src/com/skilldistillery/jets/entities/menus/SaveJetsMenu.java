package com.skilldistillery.jets.entities.menus;

import com.skilldistillery.jets.entities.*;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class SaveJetsMenu extends SelectionMenu {
	private List<Jet> listOfJets;
	
	protected SaveJetsMenu(List<Jet> listOfJets, Scanner scanner) {
		super(scanner);
		this.listOfJets = listOfJets;
	}

	
	@Override
	protected void printMainMenu() {
		System.out.println("\n===========================");
		System.out.println("1. Open save jets menu");
		System.out.println("2. Return to previous menu");
		System.out.println("===========================");
	}


	@Override
	protected boolean selectMainMenuOption(int optionNumber) {
        boolean quit = false;
        switch (optionNumber) {
            case 1: {
            	saveMenu();
                break;
            }
            case 2: {
                quit = true;
                break;
            }

            default: {
                System.out.println("Did not recognize option number: " + optionNumber + "\n");
            }
        }

        return quit;
    }
	
	private void saveMenu() {
        
        
        String filename = null;
        do {
        	System.out.println("\nEnter in filename (with extension) to save to root of the project folder");
        	
        	filename = getNextLine("Filename: ");
        	if (filename.equalsIgnoreCase("jets.txt") || filename.equalsIgnoreCase("pilot_names.txt")) {
        		filename = null;
        		System.out.println("That file name is reserved, pick another");
        	}
        	
		} while (filename == null);

        if (verifyFile(filename)) {
        	writeJetsToFile(filename);
        }
	}
	
	
	private boolean verifyFile(String filename) {
		
		boolean allowedToWrite = true;
		
		File fileToWriteTo = new File(filename);
		if (!fileToWriteTo.exists()) {
			System.out.println("\nThe file: " + filename + " does not currently exist...");	
			
			boolean decided = false;
			int decision;
			do {
				System.out.println("1. Create file");
				System.out.println("2. Exit");
				
				decision = getNextInt("Choice: ");
				if (decision == 1) {
					decided = true;
					createFile(fileToWriteTo);
					
				} else if (decision == 2) {
					decided = true;
					allowedToWrite = false;
					
				} else {
					printInvalidOptionSelected(decision);
					
				}

			} while (!decided);
		}		
		
		return allowedToWrite;
	}
	
	private void createFile(File file) {
		try {
			
			if (file.createNewFile()) {
				System.out.println("File created: " + file.getName());
			} else {
				System.out.println("File already exists.");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	private void writeJetsToFile(String filename) {
		try {
			FileWriter fw = new FileWriter(filename);
			PrintWriter pw = new PrintWriter(fw);
			for (Jet jet : listOfJets) {
				pw.println(
					jet.getModel() + "," + 
					jet.getSpeed() + "," + 
					jet.getRange() + "," + 
					jet.getPrice() + "," + 
					jet.getJetType()
				);
			}
			
			System.out.println("Wrote to file: " + filename);
			pw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	
}
