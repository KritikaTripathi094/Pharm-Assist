/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.List;
import dao.ProductDAO;
import Model.Product;
import java.awt.Dimension;
import java.awt.FlowLayout;
import view.Dashboard;
import view.ProductCard;
import dao.BloodBankDAO;
import Model.BloodBank;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import view.PaymentMethodPanel;
import view.StripePaymentPanel;

/**
 *
 * @author rojal
 */
public class DashboardController {

    private final ProductDAO dao;
    private Dashboard view;
    private BloodBankDAO bloodDao;

    public DashboardController(Dashboard view) {
        this.view = view;
        this.dao = new ProductDAO();
        this.bloodDao = new BloodBankDAO();
    }

    public List<Product> getAllProducts() {
        return dao.getAllProducts();
    }

    public List<Product> getProductsByCategory(String category) {
        return dao.getProductsByCategory(category);
    }

    public void loadAllProducts() {
        javax.swing.JPanel productListPanel = view.getProductListPanel();

        productListPanel.removeAll();
        productListPanel.setLayout(new java.awt.GridLayout(0, 4, 20, 20));

        try {
            List<Product> products = dao.getAllProducts();
            for (Model.Product product : products) {
                ProductCard card = new ProductCard();
                card.setProduct(product);
                card.setPreferredSize(new Dimension(150, 170));
                productListPanel.add(card);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        productListPanel.revalidate();
        productListPanel.repaint();
    }

    public void loadProductsByCategory(String category) {
        javax.swing.JPanel productListPanel = view.getProductListPanel();
        productListPanel.removeAll();
        productListPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));

        try {
            List<Product> products = dao.getProductsByCategory(category);

            for (Model.Product product : products) {
                ProductCard card = new ProductCard();
                card.setProduct(product);
                card.setPreferredSize(new Dimension(150, 170));
                productListPanel.add(card);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        productListPanel.revalidate();
        productListPanel.repaint();

    }

    public void loadBloodBanks() {
        try {
            List<BloodBank> banks = bloodDao.getAllBloodBanks();

            javax.swing.JTable table = view.getBloodBankTable(); // getter from Dashboard
            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) table.getModel();

            // Clear existing rows
            model.setRowCount(0);

            // Add rows
            for (BloodBank bank : banks) {
                Object[] row = {bank.getId(), bank.getName(), bank.getPhone(), bank.getLocation(), bank.getType()};
                model.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addTestPaymentButton(JPanel jPanel1, JPanel contentPanel) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setupPaymentPanel(JPanel paymentPanel, JPanel contentPanel) {
        // Make sure Payment container uses BorderLayout
        paymentPanel.setLayout(new BorderLayout());
        paymentPanel.removeAll();

        // Create PaymentMethodPanel with listener
        PaymentMethodPanel paymentMethodPanel = new PaymentMethodPanel(new PaymentMethodPanel.PaymentSelectionListener() {
            @Override
            public void stripeSelected() {
                handleStripeSelection(paymentPanel, contentPanel);
            }

            @Override
            public void codSelected() {
                handleCodSelection(contentPanel);
            }
        });

        // Add PaymentMethodPanel initially
        paymentPanel.add(paymentMethodPanel, BorderLayout.CENTER);
        paymentPanel.revalidate();
        paymentPanel.repaint();
    }

    /**
     * Handle Stripe payment selection
     */
    private void handleStripeSelection(JPanel paymentPanel, JPanel contentPanel) {
        System.out.println("DEBUG: Stripe selected!");
        double totalAmount = 2567; // This should come from cart/order in real app

        StripePaymentPanel stripePanel = new StripePaymentPanel(contentPanel, totalAmount);
        paymentPanel.removeAll();
        paymentPanel.add(stripePanel, BorderLayout.CENTER);
        paymentPanel.revalidate();
        paymentPanel.repaint();

        CardLayout cl = (CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, "card7");
    }

    /**
     * Handle Cash on Delivery selection
     */
    private void handleCodSelection(JPanel contentPanel) {
        System.out.println("DEBUG: COD selected!");
        JOptionPane.showMessageDialog(null, "Cash on Delivery selected!");
        CardLayout cl = (CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, "card7");
    }
}
