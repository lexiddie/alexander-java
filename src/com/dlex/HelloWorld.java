package com.dlex;

import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println("This is my class");
		Scanner scan = new Scanner(System.in);

		// read the input
		System.out.print("Enter the number: ");
		int number = scan.nextInt();
		System.out.println("You just enter " + number);
		scan.close();
	}

}
