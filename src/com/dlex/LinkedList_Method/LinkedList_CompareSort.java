package com.dlex.LinkedList_Method;

public class LinkedList_CompareSort {
    private Node<String> head;

    public LinkedList_CompareSort() {
        this.head = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public boolean insert(String item) {
        Node<String> newNode = new Node(item);
        if (isEmpty()) {
            head = newNode;
        } else {
            int headSort = head.getData().compareTo(item);
            if (headSort > 0) {
                newNode.setLink(head);
                head = newNode;
            } else {
                Node<String> current = head.getLink();
                Node<String> previous = head;
                int currentSort = current.getData().compareTo(item);
                while (current != null && currentSort > 0) {
                    previous = current;
                    current = current.getLink();
                }
                newNode.setLink(current);
                previous.setLink(newNode);
            }
        }
        return true;
    }

    public boolean delete(String item) {
        Node<String> current = head.getLink();
        Node<String> previous = head;
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
}
