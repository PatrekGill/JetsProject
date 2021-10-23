package com.skilldistillery.jets.entities;

public class VtolPlane extends Jet implements VtolInterface {
    public VtolPlane(String model, double speed, int range, long price) {
        super(model, speed, range, price);
    }

    @Override
    public void enterVerticalMode() {
        System.out.println("Entering VTOL mode...");
    }
}

