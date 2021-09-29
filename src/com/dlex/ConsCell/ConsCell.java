package com.dlex.ConsCell;

public class ConsCell {
    private int head;
    private ConsCell tail;

    public ConsCell(int head) {
        this.head = head;
        this.tail = null;
    }

    public ConsCell (int head, ConsCell tail) {
        this.head = head;
        this.tail = tail;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public void setTail(ConsCell tail) {
        this.tail = tail;
    }

    public int getHead () {
        return head;
    }

    public ConsCell getTail () {
        return tail;
    }
}
