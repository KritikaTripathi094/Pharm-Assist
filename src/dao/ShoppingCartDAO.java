package dao;

import Model.CartItem;
import database.mysqlconnection;

import java.sql.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDAO {

    private final mysqlconnection db = new mysqlconnection();

    private int getOrCreateActiveCartId(Connection conn) throws SQLException {
        String findSql = "SELECT order_id FROM orders WHERE status='ACTIVE' ORDER BY order_id DESC LIMIT 1";
        try (PreparedStatement ps = conn.prepareStatement(findSql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) return rs.getInt("order_id");
        }

        String insertSql = "INSERT INTO orders(total_amount, status) VALUES(0.00, 'ACTIVE')";
        try (PreparedStatement ps = conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) return keys.getInt(1);
            }
        }
        throw new SQLException("Failed to create active cart");
    }

    public void addToCart(int productId) throws Exception {
        Connection conn = db.openConnection();
        try {
            int orderId = getOrCreateActiveCartId(conn);
            BigDecimal unitPrice = getProductPrice(conn, productId);

            String checkSql = "SELECT quantity FROM order_items WHERE order_id=? AND product_id=?";
            try (PreparedStatement ps = conn.prepareStatement(checkSql)) {
                ps.setInt(1, orderId);
                ps.setInt(2, productId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        int qty = rs.getInt("quantity");
                        if (qty >= 7) throw new Exception("LIMIT_EXCEEDED");
                        int newQty = qty + 1;
                        updateQuantityInternal(conn, orderId, productId, newQty, unitPrice);
                        updateOrderTotal(conn, orderId);
                        return;
                    }
                }
            }

            String insertSql =
                    "INSERT INTO order_items(order_id, product_id, quantity, unit_price, line_total, selected) " +
                    "VALUES(?,?,?,?,?,1)";
            try (PreparedStatement ps = conn.prepareStatement(insertSql)) {
                ps.setInt(1, orderId);
                ps.setInt(2, productId);
                ps.setInt(3, 1);
                ps.setBigDecimal(4, unitPrice);
                ps.setBigDecimal(5, unitPrice);
                ps.executeUpdate();
            }

            updateOrderTotal(conn, orderId);
        } finally {
            db.closeConnection(conn);
        }
    }

    public void updateQuantity(int productId, int newQty) throws Exception {
        if (newQty < 1) newQty = 1;
        if (newQty > 7) throw new Exception("LIMIT_EXCEEDED");

        Connection conn = db.openConnection();
        try {
            int orderId = getOrCreateActiveCartId(conn);
            BigDecimal unitPrice = getProductPrice(conn, productId);

            updateQuantityInternal(conn, orderId, productId, newQty, unitPrice);
            updateOrderTotal(conn, orderId);
        } finally {
            db.closeConnection(conn);
        }
    }

    private void updateQuantityInternal(Connection conn, int orderId, int productId, int qty, BigDecimal unitPrice) throws SQLException {
        BigDecimal lineTotal = unitPrice.multiply(new BigDecimal(qty));

        String sql = "UPDATE order_items SET quantity=?, unit_price=?, line_total=? WHERE order_id=? AND product_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, qty);
            ps.setBigDecimal(2, unitPrice);
            ps.setBigDecimal(3, lineTotal);
            ps.setInt(4, orderId);
            ps.setInt(5, productId);
            ps.executeUpdate();
        }
    }

    public void setSelectAll(boolean select) throws Exception {
        Connection conn = db.openConnection();
        try {
            int orderId = getOrCreateActiveCartId(conn);
            String sql = "UPDATE order_items SET selected=? WHERE order_id=?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, select ? 1 : 0);
                ps.setInt(2, orderId);
                ps.executeUpdate();
            }
            updateOrderTotal(conn, orderId);
        } finally {
            db.closeConnection(conn);
        }
    }

    public void deleteSelected() throws Exception {
        Connection conn = db.openConnection();
        try {
            int orderId = getOrCreateActiveCartId(conn);
            String sql = "DELETE FROM order_items WHERE order_id=? AND selected=1";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, orderId);
                ps.executeUpdate();
            }
            updateOrderTotal(conn, orderId);
        } finally {
            db.closeConnection(conn);
        }
    }

    public void confirmCart() throws Exception {
        Connection conn = db.openConnection();
        try {
            int orderId = getOrCreateActiveCartId(conn);
            String sql = "UPDATE orders SET status='CONFIRMED' WHERE order_id=?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, orderId);
                ps.executeUpdate();
            }
        } finally {
            db.closeConnection(conn);
        }
    }

    public List<CartItem> getCartItems() throws Exception {
        List<CartItem> list = new ArrayList<>();
        Connection conn = db.openConnection();

        try {
            int orderId = getOrCreateActiveCartId(conn);

            String sql =
                "SELECT oi.product_id, p.name AS product_name, p.image, oi.quantity, oi.unit_price, oi.line_total, oi.selected " +
                "FROM order_items oi " +
                "JOIN products p ON p.id = oi.product_id " +
                "WHERE oi.order_id=? " +
                "ORDER BY oi.order_item_id DESC";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, orderId);

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        CartItem item = new CartItem();
                        item.setProductId(rs.getInt("product_id"));
                        item.setProductName(rs.getString("product_name"));
                        item.setImage(rs.getString("image"));
                        item.setQuantity(rs.getInt("quantity"));
                        item.setUnitPrice(rs.getBigDecimal("unit_price"));
                        item.setLineTotal(rs.getBigDecimal("line_total"));
                        item.setSelected(rs.getInt("selected") == 1);
                        list.add(item);
                    }
                }
            }
        } finally {
            db.closeConnection(conn);
        }
        return list;
    }

    private BigDecimal getProductPrice(Connection conn, int productId) throws SQLException {
        String sql = "SELECT price FROM products WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, productId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getBigDecimal("price");
            }
        }
        throw new SQLException("Product not found: " + productId);
    }

    private void updateOrderTotal(Connection conn, int orderId) throws SQLException {
        String sumSql = "SELECT COALESCE(SUM(line_total),0) AS total FROM order_items WHERE order_id=? AND selected=1";
        BigDecimal total = BigDecimal.ZERO;

        try (PreparedStatement ps = conn.prepareStatement(sumSql)) {
            ps.setInt(1, orderId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) total = rs.getBigDecimal("total");
            }
        }

        String upd = "UPDATE orders SET total_amount=? WHERE order_id=?";
        try (PreparedStatement ps = conn.prepareStatement(upd)) {
            ps.setBigDecimal(1, total);
            ps.setInt(2, orderId);
            ps.executeUpdate();
        }
    }
}
