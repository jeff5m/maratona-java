package br.com.abc.javacore.Labstractclasses.classes;

public abstract class Person {
    protected String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public abstract void print();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
