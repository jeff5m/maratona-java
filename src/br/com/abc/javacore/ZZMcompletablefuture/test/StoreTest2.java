package br.com.abc.javacore.ZZMcompletablefuture.test;

import br.com.abc.javacore.ZZMcompletablefuture.classes.Store;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class StoreTest2 {
    public static void main(String[] args) {
//        asynchronous requests without control from api
        List<Store> stores = asList(
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("amazon "),
                new Store("bestBuy"),
                new Store("walmart"),
                new Store("north"));
//        findPrices(stores);
        findPricesParallelStream(stores);
//        stream use a lazy loading so the CompletableFuture is not asynchronous, but sequential in this case
//        findPricesSequentialCompletableFuture(stores);
//        async CompletableFuture
        findPricesCompletableFuture(stores);
//        in performance matters, parallel streams and completableFuture are very similar.
//        The advantage of use CompletableFuture is that he allows to use a custom Executor and this improve performance
//        To use an Executor, we need to tell to our program the number of threads for our thread poll. To calculate
//        this number, Brian Goetz suggest use the formula:
//        Nthreads = Ncpu * Ucpu * (1 + W/C)
//        Ncpu = number of cores available
//        Ucpu = percentage of time utilization of cpu (0-1, where 1 its 100%)
//        W/C = Wait time and Compute time
//        Exemple:
//            Nthreads = 4 * 1 * (1+99) = 400
        final Executor executor = Executors.newFixedThreadPool(Math.min(stores.size(), 100), r -> {
            Thread t = new Thread(r);
            t.setDaemon(true); // this threads can be finished when the others non daemon thread are finished
            return t;
        });
        findPricesCompletableFuture(stores, executor);
//        when to use streams -> computing data without I/O, without wait data from any source
//        when to use CompletableFuture -> computing data with I/O, waiting for data from any source
    }

    private static List<String> findPrices(List<Store> stores) {
//    returns a string with stores name and price
        System.out.println("Stream sequencial");
        long start = System.currentTimeMillis();
        List<String> collect = stores.stream()
                .map(store -> String.format("%s o preco eh: %.2f", store.getName(), store.getPrice()))
                .collect(Collectors.toList());
        System.out.println("Tempo total " + (System.currentTimeMillis() - start) + " ms");
        System.out.println(collect);
        return collect;
    }

    private static List<String> findPricesParallelStream(List<Store> stores) {
//    returns a string with stores name and price
        System.out.println("Stream paralelo");
        long start = System.currentTimeMillis();
        List<String> collect = stores.parallelStream()
                .map(store -> String.format("%s o preco eh: %.2f", store.getName(), store.getPrice()))
                .collect(Collectors.toList());
        System.out.println("Tempo total " + (System.currentTimeMillis() - start) + " ms");
        System.out.println(collect);
        return collect;
    }

    private static List<String> findPricesSequentialCompletableFuture(List<Store> stores) {
//    returns a string with stores name and price
        System.out.println("Completable future sequencial");
        long start = System.currentTimeMillis();
        List<String> collect = stores.stream()
                .map(store -> CompletableFuture.supplyAsync(
                        () -> String.format("%s o preco eh: %.2f", store.getName(), store.getPrice())
                ))
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        System.out.println("Tempo de total " + (System.currentTimeMillis() - start) + " ms");
        System.out.println(collect);
        return collect;
    }

    private static List<String> findPricesCompletableFuture(List<Store> stores) {
//    returns a string with stores name and price
        System.out.println("Completable future");
        long start = System.currentTimeMillis();
        List<CompletableFuture<String>> futurePrice = stores.stream()
                .map(store -> CompletableFuture.supplyAsync(
                        () -> String.format("%s o preco eh: %.2f", store.getName(), store.getPrice())
                ))
                .collect(Collectors.toList());
        System.out.println("Tempo de invocacao eh de " + (System.currentTimeMillis() - start) + " ms");

        List<String> collect = futurePrice.stream().map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println("Tempo de total " + (System.currentTimeMillis() - start) + " ms");
        System.out.println(collect);
        return collect;
    }

    private static List<String> findPricesCompletableFuture(List<Store> stores, Executor executor) {
//    returns a string with stores name and price
        System.out.println("Completable future");
        long start = System.currentTimeMillis();
        List<CompletableFuture<String>> futurePrice = stores.stream()
                .map(store -> CompletableFuture
                        .supplyAsync(
                                () -> String.format("%s o preco eh: %.2f", store.getName(), store.getPrice()), executor
                        ))
                .collect(Collectors.toList());
        System.out.println("Tempo de invocacao eh de " + (System.currentTimeMillis() - start) + " ms");

        List<String> collect = futurePrice.stream().map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println("Tempo de total " + (System.currentTimeMillis() - start) + " ms");
        System.out.println(collect);
        return collect;
    }
}
