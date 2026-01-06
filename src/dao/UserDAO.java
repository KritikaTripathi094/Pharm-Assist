/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Model.User;
import database.DBConnections;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnections;
import database.mysqlconnection;
import java.sql.*;

public class UserDAO {

    // ===== REGISTER USER =====
    public boolean register(User user) {
        String sql = "INSERT INTO users(username, email, password) VALUES(?, ?, ?)";

        try (Connection con = DBConnections.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

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
                user.setId(rs.getInt("id"));  // ADD THIS LINE
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setAddress(rs.getString("address"));      
                user.setPhoneNumber(rs.getString("phone_number"));
                return user; // login successful
            } else {
                return null; // login failed
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    // ===== CHECK IF EMAIL EXISTS =====
    public boolean emailExists(String email) {
        String sql = "SELECT * FROM users WHERE email=?";

        try (Connection con = DBConnections.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
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
