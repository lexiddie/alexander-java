package com.dlex.BinaryTree_LinkedList;

public class DriverBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(5);
        binaryTree.insert(4);
        binaryTree.insert(1);
        binaryTree.insert(6);
        binaryTree.insert(9);
        binaryTree.insert(3);
        binaryTree.insert(7);
        binaryTree.insert(8);

        binaryTree.print();

        System.out.println();

        LinkedList<Integer> result = binaryTree.toLinkedList();

        System.out.println(result.toString());
    }
}
