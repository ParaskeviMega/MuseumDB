import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    //String driverClassName = "com.mysql.jdbc.Driver";
    String connectionUrl = "jdbc:mysql://localhost:3306/mysql";
    String dbUser = "root";
    String dbPwd = "DBA123";

    private static DBConnection connectionFactory = null;

    private DBConnection() {
        /*try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
    }

    public Connection getConnection() throws SQLException {
        Connection conn;
        conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
        return conn;
    }

    public static DBConnection getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new DBConnection();
        }
        return connectionFactory;
    }
}