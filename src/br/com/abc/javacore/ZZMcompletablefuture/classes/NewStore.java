package br.com.abc.javacore.ZZMcompletablefuture.classes;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.asList;

public class NewStore {
    private String name;

    public NewStore(String name) {
        this.name = name;
    }

    public NewStore() {
    }

//        return NomeDaLoja:Preco:CodigoDeDesconto
    public String getBudgetString() {
        double price = calculatePrice();
        Discount.Code code = Discount.Code.values()[ThreadLocalRandom.current().nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", this.name, price, code);
    }

    private double calculatePrice() {
        delay();
        return ThreadLocalRandom.current().nextDouble() * 100;
    }

    private static void delay() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public static List<NewStore> stores() {
         return asList(
                new NewStore("amazon"),
                new NewStore("bestBuy"),
                new NewStore("walmart"),
                new NewStore("north"));
    }
}
