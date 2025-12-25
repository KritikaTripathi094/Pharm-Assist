/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.List;
import dao.ProductDAO;
import Model.Product;
import view.Dashboard;


/**
 *
 * @author rojal
 */
public class DashboardController {
    

    private final ProductDAO dao;
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
    
    
}


    

    