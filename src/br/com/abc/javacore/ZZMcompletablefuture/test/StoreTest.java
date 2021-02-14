package br.com.abc.javacore.ZZMcompletablefuture.test;

import br.com.abc.javacore.ZZMcompletablefuture.classes.Store;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class StoreTest {
    public static void main(String[] args) {
//        synchronous flow
        Store amazon = new Store();
        Store bestBuy = new Store();
        Store walmart = new Store();
        Store north = new Store();
//        long start = System.currentTimeMillis();
//        System.out.println(amazon.getPrice());
//        System.out.println(bestBuy.getPrice());
//        System.out.println(walmart.getPrice());
//        System.out.println(north.getPrice());
//        long end = System.currentTimeMillis();
//        System.out.println(end - start + " ms");

        long start2 = System.currentTimeMillis();
        Future<Double> priceAsync = amazon.getPriceAsync();
        Future<Double> priceAsync1 = bestBuy.getPriceAsync();
        Future<Double> priceAsync2 = walmart.getPriceAsync();
        Future<Double> priceAsync3 = north.getPriceAsync();
        long end2 = System.currentTimeMillis();
        System.out.println("Tempo de invocacao dos metodos: " + (end2 - start2) + " ms");
        delaying();
        try {
            System.out.println("amazon " + priceAsync.get());
            System.out.println("bestBuy " + priceAsync1.get());
            System.out.println("walmart " + priceAsync2.get());
            System.out.println("north " + priceAsync3.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Tempo que levou para pegar o resultado " + (System.currentTimeMillis() - start2) + " ms");
    }

    private static void delaying() {
        long sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
