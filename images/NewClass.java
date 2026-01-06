/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package images;

import view.ForgotPassword;

public class NewClass {

    private final ForgotPassword ui;   // UI reference

    public NewClass(ForgotPassword ui) {  //
        this.ui = ui;
    }

    // your existing methods
    public void sendOtp(String email) { /* ... */ }
    public boolean verifyOtp(String email, String otp) { 
        return false;
    }
    public void resetPassword(String email, String newPassword) {}

    // Optional: open UI
    public void open() {
        ui.setVisible(true);
    }
}
