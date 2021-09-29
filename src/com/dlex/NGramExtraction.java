package com.dlex;

import java.util.Scanner;
import java.util.StringTokenizer;

public class NGramExtraction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input the string to extracts NGrams: ");
        String text = scan.nextLine();
        System.out.print("Input the integer to ");
        int n = scan.nextInt();
        scan.close();
        String[] output = extractNGrams(text, n);
        for (String s : output) {
            System.out.print(s + ", ");
        }
    }
    public static String[] extractNGrams(String text, int n) {
        StringTokenizer st = new StringTokenizer(text);
        String[] arr = new String[st.countTokens()];
        int count = 0;
        while (st.hasMoreTokens()) {
            arr[count] = st.nextToken();
            count += 1;
        }
        String[] newArray = new String[(arr.length + 1) - n];
        System.arraycopy(arr, 0, newArray, 0, newArray.length);
        for (int i = 0; i < newArray.length; i++ ) {
            for (int j = i + 1; j < (i + n); j++) {
                newArray[i] += " " + arr[j];
            }
        }
        return newArray;
    }
}
