/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author kritss
 */
public class DBConnection {
    public static void main(String[] args) {
        database db = new mysqlconnector();
        if(db.openConnection() != null) {
           
            System.out.println("Connection successful");
        
    } else {
    System.out.println("Not Successfull");
}
    
}
}
