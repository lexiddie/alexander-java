package com.dlex.GGHotel;

public class Customer {
	private String name;
	private int phoneNumber;

	public Customer(String name, int phoneNumber) {
		this.setName(name);
		this.setPhoneNumber(phoneNumber);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
