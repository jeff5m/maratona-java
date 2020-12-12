package br.com.abc.javacore.methodsoverloading.classes;

public class Employee {
    private String name;
    private String cpf;
    private double salary;
    private String rg;

    public Employee(String name, String cpf, double salary, String rg) {
        this.name = name;
        this.cpf = cpf;
        this.salary = salary;
        this.rg = rg;
    }

    public Employee() {

    }

    public void init(String name, String cpf, double salary) {
        this.name = name;
        this.cpf = cpf;
        this.salary = salary;
    }

    public void init(String name, String cpf, double salary, String rg) {
        this.init(name, cpf, salary);
        this.rg = rg;
    }

    public void print() {
        System.out.println(this.name);  // could use the method name, in this case getName(), but that way is more readable
        System.out.println(this.cpf);
        System.out.println(this.salary);
        System.out.println(this.rg);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getRg() {
        return this.rg;
    }

    public String getName() {
        return this.name;
    }

    public String getCpf() {
        return this.cpf;
    }

    public double getSalary() {
        return this.salary;
    }
}