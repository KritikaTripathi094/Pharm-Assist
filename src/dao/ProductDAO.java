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
    
    // Existing method to get all products
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        
        try {
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
    
    // Existing method to get products by category
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

    // New method to add a product to the database
    public boolean addProduct(Product product) {
        String query = "INSERT INTO products (name, price, category, image, description, stock) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = new mysqlconnection().openConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Set the parameters for the PreparedStatement
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setString(3, product.getCategory());
            stmt.setString(4, product.getImage());
            stmt.setString(5, product.getDescription());
            stmt.setInt(6, product.getStock());

            int rowsAffected = stmt.executeUpdate();

            // Return true if at least one row was inserted, otherwise false
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // If an error occurred, return false
        }
    }
    
    public boolean deleteProductById(int id) {
    String query = "DELETE FROM products WHERE id = ?";

    try (Connection conn = new mysqlconnection().openConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setInt(1, id);
        return stmt.executeUpdate() > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    
    public boolean updateProduct(Product product) {

    String sql = "UPDATE products SET name=?, price=?, category=?, image=? WHERE id=?";

    try (Connection conn = new mysqlconnection().openConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, product.getName());
        ps.setDouble(2, product.getPrice());
        ps.setString(3, product.getCategory());
        ps.setString(4, product.getImage());
        ps.setInt(5, product.getId());

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

}
