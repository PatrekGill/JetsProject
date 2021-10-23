package com.skilldistillery.jets.app;

import com.skilldistillery.jets.entities.*;
import com.skilldistillery.jets.entities.menus.AirfieldMainMenu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class JetsApplication {
	private final Airfield airfield;
	private final Scanner scanner;

	public JetsApplication() {
		 airfield = new Airfield();
		 this.scanner = new Scanner(System.in);
	}

	private Scanner getScanner() {
		return scanner;
	}

	public static void main(String[] args) {

		JetsApplication jetApp = new JetsApplication();

		try ( BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt")) ) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] jetInfo = line.split(", ");
				jetApp.parseJet(jetInfo);
				//System.out.println(line);
			}
		}
		catch (IOException e) {
			System.err.println(e);

		}

		AirfieldMainMenu airfieldMenu = new AirfieldMainMenu(jetApp.airfield,jetApp.getScanner());
		airfieldMenu.openMenu();
		jetApp.closeJetApp();
	}

	private void closeJetApp() {
		getScanner().close();
	}



	private void parseJet(String[] jetInfo) {
		if (jetInfo.length != 5) {
			System.out.println("Could not find 5 fields for jet configuration with following info in jets.txt:");
			System.out.println(Arrays.toString(jetInfo));
			System.out.println(); // just a space

		} else {
			airfield.createJetOfType(
				jetInfo[4],
				jetInfo[0],
				Double.parseDouble(jetInfo[1]),
				Integer.parseInt(jetInfo[2]),
				Long.parseLong(jetInfo[3])
			);

		}
	}
}

