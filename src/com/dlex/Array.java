package com.dlex;

public class Array {
    public static void main(String[] args) {
        int[] number = new int[10];
        for (int i = 0; i < number.length; ++i) {
            number[i] = (i+1)*2;
        }
        for (int k : number) {
            System.out.print(k + " ");
        }

        int[] evenNumber = {2, 4, 6, 8};

        for (int j : evenNumber) {
            System.out.println(j);
        }
    }
}
