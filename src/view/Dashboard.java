/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;

/**
 *
 * @author This PC
 */
public class Dashboard extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Dashboard.class.getName());
    private void initPopupMenu() {
        
}

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        initPopupMenu();
        loadProductUI();
    }
     private void loadProductUI() {
             System.out.println("=== DEBUG START ===");
    
    // Clear the panel first
    jPanel4.removeAll();
    
    // DEBUG: Check panel before
    System.out.println("jPanel4 size: " + jPanel4.getWidth() + "x" + jPanel4.getHeight());
    System.out.println("jPanel4 visible: " + jPanel4.isVisible());
    
    // Use FlowLayout for horizontal scrolling
    jPanel4.setLayout(new java.awt.FlowLayout(
        java.awt.FlowLayout.LEFT,
        20,
        20
    ));
    
    try {
        // Get products from DATABASE
        dao.ProductDAO productDAO = new dao.ProductDAO();
        java.util.List<Model.Product> products = productDAO.getAllProducts();
        
        System.out.println("✅ Database returned: " + products.size() + " products");
        
        // DEBUG: List ALL products
        System.out.println("📋 PRODUCT LIST:");
        for (int i = 0; i < products.size(); i++) {
            Model.Product p = products.get(i);
            System.out.println((i+1) + ". " + p.getName() + " | Rs." + p.getPrice() + " | Image: " + p.getImage());
        }
        
        if (products.isEmpty()) {
            System.out.println("⚠️ No products in DB, creating 3 test cards...");
            
            // Create 3 TEST cards to verify
            for (int i = 1; i <= 3; i++) {
                Model.Product test = new Model.Product(i, "TEST " + i, i*100, "okflexon.jpg");
                ProductCard card = new ProductCard();
                card.setProduct(test);
                card.setPreferredSize(new java.awt.Dimension(150, 170));
                
                // Add colored border to see each card
                card.setBorder(javax.swing.BorderFactory.createLineBorder(
                    new java.awt.Color(i*80, i*50, i*30), 3
                ));
                
                jPanel4.add(card);
                System.out.println("   Added TEST card " + i);
            }
        } else {
            // Create and add product cards from DATABASE
            System.out.println("🛠️ Creating cards...");
            for (int i = 0; i < products.size(); i++) {
                Model.Product product = products.get(i);
                System.out.println("   Creating card " + (i+1) + ": " + product.getName());
                
                ProductCard card = new ProductCard();
                card.setProduct(product);
                card.setPreferredSize(new java.awt.Dimension(150, 170));
                
                // Add colored border to see each card
                card.setBorder(javax.swing.BorderFactory.createLineBorder(
                    java.awt.Color.RED, 2
                ));
                
                card.setCartButtonAction(e -> {
                    javax.swing.JOptionPane.showMessageDialog(
                        Dashboard.this,
                        "✅ Added: " + product.getName() + "\nPrice: Rs." + product.getPrice(),
                        "Cart",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE
                    );
                });
                
                jPanel4.add(card);
                System.out.println("   ✅ Card added to panel");
            }
        }
        
    } catch (Exception e) {
        System.err.println("❌ ERROR: " + e.getMessage());
        e.printStackTrace();
        
        // Show 3 error test cards
        for (int i = 1; i <= 3; i++) {
            javax.swing.JLabel errorCard = new javax.swing.JLabel("ERROR " + i, javax.swing.SwingConstants.CENTER);
            errorCard.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.RED));
            errorCard.setPreferredSize(new java.awt.Dimension(150, 170));
            jPanel4.add(errorCard);
        }
    }
    
    // Set preferred size for scrolling
    jPanel4.setPreferredSize(new java.awt.Dimension(800, 350));
    
    // DEBUG: Check after adding
    System.out.println("jPanel4 now has: " + jPanel4.getComponentCount() + " components");
    
    // Refresh
    jPanel4.revalidate();
    jPanel4.repaint();
    jScrollPane2.revalidate();
    
    System.out.println("=== DEBUG END ===");
                
     }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Profile = new javax.swing.JMenuItem();
        RateUs = new javax.swing.JMenuItem();
        Logout = new javax.swing.JMenuItem();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Allcategoriesbtn = new javax.swing.JButton();
        Emergencycontactsbtn = new javax.swing.JButton();
        Bmibtn = new javax.swing.JButton();
        Contactpharmacybtn = new javax.swing.JButton();
        logopharmassist = new javax.swing.JLabel();
        Accountbtn = new javax.swing.JButton();
        namepharmassist = new javax.swing.JLabel();
        Slogan = new javax.swing.JLabel();
        Searchbar = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        categories = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        emergency = new javax.swing.JPanel();
        bmi = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        pharmacy = new javax.swing.JPanel();

        Profile.setText("Profile");
        jPopupMenu1.add(Profile);

        RateUs.setText("Rateus");
        jPopupMenu1.add(RateUs);

        Logout.setText("Logout");
        jPopupMenu1.add(Logout);

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        Allcategoriesbtn.setBackground(new java.awt.Color(14, 94, 174));
        Allcategoriesbtn.setFont(new java.awt.Font("Comic Neue", 0, 13)); // NOI18N
        Allcategoriesbtn.setForeground(new java.awt.Color(255, 255, 255));
        Allcategoriesbtn.setText("All Categories");
        Allcategoriesbtn.setBorder(null);
        Allcategoriesbtn.setBorderPainted(false);
        Allcategoriesbtn.addActionListener(this::AllcategoriesbtnActionPerformed);
        jPanel1.add(Allcategoriesbtn);
        Allcategoriesbtn.setBounds(0, 70, 122, 28);

        Emergencycontactsbtn.setFont(new java.awt.Font("Comic Neue", 0, 13)); // NOI18N
        Emergencycontactsbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/emergencyicon.png"))); // NOI18N
        Emergencycontactsbtn.setText("Emergency Contacts  ");
        Emergencycontactsbtn.setBorder(null);
        Emergencycontactsbtn.setBorderPainted(false);
        Emergencycontactsbtn.setContentAreaFilled(false);
        Emergencycontactsbtn.addActionListener(this::EmergencycontactsbtnActionPerformed);
        jPanel1.add(Emergencycontactsbtn);
        Emergencycontactsbtn.setBounds(180, 70, 160, 28);

        Bmibtn.setFont(new java.awt.Font("Comic Neue", 0, 13)); // NOI18N
        Bmibtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bmiicon.png"))); // NOI18N
        Bmibtn.setText("BMI");
        Bmibtn.setBorder(null);
        Bmibtn.setBorderPainted(false);
        Bmibtn.setContentAreaFilled(false);
        Bmibtn.addActionListener(this::BmibtnActionPerformed);
        jPanel1.add(Bmibtn);
        Bmibtn.setBounds(410, 70, 60, 28);

        Contactpharmacybtn.setFont(new java.awt.Font("Comic Neue", 0, 13)); // NOI18N
        Contactpharmacybtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/contactpharmacyicon.png"))); // NOI18N
        Contactpharmacybtn.setText("Contact Pharmacy");
        Contactpharmacybtn.setBorder(null);
        Contactpharmacybtn.setBorderPainted(false);
        Contactpharmacybtn.setContentAreaFilled(false);
        Contactpharmacybtn.addActionListener(this::ContactpharmacybtnActionPerformed);
        jPanel1.add(Contactpharmacybtn);
        Contactpharmacybtn.setBounds(560, 70, 131, 28);

        logopharmassist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reallogo.png"))); // NOI18N
        jPanel1.add(logopharmassist);
        logopharmassist.setBounds(10, 10, 40, 40);

        Accountbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/accounticon.png"))); // NOI18N
        Accountbtn.setText("Account");
        Accountbtn.setBorder(null);
        Accountbtn.setBorderPainted(false);
        Accountbtn.setContentAreaFilled(false);
        Accountbtn.addActionListener(this::AccountbtnActionPerformed);
        jPanel1.add(Accountbtn);
        Accountbtn.setBounds(620, 10, 80, 23);

        namepharmassist.setFont(new java.awt.Font("Comic Neue", 1, 20)); // NOI18N
        namepharmassist.setText("Pharm-Assist");
        jPanel1.add(namepharmassist);
        namepharmassist.setBounds(60, 3, 130, 40);

        Slogan.setFont(new java.awt.Font("Comic Neue", 0, 11)); // NOI18N
        Slogan.setText("Your healthy dose of convenience");
        jPanel1.add(Slogan);
        Slogan.setBounds(10, 50, 210, 15);

        Searchbar.addActionListener(this::SearchbarActionPerformed);
        jPanel1.add(Searchbar);
        Searchbar.setBounds(200, 10, 360, 30);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cartlogo.png"))); // NOI18N
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setPreferredSize(new java.awt.Dimension(25, 25));
        jPanel1.add(jButton5);
        jButton5.setBounds(570, 10, 40, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 700, 100);

        contentPanel.setLayout(new java.awt.CardLayout());

        categories.setBackground(new java.awt.Color(244, 252, 255));
        categories.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        jButton1.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton1.setText("Pain Relief");
        jButton1.addActionListener(this::jButton1ActionPerformed);
        jPanel2.add(jButton1);
        jButton1.setBounds(0, 0, 120, 30);

        jButton2.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton2.setText("Antifungal");
        jButton2.addActionListener(this::jButton2ActionPerformed);
        jPanel2.add(jButton2);
        jButton2.setBounds(0, 30, 120, 30);

        categories.add(jPanel2);
        jPanel2.setBounds(30, 20, 120, 310);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        jScrollPane2.setViewportView(jPanel4);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(0, 0, 530, 310);

        categories.add(jPanel3);
        jPanel3.setBounds(150, 20, 530, 310);

        contentPanel.add(categories, "categories");

        emergency.setBackground(new java.awt.Color(255, 0, 0));
        contentPanel.add(emergency, "emergency");

        bmi.setBackground(new java.awt.Color(245, 253, 255));
        bmi.setLayout(null);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setPreferredSize(new java.awt.Dimension(651, 319));
        jPanel14.setLayout(null);
        bmi.add(jPanel14);
        jPanel14.setBounds(30, 10, 651, 319);

        contentPanel.add(bmi, "bmi");

        pharmacy.setBackground(new java.awt.Color(153, 0, 153));
        contentPanel.add(pharmacy, "pharmacy");

        getContentPane().add(contentPanel);
        contentPanel.setBounds(0, 100, 700, 350);

        setBounds(0, 0, 716, 459);
    }// </editor-fold>//GEN-END:initComponents

    private void SearchbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchbarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchbarActionPerformed

    private void AccountbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountbtnActionPerformed
        // TODO add your handling code here:
    jPopupMenu1.show(Accountbtn, 0, Accountbtn.getHeight());
    }//GEN-LAST:event_AccountbtnActionPerformed

    private void ContactpharmacybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactpharmacybtnActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout) contentPanel.getLayout();
        card.show(contentPanel, "pharmacy");
    }//GEN-LAST:event_ContactpharmacybtnActionPerformed

    private void BmibtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BmibtnActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout) contentPanel.getLayout();
        card.show(contentPanel, "bmi");
    }//GEN-LAST:event_BmibtnActionPerformed

    private void AllcategoriesbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllcategoriesbtnActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout) contentPanel.getLayout();
        card.show(contentPanel, "categories");
    }//GEN-LAST:event_AllcategoriesbtnActionPerformed

    private void EmergencycontactsbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmergencycontactsbtnActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout) contentPanel.getLayout();
        card.show(contentPanel, "emergency");
    }//GEN-LAST:event_EmergencycontactsbtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Dashboard().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Accountbtn;
    private javax.swing.JButton Allcategoriesbtn;
    private javax.swing.JButton Bmibtn;
    private javax.swing.JButton Contactpharmacybtn;
    private javax.swing.JButton Emergencycontactsbtn;
    private javax.swing.JMenuItem Logout;
    private javax.swing.JMenuItem Profile;
    private javax.swing.JMenuItem RateUs;
    private javax.swing.JTextField Searchbar;
    private javax.swing.JLabel Slogan;
    private javax.swing.JPanel bmi;
    private javax.swing.JPanel categories;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel emergency;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel logopharmassist;
    private javax.swing.JLabel namepharmassist;
    private javax.swing.JPanel pharmacy;
    // End of variables declaration//GEN-END:variables
}
