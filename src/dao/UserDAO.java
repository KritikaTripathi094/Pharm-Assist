package dao;

import Model.User;
import database.mysqlconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    // Register a new user
    public boolean register(User user) {
        String sql = "INSERT INTO users (username, email, password, phone_number, address, role) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = mysqlconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            // Set values for each parameter in the prepared statement
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());  // Plain password
            ps.setString(4, user.getPhoneNumber());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getRole());  // Default role is 'USER'

            // Execute the query and check if insertion was successful
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
