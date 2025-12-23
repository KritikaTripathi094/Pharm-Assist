package Controller;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.CardLayout;
import java.sql.*;
import Model.Product;
import dao.ProductDAO;
import database.DBConnection;
import database.DatabaseHelper;

public class AdminDashboardController {

    // Method to switch views (cards) in the dashboard
    public static void showPanel(JPanel container, String panelName) {
        // Assuming the container is a JPanel with CardLayout
        CardLayout layout = (CardLayout) container.getLayout();
        layout.show(container, panelName); // Switch to the given panel
    }

    // Method to load product data into the table (example)
    public static void loadProductData(JTable table) {
        // Example data. Replace with actual data fetching logic (from DB, API, etc.)
        Object[][] data = {
            {"Product 1", "10", "Category A", "image1.png"},
            {"Product 2", "15", "Category B", "image2.png"},
        };

        DefaultTableModel model = new DefaultTableModel(data, new String[] {"Name", "Price", "Category", "Image"});
        table.setModel(model);
    }

    // Existing method to save a product (example, replace with actual save logic)
    public static void saveProduct(String name, String price, String category) {
        // Placeholder logic to save a product (e.g., database insertion, file writing)
        System.out.println("Saving product: " + name + ", " + price + ", " + category);
    }

   

    // New method to load product data from the database into the table
    public static void loadProductDataFromDB(JTable table) {
        // SQL query to fetch product data
        String query = "SELECT name, price, category, image, description, stock FROM products";

        try (Connection conn = DBConnection.getConnection(); // Establish connection
             PreparedStatement stmt = conn.prepareStatement(query); // Prepare query
             ResultSet rs = stmt.executeQuery()) { // Execute the query

            // Create a DefaultTableModel with column names
            DefaultTableModel model = new DefaultTableModel(new String[] {
                "Name", "Price", "Category", "Image", "Description", "Stock"
            }, 0);

            // Iterate through the result set and add rows to the table model
            while (rs.next()) {
                String name = rs.getString("name");
                String price = "$" + rs.getString("price"); // Format price with dollar sign
                String category = rs.getString("category");
                String image = rs.getString("image");
                String description = rs.getString("description");
                int stock = rs.getInt("stock");

                // Add the row to the table model
                model.addRow(new Object[] {name, price, category, image, description, stock});
            }

            // Set the model to the table to display the data
            table.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace(); // Print any SQL errors
        }
    }

    // New method to save a product to the database
    public static void saveProductToDatabase(String name, String price, String category, String description, int stock, String image) {
        // Validate inputs
        if (name.isEmpty() || price.isEmpty() || category.isEmpty() || description.isEmpty() || stock <= 0 || image.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields must be filled.");
            return;
        }

        try {
            // Convert price to double and stock to integer
            double parsedPrice = Double.parseDouble(price);
            
            // Create a Product object
            Product product = new Product();
            product.setName(name);
            product.setPrice(parsedPrice);
            product.setCategory(category);
            product.setDescription(description);
            product.setStock(stock);
            product.setImage(image);

            // Save the product using ProductDAO
            ProductDAO productDAO = new ProductDAO();
            boolean success = productDAO.addProduct(product); // Call the addProduct method of ProductDAO
            
            if (success) {
                JOptionPane.showMessageDialog(null, "Product saved successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to save product.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid price or stock value.");
        }
    }
    
    // Method to load products into the table
    public static void loadProductsIntoTable(javax.swing.JTable table) {
        // Database query to fetch all products
        String query = "SELECT name, price, category, image FROM products";

        try (Connection con = DatabaseHelper.getConnection();
             PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            // Define table columns
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);  // Clear the table

            // Iterate through the result set and add data to the table
            while (rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String category = rs.getString("category");
                String image = rs.getString("image");

                model.addRow(new Object[]{name, price, category, image});  // Add row to table
            }

        } catch (SQLException ex) {
            System.out.println("Error loading products: " + ex.getMessage());
        }
    }
    
    // Method to delete a product from the table
    public static void deleteProduct(JTable table, int selectedRow) {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    int rowCount = model.getRowCount();

    // Check if the selected row is within the bounds of the table
    if (selectedRow >= 0 && selectedRow < rowCount) {
        // Remove the product from the table
        model.removeRow(selectedRow);
        System.out.println("Product deleted from table.");

        // Optionally, delete from database as well
        String productName = model.getValueAt(selectedRow, 0).toString();  // Get product name from table (you can also use an ID if available)

        // Call a method to delete from DB (if needed)
        deleteProductFromDatabase(productName);

        // Revalidate table after deletion
        table.revalidate();
        table.repaint();

    } else {
        // Handle the case when the selected row is out of bounds
        System.out.println("Selected row is out of bounds.");
    }
}

// Method to delete product from the database
private static void deleteProductFromDatabase(String productName) {
    String query = "DELETE FROM products WHERE name = ?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, productName);
        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Product deleted from database.");
        } else {
            System.out.println("Failed to delete product from database.");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}
