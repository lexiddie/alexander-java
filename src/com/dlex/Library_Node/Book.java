package com.dlex.Library_Node;

public class Book extends Item {

	private int pageCount;

	public Book(int id, String title) {
		super(id, title);
		this.pageCount = 0;
	}

	public Book(int id, String title, int pageCount) {
		super(id, title);
		this.pageCount = pageCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public String toString() {
		return "Book: " + id + " - " + title;
	}

}


