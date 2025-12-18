/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;



public class User {
    private String email;
    private String password;
    private String username;
    private String role;

    public User() {}

    public User(String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
   
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    
}
