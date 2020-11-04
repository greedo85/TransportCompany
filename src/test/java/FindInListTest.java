import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindInListTest {

    @Test
    public void findDriverTest() {
        //given
        TransportCompany transportCompany = new TransportCompany();
        CarDriver carDriver1 = new CarDriver("Mariusz", "Janowski");
        CarDriver carDriver2 = new CarDriver("Jan", "Kowalski");
        //when
        transportCompany.addCarDriver(carDriver1);
        transportCompany.addCarDriver(carDriver2);
        CarDriver driver3 = transportCompany.findDriver("Jan", "Kowalski");
        //then
        assertEquals(driver3, carDriver2);
    }

    @Test
    public void findCarTest() {
        //given
        TransportCompany transportCompany = new TransportCompany();
        Car car1 = new Car("Audi");
        Car car2 = new Car("Fiat");
        //when
        transportCompany.addCar(car1);
        transportCompany.addCar(car2);
        String plate = car2.getPlateNumber();
        System.out.println(car2);
        System.out.println(car2.getPlateNumber());
        Car car3 = transportCompany.findCar("Fiat", plate);

        //then
        assertEquals(car3, car2);

    }
}
