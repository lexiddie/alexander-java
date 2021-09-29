package com.dlex.LinkedList_Stack;

public class StackDriver {
    public static void main(String[] args) {
        IntegerStack is = new IntegerStack();
        is.push(5);
        is.push(4);
        is.push(7);
        is.push(15);
        is.push(22);
        
        System.out.println("Does our stack is Empty true or false? " + is.isEmpty());
        System.out.println("We going to pop item out of the stack: " + is.pop());
        System.out.println("We going to find Top item: " + is.getTopItem());
        System.out.println(is.toString());
        System.out.println("Does the stack is full true or false: " + is.isFull());
        System.out.println(is.getSize());
    }
}
