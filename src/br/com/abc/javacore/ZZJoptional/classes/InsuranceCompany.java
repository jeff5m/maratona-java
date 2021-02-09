package br.com.abc.javacore.ZZJoptional.classes;

import java.util.Optional;

public class InsuranceCompany {
    private String name;

    public InsuranceCompany(String name) {
        this.name = name;
    }

    public InsuranceCompany() {
    }

    @Override
    public String toString() {
        return "InsuranceCompany{" +
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

