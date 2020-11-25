package transportcompany;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode

public class Car {
    private String brand;
    private String plateNumber;
    private int id;

    public void setId( int id ) {
        this.id = id;
    }

    public Car( String brand, String plateNumber ) {
        this.brand = brand;
        this.plateNumber = plateNumber;
    }

    @Override
    public String toString() {
        return "\nSamochód:\n" +
                "Marka: " + brand + '\n' +
                "Nr rejestracyjny: " + plateNumber + '\n'+
                "ID: "+id;
    }
}
