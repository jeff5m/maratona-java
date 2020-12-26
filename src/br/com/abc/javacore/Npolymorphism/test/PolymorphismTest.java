package br.com.abc.javacore.Npolymorphism.test;

import br.com.abc.javacore.Npolymorphism.classes.Employee;
import br.com.abc.javacore.Npolymorphism.classes.Manager;
import br.com.abc.javacore.Npolymorphism.classes.PaymentReport;
import br.com.abc.javacore.Npolymorphism.classes.Salesman;

public class PolymorphismTest {
    public static void main(String[] args) {
        Manager manager = new Manager("Maria Santos", 4500, 2363);
        Salesman salesman = new Salesman("Carlos Demetrio", 1800, 14728);
        PaymentReport report = new PaymentReport();

        Employee employee;
        employee = manager;
        System.out.println(employee);
        employee = salesman;
        System.out.println(employee);
        System.out.println("-------------------------------------------");

        report.GenericPaymentReport(manager);
        System.out.println("-------------------------------------------");
        report.GenericPaymentReport(salesman);
    }
}
