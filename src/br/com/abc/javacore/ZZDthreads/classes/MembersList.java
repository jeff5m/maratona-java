package br.com.abc.javacore.ZZDthreads.classes;

import java.util.LinkedList;
import java.util.Queue;

public class MembersList {
    private final Queue<String> emails = new LinkedList<>();
    private boolean open = true;

    public Integer getPendingEmails() {
        synchronized (emails) {
            return emails.size();
        }
    }

    public boolean isOpen() {
        return open;
    }

    public String getMemberEmail() {
        String email = null;
        try {
            synchronized (emails) {
                while (emails.size() == 0) {
                    if (!open)
                        return null;
                    System.out.println("lista de emails vazia. Colocando a thread " + Thread.currentThread().getName() + " em modo WAIT");
                    emails.wait();
                }
                email = emails.poll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return email;
    }

    public void addMemberEmail(String email) {
        synchronized (emails) {
            emails.add(email);
            System.out.println("email adicionado a lista");
            System.out.println("notificando as threads que estao em espera");
            emails.notifyAll();
        }
    }

    public void closeEmailList() {
        System.out.println("notificando todas as threads e fechando a lista");
        open = false;
        synchronized (emails) {
            this.emails.notifyAll();
        }
    }
}
