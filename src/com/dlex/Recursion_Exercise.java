package com.dlex;

import java.util.Scanner;

public class Recursion_Exercise {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("The number of dogs is: ");
        int n = scan.nextInt();
        int result = doglegs(n);
        System.out.println(result);
        System.out.print("Input the number you want to print with dots: ");
        int dot = scan.nextInt();
        printNumberDots(dot);
        System.out.println();
        System.out.print("Please input the op1: ");
        int op1 = scan.nextInt();
        System.out.print("Please input the op2: ");
        int op2 = scan.nextInt();
        int math = multiply(op1, op2);
        System.out.println(math);
        System.out.print("Please input the number to sum of square: ");
        int sum = scan.nextInt();
        int sums = sumSquare(sum);
        System.out.print(sums);
        scan.close();
    }

    public static int doglegs(int n) {
        if (n == 0) {
            return n;
        } else if (n == 1) {
            return 4;
        } else{
            return 4 + doglegs(n-1);
        }
    }

    public static void printNumberDots(int n) {

        if (n == 0) {
            System.out.print(0);
        } else if (n == 1) {
            System.out.print("1");
            System.out.print(".");
        } else {
            printNumberDots(n-1);
            System.out.print(n);
            for (int i = n; i > 0; i--) {
                System.out.print(".");
            }
        }
    }

    public static int multiply(int op1, int op2) {
        if (op1 == 0 || op2 == 0) {
            return 0;
        } else if (op2 == 1) {
            return op1;
        } else if (op2 < 0) {
            return - op1 + multiply(op1, op2 + 1);
        } else{
            return op1 + multiply(op1, op2 - 1);
        }
    }

    public static int sumSquare(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else{
            return (n * n) + sumSquare(n-1);
        }
    }
}
