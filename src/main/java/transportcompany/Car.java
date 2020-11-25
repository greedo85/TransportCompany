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

    @Override
    public String toString() {
        return "\nSamochód:\n" +
                "Marka: " + brand + '\n' +
                "Nr rejestracyjny: " + plateNumber ;
    }
}
