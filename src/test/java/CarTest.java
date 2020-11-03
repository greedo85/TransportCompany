import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class CarTest {

    @Test
    public void generatePlateNumberTest() {
        //given
        Car car1;

        //when
        car1 = new Car("Mazda");
        System.out.println(car1);
        System.out.println(car1.getPlateNumber());
        //then
        assertEquals(7, car1.getPlateNumber().length());

    }
}
