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
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
//        "class ThreadExample extends Thread" way
//        ThreadExample t1 = new ThreadExample('a');
//        ThreadExample t2 = new ThreadExample('b');
//        ThreadExample t3 = new ThreadExample('c');
//        ThreadExample t4 = new ThreadExample('d');
        Thread t1 = new Thread(new ThreadExampleRunnable('a')); // new
        Thread t2 = new Thread(new ThreadExampleRunnable('b'));
        Thread t3 = new Thread(new ThreadExampleRunnable('c'));
        Thread t4 = new Thread(new ThreadExampleRunnable('d'));
//        runnable. The scheduler decides when this thread will be running. After that, only th thread itself can
//        can decide if the state will be alter to waiting/blocking.
        t1.start();
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
