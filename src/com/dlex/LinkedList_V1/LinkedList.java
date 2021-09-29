package com.dlex.LinkedList_V1;

public class LinkedList {

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public boolean insert(int Data) {
        Node newNode = new Node(Data);
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

    public boolean delete(int data) {
        Node current = head;
        Node previous = null;
        while (current != null) {
            if (head.getData() == data) {
                head = current.getNext();
                return true;
            }
            else if (current.getData() == data) {
                assert previous != null;
                previous.setNext(current.getNext());
                return true;
            }
            else {
                previous = current;
                current = current.getNext();
            }
        }
        return false;
    }

    public int find(int data) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (current.getData() == data) {
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
            result.append(current.getData());
            current = current.getNext();
        }
        result.append(" ]");
        return result.toString();
    }
}
