package Controller;

import Model.Productdetails;
import dao.Description;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class ProductDetailsController {

    private final Description dao;

    public ProductDetailsController() {
        dao = new Description();
    }

    public Productdetails getProductDetails(int productId) {
        return dao.getProductById(productId);
    }
    
  
    public void loadAndDisplayProduct(int productId, JLabel nameLabel, 
                                     JLabel priceLabel, JTextArea descriptionArea, 
                                     JLabel imageLabel) {
        Productdetails product = getProductDetails(productId);

        if (product != null) {
            nameLabel.setText(product.getName());
            priceLabel.setText("Rs. " + product.getPrice());
            descriptionArea.setText(product.getDescription());
            loadProductImage(product.getImage(), imageLabel);
        } else {
            nameLabel.setText("Product not found");
            priceLabel.setText("");
            descriptionArea.setText("No description available");
            setNoImage(imageLabel);
        }

        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
    }
    
   
    public void loadProductImage(String imageName, JLabel imageLabel) {
        if (imageName == null || imageName.isBlank()) {
            setNoImage(imageLabel);
            return;
        }

        try {
            java.net.URL imageUrl = 
                getClass().getResource("/images/" + imageName);

            if (imageUrl == null) {
                System.out.println("Image not found: " + imageName);
                setNoImage(imageLabel);
                return;
            }

            ImageIcon icon = new ImageIcon(imageUrl);
            Image img = icon.getImage();
            Image scaledImg = scaleImageToFit(img, 180, 180);

            imageLabel.setIcon(new ImageIcon(scaledImg));
            imageLabel.setText("");

        } catch (Exception e) {
            e.printStackTrace();
            setNoImage(imageLabel);
        }
    }
    
    
    private Image scaleImageToFit(Image img, int width, int height) {
        int originalWidth = img.getWidth(null);
        int originalHeight = img.getHeight(null);
        
        double widthRatio = (double) width / originalWidth;
        double heightRatio = (double) height / originalHeight;
        double ratio = Math.min(widthRatio, heightRatio);
        
        int newWidth = (int) (originalWidth * ratio);
        int newHeight = (int) (originalHeight * ratio);
        
        return img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
    }
    
   
    private void setNoImage(JLabel imageLabel) {
        imageLabel.setText("No Image");
        imageLabel.setIcon(null);
    }
}