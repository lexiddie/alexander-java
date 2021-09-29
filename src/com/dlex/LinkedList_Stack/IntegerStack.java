package com.dlex.LinkedList_Stack;

public class IntegerStack {
    private Node top;

    public IntegerStack() {
        this.top = null;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public boolean isFull() {
        return false;
    }

    public int getSize()
    {
        int counts = 0;
        Node current = top;
        while (current != null) {
            current = current.getLink();
            counts++;
        }
        return counts;
    }
    public boolean push(int item)
    {
        Node newNode = new Node (item,null);
        if (top != null) {
            newNode.setLink(top);
        }
        top = newNode;
        return true;
    }

    public int pop()
    {
        if (isEmpty()) {
            return -1;
        } else {
            Node item = top;
            top = item.getLink();
            return item.getData();
        }

    }
    public int getTopItem() {
        if (isEmpty()) {
            return -1;
        } else {
            return top.getData();
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node current = top;
        while (current != null) {
            result.append(" ");
            result.append(current.getData());
            current = current.getLink();
        }
        result.append(" ]");
        return result.toString();
    }

}
