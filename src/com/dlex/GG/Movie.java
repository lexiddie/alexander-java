package com.dlex.GG;

public class Movie {

    private String name;
    private String type;
    private String startTime;
    private int totalTime;
    private final Seat[][] seats;

    public Movie(String name, String type, String startTime, int totalTime) {
        this.name = name;
        this.type = type;
        this.startTime = startTime;
        this.totalTime = totalTime;
        this.seats = new Seat[6][10];
        initializePrice();
    }

    private void initializePrice() {
        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                for (int j = 0; j < 4; j++) {
                    this.seats[i][j] = new Seat(360.0);
                }
            } else if (i == 1 || i == 2) {
                for (int j = 0; j < 10; j++) {
                    this.seats[i][j] = new Seat(180.0);
                }
            } else {
                for (int j = 0; j < 10; j++) {
                    this.seats[i][j] = new Seat(140.0);
                }
            }
        }
    }

    public void bookSeat(int row, int seat) {
        this.seats[row-1][seat-1].setAvailable(false);
    }

    public int countBookedSeats() {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                for (int j = 0; j < 4; j++) {
                    if (!this.seats[i][j].isAvailable()) {
                        count += 1;
                    }
                }
            } else if (i == 1 || i == 2) {
                for (int j = 0; j < 10; j++) {
                    if (!this.seats[i][j].isAvailable()) {
                        count += 1;
                    }
                }
            } else {
                for (int j = 0; j < 10; j++) {
                    if (!this.seats[i][j].isAvailable()) {
                        count += 1;
                    }
                }
            }
        }
        return count;
    }

    public double checkPrice(int row, int seat) {
        Seat check = this.seats[row-1][seat-1];
        return check.getSeatPrice();
    }

    public boolean checkSeat(int row, int seat) {
        Seat check = this.seats[row-1][seat-1];
        return check.isAvailable();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %.2s, %.2d", this.name, this.type, this.startTime, this.totalTime);
    }
}
