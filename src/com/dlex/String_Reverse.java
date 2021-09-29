package com.dlex;

import java.util.Scanner;

public class String_Reverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input the string to reverse: ");
        String input = scan.next();
        String output = Reverse(input);
        System.out.print(output);
    }
    public static String Reverse(String input) {
        StringBuilder reverses = new StringBuilder();
        char[] arr = input.toCharArray();
        for (int i = 0; i < input.length(); i++) {
            reverses.append(arr[arr.length - 1 - i]);
        }
        return reverses.toString();
    }
}
