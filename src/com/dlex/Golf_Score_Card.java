package com.dlex;

import java.util.Scanner;

public class Golf_Score_Card {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] Hole = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
        System.out.print("Please enter first player name: ");
        String player1 = scan.next();
        System.out.print("Please enter second player name: ");
        String player2 = scan.next();
        int[] arrPlayer1 = new int[Hole.length];
        int[] arrPlayer2 = new int[Hole.length];
        for (int i = 0; i < Hole.length; i++) {
            System.out.print("Please insert " + player1 + " " + (i+1) + " " + "Score: ");
            int p1Score = scan.nextInt();
            arrPlayer1[i] = p1Score;
            System.out.print("Please insert " + player2 + " " + (i+1) + " " + "Score: ");
            int p2Score = scan.nextInt();
            arrPlayer2[i] = p2Score;
        }
        //total players scores
        int totalPlayer1 = sumDigit(arrPlayer1);
        int totalPlayer2 = sumDigit(arrPlayer2);
        //check both players scores
        int[] score = new int[Hole.length];
        for (int i = 0; i < Hole.length; i++) {
            score[i] = arrPlayer2[i] - arrPlayer1[i];
        }
        for (int i = 0; i < Hole.length; i++) {
            if (i == 0) {
                System.out.print("Hole  \t\t| ");
            }
            System.out.print(Hole[i] + "\t | \t");
        }
        System.out.println("Total \t |");
        scan.close();
        for (int i = 0; i < Hole.length; i++) {
            if (i == 0) {
                System.out.print(player1 + "  \t\t| ");
            }
            System.out.print(arrPlayer1[i] + "\t | \t");
        }
        System.out.println(totalPlayer1 + "\t |");
        for (int i = 0; i < Hole.length; i++) {
            if (i == 0) {
                System.out.print(player2 + "  \t\t| ");
            }
            System.out.print(arrPlayer2[i] + "\t | \t");
        }
        System.out.println(totalPlayer2 + "\t |");
        for (int i = 0; i < Hole.length; i++) {
            if (i == 0) {
                System.out.print("Score  \t\t| ");
            }
            System.out.print(score[i] + "\t | \t");
        }
        System.out.print(totalPlayer2 - totalPlayer1 + "\t |");


    }

    public static int sumDigit(int[] number) {
        int Total = 0;
        for (int i = 0; i < 18; i++) {
            Total += number[i];
        }
        return Total;
    }
}
