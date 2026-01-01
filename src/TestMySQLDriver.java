/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rojal
 */
public class TestMySQLDriver {
        public static void main(String[] args) {
        System.out.println("Testing MySQL Driver...");
        
        try {
            // Just try to find the class
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("SUCCESS! Found class: " + c.getName());
            
            // Now try to create an instance
            Object driver = c.getDeclaredConstructor().newInstance();
            System.out.println("Created driver instance: " + driver);
            
        } catch (ClassNotFoundException e) {
            System.out.println("FAILED: Cannot find MySQL driver class!");
            System.out.println("The JAR file is NOT in your classpath.");
            System.out.println("Go to: Project → Properties → Libraries");
            System.out.println("Add: mysql-connector-j-9.5.0");
        } catch (Exception e) {
            System.out.println("Other error: " + e.getMessage());
        }
    }
    
    
}
