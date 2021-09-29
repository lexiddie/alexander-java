package com.dlex.Restaurant;

public class Restaurant {
	private String code;
	private String name;
	private double price;
	
	public Restaurant() {
		this.code = null;
		this.name = null;
		this.price = 0.0;
	}
	
	public Restaurant(String code, String name, double price) {
		this.code = code;
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return this.code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getPrice() {
		return this.price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		return String.format("%-20s%-20s", code,name,price)+"$";
	}

}
