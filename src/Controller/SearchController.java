package Controller;

import Model.Product;
import Model.SearchModel;
import dao.ProductDAO;
import java.util.List;

public class SearchController {

    private final ProductDAO productDAO = new ProductDAO();

    public List<Product> search(SearchModel model) {
        String keyword = model.getKeyword();
        String category = model.getCategory(); // "All" / "Pain Relief" / "Anti-fungal"
        return productDAO.searchProducts(keyword, category);
    }
}
