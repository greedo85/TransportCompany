import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MapTest {

    static TransportCompany transportCompany;
    static CarDriver carDriver1;
    static CarDriver carDriver2;
    static Car car1;
    static Car car2;

    @BeforeAll
    public static void init() {
        transportCompany = new TransportCompany();
        carDriver1 = new CarDriver("Adam", "Kowalski");
        carDriver2 = new CarDriver("Jan", "Matuszewski");
        car1 = new Car("Volvo");
        car2 = new Car("Fiat");
    }


    @Test
    public void addToMapTest() {
        //when
        transportCompany.addCar(car1);
        transportCompany.addCarDriver(carDriver1);
        transportCompany.addToMap(car1, carDriver1);

        //then
        assertEquals(carDriver1, transportCompany.getMap().get(car1));

    }

    @Test
    public void replaceDriverTest() {
        //when
        transportCompany.addCar(car1);
        transportCompany.addCarDriver(carDriver1);
        transportCompany.addCarDriver(carDriver2);
        transportCompany.addToMap(car1, carDriver1);
        transportCompany.replaceDriver(car1, carDriver2);
        //then
        assertEquals(carDriver2, transportCompany.getMap().get(car1));
    }
}
