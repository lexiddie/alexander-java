package com.dlex;

import java.util.Scanner;

public class ArrayDemo {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < numbers.length; ++i) {
            System.out.print("Enter the number: ");
            numbers[i] = scan.nextInt();
        }
        int total = 0;
        for (int number : numbers) {
            total += number;
        }

        System.out.println("The total is: " + total);
        scan.close();
    }
}
