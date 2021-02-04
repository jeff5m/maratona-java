package br.com.abc.javacore.ZZCjdbc.interfaces;

import br.com.abc.javacore.ZZCjdbc.classes.Car;

import java.util.List;

public interface CarDAO {
    void save(Car car);

    void delete(Car car);

    void update(Car car);

    List<Car> selectAll();

    List<Car> searchByName(String searchTerm);
}
