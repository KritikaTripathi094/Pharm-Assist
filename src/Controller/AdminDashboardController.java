package Controller;

import Model.ImageUploader;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.CardLayout;
import java.sql.*;
import Model.Product;
import dao.ProductDAO;
import database.DBConnections;
import database.DatabaseHelper;

public class AdminDashboardController {

    // Method to switch views (cards) in the dashboard
    public static void showPanel(JPanel container, String panelName) {
        CardLayout layout = (CardLayout) container.getLayout();
        layout.show(container, panelName);
    }

    // Method to load product data into the table (example)
    public static void loadProductData(JTable table) {
        Object[][] data = {
            {"Product 1", "10", "Category A", "image1.png"},
            {"Product 2", "15", "Category B", "image2.png"},
        };

        DefaultTableModel model = new DefaultTableModel(
            data,
            new String[] {"Name", "Price", "Category", "Image"}
        );
        table.setModel(model);
    }

    // Existing method to save a product (example)
    public static void saveProduct(String name, String price, String category) {
        System.out.println("Saving product: " + name + ", " + price + ", " + category);
    }

    // New method to load product data from the database into the table
    public static void loadProductDataFromDB(JTable table) {
        String query = "SELECT name, price, category, image, description, stock FROM products";

        try (Connection conn = DBConnections.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            DefaultTableModel model = new DefaultTableModel(
                new String[] {"Name", "Price", "Category", "Image", "Description", "Stock"}, 0
            );

            while (rs.next()) {
                model.addRow(new Object[] {
                    rs.getString("name"),
                    "Rs" + rs.getString("price"),
                    rs.getString("category"),
                    rs.getString("image"),
                    rs.getString("description"),
                    rs.getInt("stock")
                });
            }

            table.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // New method to save a product to the database
    public static void saveProductToDatabase(
        String name, String price, String category,
        String description, int stock, String image
    ) {

        if (name.isEmpty() || price.isEmpty() || category.isEmpty()
                || description.isEmpty() || stock <= 0 || image.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields must be filled.");
            return;
        }

        try {
            double parsedPrice = Double.parseDouble(price);

            Product product = new Product();
            product.setName(name);
            product.setPrice(parsedPrice);
            product.setCategory(category);
            product.setDescription(description);
            product.setStock(stock);
            product.setImage(image);

            ProductDAO productDAO = new ProductDAO();
            boolean success = productDAO.addProduct(product);

            if (success) {
                JOptionPane.showMessageDialog(null, "Product saved successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to save product.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid price or stock value.");
        }
    }

    // ============================
    // ✅ FIX 1: LOAD WITH ID COLUMN
    // ============================
    public static void loadProductsIntoTable(JTable table) {

        String query = "SELECT id, name, price, category, image FROM products";

        try (Connection con = DatabaseHelper.getConnection();
             PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            DefaultTableModel model = new DefaultTableModel(
                new Object[]{"ID", "Name", "Price", "Category", "Image"}, 0
            );
            table.setModel(model);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("price"),
                    rs.getString("category"),
                    rs.getString("image")
                });
            }

            // hide ID column
            table.getColumnModel().getColumn(0).setMinWidth(0);
            table.getColumnModel().getColumn(0).setMaxWidth(0);

        } catch (SQLException ex) {
            System.out.println("Error loading products: " + ex.getMessage());
        }
    }

    // ============================
    // ✅ FIX 2: DELETE PRODUCT
    // ============================
    public static void deleteProduct(JTable table, int selectedRow) {

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Get data BEFORE removing row
        int productId = (int) model.getValueAt(selectedRow, 0);
        String imageFileName = (String) model.getValueAt(selectedRow, 4);  // Image column

        int confirm = JOptionPane.showConfirmDialog(
            null,
            "Delete this product?\nThis will also permanently delete the image file.",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );

        if (confirm != JOptionPane.YES_OPTION) return;

        // First: Delete from database
        if (deleteProductFromDatabase(productId)) {
            // Second: Delete physical image file
            boolean imageDeleted = ImageUploader.deleteImage(imageFileName);

            // Third: Remove row from table
            model.removeRow(selectedRow);

            String msg = "Product deleted successfully.";
            if (!imageDeleted && !imageFileName.isEmpty()) {
                msg += "\nWarning: Image file could not be deleted.";
            }
            JOptionPane.showMessageDialog(null, msg);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to delete product from database.");
        }
    }

    // ============================
    // ✅ FIX 3: DELETE BY ID (DB)
    // ============================
    private static boolean deleteProductFromDatabase(int productId) {

        String query = "DELETE FROM products WHERE id = ?";

        try (Connection conn = DBConnections.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, productId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void saveTableChanges(JTable table) {

    DefaultTableModel model = (DefaultTableModel) table.getModel();
    ProductDAO dao = new ProductDAO();

    int updated = 0;

    for (int i = 0; i < model.getRowCount(); i++) {

        Product product = new Product();
        product.setId((int) model.getValueAt(i, 0));
        product.setName(model.getValueAt(i, 1).toString());
        product.setPrice(Double.parseDouble(model.getValueAt(i, 2).toString()));
        product.setCategory(model.getValueAt(i, 3).toString());
        product.setImage(model.getValueAt(i, 4).toString());

        if (dao.updateProduct(product)) {
            updated++;
        }
    }

    JOptionPane.showMessageDialog(
        null,
        " product saved successfully."
    );
    
    
}

}
