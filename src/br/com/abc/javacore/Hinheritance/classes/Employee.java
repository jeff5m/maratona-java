package br.com.abc.javacore.Hinheritance.classes;

public class Employee extends Person {
    private double salary;

    public void print() {
        super.print();
        System.out.println("Salario: " + this.salary);
        this.paymentReceipt();
    }

    public void paymentReceipt() {
        System.out.println("Eu, " + super.name + ", recibe o pagamento de " + this.salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
