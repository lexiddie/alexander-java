package com.dlex.LinkedList_GenericStack;

public class Node<T> {
    private T data;
    private Node<T> link;

    public Node() {
        this.data = null;
        this.link = null;
    }

    public Node(T data) {
        this.data = data;
        this.link = null;
    }

    public Node getLink()
    {
        return this.link;
    }

    public void setLink(Node<T> n)
    {
        link = n;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return String.format("%b", this.data);
    }
}
