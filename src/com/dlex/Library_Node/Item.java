package com.dlex.Library_Node;

public class Item {
	protected int id;
	protected String title;
	protected User borrowUser;
	protected String author;
	protected boolean isAvailable;

	public Item() {
		this.title = null;
		this.id = 0;
		this.borrowUser = null;
		this.isAvailable = true;
	}

	public Item(int id, String title) {
		this.id = id;
		this.title = title;
		this.borrowUser = null;
		this.author = null;
		this.isAvailable = true;
	}

	public Item(int id, String title, User borrowUser, String author, boolean isAvailable) {
		this.id = id;
		this.title = title;
		this.borrowUser = borrowUser;
		this.author = author;
		this.isAvailable = isAvailable;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getBorrowUser() {
		return borrowUser;
	}

	public void setBorrowUser(User borrowUser) {
		this.borrowUser = borrowUser;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean available) {
		isAvailable = available;
	}

	public void Borrow(User User) {
		if (isAvailable) {
			this.borrowUser = User;
			this.isAvailable = false;
		} else {
			System.out.print( "This item borrow by " + User);
		}
	}
	public void Return() {
		this.isAvailable = true;
		this.borrowUser = null;
	}
	
	public String toString() {
		return id + "--" +title;
	}

}
