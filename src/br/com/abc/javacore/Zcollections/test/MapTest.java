package br.com.abc.javacore.Zcollections.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
//         < K, V >
//        Hashmap can't have duplicate values to Keys. If a duplicated key have been inserted, it will
//        replace the previous one. Also, we can't guarantee the insertion order. If that is necessary,
//        LinkedHashMap is the one we choose.

        map.put("teklado", "teclado");
        map.put("mouze", "mouse");
        map.put("vc", "você");
        map.put("Meza", "mesa");

//        To iterates over, there are two ways:
//          1. Over Key or Value
//      to iterates over values, map.values()
//        for (String key : map.values()) {
//            System.out.println(key);
//        }
        System.out.println("-------------------------------");
//          2. Over Key and Value simultaneously
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " == " + entry.getValue());
        }

    }
}
