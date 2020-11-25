package transportcompany;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class JDBC {

    private static final String url = "jdbc:sqlite:";
    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;
    DatabaseMetaData databaseMetaData;
    ResultSet resultSet;

    public JDBC() {

        createDataBase("transportcompany.db");
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createDataBase( String dbName ) {
        try {
            connection = DriverManager.getConnection(url + dbName);
            if (connection != null) {
                databaseMetaData = connection.getMetaData();
                System.out.println("Nazwa sterownika bazy danych to: " + databaseMetaData.getDriverName());
                System.out.println("Nawiązałem połączenie z: " + dbName);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean createTables() {
        String createCars = "CREATE TABLE IF NOT EXISTS cars (carID INTEGER PRIMARY KEY, brand STRING, plate_nr STRING type UNIQUE)";
        String createCarDrivers = "CREATE TABLE IF NOT EXISTS drivers (driverID INTEGER PRIMARY KEY, name STRING, surname STRING, pesel STRING type UNIQUE)";
        String createHashMap = "CREATE TABLE IF NOT EXISTS car_driver (recordID INTEGER PRIMARY KEY, carID INTEGER, driverID INTEGER)";
        try {
            statement.execute(createCars);
            System.out.println("Utworzyłem tabelę cars");
            statement.execute(createCarDrivers);
            System.out.println("Utworzyłem tabelę drivers");
            statement.execute(createHashMap);
            System.out.println("Utworzyłem tabelę car_driver");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Nie moge utworzyć tabeli");
            return false;
        }

    }

    public boolean addToCar( String brand, String plate ) {
        try {
            preparedStatement = connection.prepareStatement("insert into cars values (NULL,?,?);");
            preparedStatement.setString(1, brand);
            preparedStatement.setString(2, plate);
            if (preparedStatement.execute()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean addToDriver( String name, String surname, String pesel ) {
        try {
            preparedStatement = connection.prepareStatement("insert into drivers values (NULL,?,?,?);");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, pesel);
            if (preparedStatement.execute()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


    public Set getDriversFromDB() {
        Set<CarDriver> drivers = new HashSet<>();
        String getFromDrivers = "SELECT driver_ID, name, surname, pesel FROM drivers";
        CarDriver carDriver;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(getFromDrivers);
            while (resultSet.next()) {
                int id = resultSet.getInt("driver_ID");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String pesel = resultSet.getString("pesel");
                carDriver = new CarDriver(name, surname, pesel);
                carDriver.setId(id);
                drivers.add(carDriver);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return drivers;
    }

    public Set getCarsFromDB() {
        Set<Car> cars = new HashSet<>();
        String getFromDrivers = "SELECT brand, plate_nr FROM cars";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(getFromDrivers);

            while (resultSet.next()) {
                String brand = resultSet.getString("brand");
                String plate_nr = resultSet.getString("plate_nr");

                cars.add(new Car(brand, plate_nr));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cars;
    }
}
