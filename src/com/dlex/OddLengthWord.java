package com.dlex;

import java.util.Scanner;
import java.util.StringTokenizer;

public class OddLengthWord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter some text: ");
        String input = scan.nextLine();
        scan.close();
        StringTokenizer st = new StringTokenizer(input);
        String[] arr = new String[st.countTokens()];
        int count = 0;
        while (st.hasMoreTokens()) {
            arr[count] = st.nextToken();
            count += 1;
        }
        for (String s : arr) {
            char[] n = s.toCharArray();
            if (n.length % 2 != 0) {
                System.out.println(s);
            }
        }
    }
}
