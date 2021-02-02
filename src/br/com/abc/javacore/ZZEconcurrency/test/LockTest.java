package br.com.abc.javacore.ZZEconcurrency.test;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        final ReentrantLock reentrantLock = new ReentrantLock();
        new Thread(new Worker("A", reentrantLock)).start();
        new Thread(new Worker("B", reentrantLock)).start();
        new Thread(new Worker("C", reentrantLock)).start();
        new Thread(new Worker("D", reentrantLock)).start();
        new Thread(new Worker("E", reentrantLock)).start();
        new Thread(new Worker("F", reentrantLock)).start();
        new Thread(new Worker("G", reentrantLock)).start();
    }

    static class Worker implements Runnable {
        private String name;
        private ReentrantLock reentrantLock;

        public Worker(String name, ReentrantLock reentrantLock) {
            this.name = name;
            this.reentrantLock = reentrantLock;
        }

        @Override
        public void run() {
            reentrantLock.lock();
            try {
                if (reentrantLock.isHeldByCurrentThread())
                    System.out.printf("Thread %s entrou em uma seção crítica(possui lock) %n", name);
//                just for didactic proposers, since a new thread can enter the queue any time
                System.out.printf("%d Treads esperando na fila%n", reentrantLock.getQueueLength());
                System.out.printf("Thread %s vai trabalhar por 2 segundos%n", name);
                Thread.sleep(2000);
                System.out.printf("Thread %s finalizou o trabalho %n", name);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}
