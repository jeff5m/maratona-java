package br.com.abc.javacore.ZZMcompletablefuture.test;

import br.com.abc.javacore.ZZMcompletablefuture.classes.Store;

import java.util.List;
import java.util.concurrent.CompletableFuture;
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
//        The advantage of use CompletableFuture is that he allows to use a Executor
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
}
