package Controller;

import dao.ShoppingCartDAO;
import java.util.List;
import javax.swing.JOptionPane;
import Model.CartItem;
import view.Dashboard;

public class ShoppingCartController {

    private final ShoppingCartDAO dao = new ShoppingCartDAO();
    private final Dashboard view;

    public ShoppingCartController(Dashboard view) {
        this.view = view;
    }

    public void addToCart(int productId, String productName) {
        try {
            dao.addToCart(productId);
            JOptionPane.showMessageDialog(view, "Added to cart: " + productName);
            refreshCart();
        } catch (Exception ex) {
            if ("LIMIT_EXCEEDED".equals(ex.getMessage())) {
                JOptionPane.showMessageDialog(view, "Quantity limit exceeded. Maximum allowed is 3");
            } else {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(view, "Error adding to cart");
            }
        }
    }

    public void plus(int productId) {
        try {
            int currentQty = view.getDisplayedQty(productId);
            dao.updateQuantity(productId, currentQty + 1);
            refreshCart();
        } catch (Exception ex) {
            if ("LIMIT_EXCEEDED".equals(ex.getMessage())) {
                JOptionPane.showMessageDialog(view, "Quantity limit exceeded. Maximum allowed is 7");
            } else {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(view, "Error updating quantity");
            }
        }
    }

    public void minus(int productId) {
        try {
            int currentQty = view.getDisplayedQty(productId);
            dao.updateQuantity(productId, currentQty - 1);
            refreshCart();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(view, "Error updating quantity");
        }
    }

    public void selectAll(boolean select) {
        try {
            dao.setSelectAll(select);
            refreshCart();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteSelected() {
        try {
            dao.deleteSelected();
            refreshCart();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void confirmCart() {
        try {
            dao.confirmCart();
            JOptionPane.showMessageDialog(view, "Cart confirmed!");
            refreshCart();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(view, "Error confirming cart");
        }
    }

    public void refreshCart() {
        try {
            List<CartItem> items = dao.getCartItems();
            view.renderCart(items);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
