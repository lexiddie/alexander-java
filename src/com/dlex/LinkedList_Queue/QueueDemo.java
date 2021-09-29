package com.dlex.LinkedList_Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("solo");
        queue.enqueue("han");
        queue.enqueue("alexander");
        queue.enqueue("luther");

        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        System.out.println(queue.getFront());
    }
}
