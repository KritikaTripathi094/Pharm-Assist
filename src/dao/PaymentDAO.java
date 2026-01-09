/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Model.Payment;
import database.mysqlconnection;
import java.sql.*;

public class PaymentDAO {
    private mysqlconnection db;
    
    public PaymentDAO() {
        db = new mysqlconnection();
    }
    
    // SIMPLE: Save payment to database
    public boolean savePayment(Payment payment) {
        try (Connection conn = db.openConnection()) {
            String sql = "INSERT INTO payments (order_id, amount, status, transaction_id) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, payment.getOrderId());
            stmt.setDouble(2, payment.getAmount());
            stmt.setString(3, payment.getStatus());
            stmt.setString(4, payment.getTransactionId());
            
            int result = stmt.executeUpdate();
            System.out.println("✅ Payment saved to DB: " + payment.getTransactionId());
            return result > 0;
            
        } catch (Exception e) {
            System.err.println("❌ Error saving payment: " + e.getMessage());
            return false;
        }
    }
}