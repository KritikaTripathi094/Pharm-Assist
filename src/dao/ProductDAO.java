package dao;

import Model.Product;
import database.mysqlconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private final mysqlconnection db = new mysqlconnection();

    // ✅ GET ALL PRODUCTS
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        Connection conn = null;

        try {
            conn = db.openConnection();
            if (conn == null) return products;

            String sql = "SELECT id, name, price, image, category, description, stock FROM products";
            try (PreparedStatement ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Product p = new Product();
                    p.setId(rs.getInt("id"));
                    p.setName(rs.getString("name"));
                    p.setPrice(rs.getDouble("price"));
                    p.setImage(rs.getString("image"));
                    p.setCategory(rs.getString("category"));
                    p.setDescription(rs.getString("description"));
                    p.setStock(rs.getInt("stock"));
                    products.add(p);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection(conn);
        }

        return products;
    }

    // ✅ GET PRODUCTS BY CATEGORY
    public List<Product> getProductsByCategory(String category) {
        List<Product> products = new ArrayList<>();
        Connection conn = null;

        try {
            conn = db.openConnection();
            if (conn == null) return products;

            String sql = "SELECT id, name, price, image, category, description, stock FROM products WHERE category = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, category);

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Product p = new Product();
                        p.setId(rs.getInt("id"));
                        p.setName(rs.getString("name"));
                        p.setPrice(rs.getDouble("price"));
                        p.setImage(rs.getString("image"));
                        p.setCategory(rs.getString("category"));
                        p.setDescription(rs.getString("description"));
                        p.setStock(rs.getInt("stock"));
                        products.add(p);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection(conn);
        }

        return products;
    }

    // ✅ SEARCH PRODUCTS (keyword + optional category)
    public List<Product> searchProducts(String keyword, String categoryFilter) {
        List<Product> products = new ArrayList<>();
        Connection conn = null;

        String sql =
                "SELECT id, name, price, image, category, description, stock " +
                "FROM products " +
                "WHERE (name LIKE ? OR category LIKE ? OR description LIKE ?)";

        boolean useCategory = categoryFilter != null
                && !categoryFilter.trim().isEmpty()
                && !categoryFilter.equalsIgnoreCase("All");

        if (useCategory) {
            sql += " AND category = ?";
        }

        try {
            conn = db.openConnection();
            if (conn == null) return products;

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                String key = "%" + keyword + "%";
                ps.setString(1, key);
                ps.setString(2, key);
                ps.setString(3, key);

                if (useCategory) {
                    ps.setString(4, categoryFilter);
                }

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Product p = new Product();
                        p.setId(rs.getInt("id"));
                        p.setName(rs.getString("name"));
                        p.setPrice(rs.getDouble("price"));
                        p.setImage(rs.getString("image"));
                        p.setCategory(rs.getString("category"));
                        p.setDescription(rs.getString("description"));
                        p.setStock(rs.getInt("stock"));
                        products.add(p);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection(conn);
        }

        return products;
    }
}
