/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.*;

public class mysqlconnector implements database {


    @Override
    public Connection openConnection() {
        try {
            String username = "root";
            String password = "kritika123";
            String database = "hello";

            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/" + database,
                username,
                password
            );

            System.out.println("Connected Successfully!");
            return connection;

        } catch (SQLException e) {
            System.out.println("Connection Error: " + e.getMessage());
            return null;
        }
    }
    @Override
    public ResultSet runQuery(Connection conn, String query) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Query Error: " + e.getMessage());
            return null;
        }
    }

    @Override
    public int executeUpdate(Connection conn, String query) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Update Error: " + e.getMessage());
            return -1;
        }
    }

    @Override
    public void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Connection Closed");
            }
        } catch (SQLException e) {
            System.out.println("Close Error: " + e.getMessage());
        }
    }
}


