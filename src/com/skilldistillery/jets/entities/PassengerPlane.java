package com.skilldistillery.jets.entities;

public class PassengerPlane extends Jet implements PassengerInterface {
    public PassengerPlane(String model, double speed, int range, long price) {
        super(model, speed, range, price);
    }

    @Override
    public void boardPassengers() {
        System.out.printf("%s is boarding passengers...\n",getModel());
    }
}

