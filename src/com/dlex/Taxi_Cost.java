package com.dlex;

import java.util.Scanner;

public class Taxi_Cost {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please put the distance in Kilometers: ");
        int meters = scan.nextInt();
        System.out.print("Please enter 0 if the passenger didn't use the call center or 1 if passenger did: ");
        int call = scan.nextInt();
        System.out.print("Please enter 0 if the passenger didn't take Taxi from Airport or 1 if passenger did: ");
        int airport = scan.nextInt();
        double firstPrice = CurrentRate(meters, call, airport);
        double secondPrice = ProposedRate(meters, call, airport);
        double range = Math.abs(firstPrice - secondPrice);
        System.out.println(firstPrice + " " + secondPrice + " " + range);
        scan.close();

    }
    public static Double CurrentRate(int meters, int call, int airport) {
        double prices = 35;
        if (meters == 1) {
            prices += 0;
        } else if (meters >= 2 && meters <= 12) {
            prices +=  (meters-1)*4.5;
        } else if (meters >= 13 && meters <=20) {
            prices += (11*4.5) + ((meters-12)*5);
        } else if (meters >= 21) {
            prices += (11*4.5) + (8*5) + ((meters-20)*5.5);
        }

        //Find more fee
        if (call == 1 && airport == 1) {
            prices += 70;
        } else if (call == 0 && airport == 1) {
            prices += 50;
        } else if (call == 1 && airport == 0) {
            prices += 20;
        }
        return prices;

    }
    public static Double ProposedRate(int meters, int call, int airport) {
        double prices = 0;
        if (meters == 1) {
            prices = 35;
        } else if (meters == 2 ) {
            prices = 50;
        } else if (meters >= 3) {
            prices = 50 + ((meters-2) * 12);
        }
        //Find more fee
        if (call == 1 && airport == 1) {
            prices += 150;
        } else if (call == 0 && airport == 1) {
            prices += 100;
        } else if (call == 1 && airport == 0) {
            prices += 50;
        }
        return prices;
    }
}
