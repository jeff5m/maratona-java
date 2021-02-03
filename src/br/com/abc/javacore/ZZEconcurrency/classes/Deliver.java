package br.com.abc.javacore.ZZEconcurrency.classes;

public class Deliver implements Runnable {
    private MembersList membersList;

    public Deliver(MembersList membersList) {
        this.membersList = membersList;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "comecando o trabalho de entrega");
        int pendingEmails = membersList.getPendingEmails();
        boolean open = membersList.isOpen();
        while (open || pendingEmails > 0) {
            try {
                String email = membersList.getMemberEmail();
                if (email != null)
                    System.out.println(threadName + ". Enviando email para " + email);
                Thread.sleep(2000);
                System.out.println("Envio para " + email + " concluido com sucesso");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            open = membersList.isOpen();
            pendingEmails = membersList.getPendingEmails();
        }
        System.out.println("atividades finalizadas");
    }
}
