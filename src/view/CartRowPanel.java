package view;

import dao.ProductDAO;

import Controller.ShoppingCartController;
import Model.CartItem;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.net.URL;

public class CartRowPanel extends JPanel {

    private ShoppingCartController controller;
    private CartItem item;

    // 🔹 Load and scale image
    private ImageIcon loadScaledIcon(String imageName, int w, int h) {
        if (imageName == null || imageName.trim().isEmpty()) return null;

        URL url = getClass().getResource("/images/" + imageName);
        if (url == null) return null;

        ImageIcon icon = new ImageIcon(url);
        Image img = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
    

    // 🔹 Constructor
    public CartRowPanel(ShoppingCartController controller, CartItem item, int index) {

        this.controller = controller;
        this.item = item;

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        JCheckBox cb = new JCheckBox();
        cb.setSelected(item.isSelected());

        // 🖼 IMAGE PANEL (this is your "pic")
        JLabel pic = new JLabel();
        pic.setPreferredSize(new Dimension(60, 60));
        pic.setIcon(loadScaledIcon(item.getImage(), 55, 55));

        JLabel name = new JLabel(item.getName());
        JLabel qty = new JLabel(String.valueOf(item.getQuantity()));
        


        JButton plus = new JButton("+");
        JButton minus = new JButton("-");

        JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel sn = new JLabel(index + ".");
        sn.setPreferredSize(new Dimension(20, 20));
        left.setOpaque(false);
        left.add(cb);
        left.add(pic);       // ← medicine image
        left.add(name);

        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        right.setOpaque(false);
        right.add(minus);
        right.add(qty);
        right.add(plus);

        add(left, BorderLayout.CENTER);
        add(right, BorderLayout.EAST);

        // ✔ Checkbox select/unselect
     cb.addActionListener(e -> controller.setSelected(item, cb.isSelected()));

plus.addActionListener(e -> {
    int status = controller.increaseQty(item);
    if (status == -1) {
        JOptionPane.showMessageDialog(this, "Max amount of purchase is 7");
    }
});

minus.addActionListener(e -> controller.decreaseQty(item));
    }
}
