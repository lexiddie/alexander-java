package com.dlex;

import java.util.Scanner;

public class Graph {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of vertex: ");
        int v = sc.nextInt();
        System.out.print("Enter Number of Edge: ");
        int e = sc.nextInt();
        int[][] table = new int[v][v];
        for (int i = 0; i < e; i++) {
            System.out.print(" ");
            String S = sc.nextLine();
            String[] integerString = S.split(" ");
            int[] integer = new int[10];
            for(int j=0; j < 3;j++) {
                integer[i] = Integer.parseInt(integerString[i]);
                System.out.println(integer[i]);
            }
        }
        table[1][2] = 2;
        for(int i=0; i < v; i++ ) {
            for(int j=0;  j<v; j++) {
                System.out.print(table[i][j]);
            }
            System.out.println();
        }

    }
}

