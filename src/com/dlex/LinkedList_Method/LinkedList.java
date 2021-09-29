package com.dlex.LinkedList_Method;

public class LinkedList<T> {
    private Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    public boolean insert(T item) {
        Node<T> newNode = new Node(item);
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

    public boolean delete(T item) {
        Node<T> current = head.getLink();
        Node<T> previous = head;
        while (current != null) {
            if (head.getData().equals(item)) {
                head = head.getLink();
                return true;
            } else if (current.getData().equals(item)) {
                previous.setLink(current.getLink());
                return true;
            } else {
                previous = current;
                current = current.getLink();
            }
        }
        return false;
    }


    public boolean isEmpty() {
        return (head == null);
    }
}
