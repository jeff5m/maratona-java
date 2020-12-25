package br.com.abc.javacore.Npolymorphism.classes;

public class PaymentReport {
    public void GenericPaymentReport(Employee employee) {
        System.out.println("Gerando relatorio de pagamento...");
        employee.paymentCalculation();
        System.out.println("Nome: " + employee.getName());
        System.out.println("Salario do mes: " + employee.getSalary());
    }
}
