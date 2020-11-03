import lombok.*;

import java.util.Random;
@ToString
@Getter
@EqualsAndHashCode
public class Car {
    private String brand;
    private String plateNumber;

    public Car( String brand ) {
        this.brand = brand;
        this.plateNumber = generatePlateNumber();
    }

    public String generatePlateNumber() {
        int max;
        int min;
        String number="";
        for (int i = 0; i < 2; i++) {
            min = 65;
            max = 90;
            number += (char)( min + (int) (Math.random() * ((max - min) + 1)));
        }
        for (int i = 0; i < 5; i++) {
            min = 48;
            max = 57;
            number += (char)( min + (int) (Math.random() * ((max - min) + 1)));
        }
        return number;
    }
}