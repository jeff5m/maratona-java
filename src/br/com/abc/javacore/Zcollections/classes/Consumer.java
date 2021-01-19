package br.com.abc.javacore.Zcollections.classes;

public class Consumer {
    private String name;
    private String cpf;

    public Consumer(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Consumer consumer = (Consumer) o;

        return cpf != null ? cpf.equals(consumer.cpf) : consumer.cpf == null;
    }

    @Override
    public int hashCode() {
        return cpf != null ? cpf.hashCode() : 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
