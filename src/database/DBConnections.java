/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author This PC
 */
public class DBConnections {

    private static final String URL =
        "jdbc:mysql://localhost:3306/pharm_assist?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "sagar";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connected to pharm_assist database");
            return conn;
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            System.out.println(e.getMessage());
            return null;
        }
    }
}