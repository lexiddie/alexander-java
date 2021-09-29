package com.dlex;

import java.util.Scanner;

public class Recursion_Fibonacci_Series {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("The Fibonacci of ");
        int n = scan.nextInt();
        int result = Fibonacci(n);
        System.out.print(result);
    }
    
    public static int Fibonacci(int n) {
        if (n == 0 ) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return Fibonacci(n-1) + Fibonacci(n-2);
        }
    }
}
