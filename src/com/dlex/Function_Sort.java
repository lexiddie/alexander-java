package com.dlex;

import java.util.Scanner;

public class Function_Sort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input your number to sort: ");
        String input = scan.next();
        String sort = SortOrder(input);
        System.out.print(sort);
        scan.close();
    }
    private static String SortOrder(String number) {
        char[] arr = number.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (char c : arr) {
            result.append(c);
        }
        return result.toString();
    }
}
