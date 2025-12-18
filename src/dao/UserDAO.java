/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Model.User;
import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author This PC
 */
public class UserDAO {

    // ===== REGISTER USER =====
    public boolean register(User user) {
        String sql = "INSERT INTO users(username, email, password) VALUES(?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
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

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, usernameOrEmail);
        ps.setString(2, usernameOrEmail);
        ps.setString(3, password);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            // Create User object and set details including role
            User user = new User();
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role")); // <-- get role from DB
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

        try (Connection con = DBConnection.getConnection();
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

        try (Connection con = DBConnection.getConnection();
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
}
