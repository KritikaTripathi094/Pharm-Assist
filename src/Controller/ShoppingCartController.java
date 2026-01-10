package Controller;

import Model.CartItem;
import dao.ShoppingCartDAO;
import java.util.List;
import javax.swing.JOptionPane;
import view.Dashboard;

public class ShoppingCartController {

    private final ShoppingCartDAO dao = new ShoppingCartDAO();
    private int activeOrderId = -1;
    private final Dashboard dashboard;

    public ShoppingCartController(Dashboard dashboard) {
        this.dashboard = dashboard;
        this.activeOrderId = dao.getOrCreateActiveOrderId();
    }

    private int getOrderId() {
        if (activeOrderId <= 0) activeOrderId = dao.getOrCreateActiveOrderId();
        return activeOrderId;
    }

    // ================= ADD TO CART =================
    public int addToCart(int productId, int qty) {
        int orderId = getOrderId();
        int addQty = Math.max(1, qty);

        dao.addToCart(orderId, productId, addQty);
        refreshCart();
        return 1;
    }

    public int addToCart(int productId, String productName) {
        return addToCart(productId, 1);
    }

    // ================= CART REFRESH =================
    public void refreshCart() {
        List<CartItem> items = dao.getCartItems(getOrderId());
        dashboard.renderCart(items);
    }

    // ================= QUANTITY =================
    public int increaseQty(CartItem item) {
        if (item.getQuantity() >= 7) return -1;
        dao.updateQuantity(getOrderId(), item.getProductId(), item.getQuantity() + 1);
        refreshCart();
        return 1;
    }

    public void decreaseQty(CartItem item) {
        if (item.getQuantity() > 1) {
            dao.updateQuantity(getOrderId(), item.getProductId(), item.getQuantity() - 1);
            refreshCart();
        }
    }

    // ================= SELECT =================
    public void setSelected(CartItem item, boolean selected) {
        dao.setSelected(getOrderId(), item.getProductId(), selected);
        refreshCart();
    }

    public void setAllSelected(boolean selected) {
        for (CartItem c : dao.getCartItems(getOrderId())) {
            dao.setSelected(getOrderId(), c.getProductId(), selected);
        }
        refreshCart();
    }

    // ================= DELETE =================
    public int deleteSelected() {
        int n = dao.deleteSelected(getOrderId());
        refreshCart();
        return n;
    }

    // ================= CONFIRM =================
   public void confirmCart() {
    dao.confirmOrder(getOrderId());
    JOptionPane.showMessageDialog(dashboard, "Order Confirmed!");
        dashboard.showConfirmMessage();
    }
}
