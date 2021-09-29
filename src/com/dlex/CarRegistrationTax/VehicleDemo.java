package com.dlex.CarRegistrationTax;

import java.util.ArrayList;
import java.util.Scanner;

public class VehicleDemo {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("1/ Register a new vehicle: ");
            System.out.println("2/ Calculate the annual registration fee: ");
            System.out.println("3/ Pay the annual registration fee: ");
            System.out.println("4/ List all registered vehicles: ");
            System.out.println("5/ List all paid vehicles: ");
            System.out.println("6/ Exit: ");
            String check = scan.next();
            switch (check) {
                case "1" -> {
                    boolean isSuccessful = registerVehicle(vehicles);
                    if (isSuccessful) {
                        System.out.println("Register is successful");
                    }
                }
                case "2" -> {
                    boolean isSuccessful = calculateVehicleFee(vehicles);
                    if (isSuccessful) {
                        System.out.println("Calculate is successful");
                    }
                }
                case "3" -> {
                    boolean isSuccessful = payAnnualRegistration(vehicles);
                    if (!isSuccessful) {
                        System.out.println("Your vehicle is not found");
                    }
                }
                case "4" -> displayRegisteredVehicle(vehicles);
                case "5" -> displayIsNotPayVehicle(vehicles);
                case "6" -> {
                    scan.close();
                    return;
                }
            }
        }
    }
    public static boolean registerVehicle(ArrayList<Vehicle> vehicles) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the vehicle type: \nMotorcycle enter: M and Car enter: C");
        String type = scan.next();
        if (type.equals("M")|| type.equals("C")) {
            System.out.print("Enter license plate number: ");
            String plateNumber = scan.next();
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getPlateNumber().equals(plateNumber)) {
                    System.out.print("PlateNumber already exists");
                    return false;
                }
            }
            System.out.print("Enter the owner's name: ");
            String name = scan.next();
            System.out.print("Enter vehicle year: ");
            int year = scan.nextInt();
            System.out.print("Enter vehicle maker: ");
            String maker = scan.next();
            System.out.print("Enter vehicle model: ");
            String model = scan.next();
            System.out.print("Enter vehicle engine capacity: ");
            int engine = scan.nextInt();
            if (type.equals("M")) {
                vehicles.add(new Motorcycle(plateNumber, name, year, maker, model, engine));
            } else {
                vehicles.add(new PassengerCar(plateNumber, name, year, maker, model, engine));
            }
            return true;
        } else {
            System.out.println("Register failed");
            return false;
        }
    }
    public static boolean calculateVehicleFee(ArrayList<Vehicle> vehicles) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the vehicle plate number to check the fee: ");
        String plateNumber = scan.next();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlateNumber().equals(plateNumber)) {
                double fees = vehicle.calculateAnnualFee();
                System.out.println("The fees of this vehicle is: " + fees + " Baht");
                return true;
            }
        }
        return false;
    }
    public static boolean payAnnualRegistration(ArrayList<Vehicle> vehicles) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the vehicle plate number to check the fee: ");
        String plateNumber = scan.next();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlateNumber().equals(plateNumber)) {
                boolean check = vehicle.checkPay();
                if (check) {
                    System.out.println("The payment has been successful.");
                    vehicle.setPaid(true);
                    return true;
                } else {
                    System.out.println("Your vehicle has been paid");
                }
            }
        }
        return false;
    }
    public static void displayRegisteredVehicle(ArrayList<Vehicle> vehicles) {
        StringBuilder build = new StringBuilder();
        String labelType = String.format("%10s", "Type");
        String labelPlateNumber = String.format("%10s", "License");
        String labelName = String.format("%10s", "Name");
        String labelYear = String.format("%10s", "Year");
        String labelMake = String.format("%10s", "Make");
        String labelModel = String.format("%10s", "Model");
        String labelEngine = String.format("%10s", "Engine");
        build.append(labelType).append(labelPlateNumber).append(labelName).append(labelYear).append(labelMake).append(labelModel).append(labelEngine).append("\n\n");
        for (Vehicle vehicle : vehicles) {
            String type = String.format("%10s", vehicle.getVehicleType());
            String plateNumber = String.format("%10s", vehicle.getPlateNumber());
            String name = String.format("%10s", vehicle.getOwnerName());
            String year = String.format("%10s", vehicle.getVehicleYear());
            String make = String.format("%10s", vehicle.getMake());
            String model = String.format("%10s", vehicle.getModel());
            String engine = String.format("%10s", vehicle.getEngine());
            build.append(type).append(plateNumber).append(name).append(year).append(make).append(model).append(engine).append("\n");
        }
        System.out.print(build.toString());
    }

    public static void displayIsNotPayVehicle(ArrayList<Vehicle> vehicles) {
        StringBuilder build = new StringBuilder();
        String labelType = String.format("%10s", "Type");
        String labelPlateNumber = String.format("%10s", "License");
        String labelName = String.format("%10s", "Name");
        String labelYear = String.format("%10s", "Year");
        String labelMake = String.format("%10s", "Make");
        String labelModel = String.format("%10s", "Model");
        String labelEngine = String.format("%10s", "Engine");
        build.append(labelType).append(labelPlateNumber).append(labelName).append(labelYear).append(labelMake).append(labelModel).append(labelEngine).append("\n\n");
        for (Vehicle vehicle : vehicles) {
            if (vehicle.checkPay()) {
                String type = String.format("%10s", vehicle.getVehicleType());
                String plateNumber = String.format("%10s", vehicle.getPlateNumber());
                String name = String.format("%10s", vehicle.getOwnerName());
                String year = String.format("%10s", vehicle.getVehicleYear());
                String make = String.format("%10s", vehicle.getMake());
                String model = String.format("%10s", vehicle.getModel());
                String engine = String.format("%10s", vehicle.getEngine());
                build.append(type).append(plateNumber).append(name).append(year).append(make).append(model).append(engine).append("\n");
            }
        }
        System.out.print(build.toString());
    }
}
