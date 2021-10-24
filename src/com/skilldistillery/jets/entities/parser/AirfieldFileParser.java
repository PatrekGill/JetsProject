package com.skilldistillery.jets.entities.parser;

import com.skilldistillery.jets.entities.Airfield;

public abstract class AirfieldFileParser extends FileParser {
    private final Airfield airfieldToAddTo;

    protected AirfieldFileParser(String fileToParse, Airfield airfieldToAddTo) {
        super(fileToParse);
        this.airfieldToAddTo = airfieldToAddTo;
    }

    public Airfield getAirfieldToAddTo() {
        return airfieldToAddTo;
    }
}