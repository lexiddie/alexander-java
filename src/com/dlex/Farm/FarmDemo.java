package com.dlex.Farm;

import java.util.Scanner;

public class FarmDemo {
    public static void main(String[] args) {
        Farm farm = new Farm();
        Scanner scan = new Scanner(System.in);
        System.out.println("Given a sequence of animals");
        String animals = scan.nextLine();
        farm.sequenceAnimals(animals);
        scan.close();
    }
}
