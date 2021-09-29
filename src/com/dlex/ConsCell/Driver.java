package com.dlex.ConsCell;

public class Driver {
    public static void main(String[] args) {
        IntList list = new IntList();
        list.add(5);
        list.add(3);
        list.add(8);
        list.add(20);
        list.add(150);
        list.add(200);
        list.add(40);
        list.add(15);
        list.print();
        boolean result = list.contains(22);
        System.out.println();
        System.out.println("This result is " + result);
    }
}
