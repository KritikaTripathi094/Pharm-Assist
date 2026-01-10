/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Model.User;
import database.DBConnections;
import database.mysqlconnection; // Changed from 'mysqlconnection' to 'MysqlConnection'
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    // ===== REGISTER USER =====
    public boolean register(User user) {
        String sql = "INSERT INTO users (username, email, password, phone_number, address, role) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnections.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            // Set values for each parameter in the prepared statement
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPhoneNumber());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getRole());

            // Execute the query and check if insertion was successful
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }  // Fixed: Removed extra closing brace

    // ===== LOGIN =====
    public User login(String usernameOrEmail, String password) {
        String sql = "SELECT * FROM users WHERE (username=? OR email=?) AND password=?";

        try (Connection con = DBConnections.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usernameOrEmail);
            ps.setString(2, usernameOrEmail);
            ps.setString(3, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                // Create User object and set details including role
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setAddress(rs.getString("address"));      
                user.setPhoneNumber(rs.getString("phone_number"));
                return user;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // ===== CHECK IF EMAIL EXISTS =====
  public boolean emailExists(String email) {
    String sql = "SELECT 1 FROM users WHERE email = ? LIMIT 1";

    Connection con = new mysqlconnection().openConnection();

    if (con == null) {
        System.out.println("❌ Connection is null (DB not connected). Check URL/user/pass.");
        return false;
    }

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, email);

        try (ResultSet rs = ps.executeQuery()) {
            return rs.next();
        }

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    } finally {
        try { con.close(); } catch (Exception ignored) {}
    }
}


    // ===== UPDATE PASSWORD =====
    public boolean updatePassword(String email, String newPassword) {
        String sql = "UPDATE users SET password=? WHERE email=?";

        try (Connection con = DBConnections.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, newPassword);
            ps.setString(2, email);

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
        
        public boolean updateShippingDetails(int userId, String username, String phoneNumber, String address) {
        String sql = "UPDATE users SET username = ?, phone_number = ?, address = ? WHERE id = ?";
        
        try (Connection con = DBConnections.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, username);
            ps.setString(2, phoneNumber);
            ps.setString(3, address);
            ps.setInt(4, userId);
            
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}