/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Model.Productdetails;
import database.mysqlconnection;
import java.sql.*;

public class Description {

    public Productdetails getProductById(int productId) {

        Productdetails product = null;

        try {
            mysqlconnection db = new mysqlconnection();
            Connection conn = db.openConnection();

            String sql = "SELECT * FROM products WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, productId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
    product = new Productdetails();
    product.setId(rs.getInt("id"));
    product.setName(rs.getString("name"));
    product.setPrice(rs.getDouble("price"));
    product.setDescription(rs.getString("description"));
     product.setImage(rs.getString("image"));
}

            db.closeConnection(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }
}

