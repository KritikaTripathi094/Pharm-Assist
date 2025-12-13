

import Model.SearchModel;
import controller.SearchController;
import view.CategoryofMedicine;


public class NewClass {
    public static void main(String[] args) {
        CategoryofMedicine view = new CategoryofMedicine();
        SearchModel model = new SearchModel();
        new SearchController(view, model);

        view.setVisible(true);
    }
}
