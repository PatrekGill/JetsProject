package com.skilldistillery.jets.entities;

import java.util.Objects;

public abstract class Jet {
    private String model;
    private double speed;
    private int range;
    private long price;
    private Pilot pilot;
    private final String jetType;

    protected Jet(String model, double speed, int range, long price, String jetType) {
        this(model,speed,range,price,jetType,null);
    }

    protected Jet(String model, double speed, int range, long price, String jetType, Pilot pilot) {
        this.model = model;
        this.speed = speed;
        this.range = range;        
        this.price = price;
        this.jetType = jetType;
        this.pilot = pilot;
    }

    public void fly() {
        System.out.println(this);
        System.out.printf("Flight time was: %.2f hours\n", getFlightTime());
        System.out.println();
    }


    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    
    public String getJetType() {
		return jetType;
	}

    
	public double getSpeed() {
        return speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    
    public double getFlightTime() {
        return (double)range / speed;
    }

    
    public int getRange() {
        return range;
    }
    public void setRange(int range) {
        this.range = range;
    }

    
    public Pilot getPilot() {
        return pilot;
    }
    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    
    public long getPrice() {
        return price;
    }
    public void setPrice(long price) {
        this.price = price;
    }

    

    @Override
	public int hashCode() {
		return Objects.hash(jetType, model, pilot, price, range, speed);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jet other = (Jet) obj;
		return Objects.equals(jetType, other.jetType) && Objects.equals(model, other.model)
				&& Objects.equals(pilot, other.pilot) && price == other.price && range == other.range
				&& Double.doubleToLongBits(speed) == Double.doubleToLongBits(other.speed);
	}

	
	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MODEL: ");
        builder.append(model);
        builder.append(" | SPEED: ");
        builder.append(speed);
        builder.append("MPH | RANGE: ");
        builder.append(range);
        builder.append(" miles | PRICE: ");
        builder.append(price);
        builder.append(" USD | TYPE: ");
        builder.append(jetType);

        if (pilot != null) {
            builder.append(" | PILOT: ");
            builder.append(pilot.getName());
        }

        return builder.toString();
    }
}

