/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package Controller;


import com.stripe.Stripe;
import com.stripe.model.Charge;
import dao.PaymentDAO;
import Model.Payment;
import java.util.HashMap;
import java.util.Map;

public class PaymentController {
    private static final String SECRET_KEY = "sk_test_51SiG1VGkGPlqOyRCSWwSWo04T9dslFY3iBcI5mqkxnixrwcuIICJdHw4X5Bd6kri94IzQYkjIiPirTCLR7MuiDNK00jIwsbaHX";

    public static void testConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private final PaymentDAO paymentDAO;
    
    public PaymentController() {
        Stripe.apiKey = SECRET_KEY;
        paymentDAO = new PaymentDAO();
    }
    
    public boolean processPayment(double totalAmount) {
        try {
            // 1. Process with Stripe
            long amountInPaisa = (long)(totalAmount * 100);
            
            Map<String, Object> params = new HashMap<>();
            params.put("amount", amountInPaisa);
            params.put("currency", "inr");
            params.put("source", "tok_visa");
            params.put("description", "Pharmacy Order");
            
            Charge charge = Charge.create(params);
            
            // 2. Save to database
            Payment payment = new Payment(0, totalAmount, "success", charge.getId());
            boolean saved = paymentDAO.savePayment(payment);
            
            System.out.println(saved ? "✅ Saved to DB" : "❌ DB save failed");
            return true;
            
        } catch (Exception e) {
            System.err.println("Payment error: " + e.getMessage());
            return false;
        }
    }
}