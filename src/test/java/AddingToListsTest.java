import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddingToListsTest {

    @Test
    public void addDriverTest() {
        //given
        TransportCompany transportCompany = new TransportCompany();
        CarDriver carDriver1 = new CarDriver("Mariusz", "Janowski","333243214");

        //when
        transportCompany.addCarDriver(carDriver1);

        //then
        assertTrue(transportCompany.getCarDriverHashSet().contains(carDriver1));

    }

    @Test
    public void addCarTest() {
        //given
        TransportCompany transportCompany = new TransportCompany();
        Car car1 = new Car("Volvo");

        //when
        transportCompany.addCar(car1);

        //then
        assertTrue(transportCompany.getCarHashSet().contains(car1));

    }
}
