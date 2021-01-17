package br.com.abc.javacore.Yserialization.classes;

import java.io.Serializable;

public class SchoolClass {
    private String name;

    public SchoolClass(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SchoolClass{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
