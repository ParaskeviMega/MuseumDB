import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExhibitDAO {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    public ExhibitDAO() {}

    // id, title, artist, date, culture, description

    private Connection getConnection() throws SQLException {
        Connection connection;
        connection = DBConnection.getInstance().getConnection();
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

    public void insert(Exhibit object) {
        try {
            String sql = "INSERT INTO museum(id, title, artist, date, culture, description) VALUES(?,?,?,?,?,?)";
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, object.getId());
            statement.setString(2, object.getTitle());
            statement.setString(3, object.getArtist());
            statement.setInt(4, object.getDate());
            statement.setString(5, object.getCulture());
            statement.setString(6, object.getDescription());
            statement.executeUpdate();
            System.out.println("Data Added!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            finallyMethod();
        }
    }

    public void update(Exhibit object) {
        try {
            System.out.println(object.getId() + object.getArtist());
            String sql = "UPDATE museum SET artist=? WHERE id=?";
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, object.getArtist());
            statement.setInt(2, object.getId());
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
            while (resultSet.next()) {
                // id, title, artist, date, culture, description
                System.out.println("Id " + resultSet.getInt("id")
                        + ", Title " + resultSet.getString("title")
                        + ", Artist " + resultSet.getString("artist")
                        + ", Date " + resultSet.getInt("date")
                        + ", Culture " + resultSet.getString("culture")
                        + ", Description " + resultSet.getString("description"));
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