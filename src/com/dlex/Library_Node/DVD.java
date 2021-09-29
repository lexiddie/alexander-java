package com.dlex.Library_Node;

public class DVD extends Item {
	int duration;

	public DVD(int id, String title) {
		super(id, title);
		this.duration = 0;
	}

	public DVD(int id, String title, int duration) {
		super(id, title);
		this.duration = duration;
	}

	public DVD(int id, String title, User borrowUser, String author, boolean isAvailable, int duration) {
		super(id, title, borrowUser, author, isAvailable);
		this.duration = duration;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
}
