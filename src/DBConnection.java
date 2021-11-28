import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    String url = "jdbc:mysql://localhost:3306/mysql";
    String user = "root";
    String password = "DBA123";

    private static DBConnection connectionFactory = null;

    public Connection getConnection() throws SQLException {
        Connection connection;
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public static DBConnection getDBConnection() {
        if (connectionFactory == null) {
            connectionFactory = new DBConnection();
        }
        return connectionFactory;
    }
}