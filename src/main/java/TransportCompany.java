import lombok.*;

import java.awt.dnd.DragGestureEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@ToString
public class TransportCompany {

    private List<CarDriver> carDriverList;
    private List<Car> carList;
    private HashMap<Car, CarDriver> map;
    JDBC jdbc=new JDBC();
    public TransportCompany() {
        this.carDriverList = new ArrayList<>();
        this.carList = new ArrayList<>();
        this.map = new HashMap<>();
        jdbc.createTables();
    }

    public boolean addCarDriver( CarDriver carDriver ) {
        return carDriverList.add(carDriver);
    }

    public boolean addCar( Car car ) {
        return carList.add(car);
    }

    public void addToMap( Car car, CarDriver carDriver ) {
        if (car != null && carDriver != null) {
            map.putIfAbsent(car, carDriver);
        } else if (carDriver == null)
            System.out.println("Brak takiego kierowcy");
        else if (car==null){
            System.out.println("Brak takiego samochodu");
        }
        else System.out.println("Brak takiego samochodu i kierowcy");
    }

    public void replaceDriver( Car car, CarDriver carDriver ) {
        map.replace(car, carDriver);
    }

    public CarDriver getDriver( String name, String surname ) {
        CarDriver driver = new CarDriver(name, surname);
        for (CarDriver d : carDriverList) {
            if (d.equals(driver)) {
                return d;
            }
        }
        return null;
    }

    public Car getCar( String brand, String plate ) {

        for (Car c : carList) {
            if (brand.equals(c.getBrand()) && plate.equals(c.getPlateNumber())) {
                return c;
            }
        }
        return null;
    }
    public void addListToCarsTable()
    {
        for (Car c:carList) {
            jdbc.addToCar(c.getBrand(), c.getPlateNumber());
        }
    }
    public void printCars() {
        System.out.println(carList);
    }

    public void printCarDrivers() {
        System.out.println(carDriverList);
    }

    public void printMap() {
        System.out.println(map);
    }

}
