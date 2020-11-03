import org.junit.Test;

public class FindDriverTest {

    @Test
    public void findDriverTest()
    {
        //giver
        TransportCompany transportCompany=new TransportCompany();
        CarDriver carDriver1 =new CarDriver("Mariusz","Janowski");
        CarDriver carDriver2 =new CarDriver("Jan","Kowalski");
        //when
        transportCompany.addCarDriver(carDriver1);
        transportCompany.addCarDriver(carDriver2);
        Car driver3 = transportCompany.findDriver("Jan","Kowalski");
        //then
        assertEquals(driver3,carDriver2);
    }
}