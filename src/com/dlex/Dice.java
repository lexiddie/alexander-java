package com.dlex;

import java.util.Scanner;

public class Dice {

    public static void main(String[] args) {
        DiceClass dice = new DiceClass();
        System.out.println("The first dice roll value: " + dice.getDiceValue());
        Scanner scan = new Scanner(System.in);
        System.out.print("Guess number of dice next value: ");
        int n = scan.nextInt();
        scan.close();
        dice.setDiceValue(n);
        System.out.println("The dice final value is: " + dice.HighLow(dice.getDiceValue()) + "\nYou " + dice.Check());
    }
}
