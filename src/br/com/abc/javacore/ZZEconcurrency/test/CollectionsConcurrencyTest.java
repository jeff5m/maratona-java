package br.com.abc.javacore.ZZEconcurrency.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CollectionsConcurrencyTest {
    public static void main(String[] args) {
//        ConcurrentHashMap
//        ConcurrentLinkedDeque
//        ConcurrentLinkedQueue
//        ConcurrentSkipListMap
//        ConcurrentSkipListSet
//
//        this collections don't have CopyOnWrite behavior. The iterator is weakly consistent. This allows multiple
//        threads to read and write concurrently. This collections are faster then copyOnWrite.

//        Since Java 8, the methods in ConcurrentHashMap was incorporated in Map interface
//        adds the capacity of perform atomic operations. The .putIfAbsent() will only add if the key doesn't exist.
        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        map.put("1", "1");
        map.putIfAbsent("1", "2");
        System.out.println(map.size());
    }
}
