package controller;

import Model.User;
import dao.UserDAO;

public class SignupController {

    private UserDAO userDAO;

    public SignupController() {
        this.userDAO = new UserDAO();
    }

    // Method to register the user
    public String register(User user) {
        // Register the new user
        boolean registrationSuccess = userDAO.register(user);

        if (registrationSuccess) {
            return "Registration successful!";
        } else {
            return "Registration failed. Please try again.";
        }
    }
}
