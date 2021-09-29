package com.dlex.CarRegistrationTax;

public class PassengerCar extends Vehicle {

    public PassengerCar(String plateNumber, String ownerName, int vehicleYear, String make, String model, int engine) {
        super(plateNumber, ownerName, vehicleYear, make, model, engine);
    }

    @Override
    public double calculateAnnualFee() {
        double engineFee = 0.0;
        if (getEngine() <= 600) {
            engineFee = getEngine() * 0.5;
        } else if (getEngine() > 600 && getEngine() < 1800) {
            engineFee = (600 * 0.5) + ((getEngine() - 600) * 1.5);
        } else if (getEngine() >= 1800) {
            engineFee = (600 * 0.5) + (1199 * 1.5) + ((getEngine()-1799) * 4);
        }
        return calculateTaxRate(engineFee);
    }

    @Override
    String getVehicleType() {
        return "C";
    }

    private double calculateTaxRate(double engineFee) {
        int year = 2018 - getVehicleYear() + 1;
        int rate = 0;
        if (year < 6) {
            rate += 0;
        } else if (year == 6) {
            rate = 10;
        } else if (year == 7) {
            rate = 20;
        } else if (year == 8) {
            rate = 30;
        } else if (year == 9) {
            rate = 40;
        } else {
            rate = 50;
        }
        double discount = (engineFee * rate) / 100;
        return engineFee - discount;
    }
}
