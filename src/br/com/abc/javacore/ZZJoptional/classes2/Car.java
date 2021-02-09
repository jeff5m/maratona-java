package br.com.abc.javacore.ZZJoptional.classes2;

public class Car {
    private InsuranceCompany insuranceCompany;
    private String name;

    public String getInsuranceCompanyName(Person person) {
        if (person != null) {
            Car car = person.getCar();
            if (car != null) {
                InsuranceCompany insuranceCompany = car.getInsuranceCompany();
                if (insuranceCompany != null) {
                    return insuranceCompany.getName();
                }
            }
        }
        return "";
    }

    public InsuranceCompany getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
