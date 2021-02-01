package br.com.abc.javacore.ZZDthreads.classes;

public class Account {
    private Integer balance = 50;

    public Integer getBalance() {
        return balance;
    }

    public void withdraw(Integer value) {
        balance -= value;
    }
}
