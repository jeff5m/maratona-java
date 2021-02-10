package br.com.abc.javacore.ZZKstreams.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class StreamTest2 {
    public static void main(String[] args) {
        List<List<String>> names = new ArrayList<>();
        names.add(asList("DevDojo", "Melhor curso de Java"));
        names.add(asList("Academy", "A segunda tah ainda melhor"));
        System.out.println(names);
//        to concatenate this values. flatMap is used when we have values inside values and we need to extract them.
        List<String> collect = names.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(collect);
        collect.forEach(System.out::println);

        List<String> words = asList("Ola", "Tisubasa");
        String[] split = words.get(0).split("");
        System.out.println(Arrays.toString(split));

        List<String> collect2 =
                words.stream()
//                     apply a function to each value and return the values in a new Stream
                     .map(p -> p.split(""))
//                     function that receive a Stream and return another Stream of values combining all the values received.
                     .flatMap(Arrays::stream)
                     .collect(Collectors.toList());
        System.out.println(collect2);
    }
}
