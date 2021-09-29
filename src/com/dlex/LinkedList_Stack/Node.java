package com.dlex.LinkedList_Stack;

public class Node {
    private int data;
    private Node link;

    public Node() {
        this.data = 0;
        this.link = null;
    }

    public Node(int data, Node node) {
        this.data = data;
        this.link = node;
    }

    public Node getLink()
    {
        return this.link;
    }

    public void setLink(Node n)
    {
        link = n;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return String.format("%d", this.data);
    }
}
