package com.skilldistillery.jets.entities;

import java.util.Objects;

public class Pilot {
    private String name;
    private Jet jet;

    public Pilot(String name) {
        this.name = name;
        this.jet = null;
    }

    public Jet getJet() {
        return jet;
    }
    public void setJet(Jet jet) {
        this.jet = jet;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    

    @Override
	public int hashCode() {
		return Objects.hash(jet, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pilot other = (Pilot) obj;
		return Objects.equals(jet, other.jet) && Objects.equals(name, other.name);
	}

	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("NAME: ");
        builder.append(name);

        if (jet != null) {
            builder.append(" | JET---: ");
            builder.append(jet);
        }

        return builder.toString();
    }
}
