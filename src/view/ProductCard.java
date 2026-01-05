package view;

import Model.Product;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ProductCard extends javax.swing.JPanel {

    private Product product;
    private Dashboard dashboard;   // ✅ reference to dashboard

    public ProductCard() {
        initComponents();
        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    }

    // ✅ Dashboard will call this
    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    public void setProduct(Product product) {
        this.product = product;

        if (product != null) {
            lblName.setText(product.getName());
            lblPrice.setText("Rs. " + product.getPrice());
            loadProductImage();
        }
    }

    public Product getProduct() {
        return product;
    }

    private void loadProductImage() {
        if (product == null) {
            lblImage.setText("No Image");
            lblImage.setIcon(null);
            return;
        }

        String imageName = product.getImage();
        if (imageName == null || imageName.trim().isEmpty()) {
            lblImage.setText("No Image");
            lblImage.setIcon(null);
            return;
        }

        try {
            java.net.URL url = getClass().getResource("/images/" + imageName);
            if (url == null) {
                lblImage.setText("No Image");
                lblImage.setIcon(null);
                return;
            }

            ImageIcon icon = new ImageIcon(url);
            Image scaled = icon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            lblImage.setIcon(new ImageIcon(scaled));
            lblImage.setText("");

        } catch (Exception e) {
            lblImage.setText("No Image");
            lblImage.setIcon(null);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImage = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        btnAddToCart = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(100, 100));
        setLayout(null);

        lblImage.setBackground(new java.awt.Color(255, 255, 255));
        lblImage.setOpaque(true);
        add(lblImage);
        lblImage.setBounds(50, 10, 60, 60);

        lblName.setText("     item name");
        add(lblName);
        lblName.setBounds(20, 80, 110, 20);

        lblPrice.setText("     item price");
        add(lblPrice);
        lblPrice.setBounds(20, 100, 110, 20);

        btnAddToCart.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnAddToCart.setText("Add to cart");
        btnAddToCart.addActionListener(this::btnAddToCartActionPerformed);
        add(btnAddToCart);
        btnAddToCart.setBounds(30, 130, 100, 21);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
            if (product == null) return;

        if (dashboard == null) {
            JOptionPane.showMessageDialog(this, "Dashboard not linked!");
            return;
        }// TODO add your handling code here:
                                                
     dashboard.getCartController().addToCart(product.getId(), product.getName());
    
    }//GEN-LAST:event_btnAddToCartActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPrice;
    // End of variables declaration//GEN-END:variables


}


