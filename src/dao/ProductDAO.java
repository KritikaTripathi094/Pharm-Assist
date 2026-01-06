/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import Model.Product;
import database.mysqlconnection;
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
    
           public List<Product> getProductsByCategory(String category) {
        List<Product> products = new ArrayList<>();

        try {
            mysqlconnection db = new mysqlconnection();
            Connection conn = db.openConnection();

            if (conn != null) {
                String query = "SELECT * FROM products WHERE category = ?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, category);
                ResultSet rs = ps.executeQuery();

                while (rs != null && rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getDouble("price"));
                    product.setImage(rs.getString("image"));
                    product.setCategory(rs.getString("category"));
                    products.add(product);
                }

                db.closeConnection(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
    
}
