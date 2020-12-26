package br.com.abc.javacore.Npolymorphism.test;

import br.com.abc.javacore.Npolymorphism.classes.DAODatabaseImplementation;
import br.com.abc.javacore.Npolymorphism.classes.GenericDAO;

public class DAOTest {
    public static void main(String[] args) {
        GenericDAO DAOFile = new DAODatabaseImplementation();
        DAOFile.save();
    }
}
