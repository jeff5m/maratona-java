package br.com.abc.javacore.ZZDthreads.test;

// Daemon x user
// its not a good idea from an OOP point of view. A class should only be extended if it is specialized
class ThreadExample extends Thread {
    private char c;

    public ThreadExample(char c) {
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println("thread sendo executada: " + Thread.currentThread().getName());
        for (int i = 0; i < 1000; i++) {
            System.out.print(c);
            if (i % 100 == 0)
                System.out.println();
        }
    }
}

// its a good idea from an OOP point of view. This is the most common way to do it.
class ThreadExampleRunnable implements Runnable {
    private char c;

    public ThreadExampleRunnable(char c) {
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println("thread sendo executada: " + Thread.currentThread().getName());
        for (int i = 0; i < 1000; i++) {
            System.out.print(c);
            if (i % 100 == 0)
                System.out.println();

            if(!Thread.currentThread().getName().equals("t4"))
                Thread.yield();
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
//        "class ThreadExample extends Thread" way
//        ThreadExample t1 = new ThreadExample('a');
//        ThreadExample t2 = new ThreadExample('b');
//        ThreadExample t3 = new ThreadExample('c');
//        ThreadExample t4 = new ThreadExample('d');
        Thread t1 = new Thread(new ThreadExampleRunnable('a'),"T1"); // new
        Thread t2 = new Thread(new ThreadExampleRunnable('b'),"T2");
        Thread t3 = new Thread(new ThreadExampleRunnable('c'),"T3");
        Thread t4 = new Thread(new ThreadExampleRunnable('d'),"T4");
//        runnable. The scheduler decides when this thread will be running. After that, only th thread itself can
//        can decide if the state will be alter to waiting/blocking.
//        We can also define a priority for Threads. Priority is defined by the JVM specification. We should not develop
//        our system based on that. The priority range goes from 1 (min) to 10 (max). To set a priority we can call
//        the method setPriority() in the thread reference variable, passing as an argument the number that represents
//        the priority, but its a good practice use some of the constant values: MIN_PRIORITY, NORM_PRIORITY, MAX_PRIORITY

        t4.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t1.join();
        t2.start();
        t3.start();
        t4.start();
 /*
        Life cycle:
                  waiting/blocking
                   ↓           ↑
        new -> runnable <-> running -> dead
                                       ↓
                              after execute .run()
 */

    }
}
