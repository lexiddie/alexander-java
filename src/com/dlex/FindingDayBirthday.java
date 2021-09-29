package com.dlex;

import java.util.Scanner;

public class FindingDayBirthday {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        System.out.print("How many friends do you want to put: ");
        int n = scan.nextInt();
        int[] FriArr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Input friend day: ");
            int d = scan.nextInt();
            FriArr[i] = d;
        }
        int[] check = new int[7];

        for (int j = 0; j < check.length; j++) {
            for (int i : FriArr) {
                if ((j + 1) == i) {
                    check[j] += 1;
                } else {
                    check[j] += 0;
                }

            }
        }

        int first = 0;
        int second = 0;

        for (int z = 0; z < check.length; z++ ) {
            if (check[first] < check[z]) {
                first = z;
            } else if (check[first] > check[z]) {
                second = z;
            }
        }

        for (int i : check) {
            System.out.print(i + " ");
        }
        System.out.print("\n" + first + " " + second);

    }
}
