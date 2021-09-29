package com.dlex.Library_ArrayList;

public class Library {

	private final String name;
	private final Item[] items;
	private final int itemCount = 20;
	
	public Library(String name) {
		this.name = name;
		this.items = new Item[itemCount];
	}
	
	public void printMenu() {
		System.out.println("Welcome to " + this.name);
		System.out.println("1. List items");
		System.out.println("2. Search item");
		System.out.println("3. Add book");
		System.out.println("4. Add DVD");
		System.out.println("5. Borrow item");
		System.out.println("6. Return item");
		System.out.println("7. Exit");
	}
	
	public void listItems() {
		int i = 0;
		while (i < itemCount && items[i] != null) {
			System.out.println(items[i]);
			i++;
		}
		if (i==0) {
			System.out.println("Library is empty");
		}
	}
	
	public void searchItem(int itemID) {
		boolean found = false;
		int i=0; 
		while (i < itemCount && items[i] != null) {	
			if (items[i].getID() == itemID) {
				System.out.println(items[i]);
				found = true;
			}
			i++;
		}
		if (!found) {
			System.out.println("Item not found");
		}
	}
	
	public void addItem(Item item) {
		int i=0; 
		while (i < itemCount && items[i] != null) {	
			i++;
		}
		if (i < itemCount) {
			items[i] = item;
		} else {
			System.out.println("Library is full");
		}
	}
	
	public void borrowItem(int itemID, User user) {
		int i=0; 
		while (items[i] != null) {
			if (items[i].getID() == itemID) {
				items[i].Borrow(user);
				return;
			}
		}
		System.out.println("Item not found");
	}
	
	public void returnItem(int itemID) {
		int i=0; 
		while (items[i] != null) {
			if (items[i].getID() == itemID) {
				items[i].Return();
				return;
			}
		}
		System.out.println("Item not found");		
	}
}
