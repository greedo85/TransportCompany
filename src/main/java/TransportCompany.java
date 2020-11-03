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

    public void addCarDriver( CarDriver carDriver ) {
        carDriverList.add(carDriver);
    }

    public void addCar( Car car ) {
        carList.add(car);
    }

    public void addToMap( Car car, CarDriver carDriver ) {
        map.putIfAbsent(car, carDriver);
    }
}
