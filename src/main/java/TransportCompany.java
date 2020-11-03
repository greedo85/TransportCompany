import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter

public class TransportCompany {

    private List<CarDriver> carDriverList;
    private List<Car> carList;

    public TransportCompany() {
        this.carDriverList = new ArrayList<>();
        this.carList = new ArrayList<>();
    }

    public void addCarDriver( CarDriver carDriver ) {
        carDriverList.add(carDriver);
    }

    public void addCar( Car car ) {
        carList.add(car);
    }
}
