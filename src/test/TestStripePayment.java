package test;

import Controller.PaymentController;

public class TestStripePayment {
    public static void main(String[] args) {
        System.out.println("=== Testing Stripe v31.1.0 ===");
        System.out.println("Note: Minimum amount is ₹41 (0.50 USD equivalent)\n");
        
        // Test 1: Connection test
        System.out.println("1. Testing connection to Stripe...");
        
        PaymentController pc = new PaymentController();
        pc.testConnection();
        
        // Test 2: Payment test - use at least ₹50
        System.out.println("\n2. Testing actual payment (₹100)...");
        boolean success = pc.processPayment(100.0); // ₹100
        
        if (success) {
            System.out.println("\n✅ ✅ ✅ ALL TESTS PASSED!");
            System.out.println("Your pharmacy app can now accept REAL payments via Stripe!");
            System.out.println("Check your Stripe Dashboard: https://dashboard.stripe.com/test/payments");
        } else {
            System.out.println("\n❌ Payment test failed - check errors above");
        }
        
        System.out.println("\n=== Test Complete ===");
    }
}