package com.dlex;

public class Parameter_Passing {

    public static void main(String[] args) {
        int number = 15;
        System.out.println("Value of number before calling the method " + number);
        add(number);
        System.out.println("Value of number after calling the method " + number);

        int[] numbers = { 2, 7, 1, 5, 12 };
        System.out.print("Before the method call: ");
        printArray(numbers);
        System.out.print("\nAfter the method call: ");
        add5Each(numbers);
        printArray(numbers);

    }

    public static void add(int n) {
        n += 5;
    }

    private static void add5Each(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] += 5;
        }
    }

    private static void printArray(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
