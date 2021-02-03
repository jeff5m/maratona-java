package br.com.abc.javacore.ZZEconcurrency.test;

import br.com.abc.javacore.ZZEconcurrency.classes.Deliver;
import br.com.abc.javacore.ZZEconcurrency.classes.MembersList;

import javax.swing.*;

public class DeliverTest {
    public static void main(String[] args) {
        MembersList membersList = new MembersList();
        Thread t1 = new Thread(new Deliver(membersList), "Deliver 1");
        Thread t2 = new Thread(new Deliver(membersList), "Deliver 2");
        t1.start();
        t2.start();
        while(true) {
            String email = JOptionPane.showInputDialog("Digite o email do membro");
            if(email == null || email.isEmpty()){
                membersList.closeEmailList();
                break;
            }
            membersList.addMemberEmail(email);
        }
    }
}
