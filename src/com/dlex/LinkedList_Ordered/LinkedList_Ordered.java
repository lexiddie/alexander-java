package com.dlex.LinkedList_Ordered;

public class LinkedList_Ordered {

    private Node head;

    public LinkedList_Ordered() {
        this.head = null;
    }

    public boolean insert(int Data) {
        Node newNode = new Node(Data);
        if (find(Data) == -1) {
            if (isEmpty()) {
                head = newNode;
                return true;
            } else {
                if (head.getData() > Data) {
                    newNode.setNext(head);
                    head = newNode;
                    return true;
                } else {
                    Node current = head.getNext();
                    Node previous = head;
                    while (current != null && current.getData() < Data) {
                        previous = current;
                        current = current.getNext();
                    }
                    newNode.setNext(current);
                    previous.setNext(newNode);
                    return true;
                }
            }
        }
        return false;
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
