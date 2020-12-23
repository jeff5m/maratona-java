package br.com.abc.javacore.Labstractclasses.test;

import br.com.abc.javacore.Labstractclasses.classes.Manager;
import br.com.abc.javacore.Labstractclasses.classes.Salesman;

public class EmployeeTest {
    public static void main(String[] args) {
        Manager manager = new Manager("Anna Neri", "12345-6",2000.00);
        Salesman salesman = new Salesman("Marcos Costa", "2123-5",1500,4000);
        manager.salaryCalc();
        salesman.salaryCalc();
        System.out.println(manager);
        manager.print();
        System.out.println("-------------------------------");
        System.out.println(salesman);
        salesman.print();
    }
}
