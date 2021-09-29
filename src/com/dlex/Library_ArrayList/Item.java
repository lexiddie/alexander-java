package com.dlex.Library_ArrayList;

public class Item {

	protected int itemID;
	protected String title;	
	protected boolean isAvailable;
	protected User borrowingUser;
	
	public Item(int ID, String title) {
		this.itemID = ID;
		this.title = title;
		this.isAvailable = true;
	}
	
	public int getID() {
		return itemID;
	}

	public void Borrow(User user) {
		if (isAvailable) {
			this.borrowingUser = user;
			this.isAvailable = false;
		} else {
			System.out.println("This item is borrowed by " + user);
		}
	}

	public void Return() {
		this.isAvailable = true;
		this.borrowingUser = null;
	}
	
	public String toString() {
		return itemID + " - " + title;
	}
}
