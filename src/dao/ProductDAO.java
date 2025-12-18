/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import Model.Product;
import Database.mysqlconnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rojal
 */
public class ProductDAO {
        public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        
        try {
            // Use your mysqlconnection class
            mysqlconnection db = new mysqlconnection();
            Connection conn = db.openConnection();
            
            if (conn != null) {
                String query = "SELECT * FROM products";
                ResultSet rs = db.runQuery(conn, query);
                
                while (rs != null && rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getDouble("price"));
                    product.setImage(rs.getString("image"));
                    products.add(product);
                }
                
                System.out.println("Loaded " + products.size() + " products from database");
                db.closeConnection(conn);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        return products;
    }
    
}
