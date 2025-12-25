
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template

*/

package view;

import Controller.ProductController;
import Model.Product;
import javax.swing.UnsupportedLookAndFeelException;

public class ProductDescription extends javax.swing.JFrame {

    private int productId;

    /**
     * Default constructor (for testing)
     */
    public ProductDescription() {
        initComponents();
    }

    /**
     * Constructor with product ID
     * @param productId
     */
    public ProductDescription(int productId) {
        this.productId = productId;
        initComponents();
        loadProductDetails();
    }

    /**
     * Load product data from DB
     */
    private void loadProductDetails() {
        try {
            ProductController controller = new ProductController();
            Product product = controller.getProductById(productId);

            if (product == null) return;

            Flexontab.setText(product.getName());
            priceLabel.setText("Rs : " + product.getPrice());
            jTextArea1.setText(product.getDescription());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        whitebackground1 = new javax.swing.JPanel();
        imageLabel1 = new javax.swing.JPanel();
        Flexontab1 = new javax.swing.JLabel();
        manufacturer1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        priceLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        whitebackground = new javax.swing.JPanel();
        imageLabel = new javax.swing.JPanel();
        Flexontab = new javax.swing.JLabel();
        manufacturer = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        priceLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();

        jLabel8.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));

        jLabel12.setText("jLabel12");

        jLabel14.setText("jLabel14");

        whitebackground1.setBackground(new java.awt.Color(255, 255, 255));
        whitebackground1.setForeground(new java.awt.Color(255, 255, 255));
        whitebackground1.setLayout(null);

        imageLabel1.setPreferredSize(new java.awt.Dimension(201, 145));
        imageLabel1.setLayout(null);
        whitebackground1.add(imageLabel1);
        imageLabel1.setBounds(0, 0, 201, 120);

        Flexontab1.setFont(new java.awt.Font("Comic Neue", 1, 13)); // NOI18N
        Flexontab1.setText("Flexon Tab");
        Flexontab1.setPreferredSize(new java.awt.Dimension(124, 16));
        whitebackground1.add(Flexontab1);
        Flexontab1.setBounds(250, 0, 180, 20);

        manufacturer1.setFont(new java.awt.Font("Comic Neue", 1, 13)); // NOI18N
        manufacturer1.setText("Manufacturer :");
        whitebackground1.add(manufacturer1);
        manufacturer1.setBounds(250, 20, 90, 20);

        jLabel5.setFont(new java.awt.Font("Comic Neue", 0, 13)); // NOI18N
        jLabel5.setText("Aristo Pharmaceuticals");
        whitebackground1.add(jLabel5);
        jLabel5.setBounds(340, 20, 150, 20);

        jLabel6.setFont(new java.awt.Font("Comic Neue", 1, 13)); // NOI18N
        jLabel6.setText("Delivery date : ");
        whitebackground1.add(jLabel6);
        jLabel6.setBounds(250, 40, 90, 16);

        jLabel9.setText("1-3");
        whitebackground1.add(jLabel9);
        jLabel9.setBounds(340, 40, 80, 16);

        jLabel10.setFont(new java.awt.Font("Comic Neue", 1, 13)); // NOI18N
        jLabel10.setText("Quantity :");
        jLabel10.setPreferredSize(new java.awt.Dimension(56, 17));
        whitebackground1.add(jLabel10);
        jLabel10.setBounds(250, 80, 60, 17);

        jButton2.setText("Add to Cart");
        jButton2.addActionListener(this::jButton2ActionPerformed);
        whitebackground1.add(jButton2);
        jButton2.setBounds(250, 100, 150, 23);

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Comic Neue", 0, 12)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setText("Composition:\nIbuprofen (400mg) + Paracetamol (325mg)\n\nFlexon Tablet contains two painkiller medicines. They work together to reduce pain, fever, and inflammation. It is used to \ntreat many conditions such as headache, muscle pain, pain during periods, toothache, and joint pain. Flexon Tablet is best \ntaken with food to reduce side effects. The dose and how often you need it will be decided by your doctor. You should \ntake it regularly as advised by your doctor. Medicines used to treat pain are usually best taken at the first sign of pain.\nIt is meant for short-term use only. Consult your doctor if the symptoms persist or worsen or if the medicine is required \nfor use beyond 3 days.\n\nUses\nPain relief\nTreatment of Fever\nSide Effect\nCommon side effects:\n\nHeartburn\nIndigestion\nNausea\nStomach pain\nTake this medicine in the dose and duration as advised by your doctor. Swallow it as a whole. Do not chew, crush or break it. Flexon Tablet is to be taken with food.\n\nHow It works\nFlexon Tablet is a combination of two medicines: Ibuprofen and Paracetamol. It works by blocking the release of certain \nchemical messengers that cause fever, pain and inflammation (redness and swelling).\n\nWhat if you forget to take?\nIf you miss a dose of Flexon Tablet, take it as soon as possible. However, if it is almost time for your next dose, skip the\n missed dose and go back to your regular schedule. Do not double the dose.\n\nSafety Advice for Flexon Tab\n1. Alchohol\n: It is unsafe to consume alcohol with Flexon Tablet.\n\n2. Pregnancy\n:Flexon Tablet may be unsafe to use during pregnancy. Although there are limited studies in humans, animal studies have\nshown harmful effects on the developing baby. Your doctor will weigh the benefits and any potential risks before \nprescribing it to you. Please consult your d\n\n3. Breastfeeding\n:Flexon Tablet is safe to use during breastfeeding. Human studies suggest that the drug does not pass into the breastmilk\nin a significant amount and is not harmful to the baby\n\n \n");
        jTextArea2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane3.setViewportView(jTextArea2);

