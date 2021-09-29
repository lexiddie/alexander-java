package com.dlex.MinorCineplex;

public class  PremiumTheater extends Theater {

    public PremiumTheater(String nameOfMovie) {
        super(nameOfMovie);
        this.seats = new Seat[5][20];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 20; j++) {
                seats[i][j] = new Seat();
            }
        }
    }

    @Override
    double calculatedPrice(int row) {
        if (row >= 1 && row <= 4) {
            return 500;
        } else if (row == 5) {
            return 700;
        } else {
            return -1;
        }
    }
}
