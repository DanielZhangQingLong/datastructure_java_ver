package com.daniel.datastructures.queue;

public class Main {

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue();
        for (int i = 0; i < 5; i ++)
            queue.enqueue(i);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);

    }
}
