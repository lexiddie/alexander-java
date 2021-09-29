package com.dlex.BookingHotel;

import java.util.Objects;

public class HotelLinkedList {
	private Node start;
	private Node end;

	public void insertHotel(String name, String location, double price) {
		Hotel data = new Hotel(name, price, location);
		Node newNode = new Node(data);

		if (isEmpty()) {
			start = newNode;
		} else {
			end.setNext(newNode);
		}
		end = newNode;
	}

	public void Print() {
		Node current = start;
		while (current != null) {
			System.out.println(current);
			current = current.getNext();
		}
	}

	public void searchLocation(String location) {
		Node current = this.start;
		while (current != null) {
			if (current.getHotel().getLocation().equals(location)) {
				System.out.println(current.getHotel().toString());
			}
			current = current.getNext();
		}
	}

	public int count() {
		int counter = 0;
		Node current = this.start;
		while (current != null) {
			current = current.getNext();
			counter++;
		}
		return counter;
	}

	private boolean isEmpty() {
		return this.start == null;
	}

	public void searchingHelper(Node start, String destination) {
		Node current = start;
		while (current != null) {
			if (Objects.equals(current.getHotel().getLocation(), destination)) {
				System.out.println(current.getHotel());
			}
			current = current.getNext();

		}

	}

}
