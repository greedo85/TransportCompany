package transportcompany;

import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class CarDriver {

    private String name;
    private String surname;
    private String pesel;
    @Override
    public String toString() {
        return "Kierowca:\n" +
                "Imię: " + name + '\n' +
                "Nazwisko: " + surname + '\n' +
                "PESEL: " + pesel +'\n';
    }
}
