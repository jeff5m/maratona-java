package br.com.abc.javacore.ZZEconcurrency.classes;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MembersList {
    private final Queue<String> emails = new LinkedList<>();
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition conditionLock = lock.newCondition();
    private boolean open = true;

    public Integer getPendingEmails() {
        lock.lock();
        try {
            return emails.size();
        } finally {
            lock.unlock();
        }
    }

    public boolean isOpen() {
        return open;
    }

    public String getMemberEmail() {
        String email = null;
        try {
            lock.lock();
            while (emails.size() == 0) {
                if (!open)
                    return null;
                System.out.println("lista de emails vazia. Colocando a thread " + Thread.currentThread().getName() + " em modo WAIT");
                conditionLock.await();
            }
            email = emails.poll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return email;
    }

    public void addMemberEmail(String email) {
        lock.lock();
        try {
            emails.add(email);
            System.out.println("email adicionado a lista");
            System.out.println("notificando as threads que estao em espera");
            conditionLock.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void closeEmailList() {
        System.out.println("notificando todas as threads e fechando a lista");
        open = false;
        lock.lock();
        try {
            conditionLock.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
