package com.dlex.ConversionV2;

public class Stack<T> {

    private Node<T> top;

    public Stack() {
        this.top = null;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public boolean isFull() {
        return false;
    }

    public boolean push(T item) {
        Node<T> newNode = new Node(item);
        if (top != null) {
            newNode.setLink(top);
        }
        top = newNode;
        return true;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        } else {
            Node<T> current = top;
            top = current.getLink();
            return current.getData();
        }
    }

    public T getTopItem() {
        if (isEmpty()) {
            return null;
        } else {
            Node<T> current = top;
            return current.getData();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = top;
        while (current != null) {
            sb.append(" ");
            sb.append(current.getData());
            current = current.getLink();
        }
        sb.append(" ]");
        return sb.toString();
    }

}
