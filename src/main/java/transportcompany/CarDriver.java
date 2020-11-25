package transportcompany;

import lombok.*;


@EqualsAndHashCode
@Getter
public class CarDriver {

    private String name;
    private String surname;
    private String pesel;
    private int id;

    public void setId( int id ) {
        this.id = id;
    }

    public CarDriver( String name, String surname, String pesel ) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return "Kierowca:\n" +
                "Imię: " + name + '\n' +
                "Nazwisko: " + surname + '\n' +
                "PESEL: " + pesel +'\n'+
                "ID: "+id;
    }
}
