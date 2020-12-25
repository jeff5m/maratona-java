package br.com.abc.javacore.Npolymorphism.test;

import br.com.abc.javacore.Npolymorphism.classes.Manager;
import br.com.abc.javacore.Npolymorphism.classes.PaymentReport;
import br.com.abc.javacore.Npolymorphism.classes.Salesman;

public class PolymorphismTest {
    public static void main(String[] args) {
        Manager manager = new Manager("Maria Santos", 4500, 2363);
        Salesman salesman = new Salesman("Carlos Demetrio", 1800, 14728);
        PaymentReport report = new PaymentReport();

        report.managerPaymentReport(manager);
        System.out.println("-------------------------------------------");
        report.salesmanPaymentReport(salesman);
    }
}
