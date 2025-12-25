/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Product;
import database.DBConnection;
import database.mysqlconnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductController {

    private final DBConnection db = new mysqlconnection();

    // Get product by ID
    public Product getProductById(int productId) {

        Product product = null;
        Connection conn = null;

        try {
            conn = db.openConnection();

            String query = "SELECT * FROM products WHERE id = " + productId;
            ResultSet rs = db.runQuery(conn, query);

            if (rs != null && rs.next()) {
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setImage(rs.getString("image"));
                product.setCategory(rs.getString("category"));
                product.setDescription(rs.getString("description"));
                product.setStock(rs.getInt("stock"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection(conn);
        }

        return product;
    }
}
