package com.dlex.CardGame;

import java.util.Scanner;

public class CardDemo {
    public static void main(String[] args) {
        int count = 0;
        Card card = new Card();
        while (true) {
            card.randomCards();
            Scanner scan = new Scanner(System.in);
            count++;
            System.out.println("::  Game " + count + "  ::");
            for (int i = 1; i <=5; i++) {
                System.out.println("Please select the rank of the card.\n(1=Ace, 2=Two, 3=Three, 4=Four, 5=Five, 6=Six, 7=Seven, 8=Eight, 9=Nine, 10=Ten, 11=Jack, 12=Queen, 13=King)");
                int ranks = scan.nextInt();
                System.out.println("Please select the suit.\n(1=Spades, 2=Hearts, 3=Diamonds, 4=Clubs):");
                int suits = scan.nextInt();
                int check = card.guessCards(ranks, suits, i);
                if (check == 0) {
                    System.out.println("You won!! You picked the right card.\n");
                    break;
                } else if (check == 1) {
                    System.out.println("Wrong suit, correct rank!! Pick again.\n");
                } else if (check == 2) {
                    System.out.println("Right suit, wrong rank!! Pick again.\n");
                } else {
                    System.out.println("Wrong suit, wrong rank!! Pick again.\n");
                }
                if (i == 5) {
                    System.out.print("You’ve run out of tries.\n");
                    System.out.println("You Lost!! I chose " + card.getRanGame() + ".");
                }
            }
            System.out.println("Do you want to play again [Y/N]?");
            String plays = scan.next();
            if (plays.equals("n") || plays.equals("N")) {
                System.out.println(card.toString());
                scan.close();
                return;
            }
        }
    }
}
