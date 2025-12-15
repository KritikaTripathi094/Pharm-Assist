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

    DBConnection db = new DBConnection();

    // ===== REGISTER USER =====
    public boolean register(User user) {
        String sql = "INSERT INTO users(username, email, password) VALUES(?, ?, ?)";

        try (Connection con = db.openConnection();
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
    public boolean login(String username, String password) {
        String sql = "SELECT * FROM users WHERE username=? AND password=?";

        try (Connection con = db.openConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ===== CHECK IF EMAIL EXISTS =====
    public boolean emailExists(String email) {
        String sql = "SELECT * FROM users WHERE email=?";

        try (Connection con = db.openConnection();
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

        try (Connection con = db.openConnection();
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