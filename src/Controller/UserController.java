/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.User;
import dao.UserDAO;

/**
 *
 * @author This PC
 */
public class UserController {
     UserDAO dao = new UserDAO();

    public boolean register(String username, String email, String password) {
        if(username == null || username.isEmpty() ||
           email == null || email.isEmpty() ||
           password == null || password.isEmpty()) {
            return false;
        }
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        return dao.register(user);
    }

     // ===== LOGIN =====
    // Return the User object instead of boolean so we can check role
    public User login(String username, String password) {
        if(username == null || username.isEmpty() || password == null || password.isEmpty()) {
        return null;
    }
        return dao.login(username, password);
    }
}
    
    

