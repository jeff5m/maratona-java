package br.com.abc.javacore.ZZDthreads.test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class NameList {
    private List<String> names = new LinkedList<>();

    public synchronized void add(String name) {
        names.add(name);
    }

    public synchronized void removeFirst() {
//        this class in not thread safe, because between the execution of this methods, other thread can operates.
//        to solve this, we can synchronize the external methods. So, because a class is thread safe, this doesn't mean
//        that the method of that class are 100% thread safe
        if (names.size() > 0) {
            System.out.println(names.remove(0));
        }
    }
}

public class ThreadSafeTest {
    public static void main(String[] args) {
        NameList names = new NameList();
        names.add("Anna");
        class namesRemover extends Thread {
            public void run() {
                names.removeFirst();
            }
        }

        new namesRemover().start();
        new namesRemover().start();
    }
}
