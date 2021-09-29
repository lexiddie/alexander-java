package com.dlex.ConsCell;

public class IntList {

    private ConsCell start;

    public IntList() {
        this.start = null;
    }

    public void add(int value) {
        ConsCell newValue = new ConsCell(value);
        if (isEmpty()) {
            start = newValue;
        } else {
            ConsCell current = start;
            while (current.getTail() != null) {
                current = current.getTail();
            }
            current.setTail(newValue);
        }
    }

    public boolean contains(int x) {
        ConsCell current = start;
        while (current != null) {
            if (current.getHead() == x) {
                return true;
            } else {
                current = current.getTail();
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return start == null;
    }

    public int length() {
        int length = 0;
        ConsCell current = start;
        while (current != null) {
            length++;
            current = current.getTail();
        }
        return length;
    }


    public void print() {
        System.out.print("[");
        ConsCell current = start;
        while (current != null) {
            System.out.print(current.getHead());
            current = current.getTail();
            if (current != null) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
}