package br.com.abc.javacore.ZZEconcurrency.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class ThreadWorkerExecutor implements Runnable {
    private String number;

    public ThreadWorkerExecutor(String number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " iniciou: " + number);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finalizou");
    }
}

public class ExecutorTest {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
//        threadPoolExecutor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        executorService.execute(new ThreadWorkerExecutor("1"));
        executorService.execute(new ThreadWorkerExecutor("2"));
        executorService.execute(new ThreadWorkerExecutor("3"));
        executorService.execute(new ThreadWorkerExecutor("4"));
        executorService.shutdown();
        while (!executorService.isTerminated()) {}
        System.out.println(executorService.isTerminated());
        System.out.println("Finalizado");
    }
}
