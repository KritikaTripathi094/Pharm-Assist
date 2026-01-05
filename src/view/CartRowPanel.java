package view;

import Controller.ShoppingCartController;
import Model.CartItem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CartRowPanel extends JPanel {

    private final ShoppingCartController controller;
    private final CartItem item;
    private final int productId;

    private final JCheckBox cb = new JCheckBox();
    private final JLabel imageLabel = new JLabel();
    private final JLabel nameLabel = new JLabel();
    private final JButton btnMinus = new JButton("-");
    private final JLabel qtyLabel = new JLabel("1");
    private final JButton btnPlus = new JButton("+");
    private final JLabel priceLabel = new JLabel("Rs. 0");

    public CartRowPanel(ShoppingCartController controller, CartItem item) {
        this.controller = controller;
        this.item = item;
        this.productId = item.getProductId();

        setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(380, 70));

        cb.setSelected(item.isSelected());
        cb.setBackground(Color.WHITE);
        cb.addActionListener(e -> controller.refreshCart());

        imageLabel.setPreferredSize(new Dimension(50, 50));
        loadImage(item.getImage());

        nameLabel.setPreferredSize(new Dimension(120, 25));
        nameLabel.setFont(new Font("Comic Neue", Font.BOLD, 12));
        nameLabel.setText(item.getProductName());

        btnMinus.setPreferredSize(new Dimension(45, 28));
        btnPlus.setPreferredSize(new Dimension(45, 28));
        qtyLabel.setPreferredSize(new Dimension(25, 25));
        qtyLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        qtyLabel.setText(String.valueOf(item.getQuantity()));

        btnMinus.addActionListener(e -> controller.minus(productId));
        btnPlus.addActionListener(e -> controller.plus(productId));

        priceLabel.setPreferredSize(new Dimension(90, 25));
        priceLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        priceLabel.setText("Rs. " + item.getLineTotal().toPlainString());

        add(cb);
        add(imageLabel);
        add(nameLabel);
        add(btnMinus);
        add(qtyLabel);
        add(btnPlus);
        add(priceLabel);
    }

    private void loadImage(String imageName) {
        try {
            if (imageName == null || imageName.trim().isEmpty()) {
                imageLabel.setText("No Image");
                return;
            }

            java.net.URL url = getClass().getResource("/images/" + imageName);
            if (url == null) {
                imageLabel.setText("No Image");
                return;
            }

            ImageIcon icon = new ImageIcon(url);
            Image scaled = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(scaled));
            imageLabel.setText("");

        } catch (Exception ex) {
            imageLabel.setText("No Image");
        }
    }
}
