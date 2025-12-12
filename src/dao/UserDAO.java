/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import database.DBConnection;

public class UserDAO {

    // Save OTP
    public static boolean saveOtp(String email, String otp) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE users SET otp=? WHERE email=?"
            );

            ps.setString(1, otp);
            ps.setString(2, email);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Verify OTP
    public static boolean verifyOtp(String email, String otp) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT otp FROM users WHERE email=?"
            );

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return otp.equals(rs.getString("otp"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Update password
    public static boolean updatePassword(String email, String newPass) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE users SET password=?, otp=NULL WHERE email=?"
            );

            ps.setString(1, newPass);
            ps.setString(2, email);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
