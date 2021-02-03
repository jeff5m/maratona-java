package br.com.abc.javacore.ZZEconcurrency.test;

import java.util.concurrent.*;

public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(1);
//        SynchronousQueue
//        DelayQueue
        Thread t1 = new Thread(new RemoveFromQueue(blockingQueue));
        blockingQueue.put("Lee");
        System.out.println(blockingQueue.peek());
        System.out.println("Tentando colocar outro valor");
        t1.start();
        blockingQueue.put("Jeff");
        System.out.println("Inserido ultimo valor");
    }

    static class RemoveFromQueue implements Runnable {
        private BlockingQueue<String> bq;

        public RemoveFromQueue(BlockingQueue<String> bq) {
            this.bq = bq;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " entrando em espera por 2s");
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Removendo o valor: " + bq.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
