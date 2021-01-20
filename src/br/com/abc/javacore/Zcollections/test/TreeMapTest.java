package br.com.abc.javacore.Zcollections.test;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
//        TreeMap requires that the key value inserted implements Comparable, since the entries are sorted when inserted.
//        If not, a ClassCastException will be threw.

        NavigableMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("A", "Letra a");
        treeMap.put("D", "Letra d");
        treeMap.put("B", "Letra b");
        treeMap.put("C", "Letra c");
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println("------------------------------");
//        Useful methods:
//        .headMap() -> a view of the portion of this map whose keys are < or <=, if true is passed as second argument.
//        Important, both maps are linked, so changes in one of then, affects the other.
        System.out.println(treeMap.headMap("C", true));
        System.out.println("------------------------------");
//       .pollFirstEntry() -> returns the first entry of the map and removes it
//       .pollLastEntry() -> returns the last entry of the map and removes it
        System.out.println(treeMap.pollFirstEntry());
        System.out.println(treeMap.pollLastEntry());
        System.out.println(treeMap.size());
        System.out.println("------------------------------");

//        .lower() == <, .floor() <=, .higher() >, .ceiling() >=
//        returns the next element that satisfied the statement
        System.out.println(treeMap.lowerEntry("B"));
        System.out.println(treeMap.floorEntry("B"));
        System.out.println(treeMap.higherEntry("B"));
        System.out.println(treeMap.ceilingEntry("B"));
        System.out.println("------------------------------");

//        .descendingMap() -> returns the map in reverse order
        System.out.println(treeMap.descendingMap());

    }
}
