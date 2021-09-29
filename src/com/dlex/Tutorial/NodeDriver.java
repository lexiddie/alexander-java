package com.dlex.Tutorial;

public class NodeDriver {
    public static void main(String[] args) {
        Node firstNode = new Node(6);

        System.out.println(firstNode.toString());

        firstNode.setData(7);

        System.out.println(firstNode.toString());

        Node secondNode = new Node(123);

        System.out.println(secondNode.toString());

        firstNode.setNext(secondNode);
    }
}
