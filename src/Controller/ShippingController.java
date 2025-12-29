/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.User;
import dao.UserDAO;
import view.EditPanel;
import view.Dashboard;
import javax.swing.JOptionPane;
/**
 *
 * @author This PC
 */
public class ShippingController {
    private EditPanel editPanel;
    private User currentUser;
    private Dashboard dashboard; // To refresh labels
    private UserDAO userDAO;
    public ShippingController(EditPanel editPanel, User currentUser, Dashboard dashboard) {
        this.editPanel = editPanel;
        this.currentUser = currentUser;
        this.dashboard = dashboard;
        this.userDAO = new UserDAO();
        // Load current data
        editPanel.loadUserData(
            currentUser.getUsername(),
            currentUser.getPhoneNumber(),
            currentUser.getAddress()
        );
        // Attach listeners
        initListeners();
    }
    private void initListeners() {
        editPanel.getSaveButton().addActionListener(e -> saveDetails());
        editPanel.getCancelButton().addActionListener(e -> editPanel.setVisible(false));
    }
    private void saveDetails() {
        String name = editPanel.getNameTextField().getText().trim();
        String phone = editPanel.getContactTextField().getText().trim();
        String address = editPanel.getAddressTextArea().getText().trim();
        if (name.isEmpty() || phone.isEmpty() || address.isEmpty()) {
            JOptionPane.showMessageDialog(editPanel, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean success = userDAO.updateShippingDetails(currentUser.getId(), name, phone, address);
        if (success) {
            // Update the currentUser object
            currentUser.setUsername(name);
            currentUser.setPhoneNumber(phone);
            currentUser.setAddress(address);
            // Refresh the labels in Dashboard
            dashboard.getTxtname().setText(name);
            dashboard.getTxtnumber().setText(phone);
            dashboard.getTxtlocation().setText(address);
            JOptionPane.showMessageDialog(editPanel, "Shipping details updated successfully!");
            editPanel.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(editPanel, "Update failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
   
}