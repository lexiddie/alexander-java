package com.dlex.GG;

public class Seat {
    private boolean isAvailable;
    private double seatPrice;


    public Seat(double seatPrice) {
        this.isAvailable = true;
        this.seatPrice = seatPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(double seatPrice) {
        this.seatPrice = seatPrice;
    }
}
