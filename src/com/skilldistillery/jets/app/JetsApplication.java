package com.skilldistillery.jets.app;

import com.skilldistillery.jets.entities.*;
import com.skilldistillery.jets.entities.menus.*;
import com.skilldistillery.jets.entities.parser.*;

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

		PilotsFileParser pilotsFileParser = new PilotsFileParser("pilot_names.txt", jetApp.airfield);
		pilotsFileParser.parseFile();

		JetsFileParser jetsFileParser = new JetsFileParser("jets.txt",jetApp.airfield);
		jetsFileParser.parseFile();

		AirfieldMainMenu airfieldMainMenu = new AirfieldMainMenu(jetApp.airfield,jetApp.getScanner());
		airfieldMainMenu.openMenu();
		jetApp.closeJetApp();

	}

	private void closeJetApp() {
		getScanner().close();
	}

	public Airfield getAirfield() {
		return airfield;
	}
}

