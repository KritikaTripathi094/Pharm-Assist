/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import dao.UserDAO;
import view.ForgotPassword;

/**
 *
 * @author kritss
 */
public class Group5PharmAssist {
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {

        // OPTIONAL: DB test (you can remove later)
        UserDAO userDAO = new UserDAO();
        String testEmail = "kritikatripathi0094@gmail.com";

        if (userDAO.emailExists(testEmail)) {
            System.out.println("Email exists ✔");
        } else {
            System.out.println("Email not found ❌");
        }

        // ✅ OPEN FORGOT PASSWORD UI
        java.awt.EventQueue.invokeLater(() -> {
            new ForgotPassword().setVisible(true);
        });
    }
}
