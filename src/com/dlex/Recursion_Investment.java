package com.dlex;

import java.util.Scanner;

public class Recursion_Investment {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input the investment amount: ");
        double amount = scan.nextDouble();
        System.out.print("Input the interest rate: ");
        double rate = scan.nextDouble();
        System.out.print("Input the years of investment: ");
        int years = scan.nextInt();
        double math = invest(amount, rate, years);
        System.out.print(math);
        scan.close();
    }

    public static double invest(double amount, double rate, int year) {
        if (year == 0) {
            return amount;
        } else {
            return (1 + rate) * invest(amount, rate, year - 1);
        }
    }
}
