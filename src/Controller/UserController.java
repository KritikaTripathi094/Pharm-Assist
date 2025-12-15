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
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        return dao.register(user);
    }

    public boolean login(String username, String password) {
        return dao.login(username, password);
    }
}
    
    

