package com.dlex.GG;

public class Node {
    private Cinema cinema;
    private Node link;

    public Node() {
        this.cinema = null;
        this.link = null;
    }

    public Node(Cinema cinema) {
        this.cinema = cinema;
        this.link = null;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Node getLink() {
        return link;
    }

    public void setLink(Node link) {
        this.link = link;
    }
}
