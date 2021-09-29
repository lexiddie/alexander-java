package com.dlex.LinkedList_SortCompare;

public class CompareDemo {
    public static void main(String[] args) {
        CompareName list = new CompareName();
        list.insertName("Newt");
        list.insertName("Alexander");
        list.insertName("Solo");
        list.insertName("Apple");
        list.insertName("Green");
        list.insertName("Blue");
        System.out.println(list.toString());
    }
}
