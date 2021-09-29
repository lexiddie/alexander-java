package com.dlex.BinaryTree_LinkedList;

public class Node<T> {
    private T data;
    private Node link;

    public Node(T data) {
        this.data = data;
        this.link = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLink() {
        return link;
    }

    public void setLink(Node<T> link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return String.format("%b", this.data);
    }
}
