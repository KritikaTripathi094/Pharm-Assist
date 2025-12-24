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


/**
 *
 * @author rojal
 */
public class DashboardController {
    

    private ProductDAO dao;
    private Dashboard view;

    public DashboardController(Dashboard view) {
        this.view = view;
        this.dao = new ProductDAO();
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
}


    

    