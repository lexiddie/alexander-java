package com.dlex.LinkedList_SortCompare;

public class CompareName {
    private Node head;

    public CompareName() {
        head = null;
    }

    public boolean insertName(String name) {
        Node newNode = new Node(name);
        if (isEmpty()) {
            head = newNode;
        } else {
            int compareHead = head.getName().compareTo(name);
            System.out.print(compareHead);
            if (compareHead > 0) {
                newNode.setLink(head);
                head = newNode;
            } else {
                Node current = head.getLink();
                Node previous = head;
                int compare = current.getName().compareTo(name);
                while (current != null && compare > 0) {
                    previous = current;
                    current = current.getLink();
                }
                newNode.setLink(current);
                previous.setLink(newNode);
            }
        }
        return true;
    }
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != null) {
            String name = String.format("%10s", current.getName());
            result.append(name).append("\n");
            current = current.getLink();
        }
        return result.toString();
    }
}
