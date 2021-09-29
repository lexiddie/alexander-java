package com.dlex.Arithmetic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArithmeticDemo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your arithmetic expression: ");
        String express = scan.next();
        System.out.print("Enter the value of A: ");
        int valueA = scan.nextInt();
        System.out.print("Enter the value of B: ");
        int valueB = scan.nextInt();
        System.out.print("Enter the value of C: ");
        int valueC = scan.nextInt();
        scan.close();
        boolean check = commands(express, valueA, valueB, valueC);
        if (!check) {
            System.out.print("The above expression is an invalid and can't be evaluated.");
        }
    }

    private static boolean commands(String expr, int a, int b, int c) {
        Stack<Character> stack = new Stack<>();
        char[] arr = expr.toCharArray();
        char[] checkVar = {'A', 'B', 'C'};
        char[] checkOperative = {'+', '-', '*', '/'};
        char top = ' ';
        boolean verify;
        for (char value : arr) {
            verify = false;
            if (stack.count() == 0) {
                stack.push(value);
                top = stack.peek();
            } else if (top == checkVar[0] || top == checkVar[1] || top == checkVar[2]) {
                for (char item : checkOperative) {
                    if (value == item) {
                        stack.push(value);
                        top = stack.peek();
                        verify = true;
                    }
                }
                if (!verify) {
                    return false;
                }
            } else {
                for (char item : checkVar) {
                    if (value == item) {
                        verify = true;
                        stack.push(value);
                        top = stack.peek();
                    }
                }
                if (!verify) {
                    return false;
                }
            }
        }

        StringBuilder express = new StringBuilder();
        for (char value : arr) {
            if (value == checkVar[0]) {
                express.append(a);
            } else if (value == checkVar[1]) {
                express.append(b);
            } else if (value == checkVar[2]) {
                express.append(c);
            } else {
                express.append(value);
            }
        }
        String result = infixToPostfix(expr);
        System.out.println("The postfix expression is " + result);
        System.out.println(express);
        int valueOperation = evaluatePostfixExpr(express.toString());
        System.out.println("The above expression evaluates to " + valueOperation + ".");
        return true;
    }


    public static int Prec(char ch)
    {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }


    public static String infixToPostfix(String exp) {

        StringBuilder result = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid Expression";
                } else{
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }

        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    private static int evaluatePostfixExpr(String exp) {
        Stack<Integer> stack = new Stack<> ();
        String[] check = exp.split("");
        ArrayList<String> validArr = new ArrayList<>();
        int j = 0;
        String str = "";
        while (j < check.length) {
            if (check[j].equals("*") || check[j].equals("/") || check[j].equals("-") || check[j].equals("+")) {
                validArr.add(str);
                str = "";
                validArr.add(check[j]);
            } else if (j == check.length - 1) {
                str += check[j];
                validArr.add(str);
            } else {
                str += check[j];
            }
            j++;
        }

        int i = 0;
        while (i < validArr.size()) {
            if (validArr.get(i).equals("*") || validArr.get(i).equals("/") || validArr.get(i).equals("+") || validArr.get(i).equals("-")) {
                int num1 = stack.pop();
                int num2 = Integer.parseInt(validArr.get(i+1));
                switch (validArr.get(i)) {
                    case "+" -> stack.push(num1 + num2);
                    case "-" -> stack.push(num1 - num2);
                    case "*" -> stack.push(num1 * num2);
                    default -> stack.push(num1 / num2);
                }
                i += 2;
            } else {
                int toInt = Integer.parseInt(validArr.get(i));
                stack.push(toInt);
                i++;
            }
        }
        return stack.pop();
    }
}
