package com.dlex.ParenthesisMatching;

import java.util.Scanner;

public class ParenthesisMatcher {
    public static void main(String[] arggs) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        scan.close();
        boolean result = commands(input);
        if (result) {
            System.out.print("Correct");
        } else {
            System.out.print("Incorrect");
        }
    }
    public static boolean commands(String command) {
        char[] arr = command.toCharArray();
        Stack<Character> list = new Stack<Character>();
        char[] check = {'(', '{', '['};
        char[] find = {')', '}', ']'};
        int verify = arr.length/2;
        int counts = 0;
        for (char c : arr) {
            if (c == check[0] || c == check[1] || c == check[2]) {
                list.push(c);
            } else if (list.count() == 0) {
                return false;
            } else {
                char mypop = list.pop();
                for (int x = 0; x < check.length; x++) {
                    if (mypop == check[x]) {
                        if (c == find[x]) {
                            counts++;
                        }
                    }
                }
            }
        }
        return verify != 0 && verify == counts;
    }
}
