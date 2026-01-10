package dao;

import Model.CartItem;
import database.mysqlconnection;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDAO {

    // =================== ACTIVE ORDER ===================
    public int getOrCreateActiveOrderId() {
        try (Connection con = new mysqlconnection().openConnection()) {

            PreparedStatement ps = con.prepareStatement(
                "SELECT order_id FROM orders WHERE status='ACTIVE' LIMIT 1");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) return rs.getInt("order_id");

            PreparedStatement ins = con.prepareStatement(
                "INSERT INTO orders(total_amount,status) VALUES(0,'ACTIVE')",
                Statement.RETURN_GENERATED_KEYS);
            ins.executeUpdate();
            ResultSet keys = ins.getGeneratedKeys();
            keys.next();
            return keys.getInt(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    // =================== ADD TO CART ===================
    public void addToCart(int orderId, int productId, int qty) {
        try (Connection con = new mysqlconnection().openConnection()) {

            PreparedStatement p1 = con.prepareStatement(
                "SELECT price,image,name FROM products WHERE id=?");
            p1.setInt(1, productId);
            ResultSet rs = p1.executeQuery();
            if (!rs.next()) return;

            BigDecimal price = rs.getBigDecimal("price");

            PreparedStatement p2 = con.prepareStatement(
                "SELECT quantity FROM order_items WHERE order_id=? AND product_id=?");
            p2.setInt(1, orderId);
            p2.setInt(2, productId);
            ResultSet rs2 = p2.executeQuery();

            if (rs2.next()) {
                int newQty = Math.min(7, rs2.getInt("quantity") + qty);
                PreparedStatement up = con.prepareStatement(
                    "UPDATE order_items SET quantity=?, line_total=? WHERE order_id=? AND product_id=?");
                up.setInt(1, newQty);
                up.setBigDecimal(2, price.multiply(new BigDecimal(newQty)));
                up.setInt(3, orderId);
                up.setInt(4, productId);
                up.executeUpdate();
            } else {
                PreparedStatement ins = con.prepareStatement(
                    "INSERT INTO order_items(order_id,product_id,quantity,unit_price,line_total) VALUES(?,?,?,?,?)");
                ins.setInt(1, orderId);
                ins.setInt(2, productId);
                ins.setInt(3, qty);
                ins.setBigDecimal(4, price);
                ins.setBigDecimal(5, price.multiply(new BigDecimal(qty)));
                ins.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =================== GET CART ===================
    public List<CartItem> getCartItems(int orderId) {
        List<CartItem> list = new ArrayList<>();
        try (Connection con = new mysqlconnection().openConnection()) {

            PreparedStatement ps = con.prepareStatement(
                "SELECT p.id,p.name,p.image,oi.quantity,oi.line_total,oi.selected " +
                "FROM order_items oi JOIN products p ON oi.product_id=p.id WHERE oi.order_id=?");
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CartItem c = new CartItem();
                c.setProductId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setImage(rs.getString("image"));
                c.setQuantity(rs.getInt("quantity"));
                c.setLineTotal(rs.getBigDecimal("line_total"));
                c.setSelected(rs.getBoolean("selected"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // =================== UPDATE QTY ===================
    public void updateQuantity(int orderId, int productId, int qty) {
        try (Connection con = new mysqlconnection().openConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE order_items SET quantity=?, line_total=unit_price*? WHERE order_id=? AND product_id=?");
            ps.setInt(1, qty);
            ps.setInt(2, qty);
            ps.setInt(3, orderId);
            ps.setInt(4, productId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setSelected(int orderId, int productId, boolean sel) {
        try (Connection con = new mysqlconnection().openConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE order_items SET selected=? WHERE order_id=? AND product_id=?");
            ps.setBoolean(1, sel);
            ps.setInt(2, orderId);
            ps.setInt(3, productId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int deleteSelected(int orderId) {
        try (Connection con = new mysqlconnection().openConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM order_items WHERE order_id=? AND selected=1");
            ps.setInt(1, orderId);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // =================== CONFIRM ===================
   public void confirmOrder(int orderId) {
    String sql1 = "UPDATE orders SET status='CONFIRMED' WHERE order_id=?";
    String sql2 = "UPDATE orders SET total_amount = " +
                  "(SELECT IFNULL(SUM(line_total),0) FROM order_items WHERE order_id=? AND selected=1) " +
                  "WHERE order_id=?";

    try (Connection con = new mysqlconnection().openConnection();
         PreparedStatement p1 = con.prepareStatement(sql1);
         PreparedStatement p2 = con.prepareStatement(sql2)) {

        p2.setInt(1, orderId);
        p2.setInt(2, orderId);
        p2.executeUpdate();

        p1.setInt(1, orderId);
        p1.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    }

