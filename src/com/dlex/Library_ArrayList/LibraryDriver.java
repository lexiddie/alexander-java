package com.dlex.Library_ArrayList;

import java.util.Scanner;

public class LibraryDriver {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int command = -1;
		Library auLib = new Library("AU Library");
		User user1 = new User(1, "John");
		
		do {
			auLib.printMenu();
			System.out.print("What do you want to do? ");
			command = scan.nextInt();
			if (command == 1) {
				auLib.listItems();
				
			} else if (command == 2) {
				System.out.print("Enter ID: ");
				int itemID = scan.nextInt();
				auLib.searchItem(itemID);
				
			} else if (command == 3) {
				System.out.print("Enter ID: ");
				int itemID = scan.nextInt();
				System.out.print("Enter Title: ");
				String title = scan.nextLine();
				System.out.print("Enter Page Count: ");
				int pageCount = scan.nextInt();
				Book book = new Book(itemID, title);
				book.setPageCount(pageCount);
				auLib.addItem(book);
				
			} else if (command == 4) {
				
			} else if (command == 5) {
				System.out.print("Enter ID: ");
				int itemID = scan.nextInt();
				auLib.borrowItem(itemID, user1);
			} else if (command == 6) {
				System.out.print("Enter ID: ");
				int itemID = scan.nextInt();
				auLib.returnItem(itemID);
			}
			System.out.println();			
		} while (command != 7);
		
		System.out.println("Thank you");
	}

}
