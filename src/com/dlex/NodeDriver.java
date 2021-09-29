package com.dlex;

public class NodeDriver {

    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(10);
        Node node3 = new Node(8);
        node1.setNext(node2);
        node2.setNext(node3);

        System.out.print(list(node1));
    }

    public static String list(Node head) {
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
