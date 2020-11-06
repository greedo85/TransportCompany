import java.sql.*;

public class JDBC {

    private static final String url = "jdbc:sqlite:C:\\KursJava\\TransportCompany\\";
    Connection connection;
    Statement status;
    PreparedStatement preparedStatement;
    DatabaseMetaData databaseMetaData;
    ResultSet resultSet;

    public void createDataBase( String dbName ) {
        try {
                connection = DriverManager.getConnection(url + dbName);
            if(connection!=null) {
                databaseMetaData = connection.getMetaData();
                System.out.println("Nazwa sterownika bazy danych to: " + databaseMetaData.getDriverName());
                System.out.println("Baza została utworzona: " + dbName);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
