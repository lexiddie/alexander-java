package com.dlex.Tutorial;

import java.util.Scanner;

public class ArrayStatic {
    public  static void main(String[] args) {
        String name = "Alexander";
        char[] charArray = name.toCharArray();
        String[] inputArray = new String[charArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = String.valueOf(charArray[i]);
        }

        System.out.println(inputArray.toString());

        for (String s : inputArray) {
            System.out.println(s + " ");
        }

        Scanner scan = new Scanner(System.in);
        System.out.print("Please input the number: ");
        int input = scan.nextInt();
        String inputFormat = String.format("%06d", input);
        System.out.println(inputFormat);

    }
}
