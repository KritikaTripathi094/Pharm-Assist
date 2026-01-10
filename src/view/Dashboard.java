/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import Controller.SearchController;
import Model.SearchModel;
import Model.Product;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.lang.reflect.Field;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


import Controller.DashboardController;
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
import Controller.ShoppingCartController;
import Model.CartItem;
import dao.ProductDAO;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JLabel;


/**
 *
 * @author This PC
 */
public class Dashboard extends javax.swing.JFrame {

    private Model.User currentUser;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Dashboard.class.getName());

    private final ShoppingCartController cartController = new ShoppingCartController(this);
    public ShoppingCartController getCartController() {
    return cartController;
}

    private void initPopupMenu() {

    }
    private final Controller.DashboardController controller;

    /**
     * Creates new form Dashboard
     */
   

    public Dashboard() {
        initComponents();
        // ✅ Delete selected items
jButton2.addActionListener(e -> {
    int deleted = cartController.deleteSelected();
    JOptionPane.showMessageDialog(this, deleted + " item(s) deleted");
});

// ✅ Confirm cart popup
ConfirmCart.addActionListener(e -> {
    JOptionPane.showMessageDialog(this, "Confirmed!");
});

        jButton2.addActionListener(e -> {
    int deleted = cartController.deleteSelected();
    JOptionPane.showMessageDialog(this, deleted + " item(s) deleted");
});
ConfirmCart.addActionListener(e -> {
    cartController.confirmCart();
    JOptionPane.showMessageDialog(this, "Order Confirmed Successfully!");
});


        controller = new DashboardController(this);
        

        // Show categories panel by default
        CardLayout card = (CardLayout) contentPanel.getLayout();
        card.show(contentPanel, "categories");

        
        // Add ProductDescriptionPanel card
        contentPanel.add(ProductDescriptionPanel, "productDescription");

        // Load all products initially
        loadAllProducts();

        // Initialize Shipping panel (from second version)
        editPanel = new EditPanel();
        editPanel.setBounds(450, 15, 240, 300);
        editPanel.setVisible(false);
        Shippingdetails.add(editPanel);

        // Add test payment button if needed
        addTestPaymentButton();
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
        List<Product> products = controller.getAllProducts();

        for (Product product : products) {
            ProductCard card = new ProductCard();
            card.setDashboard(this);    // ⭐ LINKED
            card.setProduct(product);
            card.setPreferredSize(new Dimension(150,170));
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
    productListPanel.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));

    try {
        List<Product> products = controller.getProductsByCategory(category);

        for (Product product : products) {
            ProductCard card = new ProductCard();
            card.setDashboard(this);    // ⭐ LINKED
            card.setProduct(product);
            card.setPreferredSize(new Dimension(150,170));
            productListPanel.add(card);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    productListPanel.revalidate();
    productListPanel.repaint();
}


    private void addTestPaymentButton() {
        controller.addTestPaymentButton(jPanel1, contentPanel);
    }

//    private void setupContentPanels() {
//        controller.setupPaymentPanel(Payment, contentPanel);
//    }
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
        SearchButton = new javax.swing.JButton();
        Searchbar = new javax.swing.JTextField();
        Contactpharmacybtn = new javax.swing.JButton();
        logopharmassist = new javax.swing.JLabel();
        Accountbtn = new javax.swing.JButton();
        namepharmassist = new javax.swing.JLabel();
        Slogan = new javax.swing.JLabel();
        btnproceed = new javax.swing.JButton();
        ShoppingCart = new javax.swing.JButton();
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
        jLabel18 = new javax.swing.JLabel();
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
        Shoppingcart = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        SelectedItem = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        ConfirmCart = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        ADD = new javax.swing.JButton();
        SUB = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        Pic = new javax.swing.JPanel();
        jScrollBar1 = new javax.swing.JScrollBar();

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

        SearchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/searchlogo.png"))); // NOI18N
        SearchButton.addActionListener(this::SearchButtonActionPerformed);
        jPanel1.add(SearchButton);
        SearchButton.setBounds(519, 10, 40, 30);

        Searchbar.addActionListener(this::SearchbarActionPerformed);
        jPanel1.add(Searchbar);
        Searchbar.setBounds(200, 10, 360, 30);

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

        btnproceed.setText("Proceed");
        btnproceed.addActionListener(this::btnproceedActionPerformed);
        jPanel1.add(btnproceed);
        btnproceed.setBounds(500, 40, 75, 23);

        ShoppingCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cartlogo.png"))); // NOI18N
        ShoppingCart.setBorderPainted(false);
        ShoppingCart.setContentAreaFilled(false);
        ShoppingCart.setPreferredSize(new java.awt.Dimension(25, 25));
        ShoppingCart.addActionListener(this::ShoppingCartActionPerformed);
        jPanel1.add(ShoppingCart);
        ShoppingCart.setBounds(570, 10, 40, 30);

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

        pharmacy.setBackground(new java.awt.Color(255, 255, 255));
        pharmacy.setLayout(null);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Contact pharmacy1.png"))); // NOI18N
        pharmacy.add(jLabel18);
        jLabel18.setBounds(30, 20, 640, 300);

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

        Shoppingcart.setBackground(new java.awt.Color(244, 252, 255));
        Shoppingcart.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        SelectedItem.setText("Selected Item(s)");
        SelectedItem.addActionListener(this::SelectedItemActionPerformed);
        jPanel2.add(SelectedItem);
        SelectedItem.setBounds(10, 0, 120, 20);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bin.png"))); // NOI18N
        jPanel2.add(jButton2);
        jButton2.setBounds(290, 0, 20, 20);

        jLabel17.setText("Delete Item(s)");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(310, 0, 90, 20);

        Shoppingcart.add(jPanel2);
        jPanel2.setBounds(40, 50, 402, 24);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        ConfirmCart.setText("Confirm Cart");
        jPanel4.add(ConfirmCart);
        ConfirmCart.setBounds(10, 100, 208, 25);

        jLabel14.setText("Total");
        jPanel4.add(jLabel14);
        jLabel14.setBounds(20, 60, 123, 22);

        jLabel15.setText("Order Summary");
        jPanel4.add(jLabel15);
        jLabel15.setBounds(20, 10, 123, 22);

        jLabel16.setText("Selected items price ");
        jPanel4.add(jLabel16);
        jLabel16.setBounds(20, 40, 123, 22);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jPanel5);
        jPanel5.setBounds(145, 42, 60, 20);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jPanel6);
        jPanel6.setBounds(145, 62, 60, 20);

        Shoppingcart.add(jPanel4);
        jPanel4.setBounds(460, 50, 230, 138);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(null);

        ADD.setText("+");
        jPanel7.add(ADD);
        ADD.setBounds(90, 40, 40, 23);

        SUB.setText("-");
        jPanel7.add(SUB);
        SUB.setBounds(160, 40, 40, 23);
        jPanel7.add(jPanel8);
        jPanel8.setBounds(-10, -10, 10, 10);
        jPanel7.add(Pic);
        Pic.setBounds(0, 0, 90, 80);
        jPanel7.add(jScrollBar1);
        jScrollBar1.setBounds(390, 0, 10, 80);

        Shoppingcart.add(jPanel7);
        jPanel7.setBounds(42, 90, 410, 77);

        contentPanel.add(Shoppingcart, "card8");

        getContentPane().add(contentPanel);
        contentPanel.setBounds(0, 100, 700, 350);

        setBounds(0, 0, 716, 460);
    }// </editor-fold>//GEN-END:initComponents

    
    private java.util.Map<Integer, Integer> qtyMap = new java.util.HashMap<>();

    public int getDisplayedQty(int productId) {
        return qtyMap.getOrDefault(productId, 1);
    }

    private void SearchbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchbarActionPerformed
   String keyword = Searchbar.getText().trim();

    // show all if empty
    if (keyword.isEmpty()) {
        loadAllProducts();
        return;
    }

    ProductDAO dao = new ProductDAO();
    List<Product> products = dao.searchProducts(keyword);

    productListPanel.removeAll();
    productListPanel.setLayout(new java.awt.GridLayout(0, 4, 20, 20));

    for (Product p : products) {
        ProductCard card = new ProductCard();
        card.setDashboard(this);
        card.setProduct(p);
        card.setPreferredSize(new java.awt.Dimension(150, 170));
        productListPanel.add(card);
    }

    productListPanel.revalidate();
    productListPanel.repaint();
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

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        String keyword = Searchbar.getText().trim();

    if (keyword.isEmpty()) {
        loadAllProducts();
        return;
    }

    try {
        ProductDAO dao = new ProductDAO();
        List<Product> products = dao.searchProducts(keyword); // ✅ this one

        productListPanel.removeAll();
        productListPanel.setLayout(new java.awt.GridLayout(0, 4, 20, 20));

        for (Product product : products) {
            ProductCard card = new ProductCard();
            card.setDashboard(this);
            card.setProduct(product);
            productListPanel.add(card);
        }

        productListPanel.revalidate();
        productListPanel.repaint();

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Search failed!");
    }
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void ShoppingCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShoppingCartActionPerformed
        CardLayout cl = (CardLayout) contentPanel.getLayout();
