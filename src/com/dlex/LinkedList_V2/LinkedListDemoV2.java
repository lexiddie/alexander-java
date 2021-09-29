package com.dlex.LinkedList_V2;

import java.util.Scanner;

public class LinkedListDemoV2 {
    public static void main(String[] args) {
        LinkedListV2 list = new LinkedListV2();
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
    public static boolean commands(String command, LinkedListV2 list, int[] counts) {
        String[] arr = command.split(" ");
        String[] check = {"insert", "delete", "find"};
        int data = Integer.parseInt(arr[1]);
        if (arr[0].equals(check[0])) {
            boolean notDuplicated = list.insert(data);
            if (notDuplicated) {
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
