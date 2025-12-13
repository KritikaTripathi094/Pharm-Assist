/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import dao.UserDAO;
import javax.swing.JOptionPane;
import java.util.Random;

public class ForgotPasswordController {

    // Use consistent variable name
    private final UserDAO userDao = new UserDAO();

    // 1. Generate 6-digit OTP
    private String generateOtp() {
        Random rand = new Random();
        int otp = rand.nextInt(900000) + 100000; // ensures 6-digit
        return String.valueOf(otp);
    }

    // 2. SEND OTP
    public void sendOtp(String email) {
        try {
            if (userDao.isEmailExist(email)) {   // lowercase d
                String otp = generateOtp();
                userDao.saveOtp(email, otp);     // save OTP to database

                // Send OTP via email
                String subject = "Your OTP for Pharm-Assist";
                String message = "Your OTP to reset your password is: " + otp;
                EmailService.sendEmail(email, subject, message);

                JOptionPane.showMessageDialog(null, "OTP sent to your email!");
            } else {
                JOptionPane.showMessageDialog(null, "Email not found!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while sending OTP!");
        }
    }

    // 3. VERIFY OTP
    public boolean verifyOtp(String email, String enteredOtp) {
        try {
            return userDao.verifyOtp(email, enteredOtp);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error verifying OTP: " + e.getMessage());
            return false;
        }
    }

    // 4. RESET PASSWORD
    public void resetPassword(String email, String newPassword) {
        try {
            userDao.updatePassword(email, newPassword);
            JOptionPane.showMessageDialog(null, "Password reset successful!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error resetting password: " + e.getMessage());
        }
    }
}
