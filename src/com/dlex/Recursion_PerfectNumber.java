package com.dlex;

import java.util.Scanner;

public class Recursion_PerfectNumber {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input the numbers to find perfect number: ");
        int n = scan.nextInt();
        int result = isPerfectNumber(n);
        if (result == n) {
            System.out.println("Hence, " + n + " is a perfect number.");
        } else{
            System.out.println("Hence, " + n + " is not a perfect number.");
        }
    }
    
    public static int isPerfectNumber(int n) {
        if (n == 1) {
            return n;
        } else {
            isPerfectNumber(n-1);
            int check = 0;
            for (int i = n/2; i > 0; i--) {
                if (n%i == 0 ) {
                    check += i;
                }
            }
            return check;
        }
    }
}
