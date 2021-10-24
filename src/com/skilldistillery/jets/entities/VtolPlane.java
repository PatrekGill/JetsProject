package com.skilldistillery.jets.entities;

public class VtolPlane extends Jet implements VtolInterface {
    public VtolPlane(String model, double speed, int range, long price) {
        super(model, speed, range, price, "vtol");
    }

    @Override
    public void enterVerticalMode() {
        System.out.printf("%s is entering VTOL mode...\n",getModel());
    }
}

