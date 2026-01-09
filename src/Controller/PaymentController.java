/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package Controller;

import com.stripe.Stripe;
import com.stripe.model.Charge;
import dao.PaymentDAO;
import Model.Payment;
import view.PaymentMethodPanel;
import javax.swing.JOptionPane;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.util.HashMap;
import java.util.Map;

public class PaymentController {
    private static final String SECRET_KEY = "sk_test_51SiG1VGkGPlqOyRCSWwSWo04T9dslFY3iBcI5mqkxnixrwcuIICJdHw4X5Bd6kri94IzQYkjIiPirTCLR7MuiDNK00jIwsbaHX";
    private final PaymentDAO paymentDAO;
    
    public PaymentController() {
        Stripe.apiKey = SECRET_KEY;
        paymentDAO = new PaymentDAO();
    }
    
    // Existing method - keep as is
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
    
    // NEW METHOD 1: Handle Stripe selection in PaymentMethodPanel
    public void handleStripeSelection(PaymentMethodPanel.PaymentSelectionListener listener) {
        JOptionPane.showMessageDialog(null, "Stripe payment selected!");
        
        if (listener != null) {
            listener.stripeSelected();
        }
    }
    
    // NEW METHOD 2: Handle COD selection in PaymentMethodPanel
    public void handleCodSelection(PaymentMethodPanel.PaymentSelectionListener listener) {
        JOptionPane.showMessageDialog(null, "Cash on Delivery selected!");
        
        if (listener != null) {
            listener.codSelected();
        }
    }
    
    // NEW METHOD 3: Handle complete payment process (for StripePaymentPanel)
    public void processStripePayment(JPanel parentPanel, JButton payButton, double totalAmount) {
        try {
            // Show loading message
            payButton.setEnabled(false);
            payButton.setText("Processing...");
            
            // Process payment
            boolean success = processPayment(totalAmount);
            
            if (success) {
                JOptionPane.showMessageDialog(null, 
                    "✅ Payment Successful!\nYour order has been confirmed.",
                    "Success", 
                    JOptionPane.INFORMATION_MESSAGE);
                
                // Go back to home
                if (parentPanel != null) {
                    CardLayout cl = (CardLayout) parentPanel.getLayout();
                    cl.show(parentPanel, "categories");
                }
                
            } else {
                JOptionPane.showMessageDialog(null,
                    "❌ Payment failed. Please try again.",
                    "Payment Failed",
                    JOptionPane.ERROR_MESSAGE);
                resetPayButton(payButton);
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                "Error: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            resetPayButton(payButton);
        }
    }
    
    // Helper method to reset button
    private void resetPayButton(JButton payButton) {
        if (payButton != null) {
            payButton.setEnabled(true);
            payButton.setText("[ Pay Now ]");
        }
    }

    public void testConnection() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}