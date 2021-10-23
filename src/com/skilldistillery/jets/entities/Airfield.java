package com.skilldistillery.jets.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Airfield {
    private List<Jet> listOfJets;

    public Airfield() {
        listOfJets = new ArrayList<>();
    }

    public List<Jet> getListOfJets() {
        return listOfJets;
    }

    public Jet createJetOfType(String jetType, String model, double speed, int range, long price) {
        Jet jet = null;

        switch (jetType.toLowerCase()) {
            case "passenger": {
                jet = new PassengerPlane(model,speed,range,price);
                break;
            }
            case "cargo": {
                jet = new CargoPlane(model,speed,range,price);
                break;
            }
            case "vtol": {
                jet = new VtolPlane(model,speed,range,price);
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

        return jet;
    }

    public void printAirfieldFleetIndexMenu() {
        System.out.println(); // space
        for (int i = 0; i < listOfJets.size(); i++) {
            System.out.printf("%s. %s\n",i,listOfJets.get(i));
        }
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Airfield [listOfJets= ");
		builder.append(listOfJets);
		builder.append(" ]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(listOfJets);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airfield other = (Airfield) obj;
		return Objects.equals(listOfJets, other.listOfJets);
	}
    
    
}

