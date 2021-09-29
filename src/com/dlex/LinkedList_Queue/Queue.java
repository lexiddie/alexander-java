package com.dlex.LinkedList_Queue;

public class Queue<T> {
    private Node<T> first;
    private Node<T> last;

    public Queue() {
        this.first = null;
        this.last = null;
    }
    public boolean isEmpty() {
        return (first == null);
    }
    public boolean isFull() {
        return false;
    }
    public boolean enqueue(T item) {
        Node<T> newNode = new Node<T>(item);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.setLink(newNode);
        }
        last = newNode;
        return true;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            Node<T> current = first;
            first = current.getLink();
            return current.getData();
        }
    }

    public T getFront() {
        return first.getData();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = first;
        while (current != null) {
            sb.append(" ");
            sb.append(current.getData());
            current = current.getLink();
        }
        sb.append(" ]");
        return sb.toString();
    }

}
