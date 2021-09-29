package com.dlex.CarRegistrationTax;

public class Motorcycle extends Vehicle {

    public Motorcycle(String plateNumber, String ownerName, int vehicleYear, String make, String model, int engine) {
        super(plateNumber, ownerName, vehicleYear, make, model, engine);
    }

    @Override
    public double calculateAnnualFee() {
        return 100;
    }

    @Override
    String getVehicleType() {
        return "M";
    }
}

