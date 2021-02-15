package br.com.abc.javacore.ZZMcompletablefuture.test;

import br.com.abc.javacore.ZZMcompletablefuture.classes.Budget;
import br.com.abc.javacore.ZZMcompletablefuture.classes.Discount;
import br.com.abc.javacore.ZZMcompletablefuture.classes.NewStore;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NewStoreTest {
    public static void main(String[] args) {
        List<NewStore> stores = NewStore.stores();
//        stores.stream().forEach(newStore -> System.out.println(newStore.getPrice()));
//        findPrices(stores);
        final Executor executor = Executors.newFixedThreadPool(Math.min(stores.size(), 100), r -> {
            Thread t = new Thread(r);
            t.setDaemon(true); // this threads can be finished when the others non daemon thread are finished
            return t;
        });
//        findPricesAsync(stores, executor);
        long start = System.currentTimeMillis();
        CompletableFuture[] completableFutures = findPricesStream(stores, executor)
                .map(f -> f.thenAccept(s -> System.out.println(s + " finalizado em : " +
                        (System.currentTimeMillis() - start) + " ms")))
                .toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(completableFutures).join();
//        CompletableFuture.anyOf(completableFutures).join();  return the first ready
        System.out.println("todas as lojas respoderam em: " + (System.currentTimeMillis() - start) + " ms");
    }

    private static List<String> findPrices(List<NewStore> stores) {
        System.out.println("Stream sequencial");
        long start = System.currentTimeMillis();
        List<String> collect = stores.stream()
                .map(NewStore::getBudgetString)
                .map(Budget::parse)
                .map(Discount::calculateDiscount)
                .collect(Collectors.toList());
        System.out.println("Tempo total " + (System.currentTimeMillis() - start) + " ms");
        System.out.println(collect);
        return collect;
    }

    private static List<String> findPricesAsync(List<NewStore> stores, Executor executor) {
        System.out.println("Completable Future Async");
        long start = System.currentTimeMillis();
        List<CompletableFuture<String>> completableFutures = stores.stream()
//                get original budget String in an asynchronous way
                .map(store -> CompletableFuture.supplyAsync(store::getBudgetString, executor))
//                when the result is ready, transform into a Budget instance
                .map(future -> future.thenApply(Budget::parse))
//                when the first async request is available, compose the first future with one more async request to get the the discounts
                .map(future -> future.thenCompose(budget ->
                        CompletableFuture.supplyAsync(() -> Discount.calculateDiscount(budget), executor)))
                .collect(Collectors.toList());
//        wait all the future instances in the stream be finished to extract their results
        List<String> collect = completableFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        System.out.println("Tempo total " + (System.currentTimeMillis() - start) + " ms");
        System.out.println(collect);
        return collect;
    }

    private static Stream<CompletableFuture<String>> findPricesStream(List<NewStore> stores, Executor executor) {
        System.out.println("Completable Future Async Stream");
        long start = System.currentTimeMillis();
        Stream<CompletableFuture<String>> completableFutureStream = stores.stream()
                .map(store -> CompletableFuture.supplyAsync(store::getBudgetString, executor))
                .map(future -> future.thenApply(Budget::parse))
                .map(future -> future.thenCompose(budget ->
                        CompletableFuture.supplyAsync(() -> Discount.calculateDiscount(budget), executor)));
        System.out.println("Tempo total " + (System.currentTimeMillis() - start) + " ms");
        return completableFutureStream;
    }
}

