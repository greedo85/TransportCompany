import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {

    public static void main( String[] args ) {
        TransportCompany transportCompany=new TransportCompany();
        Scanner scanner = new Scanner(System.in);
        String name;
        String surname;
        String brand;
        char choice;
        do {
            System.out.println("1 - dodaj kierowcę");
            System.out.println("2 - dodaj samochód");
            System.out.println("3 - wyświetl kierowców");
            System.out.println("4 - wyświetl samochody");
            System.out.println("5 - przypisz kierowcę do samochodu");
            System.out.println("q - wyjdź");
            choice=scanner.next().charAt(0);
            switch (choice)
            {
                case '1':
                    System.out.println("Podaj imię:");
                    scanner.nextLine();
                    name=scanner.nextLine();
                    System.out.println("Podaj nazwisko:");
                    surname=scanner.nextLine();
                    transportCompany.addCarDriver(new CarDriver(name,surname));
                    break;
                case '2':
                    System.out.println("Podaj markę:");
                    scanner.nextLine();
                    brand=scanner.nextLine();
                    transportCompany.addCar(new Car(brand));
                    break;
                case '3':
                    transportCompany.printCarDrivers();
                    break;
                case '4':
                    transportCompany.printCars();
                    break;
                case '5':
                    System.out.println("Podaj imię:");
                    scanner.nextLine();
                    name=scanner.nextLine();
                    System.out.println("Podaj nazwisko:");
                    surname=scanner.nextLine();

                    System.out.println("Podaj markę:");
                    scanner.nextLine();
                    brand=scanner.nextLine();

                    break;
            }
        }
        while (choice!='q');
    }
}
