package com.dlex.OOC.Week1.OldMacDonaldSong;

import java.util.Scanner;

public class FarmDemo {
    public static void main(String[] args) {
        //cow pig chick dog
        Farm farm = new Farm();
        Scanner scan = new Scanner(System.in);
        System.out.println("Given a sequence of animals");
        String animals = scan.nextLine();
        farm.sequenceAnimals(animals);
        scan.close();
    }
}
