package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mysqlconnection {

    // Database connection parameters
    private static final String URL = "jdbc:mysql://localhost:3306/pharm_assist";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    // Method to establish and return a connection to the database
    public static Connection getConnection() throws SQLException {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Database connection error", e);
        }
    }
}
