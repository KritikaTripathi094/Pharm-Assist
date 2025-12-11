/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.*;

public interface database {
    Connection openConnection();
    ResultSet runQuery(Connection conn, String query);
    int executeUpdate(Connection conn, String query);
    void closeConnection(Connection conn);
}
