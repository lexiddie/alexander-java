package com.dlex.CarRegistrationTax;

abstract class Vehicle {
    private String plateNumber;
    private String ownerName;
    private int vehicleYear;
    private String make;
    private String model;
    private int engine;
    private boolean isPaid = false;

    public Vehicle(String plateNumber, String ownerName, int vehicleYear, String make, String model, int engine) {
        this.plateNumber = plateNumber;
        this.ownerName = ownerName;
        this.vehicleYear = vehicleYear;
        this.make = make;
        this.model = model;
        this.engine = engine;
    }

    abstract String getVehicleType();

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(int vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getEngine() {
        return engine;
    }

    public void setEngine(int engine) {
        this.engine = engine;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public boolean checkPay() {
        return !isPaid;
    }

    abstract double calculateAnnualFee();
}
