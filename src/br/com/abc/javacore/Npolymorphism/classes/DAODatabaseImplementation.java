package br.com.abc.javacore.Npolymorphism.classes;

public class DAODatabaseImplementation implements GenericDAO {
    public void save() {
        System.out.println("Salvando dados no banco de dados");
    }
}
