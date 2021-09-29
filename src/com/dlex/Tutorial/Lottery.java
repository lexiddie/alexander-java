package com.dlex.Tutorial;

import java.util.Scanner;

public class Lottery {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        RanLottery ranLottery = new RanLottery();
        System.out.println("Please input the numbers to win the lottery: ");
        int input = scan.nextInt();
        int result = ranLottery.setupValue(input);
        System.out.println("Check user wins the lottery number: " + result);
    }
}
