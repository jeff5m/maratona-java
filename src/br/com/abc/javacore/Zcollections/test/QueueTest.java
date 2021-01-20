package br.com.abc.javacore.Zcollections.test;

import br.com.abc.javacore.Zcollections.classes.Consumer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class ConsumerNameComparator implements Comparator<Consumer> {
    @Override
    public int compare(Consumer o1, Consumer o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

public class QueueTest {
    public static void main(String[] args) {
//        The priority is defined by us with the Comparable interface. But we can pass a Comparator in the constructor
        Queue<Consumer> queue = new PriorityQueue<>(new ConsumerNameComparator());
        Consumer consumer1 = new Consumer("Jeff", "123");
        Consumer consumer2 = new Consumer("Marlon", "456");
        Consumer consumer3 = new Consumer("Carlos", "987");
        Consumer consumer4 = new Consumer("Anne", "345");
        queue.add(consumer1);
        queue.add(consumer2);
        queue.add(consumer3);
        queue.add(consumer4);
        System.out.println(queue);
        System.out.println("----------------------------------");

        Queue<String> queue2 = new PriorityQueue<>();
        queue2.add("D");
        queue2.add("B");
        queue2.add("A");
        queue2.add("C");
        while (!queue2.isEmpty())
            System.out.println(queue2.poll());
        System.out.println("----------------------------------");

//        Important methods
        System.out.println(queue2.remove());
        System.out.println(queue2.peek());
        System.out.println(queue2.poll());

    }
}
