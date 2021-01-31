package br.com.abc.javacore.ZZCjdbc.test;

import br.com.abc.javacore.ZZCjdbc.classes.Buyer;
import br.com.abc.javacore.ZZCjdbc.classes.Car;
import br.com.abc.javacore.ZZCjdbc.db.CarDAO;

import java.util.List;
import java.util.Scanner;

public class CarCRUD {
    private static Scanner input = new Scanner(System.in);

    public static void execute(int op) {
        switch (op) {
            case 1:
                insert();
                break;
            case 2:
                update();
                break;
            case 3:
                list();
                break;
            case 4:
                System.out.println("Digite o nome ou parte do nome do Carro: ");
                searchByName(input.nextLine());
                break;
            case 5:
                delete();
                break;
            default:
                System.out.println("Saindo do sistema...");
                CRUDTest.setLogin(false);
                break;
        }
    }

    private static void insert() {
        Car car = new Car();
        System.out.println("Nome: ");
        car.setName(input.nextLine());
        System.out.println("Placa: ");
        car.setLicense_plate(input.nextLine());
        System.out.println("Selecione o numero de um dos Compradores abaixo:");
        List<Buyer> buyerList = BuyerCRUD.list();
        car.setBuyer(buyerList.get(Integer.parseInt(input.nextLine())));
        CarDAO.save(car);
        System.out.println();
    }

    private static void update() {
        System.out.println("Selecione o numero de um dos Carros abaixo:");
        List<Car> carList = list();
        Car car = carList.get(Integer.parseInt(input.nextLine()));
        System.out.println("Novo nome ou enter para manter o atual");
        String name = input.nextLine();
        System.out.println("Nova placa ou enter para manter a atual");
        String license_plate = input.nextLine();
        if (!name.isEmpty()) {
            car.setName(name);
        }
        if (!license_plate.isEmpty()) {
            car.setLicense_plate(license_plate);
        }
        CarDAO.update(car);
        System.out.println();
    }

    private static List<Car> list() {
        List<Car> carList = CarDAO.selectAll();
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            System.out.println("[" + i + "] " + car.getName() + " " + car.getLicense_plate() + " " + car.getBuyer().getName());
        }
        System.out.println();
        return carList;
    }

    private static void searchByName(String searchTerm) {
        List<Car> carLIst = CarDAO.searchByName(searchTerm);
        for (int i = 0; i < carLIst.size(); i++) {
            Car car = carLIst.get(i);
            System.out.println("[" + i + "] " + car.getName() + " " + car.getLicense_plate() + " " + car.getBuyer().getName());
        }
        System.out.println();
    }

    private static void delete() {
        System.out.println("Selecione um dos carros abaixo para deletar: ");
        List<Car> carList = list();
        Car car = carList.get(Integer.parseInt(input.nextLine()));
        System.out.println(car.getName() + " " + car.getLicense_plate());
        System.out.println("Tem certeza? Digite y para confirmar...");
        String confimation = input.nextLine();
        if (confimation.equalsIgnoreCase("y") || confimation.isEmpty())
            CarDAO.delete(car);
        else
            System.out.println("Comprador nao deletado");

        System.out.println();
    }
}
