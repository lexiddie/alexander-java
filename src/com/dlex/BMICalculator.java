package com.dlex;

import java.util.Scanner;

public class BMICalculator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Input your Height in Cm: ");
		int height = scan.nextInt();
		System.out.print("Input your Weight in Kg: ");
		int weight = scan.nextInt();
		scan.close();
		double checkHeight = 0.0;
		checkHeight = (double) height / 100;
		double result = 0.0;
		result = weight / (Math.pow(checkHeight, 2.0));
		if (result < 18.5) {
			System.out.println("your BMI is Underweight");
		}
		else if (result == 18.5 || result < 25) {
			System.out.println("your BMI is Normal");
		}
		else if (result == 25 || result < 30) {
			System.out.println("your BMI is Overweight");
		}
		else if (result == 30 || result > 30) {
			System.out.println("Your BMI is Obese");
		}
	} 

}
