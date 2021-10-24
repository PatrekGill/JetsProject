package com.skilldistillery.jets.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Airfield {
    private final List<Jet> listOfJets;
    private final List<Pilot> listOfPilots;

    public Airfield() {
        listOfJets = new ArrayList<>();
        listOfPilots = new ArrayList<>();
    }

    public List<Jet> getListOfJets() {
        return listOfJets;
    }
    public List<Pilot> getListOfPilots() {
        return listOfPilots;
    }
    public Pilot getUnassignedPilot() {
        Pilot pilotToReturn = null;
        for (Pilot pilot: listOfPilots) {
            if (pilot.getJet() == null) {
                pilotToReturn = pilot;
            }
        }

        return pilotToReturn;
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
            if (!listOfPilots.isEmpty()) {
                Pilot pilotToAssign = getUnassignedPilot();
                if (pilotToAssign != null) {
                    jet.setPilot(pilotToAssign);
                    pilotToAssign.setJet(jet);
                }
            }
        }

        return jet;
    }

	@Override
	public int hashCode() {
		return Objects.hash(listOfJets, listOfPilots);
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
		return Objects.equals(listOfJets, other.listOfJets) && Objects.equals(listOfPilots, other.listOfPilots);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Airfield [listOfJets=");
		builder.append(listOfJets);
		builder.append(", listOfPilots=");
		builder.append(listOfPilots);
		builder.append("]");
		return builder.toString();
	}


}

