package com.dlex.BinaryTree_LinkedList;

public class BinaryTree {

    private TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int data) {

        if (root == null) {
            root = new TreeNode(data);
            System.out.println("Start at Root\n" );
            System.out.println("insert " + data + " at root");
        } else {
            insertData(data, root);
        }
    }

    private void insertData(int data, TreeNode node) {
        if (data <= node.getData()) {
            if (node.getLeft() == null) {
                System.out.println("insert " + data + " at left of root " + node.getData());
                node.setLeft(new TreeNode(data));
            } else {
                insertData(data, node.getLeft());
            }
        } else {
            if (node.getRight() == null) {
                System.out.println("insert " + data + " at right of root " + node.getData());
                node.setRight(new TreeNode(data));
            } else {
                insertData(data, node.getRight());
            }
        }
    }

    public void print() {
        printSort(root);
    }

    private void printSort(TreeNode node) {
        if (node != null) {
            printSort(node.getLeft());
            System.out.print(node.getData() + " ");
            printSort(node.getRight());
        }
    }

    public boolean hasValue(int data) {
        return hasValueCheck(root, data);
    }

    private boolean hasValueCheck(TreeNode node, int data) {
        if (node == null) {
            return false;
        } else if (data == node.getData()) {
            return true;
        } else if (data < node.getData()) {
            return hasValueCheck(node.getLeft(), data);
        } else {
            return hasValueCheck(node.getRight(), data);
        }
    }

    public LinkedList<Integer> toLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        return insertBinaryTree(root, linkedList);
    }

    private LinkedList<Integer> insertBinaryTree(TreeNode root, LinkedList<Integer> list) {
        if (root != null) {
            insertBinaryTree(root.getLeft(), list);
            list.insert(root.getData());
            insertBinaryTree(root.getRight(), list);
        }
        return list;
    }
}











