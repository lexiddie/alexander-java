package com.dlex.LinkedList_Ordered;

import java.util.Scanner;

public class LinkedList_Ordered_Demo {
    public  static  void main(String[] args) {
        LinkedList_Ordered list = new LinkedList_Ordered();
        int[] counts = {0, 0, 0, 0};
        Scanner scan = new Scanner(System.in);
        System.out.print("Input the number of transaction: ");
        int t = scan.nextInt();
        scan.nextLine();
        if (t < 1 || t > 200) {
            System.out.print("Invalid number of transaction!!");
            return;
        }
        System.out.println(t);
        for (int i = 0; i < t; i++) {
            String command = scan.nextLine();
            boolean check = commands(command, list, counts);
            if (!check) {
                System.out.println("Invalid command");
            }
        }
        scan.close();
        counts[3] = list.count();
        for (int count : counts) {
            System.out.print(count + " ");
        }
        System.out.println("\n" + list.toString());

    }
    public static boolean commands(String command, LinkedList_Ordered list, int[] counts) {
        String[] arr = command.split(" ");
        String[] check = {"insert", "delete", "find"};
        int data = Integer.parseInt(arr[1]);
        if (arr[0].equals(check[0])) {
            boolean inserted = list.insert(data);
            if (inserted) {
                counts[0]++;
            }
            return true;
        } else if (arr[0].equals(check[1])) {
            boolean deleted = list.delete(data);
            if (deleted) {
                counts[1]++;
            }
            return true;
        } else if (arr[0].equals(check[2])) {
            int found = list.find(data);
            if (found != -1) {
                counts[2]++;
            }
            return true;
        }
        return false;
    }
}
