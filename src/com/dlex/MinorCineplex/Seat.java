package com.dlex.MinorCineplex;

public class Seat {
    private boolean isAvailable;
    private double seatPrice;

    public Seat() {
        this.isAvailable = true;
        this.seatPrice = 0.0;
    }

    public Seat(boolean isAvailable, double seatPrice) {
        this.isAvailable = isAvailable;
        this.seatPrice = seatPrice;
    }

    public boolean getAvailable() {
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