cl.show(contentPanel, "card8");     // your Shoppingcart panel
cartController.refreshCart();       // load items

    }//GEN-LAST:event_ShoppingCartActionPerformed

    private void SelectedItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectedItemActionPerformed
        String keyword = Searchbar.getText().trim();

    if (keyword.isEmpty()) {
        loadAllProducts();
        return;
    }

    try {
        dao.ProductDAO dao = new dao.ProductDAO();
        List<Model.Product> products = dao.searchProducts(keyword, "All");

        productListPanel.removeAll();
        productListPanel.setLayout(new java.awt.GridLayout(0, 4, 20, 20));

        for (Model.Product product : products) {
            ProductCard card = new ProductCard();
            card.setDashboard(this);
            card.setProduct(product);
            card.setPreferredSize(new java.awt.Dimension(150, 170));
            productListPanel.add(card);
        }

        productListPanel.revalidate();
        productListPanel.repaint();

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Search failed!");
    }
    }//GEN-LAST:event_SelectedItemActionPerformed

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
    private javax.swing.JButton ADD;
    private javax.swing.JButton Accountbtn;
    private javax.swing.JButton Allbtn;
    private javax.swing.JButton Allcategoriesbtn;
    private javax.swing.JButton AntiFungalbtn;
    private javax.swing.JButton Bmibtn;
    private javax.swing.JButton Calculatebtn;
    private javax.swing.JButton ConfirmCart;
    private javax.swing.JButton Contactpharmacybtn;
    private javax.swing.JButton Emergencycontactsbtn;
    private javax.swing.JTextField Height;
    private javax.swing.JMenuItem Logout;
    private javax.swing.JButton PainReliefbtn;
    private javax.swing.JPanel Pic;
    private javax.swing.JPanel ProductDescriptionPanel;
    private javax.swing.JMenuItem Profile;
    private javax.swing.JMenuItem RateUs;
    private javax.swing.JLabel Result;
    private javax.swing.JButton SUB;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField Searchbar;
    private javax.swing.JCheckBox SelectedItem;
    private javax.swing.JPanel Shippingdetails;
    private javax.swing.JButton ShoppingCart;
    private javax.swing.JPanel Shoppingcart;
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
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollBar jScrollBar1;
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
    public void updateSelectedTotals(java.math.BigDecimal selectedTotal) {
    jPanel5.removeAll();
    jPanel6.removeAll();

    jPanel5.add(new javax.swing.JLabel("Rs. " + selectedTotal.toPlainString()));
    jPanel6.add(new javax.swing.JLabel("Rs. " + selectedTotal.toPlainString()));

    jPanel5.revalidate();
    jPanel5.repaint();
    jPanel6.revalidate();
    jPanel6.repaint();

    lblitemprice.setText("Rs. " + selectedTotal.toPlainString());
    lbltotalprice.setText("Rs. " + selectedTotal.toPlainString());
}


public void renderCart(List<CartItem> items) {

    jPanel7.removeAll();
    jPanel7.setLayout(new BoxLayout(jPanel7, BoxLayout.Y_AXIS));
    int i = 1;
    for (CartItem item : items) {
        CartRowPanel row = new CartRowPanel(getCartController(), item, i);
         i++;
        row.setMaximumSize(new java.awt.Dimension(380, 80));
        jPanel7.add(row);
    }

    jPanel7.revalidate();
    jPanel7.repaint();

    BigDecimal selectedTotal = BigDecimal.ZERO;
    for (CartItem c : items) {
        if (c.isSelected()) {
            selectedTotal = selectedTotal.add(c.getLineTotal());
        }
    }

    jPanel5.removeAll();
    jPanel6.removeAll();

    jPanel5.add(new JLabel("Rs. " + selectedTotal.toPlainString()));
    jPanel6.add(new JLabel("Rs. " + selectedTotal.toPlainString()));

    jPanel5.revalidate();
    jPanel5.repaint();
    jPanel6.revalidate();
    jPanel6.repaint();

    lblitemprice.setText("Rs. " + selectedTotal.toPlainString());
    lbltotalprice.setText("Rs. " + selectedTotal.toPlainString());
}

    public void showConfirmMessage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

}