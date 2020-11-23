package transportcompany;

import lombok.*;

import java.util.*;

@Getter

public class TransportCompany {

    private Set<CarDriver> carDriverHashSet;
    private Set<Car> carHashSet;
    private HashMap<Car, CarDriver> map;
    private JDBC jdbc;

    public TransportCompany() {
        jdbc = new JDBC();
        jdbc.createTables();
        this.carDriverHashSet = jdbc.getDriversFromDB();
        this.carHashSet = jdbc.getCarsFromDB();
        this.map = new HashMap<>();

    }

    public boolean addCarDriver( CarDriver carDriver ) {
        jdbc.addToDriver(carDriver.getName(), carDriver.getSurname(), carDriver.getPesel());
        return carDriverHashSet.add(carDriver);
    }

    public boolean addCar( Car car ) {
        jdbc.addToCar(car.getBrand(), car.getPlateNumber());
        return carHashSet.add(car);
    }

    public void addToMap( Car car, CarDriver carDriver ) {
        if (car != null && carDriver != null) {
            map.putIfAbsent(car, carDriver);
        } else if (carDriver == null)
            System.out.println("Brak takiego kierowcy");
        else if (car == null) {
            System.out.println("Brak takiego samochodu");
        } else System.out.println("Brak takiego samochodu i kierowcy");
    }

    public void replaceDriver( Car car, CarDriver carDriver ) {
        map.replace(car, carDriver);
    }

    public CarDriver getDriver( String name, String surname, String pesel ) {
        CarDriver driver = new CarDriver(name, surname, pesel);
        for (CarDriver d : carDriverHashSet) {
            if (d.equals(driver)) {
                return d;
            }
        }
        return null;
    }

    public Car getCar( String brand, String plate ) {

        for (Car c : carHashSet) {
            if (brand.equals(c.getBrand()) && plate.equals(c.getPlateNumber())) {
                return c;
            }
        }
        return null;
    }

    public void addListToCarsTable() {
        for (Car c : carHashSet) {
            jdbc.addToCar(c.getBrand(), c.getPlateNumber());
        }
    }

    public void printCars() {
        System.out.println(carHashSet);
    }

    public void printCarDrivers() {
        System.out.println(carDriverHashSet);
    }

    public void printMap() {
        System.out.println(map);
    }

}
