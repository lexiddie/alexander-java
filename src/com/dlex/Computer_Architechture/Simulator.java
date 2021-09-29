package com.dlex.Computer_Architechture;

import java.util.Scanner;

public class Simulator {
	public static void main(String[] args) {
		InitializeData initializeData = new InitializeData();
		Scanner scan = new Scanner(System.in);
		boolean isQuit = false;
		String readLine;
		while (!isQuit) {
			readLine = scan.nextLine();
			isQuit = initializeData.verification(readLine);
		}
		scan.close();
	}
}
