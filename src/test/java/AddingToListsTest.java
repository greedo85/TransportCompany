import org.junit.Test;
import org.junit.platform.engine.support.discovery.EngineDiscoveryRequestResolver;

public class AddingToListsTest {

    @Test
    public void addDriverTest()
    {
        //given
        TransportCompany transportCompany=new TransportCompany();
        Driver driver1=new Driver("Mariusz","Janowski");

        //when
        transportCompany.addDriver(driver1);

        //then
        assertTrue(transportCompany.getDriverList().contains(driver1));

    }

    @Test
    public void addCarTest()
    {
        //given
        TransportCompany transportCompany=new TransportCompany();
        Car car1 = new Car()

    }
}
