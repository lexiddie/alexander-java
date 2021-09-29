package com.dlex;

import java.util.Scanner;

public class Recursion_Factorial {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("The factorial of ");
        int n = scan.nextInt();
        int result = factorial(n);
        System.out.print(result);
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return n * factorial(n - 1);
        }
    }
}
