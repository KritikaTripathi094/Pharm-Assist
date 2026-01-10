package Model;

import java.math.BigDecimal;

public class CartItem {

    private int orderItemId;
    private int orderId;
    private int productId;
    private String name;
    private String image;
    private BigDecimal unitPrice = BigDecimal.ZERO;
    private BigDecimal lineTotal = BigDecimal.ZERO;
    private int quantity = 1;
    private boolean selected = true;

    // ----- getters/setters -----

    public int getOrderItemId() { return orderItemId; }
    public void setOrderItemId(int id) { this.orderItemId = id; }

    public int getOrderId() { return orderId; }
    public void setOrderId(int id) { this.orderId = id; }

    public int getProductId() { return productId; }
    public void setProductId(int id) { this.productId = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public BigDecimal getUnitPrice() { return unitPrice; }
    public void setUnitPrice(BigDecimal price) { this.unitPrice = price; }

    public BigDecimal getLineTotal() { return lineTotal; }
    public void setLineTotal(BigDecimal total) { this.lineTotal = total; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int q) { this.quantity = Math.max(1, q); }

    public boolean isSelected() { return selected; }
    public void setSelected(boolean s) { this.selected = s; }

    public void setCategory(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setDescription(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setStock(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
