import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindInListTest {

    @Test
    public void findDriverTest() {
        //given
        TransportCompany transportCompany = new TransportCompany();
        CarDriver carDriver1 = new CarDriver("Mariusz", "Janowski","543543252542");
        CarDriver carDriver2 = new CarDriver("Jan", "Kowalski","341343141");
        //when
        transportCompany.addCarDriver(carDriver1);
        transportCompany.addCarDriver(carDriver2);
        CarDriver driver3 = transportCompany.getDriver("Jan", "Kowalski","32132343214");
        //then
        assertEquals(driver3, carDriver2);
    }

    @Test
    public void findCarTest() {
        //given
        TransportCompany transportCompany = new TransportCompany();
        Car car1 = new Car("Audi","s2321321");
        Car car2 = new Car("Fiat","21321213");
        //when
        transportCompany.addCar(car1);
        transportCompany.addCar(car2);
        String plate = car2.getPlateNumber();
        Car car3 = transportCompany.getCar("Fiat", plate);

        //then
        assertEquals(car3, car2);

    }
}
