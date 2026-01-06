/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Model.User;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import view.ProductDescriptionPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Controller.ShippingController;

/**
 *
 * @author This PC
 */
public class Dashboard extends javax.swing.JFrame {
    private Model.User currentUser;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Dashboard.class.getName());
    
    private void initPopupMenu() {
        
    }
    private final Controller.DashboardController controller;

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        controller = new Controller.DashboardController(this);
        initPopupMenu();
        
        contentPanel.add(ProductDescriptionPanel, "productDescription");
        loadProductUI();
        loadAllProducts();
        editPanel = new EditPanel();
        editPanel.setBounds(450, 15, 240, 300);

        editPanel.setVisible(false);

        Shippingdetails.add(editPanel);
        
        // Added from their version: Show categories panel on startup
        CardLayout card = (CardLayout) contentPanel.getLayout();
        card.show(contentPanel, "categories"); 
        controller.loadAllProducts();
    }
    
    public void setCurrentUser(Model.User user) {
        this.currentUser = user;
        if (user != null) {
            System.out.println("User set: " + user.getUsername());
        }
    }
    
    // Added from their version
    public javax.swing.JPanel getProductListPanel() {
        return productListPanel;
    }
    
    // Added from their version
    public JTable getBloodBankTable() {
        return bloodBankTable;
    }
    
    private void loadProductUI() {
         
    }
    
    private void loadAllProducts() {
        productListPanel.removeAll();
        productListPanel.setLayout(new java.awt.GridLayout(0, 4, 20, 20));

        try {
            java.util.List<Model.Product> products = controller.getAllProducts();

            for (Model.Product product : products) {
                ProductCard card = new ProductCard();
                card.setProduct(product);
                card.setPreferredSize(new Dimension(150, 170));

                // Clicking a product opens the ProductDescriptionPanel
                card.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent e) {
                        // Simplified version - remove complex logic temporarily
                        try {
                            ProductDescriptionPanel.setLayout(new BorderLayout());
                            ProductDescriptionPanel pd = new ProductDescriptionPanel(product.getId(), contentPanel);
                            ProductDescriptionPanel.removeAll();
                            ProductDescriptionPanel.add(pd, BorderLayout.CENTER);
                            ProductDescriptionPanel.revalidate();
                            ProductDescriptionPanel.repaint();

                            CardLayout cl = (CardLayout) contentPanel.getLayout();
                            cl.show(contentPanel, "productDescription");
                            contentPanel.revalidate();
                            contentPanel.repaint();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                productListPanel.add(card);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        productListPanel.revalidate();
        productListPanel.repaint();
    }

    private void loadProductsByCategory(String category) {
        productListPanel.removeAll();
        productListPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));

        try {
            java.util.List<Model.Product> products = controller.getProductsByCategory(category);

            for (Model.Product product : products) {
                ProductCard card = new ProductCard();
                card.setProduct(product);
                card.setPreferredSize(new Dimension(150, 170));

                card.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent e) {
                        ProductDescriptionPanel.setLayout(new BorderLayout());
                        ProductDescriptionPanel pd = new ProductDescriptionPanel(product.getId(), contentPanel);
                        ProductDescriptionPanel.removeAll();
                        ProductDescriptionPanel.add(pd, BorderLayout.CENTER);
                        ProductDescriptionPanel.revalidate();
                        ProductDescriptionPanel.repaint();

                        CardLayout cl = (CardLayout) contentPanel.getLayout();
                        cl.show(contentPanel, "productDescription");
                        contentPanel.revalidate();
                        contentPanel.repaint();
                    }
                });

                productListPanel.add(card);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        productListPanel.revalidate();
        productListPanel.repaint();
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
        btnproceed = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        categories = new javax.swing.JPanel();
        categoryFilterPanel = new javax.swing.JPanel();
        Allbtn = new javax.swing.JButton();
        PainReliefbtn = new javax.swing.JButton();
        AntiFungalbtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        productScrollPane = new javax.swing.JScrollPane();
        productListPanel = new javax.swing.JPanel();
        emergency = new javax.swing.JPanel();
        emergencyScrollPane = new javax.swing.JScrollPane();
        bloodBankTable = new javax.swing.JTable();
        bmi = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Height = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Weight = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Calculatebtn = new javax.swing.JButton();
        Result = new javax.swing.JLabel();
        pharmacy = new javax.swing.JPanel();
        ProductDescriptionPanel = new javax.swing.JPanel();
        Shippingdetails = new javax.swing.JPanel();
        heder = new javax.swing.JPanel();
        panelfrodetail = new javax.swing.JPanel();
        txtlocation = new javax.swing.JLabel();
        txtname = new javax.swing.JLabel();
        txtnumber = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnedit = new javax.swing.JButton();
        itempricedetail = new javax.swing.JPanel();
        detail = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblitemprice = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbltotalprice = new javax.swing.JLabel();
        lbldetail = new javax.swing.JLabel();

        Profile.setText("Profile");
        jPopupMenu1.add(Profile);

        RateUs.setText("Rateus");
        RateUs.addActionListener(this::RateUsActionPerformed);
        jPopupMenu1.add(RateUs);

        Logout.setText("Logout");
        Logout.addActionListener(this::LogoutActionPerformed);
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
        Emergencycontactsbtn.setText("Emergency Contacts ");
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
        Contactpharmacybtn.setBounds(560, 70, 130, 28);

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
        Slogan.setBounds(10, 50, 210, 13);

        Searchbar.addActionListener(this::SearchbarActionPerformed);
        jPanel1.add(Searchbar);
        Searchbar.setBounds(200, 10, 360, 30);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cartlogo.png"))); // NOI18N
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setPreferredSize(new java.awt.Dimension(25, 25));
        jPanel1.add(jButton5);
        jButton5.setBounds(570, 10, 40, 30);

        btnproceed.setText("Proceed");
        btnproceed.addActionListener(this::btnproceedActionPerformed);
        jPanel1.add(btnproceed);
        btnproceed.setBounds(500, 40, 75, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 700, 100);

        contentPanel.setLayout(new java.awt.CardLayout());

        categories.setBackground(new java.awt.Color(244, 252, 255));
        categories.setLayout(null);

        categoryFilterPanel.setBackground(new java.awt.Color(255, 255, 255));
        categoryFilterPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        categoryFilterPanel.setLayout(null);

        Allbtn.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        Allbtn.setText("All");
        Allbtn.addActionListener(this::AllbtnActionPerformed);
        categoryFilterPanel.add(Allbtn);
        Allbtn.setBounds(0, 0, 120, 30);

        PainReliefbtn.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        PainReliefbtn.setText("Pain Relief");
        PainReliefbtn.addActionListener(this::PainReliefbtnActionPerformed);
        categoryFilterPanel.add(PainReliefbtn);
        PainReliefbtn.setBounds(0, 30, 120, 30);

        AntiFungalbtn.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        AntiFungalbtn.setText("Antifungal");
        AntiFungalbtn.addActionListener(this::AntiFungalbtnActionPerformed);
        categoryFilterPanel.add(AntiFungalbtn);
        AntiFungalbtn.setBounds(0, 60, 120, 30);

        categories.add(categoryFilterPanel);
        categoryFilterPanel.setBounds(30, 20, 120, 330);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        productScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        productListPanel.setBackground(new java.awt.Color(255, 255, 255));
        productScrollPane.setViewportView(productListPanel);

        jPanel3.add(productScrollPane);
        productScrollPane.setBounds(0, 0, 550, 330);

        categories.add(jPanel3);
        jPanel3.setBounds(150, 20, 530, 330);

        contentPanel.add(categories, "categories");

        emergency.setBackground(new java.awt.Color(244, 252, 255));
        emergency.setLayout(null);

        emergencyScrollPane.setBackground(new java.awt.Color(255, 255, 255));

        bloodBankTable.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        bloodBankTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "S.N.", "Name", "Phone", "Location", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        emergencyScrollPane.setViewportView(bloodBankTable);

        emergency.add(emergencyScrollPane);
        emergencyScrollPane.setBounds(30, 20, 650, 310);

        contentPanel.add(emergency, "emergency");

        bmi.setBackground(new java.awt.Color(245, 253, 255));
        bmi.setLayout(null);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setPreferredSize(new java.awt.Dimension(651, 319));
        jPanel14.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel1.setText("BMI CALCULATOR");
        jPanel14.add(jLabel1);
        jLabel1.setBounds(230, 10, 220, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BMI_Chart.png"))); // NOI18N
        jLabel3.setOpaque(true);
        jPanel14.add(jLabel3);
        jLabel3.setBounds(350, 40, 300, 250);

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel4.setText("Please enter your height and weight");
        jPanel14.add(jLabel4);
        jLabel4.setBounds(30, 60, 280, 30);

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel5.setText("Your Height");
        jPanel14.add(jLabel5);
        jLabel5.setBounds(30, 110, 120, 26);

        Height.setText("0");
        jPanel14.add(Height);
        Height.setBounds(30, 140, 50, 30);

        jLabel6.setText("CM");
        jPanel14.add(jLabel6);
        jLabel6.setBounds(80, 140, 37, 30);

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel7.setText("Your Weight");
        jPanel14.add(jLabel7);
        jLabel7.setBounds(30, 190, 120, 26);

        Weight.setText("0");
        jPanel14.add(Weight);
        Weight.setBounds(30, 220, 50, 30);

        jLabel8.setText("KG");
        jPanel14.add(jLabel8);
        jLabel8.setBounds(80, 220, 37, 30);

        Calculatebtn.setBackground(new java.awt.Color(14, 94, 174));
        Calculatebtn.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        Calculatebtn.setForeground(new java.awt.Color(255, 255, 255));
        Calculatebtn.setText("Calculate");
        Calculatebtn.addActionListener(this::CalculatebtnActionPerformed);
        jPanel14.add(Calculatebtn);
        Calculatebtn.setBounds(240, 240, 100, 30);

        Result.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel14.add(Result);
        Result.setBounds(20, 270, 200, 30);

        bmi.add(jPanel14);
        jPanel14.setBounds(30, 10, 651, 319);

        contentPanel.add(bmi, "bmi");

        pharmacy.setBackground(new java.awt.Color(153, 0, 153));
        contentPanel.add(pharmacy, "pharmacy");

        ProductDescriptionPanel.setBackground(new java.awt.Color(255, 255, 255));
        ProductDescriptionPanel.setFont(new java.awt.Font("Comic Neue", 0, 12)); // NOI18N
        ProductDescriptionPanel.setPreferredSize(new java.awt.Dimension(500, 200));
        contentPanel.add(ProductDescriptionPanel, "productDescription");

        Shippingdetails.setBackground(new java.awt.Color(245, 253, 255));
        Shippingdetails.setLayout(null);

        heder.setBackground(new java.awt.Color(214, 242, 249));
        heder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        heder.setLayout(null);

        panelfrodetail.setBackground(new java.awt.Color(255, 255, 255));
        panelfrodetail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelfrodetail.setFont(new java.awt.Font("Comic Neue", 0, 14)); // NOI18N
        panelfrodetail.setLayout(null);

        txtlocation.setFont(new java.awt.Font("Comic Neue", 0, 14)); // NOI18N
        txtlocation.setText("location");
        panelfrodetail.add(txtlocation);
        txtlocation.setBounds(10, 50, 330, 40);

        txtname.setFont(new java.awt.Font("Comic Neue", 0, 14)); // NOI18N
        txtname.setText("name ");
        panelfrodetail.add(txtname);
        txtname.setBounds(10, 10, 90, 17);

        txtnumber.setFont(new java.awt.Font("Comic Neue", 0, 14)); // NOI18N
        txtnumber.setText("phone");
        panelfrodetail.add(txtnumber);
        txtnumber.setBounds(120, 10, 100, 17);

        heder.add(panelfrodetail);
        panelfrodetail.setBounds(0, 20, 430, 90);

        jLabel9.setFont(new java.awt.Font("Comic Neue", 1, 14)); // NOI18N
        jLabel9.setText("Shipping Details");
        heder.add(jLabel9);
        jLabel9.setBounds(10, 0, 120, 20);

        btnedit.setBackground(new java.awt.Color(214, 242, 249));
        btnedit.setFont(new java.awt.Font("Comic Neue", 1, 14)); // NOI18N
        btnedit.setText("Edit");
        btnedit.setBorderPainted(false);
        btnedit.setContentAreaFilled(false);
        btnedit.addActionListener(this::btneditActionPerformed);
        heder.add(btnedit);
        btnedit.setBounds(370, 0, 60, 20);

        Shippingdetails.add(heder);
        heder.setBounds(20, 20, 430, 110);

        itempricedetail.setBackground(new java.awt.Color(214, 243, 250));
        itempricedetail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        itempricedetail.setLayout(null);

        detail.setBackground(new java.awt.Color(255, 255, 255));
        detail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        detail.setFont(new java.awt.Font("Comic Neue", 0, 12)); // NOI18N
        detail.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Comic Neue", 0, 12)); // NOI18N
        jLabel10.setText("Item Total");
        detail.add(jLabel10);
        jLabel10.setBounds(10, 10, 70, 14);

        jLabel11.setFont(new java.awt.Font("Comic Neue", 0, 12)); // NOI18N
        jLabel11.setText("Delivery Fee");
        detail.add(jLabel11);
        jLabel11.setBounds(10, 40, 64, 14);

        jLabel12.setFont(new java.awt.Font("Comic Neue", 0, 12)); // NOI18N
        jLabel12.setText("Total:");
        detail.add(jLabel12);
        jLabel12.setBounds(10, 80, 60, 14);

        jButton1.setBackground(new java.awt.Color(14, 93, 174));
        jButton1.setFont(new java.awt.Font("Comic Neue", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Place Order");
        detail.add(jButton1);
        jButton1.setBounds(32, 120, 92, 20);

        lblitemprice.setFont(new java.awt.Font("Comic Neue", 0, 12)); // NOI18N
        lblitemprice.setText("iprice");
        detail.add(lblitemprice);
        lblitemprice.setBounds(90, 10, 50, 14);

        jLabel13.setFont(new java.awt.Font("Comic Neue", 0, 12)); // NOI18N
        jLabel13.setText("RS.90");
        detail.add(jLabel13);
        jLabel13.setBounds(89, 40, 40, 14);

        lbltotalprice.setFont(new java.awt.Font("Comic Neue", 0, 12)); // NOI18N
        lbltotalprice.setText("tprice");
        detail.add(lbltotalprice);
        lbltotalprice.setBounds(90, 80, 60, 14);

        itempricedetail.add(detail);
        detail.setBounds(0, 30, 150, 160);

        lbldetail.setFont(new java.awt.Font("Comic Neue", 1, 14)); // NOI18N
        lbldetail.setText("Order Details");
        itempricedetail.add(lbldetail);
        lbldetail.setBounds(30, 6, 90, 20);

        Shippingdetails.add(itempricedetail);
        itempricedetail.setBounds(540, 20, 150, 190);

        contentPanel.add(Shippingdetails, "Shippingdetails");

        getContentPane().add(contentPanel);
        contentPanel.setBounds(0, 100, 700, 350);

        setBounds(0, 0, 716, 460);
    }// </editor-fold>//GEN-END:initComponents

    private void SearchbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchbarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchbarActionPerformed

    private void AccountbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountbtnActionPerformed
        jPopupMenu1.show(Accountbtn, 0, Accountbtn.getHeight());
    }//GEN-LAST:event_AccountbtnActionPerformed

    private void ContactpharmacybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactpharmacybtnActionPerformed
        CardLayout card = (CardLayout) contentPanel.getLayout();
        card.show(contentPanel, "pharmacy");
    }//GEN-LAST:event_ContactpharmacybtnActionPerformed

    private void BmibtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BmibtnActionPerformed
        CardLayout card = (CardLayout) contentPanel.getLayout();
        card.show(contentPanel, "bmi");
    }//GEN-LAST:event_BmibtnActionPerformed

    private void AllcategoriesbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllcategoriesbtnActionPerformed
        CardLayout card = (CardLayout) contentPanel.getLayout();
        card.show(contentPanel, "categories");
    }//GEN-LAST:event_AllcategoriesbtnActionPerformed

    private void EmergencycontactsbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmergencycontactsbtnActionPerformed
        CardLayout card = (CardLayout) contentPanel.getLayout();
        card.show(contentPanel, "emergency");
        controller.loadBloodBanks();
    }//GEN-LAST:event_EmergencycontactsbtnActionPerformed

    private void PainReliefbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PainReliefbtnActionPerformed
       loadProductsByCategory("Pain Relief");
    }//GEN-LAST:event_PainReliefbtnActionPerformed

    private void AntiFungalbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AntiFungalbtnActionPerformed
       loadProductsByCategory("Anti-fungal");
    }//GEN-LAST:event_AntiFungalbtnActionPerformed

    private void AllbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllbtnActionPerformed
       loadAllProducts();
    }//GEN-LAST:event_AllbtnActionPerformed

    private void RateUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RateUsActionPerformed
        RateUS rateFrame = new RateUS();
        rateFrame.setVisible(true);
        rateFrame.setLocationRelativeTo(this);
    }//GEN-LAST:event_RateUsActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        this.dispose();
        Login loginWindow = new Login();
        loginWindow.setVisible(true);
    }//GEN-LAST:event_LogoutActionPerformed

    private void btnproceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproceedActionPerformed
        CardLayout card = (CardLayout) contentPanel.getLayout();
        card.show(contentPanel, "Shippingdetails");
        
        String username = currentUser.getUsername();
        String phone = currentUser.getPhoneNumber();
        String address = currentUser.getAddress();
        
        txtname.setText(username != null ? username : "Name not available");
        txtnumber.setText(phone != null ? phone : "Phone not available");
        txtlocation.setText(address != null ? address : "Address not available");
        
        System.out.println("=== Shipping Details ===");
        System.out.println("User: " + username);
        System.out.println("Phone: " + phone);
        System.out.println("Address: " + address);
    }//GEN-LAST:event_btnproceedActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        if (currentUser == null) {
            JOptionPane.showMessageDialog(this, "No user logged in!");
            return;
        }

        ShippingController shippingController = new ShippingController(editPanel, currentUser, this);
        Shippingdetails.setComponentZOrder(editPanel, 0);
        editPanel.setVisible(true);

        Shippingdetails.revalidate();
        Shippingdetails.repaint();
    }//GEN-LAST:event_btneditActionPerformed

    private void CalculatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculatebtnActionPerformed
        try {
            double heightCm = Double.parseDouble(Height.getText());
            double weightKg = Double.parseDouble(Weight.getText());
            double heightM = heightCm / 100.0;
            double bmi = weightKg / (heightM * heightM);
            String category;
            if (bmi < 18.5) {
                category = "Underweight";
            } else if (bmi < 25) {
                category = "Normal Weight";
            } else if (bmi < 30) {
                category = "Overweight";
            } else {
                category = "Obese";
            }
            Result.setText(String.format("%.2f", bmi) + " (" + category + ")");
        } catch (NumberFormatException e) {
            Result.setText("Enter valid numbers");
        }
    }//GEN-LAST:event_CalculatebtnActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new Dashboard().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Accountbtn;
    private javax.swing.JButton Allbtn;
    private javax.swing.JButton Allcategoriesbtn;
    private javax.swing.JButton AntiFungalbtn;
    private javax.swing.JButton Bmibtn;
    private javax.swing.JButton Calculatebtn;
    private javax.swing.JButton Contactpharmacybtn;
    private javax.swing.JButton Emergencycontactsbtn;
    private javax.swing.JTextField Height;
    private javax.swing.JMenuItem Logout;
    private javax.swing.JButton PainReliefbtn;
    private javax.swing.JPanel ProductDescriptionPanel;
    private javax.swing.JMenuItem Profile;
    private javax.swing.JMenuItem RateUs;
    private javax.swing.JLabel Result;
    private javax.swing.JTextField Searchbar;
    private javax.swing.JPanel Shippingdetails;
    private javax.swing.JLabel Slogan;
    private javax.swing.JTextField Weight;
    private javax.swing.JTable bloodBankTable;
    private javax.swing.JPanel bmi;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnproceed;
    private javax.swing.JPanel categories;
    private javax.swing.JPanel categoryFilterPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel detail;
    private javax.swing.JPanel emergency;
    private javax.swing.JScrollPane emergencyScrollPane;
    private javax.swing.JPanel heder;
    private javax.swing.JPanel itempricedetail;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JLabel lbldetail;
    private javax.swing.JLabel lblitemprice;
    private javax.swing.JLabel lbltotalprice;
    private javax.swing.JLabel logopharmassist;
    private javax.swing.JLabel namepharmassist;
    private javax.swing.JPanel panelfrodetail;
    private javax.swing.JPanel pharmacy;
    private javax.swing.JPanel productListPanel;
    private javax.swing.JScrollPane productScrollPane;
    private javax.swing.JLabel txtlocation;
    private javax.swing.JLabel txtname;
    private javax.swing.JLabel txtnumber;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JLabel getTxtname() {
        return txtname;
    }

    public javax.swing.JLabel getTxtnumber() {
        return txtnumber;
    }

    public javax.swing.JLabel getTxtlocation() {
        return txtlocation;
    }
    
    public javax.swing.JPanel getDetailPanel() {
        return detail;
    }
    
    public javax.swing.JPanel getShippingDetailsPanel() {
        return Shippingdetails;
    }
    
    private EditPanel editPanel;
}