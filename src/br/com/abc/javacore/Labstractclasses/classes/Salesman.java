package br.com.abc.javacore.Labstractclasses.classes;

public class Salesman extends Employee {

    private double totalSales;

    public Salesman() {
    }

    public Salesman(String name, String clt, double salary, double totalSales) {
        super(name, clt, salary);
        this.totalSales = totalSales;
    }

    @Override
    public void salaryCalc() {
        this.salary += totalSales*0.05;
    }

    @Override
    public void print() {
        System.out.println("Dentro do metodo print_Salesman");
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }
}
