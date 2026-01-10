package Controller;

import Model.Product;
import dao.ProductDAO;

import java.awt.CardLayout;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
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

    // ---------------- CART BUTTON HOOK ----------------
    // Dashboard calls this in constructor -> MUST NOT crash.
    public void addTestPaymentButton(JPanel topPanel, JPanel contentPanel) {
        try {
            JButton cartBtn = (JButton) getPrivateField(dashboard, "ShoppingCart"); // button name in your view
            if (cartBtn == null) return;

            // remove old listeners (NetBeans sometimes auto adds)
            for (var al : cartBtn.getActionListeners()) {
                cartBtn.removeActionListener(al);
            }

            cartBtn.addActionListener(e -> {
                try {
                    CardLayout cl = (CardLayout) contentPanel.getLayout();
                    cl.show(contentPanel, "card8"); // your Shoppingcart panel key

                    // refresh cart UI
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
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
