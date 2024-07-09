import java.sql.*;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/bookkeeper";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection connection;

    public Database() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
