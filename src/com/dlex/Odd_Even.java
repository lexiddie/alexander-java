package com.dlex;

import java.util.Scanner;

public class Odd_Even {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter the number: ");
		int number = scan.nextInt();
		scan.close();
		if (IsEven(number)) {
			System.out.println(number + " is an Even Number");
		}
		else {
			System.out.println(number + " is an Odd Number");
		}
	}
	public static boolean IsEven(int n) {
		return n % 2 == 0;
	}

}
