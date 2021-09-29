package com.dlex.GG;

public class Main {

    public static void main(String[] args) {

        CinemaList cinemaList = new CinemaList();
        cinemaList.insert(new Cinema(1, "Solo", "Action", "22:00", 130));
        cinemaList.insert(new Cinema(13, "Ralph breaks the internet", "Comedy, Animation", "31.20", 112));
        cinemaList.insert(new Cinema(12, "Ralph breaks the internet", "Comedy, Animation", "02:00", 130));
        cinemaList.insert(new Cinema(2, "Ralph breaks the internet", "Comedy, Animation", "02:00", 130));
        cinemaList.insert(new Cinema(3, "Ralph breaks the internet", "Comedy, Animation", "10:00", 130));
        cinemaList.insert(new Cinema(4, "Ralph breaks the internet", "Comedy, Animation", "12:00", 130));
        cinemaList.insert(new Cinema(2, "Ralph breaks the internet", "Comedy, Animation", "22:00", 130));
        cinemaList.showAllCinema();
        System.out.println("I want know to the counts " + cinemaList.count());
        System.out.println(cinemaList.bookingSeat(0, 1, 1));
        System.out.println(cinemaList.bookingSeat(0, 1, 2));
        System.out.println(cinemaList.bookingSeat(0, 1, 3));
        System.out.println(cinemaList.bookingSeat(0, 1, 4));
        System.out.println(cinemaList.bookingSeat(1, 1, 1));
        System.out.println(cinemaList.bookingSeat(1, 1, 2));
        System.out.println(cinemaList.countAllBookedSeats());
        System.out.println("I'm checking sit in Cinema 0 row 1 and seat 1 " + cinemaList.checkSeat(0, 1, 1) + " if true means taken else false");
    }
}
