package com.dlex;

import java.util.Scanner;

public class Vote_Counts {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please input the number of candidates: ");
        int person = scan.nextInt();
        System.out.print("Please input the voters in this election: ");

        int voters = scan.nextInt();
        int[] count = new int[voters];

        for (int i = 1; i <= voters; i++) {
            System.out.print("#"+i+" Please input the candidate's number: ");
            int input = scan.nextInt();
            count[i-1] = input;
        }

        int[] check = new int[person];

        for (int i = 0; i < check.length; i++) {
            for (int k : count) {
                if (k == i + 1) {
                    check[i] += 1;
                }
            }
        }

        int firstLarge = 0;
        for (int i = 0; i < check.length; i++) {
            if (check[firstLarge] > check[i]) {
                firstLarge += 0;
            } else if (check[i] > check[firstLarge]) {
                firstLarge = i;
            }
        }
        int number = 1;
        for (int i = 0; i < person; i++) {
            if (check[i] == firstLarge) {
                number += i;
            }
        }
        scan.close();
        System.out.print("\n"+ number);
    }
}
