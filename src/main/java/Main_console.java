import java.util.InputMismatchException;
import java.util.Scanner;

public class Main_console {
    static TransportCompany transportCompany = new TransportCompany();
    static Scanner scanner = new Scanner(System.in);
    static String name;
    static String surname;
    static String brand;
    static String plate;
    static String pesel;
    static Car car;
    static CarDriver carDriver;

    public static void main( String[] args ) {
        char choice;
        try {
            do {
                menu();
                choice = scanner.next().charAt(0);
                switch (choice) {
                    case '1':
                        driverData();
                        transportCompany.addCarDriver(new CarDriver(name, surname,pesel));
                        break;
                    case '2':
                        scanner.nextLine();
                        carData();
                        car=new Car(brand);
                        transportCompany.addCar(car);
                        transportCompany.jdbc.addToCar(car.getBrand(),car.getPlateNumber());
                        transportCompany.printCars();
                        break;
                    case '3':
                        transportCompany.printCarDrivers();
                        break;
                    case '4':
                        transportCompany.printCars();
                        break;
                    case '5':
                        driverData();
                        carData();
                        plateData();
                        transportCompany.addToMap(transportCompany.getCar(brand, plate), transportCompany.getDriver(name, surname,pesel));
                        transportCompany.printMap();
                        break;
                    case '6':
                        carData();
                        plateData();
                        driverData();
                        transportCompany.replaceDriver(transportCompany.getCar(brand, plate), transportCompany.getDriver(name, surname,pesel));
                        transportCompany.printMap();
                }
            }
            while (choice != 'q');
        }
        catch (InputMismatchException e)
        {
            System.out.println("Zły wybór");
        }
    }


    private static void menu() {
        System.out.println("1 - dodaj kierowcę");
        System.out.println("2 - dodaj samochód");
        System.out.println("3 - wyświetl kierowców");
        System.out.println("4 - wyświetl samochody");
        System.out.println("5 - przypisz kierowcę do samochodu");
        System.out.println("6 - wymień kierowcę");
        System.out.println("q - wyjdź");
    }

    public static void driverData() {
        scanner.nextLine();
        System.out.println("Podaj imię:");
        name = scanner.nextLine();
        System.out.println("Podaj nazwisko:");
        surname = scanner.nextLine();
        System.out.println("Podaj PESEL:");
        pesel=scanner.nextLine();

    }

    public static void carData() {
        scanner.nextLine();
        System.out.println("Podaj markę:");
        brand = scanner.nextLine();

    }

    public static void plateData() {
        System.out.println("Podaj nr rejestracyjny:");
        plate = scanner.nextLine();
    }
}
