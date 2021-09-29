package com.dlex.MinorCineplex;

import java.util.ArrayList;
import java.util.Scanner;

public class TheaterDemo {
    public static void main(String[] args) {

        ArrayList<Theater> theaters = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the movie name: ");
        String movie = scan.next();
        for (int i = 0; i < 4; i++) {
            if (i == 3) {
                theaters.add(new PremiumTheater(movie));
            } else {
                theaters.add(new RegularTheater(movie));
            }
        }
        while (true) {
            System.out.println("1/ Book a seat: ");
            System.out.println("2/ Edit movie title: ");
            System.out.println("3/ View sales report: ");
            System.out.println("4/ Exit the program: ");
            int check = scan.nextInt();
            if (check == 1) {
                boolean isSuccessful = bookTicket(theaters);
                if (isSuccessful) {
                    System.out.println("Book Successful");
                }
            } else if (check == 2) {
                updateMovie(theaters);
            } else if (check == 3) {
                viewSalesReport(theaters);
            } else {
                scan.close();
                return;
            }
        }
    }

    public static boolean bookTicket(ArrayList<Theater> theaters) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the Theater number from 1 to 4: ");
        int number = scan.nextInt();
        int row;
        if (number != 4) {
            System.out.print("Enter the seat rows from 1 to 10: ");
        } else {
            System.out.print("Enter the seat rows from 1 to 5: ");
        }
        row = scan.nextInt();
        System.out.print("Enter the seat number from 1 to 20: ");
        int seat = scan.nextInt();
        boolean check = theaters.get(number-1).checkSeat(row, seat);
        if (check) {
            double price = theaters.get(number-1).calculatedPrice(row);
            System.out.println("This seat price is " + price + ".");
            System.out.println("Do you want to book it? Y/N");
            String confirm = scan.next();
            if (confirm.equals("Y") || confirm.equals("y")) {
                theaters.get(number-1).bookSeat(row, seat, price);
                return true;
            } else {
                return false;
            }

        } else {
            System.out.print("This seat is not available please choose other seats");
            return false;
        }
    }

    public static void updateMovie(ArrayList<Theater> theaters) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter new movie title: ");
        String title = scan.nextLine();
        for (Theater theater : theaters) {
            theater.setNameOfMovie(title);
        }
        System.out.println("Movie name has been update successful.");
    }

    public static void viewSalesReport(ArrayList<Theater> theaters) {
        int[] counts = new int[theaters.size()];
        int total = 0;
        for (int i = 0; i < theaters.size(); i++) {
            for (int j = 0; j < theaters.get(i).getSeats().length; j++) {
                for (int x = 0; x < 20; x++) {
                    Seat[][] check = theaters.get(i).getSeats();
                    if (!check[j][x].getAvailable()) {
                        counts[i] += 1;
                    }
                }
            }
        }
        for (int count : counts) {
            total += count;
        }
        StringBuilder build = new StringBuilder();
        String movieTitle = String.format("%50s", "Minor Cineplex movie is " + theaters.get(1).getNameOfMovie());
        build.append(movieTitle).append("\n\n");
        String labelTheater1 = String.format("%15s", "Theater1");
        String labelTheater2 = String.format("%15s", "Theater2");
        String labelTheater3 = String.format("%15s", "Theater3");
        String labelTheater4 = String.format("%15s", "Theater4");
        String labelTotal = String.format("%15s", "Total");
        build.append(labelTheater1).append(labelTheater2).append(labelTheater3).append(labelTheater4).append(labelTotal).append("\n\n");
        String theater1 = String.format("%15s", counts[0]);
        String theater2 = String.format("%15s", counts[1]);
        String theater3 = String.format("%15s", counts[2]);
        String theater4 = String.format("%15s", counts[3]);
        String totalBook = String.format("%15s", total);
        build.append(theater1).append(theater2).append(theater3).append(theater4).append(totalBook).append("\n\n");
        System.out.print(build.toString());
    }
}
