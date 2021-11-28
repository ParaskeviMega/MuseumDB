/* The data access object class where we can create a table to mysql database,
insert, update or delete an exhibit,
print the exhibits of the table and delete the table
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExhibitDAO {
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;

    public ExhibitDAO() {}

    private Connection getConnection() throws SQLException {
        Connection connection;
        connection = DBConnection.getDBConnection().getConnection();
        return connection;
    }

    public void createTable(){
        try {
            String sql = "CREATE TABLE museum " +
                    "(id INTEGER not NULL, " +
                    " title VARCHAR(30), " +
                    " artist VARCHAR(30), " +
                    " date INTEGER, " +
                    " culture VARCHAR(30), " +
                    " description VARCHAR(30), " +
                    " PRIMARY KEY ( id ))";
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("Table Created!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            finallyMethod();
        }
    }

    public void insert(Exhibit exhibit) {
        try {
            String sql = "INSERT INTO museum(id, title, artist, date, culture, description) " +
                    "VALUES(?,?,?,?,?,?)";
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, exhibit.getId());
            statement.setString(2, exhibit.getTitle());
            statement.setString(3, exhibit.getArtist());
            statement.setInt(4, exhibit.getDate());
            statement.setString(5, exhibit.getCulture());
            statement.setString(6, exhibit.getDescription());
            statement.executeUpdate();
            System.out.println("Data Added!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            finallyMethod();
        }
    }

    public void update(Exhibit exhibit) {
        try {
            String sql = "UPDATE museum SET artist=? WHERE id=?";
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, exhibit.getArtist());
            statement.setInt(2, exhibit.getId());
            statement.executeUpdate();
            System.out.println("Table Updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            finallyMethod();
        }
    }

    public void delete(int id) {
        try {
            String sql = "DELETE FROM museum WHERE id=?";
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Data deleted!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            finallyMethod();
        }
    }

    public void printAll() {
        try {
            String sql = "SELECT * FROM museum";
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            if (!resultSet.next()){
                System.out.println("The table is empty. \n");
            } else {
                do {
                    System.out.println("Id: " + resultSet.getInt("id")
                            + ", Title: " + resultSet.getString("title")
                            + ", Artist: " + resultSet.getString("artist")
                            + ", Date: " + resultSet.getInt("date")
                            + ", Culture: " + resultSet.getString("culture")
                            + ", Description: " + resultSet.getString("description")
                            + ". \n");
                } while (resultSet.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            finallyMethod();
        }
    }

    public void dropTable() {
        try {
            String sql = "DROP TABLE museum";
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("Table deleted!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            finallyMethod();
        }
    }

    public void finallyMethod(){
        try {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}