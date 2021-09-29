package com.dlex.LinkedList_GenericStack;

public class StackDriver {
    public static void main(String[] args) {
        Stack<String> list = new Stack();
        list.push("s");
        list.push("o");
        list.push("l");
        list.push("o");
        System.out.println(list.toString());
        System.out.println(list.getTopItem());
        System.out.println(list.pop());
        System.out.println(list.toString());
    }
}
