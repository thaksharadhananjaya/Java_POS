/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Code.DBconnect;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import javax.mail.Transport;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Session;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.DefaultListModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Thakshara Dhananjaya
 */
public class Home extends javax.swing.JFrame {

    int mouseX;
    int mouseY;

    // Var for conrol DB 
    Connection conn = null;
    PreparedStatement Pstatement = null;
    ResultSet resualt = null;

    String u_name = "";
    String cashier_id = "";
    String sqlInst;
    String netT = "";
    String sqlresualt;
    String ReturnNetTotal = "";
    String ReturnTotal = "";
    String ReturnBalance = "";
    int p, b, qty = 0;
    String BillID = null;
    String iid = "";
    float Total = 0;
    float NetDiscount = 0;
    float NetTotal = 0;
    Double bHeight = 0.0;
    Map<String, Integer> ReturnItemNames_Qty = new HashMap<String, Integer>();
    //Map<String, String> ReturnItemNames_Price = new HashMap<String, String>();

    //Creates new form Home
    public Home() {

        initComponents();

        //conect DB 
        conn = DBconnect.connect();

        this.setSize(1200, 700);
        //Frame open in center screen
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, (size.height / 2 - getHeight() / 2) - 15);

        Panelhide();
        jScrollPaneList.setVisible(false);
        PanelSideButton.setVisible(false);
        PanelLogout.setVisible(false);
        Logoutbtn.setVisible(false);
        PanelUserName.setVisible(false);
        admin_text.setVisible(false);

    }

    public Home(ArrayList<String> s) {
        initComponents();
        showdata(s);

        try {
            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/SW_Logo.png")));
        } catch (Exception e) {

        }

        //conect DB 
        conn = DBconnect.connect();

        this.setSize(1200, 700);
        //Frame open in center screen
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, (size.height / 2 - getHeight() / 2) - 15);

        Panelhide();
        jScrollPaneList.setVisible(false);
        PanelSideButton.setVisible(false);
        PanelLogout.setVisible(false);
        Logoutbtn.setVisible(false);
        PanelUserName.setVisible(false);
        admin_text.setVisible(false);
    }

    void showdata(ArrayList<String> a) {
        u_name = a.get(0);
        cashier_id = a.get(1);
        LabelUserName.setText(u_name);
        if ("ADMIN".equals(cashier_id)) {
            LabelUserName.setLocation(0, 0);
            admin_text.setText("(admin)");
            admin_only2.setVisible(false);
            admin_only4.setVisible(false);
            admin_only5.setVisible(false);
            admin_only7.setVisible(false);
            admin_only8.setVisible(false);
            admin_only9.setVisible(false);
            admin_only10.setVisible(false);
            admin_only11.setVisible(false);
            admin_only12.setVisible(false);
            admin_only13.setVisible(false);
            admin_only14.setVisible(false);
        } else {
            LabelUserName.setLocation(0, 6);
            admin_text.setText("");
            CashierButton.setEnabled(false);
            RadioButtonMonthly.setEnabled(false);
            SideButtonCashier.setEnabled(false);
            SideButtonSupplier.setEnabled(false);
            SupplierButton.setEnabled(false);
            OderButton.setEnabled(false);
            rpt_cashier.setEnabled(false);
            SideButtonSupplier.setEnabled(false);
            SideButtonOrder.setEnabled(false);
            RadioButtonToSupplier.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        developer = new javax.swing.JLabel();
        PanelLogout = new javax.swing.JPanel();
        Logoutbtn = new javax.swing.JLabel();
        PanelUserName = new javax.swing.JPanel();
        admin_text = new javax.swing.JLabel();
        LabelUserName = new javax.swing.JLabel();
        PanelHome = new javax.swing.JPanel();
        admin_only5 = new javax.swing.JLabel();
        admin_only4 = new javax.swing.JLabel();
        admin_only2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextAreaNotifications = new javax.swing.JTextArea();
        jLabel44 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Nclearbtn = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        rSButtonRiple1 = new rojeru_san.RSButtonRiple();
        rSButtonRiple2 = new rojeru_san.RSButtonRiple();
        OderButton = new rojeru_san.RSButtonRiple();
        rSButtonRiple4 = new rojeru_san.RSButtonRiple();
        SupplierButton = new rojeru_san.RSButtonRiple();
        CashierButton = new rojeru_san.RSButtonRiple();
        ReportButton = new rojeru_san.RSButtonRiple();
        ReturnButton = new rojeru_san.RSButtonRiple();
        PanelSideButton = new javax.swing.JPanel();
        admin_only10 = new javax.swing.JLabel();
        admin_only9 = new javax.swing.JLabel();
        admin_only8 = new javax.swing.JLabel();
        homePanel = new javax.swing.JPanel();
        homebtn = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        SideButtonBilling = new rojeru_san.RSButtonRiple();
        SideButtonItem = new rojeru_san.RSButtonRiple();
        SideButtonOrder = new rojeru_san.RSButtonRiple();
        SideButtonCustomer = new rojeru_san.RSButtonRiple();
        SideButtonSupplier = new rojeru_san.RSButtonRiple();
        SideButtonCashier = new rojeru_san.RSButtonRiple();
        SideButtonReport = new rojeru_san.RSButtonRiple();
        SideButtonReturn = new rojeru_san.RSButtonRiple();
        PanelTitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        close_btn = new javax.swing.JLabel();
        minimize_btn = new javax.swing.JLabel();
        notificationbtn = new javax.swing.JLabel();
        userbtn = new javax.swing.JLabel();
        Settings_Btn = new javax.swing.JLabel();
        PanelBilling = new javax.swing.JPanel();
        TextFieldBillingQuantity = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        LabelCashTxt = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ButtonPay = new javax.swing.JButton();
        ButtonAddToBill = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        TextFieldCash = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        TextFieldDiscountPerUnit = new javax.swing.JTextField();
        ComboBoxCustermer = new javax.swing.JComboBox();
        PanelNumOfItems = new javax.swing.JPanel();
        LabelItem = new javax.swing.JLabel();
        LabelItemTxt = new javax.swing.JLabel();
        PanelTotal = new javax.swing.JPanel();
        LabelTotalTxt = new javax.swing.JLabel();
        LabelTotal = new javax.swing.JLabel();
        PanelDiscount = new javax.swing.JPanel();
        LabelDiscount = new javax.swing.JLabel();
        LabelDiscountTxt = new javax.swing.JLabel();
        PanelNetTotal = new javax.swing.JPanel();
        LabelNetTotal = new javax.swing.JLabel();
        LabelNetTotalTxt = new javax.swing.JLabel();
        ButtonRemoveBill = new rojeru_san.RSButtonRiple();
        ButtonCancelItem = new rojeru_san.RSButtonRiple();
        LabelBillingBillID = new javax.swing.JLabel();
        jScrollPaneTabelBilling = new javax.swing.JScrollPane();
        TabelBilling = new rojerusan.RSTableMetro();
        PanelBalance = new javax.swing.JPanel();
        LabelBalanceDisplayBalance = new javax.swing.JLabel();
        LabelBalanceDisplayBalanceTxt = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        RadioButtonCash = new javax.swing.JRadioButton();
        RadioButtonCard = new javax.swing.JRadioButton();
        ComboBoxBillingItemID = new javax.swing.JTextField();
        jScrollPaneList = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel61 = new javax.swing.JLabel();
        PanelItem = new javax.swing.JPanel();
        ItemSearchTextField = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        ItemTable = new rojerusan.RSTableMetro();
        ItemEditBtn = new javax.swing.JButton();
        ItemDeleteBtn = new javax.swing.JButton();
        ItemGetSupplierBtn = new javax.swing.JButton();
        Item_delete_Button = new javax.swing.JButton();
        PanelItemInputComponents = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        item_ID = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        item_Name = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        addItembtnPanel = new javax.swing.JPanel();
        addItembtn = new javax.swing.JLabel();
        item_SupID = new javax.swing.JComboBox();
        BuyingPriceLabel = new javax.swing.JLabel();
        item_SPrice = new javax.swing.JTextField();
        item_AtQuantity = new javax.swing.JTextField();
        item_Quantity = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        SellingPriceLabel = new javax.swing.JLabel();
        item_BPrice = new javax.swing.JTextField();
        PanelOrder = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        Order_ItemID = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        OdrAddPanel = new javax.swing.JPanel();
        OdrAddbtn = new javax.swing.JLabel();
        OdrSearchTextField = new javax.swing.JTextField();
        OrderEditBtn = new javax.swing.JButton();
        OrderDeleteBtn = new javax.swing.JButton();
        OrderGetSupplierBtn = new javax.swing.JButton();
        OrderGetItemBtn = new javax.swing.JButton();
        Order_PaiedAmount = new javax.swing.JTextField();
        PaiedLabel = new javax.swing.JLabel();
        Order_Quantty = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        OrderTable = new rojerusan.RSTableMetro();
        PanelCustomer = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        Customer_ID = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        Customer_Name = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        Customer_Adds = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        Customer_Contact = new javax.swing.JTextField();
        CusAddPanel = new javax.swing.JPanel();
        CusAddBtn = new javax.swing.JLabel();
        CustomerSearchTextField = new javax.swing.JTextField();
        CustomerEditBtn = new javax.swing.JButton();
        CustomerDeleteBtn = new javax.swing.JButton();
        ButtonGetBill = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        CustomerTable = new rojerusan.RSTableMetro();
        PanelSupplier = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        Supplier_ID = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        Supplier_Name = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        Supplier_Adds = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        Supplier_Contact = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        Supplier_Discription = new javax.swing.JTextField();
        SupAddPanel = new javax.swing.JPanel();
        SupAddBtn = new javax.swing.JLabel();
        SupSearchTextField = new javax.swing.JTextField();
        SupplierEditBtn = new javax.swing.JButton();
        SupplierDeleteBtn = new javax.swing.JButton();
        SupGetItemsBtn = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        SupplierTable = new rojerusan.RSTableMetro();
        PanelCashier = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        Cashier_ID = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        Cashier_Name = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        Cashier_Adds = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        Cashier_Contact = new javax.swing.JTextField();
        CashierAddPanel = new javax.swing.JPanel();
        CashierAddButton = new javax.swing.JLabel();
        CasSearchTextField = new javax.swing.JTextField();
        CashierEditBtn = new javax.swing.JButton();
        CashierDeleteBtn = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        CashierTable = new rojerusan.RSTableMetro();
        PanelReport = new javax.swing.JPanel();
        admin_only7 = new javax.swing.JLabel();
        DailyRadioButton = new javax.swing.JRadioButton();
        RadioButtonMonthly = new javax.swing.JRadioButton();
        ShellRptBtn = new javax.swing.JButton();
        BillRptBtn = new javax.swing.JButton();
        BlReportPanel = new javax.swing.JPanel();
        BillSearchTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        AllRptRadioButton = new javax.swing.JRadioButton();
        BLCRptRadioButton = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        itm_slt_label = new javax.swing.JLabel();
        BLCRptRadioButton1 = new javax.swing.JRadioButton();
        ReturnCRptRadioButton = new javax.swing.JRadioButton();
        hstCheckBox = new javax.swing.JCheckBox();
        admin_only13 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        PurchaseBillTable = new rojerusan.RSTableMetro();
        jScrollPane2 = new javax.swing.JScrollPane();
        PurchaseItemTable = new rojerusan.RSTableMetro();
        rpt_getitem = new rojeru_san.RSButton();
        rpt_getcus = new rojeru_san.RSButton();
        rpt_cashier = new rojeru_san.RSButton();
        fullbillrtlabel = new javax.swing.JLabel();
        DailyReportPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        ReportNetTotalCardLabel = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ReportNetTotalCashlLabel = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        ReportTotaEarnlLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        LabelSellItems = new javax.swing.JLabel();
        LabelSellQTY = new javax.swing.JLabel();
        LabelSellQTY1 = new javax.swing.JLabel();
        LabelDayReportIcon = new javax.swing.JLabel();
        ButtonSendDayReport = new rojeru_san.RSButtonRiple();
        MonthlyReportPanel = new javax.swing.JPanel();
        MreportView = new javax.swing.JPanel();
        total_item_costLabel = new javax.swing.JLabel();
        TitleMonth_Label = new javax.swing.JLabel();
        Monthly_T_ernLabel = new javax.swing.JLabel();
        eLabel = new javax.swing.JLabel();
        wLabel = new javax.swing.JLabel();
        netp_label = new javax.swing.JLabel();
        oLabel = new javax.swing.JLabel();
        ProfitLabel = new javax.swing.JLabel();
        SelectMonth = new javax.swing.JRadioButton();
        ThisMonth = new javax.swing.JRadioButton();
        PreviousMonth = new javax.swing.JRadioButton();
        YearComboBox = new javax.swing.JComboBox();
        MonthComboBox = new javax.swing.JComboBox();
        Ebill_TextField = new javax.swing.JTextField();
        Wbill_TextField = new javax.swing.JTextField();
        Othercost_TextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        PanelReturn = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        LabeItemSelected = new javax.swing.JLabel();
        TextFieldReturnQTY = new javax.swing.JTextField();
        RadioButtonReSelling = new javax.swing.JRadioButton();
        RadioButtonToSupplier = new javax.swing.JRadioButton();
        ButtonReturnBill = new javax.swing.JButton();
        LabelReturnBillTxt = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        TextFieldReturnItemSearch = new javax.swing.JTextField();
        TextFieldReturnBillSearch = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        ButtonAddReturnQTY = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        ReturnBillTable = new rojerusan.RSTableMetro();
        jScrollPane11 = new javax.swing.JScrollPane();
        ReturnItemTable = new rojerusan.RSTableMetro();
        ButtonReturnQTY = new javax.swing.JButton();
        ButtonReturnReset = new javax.swing.JButton();
        ButtonReturnToSuppliers = new rojeru_san.RSButtonRiple();
        admin_only14 = new javax.swing.JLabel();
        PanelSettings = new javax.swing.JPanel();
        admin_only11 = new javax.swing.JLabel();
        admin_only12 = new javax.swing.JLabel();
        Database = new javax.swing.JPanel();
        Backup_btn = new rojeru_san.RSButton();
        Restore_btn = new rojeru_san.RSButton();
        about = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        user_act = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        RadioButton_Admin = new javax.swing.JRadioButton();
        RadioButton_Cashier = new javax.swing.JRadioButton();
        Label_CashierUserAcct = new javax.swing.JLabel();
        ComboBox_Cashieruserselect = new javax.swing.JComboBox();
        jLabel65 = new javax.swing.JLabel();
        userNameTextField = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        UserAcct_Button = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        RT_PasswordTextField = new javax.swing.JPasswordField();
        jLabel68 = new javax.swing.JLabel();
        ComboBox_UserNameselect = new javax.swing.JComboBox();
        PasswordTextField = new javax.swing.JPasswordField();
        jPasswordField4 = new javax.swing.JPasswordField();
        jPasswordField5 = new javax.swing.JPasswordField();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel72 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        sideBar = new javax.swing.JPanel();
        userAcct_btn = new rojeru_san.RSButtonRiple();
        database_btn = new rojeru_san.RSButtonRiple();
        about_btn = new rojeru_san.RSButtonRiple();
        jButton9 = new rojeru_san.RSButtonRiple();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(29, 29, 29));
        setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        setUndecorated(true);
        setSize(new java.awt.Dimension(1200, 700));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        developer.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        developer.setForeground(new java.awt.Color(255, 255, 255));
        developer.setText("Develop by Thakshara Dhananjaya");
        developer.setToolTipText("Contact: 077 659 1828");
        developer.setFocusable(false);
        getContentPane().add(developer);
        developer.setBounds(1000, 678, 190, 20);

        PanelLogout.setBackground(new java.awt.Color(0, 153, 153));
        PanelLogout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        PanelLogout.setFocusable(false);
        PanelLogout.setLayout(null);

        Logoutbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Logoutbtn.setForeground(new java.awt.Color(255, 255, 255));
        Logoutbtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Logoutbtn.setText("Sign Out");
        Logoutbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutbtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LogoutbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LogoutbtnMouseExited(evt);
            }
        });
        PanelLogout.add(Logoutbtn);
        Logoutbtn.setBounds(0, 0, 100, 23);

        getContentPane().add(PanelLogout);
        PanelLogout.setBounds(1080, 118, 100, 23);

        PanelUserName.setBackground(new java.awt.Color(0, 153, 102));
        PanelUserName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        PanelUserName.setFocusable(false);
        PanelUserName.setLayout(null);

        admin_text.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        admin_text.setForeground(new java.awt.Color(255, 255, 255));
        admin_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_text.setText("(admin)");
        admin_text.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_textMouseClicked(evt);
            }
        });
        PanelUserName.add(admin_text);
        admin_text.setBounds(0, 17, 100, 16);

        LabelUserName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelUserName.setForeground(new java.awt.Color(255, 255, 255));
        LabelUserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelUserName.setText("admin");
        PanelUserName.add(LabelUserName);
        LabelUserName.setBounds(0, 0, 100, 23);

        getContentPane().add(PanelUserName);
        PanelUserName.setBounds(1080, 82, 100, 36);

        PanelHome.setBackground(new java.awt.Color(29, 29, 29));
        PanelHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelHomeMouseClicked(evt);
            }
        });
        PanelHome.setLayout(null);

        admin_only5.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        admin_only5.setForeground(new java.awt.Color(51, 51, 51));
        admin_only5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Admin_lock.png"))); // NOI18N
        admin_only5.setToolTipText("Admin Only");
        PanelHome.add(admin_only5);
        admin_only5.setBounds(590, 209, 30, 30);

        admin_only4.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        admin_only4.setForeground(new java.awt.Color(51, 51, 51));
        admin_only4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Admin_lock.png"))); // NOI18N
        admin_only4.setToolTipText("Admin Only");
        PanelHome.add(admin_only4);
        admin_only4.setBounds(170, 399, 30, 30);

        admin_only2.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        admin_only2.setForeground(new java.awt.Color(51, 51, 51));
        admin_only2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Admin_lock.png"))); // NOI18N
        admin_only2.setToolTipText("Admin Only");
        PanelHome.add(admin_only2);
        admin_only2.setBounds(380, 399, 30, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Report");
        PanelHome.add(jLabel6);
        jLabel6.setBounds(480, 385, 140, 30);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setFocusable(false);
        jScrollPane1.setRequestFocusEnabled(false);

        TextAreaNotifications.setEditable(false);
        TextAreaNotifications.setBackground(new java.awt.Color(102, 102, 102));
        TextAreaNotifications.setColumns(12);
        TextAreaNotifications.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        TextAreaNotifications.setForeground(new java.awt.Color(255, 255, 255));
        TextAreaNotifications.setRows(5);
        TextAreaNotifications.setText("No new notifications");
        jScrollPane1.setViewportView(TextAreaNotifications);

        PanelHome.add(jScrollPane1);
        jScrollPane1.setBounds(910, 70, 240, 429);

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Order");
        PanelHome.add(jLabel44);
        jLabel44.setBounds(480, 195, 140, 30);

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Customer");
        PanelHome.add(jLabel39);
        jLabel39.setBounds(700, 195, 140, 30);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Cashier");
        PanelHome.add(jLabel24);
        jLabel24.setBounds(270, 385, 140, 30);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Item");
        PanelHome.add(jLabel17);
        jLabel17.setBounds(270, 195, 140, 30);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Supplier");
        PanelHome.add(jLabel16);
        jLabel16.setBounds(60, 385, 140, 30);

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 204, 255));
        jLabel5.setText("Notifications");
        PanelHome.add(jLabel5);
        jLabel5.setBounds(960, 40, 140, 26);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Billing");
        PanelHome.add(jLabel12);
        jLabel12.setBounds(60, 195, 140, 30);

        Nclearbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Nclearbtn-default.png"))); // NOI18N
        Nclearbtn.setToolTipText("Clear all notifications");
        Nclearbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NclearbtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NclearbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NclearbtnMouseExited(evt);
            }
        });
        PanelHome.add(Nclearbtn);
        Nclearbtn.setBounds(1020, 500, 30, 38);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Return");
        PanelHome.add(jLabel15);
        jLabel15.setBounds(700, 385, 140, 30);

        rSButtonRiple1.setBackground(new java.awt.Color(45, 137, 239));
        rSButtonRiple1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        rSButtonRiple1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Items.png"))); // NOI18N
        rSButtonRiple1.setColorHover(new java.awt.Color(153, 204, 255));
        rSButtonRiple1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rSButtonRiple1.setFocusable(false);
        rSButtonRiple1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonRiple1ActionPerformed(evt);
            }
        });
        PanelHome.add(rSButtonRiple1);
        rSButtonRiple1.setBounds(270, 100, 140, 140);

        rSButtonRiple2.setBackground(new java.awt.Color(45, 137, 239));
        rSButtonRiple2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        rSButtonRiple2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Billing.png"))); // NOI18N
        rSButtonRiple2.setColorHover(new java.awt.Color(153, 204, 255));
        rSButtonRiple2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rSButtonRiple2.setFocusable(false);
        rSButtonRiple2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonRiple2ActionPerformed(evt);
            }
        });
        PanelHome.add(rSButtonRiple2);
        rSButtonRiple2.setBounds(60, 100, 140, 140);

        OderButton.setBackground(new java.awt.Color(45, 137, 239));
        OderButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        OderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Order.png"))); // NOI18N
        OderButton.setColorHover(new java.awt.Color(153, 204, 255));
        OderButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        OderButton.setFocusable(false);
        OderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OderButtonActionPerformed(evt);
            }
        });
        PanelHome.add(OderButton);
        OderButton.setBounds(480, 100, 140, 140);

        rSButtonRiple4.setBackground(new java.awt.Color(45, 137, 239));
        rSButtonRiple4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        rSButtonRiple4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Customer.png"))); // NOI18N
        rSButtonRiple4.setColorHover(new java.awt.Color(153, 204, 255));
        rSButtonRiple4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rSButtonRiple4.setFocusable(false);
        rSButtonRiple4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonRiple4ActionPerformed(evt);
            }
        });
        PanelHome.add(rSButtonRiple4);
        rSButtonRiple4.setBounds(700, 100, 140, 140);

        SupplierButton.setBackground(new java.awt.Color(45, 137, 239));
        SupplierButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        SupplierButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Suppliers.png"))); // NOI18N
        SupplierButton.setColorHover(new java.awt.Color(153, 204, 255));
        SupplierButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SupplierButton.setFocusable(false);
        SupplierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupplierButtonActionPerformed(evt);
            }
        });
        PanelHome.add(SupplierButton);
        SupplierButton.setBounds(60, 290, 140, 140);

        CashierButton.setBackground(new java.awt.Color(45, 137, 239));
        CashierButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        CashierButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cashier.png"))); // NOI18N
        CashierButton.setColorHover(new java.awt.Color(153, 204, 255));
        CashierButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CashierButton.setFocusable(false);
        CashierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CashierButtonActionPerformed(evt);
            }
        });
        PanelHome.add(CashierButton);
        CashierButton.setBounds(270, 290, 140, 140);

        ReportButton.setBackground(new java.awt.Color(45, 137, 239));
        ReportButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        ReportButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Report.png"))); // NOI18N
        ReportButton.setColorHover(new java.awt.Color(153, 204, 255));
        ReportButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ReportButton.setFocusable(false);
        ReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportButtonActionPerformed(evt);
            }
        });
        PanelHome.add(ReportButton);
        ReportButton.setBounds(480, 290, 140, 140);

        ReturnButton.setBackground(new java.awt.Color(45, 137, 239));
        ReturnButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        ReturnButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Return.png"))); // NOI18N
        ReturnButton.setColorHover(new java.awt.Color(153, 204, 255));
        ReturnButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ReturnButton.setFocusable(false);
        ReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButtonActionPerformed(evt);
            }
        });
        PanelHome.add(ReturnButton);
        ReturnButton.setBounds(700, 290, 140, 140);

        getContentPane().add(PanelHome);
        PanelHome.setBounds(0, 90, 1250, 700);

        PanelSideButton.setBackground(new java.awt.Color(51, 51, 255));
        PanelSideButton.setEnabled(false);
        PanelSideButton.setLayout(null);

        admin_only10.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        admin_only10.setForeground(new java.awt.Color(51, 51, 51));
        admin_only10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Admin_lock_mini.png"))); // NOI18N
        admin_only10.setToolTipText("Admin Only");
        PanelSideButton.add(admin_only10);
        admin_only10.setBounds(147, 420, 25, 25);

        admin_only9.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        admin_only9.setForeground(new java.awt.Color(51, 51, 51));
        admin_only9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Admin_lock_mini.png"))); // NOI18N
        admin_only9.setToolTipText("Admin Only");
        PanelSideButton.add(admin_only9);
        admin_only9.setBounds(147, 355, 25, 25);

        admin_only8.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        admin_only8.setForeground(new java.awt.Color(51, 51, 51));
        admin_only8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Admin_lock_mini.png"))); // NOI18N
        admin_only8.setToolTipText("Admin Only");
        PanelSideButton.add(admin_only8);
        admin_only8.setBounds(147, 225, 25, 25);

        homePanel.setBackground(new java.awt.Color(102, 0, 102));
        homePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homePanelMouseEntered(evt);
            }
        });
        homePanel.setLayout(null);

        homebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/HomePanel.png"))); // NOI18N
        homebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homebtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homebtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homebtnMouseExited(evt);
            }
        });
        homePanel.add(homebtn);
        homebtn.setBounds(0, 4, 175, 70);

        PanelSideButton.add(homePanel);
        homePanel.setBounds(0, 0, 175, 75);
        homePanel.getAccessibleContext().setAccessibleParent(PanelSideButton);

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SupplierPanel.png"))); // NOI18N
        PanelSideButton.add(jLabel45);
        jLabel45.setBounds(0, 335, 60, 65);

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CashierPanel.png"))); // NOI18N
        PanelSideButton.add(jLabel46);
        jLabel46.setBounds(0, 400, 60, 65);

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ReportPanel.png"))); // NOI18N
        PanelSideButton.add(jLabel47);
        jLabel47.setBounds(0, 465, 60, 65);

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CustomerPanel.png"))); // NOI18N
        PanelSideButton.add(jLabel48);
        jLabel48.setBounds(0, 270, 60, 65);

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OrderPanel.png"))); // NOI18N
        PanelSideButton.add(jLabel49);
        jLabel49.setBounds(0, 205, 60, 65);

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ItemsPanel.png"))); // NOI18N
        PanelSideButton.add(jLabel50);
        jLabel50.setBounds(0, 140, 60, 65);

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BillingPanel.png"))); // NOI18N
        PanelSideButton.add(jLabel52);
        jLabel52.setBounds(0, 75, 60, 65);

        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ReturnPanel.png"))); // NOI18N
        PanelSideButton.add(jLabel53);
        jLabel53.setBounds(0, 530, 60, 65);

        SideButtonBilling.setBorder(null);
        SideButtonBilling.setText("             Billing");
        SideButtonBilling.setFocusable(false);
        SideButtonBilling.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        SideButtonBilling.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SideButtonBilling.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        SideButtonBilling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SideButtonBillingActionPerformed(evt);
            }
        });
        PanelSideButton.add(SideButtonBilling);
        SideButtonBilling.setBounds(0, 75, 175, 65);

        SideButtonItem.setBackground(new java.awt.Color(51, 51, 255));
        SideButtonItem.setBorder(null);
        SideButtonItem.setText("             Item");
        SideButtonItem.setFocusable(false);
        SideButtonItem.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        SideButtonItem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SideButtonItem.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        SideButtonItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SideButtonItemActionPerformed(evt);
            }
        });
        PanelSideButton.add(SideButtonItem);
        SideButtonItem.setBounds(0, 140, 175, 65);

        SideButtonOrder.setBackground(new java.awt.Color(51, 51, 255));
        SideButtonOrder.setBorder(null);
        SideButtonOrder.setText("             Order");
        SideButtonOrder.setFocusable(false);
        SideButtonOrder.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        SideButtonOrder.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SideButtonOrder.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        SideButtonOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SideButtonOrderActionPerformed(evt);
            }
        });
        PanelSideButton.add(SideButtonOrder);
        SideButtonOrder.setBounds(0, 205, 175, 65);

        SideButtonCustomer.setBackground(new java.awt.Color(51, 51, 255));
        SideButtonCustomer.setBorder(null);
        SideButtonCustomer.setText("             Customer");
        SideButtonCustomer.setFocusable(false);
        SideButtonCustomer.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        SideButtonCustomer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SideButtonCustomer.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        SideButtonCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SideButtonCustomerActionPerformed(evt);
            }
        });
        PanelSideButton.add(SideButtonCustomer);
        SideButtonCustomer.setBounds(0, 270, 175, 65);

        SideButtonSupplier.setBackground(new java.awt.Color(51, 51, 255));
        SideButtonSupplier.setBorder(null);
        SideButtonSupplier.setText("             Supplier");
        SideButtonSupplier.setFocusable(false);
        SideButtonSupplier.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        SideButtonSupplier.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SideButtonSupplier.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        SideButtonSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SideButtonSupplierActionPerformed(evt);
            }
        });
        PanelSideButton.add(SideButtonSupplier);
        SideButtonSupplier.setBounds(0, 335, 175, 65);

        SideButtonCashier.setBackground(new java.awt.Color(51, 51, 255));
        SideButtonCashier.setBorder(null);
        SideButtonCashier.setText("             Cashier");
        SideButtonCashier.setFocusable(false);
        SideButtonCashier.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        SideButtonCashier.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SideButtonCashier.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        SideButtonCashier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SideButtonCashierActionPerformed(evt);
            }
        });
        PanelSideButton.add(SideButtonCashier);
        SideButtonCashier.setBounds(0, 400, 175, 65);

        SideButtonReport.setBackground(new java.awt.Color(51, 51, 255));
        SideButtonReport.setBorder(null);
        SideButtonReport.setText("             Report");
        SideButtonReport.setFocusable(false);
        SideButtonReport.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        SideButtonReport.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SideButtonReport.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        SideButtonReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SideButtonReportActionPerformed(evt);
            }
        });
        PanelSideButton.add(SideButtonReport);
        SideButtonReport.setBounds(0, 465, 175, 65);

        SideButtonReturn.setBackground(new java.awt.Color(51, 51, 255));
        SideButtonReturn.setBorder(null);
        SideButtonReturn.setText("             Return");
        SideButtonReturn.setFocusable(false);
        SideButtonReturn.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        SideButtonReturn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SideButtonReturn.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        SideButtonReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SideButtonReturnActionPerformed(evt);
            }
        });
        PanelSideButton.add(SideButtonReturn);
        SideButtonReturn.setBounds(0, 530, 175, 65);

        getContentPane().add(PanelSideButton);
        PanelSideButton.setBounds(0, 91, 175, 1110);

        PanelTitle.setBackground(new java.awt.Color(45, 137, 239));
        PanelTitle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PanelTitleMouseDragged(evt);
            }
        });
        PanelTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelTitleMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelTitleMousePressed(evt);
            }
        });
        PanelTitle.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 42)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 153));
        jLabel1.setText("AANYA FASHION STORE");
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        PanelTitle.add(jLabel1);
        jLabel1.setBounds(340, 18, 490, 57);

        close_btn.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 16)); // NOI18N
        close_btn.setForeground(new java.awt.Color(102, 102, 102));
        close_btn.setText("X");
        close_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        close_btn.setPreferredSize(new java.awt.Dimension(15, 15));
        close_btn.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                close_btnMouseMoved(evt);
            }
        });
        close_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close_btnMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                close_btnMouseExited(evt);
            }
        });
        PanelTitle.add(close_btn);
        close_btn.setBounds(1180, 0, 15, 20);
        close_btn.getAccessibleContext().setAccessibleName(" X");

        minimize_btn.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        minimize_btn.setForeground(new java.awt.Color(102, 102, 102));
        minimize_btn.setText("─");
        minimize_btn.setPreferredSize(new java.awt.Dimension(15, 15));
        minimize_btn.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                minimize_btnMouseMoved(evt);
            }
        });
        minimize_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimize_btnMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimize_btnMouseExited(evt);
            }
        });
        PanelTitle.add(minimize_btn);
        minimize_btn.setBounds(1160, 0, 14, 20);

        notificationbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notification.png"))); // NOI18N
        notificationbtn.setToolTipText("Notifications");
        notificationbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notificationbtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                notificationbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                notificationbtnMouseExited(evt);
            }
        });
        PanelTitle.add(notificationbtn);
        notificationbtn.setBounds(1010, 40, 40, 40);

        userbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/userN.png"))); // NOI18N
        userbtn.setToolTipText("User");
        userbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userbtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userbtnMouseExited(evt);
            }
        });
        PanelTitle.add(userbtn);
        userbtn.setBounds(1110, 40, 40, 38);

        Settings_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Settings_ExitMouse.png"))); // NOI18N
        Settings_Btn.setToolTipText("Settings");
        Settings_Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Settings_BtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Settings_BtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Settings_BtnMouseExited(evt);
            }
        });
        PanelTitle.add(Settings_Btn);
        Settings_Btn.setBounds(1058, 40, 40, 40);

        getContentPane().add(PanelTitle);
        PanelTitle.setBounds(0, 0, 1200, 90);

        PanelBilling.setBackground(new java.awt.Color(29, 29, 29));
        PanelBilling.setAlignmentX(0.0F);
        PanelBilling.setPreferredSize(new java.awt.Dimension(1200, 700));
        PanelBilling.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelBillingMouseClicked(evt);
            }
        });
        PanelBilling.setLayout(null);

        TextFieldBillingQuantity.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TextFieldBillingQuantity.setText("1");
        TextFieldBillingQuantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TextFieldBillingQuantity.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        TextFieldBillingQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TextFieldBillingQuantityKeyPressed(evt);
            }
        });
        PanelBilling.add(TextFieldBillingQuantity);
        TextFieldBillingQuantity.setBounds(500, 550, 200, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Customer ID (Optional) ");
        PanelBilling.add(jLabel4);
        jLabel4.setBounds(760, 590, 158, 20);

        LabelCashTxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelCashTxt.setForeground(new java.awt.Color(255, 255, 255));
        LabelCashTxt.setText("Cash (Rs.)");
        PanelBilling.add(LabelCashTxt);
        LabelCashTxt.setBounds(500, 590, 80, 20);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Item ID");
        PanelBilling.add(jLabel10);
        jLabel10.setBounds(240, 530, 48, 20);

        ButtonPay.setBackground(new java.awt.Color(0, 102, 204));
        ButtonPay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ButtonPay.setForeground(new java.awt.Color(255, 255, 255));
        ButtonPay.setText("Pay");
        ButtonPay.setBorder(null);
        ButtonPay.setFocusable(false);
        ButtonPay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonPayMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonPayMouseExited(evt);
            }
        });
        ButtonPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPayActionPerformed(evt);
            }
        });
        PanelBilling.add(ButtonPay);
        ButtonPay.setBounds(340, 660, 80, 30);

        ButtonAddToBill.setBackground(new java.awt.Color(7, 182, 48));
        ButtonAddToBill.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ButtonAddToBill.setForeground(new java.awt.Color(255, 255, 255));
        ButtonAddToBill.setText("Add to Bill");
        ButtonAddToBill.setBorder(null);
        ButtonAddToBill.setFocusable(false);
        ButtonAddToBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonAddToBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonAddToBillMouseExited(evt);
            }
        });
        ButtonAddToBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddToBillActionPerformed(evt);
            }
        });
        PanelBilling.add(ButtonAddToBill);
        ButtonAddToBill.setBounds(240, 660, 80, 30);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Quantity");
        PanelBilling.add(jLabel21);
        jLabel21.setBounds(500, 530, 60, 20);

        TextFieldCash.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TextFieldCash.setToolTipText("");
        TextFieldCash.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TextFieldCash.setEnabled(false);
        TextFieldCash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TextFieldCashMouseClicked(evt);
            }
        });
        TextFieldCash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TextFieldCashKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextFieldCashKeyReleased(evt);
            }
        });
        PanelBilling.add(TextFieldCash);
        TextFieldCash.setBounds(500, 610, 200, 30);

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Discount Per Unit (Rs.)");
        PanelBilling.add(jLabel31);
        jLabel31.setBounds(760, 530, 160, 20);

        TextFieldDiscountPerUnit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TextFieldDiscountPerUnit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TextFieldDiscountPerUnit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TextFieldDiscountPerUnitMouseClicked(evt);
            }
        });
        TextFieldDiscountPerUnit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TextFieldDiscountPerUnitKeyPressed(evt);
            }
        });
        PanelBilling.add(TextFieldDiscountPerUnit);
        TextFieldDiscountPerUnit.setBounds(760, 550, 200, 30);

        ComboBoxCustermer.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ComboBoxCustermer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        ComboBoxCustermer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelBilling.add(ComboBoxCustermer);
        ComboBoxCustermer.setBounds(760, 610, 200, 30);

        PanelNumOfItems.setBackground(new java.awt.Color(0, 112, 192));
        PanelNumOfItems.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        PanelNumOfItems.setLayout(null);

        LabelItem.setBackground(new java.awt.Color(255, 255, 255));
        LabelItem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelItem.setForeground(new java.awt.Color(255, 255, 255));
        LabelItem.setText("0");
        PanelNumOfItems.add(LabelItem);
        LabelItem.setBounds(10, 35, 160, 30);

        LabelItemTxt.setBackground(new java.awt.Color(255, 255, 255));
        LabelItemTxt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelItemTxt.setForeground(new java.awt.Color(255, 255, 255));
        LabelItemTxt.setText("Item");
        PanelNumOfItems.add(LabelItemTxt);
        LabelItemTxt.setBounds(10, 5, 120, 30);

        PanelBilling.add(PanelNumOfItems);
        PanelNumOfItems.setBounds(240, 390, 182, 80);

        PanelTotal.setBackground(new java.awt.Color(0, 112, 192));
        PanelTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        PanelTotal.setLayout(null);

        LabelTotalTxt.setBackground(new java.awt.Color(255, 255, 255));
        LabelTotalTxt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelTotalTxt.setForeground(new java.awt.Color(255, 255, 255));
        LabelTotalTxt.setText("Total");
        PanelTotal.add(LabelTotalTxt);
        LabelTotalTxt.setBounds(10, 5, 110, 30);

        LabelTotal.setBackground(new java.awt.Color(255, 255, 255));
        LabelTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelTotal.setForeground(new java.awt.Color(255, 255, 255));
        LabelTotal.setText("Rs. 0.00");
        PanelTotal.add(LabelTotal);
        LabelTotal.setBounds(10, 35, 170, 30);

        PanelBilling.add(PanelTotal);
        PanelTotal.setBounds(420, 390, 182, 80);

        PanelDiscount.setBackground(new java.awt.Color(0, 112, 192));
        PanelDiscount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        PanelDiscount.setLayout(null);

        LabelDiscount.setBackground(new java.awt.Color(255, 255, 255));
        LabelDiscount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelDiscount.setForeground(new java.awt.Color(255, 255, 255));
        LabelDiscount.setText("Rs. 0.00");
        PanelDiscount.add(LabelDiscount);
        LabelDiscount.setBounds(10, 35, 170, 30);

        LabelDiscountTxt.setBackground(new java.awt.Color(255, 255, 255));
        LabelDiscountTxt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelDiscountTxt.setForeground(new java.awt.Color(255, 255, 255));
        LabelDiscountTxt.setText("Discount");
        PanelDiscount.add(LabelDiscountTxt);
        LabelDiscountTxt.setBounds(10, 5, 120, 30);

        PanelBilling.add(PanelDiscount);
        PanelDiscount.setBounds(600, 390, 182, 80);

        PanelNetTotal.setBackground(new java.awt.Color(0, 112, 192));
        PanelNetTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        PanelNetTotal.setLayout(null);

        LabelNetTotal.setBackground(new java.awt.Color(0, 102, 255));
        LabelNetTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelNetTotal.setForeground(new java.awt.Color(255, 255, 255));
        LabelNetTotal.setText("Rs. 0.00");
        PanelNetTotal.add(LabelNetTotal);
        LabelNetTotal.setBounds(10, 35, 170, 30);

        LabelNetTotalTxt.setBackground(new java.awt.Color(255, 255, 255));
        LabelNetTotalTxt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelNetTotalTxt.setForeground(new java.awt.Color(255, 255, 255));
        LabelNetTotalTxt.setText("Net Total");
        PanelNetTotal.add(LabelNetTotalTxt);
        LabelNetTotalTxt.setBounds(10, 5, 120, 30);

        PanelBilling.add(PanelNetTotal);
        PanelNetTotal.setBounds(780, 390, 182, 80);

        ButtonRemoveBill.setBackground(new java.awt.Color(255, 51, 0));
        ButtonRemoveBill.setBorder(null);
        ButtonRemoveBill.setText("Remove");
        ButtonRemoveBill.setColorHover(new java.awt.Color(255, 153, 51));
        ButtonRemoveBill.setEnabled(false);
        ButtonRemoveBill.setFocusable(false);
        ButtonRemoveBill.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        ButtonRemoveBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRemoveBillActionPerformed(evt);
            }
        });
        PanelBilling.add(ButtonRemoveBill);
        ButtonRemoveBill.setBounds(570, 480, 90, 26);

        ButtonCancelItem.setBackground(new java.awt.Color(255, 0, 0));
        ButtonCancelItem.setBorder(null);
        ButtonCancelItem.setText("Cancel Bill");
        ButtonCancelItem.setColorHover(new java.awt.Color(255, 102, 102));
        ButtonCancelItem.setEnabled(false);
        ButtonCancelItem.setFocusable(false);
        ButtonCancelItem.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        ButtonCancelItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelItemActionPerformed(evt);
            }
        });
        PanelBilling.add(ButtonCancelItem);
        ButtonCancelItem.setBounds(710, 480, 90, 26);

        LabelBillingBillID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelBillingBillID.setForeground(new java.awt.Color(255, 255, 255));
        LabelBillingBillID.setText("Bill ID: ");
        PanelBilling.add(LabelBillingBillID);
        LabelBillingBillID.setBounds(241, 100, 280, 20);

        jScrollPaneTabelBilling.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPaneTabelBilling.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TabelBilling.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Price (Rs.)", "Quantity", "Total (Rs.)", "Discount (Rs.)", "Net Total (Rs.)"
            }

        )
    );
    TabelBilling.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
    TabelBilling.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
    TabelBilling.setFocusable(false);
    TabelBilling.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    TabelBilling.setFuenteFilas(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    TabelBilling.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    TabelBilling.setFuenteHead(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    TabelBilling.setMultipleSeleccion(false);
    TabelBilling.setRowHeight(24);
    TabelBilling.setSelectionBackground(new java.awt.Color(0, 153, 255));
    TabelBilling.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            TabelBillingMouseClicked(evt);
        }
    });
    jScrollPaneTabelBilling.setViewportView(TabelBilling);

    PanelBilling.add(jScrollPaneTabelBilling);
    jScrollPaneTabelBilling.setBounds(240, 120, 901, 270);

    PanelBalance.setBackground(new java.awt.Color(0, 112, 192));
    PanelBalance.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
    PanelBalance.setLayout(null);

    LabelBalanceDisplayBalance.setBackground(new java.awt.Color(255, 255, 255));
    LabelBalanceDisplayBalance.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    LabelBalanceDisplayBalance.setForeground(new java.awt.Color(255, 255, 255));
    LabelBalanceDisplayBalance.setText("Rs. 0.00");
    PanelBalance.add(LabelBalanceDisplayBalance);
    LabelBalanceDisplayBalance.setBounds(10, 35, 280, 30);

    LabelBalanceDisplayBalanceTxt.setBackground(new java.awt.Color(255, 255, 255));
    LabelBalanceDisplayBalanceTxt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    LabelBalanceDisplayBalanceTxt.setForeground(new java.awt.Color(255, 255, 255));
    LabelBalanceDisplayBalanceTxt.setText("Balance");
    PanelBalance.add(LabelBalanceDisplayBalanceTxt);
    LabelBalanceDisplayBalanceTxt.setBounds(10, 5, 120, 30);

    PanelBilling.add(PanelBalance);
    PanelBalance.setBounds(960, 390, 182, 80);

    jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(255, 255, 255));
    jLabel9.setText("Payment Method");
    PanelBilling.add(jLabel9);
    jLabel9.setBounds(240, 590, 130, 20);

    RadioButtonCash.setBackground(new java.awt.Color(29, 29, 29));
    RadioButtonCash.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    RadioButtonCash.setForeground(new java.awt.Color(255, 255, 255));
    RadioButtonCash.setSelected(true);
    RadioButtonCash.setText("Cash");
    RadioButtonCash.setBorder(null);
    RadioButtonCash.setFocusable(false);
    RadioButtonCash.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            RadioButtonCashActionPerformed(evt);
        }
    });
    PanelBilling.add(RadioButtonCash);
    RadioButtonCash.setBounds(240, 620, 50, 15);

    RadioButtonCard.setBackground(new java.awt.Color(29, 29, 29));
    RadioButtonCard.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    RadioButtonCard.setForeground(new java.awt.Color(255, 255, 255));
    RadioButtonCard.setText("Card/ Cash On Delivery");
    RadioButtonCard.setBorder(null);
    RadioButtonCard.setFocusable(false);
    RadioButtonCard.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            RadioButtonCardActionPerformed(evt);
        }
    });
    PanelBilling.add(RadioButtonCard);
    RadioButtonCard.setBounds(300, 620, 140, 15);

    ComboBoxBillingItemID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    ComboBoxBillingItemID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    ComboBoxBillingItemID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    ComboBoxBillingItemID.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusLost(java.awt.event.FocusEvent evt) {
            ComboBoxBillingItemIDFocusLost(evt);
        }
    });
    ComboBoxBillingItemID.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            ComboBoxBillingItemIDKeyPressed(evt);
        }
        public void keyReleased(java.awt.event.KeyEvent evt) {
            ComboBoxBillingItemIDKeyReleased(evt);
        }
    });
    PanelBilling.add(ComboBoxBillingItemID);
    ComboBoxBillingItemID.setBounds(240, 550, 180, 30);

    jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
        public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
            jList1ValueChanged(evt);
        }
    });
    jScrollPaneList.setViewportView(jList1);

    PanelBilling.add(jScrollPaneList);
    jScrollPaneList.setBounds(241, 470, 198, 80);

    jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icocombo.png"))); // NOI18N
    jLabel61.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel61MouseClicked(evt);
        }
    });
    PanelBilling.add(jLabel61);
    jLabel61.setBounds(420, 551, 20, 30);

    getContentPane().add(PanelBilling);
    PanelBilling.setBounds(0, 0, 1250, 700);

    PanelItem.setBackground(new java.awt.Color(29, 29, 29));
    PanelItem.setPreferredSize(new java.awt.Dimension(1250, 610));
    PanelItem.setLayout(null);

    ItemSearchTextField.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
    ItemSearchTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    ItemSearchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            ItemSearchTextFieldKeyReleased(evt);
        }
    });
    PanelItem.add(ItemSearchTextField);
    ItemSearchTextField.setBounds(610, 150, 390, 28);

    jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel59.setForeground(new java.awt.Color(255, 255, 255));
    jLabel59.setText("Search:");
    PanelItem.add(jLabel59);
    jLabel59.setBounds(550, 150, 50, 25);

    jScrollPane9.setBorder(null);

    ItemTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Item ID", "Item Name", "Quantity", "Price (Rs.)", "Alert Quantity"
        }
    ));
    ItemTable.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
    ItemTable.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
    ItemTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    ItemTable.setFuenteFilas(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    ItemTable.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    ItemTable.setFuenteHead(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
    ItemTable.setMultipleSeleccion(false);
    ItemTable.setRowHeight(24);
    ItemTable.setSelectionBackground(new java.awt.Color(0, 153, 255));
    ItemTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            ItemTableMouseClicked(evt);
        }
    });
    jScrollPane9.setViewportView(ItemTable);

    PanelItem.add(jScrollPane9);
    jScrollPane9.setBounds(420, 190, 740, 423);

    ItemEditBtn.setBackground(new java.awt.Color(0, 112, 192));
    ItemEditBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    ItemEditBtn.setForeground(new java.awt.Color(255, 255, 255));
    ItemEditBtn.setText("Edit");
    ItemEditBtn.setFocusable(false);
    ItemEditBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ItemEditBtnActionPerformed(evt);
        }
    });
    PanelItem.add(ItemEditBtn);
    ItemEditBtn.setBounds(520, 620, 110, 28);

    ItemDeleteBtn.setBackground(new java.awt.Color(245, 73, 6));
    ItemDeleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    ItemDeleteBtn.setForeground(new java.awt.Color(255, 255, 255));
    ItemDeleteBtn.setText("Delete");
    ItemDeleteBtn.setFocusable(false);
    ItemDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ItemDeleteBtnActionPerformed(evt);
        }
    });
    PanelItem.add(ItemDeleteBtn);
    ItemDeleteBtn.setBounds(800, 620, 110, 28);

    ItemGetSupplierBtn.setBackground(new java.awt.Color(0, 112, 192));
    ItemGetSupplierBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    ItemGetSupplierBtn.setForeground(new java.awt.Color(255, 255, 255));
    ItemGetSupplierBtn.setText("Get Supplier");
    ItemGetSupplierBtn.setFocusable(false);
    ItemGetSupplierBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ItemGetSupplierBtnActionPerformed(evt);
        }
    });
    PanelItem.add(ItemGetSupplierBtn);
    ItemGetSupplierBtn.setBounds(660, 620, 110, 28);

    Item_delete_Button.setBackground(new java.awt.Color(191, 0, 0));
    Item_delete_Button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    Item_delete_Button.setForeground(new java.awt.Color(255, 255, 255));
    Item_delete_Button.setText("Delete All");
    Item_delete_Button.setFocusable(false);
    Item_delete_Button.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            Item_delete_ButtonActionPerformed(evt);
        }
    });
    PanelItem.add(Item_delete_Button);
    Item_delete_Button.setBounds(940, 620, 110, 28);

    PanelItemInputComponents.setBackground(new java.awt.Color(29, 29, 29));
    PanelItemInputComponents.setLayout(null);

    jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(255, 255, 255));
    jLabel7.setText("Item ID");
    PanelItemInputComponents.add(jLabel7);
    jLabel7.setBounds(0, 0, 130, 20);

    item_ID.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    item_ID.setToolTipText("");
    item_ID.setAutoscrolls(false);
    item_ID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    item_ID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    item_ID.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            item_IDKeyPressed(evt);
        }
    });
    PanelItemInputComponents.add(item_ID);
    item_ID.setBounds(0, 20, 180, 25);

    jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel20.setForeground(new java.awt.Color(255, 255, 255));
    jLabel20.setText("Item Name");
    PanelItemInputComponents.add(jLabel20);
    jLabel20.setBounds(0, 60, 130, 20);

    item_Name.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    item_Name.setToolTipText("");
    item_Name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    item_Name.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            item_NameKeyPressed(evt);
        }
    });
    PanelItemInputComponents.add(item_Name);
    item_Name.setBounds(0, 80, 180, 25);

    jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel22.setForeground(new java.awt.Color(255, 255, 255));
    jLabel22.setText("Quantity");
    PanelItemInputComponents.add(jLabel22);
    jLabel22.setBounds(0, 240, 90, 20);

    jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel23.setForeground(new java.awt.Color(255, 255, 255));
    jLabel23.setText("Supplier ID");
    PanelItemInputComponents.add(jLabel23);
    jLabel23.setBounds(0, 300, 90, 20);

    addItembtnPanel.setBackground(new java.awt.Color(7, 182, 48));
    addItembtnPanel.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            addItembtnPanelMouseEntered(evt);
        }
    });
    addItembtnPanel.setLayout(null);

    addItembtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    addItembtn.setForeground(new java.awt.Color(255, 255, 255));
    addItembtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    addItembtn.setText("Add");
    addItembtn.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            addItembtnMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            addItembtnMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            addItembtnMouseExited(evt);
        }
        public void mousePressed(java.awt.event.MouseEvent evt) {
            addItembtnMousePressed(evt);
        }
        public void mouseReleased(java.awt.event.MouseEvent evt) {
            addItembtnMouseReleased(evt);
        }
    });
    addItembtnPanel.add(addItembtn);
    addItembtn.setBounds(0, 0, 80, 30);

    PanelItemInputComponents.add(addItembtnPanel);
    addItembtnPanel.setBounds(40, 430, 80, 30);

    item_SupID.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
    item_SupID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
    item_SupID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    item_SupID.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusLost(java.awt.event.FocusEvent evt) {
            item_SupIDFocusLost(evt);
        }
    });
    item_SupID.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            item_SupIDActionPerformed(evt);
        }
    });
    item_SupID.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            item_SupIDKeyPressed(evt);
        }
    });
    PanelItemInputComponents.add(item_SupID);
    item_SupID.setBounds(0, 320, 180, 25);

    BuyingPriceLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    BuyingPriceLabel.setForeground(new java.awt.Color(255, 255, 255));
    BuyingPriceLabel.setText("Buying Price (Rs.)");
    PanelItemInputComponents.add(BuyingPriceLabel);
    BuyingPriceLabel.setBounds(0, 120, 130, 20);

    item_SPrice.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    item_SPrice.setToolTipText("");
    item_SPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    item_SPrice.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            item_SPriceKeyPressed(evt);
        }
    });
    PanelItemInputComponents.add(item_SPrice);
    item_SPrice.setBounds(0, 200, 180, 25);

    item_AtQuantity.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    item_AtQuantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    item_AtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            item_AtQuantityKeyPressed(evt);
        }
    });
    PanelItemInputComponents.add(item_AtQuantity);
    item_AtQuantity.setBounds(0, 380, 180, 25);

    item_Quantity.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    item_Quantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    item_Quantity.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            item_QuantityKeyPressed(evt);
        }
    });
    PanelItemInputComponents.add(item_Quantity);
    item_Quantity.setBounds(0, 260, 180, 25);

    jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel43.setForeground(new java.awt.Color(255, 255, 255));
    jLabel43.setText("Alert Quantity");
    PanelItemInputComponents.add(jLabel43);
    jLabel43.setBounds(0, 360, 130, 20);

    SellingPriceLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    SellingPriceLabel.setForeground(new java.awt.Color(255, 255, 255));
    SellingPriceLabel.setText("Selling Price (Rs.)");
    PanelItemInputComponents.add(SellingPriceLabel);
    SellingPriceLabel.setBounds(0, 180, 130, 20);

    item_BPrice.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    item_BPrice.setToolTipText("");
    item_BPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    item_BPrice.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            item_BPriceKeyPressed(evt);
        }
    });
    PanelItemInputComponents.add(item_BPrice);
    item_BPrice.setBounds(0, 140, 180, 25);

    PanelItem.add(PanelItemInputComponents);
    PanelItemInputComponents.setBounds(210, 186, 190, 470);

    getContentPane().add(PanelItem);
    PanelItem.setBounds(0, 0, 1250, 700);

    PanelOrder.setBackground(new java.awt.Color(29, 29, 29));
    PanelOrder.setLayout(null);

    jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jLabel25.setForeground(new java.awt.Color(255, 255, 255));
    jLabel25.setText("Item Name");
    PanelOrder.add(jLabel25);
    jLabel25.setBounds(212, 180, 70, 16);

    Order_ItemID.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
    Order_ItemID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
    Order_ItemID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    Order_ItemID.setPreferredSize(new java.awt.Dimension(240, 20));
    Order_ItemID.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            Order_ItemIDActionPerformed(evt);
        }
    });
    Order_ItemID.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            Order_ItemIDKeyPressed(evt);
        }
    });
    PanelOrder.add(Order_ItemID);
    Order_ItemID.setBounds(210, 200, 180, 25);

    jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jLabel26.setForeground(new java.awt.Color(255, 255, 255));
    jLabel26.setText("Quantity");
    PanelOrder.add(jLabel26);
    jLabel26.setBounds(212, 240, 60, 16);

    OdrAddPanel.setBackground(new java.awt.Color(7, 182, 48));
    OdrAddPanel.setLayout(null);

    OdrAddbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    OdrAddbtn.setForeground(new java.awt.Color(255, 255, 255));
    OdrAddbtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    OdrAddbtn.setText("Add");
    OdrAddbtn.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            OdrAddbtnMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            OdrAddbtnMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            OdrAddbtnMouseExited(evt);
        }
        public void mousePressed(java.awt.event.MouseEvent evt) {
            OdrAddbtnMousePressed(evt);
        }
        public void mouseReleased(java.awt.event.MouseEvent evt) {
            OdrAddbtnMouseReleased(evt);
        }
    });
    OdrAddPanel.add(OdrAddbtn);
    OdrAddbtn.setBounds(0, 0, 80, 30);

    PanelOrder.add(OdrAddPanel);
    OdrAddPanel.setBounds(250, 380, 80, 30);

    OdrSearchTextField.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
    OdrSearchTextField.setAutoscrolls(false);
    OdrSearchTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    OdrSearchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            OdrSearchTextFieldKeyReleased(evt);
        }
    });
    PanelOrder.add(OdrSearchTextField);
    OdrSearchTextField.setBounds(610, 145, 390, 28);

    OrderEditBtn.setBackground(new java.awt.Color(0, 102, 255));
    OrderEditBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    OrderEditBtn.setForeground(new java.awt.Color(255, 255, 255));
    OrderEditBtn.setText("Edit");
    OrderEditBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    OrderEditBtn.setEnabled(false);
    OrderEditBtn.setFocusPainted(false);
    OrderEditBtn.setFocusable(false);
    OrderEditBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            OrderEditBtnActionPerformed(evt);
        }
    });
    PanelOrder.add(OrderEditBtn);
    OrderEditBtn.setBounds(520, 620, 110, 28);

    OrderDeleteBtn.setBackground(new java.awt.Color(255, 0, 0));
    OrderDeleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    OrderDeleteBtn.setForeground(new java.awt.Color(255, 255, 255));
    OrderDeleteBtn.setText("Delete");
    OrderDeleteBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    OrderDeleteBtn.setEnabled(false);
    OrderDeleteBtn.setFocusPainted(false);
    OrderDeleteBtn.setFocusable(false);
    OrderDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            OrderDeleteBtnActionPerformed(evt);
        }
    });
    PanelOrder.add(OrderDeleteBtn);
    OrderDeleteBtn.setBounds(940, 620, 110, 28);

    OrderGetSupplierBtn.setBackground(new java.awt.Color(0, 102, 255));
    OrderGetSupplierBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    OrderGetSupplierBtn.setForeground(new java.awt.Color(255, 255, 255));
    OrderGetSupplierBtn.setText("Get Supplier");
    OrderGetSupplierBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    OrderGetSupplierBtn.setEnabled(false);
    OrderGetSupplierBtn.setFocusPainted(false);
    OrderGetSupplierBtn.setFocusable(false);
    OrderGetSupplierBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            OrderGetSupplierBtnActionPerformed(evt);
        }
    });
    PanelOrder.add(OrderGetSupplierBtn);
    OrderGetSupplierBtn.setBounds(660, 620, 110, 28);

    OrderGetItemBtn.setBackground(new java.awt.Color(0, 102, 255));
    OrderGetItemBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    OrderGetItemBtn.setForeground(new java.awt.Color(255, 255, 255));
    OrderGetItemBtn.setText("Get Item");
    OrderGetItemBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    OrderGetItemBtn.setEnabled(false);
    OrderGetItemBtn.setFocusPainted(false);
    OrderGetItemBtn.setFocusable(false);
    OrderGetItemBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            OrderGetItemBtnActionPerformed(evt);
        }
    });
    PanelOrder.add(OrderGetItemBtn);
    OrderGetItemBtn.setBounds(800, 620, 110, 28);

    Order_PaiedAmount.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    Order_PaiedAmount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    Order_PaiedAmount.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            Order_PaiedAmountKeyPressed(evt);
        }
    });
    PanelOrder.add(Order_PaiedAmount);
    Order_PaiedAmount.setBounds(210, 320, 180, 25);

    PaiedLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    PaiedLabel.setForeground(new java.awt.Color(255, 255, 255));
    PaiedLabel.setText("Paied Amount");
    PanelOrder.add(PaiedLabel);
    PaiedLabel.setBounds(210, 300, 90, 16);

    Order_Quantty.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    Order_Quantty.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    Order_Quantty.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            Order_QuanttyKeyPressed(evt);
        }
    });
    PanelOrder.add(Order_Quantty);
    Order_Quantty.setBounds(210, 260, 180, 25);

    jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel58.setForeground(new java.awt.Color(255, 255, 255));
    jLabel58.setText("Search:");
    PanelOrder.add(jLabel58);
    jLabel58.setBounds(550, 145, 50, 25);

    OrderTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Order ID", "Item Name", "Quantity", "Date & Time", "Total Price (Rs.)"
        }
    ));
    OrderTable.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
    OrderTable.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
    OrderTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    OrderTable.setFuenteFilas(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    OrderTable.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    OrderTable.setFuenteHead(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
    OrderTable.setMultipleSeleccion(false);
    OrderTable.setRowHeight(24);
    OrderTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            OrderTableMouseClicked(evt);
        }
    });
    jScrollPane3.setViewportView(OrderTable);

    PanelOrder.add(jScrollPane3);
    jScrollPane3.setBounds(420, 190, 740, 423);

    getContentPane().add(PanelOrder);
    PanelOrder.setBounds(0, 0, 1250, 700);

    PanelCustomer.setBackground(new java.awt.Color(29, 29, 29));
    PanelCustomer.setLayout(null);

    jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jLabel13.setForeground(new java.awt.Color(255, 255, 255));
    jLabel13.setText("Customer ID");
    PanelCustomer.add(jLabel13);
    jLabel13.setBounds(211, 180, 120, 16);

    Customer_ID.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    Customer_ID.setToolTipText("");
    Customer_ID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    Customer_ID.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            Customer_IDKeyPressed(evt);
        }
    });
    PanelCustomer.add(Customer_ID);
    Customer_ID.setBounds(210, 200, 180, 25);

    jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jLabel18.setForeground(new java.awt.Color(255, 255, 255));
    jLabel18.setText("Name");
    PanelCustomer.add(jLabel18);
    jLabel18.setBounds(212, 240, 50, 16);

    Customer_Name.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    Customer_Name.setToolTipText("");
    Customer_Name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    Customer_Name.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            Customer_NameKeyPressed(evt);
        }
    });
    PanelCustomer.add(Customer_Name);
    Customer_Name.setBounds(210, 260, 180, 25);

    jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jLabel29.setForeground(new java.awt.Color(255, 255, 255));
    jLabel29.setText("Address");
    PanelCustomer.add(jLabel29);
    jLabel29.setBounds(212, 300, 70, 16);

    Customer_Adds.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    Customer_Adds.setToolTipText("");
    Customer_Adds.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    Customer_Adds.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            Customer_AddsKeyPressed(evt);
        }
    });
    PanelCustomer.add(Customer_Adds);
    Customer_Adds.setBounds(210, 320, 180, 25);

    jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jLabel30.setForeground(new java.awt.Color(255, 255, 255));
    jLabel30.setText("Contact");
    PanelCustomer.add(jLabel30);
    jLabel30.setBounds(212, 360, 100, 16);

    Customer_Contact.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    Customer_Contact.setToolTipText("");
    Customer_Contact.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    Customer_Contact.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            Customer_ContactKeyPressed(evt);
        }
    });
    PanelCustomer.add(Customer_Contact);
    Customer_Contact.setBounds(210, 380, 180, 25);

    CusAddPanel.setBackground(new java.awt.Color(7, 182, 48));
    CusAddPanel.setLayout(null);

    CusAddBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    CusAddBtn.setForeground(new java.awt.Color(255, 255, 255));
    CusAddBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    CusAddBtn.setText("Add");
    CusAddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            CusAddBtnMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            CusAddBtnMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            CusAddBtnMouseExited(evt);
        }
        public void mousePressed(java.awt.event.MouseEvent evt) {
            CusAddBtnMousePressed(evt);
        }
        public void mouseReleased(java.awt.event.MouseEvent evt) {
            CusAddBtnMouseReleased(evt);
        }
    });
    CusAddPanel.add(CusAddBtn);
    CusAddBtn.setBounds(0, 0, 80, 30);

    PanelCustomer.add(CusAddPanel);
    CusAddPanel.setBounds(250, 430, 80, 30);

    CustomerSearchTextField.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
    CustomerSearchTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    CustomerSearchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            CustomerSearchTextFieldKeyReleased(evt);
        }
    });
    PanelCustomer.add(CustomerSearchTextField);
    CustomerSearchTextField.setBounds(610, 145, 390, 28);

    CustomerEditBtn.setBackground(new java.awt.Color(0, 102, 255));
    CustomerEditBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    CustomerEditBtn.setForeground(new java.awt.Color(255, 255, 255));
    CustomerEditBtn.setText("Edit");
    CustomerEditBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    CustomerEditBtn.setEnabled(false);
    CustomerEditBtn.setFocusPainted(false);
    CustomerEditBtn.setFocusable(false);
    CustomerEditBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            CustomerEditBtnActionPerformed(evt);
        }
    });
    PanelCustomer.add(CustomerEditBtn);
    CustomerEditBtn.setBounds(590, 620, 110, 28);

    CustomerDeleteBtn.setBackground(new java.awt.Color(255, 0, 0));
    CustomerDeleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    CustomerDeleteBtn.setForeground(new java.awt.Color(255, 255, 255));
    CustomerDeleteBtn.setText("Delete");
    CustomerDeleteBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    CustomerDeleteBtn.setEnabled(false);
    CustomerDeleteBtn.setFocusPainted(false);
    CustomerDeleteBtn.setFocusable(false);
    CustomerDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            CustomerDeleteBtnActionPerformed(evt);
        }
    });
    PanelCustomer.add(CustomerDeleteBtn);
    CustomerDeleteBtn.setBounds(870, 620, 110, 28);

    ButtonGetBill.setBackground(new java.awt.Color(0, 102, 255));
    ButtonGetBill.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    ButtonGetBill.setForeground(new java.awt.Color(255, 255, 255));
    ButtonGetBill.setText("Get Bills");
    ButtonGetBill.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    ButtonGetBill.setEnabled(false);
    ButtonGetBill.setFocusPainted(false);
    ButtonGetBill.setFocusable(false);
    ButtonGetBill.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ButtonGetBillActionPerformed(evt);
        }
    });
    PanelCustomer.add(ButtonGetBill);
    ButtonGetBill.setBounds(730, 620, 110, 28);

    jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel57.setForeground(new java.awt.Color(255, 255, 255));
    jLabel57.setText("Search:");
    PanelCustomer.add(jLabel57);
    jLabel57.setBounds(550, 145, 50, 25);

    CustomerTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Customer ID", "Name", "Address", "Contact", "Balance"
        }
    ));
    CustomerTable.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
    CustomerTable.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
    CustomerTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    CustomerTable.setFuenteFilas(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    CustomerTable.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    CustomerTable.setFuenteHead(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
    CustomerTable.setMultipleSeleccion(false);
    CustomerTable.setRowHeight(24);
    CustomerTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            CustomerTableMouseClicked(evt);
        }
    });
    jScrollPane4.setViewportView(CustomerTable);

    PanelCustomer.add(jScrollPane4);
    jScrollPane4.setBounds(420, 190, 740, 423);

    getContentPane().add(PanelCustomer);
    PanelCustomer.setBounds(0, 0, 1250, 700);

    PanelSupplier.setBackground(new java.awt.Color(29, 29, 29));
    PanelSupplier.setForeground(new java.awt.Color(255, 255, 255));
    PanelSupplier.setToolTipText("");
    PanelSupplier.setLayout(null);

    jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jLabel32.setForeground(new java.awt.Color(255, 255, 255));
    jLabel32.setText("Supplier ID");
    PanelSupplier.add(jLabel32);
    jLabel32.setBounds(211, 180, 100, 16);

    Supplier_ID.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    Supplier_ID.setToolTipText("");
    Supplier_ID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    Supplier_ID.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            Supplier_IDKeyPressed(evt);
        }
    });
    PanelSupplier.add(Supplier_ID);
    Supplier_ID.setBounds(210, 200, 180, 25);

    jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jLabel33.setForeground(new java.awt.Color(255, 255, 255));
    jLabel33.setText("Name");
    PanelSupplier.add(jLabel33);
    jLabel33.setBounds(211, 240, 100, 16);

    Supplier_Name.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    Supplier_Name.setToolTipText("");
    Supplier_Name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    Supplier_Name.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            Supplier_NameKeyPressed(evt);
        }
    });
    PanelSupplier.add(Supplier_Name);
    Supplier_Name.setBounds(210, 260, 180, 25);

    jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jLabel34.setForeground(new java.awt.Color(255, 255, 255));
    jLabel34.setText("Address");
    PanelSupplier.add(jLabel34);
    jLabel34.setBounds(212, 300, 100, 16);

    Supplier_Adds.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    Supplier_Adds.setToolTipText("");
    Supplier_Adds.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    Supplier_Adds.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            Supplier_AddsKeyPressed(evt);
        }
    });
    PanelSupplier.add(Supplier_Adds);
    Supplier_Adds.setBounds(210, 320, 180, 25);

    jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jLabel35.setForeground(new java.awt.Color(255, 255, 255));
    jLabel35.setText("Contact");
    PanelSupplier.add(jLabel35);
    jLabel35.setBounds(211, 360, 100, 16);

    Supplier_Contact.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    Supplier_Contact.setToolTipText("");
    Supplier_Contact.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    Supplier_Contact.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            Supplier_ContactKeyPressed(evt);
        }
    });
    PanelSupplier.add(Supplier_Contact);
    Supplier_Contact.setBounds(210, 380, 180, 25);

    jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jLabel36.setForeground(new java.awt.Color(255, 255, 255));
    jLabel36.setText("Discription");
    PanelSupplier.add(jLabel36);
    jLabel36.setBounds(211, 420, 100, 16);

    Supplier_Discription.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    Supplier_Discription.setToolTipText("");
    Supplier_Discription.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    Supplier_Discription.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            Supplier_DiscriptionKeyPressed(evt);
        }
    });
    PanelSupplier.add(Supplier_Discription);
    Supplier_Discription.setBounds(210, 440, 180, 25);

    SupAddPanel.setBackground(new java.awt.Color(7, 182, 48));
    SupAddPanel.setLayout(null);

    SupAddBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    SupAddBtn.setForeground(new java.awt.Color(255, 255, 255));
    SupAddBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    SupAddBtn.setText("Add");
    SupAddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            SupAddBtnMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            SupAddBtnMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            SupAddBtnMouseExited(evt);
        }
        public void mousePressed(java.awt.event.MouseEvent evt) {
            SupAddBtnMousePressed(evt);
        }
        public void mouseReleased(java.awt.event.MouseEvent evt) {
            SupAddBtnMouseReleased(evt);
        }
    });
    SupAddPanel.add(SupAddBtn);
    SupAddBtn.setBounds(0, 0, 80, 30);

    PanelSupplier.add(SupAddPanel);
    SupAddPanel.setBounds(250, 490, 80, 30);

    SupSearchTextField.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
    SupSearchTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    SupSearchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            SupSearchTextFieldKeyReleased(evt);
        }
    });
    PanelSupplier.add(SupSearchTextField);
    SupSearchTextField.setBounds(610, 145, 390, 28);

    SupplierEditBtn.setBackground(new java.awt.Color(0, 102, 255));
    SupplierEditBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    SupplierEditBtn.setForeground(new java.awt.Color(255, 255, 255));
    SupplierEditBtn.setText("Edt");
    SupplierEditBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    SupplierEditBtn.setEnabled(false);
    SupplierEditBtn.setFocusPainted(false);
    SupplierEditBtn.setFocusable(false);
    SupplierEditBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            SupplierEditBtnActionPerformed(evt);
        }
    });
    PanelSupplier.add(SupplierEditBtn);
    SupplierEditBtn.setBounds(590, 620, 110, 28);

    SupplierDeleteBtn.setBackground(new java.awt.Color(255, 0, 0));
    SupplierDeleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    SupplierDeleteBtn.setForeground(new java.awt.Color(255, 255, 255));
    SupplierDeleteBtn.setText("Delete");
    SupplierDeleteBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    SupplierDeleteBtn.setEnabled(false);
    SupplierDeleteBtn.setFocusPainted(false);
    SupplierDeleteBtn.setFocusable(false);
    SupplierDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            SupplierDeleteBtnActionPerformed(evt);
        }
    });
    PanelSupplier.add(SupplierDeleteBtn);
    SupplierDeleteBtn.setBounds(870, 620, 110, 28);

    SupGetItemsBtn.setBackground(new java.awt.Color(0, 102, 255));
    SupGetItemsBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    SupGetItemsBtn.setForeground(new java.awt.Color(255, 255, 255));
    SupGetItemsBtn.setText("Get Items");
    SupGetItemsBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    SupGetItemsBtn.setEnabled(false);
    SupGetItemsBtn.setFocusPainted(false);
    SupGetItemsBtn.setFocusable(false);
    SupGetItemsBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            SupGetItemsBtnActionPerformed(evt);
        }
    });
    PanelSupplier.add(SupGetItemsBtn);
    SupGetItemsBtn.setBounds(730, 620, 110, 28);

    jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel56.setForeground(new java.awt.Color(255, 255, 255));
    jLabel56.setText("Search:");
    PanelSupplier.add(jLabel56);
    jLabel56.setBounds(550, 145, 50, 25);

    SupplierTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Supplier ID", "Name", "Address", "Contact", "Discription"
        }
    ));
    SupplierTable.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
    SupplierTable.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
    SupplierTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    SupplierTable.setFuenteFilas(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    SupplierTable.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    SupplierTable.setFuenteHead(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
    SupplierTable.setMultipleSeleccion(false);
    SupplierTable.setRowHeight(24);
    SupplierTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            SupplierTableMouseClicked(evt);
        }
    });
    jScrollPane5.setViewportView(SupplierTable);

    PanelSupplier.add(jScrollPane5);
    jScrollPane5.setBounds(420, 190, 740, 423);

    getContentPane().add(PanelSupplier);
    PanelSupplier.setBounds(0, 0, 1250, 700);

    PanelCashier.setBackground(new java.awt.Color(29, 29, 29));
    PanelCashier.setLayout(null);

    jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel37.setForeground(new java.awt.Color(255, 255, 255));
    jLabel37.setText("Search:");
    PanelCashier.add(jLabel37);
    jLabel37.setBounds(550, 145, 50, 25);

    Cashier_ID.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    Cashier_ID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    Cashier_ID.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            Cashier_IDKeyPressed(evt);
        }
    });
    PanelCashier.add(Cashier_ID);
    Cashier_ID.setBounds(210, 200, 180, 25);

    jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jLabel38.setForeground(new java.awt.Color(255, 255, 255));
    jLabel38.setText("Name");
    PanelCashier.add(jLabel38);
    jLabel38.setBounds(211, 240, 50, 16);

    Cashier_Name.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    Cashier_Name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    Cashier_Name.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            Cashier_NameKeyPressed(evt);
        }
    });
    PanelCashier.add(Cashier_Name);
    Cashier_Name.setBounds(210, 260, 180, 25);

    jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jLabel41.setForeground(new java.awt.Color(255, 255, 255));
    jLabel41.setText("Address");
    PanelCashier.add(jLabel41);
    jLabel41.setBounds(211, 300, 90, 20);

    Cashier_Adds.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    Cashier_Adds.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    Cashier_Adds.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            Cashier_AddsKeyPressed(evt);
        }
    });
    PanelCashier.add(Cashier_Adds);
    Cashier_Adds.setBounds(210, 320, 180, 25);

    jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jLabel42.setForeground(new java.awt.Color(255, 255, 255));
    jLabel42.setText("Contact");
    PanelCashier.add(jLabel42);
    jLabel42.setBounds(211, 360, 70, 16);

    Cashier_Contact.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    Cashier_Contact.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    Cashier_Contact.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            Cashier_ContactKeyPressed(evt);
        }
    });
    PanelCashier.add(Cashier_Contact);
    Cashier_Contact.setBounds(210, 380, 180, 25);

    CashierAddPanel.setBackground(new java.awt.Color(7, 182, 48));
    CashierAddPanel.setLayout(null);

    CashierAddButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    CashierAddButton.setForeground(new java.awt.Color(255, 255, 255));
    CashierAddButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    CashierAddButton.setText("Add");
    CashierAddButton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            CashierAddButtonMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            CashierAddButtonMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            CashierAddButtonMouseExited(evt);
        }
        public void mousePressed(java.awt.event.MouseEvent evt) {
            CashierAddButtonMousePressed(evt);
        }
        public void mouseReleased(java.awt.event.MouseEvent evt) {
            CashierAddButtonMouseReleased(evt);
        }
    });
    CashierAddPanel.add(CashierAddButton);
    CashierAddButton.setBounds(0, 0, 80, 30);

    PanelCashier.add(CashierAddPanel);
    CashierAddPanel.setBounds(250, 430, 80, 30);

    CasSearchTextField.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
    CasSearchTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    CasSearchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            CasSearchTextFieldKeyReleased(evt);
        }
    });
    PanelCashier.add(CasSearchTextField);
    CasSearchTextField.setBounds(610, 145, 390, 28);

    CashierEditBtn.setBackground(new java.awt.Color(0, 102, 255));
    CashierEditBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    CashierEditBtn.setForeground(new java.awt.Color(255, 255, 255));
    CashierEditBtn.setText("Edit");
    CashierEditBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    CashierEditBtn.setEnabled(false);
    CashierEditBtn.setFocusPainted(false);
    CashierEditBtn.setFocusable(false);
    CashierEditBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            CashierEditBtnActionPerformed(evt);
        }
    });
    PanelCashier.add(CashierEditBtn);
    CashierEditBtn.setBounds(665, 620, 110, 28);

    CashierDeleteBtn.setBackground(new java.awt.Color(255, 0, 0));
    CashierDeleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    CashierDeleteBtn.setForeground(new java.awt.Color(255, 255, 255));
    CashierDeleteBtn.setText("Delete");
    CashierDeleteBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    CashierDeleteBtn.setEnabled(false);
    CashierDeleteBtn.setFocusPainted(false);
    CashierDeleteBtn.setFocusable(false);
    CashierDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            CashierDeleteBtnActionPerformed(evt);
        }
    });
    PanelCashier.add(CashierDeleteBtn);
    CashierDeleteBtn.setBounds(805, 620, 110, 28);

    jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jLabel55.setForeground(new java.awt.Color(255, 255, 255));
    jLabel55.setText("Cashier ID");
    PanelCashier.add(jLabel55);
    jLabel55.setBounds(211, 180, 100, 16);

    jScrollPane6.setBorder(null);

    CashierTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Cashier ID", "Name", "Address", "Contact"
        }
    ));
    CashierTable.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
    CashierTable.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
    CashierTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    CashierTable.setFuenteFilas(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    CashierTable.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    CashierTable.setFuenteHead(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
    CashierTable.setMultipleSeleccion(false);
    CashierTable.setRowHeight(24);
    CashierTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            CashierTableMouseClicked(evt);
        }
    });
    jScrollPane6.setViewportView(CashierTable);

    PanelCashier.add(jScrollPane6);
    jScrollPane6.setBounds(420, 190, 740, 423);

    getContentPane().add(PanelCashier);
    PanelCashier.setBounds(0, 0, 1250, 700);

    PanelReport.setBackground(new java.awt.Color(29, 29, 29));
    PanelReport.setForeground(new java.awt.Color(255, 255, 255));
    PanelReport.setFocusable(false);
    PanelReport.setLayout(null);

    admin_only7.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
    admin_only7.setForeground(new java.awt.Color(51, 51, 51));
    admin_only7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Admin_lock_mini2.png"))); // NOI18N
    admin_only7.setToolTipText("Admin Only");
    PanelReport.add(admin_only7);
    admin_only7.setBounds(763, 174, 15, 15);

    DailyRadioButton.setBackground(new java.awt.Color(29, 29, 29));
    DailyRadioButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    DailyRadioButton.setForeground(new java.awt.Color(255, 255, 255));
    DailyRadioButton.setText("Daily");
    DailyRadioButton.setFocusable(false);
    DailyRadioButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            DailyRadioButtonActionPerformed(evt);
        }
    });
    PanelReport.add(DailyRadioButton);
    DailyRadioButton.setBounds(586, 170, 80, 25);

    RadioButtonMonthly.setBackground(new java.awt.Color(29, 29, 29));
    RadioButtonMonthly.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    RadioButtonMonthly.setForeground(new java.awt.Color(255, 255, 255));
    RadioButtonMonthly.setText("Monthly");
    RadioButtonMonthly.setFocusable(false);
    RadioButtonMonthly.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            RadioButtonMonthlyActionPerformed(evt);
        }
    });
    PanelReport.add(RadioButtonMonthly);
    RadioButtonMonthly.setBounds(690, 170, 72, 25);

    ShellRptBtn.setBackground(new java.awt.Color(0, 153, 51));
    ShellRptBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    ShellRptBtn.setForeground(new java.awt.Color(255, 255, 255));
    ShellRptBtn.setText("Sell");
    ShellRptBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204)));
    ShellRptBtn.setFocusPainted(false);
    ShellRptBtn.setFocusable(false);
    ShellRptBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ShellRptBtnActionPerformed(evt);
        }
    });
    PanelReport.add(ShellRptBtn);
    ShellRptBtn.setBounds(560, 110, 120, 40);

    BillRptBtn.setBackground(new java.awt.Color(51, 204, 0));
    BillRptBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    BillRptBtn.setForeground(new java.awt.Color(255, 255, 255));
    BillRptBtn.setText("Bills");
    BillRptBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204)));
    BillRptBtn.setFocusPainted(false);
    BillRptBtn.setFocusable(false);
    BillRptBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BillRptBtnActionPerformed(evt);
        }
    });
    PanelReport.add(BillRptBtn);
    BillRptBtn.setBounds(680, 110, 120, 40);

    BlReportPanel.setBackground(new java.awt.Color(29, 29, 29));
    BlReportPanel.setLayout(null);

    BillSearchTextField.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    BillSearchTextField.setToolTipText("Enter bill id, user name or date & time");
    BillSearchTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    BillSearchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            BillSearchTextFieldKeyReleased(evt);
        }
    });
    BlReportPanel.add(BillSearchTextField);
    BillSearchTextField.setBounds(290, 20, 420, 28);

    jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(255, 255, 255));
    jLabel2.setText("Bill");
    BlReportPanel.add(jLabel2);
    jLabel2.setBounds(21, 59, 40, 20);

    AllRptRadioButton.setBackground(new java.awt.Color(29, 29, 29));
    AllRptRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    AllRptRadioButton.setForeground(new java.awt.Color(255, 255, 255));
    AllRptRadioButton.setSelected(true);
    AllRptRadioButton.setText("All");
    AllRptRadioButton.setFocusable(false);
    AllRptRadioButton.setRequestFocusEnabled(false);
    AllRptRadioButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            AllRptRadioButtonActionPerformed(evt);
        }
    });
    BlReportPanel.add(AllRptRadioButton);
    AllRptRadioButton.setBounds(250, 50, 50, 20);

    BLCRptRadioButton.setBackground(new java.awt.Color(29, 29, 29));
    BLCRptRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    BLCRptRadioButton.setForeground(new java.awt.Color(255, 255, 255));
    BLCRptRadioButton.setText("Cash");
    BLCRptRadioButton.setFocusable(false);
    BLCRptRadioButton.setRequestFocusEnabled(false);
    BLCRptRadioButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BLCRptRadioButtonActionPerformed(evt);
        }
    });
    BlReportPanel.add(BLCRptRadioButton);
    BLCRptRadioButton.setBounds(320, 50, 70, 20);

    jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(255, 255, 255));
    jLabel3.setText("Search:");
    BlReportPanel.add(jLabel3);
    jLabel3.setBounds(230, 20, 60, 30);

    itm_slt_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    itm_slt_label.setForeground(new java.awt.Color(255, 255, 255));
    itm_slt_label.setText("Items Of Selected Bill");
    BlReportPanel.add(itm_slt_label);
    itm_slt_label.setBounds(21, 260, 160, 20);

    BLCRptRadioButton1.setBackground(new java.awt.Color(29, 29, 29));
    BLCRptRadioButton1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    BLCRptRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
    BLCRptRadioButton1.setText("Card/ C.O. Delivery");
    BLCRptRadioButton1.setFocusable(false);
    BLCRptRadioButton1.setRequestFocusEnabled(false);
    BLCRptRadioButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BLCRptRadioButton1ActionPerformed(evt);
        }
    });
    BlReportPanel.add(BLCRptRadioButton1);
    BLCRptRadioButton1.setBounds(400, 50, 130, 20);

    ReturnCRptRadioButton.setBackground(new java.awt.Color(29, 29, 29));
    ReturnCRptRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    ReturnCRptRadioButton.setForeground(new java.awt.Color(255, 255, 255));
    ReturnCRptRadioButton.setText("Return");
    ReturnCRptRadioButton.setFocusable(false);
    ReturnCRptRadioButton.setRequestFocusEnabled(false);
    ReturnCRptRadioButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ReturnCRptRadioButtonActionPerformed(evt);
        }
    });
    BlReportPanel.add(ReturnCRptRadioButton);
    ReturnCRptRadioButton.setBounds(550, 50, 60, 20);

    hstCheckBox.setBackground(new java.awt.Color(29, 29, 29));
    hstCheckBox.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    hstCheckBox.setForeground(new java.awt.Color(255, 255, 255));
    hstCheckBox.setText("Show Return History");
    hstCheckBox.setEnabled(false);
    hstCheckBox.setFocusable(false);
    hstCheckBox.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            hstCheckBoxActionPerformed(evt);
        }
    });
    BlReportPanel.add(hstCheckBox);
    hstCheckBox.setBounds(610, 50, 140, 20);

    admin_only13.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
    admin_only13.setForeground(new java.awt.Color(51, 51, 51));
    admin_only13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Admin_lock_mini2.png"))); // NOI18N
    admin_only13.setToolTipText("Admin Only");
    BlReportPanel.add(admin_only13);
    admin_only13.setBounds(660, 470, 15, 26);

    PurchaseBillTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Bill ID", "Date & Time", "Total (Rs.)", "Discount (Rs.)", "Net Total (Rs.)", "Balance", "Payment Method "
        }
    ));
    PurchaseBillTable.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
    PurchaseBillTable.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
    PurchaseBillTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    PurchaseBillTable.setFuenteFilas(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    PurchaseBillTable.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    PurchaseBillTable.setFuenteHead(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
    PurchaseBillTable.setMultipleSeleccion(false);
    PurchaseBillTable.setRowHeight(24);
    PurchaseBillTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            PurchaseBillTableMouseClicked(evt);
        }
    });
    jScrollPane7.setViewportView(PurchaseBillTable);

    BlReportPanel.add(jScrollPane7);
    jScrollPane7.setBounds(20, 81, 980, 170);

    PurchaseItemTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Item ID", "Price (Rs.)", "Quantity", "Total (Rs.)", "Discount (Rs.)", "Net Total (Rs.)"
        }
    ));
    PurchaseItemTable.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
    PurchaseItemTable.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
    PurchaseItemTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    PurchaseItemTable.setFuenteFilas(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    PurchaseItemTable.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    PurchaseItemTable.setFuenteHead(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
    PurchaseItemTable.setMultipleSeleccion(false);
    PurchaseItemTable.setRowHeight(24);
    PurchaseItemTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            PurchaseItemTableMouseClicked(evt);
        }
    });
    jScrollPane2.setViewportView(PurchaseItemTable);

    BlReportPanel.add(jScrollPane2);
    jScrollPane2.setBounds(20, 282, 980, 170);

    rpt_getitem.setText("Get Item");
    rpt_getitem.setEnabled(false);
    rpt_getitem.setFocusable(false);
    rpt_getitem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    rpt_getitem.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            rpt_getitemActionPerformed(evt);
        }
    });
    BlReportPanel.add(rpt_getitem);
    rpt_getitem.setBounds(310, 470, 115, 26);

    rpt_getcus.setText("Get Customer");
    rpt_getcus.setEnabled(false);
    rpt_getcus.setFocusable(false);
    rpt_getcus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    rpt_getcus.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            rpt_getcusActionPerformed(evt);
        }
    });
    BlReportPanel.add(rpt_getcus);
    rpt_getcus.setBounds(440, 470, 115, 26);

    rpt_cashier.setEnabled(false);
    rpt_cashier.setFocusable(false);
    rpt_cashier.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    rpt_cashier.setLabel("Get Cashier");
    rpt_cashier.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            rpt_cashierActionPerformed(evt);
        }
    });
    BlReportPanel.add(rpt_cashier);
    rpt_cashier.setBounds(570, 470, 115, 26);

    fullbillrtlabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    fullbillrtlabel.setForeground(new java.awt.Color(255, 51, 51));
    fullbillrtlabel.setText("(Full Bill Returned)");
    BlReportPanel.add(fullbillrtlabel);
    fullbillrtlabel.setBounds(175, 260, 160, 20);

    PanelReport.add(BlReportPanel);
    BlReportPanel.setBounds(180, 160, 1100, 510);

    DailyReportPanel.setBackground(new java.awt.Color(29, 29, 29));
    DailyReportPanel.setLayout(null);

    jPanel1.setBackground(new java.awt.Color(255, 204, 204));
    jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 2));
    jPanel1.setLayout(null);

    ReportNetTotalCardLabel.setBackground(new java.awt.Color(255, 255, 255));
    ReportNetTotalCardLabel.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
    ReportNetTotalCardLabel.setText("Rs. 0.00");
    jPanel1.add(ReportNetTotalCardLabel);
    ReportNetTotalCardLabel.setBounds(10, 50, 450, 30);

    jLabel54.setBackground(new java.awt.Color(255, 255, 255));
    jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
    jLabel54.setText("Today Net Total (Card/ Cash On Delivery)");
    jPanel1.add(jLabel54);
    jLabel54.setBounds(4, 2, 400, 30);

    DailyReportPanel.add(jPanel1);
    jPanel1.setBounds(280, 270, 460, 90);

    jPanel2.setBackground(new java.awt.Color(255, 204, 204));
    jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 2));
    jPanel2.setLayout(null);

    ReportNetTotalCashlLabel.setBackground(new java.awt.Color(255, 255, 255));
    ReportNetTotalCashlLabel.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
    ReportNetTotalCashlLabel.setText("Rs. 0.00");
    jPanel2.add(ReportNetTotalCashlLabel);
    ReportNetTotalCashlLabel.setBounds(10, 50, 440, 30);

    jLabel60.setBackground(new java.awt.Color(255, 255, 255));
    jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
    jLabel60.setText("Today Net Total (Cash)");
    jPanel2.add(jLabel60);
    jLabel60.setBounds(4, 2, 240, 30);

    DailyReportPanel.add(jPanel2);
    jPanel2.setBounds(280, 170, 460, 90);

    jPanel3.setBackground(new java.awt.Color(255, 255, 102));
    jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 2));
    jPanel3.setLayout(null);

    jLabel14.setBackground(new java.awt.Color(255, 255, 255));
    jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
    jLabel14.setText("Today Total Earn");
    jPanel3.add(jLabel14);
    jLabel14.setBounds(4, 5, 270, 30);

    ReportTotaEarnlLabel.setBackground(new java.awt.Color(255, 255, 255));
    ReportTotaEarnlLabel.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
    ReportTotaEarnlLabel.setText("Rs. 0.00");
    jPanel3.add(ReportTotaEarnlLabel);
    ReportTotaEarnlLabel.setBounds(10, 60, 450, 50);

    DailyReportPanel.add(jPanel3);
    jPanel3.setBounds(280, 30, 460, 120);

    jPanel4.setBackground(new java.awt.Color(255, 204, 204));
    jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 2));
    jPanel4.setLayout(null);

    LabelSellItems.setBackground(new java.awt.Color(255, 255, 255));
    LabelSellItems.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    LabelSellItems.setText(" :   0");
    jPanel4.add(LabelSellItems);
    LabelSellItems.setBounds(211, 4, 200, 30);

    LabelSellQTY.setBackground(new java.awt.Color(255, 255, 255));
    LabelSellQTY.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    LabelSellQTY.setText("Today Sell Quantity         :   0");
    jPanel4.add(LabelSellQTY);
    LabelSellQTY.setBounds(4, 50, 450, 30);

    LabelSellQTY1.setBackground(new java.awt.Color(255, 255, 255));
    LabelSellQTY1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    LabelSellQTY1.setText("Today Sell Items  ");
    jPanel4.add(LabelSellQTY1);
    LabelSellQTY1.setBounds(4, 4, 200, 30);

    DailyReportPanel.add(jPanel4);
    jPanel4.setBounds(280, 370, 460, 90);

    LabelDayReportIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SendDayEndReport.png"))); // NOI18N
    DailyReportPanel.add(LabelDayReportIcon);
    LabelDayReportIcon.setBounds(550, 470, 25, 30);

    ButtonSendDayReport.setBorder(null);
    ButtonSendDayReport.setText("  Send Day End Report");
    ButtonSendDayReport.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    ButtonSendDayReport.setFocusable(false);
    ButtonSendDayReport.setFont(new java.awt.Font("Roboto Bold", 1, 12)); // NOI18N
    ButtonSendDayReport.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    ButtonSendDayReport.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ButtonSendDayReportActionPerformed(evt);
        }
    });
    DailyReportPanel.add(ButtonSendDayReport);
    ButtonSendDayReport.setBounds(420, 470, 170, 35);

    PanelReport.add(DailyReportPanel);
    DailyReportPanel.setBounds(178, 180, 1010, 700);

    MonthlyReportPanel.setBackground(new java.awt.Color(29, 29, 29));
    MonthlyReportPanel.setLayout(null);

    MreportView.setBackground(new java.awt.Color(255, 204, 51));
    MreportView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 5));
    MreportView.setLayout(null);

    total_item_costLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    total_item_costLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    total_item_costLabel.setText("Total Item Cost  :  Rs. 0.00");
    MreportView.add(total_item_costLabel);
    total_item_costLabel.setBounds(8, 100, 420, 20);

    TitleMonth_Label.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
    TitleMonth_Label.setForeground(new java.awt.Color(153, 0, 51));
    TitleMonth_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    TitleMonth_Label.setText("2020 January Report");
    MreportView.add(TitleMonth_Label);
    TitleMonth_Label.setBounds(3, 10, 420, 20);

    Monthly_T_ernLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    Monthly_T_ernLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    Monthly_T_ernLabel.setText("Total Earn          :  Rs. 0.00");
    MreportView.add(Monthly_T_ernLabel);
    Monthly_T_ernLabel.setBounds(10, 60, 420, 20);

    eLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    eLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    eLabel.setText("Electricity Bill    :  Rs. 0.00");
    MreportView.add(eLabel);
    eLabel.setBounds(9, 140, 410, 20);

    wLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    wLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    wLabel.setText("Water Bill           :  Rs. 0.00");
    MreportView.add(wLabel);
    wLabel.setBounds(9, 180, 420, 20);

    netp_label.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
    netp_label.setForeground(new java.awt.Color(0, 0, 153));
    netp_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    netp_label.setText("Net Profit:");
    MreportView.add(netp_label);
    netp_label.setBounds(10, 280, 420, 40);

    oLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    oLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    oLabel.setText("Other Costs       :  Rs. 0.00");
    MreportView.add(oLabel);
    oLabel.setBounds(8, 220, 420, 20);

    ProfitLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
    ProfitLabel.setForeground(new java.awt.Color(0, 0, 153));
    ProfitLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    ProfitLabel.setText("  Rs. 0.00");
    MreportView.add(ProfitLabel);
    ProfitLabel.setBounds(10, 320, 420, 60);

    MonthlyReportPanel.add(MreportView);
    MreportView.setBounds(400, 40, 440, 400);

    SelectMonth.setBackground(new java.awt.Color(29, 29, 29));
    SelectMonth.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    SelectMonth.setForeground(new java.awt.Color(255, 255, 255));
    SelectMonth.setText("Select Month");
    SelectMonth.setFocusable(false);
    SelectMonth.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            SelectMonthActionPerformed(evt);
        }
    });
    MonthlyReportPanel.add(SelectMonth);
    SelectMonth.setBounds(70, 130, 120, 23);

    ThisMonth.setBackground(new java.awt.Color(29, 29, 29));
    ThisMonth.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    ThisMonth.setForeground(new java.awt.Color(255, 255, 255));
    ThisMonth.setSelected(true);
    ThisMonth.setText("This Month");
    ThisMonth.setFocusable(false);
    ThisMonth.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ThisMonthActionPerformed(evt);
        }
    });
    MonthlyReportPanel.add(ThisMonth);
    ThisMonth.setBounds(70, 70, 110, 25);

    PreviousMonth.setBackground(new java.awt.Color(29, 29, 29));
    PreviousMonth.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    PreviousMonth.setForeground(new java.awt.Color(255, 255, 255));
    PreviousMonth.setText("Previous Month");
    PreviousMonth.setFocusable(false);
    PreviousMonth.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            PreviousMonthActionPerformed(evt);
        }
    });
    MonthlyReportPanel.add(PreviousMonth);
    PreviousMonth.setBounds(70, 100, 120, 23);

    YearComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    YearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Year" }));
    YearComboBox.setFocusable(false);
    YearComboBox.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            YearComboBoxActionPerformed(evt);
        }
    });
    MonthlyReportPanel.add(YearComboBox);
    YearComboBox.setBounds(90, 170, 70, 22);

    MonthComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    MonthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Month" }));
    MonthComboBox.setFocusable(false);
    MonthComboBox.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            MonthComboBoxActionPerformed(evt);
        }
    });
    MonthlyReportPanel.add(MonthComboBox);
    MonthComboBox.setBounds(170, 170, 70, 22);

    Ebill_TextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    Ebill_TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    Ebill_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            Ebill_TextFieldKeyPressed(evt);
        }
        public void keyReleased(java.awt.event.KeyEvent evt) {
            Ebill_TextFieldKeyReleased(evt);
        }
    });
    MonthlyReportPanel.add(Ebill_TextField);
    Ebill_TextField.setBounds(70, 245, 180, 25);

    Wbill_TextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    Wbill_TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    Wbill_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            Wbill_TextFieldKeyPressed(evt);
        }
        public void keyReleased(java.awt.event.KeyEvent evt) {
            Wbill_TextFieldKeyReleased(evt);
        }
    });
    MonthlyReportPanel.add(Wbill_TextField);
    Wbill_TextField.setBounds(70, 325, 180, 25);

    Othercost_TextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    Othercost_TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    Othercost_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            Othercost_TextFieldKeyReleased(evt);
        }
    });
    MonthlyReportPanel.add(Othercost_TextField);
    Othercost_TextField.setBounds(70, 405, 180, 25);

    jLabel8.setBackground(new java.awt.Color(29, 29, 29));
    jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(255, 255, 255));
    jLabel8.setText("Other Costs (Rs.): ");
    MonthlyReportPanel.add(jLabel8);
    jLabel8.setBounds(70, 380, 150, 20);

    jLabel27.setBackground(new java.awt.Color(29, 29, 29));
    jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel27.setForeground(new java.awt.Color(255, 255, 255));
    jLabel27.setText("Report: ");
    MonthlyReportPanel.add(jLabel27);
    jLabel27.setBounds(70, 45, 150, 20);

    jLabel28.setBackground(new java.awt.Color(29, 29, 29));
    jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel28.setForeground(new java.awt.Color(255, 255, 255));
    jLabel28.setText("Electricity Bill (Rs.): ");
    MonthlyReportPanel.add(jLabel28);
    jLabel28.setBounds(70, 220, 150, 20);

    jLabel51.setBackground(new java.awt.Color(29, 29, 29));
    jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel51.setForeground(new java.awt.Color(255, 255, 255));
    jLabel51.setText("Water Bill (Rs.): ");
    MonthlyReportPanel.add(jLabel51);
    jLabel51.setBounds(70, 300, 150, 20);

    PanelReport.add(MonthlyReportPanel);
    MonthlyReportPanel.setBounds(178, 180, 920, 480);

    getContentPane().add(PanelReport);
    PanelReport.setBounds(0, 0, 1250, 700);

    PanelReturn.setBackground(new java.awt.Color(29, 29, 29));
    PanelReturn.setLayout(null);

    jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jLabel11.setForeground(new java.awt.Color(255, 255, 255));
    jLabel11.setText("Return Quantity");
    PanelReturn.add(jLabel11);
    jLabel11.setBounds(210, 370, 100, 20);

    LabeItemSelected.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    LabeItemSelected.setForeground(new java.awt.Color(255, 255, 255));
    LabeItemSelected.setText("Item Of Selected Bill");
    PanelReturn.add(LabeItemSelected);
    LabeItemSelected.setBounds(382, 440, 190, 20);

    TextFieldReturnQTY.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    TextFieldReturnQTY.setText("1");
    TextFieldReturnQTY.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    PanelReturn.add(TextFieldReturnQTY);
    TextFieldReturnQTY.setBounds(210, 390, 130, 28);

    RadioButtonReSelling.setBackground(new java.awt.Color(29, 29, 29));
    RadioButtonReSelling.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    RadioButtonReSelling.setForeground(new java.awt.Color(255, 255, 255));
    RadioButtonReSelling.setSelected(true);
    RadioButtonReSelling.setText("From Customer");
    RadioButtonReSelling.setFocusable(false);
    RadioButtonReSelling.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            RadioButtonReSellingActionPerformed(evt);
        }
    });
    PanelReturn.add(RadioButtonReSelling);
    RadioButtonReSelling.setBounds(210, 260, 120, 23);

    RadioButtonToSupplier.setBackground(new java.awt.Color(29, 29, 29));
    RadioButtonToSupplier.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    RadioButtonToSupplier.setForeground(new java.awt.Color(255, 255, 255));
    RadioButtonToSupplier.setText("To Supplier");
    RadioButtonToSupplier.setFocusable(false);
    RadioButtonToSupplier.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            RadioButtonToSupplierActionPerformed(evt);
        }
    });
    PanelReturn.add(RadioButtonToSupplier);
    RadioButtonToSupplier.setBounds(210, 283, 85, 23);

    ButtonReturnBill.setBackground(new java.awt.Color(255, 51, 51));
    ButtonReturnBill.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    ButtonReturnBill.setForeground(new java.awt.Color(255, 255, 255));
    ButtonReturnBill.setText("Return Bill");
    ButtonReturnBill.setEnabled(false);
    ButtonReturnBill.setFocusable(false);
    ButtonReturnBill.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ButtonReturnBillActionPerformed(evt);
        }
    });
    PanelReturn.add(ButtonReturnBill);
    ButtonReturnBill.setBounds(660, 640, 110, 28);

    LabelReturnBillTxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    LabelReturnBillTxt.setForeground(new java.awt.Color(255, 255, 255));
    LabelReturnBillTxt.setText("Bill");
    LabelReturnBillTxt.setFocusable(false);
    LabelReturnBillTxt.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    PanelReturn.add(LabelReturnBillTxt);
    LabelReturnBillTxt.setBounds(382, 185, 170, 20);

    jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel62.setForeground(new java.awt.Color(255, 255, 255));
    jLabel62.setText("Search:");
    jLabel62.setFocusable(false);
    jLabel62.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    PanelReturn.add(jLabel62);
    jLabel62.setBounds(510, 145, 60, 30);

    jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel63.setForeground(new java.awt.Color(255, 255, 255));
    jLabel63.setText("Search:");
    jLabel63.setFocusable(false);
    jLabel63.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    PanelReturn.add(jLabel63);
    jLabel63.setBounds(510, 397, 60, 30);

    TextFieldReturnItemSearch.setEditable(false);
    TextFieldReturnItemSearch.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    TextFieldReturnItemSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    TextFieldReturnItemSearch.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            TextFieldReturnItemSearchMouseClicked(evt);
        }
    });
    TextFieldReturnItemSearch.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            TextFieldReturnItemSearchKeyReleased(evt);
        }
    });
    PanelReturn.add(TextFieldReturnItemSearch);
    TextFieldReturnItemSearch.setBounds(570, 397, 360, 28);

    TextFieldReturnBillSearch.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    TextFieldReturnBillSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    TextFieldReturnBillSearch.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            TextFieldReturnBillSearchKeyReleased(evt);
        }
    });
    PanelReturn.add(TextFieldReturnBillSearch);
    TextFieldReturnBillSearch.setBounds(570, 145, 360, 28);

    jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jLabel40.setForeground(new java.awt.Color(255, 255, 255));
    jLabel40.setText("Return Method");
    PanelReturn.add(jLabel40);
    jLabel40.setBounds(210, 220, 140, 20);

    ButtonAddReturnQTY.setBackground(new java.awt.Color(0, 112, 192));
    ButtonAddReturnQTY.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    ButtonAddReturnQTY.setForeground(new java.awt.Color(255, 255, 255));
    ButtonAddReturnQTY.setText("Add to return");
    ButtonAddReturnQTY.setEnabled(false);
    ButtonAddReturnQTY.setFocusable(false);
    ButtonAddReturnQTY.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ButtonAddReturnQTYActionPerformed(evt);
        }
    });
    PanelReturn.add(ButtonAddReturnQTY);
    ButtonAddReturnQTY.setBounds(220, 430, 110, 25);

    ReturnBillTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Bill ID", "Date & Time", "Total (Rs.)", "Discount (Rs.)", "Net Total (Rs.)", "Balance (Rs.)", "Payment Method"
        }
    ));
    ReturnBillTable.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
    ReturnBillTable.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
    ReturnBillTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    ReturnBillTable.setFuenteFilas(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    ReturnBillTable.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    ReturnBillTable.setFuenteHead(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
    ReturnBillTable.setMultipleSeleccion(false);
    ReturnBillTable.setRowHeight(24);
    ReturnBillTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            ReturnBillTableMouseClicked(evt);
        }
    });
    jScrollPane10.setViewportView(ReturnBillTable);

    PanelReturn.add(jScrollPane10);
    jScrollPane10.setBounds(382, 204, 800, 170);

    ReturnItemTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Item ID", "Quantity", "Total (Rs.)", "Discount (Rs.)", "Net Total (Rs.)"
        }
    ));
    ReturnItemTable.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
    ReturnItemTable.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
    ReturnItemTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    ReturnItemTable.setFuenteFilas(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    ReturnItemTable.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    ReturnItemTable.setFuenteHead(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
    ReturnItemTable.setMultipleSeleccion(false);
    ReturnItemTable.setRowHeight(24);
    ReturnItemTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            ReturnItemTableMouseClicked(evt);
        }
    });
    jScrollPane11.setViewportView(ReturnItemTable);

    PanelReturn.add(jScrollPane11);
    jScrollPane11.setBounds(382, 460, 800, 170);

    ButtonReturnQTY.setBackground(new java.awt.Color(255, 51, 51));
    ButtonReturnQTY.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    ButtonReturnQTY.setForeground(new java.awt.Color(255, 255, 255));
    ButtonReturnQTY.setText("Return");
    ButtonReturnQTY.setFocusable(false);
    ButtonReturnQTY.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ButtonReturnQTYActionPerformed(evt);
        }
    });
    PanelReturn.add(ButtonReturnQTY);
    ButtonReturnQTY.setBounds(220, 500, 110, 25);

    ButtonReturnReset.setBackground(new java.awt.Color(0, 112, 192));
    ButtonReturnReset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    ButtonReturnReset.setForeground(new java.awt.Color(255, 255, 255));
    ButtonReturnReset.setText("Reset");
    ButtonReturnReset.setEnabled(false);
    ButtonReturnReset.setFocusable(false);
    ButtonReturnReset.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ButtonReturnResetActionPerformed(evt);
        }
    });
    PanelReturn.add(ButtonReturnReset);
    ButtonReturnReset.setBounds(220, 465, 110, 25);

    ButtonReturnToSuppliers.setBackground(new java.awt.Color(255, 51, 51));
    ButtonReturnToSuppliers.setBorder(null);
    ButtonReturnToSuppliers.setText("Return");
    ButtonReturnToSuppliers.setColorHover(new java.awt.Color(255, 102, 102));
    ButtonReturnToSuppliers.setEnabled(false);
    ButtonReturnToSuppliers.setFocusable(false);
    ButtonReturnToSuppliers.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    ButtonReturnToSuppliers.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ButtonReturnToSuppliersActionPerformed(evt);
        }
    });
    PanelReturn.add(ButtonReturnToSuppliers);
    ButtonReturnToSuppliers.setBounds(220, 430, 110, 26);

    admin_only14.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
    admin_only14.setForeground(new java.awt.Color(51, 51, 51));
    admin_only14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Admin_lock_mini2.png"))); // NOI18N
    admin_only14.setToolTipText("Admin Only");
    PanelReturn.add(admin_only14);
    admin_only14.setBounds(300, 285, 15, 15);

    getContentPane().add(PanelReturn);
    PanelReturn.setBounds(0, 0, 1250, 750);

    PanelSettings.setBackground(new java.awt.Color(29, 29, 29));
    PanelSettings.setToolTipText("");
    PanelSettings.setLayout(null);

    admin_only11.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
    admin_only11.setForeground(new java.awt.Color(51, 51, 51));
    admin_only11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Admin_lock_mini.png"))); // NOI18N
    admin_only11.setToolTipText("Admin Only");
    PanelSettings.add(admin_only11);
    admin_only11.setBounds(135, 178, 30, 25);

    admin_only12.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
    admin_only12.setForeground(new java.awt.Color(51, 51, 51));
    admin_only12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Admin_lock_mini.png"))); // NOI18N
    admin_only12.setToolTipText("Admin Only");
    PanelSettings.add(admin_only12);
    admin_only12.setBounds(135, 238, 25, 25);

    Database.setBackground(new java.awt.Color(29, 29, 29));
    Database.setLayout(null);

    Backup_btn.setText("Backup");
    Backup_btn.setToolTipText("Click to here backup database");
    Backup_btn.setFocusable(false);
    Backup_btn.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
    Backup_btn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            Backup_btnActionPerformed(evt);
        }
    });
    Database.add(Backup_btn);
    Backup_btn.setBounds(300, 150, 250, 90);

    Restore_btn.setBackground(new java.awt.Color(0, 204, 51));
    Restore_btn.setText("Restore");
    Restore_btn.setToolTipText("Click to here restore database | Warning: if you select wrong database then system break down.");
    Restore_btn.setColorHover(new java.awt.Color(102, 255, 102));
    Restore_btn.setFocusable(false);
    Restore_btn.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
    Restore_btn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            Restore_btnActionPerformed(evt);
        }
    });
    Database.add(Restore_btn);
    Restore_btn.setBounds(300, 310, 250, 90);

    PanelSettings.add(Database);
    Database.setBounds(170, 100, 820, 500);

    about.setBackground(new java.awt.Color(29, 29, 29));
    about.setLayout(null);

    jLabel73.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    jLabel73.setForeground(new java.awt.Color(255, 255, 255));
    jLabel73.setText("POS System For Aanya Fashion Store (v 1.2  Update 2021 Febuary)");
    about.add(jLabel73);
    jLabel73.setBounds(70, 110, 980, 30);

    jLabel74.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    jLabel74.setForeground(new java.awt.Color(255, 255, 255));
    jLabel74.setText("Devolop by Thakshara Dhananjaya Jayaweera");
    about.add(jLabel74);
    jLabel74.setBounds(70, 157, 530, 30);

    jLabel75.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    jLabel75.setForeground(new java.awt.Color(255, 255, 255));
    jLabel75.setText("www.widdev.com");
    about.add(jLabel75);
    jLabel75.setBounds(70, 280, 540, 30);

    jLabel76.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    jLabel76.setForeground(new java.awt.Color(255, 255, 255));
    jLabel76.setText("Contact: 077 659 1828");
    about.add(jLabel76);
    jLabel76.setBounds(70, 200, 290, 30);

    jLabel77.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    jLabel77.setForeground(new java.awt.Color(255, 255, 255));
    jLabel77.setText("E-mail: thaksharadhananjaya@gmail.com");
    about.add(jLabel77);
    jLabel77.setBounds(70, 240, 540, 30);

    PanelSettings.add(about);
    about.setBounds(170, 100, 1100, 380);

    user_act.setBackground(new java.awt.Color(29, 29, 29));
    user_act.setLayout(null);

    jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    jLabel19.setForeground(new java.awt.Color(255, 255, 255));
    jLabel19.setText("Change / Delete Account:");
    user_act.add(jLabel19);
    jLabel19.setBounds(550, 30, 200, 20);

    RadioButton_Admin.setBackground(new java.awt.Color(29, 29, 29));
    RadioButton_Admin.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    RadioButton_Admin.setForeground(new java.awt.Color(255, 255, 255));
    RadioButton_Admin.setText("Admin");
    RadioButton_Admin.setFocusable(false);
    RadioButton_Admin.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            RadioButton_AdminActionPerformed(evt);
        }
    });
    user_act.add(RadioButton_Admin);
    RadioButton_Admin.setBounds(60, 60, 80, 20);

    RadioButton_Cashier.setBackground(new java.awt.Color(29, 29, 29));
    RadioButton_Cashier.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    RadioButton_Cashier.setForeground(new java.awt.Color(255, 255, 255));
    RadioButton_Cashier.setSelected(true);
    RadioButton_Cashier.setText("Cashier");
    RadioButton_Cashier.setFocusable(false);
    RadioButton_Cashier.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            RadioButton_CashierActionPerformed(evt);
        }
    });
    user_act.add(RadioButton_Cashier);
    RadioButton_Cashier.setBounds(170, 60, 90, 20);

    Label_CashierUserAcct.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    Label_CashierUserAcct.setForeground(new java.awt.Color(255, 255, 255));
    Label_CashierUserAcct.setText("Select Cashier ID:");
    user_act.add(Label_CashierUserAcct);
    Label_CashierUserAcct.setBounds(60, 110, 140, 20);

    ComboBox_Cashieruserselect.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    ComboBox_Cashieruserselect.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
    ComboBox_Cashieruserselect.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    ComboBox_Cashieruserselect.setFocusable(false);
    ComboBox_Cashieruserselect.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ComboBox_CashieruserselectActionPerformed(evt);
        }
    });
    user_act.add(ComboBox_Cashieruserselect);
    ComboBox_Cashieruserselect.setBounds(60, 140, 170, 25);

    jLabel65.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    jLabel65.setForeground(new java.awt.Color(255, 255, 255));
    jLabel65.setText("User Name:");
    user_act.add(jLabel65);
    jLabel65.setBounds(60, 190, 120, 20);

    userNameTextField.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    userNameTextField.setBorder(null);
    userNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            userNameTextFieldKeyPressed(evt);
        }
    });
    user_act.add(userNameTextField);
    userNameTextField.setBounds(60, 220, 170, 25);

    jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    jLabel66.setForeground(new java.awt.Color(255, 255, 255));
    jLabel66.setText("Password:");
    user_act.add(jLabel66);
    jLabel66.setBounds(60, 270, 90, 20);

    jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    jLabel67.setForeground(new java.awt.Color(255, 255, 255));
    jLabel67.setText("Your Current Password:");
    user_act.add(jLabel67);
    jLabel67.setBounds(550, 110, 310, 20);

    UserAcct_Button.setBackground(new java.awt.Color(0, 204, 51));
    UserAcct_Button.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    UserAcct_Button.setForeground(new java.awt.Color(255, 255, 255));
    UserAcct_Button.setText("Create");
    UserAcct_Button.setFocusable(false);
    UserAcct_Button.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            UserAcct_ButtonActionPerformed(evt);
        }
    });
    user_act.add(UserAcct_Button);
    UserAcct_Button.setBounds(100, 430, 90, 31);

    jPasswordField1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
    jPasswordField1.setToolTipText("");
    jPasswordField1.setBorder(null);
    jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            jPasswordField1KeyPressed(evt);
        }
    });
    user_act.add(jPasswordField1);
    jPasswordField1.setBounds(550, 300, 170, 25);

    RT_PasswordTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
    RT_PasswordTextField.setToolTipText("");
    RT_PasswordTextField.setBorder(null);
    RT_PasswordTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            RT_PasswordTextFieldKeyPressed(evt);
        }
    });
    user_act.add(RT_PasswordTextField);
    RT_PasswordTextField.setBounds(60, 380, 170, 25);

    jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    jLabel68.setForeground(new java.awt.Color(255, 255, 255));
    jLabel68.setText("User Account Type:");
    user_act.add(jLabel68);
    jLabel68.setBounds(60, 30, 150, 20);

    ComboBox_UserNameselect.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    ComboBox_UserNameselect.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
    ComboBox_UserNameselect.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    ComboBox_UserNameselect.setFocusable(false);
    ComboBox_UserNameselect.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ComboBox_UserNameselectActionPerformed(evt);
        }
    });
    user_act.add(ComboBox_UserNameselect);
    ComboBox_UserNameselect.setBounds(550, 60, 170, 25);

    PasswordTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
    PasswordTextField.setToolTipText("");
    PasswordTextField.setBorder(null);
    PasswordTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            PasswordTextFieldKeyPressed(evt);
        }
    });
    user_act.add(PasswordTextField);
    PasswordTextField.setBounds(60, 300, 170, 25);

    jPasswordField4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
    jPasswordField4.setToolTipText("");
    jPasswordField4.setBorder(null);
    user_act.add(jPasswordField4);
    jPasswordField4.setBounds(550, 380, 170, 25);

    jPasswordField5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
    jPasswordField5.setToolTipText("");
    jPasswordField5.setBorder(null);
    jPasswordField5.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            jPasswordField5KeyPressed(evt);
        }
    });
    user_act.add(jPasswordField5);
    jPasswordField5.setBounds(550, 140, 170, 25);

    jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    jLabel69.setForeground(new java.awt.Color(255, 255, 255));
    jLabel69.setText("Retype Password:");
    user_act.add(jLabel69);
    jLabel69.setBounds(60, 350, 150, 20);

    jLabel70.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    jLabel70.setForeground(new java.awt.Color(255, 255, 255));
    jLabel70.setText("Retype New Password:");
    user_act.add(jLabel70);
    jLabel70.setBounds(550, 350, 180, 20);

    jLabel71.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    jLabel71.setForeground(new java.awt.Color(255, 255, 255));
    jLabel71.setText("New Password:");
    user_act.add(jLabel71);
    jLabel71.setBounds(550, 270, 180, 20);

    jButton13.setBackground(new java.awt.Color(0, 51, 255));
    jButton13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    jButton13.setForeground(new java.awt.Color(255, 255, 255));
    jButton13.setText("Change");
    jButton13.setEnabled(false);
    jButton13.setFocusable(false);
    jButton13.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton13ActionPerformed(evt);
        }
    });
    user_act.add(jButton13);
    jButton13.setBounds(550, 430, 100, 31);

    jButton14.setBackground(new java.awt.Color(255, 0, 0));
    jButton14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    jButton14.setForeground(new java.awt.Color(255, 255, 255));
    jButton14.setText("Delete");
    jButton14.setEnabled(false);
    jButton14.setFocusable(false);
    jButton14.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton14ActionPerformed(evt);
        }
    });
    user_act.add(jButton14);
    jButton14.setBounds(660, 430, 100, 31);

    jLabel72.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    jLabel72.setForeground(new java.awt.Color(255, 255, 255));
    jLabel72.setText("New User Name:");
    user_act.add(jLabel72);
    jLabel72.setBounds(550, 190, 150, 20);

    jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    jTextField2.setBorder(null);
    jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            jTextField2KeyPressed(evt);
        }
    });
    user_act.add(jTextField2);
    jTextField2.setBounds(550, 220, 170, 25);

    PanelSettings.add(user_act);
    user_act.setBounds(160, 90, 940, 530);

    sideBar.setBackground(new java.awt.Color(0, 112, 192));
    PanelSettings.add(sideBar);
    sideBar.setBounds(0, 340, 160, 380);

    userAcct_btn.setBorder(null);
    userAcct_btn.setText("  User Account");
    userAcct_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    userAcct_btn.setFocusable(false);
    userAcct_btn.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
    userAcct_btn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    userAcct_btn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            userAcct_btnActionPerformed(evt);
        }
    });
    PanelSettings.add(userAcct_btn);
    userAcct_btn.setBounds(0, 160, 160, 60);

    database_btn.setBorder(null);
    database_btn.setText("  Database");
    database_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    database_btn.setFocusable(false);
    database_btn.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
    database_btn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    database_btn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            database_btnActionPerformed(evt);
        }
    });
    PanelSettings.add(database_btn);
    database_btn.setBounds(0, 220, 160, 60);

    about_btn.setBorder(null);
    about_btn.setText("  About");
    about_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    about_btn.setFocusable(false);
    about_btn.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
    about_btn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    about_btn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            about_btnActionPerformed(evt);
        }
    });
    PanelSettings.add(about_btn);
    about_btn.setBounds(0, 280, 160, 60);

    jButton9.setBackground(new java.awt.Color(102, 0, 102));
    jButton9.setBorder(null);
    jButton9.setText(" Home");
    jButton9.setColorHover(new java.awt.Color(153, 0, 153));
    jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jButton9.setFocusable(false);
    jButton9.setFont(new java.awt.Font("Roboto Bold", 1, 30)); // NOI18N
    jButton9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jButton9.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton9ActionPerformed(evt);
        }
    });
    PanelSettings.add(jButton9);
    jButton9.setBounds(0, 90, 160, 70);

    getContentPane().add(PanelSettings);
    PanelSettings.setBounds(0, 0, 1200, 700);

    setBounds(0, 0, 1202, 687);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        // Get window location for Window move
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - mouseX, y - mouseY);
    }//GEN-LAST:event_jLabel1MouseDragged

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        // Get mouse location for Window move
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

    private void PanelTitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelTitleMouseDragged
        // Get window location for Window move
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - mouseX, y - mouseY);
    }//GEN-LAST:event_PanelTitleMouseDragged

    private void PanelTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelTitleMousePressed
        // Get mouse location for Window move
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_PanelTitleMousePressed

    private void close_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_btnMouseClicked
        if (ButtonCancelItem.isEnabled()) {
            int btnrslt = JOptionPane.showConfirmDialog(this, "Billing is progess.\nDo you want to cancel bill and exit?", "Shop Management System", JOptionPane.YES_NO_OPTION);
            if (btnrslt == 0) {
                ButtonCancelItem.doClick();
                System.exit(0);
            }
        } else {
            System.exit(0);
        }
    }//GEN-LAST:event_close_btnMouseClicked

    private void minimize_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimize_btnMouseClicked
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_minimize_btnMouseClicked

    private void close_btnMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_btnMouseMoved
        close_btn.setForeground(Color.red);//Mouse hover color
    }//GEN-LAST:event_close_btnMouseMoved

    private void close_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_btnMouseExited
        close_btn.setForeground(new Color(102, 102, 102)); // Defualt color to mouse ext
    }//GEN-LAST:event_close_btnMouseExited

    private void minimize_btnMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimize_btnMouseMoved
        minimize_btn.setForeground(Color.GREEN); // Mouse hover color
    }//GEN-LAST:event_minimize_btnMouseMoved

    private void minimize_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimize_btnMouseExited
        minimize_btn.setForeground(new Color(102, 102, 102)); // Defualt color to mouse ext
    }//GEN-LAST:event_minimize_btnMouseExited

    private void homebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homebtnMouseClicked
        Panelhide();
        PanelHome.setVisible(true);

    }//GEN-LAST:event_homebtnMouseClicked

    private void homebtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homebtnMouseEntered
        homePanel.setBackground(new Color(153, 0, 153)); //Mouse hover color
    }//GEN-LAST:event_homebtnMouseEntered

    private void homePanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homePanelMouseEntered

    }//GEN-LAST:event_homePanelMouseEntered

    private void homebtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homebtnMouseExited
        homePanel.setBackground(new Color(102, 0, 102)); // Defualt color to mouse ext
    }//GEN-LAST:event_homebtnMouseExited

    private void NclearbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NclearbtnMouseEntered
        //Nclearbtn.setIcon(new ImageIcon(getClass().getResource("/images/Nclearbtn-mouseEnter.png"))); // Set Mouse hover image
    }//GEN-LAST:event_NclearbtnMouseEntered

    private void NclearbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NclearbtnMouseExited
        //Nclearbtn.setIcon(new ImageIcon(getClass().getResource("/images/Nclearbtn-default.png"))); // Set Mouse defualt image
    }//GEN-LAST:event_NclearbtnMouseExited

    private void addItembtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addItembtnMouseEntered
        addItembtnPanel.setBackground(new Color(82, 219, 115)); // Mouse hover color
    }//GEN-LAST:event_addItembtnMouseEntered

    private void addItembtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addItembtnMouseExited
        addItembtnPanel.setBackground(new Color(7, 182, 48)); // Defualt color to mouse ext
    }//GEN-LAST:event_addItembtnMouseExited

    private void addItembtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addItembtnMouseClicked
        AddItemBtnClick();
    }//GEN-LAST:event_addItembtnMouseClicked

    private void addItembtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addItembtnMousePressed
        // Mouse click animation for Pressed
        addItembtnPanel.setSize(79, 29);
        addItembtn.setSize(79, 29);
    }//GEN-LAST:event_addItembtnMousePressed

    private void addItembtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addItembtnMouseReleased
        // Mouse click animation for Released
        addItembtnPanel.setSize(80, 30);
        addItembtn.setSize(80, 30);
    }//GEN-LAST:event_addItembtnMouseReleased

        private void addItembtnPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addItembtnPanelMouseEntered
            // TODO add your handling code here:
    }//GEN-LAST:event_addItembtnPanelMouseEntered

    private void OdrAddbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OdrAddbtnMouseEntered
        OdrAddPanel.setBackground(new Color(82, 219, 115)); // Mouse hover color
    }//GEN-LAST:event_OdrAddbtnMouseEntered

    private void OdrAddbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OdrAddbtnMouseExited
        OdrAddPanel.setBackground(new Color(7, 182, 48)); // Defualt color to mouse ext
    }//GEN-LAST:event_OdrAddbtnMouseExited

    private void OdrAddbtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OdrAddbtnMousePressed
        // Mouse click animation for Pressed
        OdrAddPanel.setSize(79, 29);
        OdrAddbtn.setSize(79, 29);
    }//GEN-LAST:event_OdrAddbtnMousePressed

    private void OdrAddbtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OdrAddbtnMouseReleased
        // Mouse click animation for Pressed
        OdrAddPanel.setSize(80, 30);
        OdrAddbtn.setSize(80, 30);
    }//GEN-LAST:event_OdrAddbtnMouseReleased

    private void userbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userbtnMouseClicked
        PanelLogout.setVisible(true);
        Logoutbtn.setVisible(true);
        PanelUserName.setVisible(true);
        admin_text.setVisible(true);
    }//GEN-LAST:event_userbtnMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        PanelLogout.setVisible(false);
        Logoutbtn.setVisible(false);
        PanelUserName.setVisible(false);
        admin_text.setVisible(false);
    }//GEN-LAST:event_formMouseClicked

    private void PanelTitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelTitleMouseClicked
        PanelLogout.setVisible(false);
        Logoutbtn.setVisible(false);
        PanelUserName.setVisible(false);
        admin_text.setVisible(false);
    }//GEN-LAST:event_PanelTitleMouseClicked

    private void PanelHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelHomeMouseClicked
        PanelLogout.setVisible(false);
        Logoutbtn.setVisible(false);
        PanelUserName.setVisible(false);
        admin_text.setVisible(false);
    }//GEN-LAST:event_PanelHomeMouseClicked

    private void admin_textMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_textMouseClicked
        PanelUserName.setVisible(true);
        admin_text.setVisible(true);
    }//GEN-LAST:event_admin_textMouseClicked

    private void notificationbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationbtnMouseClicked
        Panelhide();
        PanelHome.setVisible(true);
    }//GEN-LAST:event_notificationbtnMouseClicked

    private void notificationbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationbtnMouseEntered
        //notificationbtn.setIcon(new ImageIcon(getClass().getResource("/images/notificationHover.png"))); // Set Mouse hover image
    }//GEN-LAST:event_notificationbtnMouseEntered

    private void notificationbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationbtnMouseExited
        //notificationbtn.setIcon(new ImageIcon(getClass().getResource("/images/notificationN.png"))); // Set Mouse defualt image
    }//GEN-LAST:event_notificationbtnMouseExited

    private void LogoutbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutbtnMouseEntered
        PanelLogout.setBackground(new Color(33, 216, 216)); // Mouse hover color
    }//GEN-LAST:event_LogoutbtnMouseEntered

    private void LogoutbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutbtnMouseExited
        PanelLogout.setBackground(new Color(0, 153, 153)); // Defualt color to mouse ext
    }//GEN-LAST:event_LogoutbtnMouseExited

    private void userbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userbtnMouseEntered
        //userbtn.setIcon(new ImageIcon(getClass().getResource("/images/userH.png"))); // Set Mouse hover image
    }//GEN-LAST:event_userbtnMouseEntered

    private void userbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userbtnMouseExited
        //userbtn.setIcon(new ImageIcon(getClass().getResource("/images/userN.png"))); // Set Mouse defualt image
    }//GEN-LAST:event_userbtnMouseExited

    private void CusAddBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CusAddBtnMouseEntered
        CusAddPanel.setBackground(new Color(82, 219, 115)); // Mouse hover color
    }//GEN-LAST:event_CusAddBtnMouseEntered

    private void CusAddBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CusAddBtnMouseExited
        CusAddPanel.setBackground(new Color(7, 182, 48)); // Defualt color to mouse ext
    }//GEN-LAST:event_CusAddBtnMouseExited

    private void CusAddBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CusAddBtnMousePressed
        // Mouse click animation for Pressed
        CusAddPanel.setSize(79, 29);
        CusAddPanel.setSize(79, 29);
    }//GEN-LAST:event_CusAddBtnMousePressed

    private void CusAddBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CusAddBtnMouseReleased
        // Mouse click animation for Released
        CusAddPanel.setSize(80, 30);
        CusAddPanel.setSize(80, 30);
    }//GEN-LAST:event_CusAddBtnMouseReleased

    private void SupAddBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupAddBtnMouseEntered
        SupAddPanel.setBackground(new Color(82, 219, 115)); // Mouse hover color
    }//GEN-LAST:event_SupAddBtnMouseEntered

    private void SupAddBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupAddBtnMouseExited
        SupAddPanel.setBackground(new Color(7, 182, 48)); // Defualt color to mouse ext
    }//GEN-LAST:event_SupAddBtnMouseExited

    private void SupAddBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupAddBtnMousePressed
        // Mouse click animation for Pressed
        SupAddPanel.setSize(79, 29);
        SupAddPanel.setSize(79, 29);
    }//GEN-LAST:event_SupAddBtnMousePressed

    private void SupAddBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupAddBtnMouseReleased
        // Mouse click animation for Released
        SupAddPanel.setSize(80, 30);
        SupAddPanel.setSize(80, 30);
    }//GEN-LAST:event_SupAddBtnMouseReleased

    private void CashierAddButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CashierAddButtonMouseClicked
        AddCashierBtnClick();
    }//GEN-LAST:event_CashierAddButtonMouseClicked

    private void CashierAddButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CashierAddButtonMouseEntered
        CashierAddPanel.setBackground(new Color(82, 219, 115)); // Mouse hover color
    }//GEN-LAST:event_CashierAddButtonMouseEntered

    private void CashierAddButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CashierAddButtonMouseExited
        CashierAddPanel.setBackground(new Color(7, 182, 48)); // Defualt color to mouse ext
    }//GEN-LAST:event_CashierAddButtonMouseExited

    private void CashierAddButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CashierAddButtonMousePressed
        // Mouse click animation for Pressed
        CashierAddPanel.setSize(79, 29);
        CashierAddPanel.setSize(79, 29);
    }//GEN-LAST:event_CashierAddButtonMousePressed

    private void CashierAddButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CashierAddButtonMouseReleased
        // Mouse click animation for Released
        CashierAddPanel.setSize(80, 30);
        CashierAddPanel.setSize(80, 30);
    }//GEN-LAST:event_CashierAddButtonMouseReleased

    private void ShellRptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShellRptBtnActionPerformed
        ReportButtonClick();
    }//GEN-LAST:event_ShellRptBtnActionPerformed

    private void BillRptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BillRptBtnActionPerformed
        DailyReportPanel.setVisible(false);
        BlReportPanel.setVisible(true);
        AllRptRadioButton.setSelected(true);
        ReturnCRptRadioButton.setSelected(false);
        BLCRptRadioButton.setSelected(false);
        MonthlyReportPanel.setVisible(false);
        DailyRadioButton.setVisible(false);
        RadioButtonMonthly.setVisible(false);
        hstCheckBox.setEnabled(false);
        rpt_getcus.setEnabled(false);
        rpt_cashier.setEnabled(false);
        rpt_getitem.setEnabled(false);
        BillSearchTextField.requestFocus();
        BillRptBtn.setBackground(new Color(0, 153, 51));
        ShellRptBtn.setBackground(new Color(51, 204, 0));
        RtLoad(0);
        bl_itemClear();

    }//GEN-LAST:event_BillRptBtnActionPerformed

    private void RadioButtonReSellingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonReSellingActionPerformed
        ReuenCus();
        ReturnItemTable.setRowSelectionAllowed(true);
    }//GEN-LAST:event_RadioButtonReSellingActionPerformed

    private void RadioButtonToSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonToSupplierActionPerformed
        ReuenSup();
        ReturnItemTable.setRowSelectionAllowed(false);
    }//GEN-LAST:event_RadioButtonToSupplierActionPerformed

    private void CusAddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CusAddBtnMouseClicked
        AddCustomerBtnClick();
    }//GEN-LAST:event_CusAddBtnMouseClicked

    private void OdrAddbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OdrAddbtnMouseClicked
        AddOrderBtnClick();
    }//GEN-LAST:event_OdrAddbtnMouseClicked

    private void SupAddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupAddBtnMouseClicked
        AddSupplierBtnClick();
    }//GEN-LAST:event_SupAddBtnMouseClicked

    private void item_SupIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_item_SupIDFocusLost
        String SupID = "";
        String itemSupIDCom = item_SupID.getSelectedItem().toString();

        try {
            String sqlload = "SELECT `Supplier ID` FROM supplier WHERE Name='" + itemSupIDCom + "'";
            Pstatement = conn.prepareStatement(sqlload);
            resualt = Pstatement.executeQuery();

            while (resualt.next()) {
                SupID = resualt.getString("Supplier ID");
                item_SupID.getEditor().setItem(SupID);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_item_SupIDFocusLost

    private void item_SupIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_SupIDActionPerformed
        item_AtQuantity.requestFocus();
    }//GEN-LAST:event_item_SupIDActionPerformed

    private void Order_ItemIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Order_ItemIDActionPerformed
        Order_Quantty.requestFocus();
    }//GEN-LAST:event_Order_ItemIDActionPerformed

    private void OrderDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderDeleteBtnActionPerformed
        int row = OrderTable.getSelectedRow();
        String ID = OrderTable.getValueAt(row, 0).toString();
        deleteValues("order", "Order ID", ID);
        OrderTableLoad();
        OdrSearchTextField.requestFocus();
    }//GEN-LAST:event_OrderDeleteBtnActionPerformed

    private void CustomerDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerDeleteBtnActionPerformed
        int row = CustomerTable.getSelectedRow();
        String ID = CustomerTable.getValueAt(row, 0).toString();
        deleteValues("customer", "Customer ID", ID);
        CustomerTableLoad();
        CustomerSearchTextField.requestFocus();
    }//GEN-LAST:event_CustomerDeleteBtnActionPerformed

    private void SupplierDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupplierDeleteBtnActionPerformed
        int row = SupplierTable.getSelectedRow();
        String ID = SupplierTable.getValueAt(row, 0).toString();
        deleteValues("supplier", "Supplier ID", ID);
        SupplierTableLoad();
        SupSearchTextField.requestFocus();
    }//GEN-LAST:event_SupplierDeleteBtnActionPerformed

    private void CashierDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CashierDeleteBtnActionPerformed
        int row = CashierTable.getSelectedRow();
        String ID = CashierTable.getValueAt(row, 0).toString();
        deleteValues("cashier", "Cashier ID", ID);
        try {
            sqlInst = "DELETE FROM `user_acct`  WHERE `user_acct`.`CaID` = '" + ID + "'";
            Pstatement = conn.prepareStatement(sqlInst);
            Pstatement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

        CashierTableLoad();
        CasSearchTextField.requestFocus();
    }//GEN-LAST:event_CashierDeleteBtnActionPerformed

    private void OrderEditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderEditBtnActionPerformed
        OdrAddbtn.setText("Update");

        int row = OrderTable.getSelectedRow();
        String OID = OrderTable.getValueAt(row, 0).toString();
        String SItemID = null;
        String SQuantty = null;
        String SPaiedAmount = null;

        sqlresualt = "SELECT `Item Name`, `Quantity`, `Paied Amount` FROM `order` WHERE `Order ID`='" + OID + "'";
        try {
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            while (resualt.next()) {
                SItemID = resualt.getString("Item Name");
                SQuantty = resualt.getString("Quantity");
                SPaiedAmount = resualt.getString("Paied Amount");
            }
            Order_ItemID.setSelectedItem(SItemID);
            Order_Quantty.setText(SQuantty);
            Order_PaiedAmount.setText(SPaiedAmount);
            Order_PaiedAmount.requestFocus();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_OrderEditBtnActionPerformed

    private void CustomerEditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerEditBtnActionPerformed
        CusAddBtn.setText("Update");

        int row = CustomerTable.getSelectedRow();
        String CID = CustomerTable.getValueAt(row, 0).toString();
        String CName = null;
        String CAds = null;
        String CContact = null;

        sqlresualt = "SELECT `Name`, `Address`, `Contact` FROM `customer` WHERE `Customer ID`='" + CID + "'";
        try {
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            while (resualt.next()) {
                CName = resualt.getString("Name");
                CAds = resualt.getString("Address");
                CContact = resualt.getString("Contact");
            }

            Customer_ID.setText(CID);
            Customer_Name.setText(CName);
            Customer_Adds.setText(CAds);
            Customer_Contact.setText(CContact);
            Customer_Contact.requestFocus();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_CustomerEditBtnActionPerformed

    private void SupplierEditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupplierEditBtnActionPerformed
        SupAddBtn.setText("Update");

        int row = SupplierTable.getSelectedRow();
        String SID = SupplierTable.getValueAt(row, 0).toString();
        String SupplierDC = null;
        String SName = null;
        String SAds = null;
        String SContact = null;

        sqlresualt = "SELECT `Name`, `Address`, `Contact`, `Discription` FROM `Supplier` WHERE `Supplier ID`='" + SID + "'";
        try {
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            while (resualt.next()) {
                SName = resualt.getString("Name");
                SAds = resualt.getString("Address");
                SContact = resualt.getString("Contact");
                SupplierDC = resualt.getString("Discription");
            }

            Supplier_ID.setText(SID);
            Supplier_Name.setText(SName);
            Supplier_Adds.setText(SAds);
            Supplier_Contact.setText(SContact);
            Supplier_Discription.setText(SupplierDC);
            Supplier_Contact.requestFocus();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_SupplierEditBtnActionPerformed

    private void CashierEditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CashierEditBtnActionPerformed
        CashierAddButton.setText("Update");

        int row = CashierTable.getSelectedRow();
        String CaID = CashierTable.getValueAt(row, 0).toString();
        String CName = null;
        String CAds = null;
        String CContact = null;

        sqlresualt = "SELECT `Name`, `Address`, `Contact` FROM `cashier` WHERE `Cashier ID`='" + CaID + "'";
        try {
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            while (resualt.next()) {
                CName = resualt.getString("Name");
                CAds = resualt.getString("Address");
                CContact = resualt.getString("Contact");
            }

            Cashier_ID.setText(CaID);
            Cashier_Name.setText(CName);
            Cashier_Adds.setText(CAds);
            Cashier_Contact.setText(CContact);
            Cashier_Contact.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_CashierEditBtnActionPerformed

    private void CasSearchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CasSearchTextFieldKeyReleased
        String CaStext = CasSearchTextField.getText();

        try {
            String sql = "SELECT `Cashier ID`, `Name`, `Address`, `Contact` FROM cashier WHERE `Cashier ID` LIKE '" + CaStext + "' OR `Name` LIKE '%" + CaStext + "%' OR `Contact` LIKE '" + CaStext + "'";
            Pstatement = conn.prepareStatement(sql);
            resualt = Pstatement.executeQuery();
            CashierTable.setModel(DbUtils.resultSetToTableModel(resualt));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_CasSearchTextFieldKeyReleased

    private void SupSearchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SupSearchTextFieldKeyReleased
        String SupStext = SupSearchTextField.getText();
        String sql = "SELECT `Supplier ID`, `Name`, `Address`, `Contact`, `Discription` FROM supplier WHERE `Supplier ID` LIKE '" + SupStext + "' OR `Name` LIKE '%" + SupStext + "%' OR `Contact` LIKE '" + SupStext + "'";

        try {
            Pstatement = conn.prepareStatement(sql);
            resualt = Pstatement.executeQuery();
            SupplierTable.setModel(DbUtils.resultSetToTableModel(resualt));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_SupSearchTextFieldKeyReleased

    private void CustomerSearchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CustomerSearchTextFieldKeyReleased
        String CusStext = CustomerSearchTextField.getText();
        String sql = "SELECT `Customer ID`, `Name`, `Address`, `Contact` FROM customer WHERE `Customer ID` = '" + CusStext + "' OR `Name` LIKE '%" + CusStext + "%' OR `Contact` LIKE '" + CusStext + "'";

        try {
            Pstatement = conn.prepareStatement(sql);
            resualt = Pstatement.executeQuery();
            CustomerTable.setModel(DbUtils.resultSetToTableModel(resualt));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_CustomerSearchTextFieldKeyReleased

    private void OdrSearchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_OdrSearchTextFieldKeyReleased
        String OdrStext = OdrSearchTextField.getText();
        String sql = "SELECT `Order ID`, `Item Name`, `Quantity`,  DATE_FORMAT(`Date & Time`,'%Y-%m-%d     %h:%i %p') AS 'Date & Time', FORMAT(`Paied Amount`,2) AS 'Paied Amount' FROM `order` WHERE `Order ID` LIKE '" + OdrStext + "' OR `Item Name` LIKE '" + OdrStext + "'";

        try {
            Pstatement = conn.prepareStatement(sql);
            resualt = Pstatement.executeQuery();
            OrderTable.setModel(DbUtils.resultSetToTableModel(resualt));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
        if ("".equals(OdrStext)) {
            OrderTableLoad();
        }
    }//GEN-LAST:event_OdrSearchTextFieldKeyReleased

    private void ItemSearchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ItemSearchTextFieldKeyReleased
        if ("(admin)".equals(admin_text.getText())) {
            String ItemStext = ItemSearchTextField.getText();
            sqlInst = "SELECT `Item ID`, `Item Name`, FORMAT(`item`.`Buying Price (Rs.)`,2) AS 'Buying Price (Rs.)', FORMAT(`item`.`Selling Price (Rs.)`,2) AS 'Selling Price (Rs.)', `Quantity`, `Alert Quantity` FROM item WHERE `Item ID` LIKE '" + ItemStext + "' OR `Item Name` LIKE '%" + ItemStext + "%' OR `Supplier ID` LIKE '" + ItemStext + "'";
        } else {
            String ItemStext = ItemSearchTextField.getText();
            sqlInst = "SELECT `Item ID`, `Item Name`, FORMAT(`item`.`Selling Price (Rs.)`,2) AS 'Price (Rs.)', `Quantity`, `Alert Quantity` FROM item WHERE `Item ID` LIKE '" + ItemStext + "' OR `Item Name` LIKE '%" + ItemStext + "%' OR `Supplier ID` LIKE '" + ItemStext + "'";
        }

        try {
            Pstatement = conn.prepareStatement(sqlInst);
            resualt = Pstatement.executeQuery();
            ItemTable.setModel(DbUtils.resultSetToTableModel(resualt));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_ItemSearchTextFieldKeyReleased

    private void SupGetItemsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupGetItemsBtnActionPerformed
        int row = SupplierTable.getSelectedRow();
        String ID = SupplierTable.getValueAt(row, 0).toString();

        ItemButtonClick();

        String sql = "SELECT `Item ID`, `Item Name`, FORMAT(`item`.`Buying Price (Rs.)`,2) AS 'Buying Price (Rs.)', FORMAT(`item`.`Selling Price (Rs.)`,2) AS 'Selling Price (Rs.)', `Quantity`, `Alert Quantity` FROM item WHERE  `Supplier ID` = '" + ID + "'";
        try {
            Pstatement = conn.prepareStatement(sql);
            resualt = Pstatement.executeQuery();
            ItemTable.setModel(DbUtils.resultSetToTableModel(resualt));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
        ItemSearchTextField.setText(ID);
    }//GEN-LAST:event_SupGetItemsBtnActionPerformed

    private void OrderGetItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderGetItemBtnActionPerformed
        int row = OrderTable.getSelectedRow();
        String item_name = OrderTable.getValueAt(row, 1).toString();

        ItemButtonClick();

        String sql = "SELECT `Item ID`, `Item Name`, FORMAT(`item`.`Buying Price (Rs.)`,2) AS 'Buying Price (Rs.)', FORMAT(`item`.`Selling Price (Rs.)`,2) AS 'Selling Price (Rs.)', `Quantity`, `Alert Quantity` FROM item WHERE `Item Name` = '" + item_name + "'";
        try {
            Pstatement = conn.prepareStatement(sql);
            resualt = Pstatement.executeQuery();
            ItemTable.setModel(DbUtils.resultSetToTableModel(resualt));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
        ItemSearchTextField.setText(item_name);
    }//GEN-LAST:event_OrderGetItemBtnActionPerformed

    private void OrderGetSupplierBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderGetSupplierBtnActionPerformed
        int row = OrderTable.getSelectedRow();
        String item_name = OrderTable.getValueAt(row, 1).toString();
        String sup_id = "";

        String sql = "SELECT `Supplier ID` FROM item WHERE `Item Name` = '" + item_name + "'";
        try {
            Pstatement = conn.prepareStatement(sql);
            resualt = Pstatement.executeQuery();
            while (resualt.next()) {
                sup_id = resualt.getString("Supplier ID");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
        SupplierButtonClick();
        sql = "SELECT `Supplier ID`, `Name`, `Address`, `Contact`, `Discription` FROM supplier WHERE `Supplier ID` LIKE '" + sup_id + "'";
        try {
            Pstatement = conn.prepareStatement(sql);
            resualt = Pstatement.executeQuery();
            SupplierTable.setModel(DbUtils.resultSetToTableModel(resualt));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
        SupSearchTextField.setText(sup_id);
    }//GEN-LAST:event_OrderGetSupplierBtnActionPerformed

    private void ButtonAddToBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonAddToBillMouseEntered
        ButtonAddToBill.setBackground(new Color(82, 219, 115)); // Mouse hover color
    }//GEN-LAST:event_ButtonAddToBillMouseEntered

    private void ButtonAddToBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonAddToBillMouseExited
        ButtonAddToBill.setBackground(new Color(7, 182, 48)); // Defualt color to mouse ext
    }//GEN-LAST:event_ButtonAddToBillMouseExited

    private void ButtonPayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPayMouseEntered
        ButtonPay.setBackground(new Color(0, 153, 255)); // Mouse hover color
    }//GEN-LAST:event_ButtonPayMouseEntered

    private void ButtonPayMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPayMouseExited
        ButtonPay.setBackground(new Color(0, 102, 204)); // Defualt color to mouse ext
    }//GEN-LAST:event_ButtonPayMouseExited

    private void ButtonAddToBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddToBillActionPerformed
        String UserInput_ItemID = ComboBoxBillingItemID.getText().toString();

        if (UserInput_ItemID.equals("") && TextFieldBillingQuantity.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter item id or name & quantity", "Shop Management System", JOptionPane.WARNING_MESSAGE);
            ComboBoxBillingItemID.requestFocus();
        } else if (UserInput_ItemID.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter item id or name", "Shop Management System", JOptionPane.WARNING_MESSAGE);
            ComboBoxBillingItemID.requestFocus();
        } else if (TextFieldBillingQuantity.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter quantity", "Shop Management System", JOptionPane.WARNING_MESSAGE);
            TextFieldBillingQuantity.requestFocus();
        } else {
            String ItemID = "";
            String ItemName = "";
            int UserInput_Qty = Integer.valueOf(TextFieldBillingQuantity.getText());
            float UnitPrice = 0;
            float UnitBuyPrice = 0;
            float Discount = 0;
            int AvailableQty = 0;

            if (!"".equals(TextFieldDiscountPerUnit.getText())) {
                Discount = Float.valueOf(TextFieldDiscountPerUnit.getText());
            }

            try {
                sqlresualt = "SELECT `Item ID`, `Item Name`, `Quantity`, `Buying Price (Rs.)`, `Selling Price (Rs.)` FROM item WHERE `Item ID`='" + UserInput_ItemID + "' OR `Item Name`='" + UserInput_ItemID + "'";
                Pstatement = conn.prepareStatement(sqlresualt);
                resualt = Pstatement.executeQuery();
                while (resualt.next()) {
                    AvailableQty = resualt.getInt("Quantity");
                    UnitPrice = resualt.getFloat("Selling Price (Rs.)");
                    UnitBuyPrice = resualt.getFloat("Buying Price (Rs.)");
                    ItemID = resualt.getString("Item ID");
                    ItemName = resualt.getString("Item Name");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
            }

            if (ItemID.equals("")) {
                JOptionPane.showMessageDialog(null, "Wrong item id or name !", "Shop Management System", JOptionPane.WARNING_MESSAGE);
                ComboBoxBillingItemID.requestFocus();
            } else if (UserInput_Qty < 1) {
                JOptionPane.showMessageDialog(null, "Invalied quantity !", "Shop Management System", JOptionPane.WARNING_MESSAGE);
                TextFieldBillingQuantity.requestFocus();
            } else if (AvailableQty == 0) {
                JOptionPane.showMessageDialog(null, "Out of stokcs !", "Shop Management System", JOptionPane.WARNING_MESSAGE);
                ComboBoxBillingItemID.requestFocus();
            } else if (UserInput_Qty > AvailableQty) {
                JOptionPane.showMessageDialog(null, "Item ID: " + ItemID + " available quantity less than " + UserInput_Qty + "\n                 (Available = " + AvailableQty + ")", "Shop Management System", JOptionPane.WARNING_MESSAGE);
                TextFieldBillingQuantity.requestFocus();
            } else if (Discount > UnitPrice || Discount < 0) {
                JOptionPane.showMessageDialog(null, "Invalied Discount!", "Shop Management System", JOptionPane.WARNING_MESSAGE);
                TextFieldDiscountPerUnit.requestFocus();
            } else {
                if (!ButtonCancelItem.isEnabled()) {
                    //BillID = "";
                    BillID = "BL" + LocalDate.now().getYear() + LocalDate.now().getDayOfYear() + LocalTime.now().getHour() + LocalTime.now().getMinute() + LocalTime.now().getSecond();
                }
                if (BillID.equals("")) {
                    ButtonCancelItem.doClick();
                    JOptionPane.showMessageDialog(null, "Something Error!\nPlease re-enter bill", "Shop Management System", JOptionPane.WARNING_MESSAGE);
                } else {
                    float ItemTotalPrice = UnitPrice * UserInput_Qty;
                    ItemTotalPrice = ConvertToCurrencyValue(ItemTotalPrice);
                    Total += ItemTotalPrice;
                    LabelTotal.setText("Rs. " + ConvertToCurrency(Total));
                    float TotalDiscount = 0;

                    if (Discount > 0) {
                        Discount = ConvertToCurrencyValue(Discount);

                        TotalDiscount = Discount * UserInput_Qty;
                        TotalDiscount = ConvertToCurrencyValue(TotalDiscount);
                        NetDiscount += TotalDiscount;

                        LabelDiscount.setText("Rs. " + ConvertToCurrency(NetDiscount));
                        NetDiscount = ConvertToCurrencyValue(NetDiscount);
                        TextFieldDiscountPerUnit.setText("");
                    }

                    NetTotal += ItemTotalPrice - TotalDiscount;
                    NetTotal = ConvertToCurrencyValue(NetTotal);

                    //Item net total
                    float ItemNetTotal = ConvertToCurrencyValue(ItemTotalPrice - TotalDiscount);

                    try {
                        //Insert new data to DB  
                        sqlInst = "INSERT INTO `billitem` (`Bill ID`, `Item ID`, `Item Name`, `Buying Price (Rs.)`, `Selling Price (Rs.)`, `Price (Rs.)`,`Quantity`,`Total (Rs.)`,`Discount (Rs.)`,`Net Total (Rs.)`,`Complete`) VALUES('" + BillID + "','" + ItemID + "','" + ItemName + "','" + UnitBuyPrice + "','" + UnitPrice + "','" + (UnitPrice - Discount) + "','" + UserInput_Qty + "','" + ItemTotalPrice + "','" + TotalDiscount + "','" + ItemNetTotal + "','1')";
                        Pstatement = conn.prepareStatement(sqlInst);
                        Pstatement.execute();
                    } catch (SQLException e) //update bill item
                    {
                        try {
                            float CurrentItemTotalPrice = 0;
                            float CurrentItemNetTotalPrice = 0;
                            float CurrentItemDiscountPrice = 0;
                            sqlresualt = "SELECT `Total (Rs.)`, `Net Total (Rs.)`, `Discount (Rs.)` FROM `billitem` WHERE `Bill ID` = '" + BillID + "' AND `Item ID` = '" + ItemID + "'";
                            Pstatement = conn.prepareStatement(sqlresualt);
                            resualt = Pstatement.executeQuery();
                            while (resualt.next()) {
                                CurrentItemTotalPrice = resualt.getFloat("Total (Rs.)");
                                CurrentItemNetTotalPrice = resualt.getFloat("Net Total (Rs.)");
                                CurrentItemDiscountPrice = resualt.getFloat("Discount (Rs.)");
                            }

                            CurrentItemTotalPrice += ItemTotalPrice;
                            CurrentItemNetTotalPrice += ItemNetTotal;
                            CurrentItemDiscountPrice += TotalDiscount;

                            CurrentItemTotalPrice = ConvertToCurrencyValue(CurrentItemTotalPrice);
                            CurrentItemNetTotalPrice = ConvertToCurrencyValue(CurrentItemNetTotalPrice);
                            CurrentItemDiscountPrice = ConvertToCurrencyValue(CurrentItemDiscountPrice);

                            //Update bill item
                            sqlInst = "UPDATE `billitem` SET  `Quantity` = `billitem`.`Quantity`+'" + UserInput_Qty + "', `Total (Rs.)` = '" + CurrentItemTotalPrice + "', `Discount (Rs.)` = + " + CurrentItemDiscountPrice + ", `Net Total (Rs.)` =" + CurrentItemNetTotalPrice + " WHERE `Item ID` = '" + ItemID + "' AND `Bill ID` = '" + BillID + "' ";
                            Pstatement = conn.prepareStatement(sqlInst);
                            Pstatement.execute();
                        } catch (SQLException ex) {
                            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (RadioButtonCash.isSelected()) {
                        BlanceCal();
                    }
                    BLItemTableLoad(BillID);
                    TextFieldCash.setEnabled(true);
                    ButtonCancelItem.setEnabled(true);

                    //New stock quantity
                    AvailableQty -= UserInput_Qty;
                    try {
                        //Update data to DB  
                        sqlInst = "UPDATE `item` SET  `Quantity` = '" + AvailableQty + "' WHERE `item`.`Item ID` = '" + ItemID + "' ";
                        Pstatement = conn.prepareStatement(sqlInst);
                        Pstatement.execute();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex, "Shop Management System", JOptionPane.WARNING_MESSAGE);
                    }

                    if (!"No new notifications".equals(TextAreaNotifications.getText())) {
                        TextAreaNotifications.setText("");
                    }
                    try {
                        sqlresualt = "SELECT `Item ID` FROM `item`";
                        Pstatement = conn.prepareStatement(sqlresualt);
                        ResultSet r = Pstatement.executeQuery();
                        while (r.next()) {
                            String itmid = r.getString("Item ID");
                            alert_qty(itmid);
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
                    }
                    int n = TabelBilling.getRowCount();
                    LabelItem.setText(String.valueOf(n));
                    LabelNetTotal.setText("Rs. " + ConvertToCurrency(NetTotal));
                    ComboBoxBillingItemID.setText("");
                    TextFieldBillingQuantity.setText("1");
                    LabelBillingBillID.setText("Bill ID: " + String.valueOf(BillID));
                    ComboBoxBillingItemID.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_ButtonAddToBillActionPerformed

    private void BillTabel_InsertData() {
        String CusID = ComboBoxCustermer.getSelectedItem().toString();
        String PayMothod = "Cash";
        if ("Select".equals(CusID)) {
            CusID = "";
        }
        if (RadioButtonCard.isSelected()) {
            PayMothod = "Card/ C.O. Delivery";
        }
        String DateTime = LocalDate.now().getYear() + "-" + LocalDate.now().getMonthValue() + "-" + LocalDate.now().getDayOfMonth() + " " + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond();
        float Cash = NetTotal;
        if (RadioButtonCash.isSelected()) {
            Cash = Float.valueOf(TextFieldCash.getText());
        }
        sqlInst = "INSERT INTO `bill` (`Bill ID`,`User Name`, `Customer ID`, `Date & Time`, `Total (Rs.)`,`Discount (Rs.)`, `Net Total (Rs.)`, `Payment Method`, `Cash (Rs.)`, `Balance (Rs.)`) VALUES('" + BillID + "','" + LabelUserName.getText() + "','" + CusID + "','" + DateTime + "','" + Total + "','" + NetDiscount + "','" + NetTotal + "','" + PayMothod + "','" + Cash + "','0')";
        try {
            //Insert new data to DB  
            Pstatement = conn.prepareStatement(sqlInst);
            Pstatement.execute();
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
    }
    private void TextFieldBillingQuantityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldBillingQuantityKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ButtonAddToBill.doClick();
        } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            TextFieldDiscountPerUnit.requestFocus();
        }
    }//GEN-LAST:event_TextFieldBillingQuantityKeyPressed

    public String get_price() {
        String prce = "";
        try {
            sqlresualt = "SELECT `Quantity`, `Selling Price (Rs.)` FROM item WHERE `Item ID`='" + ComboBoxBillingItemID.getText().toString() + "' OR `Item Name`='" + ComboBoxBillingItemID.getText().toString() + "'";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            while (resualt.next()) {
                prce = resualt.getString("Selling Price (Rs.)");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
        return prce;
    }


    private void ButtonPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPayActionPerformed
        if (ButtonCancelItem.isEnabled()) {
            if (RadioButtonCard.isSelected()) {
                BillTabel_InsertData();
                if (NetDiscount > 0) {
                    BillPrintCardDiscount(BillID);
                } else {
                    BillPrintCardNormal(BillID);
                }
                PaymentFinish();
            } else if (RadioButtonCash.isSelected() && !(TextFieldCash.getText().isEmpty())) {
                String Balance = LabelBalanceDisplayBalance.getText().replace("Rs. ", "");
                Balance = Balance.replace(",", "");
                float BalanceValue = Float.valueOf(Balance);
                BillTabel_InsertData();
                if (BalanceValue >= 0) {
                    if (NetDiscount > 0) {
                        BillPrintCashDiscount(BillID);
                    } else {
                        BillPrintCashNormal(BillID);
                    }
                    PaymentFinish();
                } else {

                    try//Set Balance to Bill
                    {
                        sqlInst = "UPDATE `bill` SET `Balance (Rs.)` = '" + BalanceValue + "' WHERE `Bill ID` = '" + BillID + "'";
                        Pstatement = conn.prepareStatement(sqlInst);
                        Pstatement.execute();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
                    }
                    if (ComboBoxCustermer.getSelectedIndex() != 0) {
                        try//Set Balance to Bill
                        {
                            sqlInst = "UPDATE `bill` SET `Customer ID` = '" + ComboBoxCustermer.getSelectedItem().toString() + "' WHERE `Bill ID` = '" + BillID + "'";
                            Pstatement = conn.prepareStatement(sqlInst);
                            Pstatement.execute();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
                        }
                        if (NetDiscount > 0) {
                            BillPrintCashDiscount(BillID);
                        } else {
                            BillPrintCashNormal(BillID);
                        }
                        PaymentFinish();
                    } else {
                        int CusBalanceBtnResualt = JOptionPane.showConfirmDialog(this, "Customer balance.\nDo you want to add customer details?", "Shop Management System", JOptionPane.YES_NO_OPTION);
                        if (CusBalanceBtnResualt == 0) {
                            CustomerButtonClick();
                        } else {
                            if (NetDiscount > 0) {
                                BillPrintCashDiscount(BillID);
                            } else {
                                BillPrintCashNormal(BillID);
                            }
                            PaymentFinish();
                        }
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Please enter cash", "Shop Management System", JOptionPane.WARNING_MESSAGE);
                TextFieldCash.requestFocus();
            }
        }
    }//GEN-LAST:event_ButtonPayActionPerformed

    public void PaymentFinish() {
        try {
            sqlInst = "UPDATE `billitem` SET `Complete`= 0 WHERE `Bill ID` = '" + BillID + "' ";
            Pstatement = conn.prepareStatement(sqlInst);
            Pstatement.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

        DefaultTableModel dm = (DefaultTableModel) TabelBilling.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
        }
        TextFieldCash.setEnabled(false);
        ButtonRemoveBill.setEnabled(false);
        ButtonCancelItem.setEnabled(false);
        LabelBillingBillID.setText("Bill ID: ");
        LabelNetTotal.setText("Rs. 0.00");
        LabelBalanceDisplayBalance.setText("Rs. 0.00");
        LabelDiscount.setText("Rs. 0.00");
        LabelTotal.setText("Rs. 0.00");
        TextFieldCash.setText("");
        LabelItem.setText("0");
        ComboBoxBillingItemID.requestFocus();
        ComboBoxCustermer.setSelectedIndex(0);
        BillID = "";
        Total = 0;
        NetDiscount = 0;
        NetTotal = 0;
    }

    private void BLCRptRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLCRptRadioButtonActionPerformed
        BLCRptRadioButton.setSelected(true);
        ReturnCRptRadioButton.setSelected(false);
        BLCRptRadioButton1.setSelected(false);
        AllRptRadioButton.setSelected(false);
        hstCheckBox.setSelected(false);
        hstCheckBox.setEnabled(false);
        fullbillrtlabel.setVisible(false);
        try {
            String sqlload = "SELECT `Bill ID`, DATE_FORMAT(`Date & Time`,'%Y-%m-%d       %h:%i %p') AS 'Date & Time', FORMAT(`bill`.`Total (Rs.)`,2) AS 'Total (Rs.)', FORMAT(`bill`.`Discount (Rs.)`,2) AS 'Discount (Rs.)', FORMAT(`bill`.`Net Total (Rs.)`,2) AS 'Net Total (Rs.)', FORMAT(`Balance (Rs.)`,2) AS 'Balance (Rs.)', `Payment Method` FROM `bill` WHERE `Payment Method` LIKE 'Cash' ORDER BY `bill`.`Date & Time` DESC";
            Pstatement = conn.prepareStatement(sqlload);
            resualt = Pstatement.executeQuery();
            PurchaseBillTable.setModel(DbUtils.resultSetToTableModel(resualt));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

        bl_itemClear();
        //RprtItemLoad();
    }//GEN-LAST:event_BLCRptRadioButtonActionPerformed

    public void bl_itemClear() {
        sqlresualt = "SELECT `billitem`.`Item ID`, FORMAT(`billitem`.`Selling Price (Rs.)`,2) AS 'Price (Rs.)', `billitem`.`Quantity`, FORMAT(`billitem`.`Total (Rs.)`,2) AS 'Total (Rs.)', FORMAT(`billitem`.`Discount (Rs.)`,2) AS 'Discount (Rs.)', FORMAT(`billitem`.`Net Total (Rs.)`,2) AS 'Net Total (Rs.)' FROM `billitem`, `item` WHERE `Bill ID` = 'tdx/' AND `item`.`Item ID` = 'k' ORDER BY `billitem`.`Item ID` ASC";
        try {
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            PurchaseItemTable.setModel(DbUtils.resultSetToTableModel(resualt));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
        rpt_cashier.setEnabled(false);
        rpt_getcus.setEnabled(false);
        rpt_getitem.setEnabled(false);
    }
    private void AllRptRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllRptRadioButtonActionPerformed
        AllRptRadioButton.setSelected(true);
        ReturnCRptRadioButton.setSelected(false);
        BLCRptRadioButton.setSelected(false);
        BLCRptRadioButton1.setSelected(false);
        hstCheckBox.setSelected(false);
        hstCheckBox.setEnabled(false);
        LabeItemSelected.setEnabled(false);

        RtLoad(0);
        bl_itemClear();
    }//GEN-LAST:event_AllRptRadioButtonActionPerformed

    private void TextFieldCashKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldCashKeyReleased
        BlanceCal();
    }//GEN-LAST:event_TextFieldCashKeyReleased

    private void Settings_BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Settings_BtnMouseClicked
        if ("(admin)".equals(admin_text.getText())) {
            String caid = "";
            int a = ComboBox_Cashieruserselect.getItemCount();
            a -= 1;
            while (a != 0) {
                ComboBox_Cashieruserselect.removeItemAt(a);
                a -= 1;
            }

            try {
                String sqlload = "SELECT `Cashier ID` FROM cashier";
                Pstatement = conn.prepareStatement(sqlload);
                resualt = Pstatement.executeQuery();

                while (resualt.next()) {
                    caid = resualt.getString("Cashier ID");
                    ComboBox_Cashieruserselect.addItem(caid);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
            }
            UserLoad();
            userAcct_btn.setEnabled(true);
            database_btn.setEnabled(true);
            user_act.setVisible(true);
            about.setVisible(false);

            userAcct_btn.setColorText(new Color(0, 0, 0));
            userAcct_btn.setColorTextHover(new Color(0, 0, 0));
            userAcct_btn.setBackground(new Color(255, 253, 242));
            userAcct_btn.setColorHover(new Color(255, 253, 242));
        } else {
            userAcct_btn.setEnabled(false);
            database_btn.setEnabled(false);
            Database.setEnabled(false);
            user_act.setEnabled(false);
            Database.setVisible(false);
            user_act.setVisible(false);
            about.setVisible(true);

            about_btn.setColorText(new Color(0, 0, 0));
            about_btn.setColorTextHover(new Color(0, 0, 0));
            about_btn.setBackground(new Color(255, 253, 242));
            about_btn.setColorHover(new Color(255, 253, 242));
        }
        Database.setVisible(false);
        PanelHome.setVisible(false);
        Panelhide();
        PanelSettings.setVisible(true);

    }//GEN-LAST:event_Settings_BtnMouseClicked

    private void RadioButton_CashierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButton_CashierActionPerformed
        RadioButton_Admin.setSelected(false);
        ComboBox_Cashieruserselect.setEnabled(true);
        Label_CashierUserAcct.setEnabled(true);
    }//GEN-LAST:event_RadioButton_CashierActionPerformed

    private void RadioButton_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButton_AdminActionPerformed
        RadioButton_Cashier.setSelected(false);
        ComboBox_Cashieruserselect.setEnabled(false);
        Label_CashierUserAcct.setEnabled(false);
    }//GEN-LAST:event_RadioButton_AdminActionPerformed

    private void TextFieldDiscountPerUnitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldDiscountPerUnitKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ButtonAddToBill.doClick();
        }
    }//GEN-LAST:event_TextFieldDiscountPerUnitKeyPressed

    private void ButtonAddReturnQTYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddReturnQTYActionPerformed
        String day = String.valueOf(LocalDate.now().getDayOfMonth());
        String month = String.valueOf(LocalDate.now().getMonthValue());

        if (LocalDate.now().getDayOfMonth() < 10) {
            day = "0" + String.valueOf(LocalDate.now().getDayOfMonth());
        }
        if (LocalDate.now().getMonthValue() < 10) {
            month = "0" + String.valueOf(LocalDate.now().getMonthValue());
        }
        String DnT = LocalDate.now().getYear() + "-" + month + "-" + day;
        String date = ReturnBillTable.getValueAt(ReturnBillTable.getSelectedRow(), 1).toString();
        String[] parts = date.split(" ");
        date = parts[0];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        long days = 0;
        try {
            Date firstDate = sdf.parse(date);
            Date secondDate = sdf.parse(DnT);

            long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
            days = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        } catch (java.text.ParseException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (days < 8 || "(admin)".equals(admin_text.getText())) {
            int ReturnQty = 0;
            int ItemID = Integer.valueOf(ReturnItemTable.getValueAt(ReturnItemTable.getSelectedRow(), 0).toString());
            BillID = ReturnBillTable.getValueAt(ReturnBillTable.getSelectedRow(), 0).toString();// Get bill ID from selected row
            int Qty = Integer.valueOf(ReturnItemTable.getValueAt(ReturnItemTable.getSelectedRow(), 1).toString());
            if (!(TextFieldReturnQTY.getText().isEmpty())) {
                ReturnQty = Integer.valueOf(TextFieldReturnQTY.getText());
            }

            if (Qty == 0) {
                JOptionPane.showMessageDialog(null, "This item is aleady returned", "Shop Management System", JOptionPane.WARNING_MESSAGE);
            } else if (Qty < ReturnQty || ReturnQty < 1) {
                JOptionPane.showMessageDialog(null, "Please enter valied quantity", "Shop Management System", JOptionPane.WARNING_MESSAGE);
            } else {
                String ItemName = null;
                sqlresualt = "SELECT `Item Name` FROM `billitem` WHERE `Bill ID` = '" + BillID + "' AND `Item ID` = '" + ItemID + "'";
                try {
                    Pstatement = conn.prepareStatement(sqlresualt);
                    resualt = Pstatement.executeQuery();
                    while (resualt.next()) {
                        ItemName = resualt.getString("Item Name");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
                }

                if (ItemName.equals("") || ItemName.equals(null)) {
                    sqlresualt = "SELECT `Item Name` FROM item WHERE `Item ID` LIKE '" + ItemID + "'";
                    try {
                        Pstatement = conn.prepareStatement(sqlresualt);
                        resualt = Pstatement.executeQuery();
                        while (resualt.next()) {
                            ItemName = resualt.getString("Item Name");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
                    }
                }

                ReturnItemNames_Qty.put(ItemName, ReturnQty);
                ButtonReturnQTY.setEnabled(true);
                ButtonReturnReset.setEnabled(true);
                JOptionPane.showMessageDialog(null, ItemName + " * " + ReturnQty + " Added to return", "Shop Management System", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Retrun Time Period Ended", "Shop Management System", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_ButtonAddReturnQTYActionPerformed

    private void Settings_BtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Settings_BtnMouseExited
        //Settings_Btn.setIcon(new ImageIcon(getClass().getResource("/images/Settings_ExitMouse.png"))); // Set Mouse defualt image
    }//GEN-LAST:event_Settings_BtnMouseExited

    private void Settings_BtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Settings_BtnMouseEntered
        //Settings_Btn.setIcon(new ImageIcon(getClass().getResource("/images/Settings_EnterMouse.png"))); // Set Mouse Enter image
    }//GEN-LAST:event_Settings_BtnMouseEntered

    private void ButtonReturnBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonReturnBillActionPerformed
        String day = String.valueOf(LocalDate.now().getDayOfMonth());
        String month = String.valueOf(LocalDate.now().getMonthValue());

        if (LocalDate.now().getDayOfMonth() < 10) {
            day = "0" + String.valueOf(LocalDate.now().getDayOfMonth());
        }
        if (LocalDate.now().getMonthValue() < 10) {
            month = "0" + String.valueOf(LocalDate.now().getMonthValue());
        }
        String DnT = LocalDate.now().getYear() + "-" + month + "-" + day;
        String date = ReturnBillTable.getValueAt(ReturnBillTable.getSelectedRow(), 1).toString();
        String[] parts = date.split(" ");
        date = parts[0];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        long days = 0;
        try {
            Date firstDate = sdf.parse(date);
            Date secondDate = sdf.parse(DnT);

            long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
            days = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        } catch (java.text.ParseException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (days < 8 || "(admin)".equals(admin_text.getText())) {
            ReturnItemNames_Qty.clear();
            //ReturnItemNames_Price.clear();
            String PaymentType = ReturnBillTable.getValueAt(ReturnBillTable.getSelectedRow(), 6).toString();
            BillID = ReturnBillTable.getValueAt(ReturnBillTable.getSelectedRow(), 0).toString();
            ReturnTotal = ReturnBillTable.getValueAt(ReturnBillTable.getSelectedRow(), 4).toString();
            try {
                sqlInst = "DELETE FROM return_bill_temp";
                Pstatement = conn.prepareStatement(sqlInst);
                Pstatement.execute();

                float Balance = 0;
                for (int i = 0; i < ReturnItemTable.getRowCount(); i++) {
                    String ItemName = null;
                    String ItemID = ReturnItemTable.getValueAt(i, 0).toString();
                    sqlresualt = "SELECT `Item Name` FROM `billitem` WHERE `Bill ID` = '" + BillID + "' AND `Item ID` = '" + ItemID + "'";
                    try {
                        Pstatement = conn.prepareStatement(sqlresualt);
                        resualt = Pstatement.executeQuery();
                        while (resualt.next()) {
                            ItemName = resualt.getString("Item Name");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
                    }

                    if (ItemName.equals("") || ItemName.equals(null)) {
                        sqlresualt = "SELECT `Item Name` FROM item WHERE `Item ID` LIKE '" + ItemID + "'";
                        try {
                            Pstatement = conn.prepareStatement(sqlresualt);
                            resualt = Pstatement.executeQuery();
                            while (resualt.next()) {
                                ItemName = resualt.getString("Item Name");
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    if (Integer.valueOf(ReturnItemTable.getValueAt(i, 1).toString()) > 0) {
                        ReturnItemNames_Qty.put(ItemName, Integer.valueOf(ReturnItemTable.getValueAt(i, 1).toString()));
                    }
                }

                for (String key : ReturnItemNames_Qty.keySet()) {
                    Balance += ReturnItem(ReturnItemNames_Qty.get(key), key);
                }
                if (Balance >= 0) {
                    ReturnBalance = "Rs. " + ConvertToCurrency(Balance);
                } else {
                    ReturnBalance = "Rs. -" + ConvertToCurrency(Balance);
                }

                BillPrintReturn(BillID);

                ReturnItemNames_Qty.clear();
                //ReturnItemNames_Price.clear();
                RtLoad(1);
                JOptionPane.showMessageDialog(null, "Return successfull\nCustomer Balance = " + ReturnBalance, "Shop Management System", JOptionPane.INFORMATION_MESSAGE);
                ReturnNetTotal = "";
                ReturnTotal = "";
                ReturnBalance = "";
                BillID = "";

                try {
                    sqlresualt = "SELECT `Item ID`, `Quantity`, FORMAT(`Total (Rs.)`,2) AS 'Total (Rs.)', FORMAT(`Discount (Rs.)`,2) AS 'Discount (Rs.)', FORMAT(`Net Total (Rs.)`,2) AS 'Net Total (Rs.)' FROM `billitem` WHERE `Bill ID` = ' '";
                    Pstatement = conn.prepareStatement(sqlresualt);
                    resualt = Pstatement.executeQuery();
                    ReturnItemTable.setModel(DbUtils.resultSetToTableModel(resualt));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
                }

                TextFieldReturnItemSearch.setEditable(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + ReturnBalance, "Shop Management System", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Retrun Time Period Ended", "Shop Management System", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_ButtonReturnBillActionPerformed

    public void ItemUpdate(String IID, float qt, int opt) {
        float qty = 0;
        try {
            sqlresualt = "SELECT `Quantity` FROM `item` WHERE `Item ID` = '" + IID + "'";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            while (resualt.next()) {
                qty = resualt.getFloat("Quantity");
            }
            if (opt == 1) {
                qty += qt;
            } else {
                qty -= qt;
            }

            sqlInst = "UPDATE `item` SET  `Quantity` = '" + qty + "' WHERE `Item ID` = '" + IID + "' ";
            Pstatement = conn.prepareStatement(sqlInst);
            Pstatement.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void UserAcct_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserAcct_ButtonActionPerformed
        char acct_type = ' ';
        String userName = userNameTextField.getText();
        String pswd = String.valueOf(PasswordTextField.getPassword());
        String rt_pswd = String.valueOf(RT_PasswordTextField.getPassword());
        String CaID = "";

        if ("".equals(userName) || "".equals(pswd) || "".equals(rt_pswd)) {
            JOptionPane.showMessageDialog(null, "Enter values", "Shop Management System", JOptionPane.WARNING_MESSAGE);
        } else if (!pswd.equals(rt_pswd)) {
            JOptionPane.showMessageDialog(null, "Password doesn't match !", "Shop Management System", JOptionPane.WARNING_MESSAGE);
        } else {
            if (RadioButton_Admin.isSelected()) {
                try {
                    String sqlload = sqlInst = "INSERT INTO `user_acct` (`User Name`, `Password`, `CaID`) VALUES('" + userName + "', '" + pswd + "','ADMIN')";
                    Pstatement = conn.prepareStatement(sqlInst);
                    Pstatement.execute();
                    userNameTextField.setText("");
                    PasswordTextField.setText("");
                    RT_PasswordTextField.setText("");
                    UserLoad();
                    JOptionPane.showMessageDialog(null, "Account create successsful", "Shop Management System", JOptionPane.INFORMATION_MESSAGE);
                } catch (HeadlessException | SQLException e) {
                    JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                CaID = ComboBox_Cashieruserselect.getSelectedItem().toString();
                if (("Select".equals(CaID))) {
                    JOptionPane.showMessageDialog(null, "Please select cashier ID", "Shop Management System", JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        String sqlload = sqlInst = "INSERT INTO `user_acct`(`User Name`, `Password`, `CaID`) VALUES('" + userName + "', '" + pswd + "', '" + CaID + "')";
                        Pstatement = conn.prepareStatement(sqlInst);
                        Pstatement.execute();
                        userNameTextField.setText("");
                        PasswordTextField.setText("");
                        RT_PasswordTextField.setText("");
                        UserLoad();
                        ComboBox_Cashieruserselect.setSelectedIndex(0);
                        JOptionPane.showMessageDialog(null, "Account create successsful", "Shop Management System", JOptionPane.INFORMATION_MESSAGE);

                    } catch (HeadlessException | SQLException e) {
                        JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }
        userNameTextField.setText("");
        PasswordTextField.setText("");
        RT_PasswordTextField.setText("");
    }//GEN-LAST:event_UserAcct_ButtonActionPerformed

    private void ReturnCRptRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnCRptRadioButtonActionPerformed
        ReturnCRptRadioButton.setSelected(true);
        BLCRptRadioButton.setSelected(false);
        BLCRptRadioButton1.setSelected(false);
        AllRptRadioButton.setSelected(false);
        hstCheckBox.setEnabled(true);
        fullbillrtlabel.setEnabled(false);
        hstCheckBox.setSelected(false);
        try {
            String sqlload = "SELECT DISTINCT `return_bill`.`Bill ID`, DATE_FORMAT(`bill`.`Date & Time`,'%Y-%m-%d       %h:%i %p') AS 'Date & Time', FORMAT(`bill`.`Total (Rs.)`,2) AS 'Total (Rs.)', FORMAT(`bill`.`Discount (Rs.)`,2) AS 'Discount (Rs.)', FORMAT(`bill`.`Net Total (Rs.)`,2) AS 'Net Total (Rs.)', FORMAT(`bill`.`Balance (Rs.)`,2) AS 'Balance (Rs.)', `Payment Method` FROM `return_bill`,`bill` WHERE `bill`.`Bill ID`=`return_bill`.`Bill ID` ORDER BY `bill`.`Date & Time` DESC";
            Pstatement = conn.prepareStatement(sqlload);
            resualt = Pstatement.executeQuery();
            PurchaseBillTable.setModel(DbUtils.resultSetToTableModel(resualt));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
        bl_itemClear();
    }//GEN-LAST:event_ReturnCRptRadioButtonActionPerformed

    private void hstCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hstCheckBoxActionPerformed
        if (hstCheckBox.isSelected()) {
            ReturnHistry();
        } else {
            RprtItemLoad();
        }
    }//GEN-LAST:event_hstCheckBoxActionPerformed

    private void ComboBox_UserNameselectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_UserNameselectActionPerformed
        if (ComboBox_UserNameselect.getSelectedIndex() == 0) {
            jButton13.setEnabled(false);
            jButton14.setEnabled(false);
            jTextField2.setText("");
        } else {
            String userT = "";
            String user = "";
            try {
                String sqlload = "SELECT `CaID`, `User Name` From `user_acct` WHERE `User Name` = '" + ComboBox_UserNameselect.getSelectedItem().toString() + "'";
                Pstatement = conn.prepareStatement(sqlload);
                resualt = Pstatement.executeQuery();

                while (resualt.next()) {
                    userT = resualt.getString("CaID");
                    user = resualt.getString("User Name");
                }
                if (user.toLowerCase().equals(LabelUserName.getText().toLowerCase())) {
                    jButton14.setEnabled(false);
                    jButton13.setEnabled(true);
                    jLabel67.setText("Your Current Password:");
                } else if (userT.equals("ADMIN")) {
                    jLabel67.setText(user + " Current Password:");
                    jButton14.setEnabled(true);
                    jButton13.setEnabled(true);
                } else {
                    jLabel67.setText("Your Current Password:");
                    jButton14.setEnabled(true);
                    jButton13.setEnabled(true);
                }
                jTextField2.setText(user);
                jPasswordField5.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_ComboBox_UserNameselectActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        String pass = "";
        if (String.valueOf(jPasswordField5.getPassword()).equals("") || jTextField2.getText().equals("") || String.valueOf(jPasswordField1.getPassword()).equals("") || String.valueOf(jPasswordField4.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter valeus", "Shop Management System", JOptionPane.WARNING_MESSAGE);
        } else if (!String.valueOf(jPasswordField1.getPassword()).equals(String.valueOf(jPasswordField4.getPassword()))) {
            JOptionPane.showMessageDialog(null, "New password doesn't match!", "Shop Management System", JOptionPane.WARNING_MESSAGE);
        } else if (jLabel67.getText().equals("Your Current Password:")) {
            try {
                String sqlload = "SELECT `Password` From `user_acct` WHERE `User Name` = '" + LabelUserName.getText() + "'";
                Pstatement = conn.prepareStatement(sqlload);
                resualt = Pstatement.executeQuery();

                while (resualt.next()) {
                    pass = resualt.getString("Password");
                }
                if (!String.valueOf(jPasswordField5.getPassword()).equals(pass)) {
                    JOptionPane.showMessageDialog(null, "Current Password doesn't match!", "Shop Management System", JOptionPane.WARNING_MESSAGE);

                } else {
                    sqlInst = "UPDATE `user_acct` SET `User Name` = '" + jTextField2.getText() + "', `Password` = '" + String.valueOf(jPasswordField1.getPassword()) + "' WHERE `user_acct`.`User Name` = '" + ComboBox_UserNameselect.getSelectedItem().toString() + "'";
                    Pstatement = conn.prepareStatement(sqlInst);
                    Pstatement.execute();
                    jTextField2.setText("");
                    UserLoad();
                    JOptionPane.showMessageDialog(null, "Acount update successful", "Shop Management System", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            try {
                String sqlload = "SELECT `Password` From `user_acct` WHERE `User Name` = '" + ComboBox_UserNameselect.getSelectedItem().toString() + "'";
                Pstatement = conn.prepareStatement(sqlload);
                resualt = Pstatement.executeQuery();

                while (resualt.next()) {
                    pass = resualt.getString("Password");
                }
                if (!String.valueOf(jPasswordField5.getPassword()).equals(pass)) {
                    JOptionPane.showMessageDialog(null, "Password doesn't match!", "Shop Management System", JOptionPane.WARNING_MESSAGE);
                } else {
                    sqlInst = "UPDATE `user_acct` SET `User Name` = '" + jTextField2.getText() + "', `Password` = '" + String.valueOf(jPasswordField1.getPassword()) + "' WHERE `user_acct`.`User Name` = '" + ComboBox_UserNameselect.getSelectedItem().toString() + "'";
                    Pstatement = conn.prepareStatement(sqlInst);
                    Pstatement.execute();
                    UserLoad();
                    jTextField2.setText("");
                    JOptionPane.showMessageDialog(null, "Acount update successful", "Shop Management System", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
            }
        }
        jPasswordField5.setText("");
        jPasswordField1.setText("");
        jPasswordField4.setText("");
    }//GEN-LAST:event_jButton13ActionPerformed

    private void TextFieldCashKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldCashKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ButtonPay.doClick();
        }
    }//GEN-LAST:event_TextFieldCashKeyPressed

    private void ItemTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ItemTableMouseClicked
        int row = ItemTable.getSelectedRow();
        String ID = ItemTable.getValueAt(row, 0).toString();

        String SId = "";
        sqlresualt = "SELECT `Supplier ID` FROM item WHERE `Item ID`='" + ID + "'";
        try {
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            while (resualt.next()) {
                SId = resualt.getString("Supplier ID");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

        if (!"".equals(SId)) {
            ItemGetSupplierBtn.setEnabled(true);
        } else {
            ItemGetSupplierBtn.setEnabled(false);
        }

        ItemEditBtn.setEnabled(true);
        ItemDeleteBtn.setEnabled(true);

        String IbtnTxt = addItembtn.getText();
        if ("Update".equals(IbtnTxt)) {
            item_ID.setText("");
            item_Name.setText("");
            item_SPrice.setText("");
            item_Quantity.setText("");
            item_BPrice.setText("");
            item_SupID.getEditor().setItem("");
            item_AtQuantity.setText("");
            addItembtn.setText("Add");
            item_ID.setEnabled(true);
        }

    }//GEN-LAST:event_ItemTableMouseClicked

    private void item_IDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_item_IDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            item_Name.requestFocus();
        }
    }//GEN-LAST:event_item_IDKeyPressed

    private void item_SPriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_item_SPriceKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            item_Quantity.requestFocus();
        }
    }//GEN-LAST:event_item_SPriceKeyPressed

    private void item_QuantityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_item_QuantityKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            item_SupID.requestFocus();
        }
    }//GEN-LAST:event_item_QuantityKeyPressed

    private void item_SupIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_item_SupIDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            item_AtQuantity.requestFocus();
        }
    }//GEN-LAST:event_item_SupIDKeyPressed

    private void item_AtQuantityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_item_AtQuantityKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            AddItemBtnClick();
        }
    }//GEN-LAST:event_item_AtQuantityKeyPressed

    private void item_NameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_item_NameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            item_BPrice.requestFocus();
        }
    }//GEN-LAST:event_item_NameKeyPressed

    private void Order_QuanttyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Order_QuanttyKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Order_PaiedAmount.requestFocus();
        }
    }//GEN-LAST:event_Order_QuanttyKeyPressed

    private void Order_PaiedAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Order_PaiedAmountKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            AddOrderBtnClick();
        }
    }//GEN-LAST:event_Order_PaiedAmountKeyPressed

    private void Order_ItemIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Order_ItemIDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Order_Quantty.requestFocus();
        }
    }//GEN-LAST:event_Order_ItemIDKeyPressed

    private void OrderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderTableMouseClicked
        int row = OrderTable.getSelectedRow();
        String item_name = OrderTable.getValueAt(row, 1).toString();

        String SId = "";
        try {
            sqlresualt = "SELECT `Supplier ID` FROM item WHERE `Item Name`='" + item_name + "'";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();

            while (resualt.next()) {
                SId = resualt.getString("Supplier ID");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

        if (!"".equals(SId)) {
            OrderGetSupplierBtn.setEnabled(true);
        } else {
            OrderGetSupplierBtn.setEnabled(false);
        }
        OrderEditBtn.setEnabled(true);
        OrderDeleteBtn.setEnabled(true);
        OrderGetItemBtn.setEnabled(true);

        String OdrAddTxt = OdrAddbtn.getText();
        if ("Update".equals(OdrAddTxt)) {
            Order_Quantty.setText("");
            Order_PaiedAmount.setText("");
            Order_ItemID.setSelectedIndex(0);
            OdrAddbtn.setText("Add");
        }
    }//GEN-LAST:event_OrderTableMouseClicked

    private void CustomerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerTableMouseClicked
        CustomerEditBtn.setEnabled(true);
        CustomerDeleteBtn.setEnabled(true);

        String CusAddTxt = CusAddBtn.getText();
        if ("Update".equals(CusAddTxt)) {
            Customer_ID.setText("");
            Customer_Name.setText("");
            Customer_Adds.setText("");
            Customer_Contact.setText("");
            CusAddBtn.setText("Add");
        }
        String cusId = CustomerTable.getValueAt(CustomerTable.getSelectedRow(), 0).toString();

        try {
            sqlresualt = "SELECT `Customer ID` FROM bill WHERE `Customer ID`= '" + cusId + "'";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            cusId = "";
            while (resualt.next()) {
                cusId = resualt.getString("Customer ID");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

        if ("".equals(cusId) || "null".equals(cusId)) {
            ButtonGetBill.setEnabled(false);
        } else {
            ButtonGetBill.setEnabled(true);
        }
    }//GEN-LAST:event_CustomerTableMouseClicked

    private void SupplierTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupplierTableMouseClicked
        int row = SupplierTable.getSelectedRow();
        String ID = SupplierTable.getValueAt(row, 0).toString();

        String IId = "";
        sqlresualt = "SELECT `Item ID` FROM item WHERE `Supplier ID`='" + ID + "'";
        try {
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            while (resualt.next()) {
                IId = resualt.getString("Item ID");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

        if (!"".equals(IId)) {
            SupGetItemsBtn.setEnabled(true);
        } else {
            SupGetItemsBtn.setEnabled(false);
        }

        if (!"".equals(ID)) {
            SupplierEditBtn.setEnabled(true);
            SupplierDeleteBtn.setEnabled(true);
        }
        String SupAddTxt = SupAddBtn.getText();
        if ("Update".equals(SupAddTxt)) {
            Supplier_ID.setText("");
            Supplier_Name.setText("");
            Supplier_Adds.setText("");
            Supplier_Contact.setText("");
            Supplier_Discription.setText("");
            SupAddBtn.setText("Add");
        }
    }//GEN-LAST:event_SupplierTableMouseClicked

    private void CashierTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CashierTableMouseClicked
        CashierEditBtn.setEnabled(true);
        CashierDeleteBtn.setEnabled(true);

        String OdrAddTxt = CashierAddButton.getText();
        if ("Update".equals(OdrAddTxt)) {
            Cashier_ID.setText("");
            Cashier_Name.setText("");
            Cashier_Adds.setText("");
            Cashier_Contact.setText("");
            CashierAddButton.setText("Add");
        }
    }//GEN-LAST:event_CashierTableMouseClicked

    private void Customer_IDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Customer_IDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Customer_Name.requestFocus();
        }
    }//GEN-LAST:event_Customer_IDKeyPressed

    private void Customer_NameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Customer_NameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Customer_Adds.requestFocus();
        }
    }//GEN-LAST:event_Customer_NameKeyPressed

    private void Customer_AddsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Customer_AddsKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Customer_Contact.requestFocus();
        }
    }//GEN-LAST:event_Customer_AddsKeyPressed

    private void Customer_ContactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Customer_ContactKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            AddCustomerBtnClick();
        }
    }//GEN-LAST:event_Customer_ContactKeyPressed

    private void Supplier_IDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Supplier_IDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Supplier_Name.requestFocus();
        }
    }//GEN-LAST:event_Supplier_IDKeyPressed

    private void Supplier_NameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Supplier_NameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Supplier_Adds.requestFocus();
        }
    }//GEN-LAST:event_Supplier_NameKeyPressed

    private void Supplier_AddsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Supplier_AddsKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Supplier_Contact.requestFocus();
        }
    }//GEN-LAST:event_Supplier_AddsKeyPressed

    private void Supplier_ContactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Supplier_ContactKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Supplier_Discription.requestFocus();
        }
    }//GEN-LAST:event_Supplier_ContactKeyPressed

    private void Supplier_DiscriptionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Supplier_DiscriptionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            AddSupplierBtnClick();
        }
    }//GEN-LAST:event_Supplier_DiscriptionKeyPressed

    private void Cashier_IDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Cashier_IDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Cashier_Name.requestFocus();
        }
    }//GEN-LAST:event_Cashier_IDKeyPressed

    private void Cashier_NameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Cashier_NameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Cashier_Adds.requestFocus();
        }
    }//GEN-LAST:event_Cashier_NameKeyPressed

    private void Cashier_AddsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Cashier_AddsKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Cashier_Contact.requestFocus();
        }
    }//GEN-LAST:event_Cashier_AddsKeyPressed

    private void Cashier_ContactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Cashier_ContactKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            AddCashierBtnClick();
        }
    }//GEN-LAST:event_Cashier_ContactKeyPressed

    private void PurchaseBillTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PurchaseBillTableMouseClicked
        if (hstCheckBox.isSelected()) {
            ReturnHistry();
        } else {
            RprtItemLoad();
        }

        int row = PurchaseBillTable.getSelectedRow();
        String ID = PurchaseBillTable.getValueAt(row, 0).toString();

        if (Float.valueOf(PurchaseBillTable.getValueAt(PurchaseBillTable.getSelectedRow(), 2).toString().replace(",", "")) == 0) {
            fullbillrtlabel.setVisible(true);
        } else {
            fullbillrtlabel.setVisible(false);
        }

        String cusId = "";
        try {
            sqlresualt = "SELECT `Customer ID` FROM bill WHERE `bill ID`='" + ID + "'";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            while (resualt.next()) {
                cusId = resualt.getString("Customer ID");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

        if ("".equals(cusId) || "null".equals(cusId)) {
            rpt_getcus.setEnabled(false);
        } else {
            rpt_getcus.setEnabled(true);
        }

        rpt_getitem.setEnabled(false);
        if (admin_text.getText().equals("(admin)")) {
            System.out.print("hh");
            rpt_cashier.setEnabled(true);
        }
    }//GEN-LAST:event_PurchaseBillTableMouseClicked

    private void ReturnBillTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReturnBillTableMouseClicked
        if (RadioButtonReSelling.isSelected()) {
            RtItemLoad();
            ButtonReturnBill.setEnabled(true);
            ReturnItemNames_Qty.clear();
            ButtonAddReturnQTY.setEnabled(false);
            ButtonReturnQTY.setEnabled(false);
            ButtonReturnReset.setEnabled(false);
            ReturnTotal = "";
            ReturnNetTotal = "";
            ReturnBalance = "";
            TextFieldReturnItemSearch.requestFocus();
        } else {
            TextFieldReturnQTY.setEnabled(true);
            ButtonReturnToSuppliers.setEnabled(true);
        }
        TextFieldReturnQTY.setText("1");
    }//GEN-LAST:event_ReturnBillTableMouseClicked

    private void ReturnItemTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReturnItemTableMouseClicked
        if (RadioButtonReSelling.isSelected()) {
            ButtonAddReturnQTY.setEnabled(true);
            TextFieldReturnQTY.setEnabled(true);
            TextFieldReturnQTY.setText("1");
        }
    }//GEN-LAST:event_ReturnItemTableMouseClicked

    private void TextFieldReturnBillSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldReturnBillSearchKeyReleased
        String Stext = TextFieldReturnBillSearch.getText();
        if (RadioButtonReSelling.isSelected()) {
            try {
                String sql = "SELECT `Bill ID`, DATE_FORMAT(`Date & Time`,'%Y-%m-%d       %h:%i %p') AS 'Date & Time', FORMAT(`bill`.`Total (Rs.)`,2) AS 'Total (Rs.)', FORMAT(`bill`.`Discount (Rs.)`,2) AS 'Discount (Rs.)', FORMAT(`bill`.`Net Total (Rs.)`,2) AS 'Net Total (Rs.)', FORMAT(`Balance (Rs.)`,2) AS 'Balance (Rs.)', `Payment Method` From `bill` WHERE `Bill ID` LIKE '%" + Stext + "%' AND `Total (Rs.)` != 0 ORDER BY `bill`.`Date & Time` DESC";
                Pstatement = conn.prepareStatement(sql);
                resualt = Pstatement.executeQuery();
                ReturnBillTable.setModel(DbUtils.resultSetToTableModel(resualt));

                sqlresualt = "SELECT `Item ID`, `Quantity`, FORMAT(`Total (Rs.)`,2) AS 'Total (Rs.)', FORMAT(`Discount (Rs.)`,2) AS 'Discount (Rs.)', FORMAT(`Net Total (Rs.)`,2) AS 'Net Total (Rs.)' FROM `billitem` WHERE `Bill ID` = '*'";
                Pstatement = conn.prepareStatement(sqlresualt);
                resualt = Pstatement.executeQuery();
                ReturnItemTable.setModel(DbUtils.resultSetToTableModel(resualt));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            try {
                String sql = "SELECT `Item ID`, `Item Name`, `Quantity` FROM item WHERE `Item ID` LIKE '" + Stext + "' OR `Item Name` LIKE '%" + Stext + "%'";
                Pstatement = conn.prepareStatement(sql);
                resualt = Pstatement.executeQuery();
                ReturnBillTable.setModel(DbUtils.resultSetToTableModel(resualt));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_TextFieldReturnBillSearchKeyReleased

    private void TextFieldReturnItemSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldReturnItemSearchKeyReleased
        String Stext = TextFieldReturnItemSearch.getText();
        if (RadioButtonReSelling.isSelected()) {
            if (ReturnItemTable.getColumnCount() > 0) {
                String BillID = ReturnBillTable.getValueAt(ReturnBillTable.getSelectedRow(), 0).toString();
                try {
                    if (Stext.equals("")) {
                        sqlresualt = "SELECT `Item ID`, `Quantity`, FORMAT(`Total (Rs.)`,2) AS 'Total (Rs.)', FORMAT(`Discount (Rs.)`,2) AS 'Discount (Rs.)', FORMAT(`Net Total (Rs.)`,2) AS 'Net Total (Rs.)' FROM `billitem` WHERE `Bill ID` = '" + BillID + "'";
                    } else {
                        sqlresualt = "SELECT `Item ID`, `Quantity`, FORMAT(`Total (Rs.)`,2) AS 'Total (Rs.)', FORMAT(`Discount (Rs.)`,2) AS 'Discount (Rs.)', FORMAT(`Net Total (Rs.)`,2) AS 'Net Total (Rs.)' FROM `billitem` WHERE `Bill ID` ='" + BillID + "' AND `Item ID` LIKE '" + Stext + "'";
                    }
                    Pstatement = conn.prepareStatement(sqlresualt);
                    resualt = Pstatement.executeQuery();
                    ReturnItemTable.setModel(DbUtils.resultSetToTableModel(resualt));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else {
            try {
                if (Stext.equals("")) {
                    sqlresualt = "SELECT `Item ID`, DATE_FORMAT(`Date & Time`,'%Y-%m-%d       %h:%i:%s %p') AS 'Date & Time', `Return Quantity` FROM `return _sup` ORDER BY `return _sup`.`Date & Time` DESC";
                } else {
                    sqlresualt = "SELECT `Item ID`, DATE_FORMAT(`Date & Time`,'%Y-%m-%d       %h:%i:%s %p') AS 'Date & Time', `Return Quantity` FROM `return _sup` WHERE `Item ID` = '" + Stext + "' ORDER BY `return _sup`.`Date & Time` DESC";
                }

                Pstatement = conn.prepareStatement(sqlresualt);
                resualt = Pstatement.executeQuery();
                ReturnItemTable.setModel(DbUtils.resultSetToTableModel(resualt));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_TextFieldReturnItemSearchKeyReleased

    private void TextFieldReturnItemSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextFieldReturnItemSearchMouseClicked
        if (TextFieldReturnItemSearch.isEditable() == false) {
            TextFieldReturnBillSearch.requestFocus();
        }
    }//GEN-LAST:event_TextFieldReturnItemSearchMouseClicked

    private void BillSearchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BillSearchTextFieldKeyReleased
        String Stext = BillSearchTextField.getText();
        if (AllRptRadioButton.isSelected()) {
            try {
                sqlresualt = "SELECT `Bill ID`, DATE_FORMAT(`Date & Time`,'%Y-%m-%d       %h:%i %p') AS 'Date & Time', FORMAT(`bill`.`Total (Rs.)`,2) AS 'Total (Rs.)', FORMAT(`bill`.`Discount (Rs.)`,2) AS 'Discount (Rs.)', FORMAT(`bill`.`Net Total (Rs.)`,2) AS 'Net Total (Rs.)', FORMAT(`Balance (Rs.)`,2) AS 'Balance (Rs.)', `Payment Method` FROM `bill` WHERE `Bill ID` LIKE '%" + Stext + "%' OR `Customer ID` = '" + Stext + "' OR `User Name` = '" + Stext + "' OR `Date & Time` Like '" + Stext + "%' ORDER BY `bill`.`Date & Time` DESC";
                Pstatement = conn.prepareStatement(sqlresualt);
                resualt = Pstatement.executeQuery();
                PurchaseBillTable.setModel(DbUtils.resultSetToTableModel(resualt));
                bl_itemClear();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
            }
        } else if (BLCRptRadioButton.isSelected()) {
            try {
                String sqlload = "SELECT `Bill ID`, DATE_FORMAT(`Date & Time`,'%Y-%m-%d       %h:%i %p') AS 'Date & Time', FORMAT(`bill`.`Total (Rs.)`,2) AS 'Total (Rs.)', FORMAT(`bill`.`Discount (Rs.)`,2) AS 'Discount (Rs.)', FORMAT(`bill`.`Net Total (Rs.)`,2) AS 'Net Total (Rs.)', FORMAT(`Balance (Rs.)`,2) AS 'Balance (Rs.)', `Payment Method` FROM `bill` WHERE `Bill ID` LIKE '%" + Stext + "%' AND `Payment Method` LIKE 'Cash' ORDER BY `bill`.`Date & Time` DESC";
                Pstatement = conn.prepareStatement(sqlload);
                resualt = Pstatement.executeQuery();
                PurchaseBillTable.setModel(DbUtils.resultSetToTableModel(resualt));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
            }
        } else if (BLCRptRadioButton1.isSelected()) {
            try {
                String sqlload = "SELECT `Bill ID`, DATE_FORMAT(`Date & Time`,'%Y-%m-%d       %h:%i %p') AS 'Date & Time', FORMAT(`bill`.`Total (Rs.)`,2) AS 'Total (Rs.)', FORMAT(`bill`.`Discount (Rs.)`,2) AS 'Discount (Rs.)', FORMAT(`bill`.`Net Total (Rs.)`,2) AS 'Net Total (Rs.)', FORMAT(`Balance (Rs.)`,2) AS 'Balance (Rs.)', `Payment Method` FROM `bill` WHERE `Bill ID` LIKE '%" + Stext + "%' AND `Payment Method` LIKE 'Card/ C.O. Delivery' ORDER BY `bill`.`Date & Time` DESC";
                Pstatement = conn.prepareStatement(sqlload);
                resualt = Pstatement.executeQuery();
                PurchaseBillTable.setModel(DbUtils.resultSetToTableModel(resualt));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            try {
                String sqlload = "SELECT DISTINCT `return_bill`.`Bill ID`, DATE_FORMAT(`bill`.`Date & Time`,'%Y-%m-%d       %h:%i %p') AS 'Date & Time', FORMAT(`bill`.`Total (Rs.)`,2) AS 'Total (Rs.)', FORMAT(`bill`.`Discount (Rs.)`,2) AS 'Discount (Rs.)', FORMAT(`bill`.`Net Total (Rs.)`,2) AS 'Net Total (Rs.)', FORMAT(`bill`.`Balance (Rs.)`,2) AS 'Balance (Rs.)', `Payment Method` FROM `return_bill`,`bill` WHERE `bill`.`Bill ID` LIKE '%" + Stext + "%' AND `return_bill`.`Bill ID`=`bill`.`Bill ID` ORDER BY `bill`.`Date & Time` DESC";
                Pstatement = conn.prepareStatement(sqlload);
                resualt = Pstatement.executeQuery();
                PurchaseBillTable.setModel(DbUtils.resultSetToTableModel(resualt));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_BillSearchTextFieldKeyReleased

    private void NclearbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NclearbtnMouseClicked
        TextAreaNotifications.setText("No new notifications");
        //notificationbtn.setIcon(new ImageIcon(getClass().getResource("/images/notification.png")));
    }//GEN-LAST:event_NclearbtnMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            sqlresualt = "SELECT `Item ID` FROM `item`";
            Pstatement = conn.prepareStatement(sqlresualt);
            ResultSet r = Pstatement.executeQuery();
            while (r.next()) {
                String Iid = r.getString("Item ID");
                alert_qty(Iid);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_formWindowOpened

    private void LogoutbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutbtnMouseClicked
        if (b == 1) {
            int btnrslt = JOptionPane.showConfirmDialog(this, "Billing is progess.\nDo you want to cancel bill and sign out?", "Shop Management System", JOptionPane.YES_NO_OPTION);
            if (btnrslt == 0) {
                Loging_Frame logfrm = new Loging_Frame();
                logfrm.setVisible(true);
                ButtonCancelItem.doClick();
                this.dispose();
            }
        } else {
            Loging_Frame logfrm = new Loging_Frame();
            logfrm.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_LogoutbtnMouseClicked

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        String pass = "";
        if (String.valueOf(jPasswordField5.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter password", "Shop Management System", JOptionPane.WARNING_MESSAGE);
        } else if (jLabel67.getText().equals("Your Current Password:") && !LabelUserName.getText().equals(ComboBox_UserNameselect.getSelectedItem().toString())) {
            try {
                String sqlload = "SELECT `Password` From `user_acct` WHERE `User Name` = '" + LabelUserName.getText() + "'";
                Pstatement = conn.prepareStatement(sqlload);
                resualt = Pstatement.executeQuery();

                while (resualt.next()) {
                    pass = resualt.getString("Password");
                }

                if (!String.valueOf(jPasswordField5.getPassword()).equals(pass)) {
                    JOptionPane.showMessageDialog(null, "Current Password doesn't match!", "Shop Management System", JOptionPane.WARNING_MESSAGE);

                } else {
                    sqlInst = "DELETE FROM `user_acct`  WHERE `user_acct`.`User Name` = '" + ComboBox_UserNameselect.getSelectedItem().toString() + "'";
                    Pstatement = conn.prepareStatement(sqlInst);
                    Pstatement.execute();
                    UserLoad();
                    JOptionPane.showMessageDialog(null, "Acount delete successful", "Shop Management System", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            try {
                String sqlload = "SELECT `Password` From `user_acct` WHERE `User Name` = '" + ComboBox_UserNameselect.getSelectedItem().toString() + "'";
                Pstatement = conn.prepareStatement(sqlload);
                resualt = Pstatement.executeQuery();

                while (resualt.next()) {
                    pass = resualt.getString("Password");
                }
                if (!String.valueOf(jPasswordField5.getPassword()).equals(pass)) {
                    JOptionPane.showMessageDialog(null, "Password doesn't match!", "Shop Management System", JOptionPane.WARNING_MESSAGE);
                } else {
                    sqlInst = "DELETE FROM `user_acct` WHERE `user_acct`.`User Name` = '" + ComboBox_UserNameselect.getSelectedItem().toString() + "'";
                    Pstatement = conn.prepareStatement(sqlInst);
                    Pstatement.execute();
                    UserLoad();
                    JOptionPane.showMessageDialog(null, "Acount delete successful", "Shop Management System", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
            }
        }
        jPasswordField5.setText("");
        jPasswordField1.setText("");
        jTextField2.setText("");
        jPasswordField4.setText("");
    }//GEN-LAST:event_jButton14ActionPerformed

    private void rpt_getitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rpt_getitemActionPerformed
        int row = PurchaseItemTable.getSelectedRow();
        String ID = PurchaseItemTable.getValueAt(row, 0).toString();

        ItemButtonClick();

        String sql = "SELECT `Item ID`, `Item Name`, FORMAT(`item`.`Buying Price (Rs.)`,2) AS 'Buying Price (Rs.)', FORMAT(`item`.`Selling Price (Rs.)`,2) AS 'Selling Price (Rs.)', `Quantity`, `Alert Quantity` FROM item WHERE  `Item ID` = '" + ID + "'";
        try {
            Pstatement = conn.prepareStatement(sql);
            resualt = Pstatement.executeQuery();
            ItemTable.setModel(DbUtils.resultSetToTableModel(resualt));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
        ItemSearchTextField.setText(ID);
    }//GEN-LAST:event_rpt_getitemActionPerformed

    private void PurchaseItemTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PurchaseItemTableMouseClicked
        rpt_getitem.setEnabled(true);
    }//GEN-LAST:event_PurchaseItemTableMouseClicked

    private void rpt_getcusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rpt_getcusActionPerformed
        int row = PurchaseBillTable.getSelectedRow();
        String ID = PurchaseBillTable.getValueAt(row, 0).toString();

        sqlresualt = "SELECT `Customer ID` FROM bill WHERE `Bill ID`='" + ID + "'";
        try {
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            while (resualt.next()) {
                ID = resualt.getString("Customer ID");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

        CustomerButtonClick();

        String sql = "SELECT `Customer ID`, `Name`, `Address`, `Contact` FROM customer WHERE `Customer ID` = '" + ID + "'";
        try {
            Pstatement = conn.prepareStatement(sql);
            resualt = Pstatement.executeQuery();
            CustomerTable.setModel(DbUtils.resultSetToTableModel(resualt));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
        CustomerSearchTextField.setText(ID);
    }//GEN-LAST:event_rpt_getcusActionPerformed

    private void rpt_cashierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rpt_cashierActionPerformed
        String uname = "";
        String caid = "";
        int row = PurchaseBillTable.getSelectedRow();
        String ID = PurchaseBillTable.getValueAt(row, 0).toString();
        try {
            sqlresualt = "SELECT `User Name` FROM bill WHERE `bill ID`='" + ID + "'";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            while (resualt.next()) {
                uname = resualt.getString("User Name");
            }

            sqlresualt = "SELECT `CaID` FROM `user_acct`  WHERE `User Name`='" + uname + "'";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            while (resualt.next()) {
                caid = resualt.getString("CaID");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

        if ("ADMIN".equals(caid)) {
            JOptionPane.showMessageDialog(null, "Bill by admin.\nUser Name: " + uname, "Shop Management System", JOptionPane.INFORMATION_MESSAGE);
        } else {
            CashierButtonClick();
            try {
                String sql = "SELECT `Cashier ID`, `Name`, `Address`, `Contact` FROM cashier WHERE `Cashier ID` = '" + caid + "'";
                Pstatement = conn.prepareStatement(sql);
                resualt = Pstatement.executeQuery();
                CashierTable.setModel(DbUtils.resultSetToTableModel(resualt));

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
            }
            CasSearchTextField.setText(caid);

        }

    }//GEN-LAST:event_rpt_cashierActionPerformed

    private void userAcct_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userAcct_btnActionPerformed
        user_act.setVisible(true);
        Database.setVisible(false);
        about.setVisible(false);

        userAcct_btn.setColorText(new Color(0, 0, 0));
        userAcct_btn.setColorTextHover(new Color(0, 0, 0));
        userAcct_btn.setBackground(new Color(255, 253, 242));
        userAcct_btn.setColorHover(new Color(255, 253, 242));

        database_btn.setColorText(new Color(255, 255, 255));
        database_btn.setColorTextHover(new Color(255, 255, 255));
        database_btn.setBackground(new Color(0, 112, 192));
        database_btn.setColorHover(new Color(67, 150, 209));

        about_btn.setColorText(new Color(255, 255, 255));
        about_btn.setColorTextHover(new Color(255, 255, 255));
        about_btn.setBackground(new Color(0, 112, 192));
        about_btn.setColorHover(new Color(67, 150, 209));
    }//GEN-LAST:event_userAcct_btnActionPerformed

    private void database_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_database_btnActionPerformed
        user_act.setVisible(false);
        Database.setVisible(true);
        about.setVisible(false);

        database_btn.setColorText(new Color(0, 0, 0));
        database_btn.setColorTextHover(new Color(0, 0, 0));
        database_btn.setBackground(new Color(255, 253, 242));
        database_btn.setColorHover(new Color(255, 253, 242));

        userAcct_btn.setColorText(new Color(255, 255, 255));
        userAcct_btn.setColorTextHover(new Color(255, 255, 255));
        userAcct_btn.setBackground(new Color(0, 112, 192));
        userAcct_btn.setColorHover(new Color(67, 150, 209));

        about_btn.setColorText(new Color(255, 255, 255));
        about_btn.setColorTextHover(new Color(255, 255, 255));
        about_btn.setBackground(new Color(0, 112, 192));
        about_btn.setColorHover(new Color(67, 150, 209));
    }//GEN-LAST:event_database_btnActionPerformed

    private void about_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_about_btnActionPerformed
        Database.setVisible(false);
        about.setVisible(true);
        user_act.setVisible(false);

        about_btn.setColorText(new Color(0, 0, 0));
        about_btn.setColorTextHover(new Color(0, 0, 0));
        about_btn.setBackground(new Color(255, 253, 242));
        about_btn.setColorHover(new Color(255, 253, 242));

        database_btn.setColorText(new Color(255, 255, 255));
        database_btn.setColorTextHover(new Color(255, 255, 255));
        database_btn.setBackground(new Color(0, 112, 192));
        database_btn.setColorHover(new Color(67, 150, 209));

        userAcct_btn.setColorText(new Color(255, 255, 255));
        userAcct_btn.setColorTextHover(new Color(255, 255, 255));
        userAcct_btn.setBackground(new Color(0, 112, 192));
        userAcct_btn.setColorHover(new Color(67, 150, 209));

    }//GEN-LAST:event_about_btnActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        Panelhide();
        PanelHome.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void item_BPriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_item_BPriceKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            item_SPrice.requestFocus();
        }
    }//GEN-LAST:event_item_BPriceKeyPressed

    private void DailyRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DailyRadioButtonActionPerformed
        ReportButtonClick();
    }//GEN-LAST:event_DailyRadioButtonActionPerformed

    private void RadioButtonMonthlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonMonthlyActionPerformed
        DailyRadioButton.setSelected(false);
        DailyReportPanel.setVisible(false);
        RadioButtonMonthly.setSelected(true);
        MonthlyReportPanel.setVisible(true);
        PreviousMonth.setSelected(false);
        SelectMonth.setSelected(false);
        ThisMonth.setSelected(true);
        Ebill_TextField.requestFocus();
        YearComboBox.setEnabled(false);
        MonthComboBox.setEnabled(false);

        String month = String.valueOf(LocalDate.now().getMonthValue());
        FindMonthName(LocalDate.now().getYear(), LocalDate.now().getMonthValue());
        if (LocalDate.now().getMonthValue() < 10) {
            month = "0" + String.valueOf(LocalDate.now().getMonthValue());
        }
        String DnT = LocalDate.now().getYear() + "-" + month;

        MonthReport(DnT);

    }//GEN-LAST:event_RadioButtonMonthlyActionPerformed

    private void SelectMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectMonthActionPerformed
        PreviousMonth.setSelected(false);
        SelectMonth.setSelected(true);
        ThisMonth.setSelected(false);
        netp_label.setForeground(new Color(0, 0, 153));
        ProfitLabel.setForeground(new Color(0, 0, 153));

        Ebill_TextField.requestFocus();
        Ebill_TextField.setText("");
        Wbill_TextField.setText("");
        Othercost_TextField.setText("");
        Monthly_T_ernLabel.setText("Total Earn          :  Rs. 0.00");
        total_item_costLabel.setText("Total Item Cost  :  Rs. 0.00");
        eLabel.setText("Electricity Bill    :  Rs. 0.00");
        wLabel.setText("Water Bill           :  Rs. 0.00");
        oLabel.setText("Other Costs       :  Rs. 0.00");
        ProfitLabel.setText("  Rs. 0.00");

        int a = YearComboBox.getItemCount();
        a -= 1;
        while (a > 0) {
            YearComboBox.removeItemAt(a);
            a -= 1;
        }

        try {
            sqlresualt = "SELECT DISTINCT Substring(`date & time`,1,4) as 'Year' FROM `bill` ORDER BY `Year` DESC ";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();

            while (resualt.next()) {
                String yr = resualt.getString("Year");
                YearComboBox.addItem(yr);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
        TitleMonth_Label.setText("Select Year & Month");
        YearComboBox.setEnabled(true);
        MonthComboBox.setEnabled(true);
    }//GEN-LAST:event_SelectMonthActionPerformed

    private void PreviousMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousMonthActionPerformed
        PreviousMonth.setSelected(true);
        SelectMonth.setSelected(false);
        ThisMonth.setSelected(false);
        ThisMonth.setSelected(false);
        YearComboBox.setEnabled(false);
        MonthComboBox.setEnabled(false);
        Ebill_TextField.requestFocus();
        eLabel.setText("Electricity Bill    :  Rs. 0.00");
        wLabel.setText("Water Bill           :  Rs. 0.00");
        oLabel.setText("Other Costs       :  Rs. 0.00");

        int month = LocalDate.now().getMonthValue();
        String DnT = "";

        if (month == 1) {
            DnT = (LocalDate.now().getYear() - 1) + "-12";
            FindMonthName(LocalDate.now().getYear() - 1, 12);
        } else if (1 < month && month < 11) {
            DnT = LocalDate.now().getYear() + "-0" + (month - 1);
            FindMonthName(LocalDate.now().getYear(), (month - 1));
        } else {
            DnT = LocalDate.now().getYear() + "-" + (month - 1);
            FindMonthName(LocalDate.now().getYear(), (month - 1));
        }
        MonthReport(DnT);
    }//GEN-LAST:event_PreviousMonthActionPerformed

    private void ThisMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThisMonthActionPerformed
        PreviousMonth.setSelected(false);
        SelectMonth.setSelected(false);
        ThisMonth.setSelected(true);
        YearComboBox.setEnabled(false);
        MonthComboBox.setEnabled(false);
        Ebill_TextField.requestFocus();
        eLabel.setText("Electricity Bill    :  Rs. 0.00");
        wLabel.setText("Water Bill           :  Rs. 0.00");
        oLabel.setText("Other Costs       :  Rs. 0.00");
        String month = String.valueOf(LocalDate.now().getMonthValue());

        if (LocalDate.now().getMonthValue() < 10) {
            month = "0" + String.valueOf(LocalDate.now().getMonthValue());
        }
        String DnT = LocalDate.now().getYear() + "-" + month;

        MonthReport(DnT);
        FindMonthName(LocalDate.now().getYear(), LocalDate.now().getMonthValue());
    }//GEN-LAST:event_ThisMonthActionPerformed

    private void YearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearComboBoxActionPerformed
        int a = MonthComboBox.getItemCount();
        String y = YearComboBox.getSelectedItem().toString();
        a -= 1;
        while (a > 0) {
            MonthComboBox.removeItemAt(a);
            a -= 1;
        }

        try {
            sqlresualt = "SELECT DISTINCT Substring(`date & time`,6,2) as 'Month' FROM `bill` WHERE `Date & Time` LIKE '%" + y + "%' ORDER BY `Month` DESC";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();

            while (resualt.next()) {
                String m = resualt.getString("Month");
                MonthComboBox.addItem(m);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_YearComboBoxActionPerformed

    private void MonthComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonthComboBoxActionPerformed
        String mt = MonthComboBox.getSelectedItem().toString();
        String yr = YearComboBox.getSelectedItem().toString();
        int m = 0;
        int y = 0;
        if (!"Year".equals(yr)) {
            y = Integer.valueOf(yr);
            if (!"Month".equals(mt)) {
                m = Integer.valueOf(mt);
            }
        }
        yr = yr + "-" + mt;
        MonthReport(yr);
        FindMonthName(y, m);
    }//GEN-LAST:event_MonthComboBoxActionPerformed

    private void Ebill_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Ebill_TextFieldKeyReleased
        float v = 0;
        try {
            v = Float.valueOf(Ebill_TextField.getText());

        } catch (Exception e) {
            if (!"".equals(Ebill_TextField.getText())) {
                JOptionPane.showMessageDialog(null, "Invalied input! Numeric values only", "Shop Management System", JOptionPane.WARNING_MESSAGE);
            }
        }
        String prc = java.text.NumberFormat.getCurrencyInstance().format(v);
        prc = prc.replace("$", "");
        eLabel.setText("Electricity Bill    :  Rs. " + prc);
        NetProfit();
    }//GEN-LAST:event_Ebill_TextFieldKeyReleased

    private void Wbill_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Wbill_TextFieldKeyReleased
        float v = 0;
        try {
            v = Float.valueOf(Wbill_TextField.getText());
        } catch (Exception e) {
            if (!"".equals(Wbill_TextField.getText())) {
                JOptionPane.showMessageDialog(null, "Invalied input! Numeric values only", "Shop Management System", JOptionPane.WARNING_MESSAGE);
            }
        }
        String prc = java.text.NumberFormat.getCurrencyInstance().format(v);
        prc = prc.replace("$", "");
        wLabel.setText("Water Bill           :  Rs. " + prc);

        NetProfit();
    }//GEN-LAST:event_Wbill_TextFieldKeyReleased

    private void Othercost_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Othercost_TextFieldKeyReleased
        float v = 0;
        try {
            v = Float.valueOf(Othercost_TextField.getText());
        } catch (Exception e) {
            if (!"".equals(Othercost_TextField.getText())) {
                JOptionPane.showMessageDialog(null, "Invalied input! Numeric values only", "Shop Management System", JOptionPane.WARNING_MESSAGE);
            }
        }
        String prc = java.text.NumberFormat.getCurrencyInstance().format(v);
        prc = prc.replace("$", "");
        oLabel.setText("Other Costs       :  Rs. " + prc);
        NetProfit();
    }//GEN-LAST:event_Othercost_TextFieldKeyReleased

    private void Ebill_TextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Ebill_TextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Wbill_TextField.requestFocus();
        }
    }//GEN-LAST:event_Ebill_TextFieldKeyPressed

    private void Wbill_TextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Wbill_TextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Othercost_TextField.requestFocus();
        }
    }//GEN-LAST:event_Wbill_TextFieldKeyPressed

    private void SideButtonBillingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SideButtonBillingActionPerformed
        BillingButtonClick();
    }//GEN-LAST:event_SideButtonBillingActionPerformed

    private void SideButtonReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SideButtonReturnActionPerformed
        ReturnButtonClick();
    }//GEN-LAST:event_SideButtonReturnActionPerformed

    private void SideButtonItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SideButtonItemActionPerformed
        ItemButtonClick();
    }//GEN-LAST:event_SideButtonItemActionPerformed

    private void SideButtonSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SideButtonSupplierActionPerformed
        SupplierButtonClick();
    }//GEN-LAST:event_SideButtonSupplierActionPerformed

    private void SideButtonCashierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SideButtonCashierActionPerformed
        CashierButtonClick();
    }//GEN-LAST:event_SideButtonCashierActionPerformed

    private void SideButtonReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SideButtonReportActionPerformed
        ReportButtonClick();
    }//GEN-LAST:event_SideButtonReportActionPerformed

    private void SideButtonCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SideButtonCustomerActionPerformed
        CustomerButtonClick();
    }//GEN-LAST:event_SideButtonCustomerActionPerformed

    private void SideButtonOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SideButtonOrderActionPerformed
        OrdersButtonClick();
    }//GEN-LAST:event_SideButtonOrderActionPerformed

    private void ButtonGetBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonGetBillActionPerformed

        String cusId = CustomerTable.getValueAt(CustomerTable.getSelectedRow(), 0).toString();
        try {
            sqlresualt = "SELECT `Bill ID`, DATE_FORMAT(`Date & Time`,'%Y-%m-%d      %h:%i %p') AS 'Date & Time', FORMAT(`bill`.`Total (Rs.)`,2) AS 'Total (Rs.)', FORMAT(`bill`.`Net Total (Rs.)`,2) AS 'Net Total (Rs.)', FORMAT(`Balance (Rs.)`,2) AS 'Balance (Rs.)' FROM `bill` WHERE `Customer ID` = '" + cusId + "' ORDER BY `bill`.`Date & Time` DESC";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            PurchaseBillTable.setModel(DbUtils.resultSetToTableModel(resualt));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
        ReportButtonClick();
        DailyReportPanel.setVisible(false);
        BlReportPanel.setVisible(true);
        AllRptRadioButton.setSelected(true);
        ReturnCRptRadioButton.setSelected(false);
        BLCRptRadioButton.setSelected(false);
        MonthlyReportPanel.setVisible(false);
        DailyRadioButton.setVisible(false);
        RadioButtonMonthly.setVisible(false);
        hstCheckBox.setEnabled(false);
        rpt_getcus.setEnabled(false);
        rpt_cashier.setEnabled(false);
        rpt_getitem.setEnabled(false);
        BillSearchTextField.requestFocus();
        BillRptBtn.setBackground(new Color(0, 153, 51));
        ShellRptBtn.setBackground(new Color(51, 204, 0));
        BillSearchTextField.setText(cusId);
    }//GEN-LAST:event_ButtonGetBillActionPerformed

    private void userNameTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNameTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            PasswordTextField.requestFocus();
        }
    }//GEN-LAST:event_userNameTextFieldKeyPressed

    private void RT_PasswordTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RT_PasswordTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            UserAcct_Button.doClick();
        }
    }//GEN-LAST:event_RT_PasswordTextFieldKeyPressed

    private void PasswordTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            RT_PasswordTextField.requestFocus();
        }
    }//GEN-LAST:event_PasswordTextFieldKeyPressed

    private void ComboBox_CashieruserselectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_CashieruserselectActionPerformed
        userNameTextField.requestFocus();
    }//GEN-LAST:event_ComboBox_CashieruserselectActionPerformed

    private void jPasswordField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField5KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField2.requestFocus();
        }
    }//GEN-LAST:event_jPasswordField5KeyPressed

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jPasswordField4.requestFocus();
        }
    }//GEN-LAST:event_jPasswordField1KeyPressed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jPasswordField1.requestFocus();
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void Backup_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Backup_btnActionPerformed

        String cmd = "\"C:\\Program Files\\MySQL\\MySQL Server 5.7\\bin\\mysqldump\" -uroot -pafs@sms aanya_fashion > ";

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Backup save as (Don't use system drive)");
        fileChooser.setSelectedFile(new File("Manual_Backup"));
        //fileChooser.setFileFilter(new FileNameExtentionFilter("sql file","sql"));
        int userSelection = fileChooser.showSaveDialog(Database);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            cmd = cmd + file.getAbsolutePath() + ".sql";
            try {
                Process runtimeProcess = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", cmd});
                JOptionPane.showMessageDialog(null, "Backup Complete", "Shop Management System", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Backup Failure", "Shop Management System", JOptionPane.WARNING_MESSAGE);
            }
        }

    }//GEN-LAST:event_Backup_btnActionPerformed

    private void Restore_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Restore_btnActionPerformed
        JOptionPane.showMessageDialog(null, "If you select wrong database then system break down !", "Shop Management System", JOptionPane.WARNING_MESSAGE);
        String cmd = "\"C:\\Program Files\\MySQL\\MySQL Server 5.7\\bin\\mysql\" -uroot -pafs@sms aanya_fashion < ";

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open backup SQL file");
        //fileChooser.setFileFilter(new FileNameExtentionFilter("sql file","sql"));
        int userSelection = fileChooser.showOpenDialog(Database);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            cmd = cmd + file.getAbsolutePath();
            try {
                Process runtimeProcess = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", cmd});
                JOptionPane.showMessageDialog(null, "Restore Successful", "Shop Management System", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Restore Failure", "Shop Management System", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_Restore_btnActionPerformed

    private void TextFieldCashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextFieldCashMouseClicked
        TextFieldCash.requestFocus();
    }//GEN-LAST:event_TextFieldCashMouseClicked

    private void ItemEditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemEditBtnActionPerformed
        addItembtn.setText("Update");

        int row = ItemTable.getSelectedRow();
        String IID = ItemTable.getValueAt(row, 0).toString();

        String ItemName = null;
        String SId = null;
        String IPrice = null;
        String BPrice = null;
        String IAQuantity = null;

        sqlresualt = "SELECT `Item Name`, `Buying Price (Rs.)`, `Selling Price (Rs.)`, `Quantity`, `Supplier ID`, `Alert Quantity` FROM item WHERE `Item ID`='" + IID + "'";
        try {
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            while (resualt.next()) {
                ItemName = resualt.getString("Item Name");
                SId = resualt.getString("Supplier ID");
                BPrice = resualt.getString("Buying Price (Rs.)");
                IPrice = resualt.getString("Selling Price (Rs.)");
                IAQuantity = resualt.getString("Alert Quantity");
            }

            item_ID.setText(IID);
            item_Name.setText(ItemName);

            if (!"".equals(SId)) {
                item_SupID.setSelectedItem(SId);
            }
            item_AtQuantity.setText(IAQuantity);
            item_BPrice.setText(BPrice);
            item_SPrice.setText(IPrice);
            item_Quantity.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_ItemEditBtnActionPerformed

    private void ItemDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemDeleteBtnActionPerformed
        int row = ItemTable.getSelectedRow();
        String ID = ItemTable.getValueAt(row, 0).toString();
        deleteValues("item", "Item ID", ID);
        ItemTableLoad();
        ItemSearchTextField.requestFocus();
    }//GEN-LAST:event_ItemDeleteBtnActionPerformed

    private void ItemGetSupplierBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemGetSupplierBtnActionPerformed
        int row = ItemTable.getSelectedRow();
        String ID = ItemTable.getValueAt(row, 0).toString();

        sqlresualt = "SELECT `Supplier ID` FROM item WHERE `Item ID`='" + ID + "'";
        try {
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            while (resualt.next()) {
                ID = resualt.getString("Supplier ID");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

        SupplierButtonClick();

        String sql = "SELECT `Supplier ID`, `Name`, `Address`, `Contact`, `Discription` FROM supplier WHERE `Supplier ID` = '" + ID + "'";
        try {
            Pstatement = conn.prepareStatement(sql);
            resualt = Pstatement.executeQuery();
            SupplierTable.setModel(DbUtils.resultSetToTableModel(resualt));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
        SupSearchTextField.setText(ID);
    }//GEN-LAST:event_ItemGetSupplierBtnActionPerformed

    private void Item_delete_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item_delete_ButtonActionPerformed
        int btnrslt = JOptionPane.showConfirmDialog(this, "Are you sure delete all items?", "Shop Management System", JOptionPane.YES_NO_OPTION);
        if (btnrslt == 0) {
            try {
                sqlInst = "DELETE FROM `item`";
                Pstatement = conn.prepareStatement(sqlInst);
                Pstatement.execute();
                ItemTableLoad();
                item_ID.requestFocus();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_Item_delete_ButtonActionPerformed

    private void TextFieldDiscountPerUnitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextFieldDiscountPerUnitMouseClicked
        TextFieldDiscountPerUnit.requestFocus();
    }//GEN-LAST:event_TextFieldDiscountPerUnitMouseClicked

    private void ButtonReturnQTYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonReturnQTYActionPerformed

        float Balance = 0;
        String PaymentType = ReturnBillTable.getValueAt(ReturnBillTable.getSelectedRow(), 6).toString();
        ReturnTotal = ReturnBillTable.getValueAt(ReturnBillTable.getSelectedRow(), 4).toString();
        try {
            sqlInst = "DELETE FROM return_bill_temp";
            Pstatement = conn.prepareStatement(sqlInst);
            Pstatement.execute();

            for (String key : ReturnItemNames_Qty.keySet()) {
                Balance += ReturnItem(ReturnItemNames_Qty.get(key), key);
            }

            if (Balance >= 0) {
                ReturnBalance = "Rs. " + ConvertToCurrency(Balance);
            } else {
                ReturnBalance = "Rs. -" + ConvertToCurrency(Balance);
            }
            BillPrintReturn(BillID);

            JOptionPane.showMessageDialog(null, "Return successfull\nCustomer Balance = " + ReturnBalance, "Shop Management System", JOptionPane.INFORMATION_MESSAGE);
            ReturnItemNames_Qty.clear();
            //ReturnItemNames_Price.clear();
            ReturnNetTotal = "";
            ReturnTotal = "";
            ReturnBalance = "";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + ReturnBalance, "Shop Management System", JOptionPane.INFORMATION_MESSAGE);
        }

        BillID = "";
        ReuenCus();
    }//GEN-LAST:event_ButtonReturnQTYActionPerformed

    private void ButtonReturnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonReturnResetActionPerformed
        ReturnItemNames_Qty.clear();
        //ReturnItemNames_Price.clear();
        ReturnNetTotal = "";
        ReturnTotal = "";
        ReturnBalance = "";
        BillID = "";
        TextFieldReturnQTY.setText("1");
        ButtonReturnQTY.setEnabled(false);
        ButtonReturnReset.setEnabled(false);
    }//GEN-LAST:event_ButtonReturnResetActionPerformed

    private void ButtonRemoveBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRemoveBillActionPerformed
        int row = TabelBilling.getSelectedRow();
        String IID = TabelBilling.getValueAt(row, 0).toString();
        float ps = Float.valueOf(TabelBilling.getValueAt(row, 4).toString().replace(",", ""));
        float netT = Float.valueOf(TabelBilling.getValueAt(row, 6).toString().replace(",", ""));
        float d = Float.valueOf(TabelBilling.getValueAt(row, 5).toString().replace(",", ""));
        float q = Float.valueOf(TabelBilling.getValueAt(row, 3).toString());

        try {
            String sqlDT = "DELETE FROM `billitem` WHERE `Bill ID` = '" + BillID + "' AND `Item ID` = '" + IID + "'";
            Pstatement = conn.prepareStatement(sqlDT);
            Pstatement.execute();

            Total -= ps;
            NetDiscount -= d;
            NetTotal -= netT;
            sqlInst = "UPDATE `bill` SET `Total (Rs.)` = '" + Total + "', `Discount (Rs.)` = '" + NetDiscount + "', `Net Total (Rs.)` = '" + NetTotal + "' WHERE `Bill ID`= '" + BillID + "'";
            Pstatement = conn.prepareStatement(sqlInst);
            Pstatement.execute();

            String a = java.text.NumberFormat.getCurrencyInstance().format(NetTotal);
            a = a.replace("$", "");
            LabelNetTotal.setText("Rs. " + a);

            a = java.text.NumberFormat.getCurrencyInstance().format(NetDiscount);
            a = a.replace("$", "");
            LabelDiscount.setText("Discount  : Rs. " + a);

            a = java.text.NumberFormat.getCurrencyInstance().format(Total);
            a = a.replace("$", "");
            LabelTotal.setText("Total        : Rs. " + a);

            BLItemTableLoad(BillID);
            ButtonRemoveBill.setEnabled(false);
            BlanceCal();

            ItemUpdate(IID, q, 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

        if (!"No new notifications".equals(TextAreaNotifications.getText())) {
            TextAreaNotifications.setText("");
        }
        try {
            sqlresualt = "SELECT `Item ID` FROM `item`";
            Pstatement = conn.prepareStatement(sqlresualt);
            ResultSet r = Pstatement.executeQuery();
            while (r.next()) {
                String itmid = r.getString("Item ID");
                alert_qty(itmid);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_ButtonRemoveBillActionPerformed

    private void ButtonCancelItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelItemActionPerformed
        try {
            DefaultTableModel dmm = (DefaultTableModel) TabelBilling.getModel();
            int total_row = dmm.getRowCount();
            while (total_row > 0) {
                float q = Float.valueOf(TabelBilling.getValueAt(total_row - 1, 3).toString());
                String IID = TabelBilling.getValueAt(total_row - 1, 0).toString();
                ItemUpdate(IID, q, 1);
                total_row--;
            }

            sqlInst = "DELETE FROM `bill` WHERE `Bill ID` = '" + BillID + "'";
            Pstatement = conn.prepareStatement(sqlInst);
            Pstatement.execute();

            sqlInst = "DELETE FROM `billitem` WHERE `Bill ID` = '" + BillID + "'";
            Pstatement = conn.prepareStatement(sqlInst);
            Pstatement.execute();

            PaymentFinish();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

        if (!"No new notifications".equals(TextAreaNotifications.getText())) {
            TextAreaNotifications.setText("");
        }
        try {
            sqlresualt = "SELECT `Item ID` FROM `item`";
            Pstatement = conn.prepareStatement(sqlresualt);
            ResultSet r = Pstatement.executeQuery();
            while (r.next()) {
                String itmid = r.getString("Item ID");
                alert_qty(itmid);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_ButtonCancelItemActionPerformed

    private void TabelBillingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelBillingMouseClicked
        ButtonRemoveBill.setEnabled(true);
    }//GEN-LAST:event_TabelBillingMouseClicked

    private void RadioButtonCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonCashActionPerformed
        RadioButtonCard.setSelected(false);
        TextFieldCash.setEnabled(true);
        LabelCashTxt.setEnabled(true);
    }//GEN-LAST:event_RadioButtonCashActionPerformed

    private void RadioButtonCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonCardActionPerformed
        RadioButtonCash.setSelected(false);
        TextFieldCash.setEnabled(false);
        LabelCashTxt.setEnabled(false);
        TextFieldCash.setText("");
        LabelBalanceDisplayBalance.setText("Rs. 0.00");
    }//GEN-LAST:event_RadioButtonCardActionPerformed

    private void ButtonReturnToSuppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonReturnToSuppliersActionPerformed
        String ItemID = ReturnBillTable.getValueAt(ReturnBillTable.getSelectedRow(), 0).toString();// Get Item ID from selected row
        int Qty = Integer.valueOf(ReturnBillTable.getValueAt(ReturnBillTable.getSelectedRow(), 2).toString());// Get qty from selected row
        int ReturnQty = 0;
        String CaID = "";
        if (!(TextFieldReturnQTY.getText().isEmpty())) {
            ReturnQty = Integer.valueOf(TextFieldReturnQTY.getText());
        }

        if (Qty == 0) {
            JOptionPane.showMessageDialog(null, "This item is out of stock", "Shop Management System", JOptionPane.WARNING_MESSAGE);
        } else if (ReturnQty < 1 || Qty < ReturnQty) {
            JOptionPane.showMessageDialog(null, "Please enter valied quantity", "Shop Management System", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                sqlInst = "INSERT INTO `return _sup` (`Item ID`,`Cashier ID`, `Return Quantity`) VALUES('" + ItemID + "','" + CaID + "', '" + ReturnQty + "')";
                Pstatement = conn.prepareStatement(sqlInst);
                Pstatement.execute();

                sqlresualt = "SELECT `Item ID`, DATE_FORMAT(`Date & Time`,'%Y-%m-%d       %h:%i:%s %p') AS 'Date & Time', `Return Quantity` FROM `return _sup` ORDER BY `return _sup`.`Date & Time` DESC";
                Pstatement = conn.prepareStatement(sqlresualt);
                resualt = Pstatement.executeQuery();
                ReturnItemTable.setModel(DbUtils.resultSetToTableModel(resualt));

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
            }
            ItemUpdate(ItemID, ReturnQty, 0);
            ReuenSup();
        }
    }//GEN-LAST:event_ButtonReturnToSuppliersActionPerformed

    private void ButtonSendDayReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSendDayReportActionPerformed
        String Day = String.valueOf(LocalDate.now().getDayOfMonth());
        String Month = String.valueOf(LocalDate.now().getMonthValue());

        int H = LocalTime.now().getHour();
        int M = LocalTime.now().getMinute();
        String Hour = String.valueOf(H);
        String Minute = String.valueOf(M);

        if (H < 10) {
            Hour = "0" + Hour;
        }
        if (M < 10) {
            Minute = "0" + Minute;
        }

        if (LocalDate.now().getDayOfMonth() < 10) {
            Day = "0" + String.valueOf(LocalDate.now().getDayOfMonth());
        }
        if (LocalDate.now().getMonthValue() < 10) {
            Month = "0" + String.valueOf(LocalDate.now().getMonthValue());
        }
        String Date = LocalDate.now().getYear() + "-" + Month + "-" + Day;
        String Time = Hour + ":" + Minute;
        String Message = "===============Invoices===============<br>";
        Message += "Bill ID &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Time &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Net Total<br>";
        Message += "=====================================<br>";
        try {

            String SumPrice = null;
            String CashSumPrice = null;
            String CardSumPrice = null;
            int TotalInvoice = 0;

            sqlresualt = "SELECT Sum(`Net Total (Rs.)`), COUNT(`Bill ID`) FROM `bill` WHERE `Date & Time` LIKE '" + Date + "%'";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();

            while (resualt.next()) {
                SumPrice = ConvertToCurrency(resualt.getFloat("Sum(`Net Total (Rs.)`)"));
                TotalInvoice = resualt.getInt("COUNT(`Bill ID`)");
            }

            sqlresualt = "SELECT Sum(`Net Total (Rs.)`) FROM `bill` WHERE `Date & Time` LIKE '" + Date + "%' AND `Payment Method` LIKE 'Cash'";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();

            while (resualt.next()) {
                CashSumPrice = ConvertToCurrency(resualt.getFloat("Sum(`Net Total (Rs.)`)"));
            }

            sqlresualt = "SELECT Sum(`Net Total (Rs.)`) FROM `bill` WHERE `Date & Time` LIKE '" + Date + "%' AND `Payment Method` LIKE 'Card/ C.O. Delivery'";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();

            while (resualt.next()) {
                CardSumPrice = ConvertToCurrency(resualt.getFloat("Sum(`Net Total (Rs.)`)"));
            }

            sqlresualt = "SELECT `Net Total (Rs.)`, DATE_FORMAT(`Date & Time`,'%H:%i:%s'),`Payment Method`, `Bill ID` FROM `bill` WHERE `Date & Time` LIKE '" + Date + "%'";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();

            while (resualt.next()) {
                String PayMethod = resualt.getString("Payment Method");
                String BillID = resualt.getString("Bill ID");
                int n = BillID.length();
                /*if(n<15){
                 for(int i=0; i<17-n;i++){
                 BillID+="&nbsp;";
                 }
                 }
                 */
                if (PayMethod.equals("Cash") || PayMethod.equals("")) {
                    Message = Message + "<br>" + BillID + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resualt.getString("DATE_FORMAT(`Date & Time`,'%H:%i:%s')") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rs. " + ConvertToCurrency(resualt.getFloat("Net Total (Rs.)"));
                } else {
                    Message = Message + "<br>" + resualt.getString("Bill ID") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resualt.getString("DATE_FORMAT(`Date & Time`,'%H:%i:%s')") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rs. " + ConvertToCurrency(resualt.getFloat("Net Total (Rs.)")) + " (Card/ C.O. Delivery)";
                }

            }
            if (TotalInvoice > 0) {
                Message = "<br>Total Invoices&nbsp;&nbsp;= " + TotalInvoice + "<br><br></b>" + Message;
                Message = "<br>Net Total (Card/ C.O. Delivery )&nbsp;&nbsp;= Rs. " + CardSumPrice + Message;
                Message = "<br>Net Total (Cash)&nbsp;&nbsp;= Rs. " + CashSumPrice + Message;
                Message = "<b>Total Earn&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;= Rs. " + SumPrice + Message;
                Message = "<font face=\"FIXED WIDTH\" >" + Message + "</font>";
            } else {
                Message = "<br><br>Total Invoices&nbsp;&nbsp;= " + TotalInvoice + "</b>";
                Message = "<br><br>Net Total (Card/ C.O. Delivery )&nbsp;&nbsp;= Rs. " + CardSumPrice + Message;
                Message = "<br><br>Net Total (Cash)&nbsp;&nbsp;= Rs. " + CashSumPrice + Message;
                Message = "<b>Total Earn&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;= Rs. " + SumPrice + Message;
                Message = "<font face=\"FIXED WIDTH\" >" + Message + "</font>";
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

        final String username = "aanyafashion.dailyreport@gmail.com";
        final String password = "4321!@#$qW10";
        MimeBodyPart mbp1 = new MimeBodyPart();
        MimeMultipart mp = new MimeMultipart();
        try {
            mbp1.setContent(Message, "text/html");
            mp.addBodyPart(mbp1);
        } catch (MessagingException ex) {
            JOptionPane.showMessageDialog(null, ex, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    MimeMessage.RecipientType.TO,
                    InternetAddress.parse("aanyasrilanka@gmail.com")
            );
            message.setSubject("Day End Report " + Date + "  " + Time);
            message.setContent(mp);

            ButtonSendDayReport.setText("   Sending...");
            LabelDayReportIcon.setEnabled(false);
            Transport.send(message);

            ButtonSendDayReport.setText("  Send Day End Report");
            LabelDayReportIcon.setEnabled(true);
            JOptionPane.showMessageDialog(null, "Day end report sent", "Shop Management System", JOptionPane.INFORMATION_MESSAGE);
        } catch (MessagingException e) {
            ButtonSendDayReport.setText("  Send Day End Report");
            LabelDayReportIcon.setEnabled(true);
            JOptionPane.showMessageDialog(null, "Send failed !  Check your internet connection", "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_ButtonSendDayReportActionPerformed

    private void BLCRptRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLCRptRadioButton1ActionPerformed
        BLCRptRadioButton1.setSelected(true);
        ReturnCRptRadioButton.setSelected(false);
        AllRptRadioButton.setSelected(false);
        BLCRptRadioButton.setSelected(false);
        hstCheckBox.setSelected(false);
        hstCheckBox.setEnabled(false);
        fullbillrtlabel.setVisible(false);

        try {
            String sqlload = "SELECT `Bill ID`, DATE_FORMAT(`Date & Time`,'%Y-%m-%d       %h:%i %p') AS 'Date & Time', FORMAT(`bill`.`Total (Rs.)`,2) AS 'Total (Rs.)', FORMAT(`bill`.`Discount (Rs.)`,2) AS 'Discount (Rs.)', FORMAT(`bill`.`Net Total (Rs.)`,2) AS 'Net Total (Rs.)', FORMAT(`Balance (Rs.)`,2) AS 'Balance (Rs.)', `Payment Method` FROM `bill` WHERE `Payment Method` LIKE 'Card/ C.O. Delivery' ORDER BY `bill`.`Date & Time` DESC";
            Pstatement = conn.prepareStatement(sqlload);
            resualt = Pstatement.executeQuery();
            PurchaseBillTable.setModel(DbUtils.resultSetToTableModel(resualt));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

        bl_itemClear();
    }//GEN-LAST:event_BLCRptRadioButton1ActionPerformed

    private void rSButtonRiple1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonRiple1ActionPerformed
        ItemButtonClick();
    }//GEN-LAST:event_rSButtonRiple1ActionPerformed

    private void rSButtonRiple2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonRiple2ActionPerformed
        BillingButtonClick();
    }//GEN-LAST:event_rSButtonRiple2ActionPerformed

    private void OderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OderButtonActionPerformed
        OrdersButtonClick();
    }//GEN-LAST:event_OderButtonActionPerformed

    private void rSButtonRiple4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonRiple4ActionPerformed
        CustomerButtonClick();
    }//GEN-LAST:event_rSButtonRiple4ActionPerformed

    private void SupplierButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupplierButtonActionPerformed
        SupplierButtonClick();
    }//GEN-LAST:event_SupplierButtonActionPerformed

    private void CashierButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CashierButtonActionPerformed
        CashierButtonClick();
    }//GEN-LAST:event_CashierButtonActionPerformed

    private void ReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportButtonActionPerformed
        ReportButtonClick();
    }//GEN-LAST:event_ReportButtonActionPerformed

    private void ReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtonActionPerformed
        ReturnButtonClick();
    }//GEN-LAST:event_ReturnButtonActionPerformed

    private void ComboBoxBillingItemIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboBoxBillingItemIDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            TextFieldBillingQuantity.requestFocus();
            jScrollPaneList.setVisible(false);
        }
    }//GEN-LAST:event_ComboBoxBillingItemIDKeyPressed

    private void ComboBoxBillingItemIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboBoxBillingItemIDKeyReleased
        if (ComboBoxBillingItemID.getText().equals("")) {
            jScrollPaneList.setVisible(false);
        } else {
            jList1.removeAll();
            String ItemName = "";
            try {
                DefaultListModel listModel = new DefaultListModel();
                String sqlload = "SELECT `Item Name` FROM item WHERE `item name` Like '" + ComboBoxBillingItemID.getText() + "%'OR `item id` Like '" + ComboBoxBillingItemID.getText() + "'";
                Pstatement = conn.prepareStatement(sqlload);
                resualt = Pstatement.executeQuery();

                while (resualt.next()) {
                    ItemName = resualt.getString("Item Name");
                    listModel.addElement(ItemName);

                }
                if (ItemName.equals("")) {
                    itemIDLoad();
                } else {
                    jList1.setModel(listModel);
                    jScrollPaneList.setVisible(true);
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
            }
        }

    }//GEN-LAST:event_ComboBoxBillingItemIDKeyReleased

    private void ComboBoxBillingItemIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ComboBoxBillingItemIDFocusLost
        jScrollPaneList.setVisible(false);
    }//GEN-LAST:event_ComboBoxBillingItemIDFocusLost

    private void PanelBillingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelBillingMouseClicked
        jScrollPaneList.setVisible(false);
    }//GEN-LAST:event_PanelBillingMouseClicked

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        ComboBoxBillingItemID.setText(jList1.getSelectedValue().toString());
        jScrollPaneList.setVisible(false);
        TextFieldBillingQuantity.requestFocus();
    }//GEN-LAST:event_jList1ValueChanged

    private void jLabel61MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel61MouseClicked
        if (jScrollPaneList.isVisible()) {
            jScrollPaneList.setVisible(false);
        } else {
            itemIDLoad();
            jScrollPaneList.setVisible(true);
        }
    }//GEN-LAST:event_jLabel61MouseClicked

    public float ReturnItem(int ReturnQty, String ItemName) {
        float Balance = 0;
        try {
            float ItemPrice = 0;
            float ItemNetTotal = 0;
            float ItemTotal = 0;
            float ItemDiscount = 0;
            float SellingPrice = 0;
            float ReturnItemPrice = 0;
            float ReturnItemSellingPrice = 0;
            float AvailableItemTotalPrice = 0;
            float AvailableItemNetTotalPrice = 0;
            float PerItemDiscount = 0;
            float ReturnItemDiscount = 0;
            float AvailableItemDiscount = 0;
            String ItemID = "";
            int Qty = 0;

            sqlresualt = "SELECT `Item ID`, `Selling Price (Rs.)`, `Price (Rs.)`, `Quantity`, `Total (Rs.)`, `Discount (Rs.)`, `Net Total (Rs.)` FROM `billitem` WHERE `Bill ID` = '" + BillID + "' AND `Item Name` = '" + ItemName + "'";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            while (resualt.next()) {
                Qty = resualt.getInt("Quantity");
                ItemDiscount = resualt.getFloat("Discount (Rs.)");
                ItemTotal = resualt.getFloat("Total (Rs.)");
                ItemNetTotal = resualt.getFloat("Net Total (Rs.)");
                ItemPrice = resualt.getFloat("Price (Rs.)");
                ItemID = resualt.getString("Item ID");
                SellingPrice = resualt.getFloat("Selling Price (Rs.)");
            }

            // For previous version match ...
            if (ItemID.equals("") || ItemID.equals(null)) {
                sqlresualt = "SELECT `Item ID` FROM item WHERE `Item Name` LIKE '" + ItemName + "'";
                try {
                    Pstatement = conn.prepareStatement(sqlresualt);
                    resualt = Pstatement.executeQuery();
                    while (resualt.next()) {
                        ItemID = resualt.getString("Item ID");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
                }

                sqlresualt = "SELECT `Selling Price (Rs.)`, `Price (Rs.)`, `Quantity`, `Total (Rs.)`, `Discount (Rs.)`, `Net Total (Rs.)` FROM `billitem` WHERE `Bill ID` = '" + BillID + "' AND `Item ID` = '" + ItemID + "'";
                Pstatement = conn.prepareStatement(sqlresualt);
                resualt = Pstatement.executeQuery();
                while (resualt.next()) {
                    Qty = resualt.getInt("Quantity");
                    ItemDiscount = resualt.getFloat("Discount (Rs.)");
                    ItemTotal = resualt.getFloat("Total (Rs.)");
                    ItemNetTotal = resualt.getFloat("Net Total (Rs.)");
                    ItemPrice = resualt.getFloat("Price (Rs.)");
                    SellingPrice = resualt.getFloat("Selling Price (Rs.)");
                }
            }

            if (ItemDiscount > 0) {
                PerItemDiscount = ItemDiscount / Qty; //discount per unit
                ReturnItemDiscount = PerItemDiscount * ReturnQty; //return discount
                AvailableItemDiscount = ItemDiscount - ReturnItemDiscount; //avilible discount
                AvailableItemDiscount = ConvertToCurrencyValue(AvailableItemDiscount);
            }

            ReturnItemPrice = ReturnQty * ItemPrice;
            ReturnItemPrice = ConvertToCurrencyValue(ReturnItemPrice);

            ReturnItemSellingPrice = SellingPrice * ReturnQty;
            ReturnItemSellingPrice = ConvertToCurrencyValue(ReturnItemSellingPrice);

            AvailableItemTotalPrice = ItemTotal - ReturnItemSellingPrice;
            AvailableItemTotalPrice = ConvertToCurrencyValue(AvailableItemTotalPrice);

            AvailableItemNetTotalPrice = ItemNetTotal - ReturnItemPrice;
            AvailableItemNetTotalPrice = ConvertToCurrencyValue(AvailableItemNetTotalPrice);

            sqlInst = "UPDATE `billitem` SET  `Quantity` = `Quantity`-" + ReturnQty + ",`Total (Rs.)` = '" + AvailableItemTotalPrice + "', `Discount (Rs.)` = '" + AvailableItemDiscount + "', `Net Total (Rs.)` = '" + AvailableItemNetTotalPrice + "' WHERE `Bill ID` = '" + BillID + "' AND `Item ID` = '" + ItemID + "'";
            Pstatement = conn.prepareStatement(sqlInst);
            Pstatement.execute();

            float Total = 0;
            float Discount = 0;
            float NetTotal = 0;
            Balance = Float.valueOf(ReturnBillTable.getValueAt(ReturnBillTable.getSelectedRow(), 5).toString().replace(",", ""));

            sqlresualt = "SELECT `Total (Rs.)`, `Discount (Rs.)`, `Net Total (Rs.)`, `Balance (Rs.)` FROM `bill` WHERE `Bill ID` = '" + BillID + "'";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            while (resualt.next()) {
                Total = resualt.getFloat("Total (Rs.)");
                NetTotal = resualt.getFloat("Net Total (Rs.)");
                Discount = resualt.getFloat("Discount (Rs.)");
                Balance = resualt.getFloat("Balance (Rs.)");
            }

            float AvailableTotal = 0;
            float AvailableDiscount = 0;
            float AvailableNetTotal = 0;

            AvailableTotal = Total - ReturnItemSellingPrice;
            AvailableDiscount = Discount - ReturnItemDiscount;
            AvailableNetTotal = NetTotal - ReturnItemPrice;

            AvailableTotal = ConvertToCurrencyValue(AvailableTotal);
            AvailableDiscount = ConvertToCurrencyValue(AvailableDiscount);
            AvailableNetTotal = ConvertToCurrencyValue(AvailableNetTotal);

            ReturnNetTotal = ConvertToCurrency(AvailableNetTotal);
            //ReturnItemNames_Price.put(ItemName, ConvertToCurrency(ReturnItemPrice));

            sqlInst = "INSERT INTO `return_bill_temp` (`Bill ID`,`Item Name`,`User Name`, `Quantity`, `Price (Rs.)`, `Total (Rs.)`) VALUES('" + BillID + "','" + ItemName + "', '" + LabelUserName.getText() + "','" + ReturnQty + "','" + ItemPrice + "','" + ReturnItemPrice + "')";
            Pstatement = conn.prepareStatement(sqlInst);
            Pstatement.execute(sqlInst);

            Balance += ReturnItemPrice;
            String BillSQLQuery = null;
            String ReturnBillSQLQuery = null;
            if (Balance < 0) {
                BillSQLQuery = "UPDATE `bill` SET `Total (Rs.)` = " + AvailableTotal + ", `Discount (Rs.)` = " + AvailableDiscount + ", `Net Total (Rs.)` = '" + AvailableNetTotal + "', `Balance (Rs.)` ='" + Balance + "'  WHERE `Bill ID` = '" + BillID + "' ";
                ReturnBillSQLQuery = "INSERT INTO `return_bill` (`Bill ID`,`Item ID`,`Item Name`,`User Name`, `Return Quantity`, `Balance (Rs.)`) VALUES('" + BillID + "','" + ItemID + "', '" + ItemName + "', '" + LabelUserName.getText() + "','" + ReturnQty + "', '0')";
            } else {
                BillSQLQuery = "UPDATE `bill` SET `Total (Rs.)` = " + AvailableTotal + ", `Discount (Rs.)` = " + AvailableDiscount + ", `Net Total (Rs.)` = '" + AvailableNetTotal + "', `Balance (Rs.)` = '0'  WHERE `Bill ID` = '" + BillID + "' ";
                ReturnBillSQLQuery = "INSERT INTO `return_bill` (`Bill ID`,`Item ID`,`Item Name`,`User Name`, `Return Quantity`, `Balance (Rs.)`) VALUES('" + BillID + "','" + ItemID + "', '" + ItemName + "', '" + LabelUserName.getText() + "','" + ReturnQty + "','" + ReturnItemPrice + "')";
            }
            Pstatement = conn.prepareStatement(BillSQLQuery);
            Pstatement.execute();

            Pstatement = conn.prepareStatement(ReturnBillSQLQuery);
            Pstatement.execute();

            ItemUpdate(String.valueOf(ItemID), ReturnQty, 1);
        } catch (NumberFormatException | SQLException e) {

        }
        return Balance;
    }

    private void NetProfit() {
        float eb = 0;
        float w = 0;
        float o = 0;
        try {
            eb = Float.valueOf(Ebill_TextField.getText());
            w = Float.valueOf(Wbill_TextField.getText());
            o = Float.valueOf(Othercost_TextField.getText());
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Invalied input!", "Shop Management System",JOptionPane.WARNING_MESSAGE);
        }

        try {
            w = Float.valueOf(Wbill_TextField.getText());
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Invalied input!", "Shop Management System",JOptionPane.WARNING_MESSAGE);
        }

        try {
            o = Float.valueOf(Othercost_TextField.getText());
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Invalied input!", "Shop Management System",JOptionPane.WARNING_MESSAGE);
        }

        float c = eb + w + o;
        String t_earn = Monthly_T_ernLabel.getText();
        t_earn = t_earn.replace("Total Earn          :  Rs. ", "");
        t_earn = t_earn.replace(",", "");

        float t_e = Float.valueOf(t_earn);

        t_earn = total_item_costLabel.getText();
        t_earn = t_earn.replace("Total Item Cost  :  Rs. ", "");
        t_earn = t_earn.replace(",", "");

        float t_icost = Float.valueOf(t_earn);

        float cp = t_e - t_icost;
        cp -= c;

        t_earn = java.text.NumberFormat.getCurrencyInstance().format(cp);
        t_earn = t_earn.replace("$", "");
        t_earn = t_earn.replace(")", "");
        t_earn = t_earn.replace("(", "");

        if (cp > -1) {
            netp_label.setForeground(new Color(0, 0, 153));
            ProfitLabel.setForeground(new Color(0, 0, 153));
            ProfitLabel.setText("  Rs. " + t_earn);
        } else {
            netp_label.setForeground(new Color(204, 0, 0));
            ProfitLabel.setForeground(new Color(204, 0, 0));
            ProfitLabel.setText("  Rs. -" + t_earn);
        }
    }

    private void MonthReport(String yrmonth) {
        try {
            String SumPrice = "";
            float total_earn = 0;
            float total_cost = 0;
            netp_label.setForeground(new Color(0, 0, 153));
            ProfitLabel.setForeground(new Color(0, 0, 153));

            sqlresualt = "SELECT Sum(`Net Total (Rs.)`), `Bill ID` FROM `bill` WHERE `Date & Time` LIKE '" + yrmonth + "%'";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();

            while (resualt.next()) {
                total_earn = resualt.getFloat("Sum(`Net Total (Rs.)`)");
            }
            SumPrice = java.text.NumberFormat.getCurrencyInstance().format(total_earn);
            SumPrice = SumPrice.replace("$", "");
            SumPrice = SumPrice.replace(")", "");
            SumPrice = SumPrice.replace(")", "");
            Monthly_T_ernLabel.setText("Total Earn          :  Rs. " + SumPrice);

            //get biil ids
            sqlresualt = "SELECT `Bill ID` FROM `bill` WHERE `Date & Time` LIKE '" + yrmonth + "%'";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();

            while (resualt.next()) {
                String bID = resualt.getString("Bill ID");

                String sqlresualtnew = "SELECT `Buying Price (Rs.)`, `Quantity` FROM `billitem` WHERE `Bill ID` = '" + bID + "'";
                PreparedStatement Pstatementnew = conn.prepareStatement(sqlresualtnew);
                ResultSet resualtnew = Pstatementnew.executeQuery();

                int q = 0;
                float bprice = 0;
                while (resualtnew.next()) {
                    q = resualtnew.getInt("Quantity");
                    bprice = resualtnew.getFloat("Buying Price (Rs.)");

                    bprice *= q;
                    SumPrice = java.text.NumberFormat.getCurrencyInstance().format(bprice);
                    SumPrice = SumPrice.replace("$", "");
                    SumPrice = SumPrice.replace(")", "");
                    SumPrice = SumPrice.replace("(", "");
                    SumPrice = SumPrice.replace(",", "");
                    bprice = Float.valueOf(SumPrice);
                    total_cost += bprice;
                }

            }

            SumPrice = java.text.NumberFormat.getCurrencyInstance().format(total_cost);
            SumPrice = SumPrice.replace("$", "");
            SumPrice = SumPrice.replace(")", "");
            SumPrice = SumPrice.replace("(", "");

            total_item_costLabel.setText("Total Item Cost  :  Rs. " + SumPrice);

            SumPrice = java.text.NumberFormat.getCurrencyInstance().format(total_earn - total_cost);
            SumPrice = SumPrice.replace("$", "");
            SumPrice = SumPrice.replace(")", "");
            SumPrice = SumPrice.replace("(", "");

            ProfitLabel.setText("  Rs. " + SumPrice);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

        Ebill_TextField.setText("");
        Wbill_TextField.setText("");
        Othercost_TextField.setText("");
    }

    private void FindMonthName(int yr, int month) {
        switch (month) {
            case 1:
                TitleMonth_Label.setText(yr + " January Report");
                break;
            case 2:
                TitleMonth_Label.setText(yr + " February Report");
                break;
            case 3:
                TitleMonth_Label.setText(yr + " March Report");
                break;
            case 4:
                TitleMonth_Label.setText(yr + " Aprial Report");
                break;
            case 5:
                TitleMonth_Label.setText(yr + " May Report");
                break;
            case 6:
                TitleMonth_Label.setText(yr + " June Report");
                break;
            case 7:
                TitleMonth_Label.setText(yr + " July Report");
                break;
            case 8:
                TitleMonth_Label.setText(yr + " August Report");
                break;
            case 9:
                TitleMonth_Label.setText(yr + " September Report");
                break;
            case 10:
                TitleMonth_Label.setText(yr + " Octomber Report");
                break;
            case 11:
                TitleMonth_Label.setText(yr + " November Report");
                break;
            case 12:
                TitleMonth_Label.setText(yr + " December Report");
                break;
            default:
                TitleMonth_Label.setText("Select Year & Month");
        }
    }
    /*
     public PageFormat getPageFormat(PrinterJob pj) {

     PageFormat pf = pj.defaultPage();
     Paper paper = pf.getPaper();

     double bodyHeight = bHeight;
     double headerHeight = 9.0;
     double footerHeight = 8.0;      //7  
     double width = cm_to_pp(11);
     double height = cm_to_pp(headerHeight + bodyHeight + footerHeight);
     paper.setSize(width, height);
     paper.setImageableArea(0, 10, width, height);
     //paper.setImageableArea(0,10,width,height - cm_to_pp(1)); 

     pf.setOrientation(PageFormat.PORTRAIT);
     pf.setPaper(paper);

     return pf;
     }

     protected static double cm_to_pp(double cm) {
     return toPPI(cm * 0.393600787);
     }

     protected static double toPPI(double inch) {
     return inch * 72d;
     }

     public class BillPrintable implements Printable {

     public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
     throws PrinterException {

     ImageIcon icon = new ImageIcon("C:\\Program Files\\Aanya Fashion Store\\Images\\Aanya_Logo.png");
     int result = NO_SUCH_PAGE;
     if (pageIndex == 0) {

     Graphics2D g2d = (Graphics2D) graphics;
     double width = pageFormat.getImageableWidth();
     g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());
     ;
     try {
     //int n=TabelBilling.getRowCount();
     int y = 20;
     int yShift = 11;
     int headerRectHeight = 15;

     String day = String.valueOf(LocalDate.now().getDayOfMonth());
     String month = String.valueOf(LocalDate.now().getMonthValue());
     String h = String.valueOf(LocalTime.now().getHour());
     String m = String.valueOf(LocalTime.now().getMinute());
     if (LocalDate.now().getDayOfMonth() < 10) {
     day = "0" + day;
     }
     if (LocalDate.now().getMonthValue() < 10) {
     month = "0" + month;
     }
     if (LocalTime.now().getHour() < 10) {
     h = "0" + h;
     }
     if (LocalTime.now().getMinute() < 10) {
     m = "0" + m;
     }
     String date_time = LocalDate.now().getYear() + "-" + month + "-" + day + "  " + h + ":" + m;

     g2d.drawImage(icon.getImage(), 42, 6, 143, 100, rootPane);
     y += yShift + 82;
     g2d.setFont(new Font("Book Antiqua ", Font.PLAIN, 6));
     g2d.drawString("                     T H E  F A S H I O N  S T O R E ", 35, y);
     y += yShift + 4;
     g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
     g2d.drawString("           150C Main Street ", 12, y);
     y += yShift;
     g2d.drawString("             Battaramulla   ", 12, y);
     y += yShift;
     g2d.drawString("             www.aanya.lk   ", 12, y);
     y += yShift;
     g2d.drawString("            +94 719517428   ", 13, y);
     y += yShift;
     g2d.drawString("       aanyasrilanka@gmail.com", 14, y);
     y += yShift;
     /*if(n==1 && discount<1)
     {
     g2d.drawString("+94719517428  aanyasrilanka@gmail.com",14,y);y+=yShift;
     }
            
     else{
     g2d.drawString("+94719517428  aanyasrilanka@gmail.com",7,y);y+=yShift;
     }

     g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
     g2d.setColor(Color.GRAY);
     g2d.drawString("----------------------------------------", 10, y);
     y += 8;
     g2d.setColor(Color.BLACK);
     g2d.drawString(" " + date_time, 12, y);
     y += yShift;
     g2d.drawString(" Bill ID: " + BillID, 12, y);
     y += yShift;
     g2d.drawString(" Cashier: " + LabelUserName.getText(), 12, y);
     y += headerRectHeight;
     g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
     g2d.setColor(Color.GRAY);
     g2d.drawString("----------------------------------------", 10, y);
     y += 7;
     g2d.setColor(Color.BLACK);
     g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
     g2d.drawString(" Item Name                          ", 10, y);
     y += yShift + 2;
     g2d.drawString("  QTY  Price             Total Amount", 10, y);
     y += 8;
     g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
     g2d.setColor(Color.GRAY);
     g2d.drawString("----------------------------------------", 10, y);
     y += yShift;
     g2d.setColor(Color.BLACK);
     g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));

     for (int i = 0; i < TabelBilling.getRowCount(); i++) {
     String itemName = TabelBilling.getValueAt(i, 1).toString();
     String itemPrice = TabelBilling.getValueAt(i, 2).toString();
     String quantity = TabelBilling.getValueAt(i, 3).toString();
     String subtotal = TabelBilling.getValueAt(i, 4).toString();
     g2d.drawString(" " + itemName + "                            ", 10, y);
     y += yShift + 2;
     g2d.drawString("  " + quantity + " * " + itemPrice, 12, y);
     g2d.drawString(subtotal, 145, y);
     y += yShift + 2;

     }
     g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
     g2d.setColor(Color.GRAY);
     g2d.drawString("----------------------------------------", 10, y);
     y += yShift + 10;
     g2d.setColor(Color.BLACK);
     g2d.setFont(new Font("Monospaced", Font.BOLD, 12));

     if (NetDiscount > 0) {
     String c = java.text.NumberFormat.getCurrencyInstance().format(Total);
     c = c.replace("$", "");
     g2d.drawString(" Total        Rs. " + c + "   ", 10, y);
     y += yShift + 2;
     c = java.text.NumberFormat.getCurrencyInstance().format(NetDiscount);
     c = c.replace("$", "");
     g2d.drawString(" Discount     Rs. " + c + "   ", 10, y);
     y += yShift + yShift;

     }

     g2d.setFont(new Font("Monospaced", Font.BOLD, 12));
     g2d.drawString(" Net Total    " + LabelNetTotal.getText() + "    ", 10, y);
     y += yShift + 2;
     if (RadioButtonCash.isSelected()) {
     // g2d.setFont(new Font("Monospaced",Font.BOLD,12));
     g2d.drawString(" Cash         Rs. " + ConvertToCurrency(Float.valueOf(TextFieldCash.getText())) + "   ", 10, y);
     y += yShift + 2;
     g2d.drawString(" Balance      " + LabelBalanceDisplayBalance.getText() + "   ", 10, y);
     } else {
     g2d.drawString(" Payment by", 10, y + 4);
     y += yShift + 5;
     g2d.drawString(" card/ cash on delivery", 10, y);
     }

     y += yShift;

     g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
     g2d.drawString(" ", 10, y);
     y += yShift;
     g2d.drawString("****************************************", 10, y);
     y += 10;
     g2d.drawString("      Hope you enjoy your purchase", 10, y);
     y += yShift + 2;
     g2d.drawString("              Thank you!", 10, y);
     y += yShift;
     g2d.drawString("****************************************", 10, y);
     y += yShift;
     g2d.drawString(" ", 10, y);
     y += yShift;
     g2d.setFont(new Font("Monospaced", Font.PLAIN, 7));
     g2d.drawString("       SYSTEM BY Thakshara (077 659 1828) ", 20, y);

     } catch (Exception e) {
     e.printStackTrace();
     }

     result = PAGE_EXISTS;
     }
     return result;
     }

     }

     public void recept80mm_print() {
     int n = TabelBilling.getRowCount();
     bHeight = Double.valueOf(TabelBilling.getRowCount());
     if ((n > 8) && (NetDiscount > 0)) {
     bHeight += 250;
     } else if ((n > 6) && (NetDiscount > 0)) {
     bHeight += 200;
     } else if ((n == 3) && (NetDiscount > 0)) {
     bHeight += 170;
     } else if ((n > 0) && (NetDiscount > 0)) {
     bHeight += 150;
     } else {
     if ((n > 0) && (n < 4) && (NetDiscount == 0)) {
     bHeight += 50;
     } else if ((n > 3) && (n < 7) && (NetDiscount == 0)) {
     bHeight += 70;
     } else if ((n > 10) && (NetDiscount == 0)) {
     bHeight += 100;
     }
     }
     PrinterJob pj = PrinterJob.getPrinterJob();
     pj.setPrintable(new BillPrintable(), getPageFormat(pj));
     try {
     pj.print();

     } catch (PrinterException ex) {
     ex.printStackTrace();
     }
     }

     public PageFormat getPageFormat2(PrinterJob pj) {

     PageFormat pf = pj.defaultPage();
     Paper paper = pf.getPaper();

     double width = cm_to_pp(10);
     double height = cm_to_pp(150);
     paper.setSize(width, height);
     paper.setImageableArea(0, 10, width, height);
     //paper.setImageableArea(0,10,width,height - cm_to_pp(1)); 

     pf.setOrientation(PageFormat.PORTRAIT);
     pf.setPaper(paper);

     return pf;
     }
     /*
     public class ReturnBillPrintable implements Printable {

     public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
     throws PrinterException {

     ImageIcon icon = new ImageIcon("C:\\Program Files\\Aanya Fashion Store\\Images\\Aanya_Logo.png");
     int result = NO_SUCH_PAGE;
     if (pageIndex == 0) {

     Graphics2D g2d = (Graphics2D) graphics;
     double width = pageFormat.getImageableWidth();
     g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());

     try {
     int y = 20;
     int yShift = 11;
     int headerRectHeight = 15;

     String day = String.valueOf(LocalDate.now().getDayOfMonth());
     String month = String.valueOf(LocalDate.now().getMonthValue());
     String h = String.valueOf(LocalTime.now().getHour());
     String m = String.valueOf(LocalTime.now().getMinute());
     if (LocalDate.now().getDayOfMonth() < 10) {
     day = "0" + day;
     }
     if (LocalDate.now().getMonthValue() < 10) {
     month = "0" + month;
     }
     if (LocalTime.now().getHour() < 10) {
     h = "0" + h;
     }
     if (LocalTime.now().getMinute() < 10) {
     m = "0" + m;
     }
     String date_time = LocalDate.now().getYear() + "-" + month + "-" + day + "  " + h + ":" + m;

     g2d.drawImage(icon.getImage(), 42, 6, 143, 100, rootPane);
     y += yShift + 82;
     g2d.setFont(new Font("Book Antiqua ", Font.PLAIN, 6));
     g2d.drawString("                     T H E  F A S H I O N  S T O R E ", 35, y);
     y += yShift + 4;
     g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
     g2d.drawString("           150C Main Street ", 12, y);
     y += yShift;
     g2d.drawString("             Battaramulla   ", 12, y);
     y += yShift;
     g2d.drawString("             www.aanya.lk   ", 12, y);
     y += yShift;
     g2d.drawString("            +94 719517428   ", 13, y);
     y += yShift;
     g2d.drawString("       aanyasrilanka@gmail.com", 14, y);
     y += yShift;
     //g2d.drawString("+94719517428  aanyasrilanka@gmail.com",12,y);y+=yShift;
     g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
     g2d.setColor(Color.GRAY);
     g2d.drawString("----------------------------------------", 14, y);
     y += yShift;
     g2d.setColor(Color.BLACK);
     g2d.drawString(" " + date_time, 12, y);
     y += yShift;
     g2d.drawString(" Bill ID: " + BillID, 12, y);
     y += yShift;
     g2d.drawString(" Cashier: " + LabelUserName.getText(), 12, y);
     y += headerRectHeight;

     g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
     g2d.setColor(Color.GRAY);
     g2d.drawString("----------------------------------------", 12, y);
     y += yShift;
     g2d.setColor(Color.BLACK);
     g2d.setFont(new Font("Monospaced", Font.PLAIN, 10));

     g2d.drawString(" Retrurn Item    Qty    Net Amount      ", 10, y);
     y += yShift;
     g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
     g2d.setColor(Color.GRAY);
     g2d.drawString("----------------------------------------", 12, y);
     y += yShift + 5;
     g2d.setColor(Color.BLACK);
     g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
     float rtn = 0;
     String a = null;
     for (String key : ReturnItemNames_Price.keySet()) {
     try {

     g2d.drawString(key + "  *  " + ReturnItemNames_Qty.get(key), 17, y);
     g2d.drawString("Rs. " + ReturnItemNames_Price.get(key), 150, y);
     y += yShift;
                            
     rtn += Float.valueOf(ReturnItemNames_Price.get(key).replace(",", ""));

     } catch (Exception e) {

     }
     }

     g2d.setColor(Color.GRAY);
     g2d.drawString("----------------------------------------", 12, y);
     y += yShift + 5;

     g2d.setFont(new Font("Monospaced", Font.BOLD, 12));
     g2d.setColor(Color.BLACK);
     g2d.drawString(" Total        Rs. " + ReturnTotal + "   ", 10, y);
     y += yShift + 2;
     g2d.drawString(" Retrurn      Rs. " + ConvertToCurrency(rtn) + "   ", 10, y);
     y += yShift + 2;
     g2d.drawString(" Net Total    Rs. " + ReturnNetTotal + "   ", 10, y);
     y += yShift + 4;
     g2d.drawString(" Balance      " + ReturnBalance + "   ", 10, y);
     y += yShift;

     g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
     g2d.drawString(" ", 10, y);
     y += yShift;
     g2d.drawString("****************************************", 12, y);
     y += 10;
     g2d.drawString("      Hope you enjoy your purchase", 10, y);
     y += yShift + 2;
     g2d.drawString("              Thank you!", 10, y);
     y += yShift;
     g2d.drawString("****************************************", 12, y);
     y += yShift;
     g2d.drawString(" ", 10, y);
     y += yShift;
     g2d.setFont(new Font("Monospaced", Font.PLAIN, 7));
     g2d.drawString("       SYSTEM BY Thakshara (077 659 1828) ", 20, y);

     } catch (Exception e) {
     e.printStackTrace();
     }

     result = PAGE_EXISTS;
     }
     return result;
     }

     }

     public void recept80mm_Returnprint() {

     PrinterJob pj = PrinterJob.getPrinterJob();
     pj.setPrintable(new ReturnBillPrintable() {
     }, getPageFormat2(pj));
     try {
     pj.print();

     } catch (PrinterException ex) {
     ex.printStackTrace();
     }
     }
     */

    private void BillPrintCashNormal(String BillID) {
        HashMap m = new HashMap();
        m.put("BillID", BillID);
        m.put("Balance", LabelBalanceDisplayBalance.getText().replace("Rs. ", ""));
        try {
            String path = "C:\\Program Files\\Aanya Fashion Store\\lib\\BillRecipt.jrxml";
            InputStream rf = new FileInputStream(new File(path));
            JasperDesign jd = JRXmlLoader.load(rf);

            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, m, conn);
            //JasperViewer.viewReport(jp,false);
            JasperPrintManager.printReport(jp, false);
        } catch (Exception e) {

        }
    }

    private void BillPrintCashDiscount(String BillID) {
        HashMap m = new HashMap();
        m.put("BillID", BillID);
        m.put("Balance", LabelBalanceDisplayBalance.getText().replace("Rs. ", ""));
        try {
            String path = "C:\\Program Files\\Aanya Fashion Store\\lib\\BillReportDiscount.jrxml";
            InputStream rf = new FileInputStream(new File(path));
            JasperDesign jd = JRXmlLoader.load(rf);

            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, m, conn);
            //JasperViewer.viewReport(jp,false);
            JasperPrintManager.printReport(jp, false);
        } catch (Exception e) {

        }
    }

    private void BillPrintCardNormal(String BillID) {
        HashMap m = new HashMap();
        m.put("BillID", BillID);
        try {
            String path = "C:\\Program Files\\Aanya Fashion Store\\lib\\BillReciptCard.jrxml";
            InputStream rf = new FileInputStream(new File(path));
            JasperDesign jd = JRXmlLoader.load(rf);

            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, m, conn);
            //JasperViewer.viewReport(jp,false);
            JasperPrintManager.printReport(jp, false);
        } catch (Exception e) {

        }
    }

    private void BillPrintCardDiscount(String BillID) {
        HashMap m = new HashMap();
        m.put("BillID", BillID);
        try {
            String path = "C:\\Program Files\\Aanya Fashion Store\\lib\\BillReportCardDiscount.jrxml";
            InputStream rf = new FileInputStream(new File(path));
            JasperDesign jd = JRXmlLoader.load(rf);

            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, m, conn);
            //JasperViewer.viewReport(jp,false);
            JasperPrintManager.printReport(jp, false);
        } catch (Exception e) {

        }
    }

    private void BillPrintReturn(String BillID) {
        HashMap m = new HashMap();
        m.put("BillID", BillID);
        m.put("Total", ReturnTotal.replace("Rs. ", ""));
        m.put("NetTotal", ReturnNetTotal.replace("Rs. ", ""));
        m.put("Balance", ReturnBalance.replace("Rs. ", ""));

        ReturnTotal = ReturnTotal.replace("Rs. ", "");
        ReturnTotal = ReturnTotal.replace(",", "");
        ReturnNetTotal = ReturnNetTotal.replace("Rs. ", "");
        ReturnNetTotal = ReturnNetTotal.replace(",", "");
        float ReturnTotalValue = Float.valueOf(ReturnTotal);
        float ReturnNetTotalValue = Float.valueOf(ReturnNetTotal);
        float Return = ReturnTotalValue - ReturnNetTotalValue;

        m.put("Return", ConvertToCurrency(Return));

        try {
            String path = "C:\\Program Files\\Aanya Fashion Store\\lib\\BillReciptReturn.jrxml";
            InputStream rf = new FileInputStream(new File(path));
            JasperDesign jd = JRXmlLoader.load(rf);

            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, m, conn);
            //JasperViewer.viewReport(jp,false);
            JasperPrintManager.printReport(jp, false);
        } catch (Exception e) {

        }
    }

    /*   public void A4_print()      **Don't REMOVE**
     {
     String s1 = String.format("\n------------------------------------------------------","%-15s %5s %10s\n");
     String DnT=LocalDate.now().getYear()+"-"+LocalDate.now().getMonthValue()+"-"+LocalDate.now().getDayOfMonth()+"  "+LocalTime.now().getHour()+":"+LocalTime.now().getMinute()+":"+LocalTime.now().getSecond();
     String s = String.format("ITEM                 PRICE         QTY      AMOUNT", "%-15s %5s %10s\n");
     String output = s+s1;
     dt_bID.setText("Contact: 071 0466002/ 047 2253707                                    නෝනගම පාර, ඇඹිලිපිටිය"+"\nE-mail: amtdilshan1996@gmail.com\nBill ID: "+BillID+"                                                        "+DnT);
     int lenth=0;
     for(int i=0;i<TabelBilling.getRowCount();i++)
     {
     String a="";
     String p="";
     String q="";
     String n="";
     n=TabelBilling.getValueAt(i, 1).toString();
     int cnt=i+1;
     p=TabelBilling.getValueAt(i, 2).toString();
     q=TabelBilling.getValueAt(i, 3).toString();
     a=TabelBilling.getValueAt(i, 4).toString();
     lenth=15-n.length();
     for(int j=0;j<lenth+3;j++)
     {
     p=" "+p;
     }
     lenth=28-n.length()-p.length();
     for(int j=0;j<lenth+4;j++)
     {
     q=" "+q;
     }
     lenth=37-n.length()-p.length()-q.length();
     for(int c=0;c<lenth+4;c++)
     {
     a=" "+a;
     }
     if(i<10)
     {
     output=output+"\n0"+cnt+". "+n+p+q+a; 
     }
     else
     {
     output=output+"\n"+cnt+". "+n+p+q+a;
     }
            
     }
     output+=s1;
     output+="\nTOTAL:\n"+StotalTxt.getText()+"\nCASH RECEIVED:  "+cashLabel.getText()+"\nBALANCE:        "+BlnLabl.getText();
     bill_txt.setText(output);

        
     PrinterJob pj = PrinterJob.getPrinterJob();

     pj.setJobName(" Print Component ");

     pj.setPrintable (new Printable() {    
     public int print(Graphics pg, PageFormat pf, int pageNum){
     if (pageNum > 0){
     return Printable.NO_SUCH_PAGE;
     }

     Graphics2D g2 = (Graphics2D) pg;
     g2.translate(pf.getImageableX(), pf.getImageableY());
     A4_Print.paint(g2);
     return Printable.PAGE_EXISTS;
     }
     });
  
     try {
     pj.print();
     } catch (PrinterException ex) {
     // handle exception
     }
     }*/
    public void ReturnHistry() {
        String BillID = "";
        try {
            int row = PurchaseBillTable.getSelectedRow();
            BillID = PurchaseBillTable.getValueAt(row, 0).toString();
        } catch (Exception e) {

        }

        try {
            String sqlload = "SELECT `Item Name`,`Return Quantity`, FORMAT(`Balance (Rs.)`,2) AS `Balance (Rs.)`, DATE_FORMAT(`Date & Time`,'%Y-%m-%d %h:%i %p') AS 'Date & Time', `User Name` AS 'Return By' FROM `return_bill` WHERE `Bill ID` = '" + BillID + "' ORDER BY `return_bill`.`Date & Time` DESC";
            Pstatement = conn.prepareStatement(sqlload);
            resualt = Pstatement.executeQuery();
            PurchaseItemTable.setModel(DbUtils.resultSetToTableModel(resualt));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
    }

    //Side shellbtn hide
    public void Panelhide() {
        PanelBilling.setVisible(false);
        PanelItem.setVisible(false);
        PanelSideButton.setVisible(false);
        PanelOrder.setVisible(false);
        PanelCustomer.setVisible(false);
        PanelSupplier.setVisible(false);
        PanelReport.setVisible(false);
        PanelCashier.setVisible(false);
        PanelSettings.setVisible(false);
        DailyReportPanel.setVisible(false);
        PanelReturn.setVisible(false);
    }

    public void ItemButtonClick() {
        SideButtonClick(PanelItem, SideButtonItem);
        ItemEditBtn.setEnabled(false);
        ItemDeleteBtn.setEnabled(false);
        ItemGetSupplierBtn.setEnabled(false);
        ItemSearchTextField.requestFocus();

        if ("(admin)".equals(admin_text.getText())) {
            //Data load to ItemTable from DB function call
            ItemTableLoad();
            //Load Supplier Names to item_SupID combo box(Function call)
            sup_comboLoad();
            item_SupID.getEditor().setItem("");
        } else {
            PanelItemInputComponents.setVisible(false);
            ItemEditBtn.setVisible(false);
            ItemDeleteBtn.setVisible(false);
            ItemGetSupplierBtn.setVisible(false);
            Item_delete_Button.setVisible(false);
            jScrollPane9.setLocation(205, 190);
            jLabel59.setLocation(446, 145);
            ItemSearchTextField.setLocation(500, 145);
            jScrollPane9.setSize(950, 450);
            sqlresualt = "SELECT `Item ID`, `Item Name`, FORMAT(`item`.`Selling Price (Rs.)`,2) AS 'Price (Rs.)', `Quantity`, `Alert Quantity` FROM item ORDER BY `item`.`Item ID` ASC";
            try {
                Pstatement = conn.prepareStatement(sqlresualt);
                resualt = Pstatement.executeQuery();
                ItemTable.setModel(DbUtils.resultSetToTableModel(resualt));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
            }

        }

    }

    public void BillingButtonClick() {
        SideButtonClick(PanelBilling, SideButtonBilling);
        itemIDLoad();
        String CusID = "";
        int a = ComboBoxCustermer.getItemCount();
        a -= 1;
        while (a > 0) {
            ComboBoxCustermer.removeItemAt(a);
            a -= 1;
        }

        try {
            String sqlload = "SELECT `Customer ID` FROM `customer`";
            Pstatement = conn.prepareStatement(sqlload);
            resualt = Pstatement.executeQuery();

            while (resualt.next()) {
                CusID = resualt.getString("Customer ID");
                ComboBoxCustermer.addItem(CusID);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
        ComboBoxBillingItemID.requestFocus();
    }

    public void OrdersButtonClick() {
        SideButtonClick(PanelOrder, SideButtonOrder);
        //Data load to OrderTable from DB function call
        OrderTableLoad();
        //Load Item Names to Order_ItemID combo box(Function call)
        item_SupIDLoad();
        p = 0;
    }

    public void CustomerButtonClick() {
        SideButtonClick(PanelCustomer, SideButtonCustomer);
        //Data load to CustomerTable from DB function call
        CustomerTableLoad();
    }

    public void SupplierButtonClick() {
        SideButtonClick(PanelSupplier, SideButtonSupplier);
        //Data load to SupplierTable from DB function call
        SupplierTableLoad();

    }

    public void ReportButtonClick() {

        SideButtonClick(PanelReport, SideButtonReport);
        DailyReportPanel.setVisible(true);

        BlReportPanel.setVisible(false);
        MonthlyReportPanel.setVisible(false);
        PanelReturn.setVisible(false);
        RadioButtonMonthly.setSelected(false);
        DailyRadioButton.setSelected(true);
        DailyRadioButton.setVisible(true);
        RadioButtonMonthly.setVisible(true);
        DailyRadioButton.setSelected(true);

        ShellRptBtn.setBackground(new Color(0, 153, 51));
        BillRptBtn.setBackground(new Color(51, 204, 0));

        String day = String.valueOf(LocalDate.now().getDayOfMonth());
        String month = String.valueOf(LocalDate.now().getMonthValue());
        if (LocalDate.now().getDayOfMonth() < 10) {
            day = "0" + String.valueOf(LocalDate.now().getDayOfMonth());
        }
        if (LocalDate.now().getMonthValue() < 10) {
            month = "0" + String.valueOf(LocalDate.now().getMonthValue());
        }
        String DnT = LocalDate.now().getYear() + "-" + month + "-" + day;
        try {
            float TotalEarn = 0;
            float NetTotalCash = 0;
            float NetTotalCard = 0;
            netp_label.setForeground(new Color(0, 0, 153));
            ProfitLabel.setForeground(new Color(0, 0, 153));

            sqlresualt = "SELECT Sum(`Net Total (Rs.)`) FROM `bill` WHERE `Date & Time` LIKE '" + DnT + "%'";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();

            while (resualt.next()) {
                TotalEarn = resualt.getFloat("Sum(`Net Total (Rs.)`)");
            }

            sqlresualt = "SELECT Sum(`Net Total (Rs.)`) FROM `bill` WHERE `Payment Method` LIKE 'Cash' AND `Date & Time` LIKE '" + DnT + "%'";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();

            while (resualt.next()) {
                NetTotalCash = resualt.getFloat("Sum(`Net Total (Rs.)`)");
            }

            sqlresualt = "SELECT Sum(`Net Total (Rs.)`) FROM `bill` WHERE `Payment Method` LIKE 'Card/ C.O. Delivery' AND `Date & Time` LIKE '" + DnT + "%'";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();

            while (resualt.next()) {
                NetTotalCard = resualt.getFloat("Sum(`Net Total (Rs.)`)");
            }

            sqlresualt = "SELECT Sum(`billitem`.`Quantity`) FROM `billitem`, `bill` WHERE `billitem`.`Bill ID` = `bill`.`Bill ID` AND `bill`.`Date & Time` Like '" + DnT + "%'";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();

            int Qty = 0;
            while (resualt.next()) {
                Qty = resualt.getInt("Sum(`billitem`.`Quantity`)");
            }

            sqlresualt = "SELECT Count(DISTINCT `billitem`.`Item ID`) FROM `billitem`, `bill` WHERE `billitem`.`Bill ID` = `bill`.`Bill ID` AND `bill`.`Date & Time` Like '" + DnT + "%' AND `billitem`.`Quantity` > 0";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();

            int Items = 0;
            while (resualt.next()) {
                Items = resualt.getInt("Count(DISTINCT `billitem`.`Item ID`)");
            }

            ReportTotaEarnlLabel.setText("Rs. " + ConvertToCurrency(TotalEarn));
            ReportNetTotalCashlLabel.setText("Rs. " + ConvertToCurrency(NetTotalCash));
            ReportNetTotalCardLabel.setText("Rs. " + ConvertToCurrency(NetTotalCard));
            LabelSellQTY.setText("Today Sell Quantity         :   " + Qty);
            LabelSellItems.setText(" :   " + Items);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void CashierButtonClick() {

        SideButtonClick(PanelCashier, SideButtonCashier);

        //Data load to CashierTable from DB function call
        CashierTableLoad();

    }

    public void ReturnButtonClick() {
        SideButtonClick(PanelReturn, SideButtonReturn);
        if (RadioButtonReSelling.isSelected()) {
            ReuenCus();
        } else {
            ReuenSup();
        }
    }

    private void SideButtonClick(javax.swing.JPanel ShowPanel, javax.swing.JButton ActiveBtn) {

        PanelLogout.setVisible(false);
        PanelUserName.setVisible(false);
        PanelHome.setVisible(false);
        PanelBilling.setVisible(false);
        PanelItem.setVisible(false);
        PanelCustomer.setVisible(false);
        PanelReport.setVisible(false);
        PanelOrder.setVisible(false);
        PanelCashier.setVisible(false);
        PanelSettings.setVisible(false);
        PanelReturn.setVisible(false);
        PanelSupplier.setVisible(false);
        PanelSideButton.setVisible(true);
        ShowPanel.setVisible(true);

        SideButtonBilling.setBackground(new Color(51, 51, 255));
        SideButtonOrder.setBackground(new Color(51, 51, 255));
        SideButtonItem.setBackground(new Color(51, 51, 255));
        SideButtonCustomer.setBackground(new Color(51, 51, 255));
        SideButtonSupplier.setBackground(new Color(51, 51, 255));
        SideButtonReturn.setBackground(new Color(51, 51, 255));
        SideButtonReport.setBackground(new Color(51, 51, 255));
        SideButtonSupplier.setBackground(new Color(51, 51, 255));
        SideButtonCashier.setBackground(new Color(51, 51, 255));
        ActiveBtn.setBackground(new Color(29, 127, 237)); // Button select color
    }

    public void ItemTableLoad() //Data load to ItemTable from DB
    {
        sqlresualt = "SELECT `Item ID`, `Item Name`, FORMAT(`item`.`Buying Price (Rs.)`,2) AS 'Buying Price (Rs.)', FORMAT(`item`.`Selling Price (Rs.)`,2) AS 'Selling Price (Rs.)', `Quantity`, `Alert Quantity` FROM item ORDER BY `item`.`Item ID` ASC";
        try {
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            ItemTable.setModel(DbUtils.resultSetToTableModel(resualt));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

        item_ID.setText("");
        item_Name.setText("");
        item_SPrice.setText("");
        item_Quantity.setText("");
        item_BPrice.setText("");
        item_SupID.getEditor().setItem("");
        item_AtQuantity.setText("");
        item_SupID.setSelectedIndex(0);
        addItembtn.setText("Add");

        ItemSearchTextField.setText("");
    }

    public void CustomerTableLoad() //Data load to CustomerTable from DB
    {
        sqlresualt = "SELECT `Customer ID`, `Name`, `Address`, `Contact` FROM `customer` ORDER BY `customer`.`Customer ID` ASC";
        try {
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            CustomerTable.setModel(DbUtils.resultSetToTableModel(resualt));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

        CustomerEditBtn.setEnabled(false);
        CustomerDeleteBtn.setEnabled(false);

        String CusAddTxt = CusAddBtn.getText();
        if ("Update".equals(CusAddTxt)) {
            Customer_ID.setText("");
            Customer_Name.setText("");
            Customer_Adds.setText("");
            Customer_Contact.setText("");
            CusAddBtn.setText("Add");
        }
        CustomerSearchTextField.setText("");
    }

    public void OrderTableLoad() //Data load to OrderTable from DB
    {
        sqlresualt = "SELECT `Order ID`, `Item Name`, `Quantity`,  DATE_FORMAT(`Date & Time`,'%Y-%m-%d     %h:%i %p') AS 'Date & Time', FORMAT(`Paied Amount`,2) AS 'Paied Amount' FROM `order` ORDER BY `order`.`Order ID` ASC";
        try {
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            OrderTable.setModel(DbUtils.resultSetToTableModel(resualt));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

        OrderEditBtn.setEnabled(false);
        OrderDeleteBtn.setEnabled(false);
        OrderGetSupplierBtn.setEnabled(false);
        OrderGetItemBtn.setEnabled(false);

        String OdrAddTxt = OdrAddbtn.getText();
        if ("Update".equals(OdrAddTxt)) {
            Order_Quantty.setText("");
            Order_PaiedAmount.setText("");
            Order_ItemID.setSelectedIndex(0);
            OdrAddbtn.setText("Add");
            OdrSearchTextField.requestFocus();
        }
        OdrSearchTextField.setText("");
    }

    public void SupplierTableLoad() //Data load to SupplierTable from DB
    {
        sqlresualt = "SELECT `Supplier ID`, `Name`, `Address`, `Contact`, `Discription` FROM `supplier` ORDER BY `supplier`.`Supplier ID` ASC";
        try {
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            SupplierTable.setModel(DbUtils.resultSetToTableModel(resualt));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

        SupplierEditBtn.setEnabled(false);
        SupplierDeleteBtn.setEnabled(false);
        SupGetItemsBtn.setEnabled(false);

        String SupAddTxt = SupAddBtn.getText();
        if ("Update".equals(SupAddTxt)) {
            Supplier_ID.setText("");
            Supplier_Name.setText("");
            Supplier_Adds.setText("");
            Supplier_Contact.setText("");
            Supplier_Discription.setText("");
            SupAddBtn.setText("Add");
            SupSearchTextField.requestFocus();
        }
        SupSearchTextField.setText("");
    }

    public void CashierTableLoad() //Data load to CashierTable from DB
    {
        sqlresualt = "SELECT `Cashier ID`, `Name`, `Address`, `Contact` FROM `cashier` ORDER BY `cashier`.`Cashier ID` ASC";
        try {
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            CashierTable.setModel(DbUtils.resultSetToTableModel(resualt));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

        CashierEditBtn.setEnabled(false);
        CashierDeleteBtn.setEnabled(false);

        String OdrAddTxt = CashierAddButton.getText();
        if ("Update".equals(OdrAddTxt)) {
            Cashier_ID.setText("");
            Cashier_Name.setText("");
            Cashier_Adds.setText("");
            Cashier_Contact.setText("");
            CashierAddButton.setText("Add");
            CasSearchTextField.requestFocus();
        }
        CasSearchTextField.setText("");
    }

    public void RtLoad(int c) //Bill Load
    {
        try {
            if (c == 1) {
                sqlresualt = "SELECT `Bill ID`, DATE_FORMAT(`Date & Time`,'%Y-%m-%d      %h:%i %p') AS 'Date & Time', FORMAT(`bill`.`Total (Rs.)`,2) AS 'Total (Rs.)', FORMAT(`bill`.`Discount (Rs.)`,2) AS 'Discount (Rs.)', FORMAT(`bill`.`Net Total (Rs.)`,2) AS 'Net Total (Rs.)', FORMAT(`Balance (Rs.)`,2) AS 'Balance (Rs.)', `Payment Method` FROM `bill` WHERE `Total (Rs.)` != 0 ORDER BY `bill`.`Date & Time` DESC";
                Pstatement = conn.prepareStatement(sqlresualt);
                resualt = Pstatement.executeQuery();
                ReturnBillTable.setModel(DbUtils.resultSetToTableModel(resualt));
                TextFieldReturnBillSearch.requestFocus();

                //Report_Search_TextField_2.setEditable(false);
            } else {
                sqlresualt = "SELECT `Bill ID`, DATE_FORMAT(`Date & Time`,'%Y-%m-%d       %h:%i %p') AS 'Date & Time', FORMAT(`bill`.`Total (Rs.)`,2) AS 'Total (Rs.)', FORMAT(`bill`.`Discount (Rs.)`,2) AS 'Discount (Rs.)', FORMAT(`bill`.`Net Total (Rs.)`,2) AS 'Net Total (Rs.)', FORMAT(`Balance (Rs.)`,2) AS 'Balance (Rs.)', `Payment Method` FROM `bill` ORDER BY `bill`.`Date & Time` DESC";
                Pstatement = conn.prepareStatement(sqlresualt);
                resualt = Pstatement.executeQuery();
                PurchaseBillTable.setModel(DbUtils.resultSetToTableModel(resualt));
                fullbillrtlabel.setVisible(false);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void RtItemLoad() //Bill Item Load
    {
        int row = ReturnBillTable.getSelectedRow();
        String billID = ReturnBillTable.getValueAt(row, 0).toString();
        sqlresualt = "SELECT `Item ID`, `Quantity`, FORMAT(`Total (Rs.)`,2) AS 'Total (Rs.)', FORMAT(`Discount (Rs.)`,2) AS 'Discount (Rs.)', FORMAT(`Net Total (Rs.)`,2) AS 'Net Total (Rs.)' FROM `billitem` WHERE `Bill ID` = '" + billID + "' ORDER BY `billitem`.`Item ID` ASC";
        try {
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            ReturnItemTable.setModel(DbUtils.resultSetToTableModel(resualt));
            TextFieldReturnItemSearch.setEditable(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void BLItemTableLoad(String b) //Data load to shell
    {
        sqlresualt = "SELECT `item`.`Item ID`,`item`.`Item Name`, FORMAT(`billitem`.`Selling Price (Rs.)`,2) AS 'Price (Rs.)', `billitem`.`Quantity`, FORMAT(`billitem`.`Total (Rs.)`,2) AS 'Total (Rs.)', FORMAT(`billitem`.`Discount (Rs.)`,2) AS 'Discount (Rs.)', FORMAT(`billitem`.`Net Total (Rs.)`,2) AS 'Net Total (Rs.)' FROM `billitem`, `item` WHERE `billitem`.`Bill ID`='" + b + "' AND `item`.`Item ID`=`billitem`.`Item ID` ORDER BY `billitem`.`Item ID` ASC";
        try {
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            TabelBilling.setModel(DbUtils.resultSetToTableModel(resualt));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void AddItemBtnClick() {
        String itemID = item_ID.getText();
        String itemName = item_Name.getText();
        String itemBuyPrice = item_BPrice.getText();
        String itemSellPrice = item_SPrice.getText();
        String itemQuantity = item_Quantity.getText();
        String itemSupID = item_SupID.getSelectedItem().toString();
        String itemAtQuantity = "";

        if ("".equals(item_AtQuantity.getText())) {
            itemAtQuantity = "0";
        } else {
            itemAtQuantity = item_AtQuantity.getText();
        }

        //Check null values
        if (("".equals(itemID) || "".equals(itemName) || "".equals(itemQuantity)) || "".equals(itemBuyPrice) || "".equals(itemSellPrice)) {
            String t[] = {itemID, itemName, itemBuyPrice, itemSellPrice, itemQuantity};
            String m[] = {"Item ID", "Item Name", "Buying Price", "Selling Price", "Quantity"};
            String msg = "Enter ";
            for (int i = 0; i < 5; i++) {
                if ("".equals(t[i])) {
                    if ("Enter ".equals(msg)) {
                        msg += m[i];
                    } else {
                        msg += ", " + m[i];
                    }

                }
            }
            JOptionPane.showMessageDialog(null, msg, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        } else {
            if ("Select".equals(itemSupID)) {
                itemSupID = "";
            }
            // For check add or update
            if ("Add".equals(addItembtn.getText())) // if Add
            {
                //Genarate sql quary
                sqlInst = "INSERT INTO `item` (`Item ID`, `Item Name`, `Buying Price (Rs.)`, `Selling Price (Rs.)`, `Quantity`, `Supplier ID`, `Alert Quantity`) VALUES('" + itemID + "', '" + itemName + "','" + itemBuyPrice + "','" + itemSellPrice + "','" + itemQuantity + "','" + itemSupID + "','" + itemAtQuantity + "')";

                try {
                    //Insert new data to DB  
                    Pstatement = conn.prepareStatement(sqlInst);
                    Pstatement.execute();

                    //Data load to ItemTable from DB function call
                    ItemTableLoad();
                    ItemEditBtn.setEnabled(false);
                    ItemDeleteBtn.setEnabled(false);
                    ItemGetSupplierBtn.setEnabled(false);

                    JOptionPane.showMessageDialog(null, "New data insert success", "Shop Management System", JOptionPane.INFORMATION_MESSAGE);
                    item_ID.requestFocus();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
                }
            } else //if update
            {
                int row = ItemTable.getSelectedRow();
                String IID = ItemTable.getValueAt(row, 0).toString();
                //Genarate sql quary
                if (itemQuantity.substring(0, 1).equals("+")) {
                    int q = Integer.valueOf(itemQuantity.replace("+", ""));
                    sqlInst = "UPDATE `item` SET `Item ID` = '" + itemID + "', `Item Name` = '" + itemName + "', `Buying Price (Rs.)` = '" + itemBuyPrice + "', `Selling Price (Rs.)` = '" + itemSellPrice + "', `Quantity` = `item`.`Quantity`+" + q + ", `Supplier ID` = '" + itemSupID + "', `Alert Quantity` = '" + itemAtQuantity + "' WHERE `item`.`Item ID` = '" + IID + "' ";
                } else if (itemQuantity.substring(0, 1).equals("-")) {
                    int q = Integer.valueOf(itemQuantity.replace("-", ""));
                    sqlInst = "UPDATE `item` SET `Item ID` = '" + itemID + "', `Item Name` = '" + itemName + "', `Buying Price (Rs.)` = '" + itemBuyPrice + "', `Selling Price (Rs.)` = '" + itemSellPrice + "', `Quantity` = `item`.`Quantity`-" + q + ", `Supplier ID` = '" + itemSupID + "', `Alert Quantity` = '" + itemAtQuantity + "' WHERE `item`.`Item ID` = '" + IID + "' ";
                } else {
                    sqlInst = "UPDATE `item` SET `Item ID` = '" + itemID + "', `Item Name` = '" + itemName + "', `Buying Price (Rs.)` = '" + itemBuyPrice + "', `Selling Price (Rs.)` = '" + itemSellPrice + "', `Quantity` = '" + itemQuantity + "', `Supplier ID` = '" + itemSupID + "', `Alert Quantity` = '" + itemAtQuantity + "' WHERE `item`.`Item ID` = '" + IID + "'";
                }
                try {
                    //Update data to DB  
                    Pstatement = conn.prepareStatement(sqlInst);
                    Pstatement.execute();

                    //Data load to ItemTable from DB function call
                    ItemTableLoad();
                    for (int i = 0; i < ItemTable.getRowCount(); i++) {
                        if (ItemTable.getValueAt(i, 0).toString().equals(itemID)) {
                            ItemTable.setRowSelectionInterval(i, i);
                            break;
                        }
                    }

                    String SId = "";
                    sqlresualt = "SELECT `Supplier ID` FROM item WHERE `Item ID`='" + itemID + "'";
                    try {
                        Pstatement = conn.prepareStatement(sqlresualt);
                        resualt = Pstatement.executeQuery();
                        while (resualt.next()) {
                            SId = resualt.getString("Supplier ID");
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
                    }

                    if (!"".equals(SId)) {
                        ItemGetSupplierBtn.setEnabled(true);
                    } else {
                        ItemGetSupplierBtn.setEnabled(false);
                    }

                    JOptionPane.showMessageDialog(null, "Database update succes", "Shop Management System", JOptionPane.INFORMATION_MESSAGE);
                } catch (HeadlessException | SQLException e) {
                    JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
                }
                //alert_qty(itemID);
                ItemSearchTextField.requestFocus();
            }
        }

    }

    public void AddOrderBtnClick() {
        String OrderItemName = Order_ItemID.getSelectedItem().toString();
        String OrderQuantty = Order_Quantty.getText();
        String OrderPaiedAmount = Order_PaiedAmount.getText();

        if ("".equals(OrderPaiedAmount)) {
            OrderPaiedAmount = "0.00";
        }
        //Check null values
        if ("Select".equals(OrderItemName) || "".equals(OrderQuantty)) {
            String t[] = {OrderItemName, OrderQuantty};
            String m[] = {"Item Name", "Order Quantity"};
            String msg = "Enter ";
            for (int i = 0; i < 2; i++) {
                if ("".equals(t[i]) || "Select".equals(t[i])) {
                    if ("Enter ".equals(msg)) {
                        msg += m[i];
                    } else {
                        msg += ", " + m[i];
                    }
                }
            }
            JOptionPane.showMessageDialog(null, msg, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        } else {
            // For check add or update
            if ("Add".equals(OdrAddbtn.getText())) // if Add
            {
                //Genarate sql quary
                sqlInst = "INSERT INTO `order` (`Item Name`, `Quantity`, `Paied Amount`) VALUES('" + OrderItemName + "', '" + OrderQuantty + "', '" + OrderPaiedAmount + "')";

                try {
                    //Insert new data to DB  
                    Pstatement = conn.prepareStatement(sqlInst);
                    Pstatement.execute();

                    //Data load to OrderTable from DB function call
                    OrderTableLoad();
                    Order_ItemID.setSelectedIndex(0);
                    Order_Quantty.setText("");
                    Order_PaiedAmount.setText("");
                    JOptionPane.showMessageDialog(null, "New data insert success", "Shop Management System", JOptionPane.INFORMATION_MESSAGE);
                } catch (HeadlessException | SQLException e) {
                    JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
                }
            } else //if update
            {
                int row = OrderTable.getSelectedRow();
                String OID = OrderTable.getValueAt(row, 0).toString();
                //Genarate sql quary
                sqlInst = "UPDATE `order` SET `Item Name` = '" + OrderItemName + "', `Quantity` = '" + OrderQuantty + "', `Paied Amount` = '" + OrderPaiedAmount + "' WHERE `Order ID` = '" + OID + "'";

                try {
                    //Update data to DB  
                    Pstatement = conn.prepareStatement(sqlInst);
                    Pstatement.execute();

                    //Data load to OrderTable from DB function call
                    OrderTableLoad();

                    JOptionPane.showMessageDialog(null, "Database update succes", "Shop Management System", JOptionPane.INFORMATION_MESSAGE);
                } catch (HeadlessException | SQLException e) {
                    JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
                }

            }
            OdrSearchTextField.requestFocus();
        }

    }

    public void AddCustomerBtnClick() {
        String CustomerID = Customer_ID.getText();
        String CustomerName = Customer_Name.getText();
        String CustomerAdds = Customer_Adds.getText();
        String CustomerContact = Customer_Contact.getText();

        //Check null values
        if ("".equals(CustomerID) || "".equals(CustomerName)) {
            String t[] = {CustomerID, CustomerName};
            String m[] = {"Customer ID", "Customer Name"};
            String msg = "Enter ";
            for (int i = 0; i < 2; i++) {
                if ("".equals(t[i])) {
                    if ("Enter ".equals(msg)) {
                        msg += m[i];
                    } else {
                        msg += ", " + m[i];
                    }

                }
            }
            JOptionPane.showMessageDialog(null, msg, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        } else {
            // For check add or update
            if ("Add".equals(CusAddBtn.getText())) // if Add
            {
                //Genarate sql quary
                sqlInst = "INSERT INTO `customer` (`Customer ID`, `Name`, `Address`, `Contact`) VALUES('" + CustomerID + "', '" + CustomerName + "', '" + CustomerAdds + "','" + CustomerContact + "')";
                try {
                    //Insert new data to DB  
                    Pstatement = conn.prepareStatement(sqlInst);
                    Pstatement.execute();

                    //Data load to CustomerTable from DB function call
                    CustomerTableLoad();
                    Customer_ID.setText("");
                    Customer_Name.setText("");
                    Customer_Adds.setText("");
                    Customer_Contact.setText("");
                    JOptionPane.showMessageDialog(null, "New data insert success", "Shop Management System", JOptionPane.INFORMATION_MESSAGE);
                    Customer_ID.requestFocus();
                } catch (HeadlessException | SQLException e) {
                    JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
                }
            } else //if update
            {
                int row = CustomerTable.getSelectedRow();
                String CID = CustomerTable.getValueAt(row, 0).toString();
                //Genarate sql quary
                sqlInst = "UPDATE `customer` SET `Customer ID` = '" + CustomerID + "', `Name` = '" + CustomerName + "', `Address` = '" + CustomerAdds + "', `Contact` = '" + CustomerContact + "' WHERE `Customer ID` = '" + CID + "'";

                try {
                    //Update data to DB  
                    Pstatement = conn.prepareStatement(sqlInst);
                    Pstatement.execute();

                    //Data load to CustomerTable from DB function call
                    CustomerTableLoad();
                    JOptionPane.showMessageDialog(null, "Database update succes", "Shop Management System", JOptionPane.INFORMATION_MESSAGE);
                    CustomerSearchTextField.requestFocus();
                } catch (HeadlessException | SQLException e) {
                    JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
                }
            }

        }

    }

    public void AddSupplierBtnClick() {
        String SupplierID = Supplier_ID.getText();
        String SupplierName = Supplier_Name.getText();
        String SupplierAdds = Supplier_Adds.getText();
        String SupplierContact = Supplier_Contact.getText();
        String SupplierDiscription = Supplier_Discription.getText();

        //Check null values
        if ("".equals(SupplierID) || "".equals(SupplierName)) {
            String t[] = {SupplierID, SupplierName};
            String m[] = {"Supplier ID", "Supplier Name"};
            String msg = "Enter ";
            for (int i = 0; i < 2; i++) {
                if ("".equals(t[i])) {
                    if ("Enter ".equals(msg)) {
                        msg += m[i];
                    } else {
                        msg += ", " + m[i];
                    }

                }
            }
            JOptionPane.showMessageDialog(null, msg, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        } else {
            // For check add or update
            if ("Add".equals(SupAddBtn.getText())) // if Add
            {
                //Genarate sql quary
                sqlInst = "INSERT INTO `supplier` (`Supplier ID`, `Name`, `Address`, `Contact`, `Discription`) VALUES('" + SupplierID + "', '" + SupplierName + "', '" + SupplierAdds + "','" + SupplierContact + "','" + SupplierDiscription + "')";

                try {
                    //Insert new data to DB  
                    Pstatement = conn.prepareStatement(sqlInst);
                    Pstatement.execute();

                    Supplier_ID.setText("");
                    Supplier_Name.setText("");
                    Supplier_Adds.setText("");
                    Supplier_Contact.setText("");
                    Supplier_Discription.setText("");
                    //Data load to SupplierTable from DB function call
                    SupplierTableLoad();
                    JOptionPane.showMessageDialog(null, "New data insert success", "Shop Management System", JOptionPane.INFORMATION_MESSAGE);
                    Supplier_ID.requestFocus();
                } catch (HeadlessException | SQLException e) {
                    JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
                }
            } else //if update
            {
                int row = SupplierTable.getSelectedRow();
                String SID = SupplierTable.getValueAt(row, 0).toString();
                //Genarate sql quary
                sqlInst = "UPDATE `supplier` SET `Supplier ID` = '" + SupplierID + "', `Name` = '" + SupplierName + "', `Address` = '" + SupplierAdds + "', `Contact` = '" + SupplierContact + "', `Discription` = '" + SupplierDiscription + "' WHERE `Supplier ID` = '" + SID + "'";

                try {
                    //Update data to DB  
                    Pstatement = conn.prepareStatement(sqlInst);
                    Pstatement.execute();

                    //Data load to SupplierTable from DB function call
                    SupplierTableLoad();
                    JOptionPane.showMessageDialog(null, "Database update succes", "Shop Management System", JOptionPane.INFORMATION_MESSAGE);
                    SupSearchTextField.requestFocus();
                } catch (HeadlessException | SQLException e) {
                    JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
                }
            }

        }

    }

    public void AddCashierBtnClick() {
        String CashierID = Cashier_ID.getText();
        String CashierName = Cashier_Name.getText();
        String CashierAdds = Cashier_Adds.getText();
        String CashierContact = Cashier_Contact.getText();

        //Check null values
        if ("".equals(CashierID) || "".equals(CashierName)) {
            String t[] = {CashierID, CashierName};
            String m[] = {"Cashier ID", "Cashier Name"};
            String msg = "Enter ";
            for (int i = 0; i < 2; i++) {
                if ("".equals(t[i])) {
                    if ("Enter ".equals(msg)) {
                        msg += m[i];
                    } else {
                        msg += ", " + m[i];
                    }

                }
            }
            JOptionPane.showMessageDialog(null, msg, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        } else {
            // For check add or update
            if ("Add".equals(CashierAddButton.getText())) // if Add
            {
                //Genarate sql quary
                sqlInst = "INSERT INTO `Cashier` (`Cashier ID`, `Name`, `Address`, `Contact`) VALUES('" + CashierID + "', '" + CashierName + "', '" + CashierAdds + "','" + CashierContact + "')";

                try {
                    //Insert new data to DB  
                    Pstatement = conn.prepareStatement(sqlInst);
                    Pstatement.execute();

                    //Data load to CashierTable from DB function call
                    CashierTableLoad();
                    Cashier_ID.setText("");
                    Cashier_Name.setText("");
                    Cashier_Adds.setText("");
                    Cashier_Contact.setText("");
                    JOptionPane.showMessageDialog(null, "New data insert success", "Shop Management System", JOptionPane.INFORMATION_MESSAGE);
                    Cashier_ID.requestFocus();

                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
                }
            } else //if update
            {
                int row = CashierTable.getSelectedRow();
                String CaID = CashierTable.getValueAt(row, 0).toString();
                //Genarate sql quary
                sqlInst = "UPDATE `Cashier` SET `Cashier ID` = '" + CashierID + "', `Name` = '" + CashierName + "', `Address` = '" + CashierAdds + "', `Contact` = '" + CashierContact + "' WHERE `Cashier ID` = '" + CaID + "'";

                try {
                    //Update data to DB  
                    Pstatement = conn.prepareStatement(sqlInst);
                    Pstatement.execute();

                    //Data load to CashierTable from DB function call
                    CashierTableLoad();
                    JOptionPane.showMessageDialog(null, "Database update succes", "Shop Management System", JOptionPane.INFORMATION_MESSAGE);
                    CasSearchTextField.requestFocus();
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
                }
            }

        }

    }

    public void sup_comboLoad() //Load Supplier Names to item_SupID combo box
    {
        String SupName = "";

        int a = item_SupID.getItemCount();
        a -= 1;
        while (a != 0) {
            item_SupID.removeItemAt(a);
            a -= 1;
        }

        try {
            String sqlload = "SELECT `Supplier ID` FROM supplier";
            Pstatement = conn.prepareStatement(sqlload);
            resualt = Pstatement.executeQuery();

            while (resualt.next()) {
                SupName = resualt.getString("Supplier ID");
                item_SupID.addItem(SupName);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void UserLoad() //Load User Name Names to ComboBox_UserNameselect
    {
        String user = "";

        int a = ComboBox_UserNameselect.getItemCount();
        a -= 1;
        while (a != 0) {
            ComboBox_UserNameselect.removeItemAt(a);
            a -= 1;
        }

        try {
            String sqlload = "SELECT * FROM `user_acct`";
            Pstatement = conn.prepareStatement(sqlload);
            resualt = Pstatement.executeQuery();

            while (resualt.next()) {
                user = resualt.getString("User Name");
                ComboBox_UserNameselect.addItem(user);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void item_SupIDLoad() //Load Item Names to Order_ItemID combo box
    {
        String SupName = "";

        int a = Order_ItemID.getItemCount();
        a -= 1;
        while (a != 0) {
            Order_ItemID.removeItemAt(a);
            a -= 1;
        }

        try {
            String sqlload = "SELECT `Item Name` FROM item";
            Pstatement = conn.prepareStatement(sqlload);
            resualt = Pstatement.executeQuery();

            while (resualt.next()) {
                SupName = resualt.getString("Item Name");
                Order_ItemID.addItem(SupName);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void deleteValues(String table, String columnName, String ID) {
        String sqlDT = "DELETE FROM `" + table + "` WHERE `" + columnName + "`='" + ID + "'";

        try {
            Pstatement = conn.prepareStatement(sqlDT);
            Pstatement.execute();
            JOptionPane.showMessageDialog(null, "Data Delete Successful", "Shop Management System", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void itemIDLoad() //Load Item Names to itemidShellCombo combo box
    {
        String ItemName = "";
        /*
         int a = ComboBoxBillingItemID.getItemCount();
         a -= 1;
         while (a != -1) {
         ComboBoxBillingItemID.removeItemAt(a);
         a -= 1;
         }
         */
        jList1.removeAll();
        try {
            DefaultListModel listModel = new DefaultListModel();
            String sqlload = "SELECT `Item Name` FROM item";
            Pstatement = conn.prepareStatement(sqlload);
            resualt = Pstatement.executeQuery();

            while (resualt.next()) {
                ItemName = resualt.getString("Item Name");
                listModel.addElement(ItemName);

            }
            jList1.setModel(listModel);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void ReuenCus() //Retuen customer redio btn
    {
        RadioButtonReSelling.setSelected(true);
        RadioButtonToSupplier.setSelected(false);

        ButtonReturnBill.setVisible(true);
        LabelReturnBillTxt.setText("Bill");
        LabeItemSelected.setText("Items Of Selected Bill");
        ButtonReturnBill.setEnabled(false);
        ButtonReturnReset.setEnabled(false);
        ButtonReturnQTY.setEnabled(false);
        TextFieldReturnQTY.setText("1");
        TextFieldReturnQTY.setEnabled(false);
        ButtonReturnQTY.setVisible(true);
        ButtonReturnReset.setVisible(true);
        ButtonAddReturnQTY.setVisible(true);
        ButtonReturnToSuppliers.setVisible(false);
        ReturnItemNames_Qty.clear();
        //ReturnItemNames_Price.clear();
        ReturnNetTotal = "";
        ReturnTotal = "";
        ReturnBalance = "";
        BillID = "";
        TextFieldReturnBillSearch.setText("");
        TextFieldReturnItemSearch.setText("");
        RtLoad(1);
        TextFieldReturnItemSearch.setEditable(false);
        try {
            sqlresualt = "SELECT `Item ID`, `Quantity`, FORMAT(`Total (Rs.)`,2) AS 'Total (Rs.)', FORMAT(`Discount (Rs.)`,2) AS 'Discount (Rs.)', FORMAT(`Net Total (Rs.)`,2) AS 'Net Total (Rs.)' FROM `billitem` WHERE `Bill ID` = ' '";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            ReturnItemTable.setModel(DbUtils.resultSetToTableModel(resualt));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
        TextFieldReturnQTY.setEnabled(false);
        ButtonAddReturnQTY.setEnabled(false);
    }

    public void ReuenSup() //Retuen Suplier redio btn
    {
        RadioButtonToSupplier.setSelected(true);
        TextFieldReturnItemSearch.setEditable(true);
        RadioButtonReSelling.setSelected(false);

        ButtonReturnBill.setVisible(false);
        LabeItemSelected.setText("Returned Items");
        LabelReturnBillTxt.setText("Items");
        ButtonAddReturnQTY.setEnabled(false);
        ButtonAddReturnQTY.setVisible(false);
        ButtonReturnToSuppliers.setVisible(true);
        ButtonReturnToSuppliers.setEnabled(false);
        TextFieldReturnQTY.setText("1");
        ButtonReturnQTY.setVisible(false);
        ButtonReturnReset.setVisible(false);
        TextFieldReturnBillSearch.setText("");
        TextFieldReturnItemSearch.setText("");
        try {
            sqlresualt = "SELECT `Item ID`, `Item Name`, `Quantity` FROM `item`";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            ReturnBillTable.setModel(DbUtils.resultSetToTableModel(resualt));

            sqlresualt = "SELECT `Item ID`, DATE_FORMAT(`Date & Time`,'%Y-%m-%d       %h:%i:%s %p') AS 'Date & Time', `Return Quantity` FROM `return _sup` ORDER BY `return _sup`.`Date & Time` DESC";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            ReturnItemTable.setModel(DbUtils.resultSetToTableModel(resualt));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void BlanceCal() {
        try {
            float a = 0;
            if (!"".equals(TextFieldCash.getText()) && !"Rs. 0.00".equals(LabelNetTotal.getText())) {
                a = Float.valueOf(TextFieldCash.getText());

                String prc = java.text.NumberFormat.getCurrencyInstance().format(a);
                prc = prc.replace("$", "");

                String prcTxt = LabelNetTotal.getText();
                prcTxt = prcTxt.substring(4);
                prcTxt = prcTxt.replace(",", "");
                float prce = Float.valueOf(prcTxt);
                float bl;
                bl = prce - a;
                prcTxt = java.text.NumberFormat.getCurrencyInstance().format(bl);
                prcTxt = prcTxt.replace("$", "");
                prcTxt = prcTxt.replace("(", "");
                prcTxt = prcTxt.replace(")", "");
                if (prce <= a) {
                    LabelBalanceDisplayBalance.setText("Rs. " + prcTxt);
                } else {
                    LabelBalanceDisplayBalance.setText("Rs. -" + prcTxt);
                }

                bl = 0;
            } else if ("".equals(TextFieldCash.getText())) {
                LabelBalanceDisplayBalance.setText("Rs. 0.00");
            } else if ("Rs. 0.00".equals(LabelNetTotal.getText())) {
                LabelBalanceDisplayBalance.setText("Rs. 0.00");
                TextFieldCash.setText("");
                TextFieldCash.setEnabled(false);
            }

        } catch (Exception e) {

        }
    }

    public void RprtItemLoad() //Bill Item Load
    {
        int row = 0;
        String billID = "";
        try {
            row = PurchaseBillTable.getSelectedRow();
            billID = PurchaseBillTable.getValueAt(row, 0).toString();
        } catch (Exception e) {

        }

        sqlresualt = "SELECT `billitem`.`Item ID`, FORMAT(`billitem`.`Selling Price (Rs.)`,2) AS 'Price (Rs.)', `billitem`.`Quantity`, FORMAT(`billitem`.`Total (Rs.)`,2) AS 'Total (Rs.)', FORMAT(`billitem`.`Discount (Rs.)`,2) AS 'Discount (Rs.)', FORMAT(`billitem`.`Net Total (Rs.)`,2) AS 'Net Total (Rs.)' FROM `billitem`, `item` WHERE `Bill ID` = '" + billID + "' AND `item`.`Item ID` = `billitem`.`Item ID` ORDER BY `billitem`.`Item ID` ASC";
        try {
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            PurchaseItemTable.setModel(DbUtils.resultSetToTableModel(resualt));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

    }

    private String ConvertToCurrency(float c) {
        String Currency = null;
        Currency = java.text.NumberFormat.getCurrencyInstance().format(c);
        Currency = Currency.replace("$", "");
        Currency = Currency.replace(")", "");
        Currency = Currency.replace("(", "");

        return Currency;
    }

    private float ConvertToCurrencyValue(float c) {
        String Currency = null;
        Currency = java.text.NumberFormat.getCurrencyInstance().format(c);
        Currency = Currency.replace(",", "");
        Currency = Currency.replace("$", "");
        Currency = Currency.replace(")", "");
        Currency = Currency.replace("(", "");
        float Value = Float.valueOf(Currency);

        return Value;
    }

    public int item_qty(String item_id) {
        int qty = 0;
        try {
            sqlresualt = "SELECT `Quantity` FROM item WHERE `Item ID`='" + item_id + "'";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            while (resualt.next()) {
                qty = resualt.getInt("Quantity");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
        return qty;
    }

    public String item_name(String item_id) {
        String iname = "";
        try {
            sqlresualt = "SELECT `Item Name` FROM item WHERE `Item ID`='" + item_id + "'";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            while (resualt.next()) {
                iname = resualt.getString("Item Name");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }
        return iname;
    }

    public void alert_qty(String iid) {
        int alt_q = 0;
        try {
            sqlresualt = "SELECT `Alert Quantity` FROM item WHERE `Item ID`='" + iid + "'";
            Pstatement = conn.prepareStatement(sqlresualt);
            resualt = Pstatement.executeQuery();
            while (resualt.next()) {
                alt_q = resualt.getInt("Alert Quantity");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Shop Management System", JOptionPane.WARNING_MESSAGE);
        }

        int q = item_qty(iid);
        String item_name = item_name(iid);
        String nfty = "";
        if ((0 < q) && (q < alt_q)) {
            nfty = item_name + " is less than " + alt_q;

            if (TextAreaNotifications.getText().equals("No new notifications")) {
                TextAreaNotifications.setText(nfty);
            } else {
                TextAreaNotifications.setText(TextAreaNotifications.getText() + "\n" + nfty);
            }
            //notificationbtn.setIcon(new ImageIcon(getClass().getResource("/images/notificationNew.png")));
        } else if (q == 0) {
            nfty = item_name + " is out of stock!";

            if (TextAreaNotifications.getText().equals("No new notifications")) {
                TextAreaNotifications.setText(nfty);
            } else {
                TextAreaNotifications.setText(TextAreaNotifications.getText() + "\n" + nfty);
            }
            //notificationbtn.setIcon(new ImageIcon(getClass().getResource("/images/notificationNew.png")));
        }

    }

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
                if ("Window".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AllRptRadioButton;
    private javax.swing.JRadioButton BLCRptRadioButton;
    private javax.swing.JRadioButton BLCRptRadioButton1;
    private rojeru_san.RSButton Backup_btn;
    private javax.swing.JButton BillRptBtn;
    private javax.swing.JTextField BillSearchTextField;
    private javax.swing.JPanel BlReportPanel;
    private javax.swing.JButton ButtonAddReturnQTY;
    private javax.swing.JButton ButtonAddToBill;
    private rojeru_san.RSButtonRiple ButtonCancelItem;
    private javax.swing.JButton ButtonGetBill;
    private javax.swing.JButton ButtonPay;
    private rojeru_san.RSButtonRiple ButtonRemoveBill;
    private javax.swing.JButton ButtonReturnBill;
    private javax.swing.JButton ButtonReturnQTY;
    private javax.swing.JButton ButtonReturnReset;
    private rojeru_san.RSButtonRiple ButtonReturnToSuppliers;
    private rojeru_san.RSButtonRiple ButtonSendDayReport;
    private javax.swing.JLabel BuyingPriceLabel;
    private javax.swing.JTextField CasSearchTextField;
    private javax.swing.JLabel CashierAddButton;
    private javax.swing.JPanel CashierAddPanel;
    private rojeru_san.RSButtonRiple CashierButton;
    private javax.swing.JButton CashierDeleteBtn;
    private javax.swing.JButton CashierEditBtn;
    private rojerusan.RSTableMetro CashierTable;
    private javax.swing.JTextField Cashier_Adds;
    private javax.swing.JTextField Cashier_Contact;
    private javax.swing.JTextField Cashier_ID;
    private javax.swing.JTextField Cashier_Name;
    private javax.swing.JTextField ComboBoxBillingItemID;
    private javax.swing.JComboBox ComboBoxCustermer;
    private javax.swing.JComboBox ComboBox_Cashieruserselect;
    private javax.swing.JComboBox ComboBox_UserNameselect;
    private javax.swing.JLabel CusAddBtn;
    private javax.swing.JPanel CusAddPanel;
    private javax.swing.JButton CustomerDeleteBtn;
    private javax.swing.JButton CustomerEditBtn;
    private javax.swing.JTextField CustomerSearchTextField;
    private rojerusan.RSTableMetro CustomerTable;
    private javax.swing.JTextField Customer_Adds;
    private javax.swing.JTextField Customer_Contact;
    private javax.swing.JTextField Customer_ID;
    private javax.swing.JTextField Customer_Name;
    private javax.swing.JRadioButton DailyRadioButton;
    private javax.swing.JPanel DailyReportPanel;
    private javax.swing.JPanel Database;
    private javax.swing.JTextField Ebill_TextField;
    private javax.swing.JButton ItemDeleteBtn;
    private javax.swing.JButton ItemEditBtn;
    private javax.swing.JButton ItemGetSupplierBtn;
    private javax.swing.JTextField ItemSearchTextField;
    private rojerusan.RSTableMetro ItemTable;
    private javax.swing.JButton Item_delete_Button;
    private javax.swing.JLabel LabeItemSelected;
    private javax.swing.JLabel LabelBalanceDisplayBalance;
    private javax.swing.JLabel LabelBalanceDisplayBalanceTxt;
    private javax.swing.JLabel LabelBillingBillID;
    private javax.swing.JLabel LabelCashTxt;
    private javax.swing.JLabel LabelDayReportIcon;
    private javax.swing.JLabel LabelDiscount;
    private javax.swing.JLabel LabelDiscountTxt;
    private javax.swing.JLabel LabelItem;
    private javax.swing.JLabel LabelItemTxt;
    private javax.swing.JLabel LabelNetTotal;
    private javax.swing.JLabel LabelNetTotalTxt;
    private javax.swing.JLabel LabelReturnBillTxt;
    private javax.swing.JLabel LabelSellItems;
    private javax.swing.JLabel LabelSellQTY;
    private javax.swing.JLabel LabelSellQTY1;
    private javax.swing.JLabel LabelTotal;
    private javax.swing.JLabel LabelTotalTxt;
    private javax.swing.JLabel LabelUserName;
    private javax.swing.JLabel Label_CashierUserAcct;
    private javax.swing.JLabel Logoutbtn;
    private javax.swing.JComboBox MonthComboBox;
    private javax.swing.JPanel MonthlyReportPanel;
    private javax.swing.JLabel Monthly_T_ernLabel;
    private javax.swing.JPanel MreportView;
    private javax.swing.JLabel Nclearbtn;
    private rojeru_san.RSButtonRiple OderButton;
    private javax.swing.JPanel OdrAddPanel;
    private javax.swing.JLabel OdrAddbtn;
    private javax.swing.JTextField OdrSearchTextField;
    private javax.swing.JButton OrderDeleteBtn;
    private javax.swing.JButton OrderEditBtn;
    private javax.swing.JButton OrderGetItemBtn;
    private javax.swing.JButton OrderGetSupplierBtn;
    private rojerusan.RSTableMetro OrderTable;
    private javax.swing.JComboBox Order_ItemID;
    private javax.swing.JTextField Order_PaiedAmount;
    private javax.swing.JTextField Order_Quantty;
    private javax.swing.JTextField Othercost_TextField;
    private javax.swing.JLabel PaiedLabel;
    private javax.swing.JPanel PanelBalance;
    private javax.swing.JPanel PanelBilling;
    private javax.swing.JPanel PanelCashier;
    private javax.swing.JPanel PanelCustomer;
    private javax.swing.JPanel PanelDiscount;
    private javax.swing.JPanel PanelHome;
    private javax.swing.JPanel PanelItem;
    private javax.swing.JPanel PanelItemInputComponents;
    private javax.swing.JPanel PanelLogout;
    private javax.swing.JPanel PanelNetTotal;
    private javax.swing.JPanel PanelNumOfItems;
    private javax.swing.JPanel PanelOrder;
    private javax.swing.JPanel PanelReport;
    private javax.swing.JPanel PanelReturn;
    private javax.swing.JPanel PanelSettings;
    private javax.swing.JPanel PanelSideButton;
    private javax.swing.JPanel PanelSupplier;
    private javax.swing.JPanel PanelTitle;
    private javax.swing.JPanel PanelTotal;
    private javax.swing.JPanel PanelUserName;
    private javax.swing.JPasswordField PasswordTextField;
    private javax.swing.JRadioButton PreviousMonth;
    private javax.swing.JLabel ProfitLabel;
    private rojerusan.RSTableMetro PurchaseBillTable;
    private rojerusan.RSTableMetro PurchaseItemTable;
    private javax.swing.JPasswordField RT_PasswordTextField;
    private javax.swing.JRadioButton RadioButtonCard;
    private javax.swing.JRadioButton RadioButtonCash;
    private javax.swing.JRadioButton RadioButtonMonthly;
    private javax.swing.JRadioButton RadioButtonReSelling;
    private javax.swing.JRadioButton RadioButtonToSupplier;
    private javax.swing.JRadioButton RadioButton_Admin;
    private javax.swing.JRadioButton RadioButton_Cashier;
    private rojeru_san.RSButtonRiple ReportButton;
    private javax.swing.JLabel ReportNetTotalCardLabel;
    private javax.swing.JLabel ReportNetTotalCashlLabel;
    private javax.swing.JLabel ReportTotaEarnlLabel;
    private rojeru_san.RSButton Restore_btn;
    private rojerusan.RSTableMetro ReturnBillTable;
    private rojeru_san.RSButtonRiple ReturnButton;
    private javax.swing.JRadioButton ReturnCRptRadioButton;
    private rojerusan.RSTableMetro ReturnItemTable;
    private javax.swing.JRadioButton SelectMonth;
    private javax.swing.JLabel SellingPriceLabel;
    private javax.swing.JLabel Settings_Btn;
    private javax.swing.JButton ShellRptBtn;
    private rojeru_san.RSButtonRiple SideButtonBilling;
    private rojeru_san.RSButtonRiple SideButtonCashier;
    private rojeru_san.RSButtonRiple SideButtonCustomer;
    private rojeru_san.RSButtonRiple SideButtonItem;
    private rojeru_san.RSButtonRiple SideButtonOrder;
    private rojeru_san.RSButtonRiple SideButtonReport;
    private rojeru_san.RSButtonRiple SideButtonReturn;
    private rojeru_san.RSButtonRiple SideButtonSupplier;
    private javax.swing.JLabel SupAddBtn;
    private javax.swing.JPanel SupAddPanel;
    private javax.swing.JButton SupGetItemsBtn;
    private javax.swing.JTextField SupSearchTextField;
    private rojeru_san.RSButtonRiple SupplierButton;
    private javax.swing.JButton SupplierDeleteBtn;
    private javax.swing.JButton SupplierEditBtn;
    private rojerusan.RSTableMetro SupplierTable;
    private javax.swing.JTextField Supplier_Adds;
    private javax.swing.JTextField Supplier_Contact;
    private javax.swing.JTextField Supplier_Discription;
    private javax.swing.JTextField Supplier_ID;
    private javax.swing.JTextField Supplier_Name;
    private rojerusan.RSTableMetro TabelBilling;
    private javax.swing.JTextArea TextAreaNotifications;
    private javax.swing.JTextField TextFieldBillingQuantity;
    private javax.swing.JTextField TextFieldCash;
    private javax.swing.JTextField TextFieldDiscountPerUnit;
    private javax.swing.JTextField TextFieldReturnBillSearch;
    private javax.swing.JTextField TextFieldReturnItemSearch;
    private javax.swing.JTextField TextFieldReturnQTY;
    private javax.swing.JRadioButton ThisMonth;
    private javax.swing.JLabel TitleMonth_Label;
    private javax.swing.JButton UserAcct_Button;
    private javax.swing.JTextField Wbill_TextField;
    private javax.swing.JComboBox YearComboBox;
    private javax.swing.JPanel about;
    private rojeru_san.RSButtonRiple about_btn;
    private javax.swing.JLabel addItembtn;
    private javax.swing.JPanel addItembtnPanel;
    private javax.swing.JLabel admin_only10;
    private javax.swing.JLabel admin_only11;
    private javax.swing.JLabel admin_only12;
    private javax.swing.JLabel admin_only13;
    private javax.swing.JLabel admin_only14;
    private javax.swing.JLabel admin_only2;
    private javax.swing.JLabel admin_only4;
    private javax.swing.JLabel admin_only5;
    private javax.swing.JLabel admin_only7;
    private javax.swing.JLabel admin_only8;
    private javax.swing.JLabel admin_only9;
    private javax.swing.JLabel admin_text;
    private javax.swing.JLabel close_btn;
    private rojeru_san.RSButtonRiple database_btn;
    private javax.swing.JLabel developer;
    private javax.swing.JLabel eLabel;
    private javax.swing.JLabel fullbillrtlabel;
    private javax.swing.JPanel homePanel;
    private javax.swing.JLabel homebtn;
    private javax.swing.JCheckBox hstCheckBox;
    private javax.swing.JTextField item_AtQuantity;
    private javax.swing.JTextField item_BPrice;
    private javax.swing.JTextField item_ID;
    private javax.swing.JTextField item_Name;
    private javax.swing.JTextField item_Quantity;
    private javax.swing.JTextField item_SPrice;
    private javax.swing.JComboBox item_SupID;
    private javax.swing.JLabel itm_slt_label;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private rojeru_san.RSButtonRiple jButton9;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField4;
    private javax.swing.JPasswordField jPasswordField5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JScrollPane jScrollPaneList;
    private javax.swing.JScrollPane jScrollPaneTabelBilling;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel minimize_btn;
    private javax.swing.JLabel netp_label;
    private javax.swing.JLabel notificationbtn;
    private javax.swing.JLabel oLabel;
    private rojeru_san.RSButtonRiple rSButtonRiple1;
    private rojeru_san.RSButtonRiple rSButtonRiple2;
    private rojeru_san.RSButtonRiple rSButtonRiple4;
    private rojeru_san.RSButton rpt_cashier;
    private rojeru_san.RSButton rpt_getcus;
    private rojeru_san.RSButton rpt_getitem;
    private javax.swing.JPanel sideBar;
    private javax.swing.JLabel total_item_costLabel;
    private rojeru_san.RSButtonRiple userAcct_btn;
    private javax.swing.JTextField userNameTextField;
    private javax.swing.JPanel user_act;
    private javax.swing.JLabel userbtn;
    private javax.swing.JLabel wLabel;
    // End of variables declaration//GEN-END:variables
}
