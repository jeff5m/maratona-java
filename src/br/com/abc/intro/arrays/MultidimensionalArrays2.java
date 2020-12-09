package br.com.abc.intro.arrays;

public class MultidimensionalArrays2 {
    public static void main(String[] args) {
        int[][] days = new int[3][];
        days[0] = new int[2];
        days[1] = new int[]{1, 2, 3};
        days[2] = new int[4];

        for (int[] arr : days) { // put each array into variable arr
            for (int day : arr) {
                System.out.println(day);
            }
        }

    }
}
