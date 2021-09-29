package com.dlex.BookingHotel;

public class Hotel {
	private String name;
	private double price;
	private String location;
	
	public Hotel() {
		this.name = null;
		this.price = 0.0;
		this.location = null;
	}
	public Hotel(String name, double price, String location) {
		this.name = name;
		this.price = price;
		this.location = location;
	}
	public void setName(String name) {
		this.name = name ;
	}
	public String getName() {
		return this.name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return this.price;
	}
	public void setLocation(String location) {
		this.location= location;
	}
	public String getLocation() {
		return this.location;
	}
	public String toString() {
		return this.name + "--" + this.location + "--" + this.price + "Baht";
	}

}
