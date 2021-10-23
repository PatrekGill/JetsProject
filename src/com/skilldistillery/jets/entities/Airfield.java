package com.skilldistillery.jets.entities;

import java.util.ArrayList;
import java.util.List;

public class Airfield {
    private List<Jet> listOfJets;

    public Airfield() {
        listOfJets = new ArrayList<>();
    }

    public List<Jet> getListOfJets() {
        return listOfJets;
    }

    public void createJetOfType(String jetType, String model, double speed, int range, long price) {
        Jet jet = null;

        switch (jetType.toLowerCase()) {
            case "passenger": {
                jet = new PassengerPlane(model,speed,range,price);
                break;
            }
            case "cargo": {
                jet = new VtolPlane(model,speed,range,price);
                break;
            }
            case "vtol": {
                jet = new CargoPlane(model,speed,range,price);
                break;
            }
            case "generic": {
                jet = new GenericPlane(model,speed,range,price);
                break;
            }

            default: {
                System.out.println("Aircraft type: " + jetType + " is undefined. Please make changes to your input.");
            }
        }

        if (jet != null) {
            listOfJets.add(jet);
        }
    }

    // TODO - .toString
    // TODO - .equals and .hashCode
}

