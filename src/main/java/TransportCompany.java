import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter

public class TransportCompany {

    private List<Driver> driverList;
    private List<Car> carList;

    public TransportCompany() {
        this.driverList = new ArrayList<>();
        this.carList = new ArrayList<>();
    }

    public void addDriver( Driver driver ) {
        driverList.add(driver);
    }

    public void addCar( Car car ) {
        carList.add(car);
    }
}
