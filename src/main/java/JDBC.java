import java.sql.*;

public class JDBC {

    private static final String url = "jdbc:sqlite:C:\\KursJava\\TransportCompany\\";
    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;
    DatabaseMetaData databaseMetaData;
    ResultSet resultSet;

    public JDBC() {
        createDataBase("transporcompany.db");
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

    public boolean createCarsTable() {
        String createCars = "CREATE TABLE IF NOT EXISTS cars (carID INTEGER PRIMARY KEY, brand STRING, plate_nr STRING)";
        try {
            statement.execute(createCars);
            System.out.println("Utworzyłem tabelę cars");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Nie moge utworzyć tabeli");
            return false;
        }
    }
}
