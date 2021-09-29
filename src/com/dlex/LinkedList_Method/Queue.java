package com.dlex.LinkedList_Method;

public class Queue<T> {
    private Node<T> first;
    private Node<T> last;

    public Queue() {
        this.first = null;
        this.last = null;
    }

    public boolean enqueue(T item) {
        Node<T> newNode = new Node(item);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.setLink(newNode);
        }
        last = newNode;
        return true;
    }

    public boolean isEmpty() {
        return (first == null);
    }
}
