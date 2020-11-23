package transportcompany;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Car {
    private String brand;
    private String plateNumber;

   /* public String generatePlateNumber() {
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
    }*/

    @Override
    public String toString() {
        return "\nSamochód:\n" +
                "Marka: " + brand + '\n' +
                "Nr rejestracyjny: " + plateNumber ;
    }
}
