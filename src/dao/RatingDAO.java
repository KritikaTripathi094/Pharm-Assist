/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import database.DBConnections;

/**
 *
 * @author This PC
 */
public class RatingDAO {
    
    public static boolean saveRating(int rating) {
        String sql = "INSERT INTO user_ratings (rating) VALUES (?)";

        try (Connection conn = DBConnections.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, rating);
            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
