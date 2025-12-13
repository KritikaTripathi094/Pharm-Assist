package controller;



import Model.SearchModel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.CategoryofMedicine;

public class SearchController {

    private final CategoryofMedicine view;
    private final SearchModel model;

    public SearchController(CategoryofMedicine view, SearchModel model) {
        this.view = view;
        this.model = model;

        // connect search button click
        view.addSearchListener(new SearchListener());
    }

    class SearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            // 1) Get text from view
            String query = view.getSearchText();

            // 2) Save in model
            model.setSearchText(query);

            // 3) Filter panels inside jPanel4 by searching JLabel text
            filterPanelsByInnerLabelText(model.getSearchText());
        }
    }

    // ---- Filtering logic ----

    private void filterPanelsByInnerLabelText(String query) {
        query = query == null ? "" : query.trim().toLowerCase();

        // Loop through all components inside jPanel4
        for (Component comp : view.jPanel4.getComponents()) {

            // We only want to hide/show product panels
            if (comp instanceof JPanel productPanel) {

                boolean match = query.isEmpty() || panelContainsText(productPanel, query);
                productPanel.setVisible(match);
            }
        }

        view.jPanel4.revalidate();
        view.jPanel4.repaint();
    }

    private boolean panelContainsText(JPanel panel, String query) {
        for (Component child : panel.getComponents()) {

            // If child is JLabel → check its displayed text
            if (child instanceof JLabel lbl) {
                String text = lbl.getText();
                if (text != null && text.toLowerCase().contains(query)) {
                    return true;
                }
            }

            // If child is another panel → search inside it (nested panels)
            if (child instanceof JPanel innerPanel) {
                if (panelContainsText(innerPanel, query)) {
                    return true;
                }
            }
        }
        return false;
    }
}
