package com.dlex;import java.util.Scanner;public class Recursion_Tower_of_Hanoi {    public static void main(String[] args) {        Scanner scan = new Scanner(System.in);        System.out.print("Input the number of Disk: ");        int disk = scan.nextInt();        solve(disk, "A", "B", "C");        scan.close();    }    public static void solve(int n, String source, String auxiliary, String destination) {            if ( n == 1) {                System.out.println("Disc " + n + ": " + source + " -> " + destination);            } else {                solve(n - 1, source, destination, auxiliary);                System.out.println("Disc " + n + ": " + source + " -> " + destination);                solve(n - 1, auxiliary, source, destination);            }    }}