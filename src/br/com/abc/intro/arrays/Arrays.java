package br.com.abc.intro.arrays;

public class Arrays {
    public static void main(String[] args) {
        // initialization methods
        int[] numbers = new int[5];
        int[] numbers2 = {1, 2, 3, 4, 5};  // only allowed in array declaration
        int[] numbers3 = new int[]{1, 2, 3, 4, 5};

        for (int i = 0; i < numbers2.length; i++) {
            System.out.println(numbers2[i]);
        }

        System.out.println("----------------");

        for (int number : numbers2) {
            System.out.println("forEach: " + number);
        }
    }
}
