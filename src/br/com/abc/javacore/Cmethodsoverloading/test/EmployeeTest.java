package br.com.abc.javacore.Cmethodsoverloading.test;

import br.com.abc.javacore.Cmethodsoverloading.classes.Employee;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee employee = new Employee("Lee","123.456.678-91",3452, "11.222.333-44");
//        employee.init("Lee","123.456.678-91",3452, "11.222.333-44");
        Employee employee2 = new Employee();

        employee.print();
        employee2.print();
    }
}
