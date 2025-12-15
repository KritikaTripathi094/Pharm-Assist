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

/**
 *
 * @author This PC
 */
public class UserDAO {
    
    DBConnection db = new DBConnection();

    // REGISTER
    public boolean register(User user) {
        try {
            Connection con = db.openConnection();

            String sql = "INSERT INTO users(username,email,password) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            int result = ps.executeUpdate();
            db.closeConnection(con);

            return result > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // LOGIN
    public boolean login(String username, String password) {
        try {
            Connection con = db.openConnection();

            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            boolean found = rs.next();

            db.closeConnection(con);
            return found;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}