package br.com.abc.intro.fluxcontrol;

public class LoopExercise {
    public static void main(String[] args) {
        int limit = 100000;
        for (int i = 0; i <= limit ; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
