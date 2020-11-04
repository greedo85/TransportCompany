import org.junit.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddToMapTest {

    @Test
    public void addToMapTest() {
        //given
        TransportCompany transportCompany = new TransportCompany();
        CarDriver carDriver1 = new CarDriver("Adam", "Kowalski");
        Car car1 = new Car("Volvo");

        //when
        transportCompany.addCar(car1);
        transportCompany.addCarDriver(carDriver1);
        transportCompany.addToMap(car1, carDriver1);
        System.out.println(transportCompany);

        //then
        assertEquals(carDriver1, transportCompany.getMap().get(car1));

    }
}
