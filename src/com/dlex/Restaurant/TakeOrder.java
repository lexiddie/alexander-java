package com.dlex.Restaurant;

public class TakeOrder {
	private Node start;
	private Node end;

	
	public void insertFood(String code, String name, double price) {
		Restaurant r = new Restaurant(code.toLowerCase(),name,price);
		Node newNode = new Node(r,null);
		if (start == null) {
			start = newNode;
		} else {
			end.setNext(newNode);
		}
		end = newNode;
	}

	public int find(String code) {
		int index = 0;
		Node current = start;
		while (current != null) {
			if (current.getRestaurant().getCode().equals(code.toLowerCase())) {
				return index;
			} else {
				current = current.getNext();
			}
			index++;
		}
		return -1;
	}
	
	public void printHelper(Node start) {
		if (start != null) {
			System.out.println(start.getRestaurant().toString());
			printHelper(start.getNext());
		}
	}
	
	public void Print() {
		printHelper(start);
	}
	
	public int count() {
		int n = 0;
		Node current = start;
		while(current != null) {
			n +=1;
			return n;
		}
		return n;
	}
}
