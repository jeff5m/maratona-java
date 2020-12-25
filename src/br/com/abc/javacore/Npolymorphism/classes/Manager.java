package br.com.abc.javacore.Npolymorphism.classes;

public class Manager extends Employee {
    private double profitShare;

    public Manager(String name, double salary, double profitShare) {
        super(name, salary);
        this.profitShare = profitShare;
    }

    @Override
    public void paymentCalculation() {
        this.salary += this.profitShare;
    }

    public double getProfitShare() {
        return profitShare;
    }

    public void setProfitShare(double profitShare) {
        this.profitShare = profitShare;
    }
}
