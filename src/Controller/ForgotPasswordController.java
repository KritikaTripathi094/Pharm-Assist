package Controller;

import dao.UserDAO;
import java.util.Random;
import javax.swing.JOptionPane;

public class ForgotPasswordController {

    private String generatedOtp;
    private boolean otpVerified = false;
    private String userEmail;
    private final UserDAO userDAO = new UserDAO();

    
    public void handleSendOtp(String email) {
        this.userEmail = email;
        
        if (!userDAO.emailExists(email)) {
            JOptionPane.showMessageDialog(null, "Email not found");
            return;
        }

        generatedOtp = String.valueOf(new Random().nextInt(900000) + 100000);
        otpVerified = false;

        EmailService.sendEmail(
            email,
            "Password Reset OTP",
            "Your OTP is: " + generatedOtp
        );
        
        JOptionPane.showMessageDialog(null, "OTP sent to email");
    }

    public void handleVerifyOtp(String enteredOtp) {
        if (generatedOtp != null && generatedOtp.equals(enteredOtp)) {
            otpVerified = true;
            JOptionPane.showMessageDialog(null, "OTP Verified");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid OTP");
        }
    }

   
    public void handleResetPassword(String newPassword) {
        if (!otpVerified) {
            JOptionPane.showMessageDialog(null, "Please verify OTP first!");
            return;
        }

        if (userDAO.updatePassword(userEmail, newPassword)) {
            JOptionPane.showMessageDialog(null, "Password reset successful!");
            
            
            otpVerified = false;
            generatedOtp = null;
            userEmail = null;
        } else {
            JOptionPane.showMessageDialog(null, "Password reset failed!");
        }
    }
}