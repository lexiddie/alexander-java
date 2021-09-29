package com.dlex.Restaurant;

public class Node {
	Restaurant res;
	Node next;
	
	public Node(Restaurant res, Node next) {
		this.res = res;
		this.next = next;
	}
	public void setHotel(Restaurant res) {
		this.res = res;
	}
	public Restaurant getRestaurant() {
		return this.res;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getNext() {
		return this.next;
	}
	
}
