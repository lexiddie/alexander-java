package com.dlex.MinorCineplex;

abstract class Theater {
    private String nameOfMovie;
    protected Seat[][] seats;

    public Theater(String nameOfMovie) {
        this.nameOfMovie = nameOfMovie;
        this.seats = new Seat[0][0];
    }

    public String getNameOfMovie() {
        return nameOfMovie;
    }

    public void setNameOfMovie(String nameOfMovie) {
        this.nameOfMovie = nameOfMovie;
    }

    public Seat[][] getSeats() {
        return seats;
    }

    public void setSeats(Seat[][] seats) {
        this.seats = seats;
    }

    abstract double calculatedPrice(int row);

    public boolean checkSeat(int row, int seat) {
        Seat check = seats[row-1][seat-1];
        return check.getAvailable();
    }

    public void bookSeat(int row, int seat, double price) {
        seats[row-1][seat-1] = new Seat(false, price);;
    }
}
