package Controller;

import Model.Product;
import Model.SearchModel;
import dao.ProductDAO;

import java.util.Collections;
import java.util.List;

public class SearchController {

    private final ProductDAO productDAO = new ProductDAO();

    public List<Product> search(SearchModel model) {
        if (model == null) return Collections.emptyList();

        String keyword = safe(model.getKeyword());
        String category = safe(model.getCategory());

        boolean hasKeyword = !keyword.isBlank();
        boolean hasCategory = !category.isBlank() && !category.equalsIgnoreCase("All");

        if (!hasKeyword && !hasCategory) {
            return productDAO.getAllProducts();
        }

        if (!hasKeyword && hasCategory) {
            return productDAO.getProductsByCategory(category);
        }

        // ✅ IMPORTANT: your ProductDAO MUST have this method:
        // List<Product> searchProducts(String keyword, String categoryFilter)
        return productDAO.searchProducts(keyword, hasCategory ? category : "All");
    }

    private String safe(String s) {
        return (s == null) ? "" : s.trim();
    }
}
