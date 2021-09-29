package com.dlex;

public class Remainder {
    public static void main(String[] args) {
        boolean result = isLeapYear(2018);
        System.out.println(result);
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
