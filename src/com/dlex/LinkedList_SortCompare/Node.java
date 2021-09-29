package com.dlex.LinkedList_SortCompare;

public class Node {
    private String name;
    private Node link;

    public Node(String name) {
        this.name = name;
        this.link = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLink() {
        return link;
    }

    public void setLink(Node link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return String.format("%b", this.name);
    }
}
