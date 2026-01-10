/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/**
 *
 * @author This PC
 */
public class mysqlconnection {
    private String url = "jdbc:mysql://localhost:3306/pharm_assist?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true"; // Replace with your database URL
    private String username = "root"; // Replace with your database username
    private String password = "samyat2006"; // Replace with your database password

    private Connection connection;

    // Method to open the database connection
    public Connection openConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                // Load the MySQL JDBC driver (optional in modern versions of JDBC)
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // Establish the connection
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Method to execute a query
    public ResultSet runQuery(Connection conn, String query) {
        ResultSet rs = null;
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // Method to close the database connection
    public void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    boolean testConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
