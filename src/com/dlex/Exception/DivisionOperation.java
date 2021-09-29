package com.dlex.Exception;

public class DivisionOperation {

    private static int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("You can't divide by Zero");
        } else {
            return a / b;
        }
    }
    public static void main(String[] args) {
        try {
            int result = divide(5, 0);
            System.out.println(result);
        } finally {
            System.out.println("It's error");
        }
    }
}
