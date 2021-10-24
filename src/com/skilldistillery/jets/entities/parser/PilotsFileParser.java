package com.skilldistillery.jets.entities.parser;

import com.skilldistillery.jets.entities.*;

public class PilotsFileParser extends AirfieldFileParser {
    public PilotsFileParser(String fileToParse,Airfield airfieldToAddTo) {
        super(fileToParse,airfieldToAddTo);
    }

    @Override
    protected void onLineRead(String line) {
        Pilot pilot = new Pilot(line);
        getAirfieldToAddTo().getListOfPilots().add(pilot);
    }
}