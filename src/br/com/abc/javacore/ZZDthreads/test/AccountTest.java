package br.com.abc.javacore.ZZDthreads.test;

import br.com.abc.javacore.ZZDthreads.classes.Account;

public class AccountTest implements Runnable {
    private Account account = new Account();

    public static void main(String[] args) {
        AccountTest accountTest = new AccountTest();
        Thread jeff = new Thread(accountTest, "Jeff");
        Thread marta = new Thread(accountTest, "Marta");
        jeff.start();
        marta.start();
    }
//    both threads, jeff and marta are trying to access the method .withdraw(), subtracting 10 from accounts balance.
//    in this scenario, we can't assure that the will stay positive, because, for example, marta can be interrupted
//    after pass the condition. Then jeff starts and subtracts the value. When marta start again, the value of the
//    balance maybe 0, but as its already pass the verification, it will continue and subtract 10 again. This is a very
//    hard kind of bug to fix. To prevent that, we can use the synchronized keyword in the signature of .withdraw().
//    This ensures that once a thread accesses .withdraw(), no other thread will be able to access that method while the
//    first thread isn't finish. But don't interferes in the order of the threads execution. "synchronized" can be use
//    in methods or blocks. If we use synchronized in a static method, the whole class will be lock.
    private synchronized void withdraw(Integer value) {
        if (account.getBalance() >= value) {
            System.out.println(Thread.currentThread().getName() + " esta indo sacar");
            account.withdraw(value);
            System.out.println(Thread.currentThread().getName() + " completou o saque. Saldo = " + account.getBalance());
        } else {
            System.out.println("saldo insuficiente para " + Thread.currentThread().getName() + ". Saldo = " + account.getBalance());
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            withdraw(10);
            if (account.getBalance() < 0)
                System.out.println("Falido!!!");
        }
    }
}
