package br.com.abc.javacore.ZZMcompletablefuture.classes;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Store {
    private String name;

    public Store(String name) {
        this.name = name;
    }

    public Store() {
    }

    public double getPrice() {
//        goes far away get the price
        return calculatePrice();
    }

    public Future<Double> getPriceAsync() {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
//            another approach, less recommended
            try {
                futurePrice.complete(calculatePrice());
            } catch (Exception e) {
                futurePrice.completeExceptionally(e);
            }
        }).start();
        return futurePrice;
    }

//   same thing done in the .getPriceAsync()
    public Future<Double> getPriceAsyncTuning() {
        return CompletableFuture.supplyAsync(this::calculatePrice);
    }

    private double calculatePrice() {
        delay();
//        System.out.println(1/0);
        return ThreadLocalRandom.current().nextDouble() * 100;
    }

    private static void delay() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }
}
