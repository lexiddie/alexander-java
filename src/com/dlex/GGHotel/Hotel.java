package com.dlex.GGHotel;

public class Hotel {
	private String name;
	private double price;
	private String location;
	private double star;
	private int room;
	private String availableDay;
	
	
	public Hotel() {
		this.name = null;
		this.price = 0.0;
		this.location = null;
		this.star = 0.0;
	}
	public Hotel(String name,String location,double price,double star,int room,String availableDay) {
		this.name = name;
		this.price = price;
		this.location = location;
		this.star = star;
		this.room = room;
		this.availableDay = availableDay;
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
	public void setStar(double star) {
		this.star = star ;
	}
	public double getStar() {
		return this.star;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public int getRoom() {
		return this.room;
	}
	public String getAvailableDay() {
		return availableDay;
	}
	public void setAvailableDay(String availableDay) {
		this.availableDay = availableDay + ",";
	}
	public String toString() {
		return String.format("%-40s%-20s%-15.2f%-17.2f%-15d%s", name,location,price,star,room,availableDay);
	}
}
