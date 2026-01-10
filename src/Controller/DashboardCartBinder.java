package Controller;

import java.awt.CardLayout;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.lang.reflect.Field;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import view.Dashboard;
import view.ProductCard;

public class DashboardCartBinder {

    private final Dashboard dashboard;

    public DashboardCartBinder(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    public void install() {
        SwingUtilities.invokeLater(() -> {
            linkExistingProductCards();
            watchFutureProductCards();
            hookShoppingCartButton();
        });
    }

    private void linkExistingProductCards() {
        JPanel productList = dashboard.getProductListPanel();
        if (productList == null) return;

        for (java.awt.Component c : productList.getComponents()) {
            if (c instanceof ProductCard) {
                ((ProductCard) c).setDashboard(dashboard);
            }
        }
    }

    private void watchFutureProductCards() {
        JPanel productList = dashboard.getProductListPanel();
        if (productList == null) return;

        productList.addContainerListener(new ContainerAdapter() {
            @Override
            public void componentAdded(ContainerEvent e) {
                if (e.getChild() instanceof ProductCard) {
                    ((ProductCard) e.getChild()).setDashboard(dashboard);
                }
            }
        });
    }

    private void hookShoppingCartButton() {
        try {
            JButton cartBtn = (JButton) getPrivateField(dashboard, "ShoppingCart"); // your button variable
            JPanel contentPanel = (JPanel) getPrivateField(dashboard, "contentPanel"); // your CardLayout panel

            if (cartBtn == null || contentPanel == null) return;

            for (var al : cartBtn.getActionListeners()) cartBtn.removeActionListener(al);

            cartBtn.addActionListener(ev -> {
                CardLayout cl = (CardLayout) contentPanel.getLayout();
                cl.show(contentPanel, "card8"); // Shoppingcart panel card name in your view
                dashboard.getCartController().refreshCart();
            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private Object getPrivateField(Object obj, String fieldName) throws Exception {
        Field f = obj.getClass().getDeclaredField(fieldName);
        f.setAccessible(true);
        return f.get(obj);
    }
}
