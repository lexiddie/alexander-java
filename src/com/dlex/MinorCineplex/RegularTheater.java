package com.dlex.MinorCineplex;

public class RegularTheater extends Theater {

    public RegularTheater(String nameOfMovie) {
        super(nameOfMovie);
        this.seats = new Seat[10][20];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                seats[i][j] = new Seat();
            }
        }
    }

    @Override
    double calculatedPrice(int row) {
        if (row >= 1 && row <= 5) {
            return 200;
        } else if (row >= 5 && row <= 10) {
            return 300;
        } else {
            return -1;
        }
    }
}



