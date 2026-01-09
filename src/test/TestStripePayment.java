/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import Controller.PaymentController;

public class TestStripePayment {
    public static void main(String[] args) {
        System.out.println("=== Testing Stripe v31.1.0 ===");
        System.out.println("Make sure you've added stripe-java-31.1.0.jar and gson-2.10.1.jar to your project!\n");
        
        // Test 1: Connection test
      System.out.println("1. Testing connection to Stripe...");
      
        PaymentController pc = new PaymentController();
        pc.testConnection();
        
        // Test 2: Payment test
        System.out.println("\n2. Testing actual payment...");
        boolean success = pc.processPayment(30.0); // Rs 50
        
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
