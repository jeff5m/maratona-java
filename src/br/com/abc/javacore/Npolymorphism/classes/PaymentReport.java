package br.com.abc.javacore.Npolymorphism.classes;

public class PaymentReport {
    public void managerPaymentReport(Manager manager) {
        System.out.println("Gerando relatorio de pagamento da gerencia...");
        manager.paymentCalculation();
        System.out.println("Nome: " + manager.getName());
        System.out.println("Salario do mes: " + manager.getSalary());
    }

    public void salesmanPaymentReport(Salesman salesman) {
        System.out.println("Gerando relatorio de pagamento do vendedor...");
        salesman.paymentCalculation();
        System.out.println("Nome: " + salesman.getName());
        System.out.println("Salario do mes: " + salesman.getSalary());
    }
}