        whitebackground1.add(jScrollPane3);
        jScrollPane3.setBounds(10, 130, 640, 190);

        priceLabel1.setFont(new java.awt.Font("Comic Neue", 1, 12)); // NOI18N
        priceLabel1.setText("Rs : 160");
        whitebackground1.add(priceLabel1);
        priceLabel1.setBounds(257, 60, 110, 14);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setMinimumSize(new java.awt.Dimension(700, 450));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 450));
        jPanel1.setLayout(null);

        whitebackground.setBackground(new java.awt.Color(255, 255, 255));
        whitebackground.setForeground(new java.awt.Color(255, 255, 255));
        whitebackground.setLayout(null);

        imageLabel.setPreferredSize(new java.awt.Dimension(201, 145));
        imageLabel.setLayout(null);
        whitebackground.add(imageLabel);
        imageLabel.setBounds(0, 0, 201, 120);

        Flexontab.setFont(new java.awt.Font("Comic Neue", 1, 13)); // NOI18N
        Flexontab.setText("Flexon Tab");
        Flexontab.setPreferredSize(new java.awt.Dimension(124, 16));
        whitebackground.add(Flexontab);
        Flexontab.setBounds(250, 0, 180, 20);

        manufacturer.setFont(new java.awt.Font("Comic Neue", 1, 13)); // NOI18N
        manufacturer.setText("Manufacturer :");
        whitebackground.add(manufacturer);
        manufacturer.setBounds(250, 20, 90, 20);

        jLabel2.setFont(new java.awt.Font("Comic Neue", 0, 13)); // NOI18N
        jLabel2.setText("Aristo Pharmaceuticals");
        whitebackground.add(jLabel2);
        jLabel2.setBounds(340, 20, 150, 20);

        jLabel3.setFont(new java.awt.Font("Comic Neue", 1, 13)); // NOI18N
        jLabel3.setText("Delivery date : ");
        whitebackground.add(jLabel3);
        jLabel3.setBounds(250, 40, 90, 16);

        jLabel4.setText("1-3");
        whitebackground.add(jLabel4);
        jLabel4.setBounds(340, 40, 80, 16);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Comic Neue", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("Composition:\nIbuprofen (400mg) + Paracetamol (325mg)\n\nFlexon Tablet contains two painkiller medicines. They work together to reduce pain, fever, and inflammation. It is used to \ntreat many conditions such as headache, muscle pain, pain during periods, toothache, and joint pain. Flexon Tablet is best \ntaken with food to reduce side effects. The dose and how often you need it will be decided by your doctor. You should \ntake it regularly as advised by your doctor. Medicines used to treat pain are usually best taken at the first sign of pain.\nIt is meant for short-term use only. Consult your doctor if the symptoms persist or worsen or if the medicine is required \nfor use beyond 3 days.\n\nUses\nPain relief\nTreatment of Fever\nSide Effect\nCommon side effects:\n\nHeartburn\nIndigestion\nNausea\nStomach pain\nTake this medicine in the dose and duration as advised by your doctor. Swallow it as a whole. Do not chew, crush or break it. Flexon Tablet is to be taken with food.\n\nHow It works\nFlexon Tablet is a combination of two medicines: Ibuprofen and Paracetamol. It works by blocking the release of certain \nchemical messengers that cause fever, pain and inflammation (redness and swelling).\n\nWhat if you forget to take?\nIf you miss a dose of Flexon Tablet, take it as soon as possible. However, if it is almost time for your next dose, skip the\n missed dose and go back to your regular schedule. Do not double the dose.\n\nSafety Advice for Flexon Tab\n1. Alchohol\n: It is unsafe to consume alcohol with Flexon Tablet.\n\n2. Pregnancy\n:Flexon Tablet may be unsafe to use during pregnancy. Although there are limited studies in humans, animal studies have\nshown harmful effects on the developing baby. Your doctor will weigh the benefits and any potential risks before \nprescribing it to you. Please consult your d\n\n3. Breastfeeding\n:Flexon Tablet is safe to use during breastfeeding. Human studies suggest that the drug does not pass into the breastmilk\nin a significant amount and is not harmful to the baby\n\n \n");
        jTextArea1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setViewportView(jTextArea1);

        whitebackground.add(jScrollPane2);
        jScrollPane2.setBounds(10, 130, 640, 190);

        priceLabel.setFont(new java.awt.Font("Comic Neue", 1, 12)); // NOI18N
        priceLabel.setText("Rs : 160");
        whitebackground.add(priceLabel);
        priceLabel.setBounds(250, 60, 110, 14);

        jPanel1.add(whitebackground);
        whitebackground.setBounds(20, 100, 650, 320);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/hello.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, -10, 690, 470);

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(700, 450));
        jScrollPane1.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 590, 440);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(603, 332));
        jPanel1.add(jPanel2);
        jPanel2.setBounds(40, 110, 620, 320);

        jTextField1.setText("jTextField1");
        jPanel1.add(jTextField1);
        jTextField1.setBounds(0, 50, 160, 22);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 690, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
public static void main(String args[]) {
    /* Set the Nimbus look and feel */
  try {
    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
            javax.swing.UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
    ex.printStackTrace();
}


    java.awt.EventQueue.invokeLater(() -> new ProductDescription().setVisible(true)
    );
}


    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Flexontab;
    private javax.swing.JLabel Flexontab1;
    private javax.swing.JPanel imageLabel;
    private javax.swing.JPanel imageLabel1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel manufacturer;
    private javax.swing.JLabel manufacturer1;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel priceLabel1;
    private javax.swing.JPanel whitebackground;
    private javax.swing.JPanel whitebackground1;
    // End of variables declaration//GEN-END:variables

}