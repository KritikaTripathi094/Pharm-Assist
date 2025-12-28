package Model;

public class User {
    private int id; 
    private String email;
    private String password;
    private String username;
    private String role;
    private String address;   
    private String phoneNumber;

    public User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // ADD GETTER AND SETTER FOR ID
    public int getId() { 
        return id; 
    }
    
    public void setId(int id) { 
        this.id = id; 
    }

    public String getUsername() { 
        return username; 
    }

    public void setUsername(String username) { 
        this.username = username; 
    }

    public String getEmail() { 
        return email; 
    }

    public void setEmail(String email) { 
        this.email = email; 
    }

    public String getPassword() { 
        return password; 
    }

    public void setPassword(String password) { 
        this.password = password; 
    }

    public String getRole() { 
        return role; 
    }

    public void setRole(String role) { 
        this.role = role; 
    }

    public String getAddress() { 
        return address; 
    }

    public void setAddress(String address) { 
        this.address = address; 
    }

    public String getPhoneNumber() { 
        return phoneNumber; 
    }

    public void setPhoneNumber(String phoneNumber) { 
        this.phoneNumber = phoneNumber; 
    }
}