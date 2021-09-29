package com.dlex;

import java.util.Scanner;

public class Play_with_Digits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Give an Integer: ");
        int number = scan.nextInt();
        System.out.print("Give the position of digit: ");
        int position = scan.nextInt();

        int result = intExtractDigit(number,position);
        System.out.println("extractDigit(" + number +","+ position + ")" + "returns " + result);
        int sum = sumDigits(number);
        System.out.println("sumDigit(" + number +")" + " will returns " + sum + ".");
        scan.close();
    }

    public static int intExtractDigit(int number, int position) {
        String str = "" + number;
        String[] arr = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[str.length() -i -1] = String.valueOf(str.charAt(i));
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (position == i+1) {
                int convert = Integer.parseInt(arr[i]);
                result = convert;
                return convert;
            }
        }
        return result;
    }

    public static int sumDigits(int number) {
        String str = "" + number;
        char[] digit = str.toCharArray();
        int total = 0;
        for (int i = 0; i < str.length(); i++) {
            digit[i] -= '0';
            total +=  digit[i];
        }
        return  total;
    }

}
