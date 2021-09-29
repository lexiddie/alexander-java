package com.dlex.GGHotel;

public class Node {
	Hotel hotel;
	Node next;
	
	public Node() {
		this.hotel = null;
		this.next = null;
	}
	public Node(Hotel hotel, Node next) {
		this.hotel = hotel;
		this.next = next;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public Hotel getHotel() {
		return this.hotel;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getNext() {
		return this.next;
	}
}
