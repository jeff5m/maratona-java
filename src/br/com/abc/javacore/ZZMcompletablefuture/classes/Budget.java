package br.com.abc.javacore.ZZMcompletablefuture.classes;

import java.text.NumberFormat;
import java.text.ParseException;

// immutable class
public class Budget {
    private final String storeName;
    private final double price;
    private final Discount.Code discountCode;

    private Budget(String storeName, double price, Discount.Code discountCode) {
        this.storeName = storeName;
        this.price = price;
        this.discountCode = discountCode;
    }

    public static Budget parse(String s) {
        NumberFormat nf = NumberFormat.getInstance();
        String[] split = s.split(":");
        String storeName = split[0];
        double price = 0;
        try {
            price = nf.parse(split[1]).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Discount.Code discountCode = Discount.Code.valueOf(split[2]);
        return new Budget(storeName, price, discountCode);
    }

    public String getStoreName() {
        return storeName;
    }

    public double getPrice() {
        return price;
    }

    public Discount.Code getDiscountCode() {
        return discountCode;
    }
}
