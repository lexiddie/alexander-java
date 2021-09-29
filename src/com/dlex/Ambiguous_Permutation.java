package com.dlex;

import java.util.Scanner;

public class Ambiguous_Permutation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.print("Please input the an Integer: ");
            int line = scan.nextInt();
            if (line >= 1 && line <= 100000) {
                int[] arr = new int[line];
                for (int i = 1; i <= line; i++) {
                    System.out.print("Please input the permutation of the Integer " + i + " is: ");
                    int input = scan.nextInt();
                    arr[i-1] = input;
                }
                int[] newArr = new int[line];
                for (int i = 0; i < newArr.length; i++) {
                    for (int z = 0; z < arr.length; z++) {
                        if (i+1 == arr[z]) {
                            newArr[i] = z+1;
                        }
                    }
                }
                int count = 0;
                for (int x = 0; x < line; x++) {
                    if (arr[x] == newArr[x]) {
                        count += 1;
                    }
                }
                System.out.println(line);
                for (int i : arr) {
                    System.out.print(i + " ");
                }
                if (count == line) {
                    System.out.println("\tAmbiguous");
                }
                else {
                    System.out.println("\tNot Ambiguous");
                }
                scan.close();
                return;
            }
        }
    }

}
