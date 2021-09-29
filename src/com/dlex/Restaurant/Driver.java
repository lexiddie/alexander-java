package com.dlex.Restaurant;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static ArrayList<Integer> orderAmounts = new ArrayList<>();

	public static void main(String[] args) {
		TakeOrder t = new TakeOrder();
		t.insertFood("A1", "Fried rice", 2.4);
		t.insertFood("A2", "Noodle", 1.2);
		t.insertFood("A3", "Tom Yum", 3.0);
		t.insertFood("A4", "Pat Thai", 4.3);
		t.insertFood("A5", "Orange Juice", 0.5);
		t.Print();
		Scanner sc = new Scanner(System.in);

		System.out.println("Please input food code then space amount of orders");
		boolean quit = false;
		while (!quit) {
			String input = sc.nextLine();
			int check = t.find(input.split(" ")[0]);
			System.out.println(input.split(" ")[0] + "  " + input.split(" ")[1]);
			if (check != -1) {
				orderAmounts.add(check, Integer.parseInt(input.split(" ")[1]));
			} else {
				quit = true;
			}
			Print();
		}
	}


	private static void Print() {
		for (int i = 0; i < orderAmounts.size(); i++) {
			System.out.println(orderAmounts.indexOf(i));
		}
	}



}
