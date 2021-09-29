package com.dlex.Library_Node;

public class LinkedList {

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public boolean insertBook(Item book) {
        Node newNode = new Node(book);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        return true;
    }

    public boolean insertDVD(Item dvd) {
        Node newNode = new Node(dvd);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        return true;
    }


    public int findID(int id) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (current.getItem().id == id) {
                return index;
            } else {
                current = current.getNext();
            }
            index++;
        }
        return -1;
    }

    public int count() {
        int counter = 0;
        Node current = head;
        while (current != null) {
            current = current.getNext();
            counter++;
        }
        return counter;
    }

    private boolean isEmpty() {
        return (head == null);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            result.append(" ");
            result.append(current.getItem());
            current = current.getNext();
        }
        result.append(" ]");
        return result.toString();
    }
}
