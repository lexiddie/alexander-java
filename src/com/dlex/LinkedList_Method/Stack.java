package com.dlex.LinkedList_Method;

public class Stack<T> {
    private Node<T> top;

    public boolean isEmpty() {
        return (top == null);
    }

    public boolean push(T item) {
        Node<T> newNode = new Node(item);
        if (!isEmpty()) {
            newNode.setLink(top);
        }
        top = newNode;
        return true;
    }
}
