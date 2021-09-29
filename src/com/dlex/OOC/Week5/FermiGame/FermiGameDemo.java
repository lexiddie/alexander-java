package com.dlex.OOC.Week5.FermiGame;

import java.util.Scanner;

public class FermiGameDemo {
    public static void main(String[] args) {
        FermiGame fermiGame = new FermiGame();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (!input.equals("-1")) {
                fermiGame.checkGuess(input.split(" "));
            } else {
                break;
            }
        }
        scanner.close();
    }
}
