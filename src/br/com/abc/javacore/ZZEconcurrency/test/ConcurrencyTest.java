package br.com.abc.javacore.ZZEconcurrency.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int count;
    private AtomicInteger atomicInteger = new AtomicInteger();
    private Lock lock = new ReentrantLock(true);

    public void increment() {
/*      this way, is not guaranteed that the result will be the expected
        count++;
        An alternative to synchronized is atomic integer that use CAS (compare and swap), which is thread safe.
        First the value is copy to a temp variable then incremented, then compare the temp variable value with the
        original. If it is different, the CPU will repeat the process without the interference of another thread.
        This is a better solution in performance matter the use synchronized in .increment()
        atomicInteger.getAndIncrement()                                                                               */

//        ReentrantLock does the same that synchronized, but is more complicated and advanced. Synchronized is more simple but
//        some task can't be done with it.
        lock.lock();
        try {
            count++;
            atomicInteger.getAndIncrement();
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }

    public int getAtomicInteger() {
        return atomicInteger.intValue();
    }
}

class IncrementerThread extends Thread {
    private Counter counter;

    public IncrementerThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
//        local variables are thread safe
        for (int i = 0; i < 10000; i++) {
            counter.increment();
        }
    }
}

public class ConcurrencyTest {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        IncrementerThread incrementerThread = new IncrementerThread(c);
        IncrementerThread incrementerThread2 = new IncrementerThread(c);
        incrementerThread.start();
        incrementerThread2.start();
        incrementerThread.join();
        incrementerThread2.join();
        System.out.println(c.getCount());
        System.out.println(c.getAtomicInteger());
    }
}
