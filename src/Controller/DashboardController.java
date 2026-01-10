package Controller;

import Model.Product;
import dao.ProductDAO;
import java.awt.BorderLayout;
import view.PaymentMethodPanel;
import view.StripePaymentPanel;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import view.Dashboard;
import view.ProductCard;

public class DashboardController {

    private final Dashboard dashboard;
    private final ProductDAO productDAO;

    public DashboardController(Dashboard dashboard) {
        this.dashboard = dashboard;
        this.productDAO = new ProductDAO();

        // ✅ IMPORTANT: do these immediately (NOT invokeLater),
        // because Dashboard loads products right after controller is created.
        attachAutoLinkListener();
        linkExistingProductCards();
    }

    // ---------------- PRODUCTS ----------------

    public List<Product> searchProducts(String keyword) {
    return productDAO.searchProducts(keyword, "All");
}

    public List<Product> getAllProducts() {
        try {
            List<Product> list = productDAO.getAllProducts();
            return list != null ? list : new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Product> getProductsByCategory(String category) {
        try {
            List<Product> list = productDAO.getProductsByCategory(category);
            return list != null ? list : new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // ---------------- BLOOD BANK (safe) ----------------

    public void loadBloodBanks() {
        try {
            JTable table = dashboard.getBloodBankTable();
            if (table == null) return;

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // keep empty safely, no crash
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    
    /**
     * Add test payment button to header
     */
    public void addTestPaymentButton(JPanel headerPanel, JPanel contentPanel) {
    javax.swing.JButton testPaymentBtn = new javax.swing.JButton("💰 Test Payment");
    
    // CHANGE THIS: Move to a non-overlapping position
    testPaymentBtn.setBounds(500, 40, 120, 25); // Changed from y=70 to y=40
    
    testPaymentBtn.setFont(new Font("Comic Neue", Font.BOLD, 12));
    testPaymentBtn.setEnabled(true);
    testPaymentBtn.setVisible(true);
    
    // Add debug to verify click
    testPaymentBtn.addActionListener(e -> {
        System.out.println("DEBUG: Test Payment button clicked!");
        System.out.println("Content panel: " + contentPanel);
        System.out.println("Layout: " + contentPanel.getLayout());
        
        CardLayout cl = (CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, "card7");
    });
    
    // Add mouse listener for debugging
    testPaymentBtn.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            System.out.println("Mouse ENTERED test payment button!");
        }
    });
    
    headerPanel.add(testPaymentBtn);
    
    // Debug information
    System.out.println("DEBUG: Test payment button added at (500, 40, 120, 25)");
    System.out.println("Button parent: " + testPaymentBtn.getParent());
    System.out.println("Panel component count: " + headerPanel.getComponentCount());
}

    
    
    // ---------------- AUTO LINK PRODUCTCARD -> DASHBOARD ----------------
    // This fixes: "Dashboard not linked!" WITHOUT editing view.

    private void linkExistingProductCards() {
        try {
            JPanel productListPanel = dashboard.getProductListPanel();
            if (productListPanel == null) return;

            for (java.awt.Component c : productListPanel.getComponents()) {
                if (c instanceof ProductCard) {
                    forceSetProductCardDashboard((ProductCard) c);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void attachAutoLinkListener() {
        try {
            JPanel productListPanel = dashboard.getProductListPanel();
            if (productListPanel == null) return;

            productListPanel.addContainerListener(new ContainerAdapter() {
                @Override
                public void componentAdded(ContainerEvent e) {
                    if (e.getChild() instanceof ProductCard) {
                        forceSetProductCardDashboard((ProductCard) e.getChild());
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void forceSetProductCardDashboard(ProductCard card) {
        try {
            // ProductCard has: private Dashboard dashboard;
            Field f = ProductCard.class.getDeclaredField("dashboard");
            f.setAccessible(true);
            f.set(card, dashboard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Object getPrivateField(Object obj, String fieldName) throws Exception {
        Field f = obj.getClass().getDeclaredField(fieldName);
        f.setAccessible(true);
        return f.get(obj);
    }

    public List<Product> search(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
