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

    public TransportCompany() {
        this.carDriverList = new ArrayList<>();
        this.carList = new ArrayList<>();
        this.map = new HashMap<>();
    }

    public boolean addCarDriver( CarDriver carDriver ) {
        return carDriverList.add(carDriver);
    }

    public boolean addCar( Car car ) {
        return carList.add(car);
    }

    public void addToMap( Car car, CarDriver carDriver ) {
        map.putIfAbsent(car, carDriver);
    }

    public void printCars() {
        System.out.println(carList);
    }

    public void printCarDrivers() {
        System.out.println(carDriverList);
    }

    public CarDriver findDriver( String name, String surname ) {
        CarDriver driver = new CarDriver(name, surname);
        for (CarDriver d : carDriverList) {
            if (d.equals(driver)) {
                return d;
            }
        }
        return null;
    }
}
