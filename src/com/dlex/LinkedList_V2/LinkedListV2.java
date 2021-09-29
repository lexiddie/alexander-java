package com.dlex.LinkedList_V2;

public class LinkedListV2 {

    private Node tail;

    public LinkedListV2() {
        this.tail = null;
    }

    public boolean insert(int Data) {
        Node newNode = new Node(Data);
        Node current = null;
        if (find(Data) == -1) {
            if (isEmpty()) {
                tail = newNode;
                return true;
            } else if (tail.getNext() == null) {
                current = newNode;
                current.setNext(tail);
                tail = current;
                return true;
            } else {
                Node previous = tail;
                current = newNode;
                current.setNext(previous);
                tail = current;
                return true;
            }
        }
        return false;
    }

    public boolean delete(int data) {

        Node current = tail;
        Node previous = null;
        while (current != null) {
            if (tail.getData() == data) {
                tail = current.getNext();
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
        Node current = tail;
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
        Node current = tail;
        while (current != null) {
            current = current.getNext();
            counter++;
        }
        return counter;
    }
    private boolean isEmpty() {
        return (tail == null);
    }

    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node current = tail;
        while (current != null) {
            result.append(" ");
            result.append(current.getData());
            current = current.getNext();
        }
        result.append(" ]");
        return result.toString();
    }
}
