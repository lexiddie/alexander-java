package com.dlex.Library_ArrayList;

public class Book extends Item {

	protected int pageCount;
	protected String author;
	
	public Book(int ID, String title) {
		super(ID, title);
	}
	
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String toString() {
		return "Book: " + itemID + " - " + title;
	}
}
