package com.dlex.ConversionV2;

import java.util.Scanner;

public class BaseConversion2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();
        boolean result = commands(input);
    }
    public static boolean commands(String command) {
        String[] arr = command.split(" ");
        String[] check = {"2", "3", "4", "5", "6", "7", "8", "16"};
        int number = Integer.parseInt(arr[0]);
        for (int i = 0; i < check.length-1; i++) {
            int base = Integer.parseInt(check[i]);
            if (arr[1].equals(check[7])) {
                baseSixteen(number);
                return true;
            }
            else if (arr[1].equals(check[i])) {
                baseFormat(number, base);
                return true;
            }
        }
        return false;
    }
    public static void baseFormat(int numbers, int base) {
        Stack<Integer> stack = new Stack<>();
        int save = 0;
        int math = numbers;
        while (math >= 1) {
            save = math % base;
            math = math / base;
            stack.push(save);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
    public static void baseSixteen(int numbers) {
        Stack<String> stack = new Stack<>();
        String[] arr = {"A", "B", "C", "D", "E", "F"};
        int[] check = {10, 11, 12, 13, 14, 15};
        int save = 0;
        int math = numbers;
        while (math >= 1) {
            save = math % 16;
            math = math / 16;
            String push = String.valueOf(save);
            for (int i = 0; i < check.length; i++) {
                if (save == check[i]) {
                    push = arr[i];
                }
            }
            stack.push(push);
        }
        while (!stack.isEmpty()) {
            String str = String.valueOf(stack.pop());
            System.out.print(str);
        }
    }
}
