package br.com.abc.javacore.ZZMcompletablefuture.classes;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Discount {
    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), ELITE(20);
        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }

        public int getPercentage() {
            return percentage;
        }
    }

    public static String calculateDiscount(Budget budget) {
        return String.format("%s o preco original: %.2f, desconto: %d, " +
                        " preco final: %.2f",
                budget.getStoreName(),
                budget.getPrice(),
                budget.getDiscountCode().getPercentage(),
                calculation(budget.getPrice(), budget.getDiscountCode()));
    }

    private static double calculation(double price, Code code) {
        delay();
        return price * (100 - code.percentage) / 100; // value will never be zero
    }

    private static void delay() {
        try {
            int delay = ThreadLocalRandom.current().nextInt(500, 2000);
            TimeUnit.MILLISECONDS.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
