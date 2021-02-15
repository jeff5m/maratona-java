package br.com.abc.javacore.ZZMcompletablefuture.test;

import br.com.abc.javacore.ZZMcompletablefuture.classes.Budget;
import br.com.abc.javacore.ZZMcompletablefuture.classes.Discount;
import br.com.abc.javacore.ZZMcompletablefuture.classes.NewStore;

import java.util.List;
import java.util.stream.Collectors;

public class NewStoreTest {
    public static void main(String[] args) {
        List<NewStore> stores = NewStore.stores();
//        stores.stream().forEach(newStore -> System.out.println(newStore.getPrice()));
        findPrices(stores);
    }

    private static List<String> findPrices(List<NewStore> stores) {
        System.out.println("Stream sequencial");
        long start = System.currentTimeMillis();
        List<String> collect = stores.stream()
                .map(NewStore::getPrice)
                .map(Budget::parse)
                .map(Discount::calculateDiscount)
                .collect(Collectors.toList());
        System.out.println("Tempo total " + (System.currentTimeMillis() - start) + " ms");
        System.out.println(collect);
        return collect;
    }
}

