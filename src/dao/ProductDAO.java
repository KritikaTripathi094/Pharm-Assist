package dao;

import Model.Product;
import database.mysqlconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT id, name, price, image, category, description, stock FROM products";

        try (Connection conn = new mysqlconnection().openConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(map(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> getProductsByCategory(String category) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT id, name, price, image, category, description, stock FROM products WHERE category=?";

        try (Connection conn = new mysqlconnection().openConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, category);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(map(rs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // ✅ This is the method your SearchController is calling
    public List<Product> searchProducts(String keyword, String categoryFilter) {
        List<Product> list = new ArrayList<>();

        boolean useCategory = categoryFilter != null
                && !categoryFilter.trim().isEmpty()
                && !categoryFilter.equalsIgnoreCase("All");

        String sql =
                "SELECT id, name, price, image, category, description, stock " +
                "FROM products " +
                "WHERE (name LIKE ? OR category LIKE ? OR description LIKE ?) " +
                (useCategory ? "AND category=? " : "") +
                "ORDER BY id DESC";

        try (Connection conn = new mysqlconnection().openConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            String like = "%" + (keyword == null ? "" : keyword.trim()) + "%";
            ps.setString(1, like);
            ps.setString(2, like);
            ps.setString(3, like);

            if (useCategory) {
                ps.setString(4, categoryFilter);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(map(rs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    private Product map(ResultSet rs) throws Exception {
        Product p = new Product();
        p.setId(rs.getInt("id"));
        p.setName(rs.getString("name"));
        p.setPrice(rs.getDouble("price"));
        p.setImage(rs.getString("image"));
        p.setCategory(rs.getString("category"));
        p.setDescription(rs.getString("description"));
        p.setStock(rs.getInt("stock"));
        return p;
    }

    public boolean updateProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean addProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   public List<Product> searchProducts(String keyword) {
    List<Product> list = new ArrayList<>();

    String sql =
        "SELECT id, name, price, image, category, description, stock " +
        "FROM products " +
        "WHERE name LIKE ? OR category LIKE ? OR description LIKE ?";

    try (Connection con = new mysqlconnection().openConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        String k = "%" + keyword + "%";
        ps.setString(1, k);
        ps.setString(2, k);
        ps.setString(3, k);

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getBigDecimal("price").doubleValue()); // or setPrice(BigDecimal) if you have
                p.setImage(rs.getString("image"));
                p.setCategory(rs.getString("category"));
                p.setDescription(rs.getString("description"));
                p.setStock(rs.getInt("stock"));
                list.add(p);
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}

}
