/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Productdetails;
import dao.Description;

public class ProductDetailsController {

    private final Description dao;

    public ProductDetailsController() {
        dao = new Description();
    }

    public Productdetails getProductDetails(int productId) {
        return dao.getProductById(productId);
    }
}
