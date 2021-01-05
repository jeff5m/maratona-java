package br.com.abc.javacore.Rstrings.test;

public class StringPerformanceTest {
    public static void main(String[] args) {
//        get operation time traditional way
        long begging = System.currentTimeMillis();
            stringConcat(30000);
        long end = System.currentTimeMillis();
        System.out.println("Tempo gasto "+(end-begging)+" ms");

//        using string builder
        long begging2 = System.currentTimeMillis();
        stringBuilderConcat(500000);
        long end2 = System.currentTimeMillis();
        System.out.println("Tempo gasto "+(end2-begging2)+" ms");

//        using string buffer
//        string buffer is the same as builder but it offers protection in multi-thread environment. slower then builder
        long begging3 = System.currentTimeMillis();
        stringBufferConcat(500000);
        long end3 = System.currentTimeMillis();
        System.out.println("Tempo gasto "+(end3-begging3)+" ms");
    }

    private static void stringConcat(int length) {
        String string = "";
        for(int i=0;i<length;i++) {
            string += i;
        }
    }

    private static void stringBuilderConcat(int length) {
       StringBuilder sb = new StringBuilder(length);
        for(int i=0;i<length;i++) {
            sb.append(i);
        }
    }

    private static void stringBufferConcat(int length) {
        StringBuffer sb = new StringBuffer(length);
        for(int i=0;i<length;i++) {
            sb.append(i);
        }
    }
}
