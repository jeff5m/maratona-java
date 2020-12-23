package br.com.abc.javacore.Labstractclasses.classes;

public abstract class Employee extends Person {
    protected String clt;
    protected double salary;

    public Employee() {
    }

    public Employee(String name, String clt, double salary) {
        super(name);
        this.clt = clt;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + this.name + '\'' +
                ", clt='" + this.clt + '\'' +
                ", salary=" + this.salary +
                '}';
    }

    @Override
    public void print() {
        System.out.println("Dentro do metodo print_Employee");
    }

    public abstract void salaryCalc();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClt() {
        return clt;
    }

    public void setClt(String clt) {
        this.clt = clt;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
