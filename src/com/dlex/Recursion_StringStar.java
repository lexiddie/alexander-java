package com.dlex;

public class Recursion_StringStar {

    public static void main(String[] args) {
        String result = insertStar("bbbb");
        System.out.print(result);
    }

    public static String insertStar(String input) {
        if (input.length() == 1) {
            return input;
        } else {
            char[] arr = input.toCharArray();
            insertStar(input.substring(0, input.length() -1));
            if (arr[arr.length -1] == arr[arr.length -2]) {
                return insertStar(input) + "*" + arr[input.length() -1];
            } else {
                return insertStar(input) + arr[input.length() -1];
            }
        }
    }
}
