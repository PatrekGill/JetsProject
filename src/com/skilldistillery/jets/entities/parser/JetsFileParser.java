package com.skilldistillery.jets.entities.parser;

import com.skilldistillery.jets.entities.*;
import java.util.Arrays;


public class JetsFileParser extends AirfieldFileParser {
    public JetsFileParser(String fileToParse, Airfield airfieldToAddTo) {
        super(fileToParse,airfieldToAddTo);
    }

    @Override
    protected void onLineRead(String line) {
        String[] jetInfo = line.split(",");
        parseJet(jetInfo);
    }

    private void parseJet(String[] jetInfo) {
        if (jetInfo.length != 5) {
            System.out.println("Could not find 5 fields for jet configuration with following info in " + getFileToParse() + ":");
            System.out.println(Arrays.toString(jetInfo));
            System.out.println(); // just a space

        } else {
            getAirfieldToAddTo().createJetOfType(
                    jetInfo[4],
                    jetInfo[0],
                    Double.parseDouble(jetInfo[1]),
                    Integer.parseInt(jetInfo[2]),
                    Long.parseLong(jetInfo[3])
            );

        }
    }
}