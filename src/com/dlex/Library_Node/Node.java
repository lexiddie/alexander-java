package com.dlex.Library_Node;

public class Node {
	protected Item item;
	protected Node next;

	public Node() {
		this.item = null;
		this.next = null;
	}

	public Node(Item item) {
		this.item = item;
		this.next = null;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
