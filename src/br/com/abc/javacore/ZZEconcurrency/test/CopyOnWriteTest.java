package br.com.abc.javacore.ZZEconcurrency.test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

// immutable object.
final class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class CopyOnWriteTest implements Runnable {
    //    is immutable, this object is read-only. But is arrayList is mutable. If we delete an item, a new array will be
//    created and reference to reference variable. Its not 100% thread safe.
    private List<Integer> list = new CopyOnWriteArrayList<>();

    public CopyOnWriteTest() {
        for (int i = 0; i < 9000; i++) {
            list.add(i);
        }
    }

    @Override
    public void run() {
        Iterator<Integer> iterator = list.iterator();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (iterator.hasNext()) {
            System.out.println(Thread.currentThread().getName() + " " + iterator.next());
        }
    }

    public List<Integer> getList() {
        return list;
    }

    public static void main(String[] args) {
        CopyOnWriteTest ct = new CopyOnWriteTest();
        Thread t1 = new Thread(ct);
        Thread t2 = new Thread(ct);
//        iterator does not remove items
        Thread remover = new Thread(new RemoveMembers(ct.getList()));
        t1.start();
        t2.start();
        remover.start();
    }

    private static class RemoveMembers implements Runnable {
        private List<Integer> list;

        public RemoveMembers(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            for (int i = 0; i < 500; i++) {
                System.out.println(Thread.currentThread().getName() + " removeu: " + list.remove(i));
            }
        }
    }
}
