package br.com.abc.intro.arrays;

public class MultidimensionalArrays {
    public static void main(String[] args) {
        // each position in the first array stores a ref to a second array, so on and so forth
        int[][] days = new int[2][2];
        days[0][0] = 30;
        days[0][1] = 31;
        days[1][0] = 29;
        days[1][1] = 28;

        //traditional for
        for (int i = 0; i < days.length; i++) {
            System.out.println(days[i]);
            for (int j = 0; j < days[i].length; j++) {
                System.out.println(days[i][j]);
            }
        }

        System.out.println("-----------------");

        // foreach
        for (int[] refArrDay : days) {
            System.out.println(refArrDay);
            for(int day : refArrDay) {
                System.out.println(day);
            }
        }
    }
}
