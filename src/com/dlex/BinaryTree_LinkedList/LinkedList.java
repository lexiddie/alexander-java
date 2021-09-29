package com.dlex.BinaryTree_LinkedList;

public class LinkedList<T> {

    private Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    public boolean insert(T Data) {
        Node<T> newNode = new Node<T>(Data);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getLink() != null) {
                current = current.getLink();
            }
            current.setLink(newNode);
        }
        return true;
    }

    public boolean delete(T data) {
        Node<T> current = head;
        Node previous = null;
        while (current != null) {
            if (head.getData() == data) {
                head = current.getLink();
                return true;
            }
            else if (current.getData() == data) {
                previous.setLink(current.getLink());
                return true;
            }
            else {
                previous = current;
                current = current.getLink();
            }
        }
        return false;
    }


    public int count() {
        int counter = 0;
        Node<T> current = head;
        while (current != null) {
            current = current.getLink();
            counter++;
        }
        return counter;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            result.append(" ");
            result.append(current.getData());
            current = current.getLink();
        }
        result.append(" ]");
        return result.toString();
    }
}
