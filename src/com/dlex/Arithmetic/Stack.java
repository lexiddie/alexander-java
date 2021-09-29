package com.dlex.Arithmetic;

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
        Node<T> newNode = new Node<T>(item);
        if (!isEmpty()) {
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


    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return top.getData();
        }
    }

    public int count() {
        int counts = 0;
        Node<T> current = top;
        while (current != null) {
            current = current.getLink();
            counts++;
        }
        return counts;
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
