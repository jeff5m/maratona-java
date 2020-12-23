package br.com.abc.javacore.Labstractclasses.classes;

public class Manager extends Employee {

    public Manager() {
    }

    public Manager(String name, String clt, double salary) {
        super(name, clt, salary);
    }

    @Override
    public void salaryCalc() {
        this.salary += salary*0.2;
    }

//    @Override
//    public void print() {
//        System.out.println("Dentro do metodo print_Manager");
//    }
}
