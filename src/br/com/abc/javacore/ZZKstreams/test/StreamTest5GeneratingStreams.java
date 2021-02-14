package br.com.abc.javacore.ZZKstreams.test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest5GeneratingStreams {
    public static void main(String[] args) {
//        stream of integers
        IntStream.rangeClosed(2, 100)
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        IntStream.range(2, 100)
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        OptionalDouble optionalDouble = Arrays.stream(numbers).average();
        System.out.println(optionalDouble.getAsDouble());

//        stream of strings
        Stream<String> stringStream = Stream.of("Jeff", "DevDojo", "Lee");
        stringStream.map(String::toUpperCase).forEach(s -> System.out.print(s + " "));
        System.out.println();

        Stream<Object> empty = Stream.empty();
        System.out.println(empty);

//        file
        try (Stream<String> filesStreaming = Files.lines(Paths.get("Arquivo.txt"), Charset.defaultCharset())) {
            filesStreaming.flatMap(line -> Arrays.stream(line.split("\n")))
                    .filter(p -> p.contains("arquivo"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        infinite streams - with those, is important to use .limit() to stop the execution
        Stream.iterate(1, n -> n + 2).limit(10).forEach(System.out::println);
//        fibonacci
        Stream
                .iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[0] + arr[1]})
                .limit(5)
                .forEach(arr -> System.out.println(Arrays.toString(arr)));
        Stream
                .iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[0] + arr[1]})
                .limit(15)
                .map(arr -> arr[0])
                .forEach(System.out::println);

        Stream.generate(Math::random).limit(10).forEach(System.out::println);
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        Stream.generate(() -> threadLocalRandom.nextInt(1,100)).limit(100).forEach(System.out::println);
    }
}
