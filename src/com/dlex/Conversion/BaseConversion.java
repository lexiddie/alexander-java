package com.dlex.Conversion;

import java.util.Scanner;

public class BaseConversion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();
        boolean result = commands(input);
    }
    public static boolean commands(String command) {
        String[] arr = command.split(" ");
        String[] check = {"2", "3", "4", "5", "6", "7", "8"};
        int number = Integer.parseInt(arr[0]);
        for (String s : check) {
            int base = Integer.parseInt(s);
            if (arr[1].equals(s)) {
                baseFormat(number, base);
                return true;
            }
        }
        return false;
    }
    public static void baseFormat(int numbers, int base) {
        IntegerStack integerStack = new IntegerStack();
        int save = 0;
        int math = numbers;
        while (math >= 1) {
            save = math % base;
            math = math / base;
            integerStack.push(save);
        }

        while (!integerStack.isEmpty()) {
            System.out.print(integerStack.pop());
        }
    }
}
