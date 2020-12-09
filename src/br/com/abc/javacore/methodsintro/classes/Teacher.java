package br.com.abc.javacore.methodsintro.classes;

public class Teacher {
    public String name;
    public String registration;
    public String rg;
    public String cpf;

    public void printData() {
        System.out.println("-----------------");
        System.out.println(this.name);
        System.out.println(this.cpf);
        System.out.println(this.registration);
        System.out.println(this.rg);
    }
}
