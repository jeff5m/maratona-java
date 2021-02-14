package br.com.abc.javacore.ZZLparallelstreams.test;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreams1 {
    public static void main(String[] args) {
        long num = 10_000_000L;
        sumFor(num);
//        not a good idea to use streams to do that kind of operation, not even parallel streams.
//        The traditional for is faster. But a better way to do it using streams is using LongStream
        sumStreamIterate(num);
        sumParallelStreamIterate(num);
        sumStreamRangClosed(num);
        sumParallelStreamIterate(num);
//        print available threads in the system
        System.out.println(Runtime.getRuntime().availableProcessors());
//        change the number of available threads in the system
//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");

    }

    private static void sumFor(long n) {
        System.out.println("For: ");
        long result = 0;
        long init = System.currentTimeMillis();
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + " ms");
    }

    private static void sumStreamIterate(long n) {
        System.out.println("Stream sequencial: ");
        long result = 0;
        long init = System.currentTimeMillis();
        result = Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + " ms");
    }

    private static void sumParallelStreamIterate(long n) {
        System.out.println("Stream paralelo: ");
        long result = 0;
        long init = System.currentTimeMillis();
        result = Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + " ms");
    }

    private static void sumStreamRangClosed(long n) {
        System.out.println("Stream range closed sequencial: ");
        long result = 0;
        long init = System.currentTimeMillis();
        result = LongStream.rangeClosed(1L, n).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + " ms");
    }

    private static void sumParallelStreamRangClosed(long n) {
        System.out.println("Stream range closed paralelo: ");
        long result = 0;
        long init = System.currentTimeMillis();
        result = LongStream.rangeClosed(1L, n).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + " ms");
    }
}
