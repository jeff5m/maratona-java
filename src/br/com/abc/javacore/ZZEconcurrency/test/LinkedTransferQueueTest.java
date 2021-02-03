package br.com.abc.javacore.ZZEconcurrency.test;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueTest {
    public static void main(String[] args) throws InterruptedException {
//        More efficient to work with queues
        TransferQueue<String> tq = new LinkedTransferQueue<>();
        System.out.println(tq.add("Lee"));
        tq.put("Jeff");
        System.out.println(tq.offer("Lee"));
        System.out.println(tq.offer("Lee", 10, TimeUnit.MILLISECONDS));
        tq.put("Jeff");
//        tq.transfer("Lee");
        System.out.println(tq.tryTransfer("Asdf"));
        System.out.println(tq.tryTransfer("Asdf", 10, TimeUnit.SECONDS));
        System.out.println(tq.remainingCapacity());

        System.out.println(tq.element());
        System.out.println(tq.peek());
        System.out.println(tq.poll());
        System.out.println(tq.poll(10, TimeUnit.MILLISECONDS));
        System.out.println(tq.remove());
        System.out.println(tq.take());
    }
}
