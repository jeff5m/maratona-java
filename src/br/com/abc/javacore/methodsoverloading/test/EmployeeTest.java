package br.com.abc.javacore.methodsoverloading.test;

import br.com.abc.javacore.methodsoverloading.classes.Employee;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.init("Lee","123.456.678-91",3452, "11.222.333-44");
        employee.print();
    }
}
