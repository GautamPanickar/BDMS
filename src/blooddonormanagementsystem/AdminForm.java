/*
 * The following class consists of the functionalities in AdminForm
 */
package blooddonormanagementsystem;

import BDMS.Database.DataBaseManager;
import java.awt.List;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author Panickar
 */
public class AdminForm extends javax.swing.JFrame {

    // Structures to hold Districts and cities
    Map<String, ArrayList<String>> districtCityMap;
    String[] districts;
    String[] bloodGroup;
    /**
     * Creates new form AdminForm
     */
    public AdminForm() {
        initComponents();
        
        // Initialixzing the structures to hold Districts and cities
        this.districtCityMap = new HashMap<String, ArrayList<String>>();      
        this.districts = new String[2];
        this.bloodGroup = new String[]{"O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-"};
        this.PopulateDistrictCityMap();
        // Setting the default location to the middle of the screen
        this.setLocationRelativeTo(null);
    }

    // Function to set the visibility of different panels 
    // The method first sets the visibility oif all the other panel except the required one to false.
    // Then it sets the visibility of the required panel to true.
    public void SetVisibility( JPanel panel )
    {
        HomePanel.setVisible(false);
        BloodUrgentPanel.setVisible(false);
        RegisterDonorPanel.setVisible(false);
        ViewDonorsPanel.setVisible(false);
        DeleteDonorPanel.setVisible(false);
        AddAcceptorPanel.setVisible(false);
        ViewAcceptorsPanel.setVisible(false);
        
        panel.setVisible(true);             
    }
    
    // For blindly entering raw data to the data stucture for districtcity mapping
    public void PopulateDistrictCityMap()
    {
        ArrayList<String> tvmCity = new ArrayList<String>();ArrayList<String> kollamCity = new ArrayList<String>();;
        this.districts = new String[]{"Thiruvananthapuram", "Kollam"};
        tvmCity.add("Thiruvananthapuram");tvmCity.add("Neyyattinkara");tvmCity.add("Nedumangadu");tvmCity.add("Chirayinkeezhu");
        this.districtCityMap.put(districts[0],tvmCity);
        kollamCity.add("Kollam");kollamCity.add("Kottarakkara");kollamCity.add("Pathanapuram");kollamCity.add("Karunagapally");kollamCity.add("Kunnathur");
        this.districtCityMap.put(districts[1],kollamCity);
    }
    
    // Method to populate combo box for districts
    public void PopulateDistrictCombobox(JComboBox boxNameDistrict)
    {
        boxNameDistrict.removeAllItems();
        int i = 0;
        
        // Adding district names to combo box
        while (i < districtCityMap.size())
        {
            boxNameDistrict.addItem(this.districts[i]);
            i++;
        }        
    }
    
    // Method to populate combo box for districts
    public void PopulateCityCombobox(JComboBox boxNameCity, JComboBox boxNameDistrict)
    {       
        boxNameCity.removeAllItems();
        int i = 0;
        ArrayList<String> city;
        
        // Adding corresponding city names to combo box        
        city = this.districtCityMap.get((String)boxNameDistrict.getSelectedItem());
        
        //String[] city1 = new String[city.size()];
        //city1 = city .toArray(city1);
        while (i < city.size())
        {            
            boxNameCity.addItem(city.get(i));
            i++;
        }
    }
    
    // Method to populate blood group in combo box
    public void PopulateBlooodGroupCombobox(JComboBox boxNameBloodGroup)
    {
        int i =0;
        while (i < bloodGroup.length)
        {
            boxNameBloodGroup.addItem(bloodGroup[i]);
            i++;
        }
    }
    
    // Populate table with all acceptor details
    public void PopulateAcceptorDetails(JTable table)
    {
        // By default setst the table with all acceptors in db
        DataBaseManager manager = null; 
        ResultSet rs = null; 
        try 
            {
                manager = new DataBaseManager();
                rs = manager.RetrieveAcceptorDetails();
                if ( null == rs )
                {
                    
                }
                else
                {
                   table.setModel(DbUtils.resultSetToTableModel(rs));
                }
                
                // deallocation
                manager.closeConection();
                manager    = null;
                rs         = null;
                
            } 
            catch (ClassNotFoundException | SQLException ex) 
            {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
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

        AcceptorSearchDialog = new javax.swing.JDialog();
        AcceptorSearchBasePanel = new javax.swing.JPanel();
        AcceptoSearchTextfield = new javax.swing.JTextField();
        AcceptorSearchScrollPane = new javax.swing.JScrollPane();
        AcceptorSearchTable = new javax.swing.JTable();
        AcceptSearchOKButton = new javax.swing.JButton();
        AcceptorSearchCloseButton = new javax.swing.JButton();
        AcceptorSearchLabel = new javax.swing.JLabel();
        FeedbackViewerDialog = new javax.swing.JDialog();
        FeedbackViewerBasePanel = new javax.swing.JPanel();
        FeedbackViewerScrollPane = new javax.swing.JScrollPane();
        FeedbackViewerTable = new javax.swing.JTable();
        FeedbackViewerCloseButton = new javax.swing.JButton();
        PrintFeedbackPrintButton = new javax.swing.JButton();
        BasePanel = new javax.swing.JPanel();
        HeaderPanel = new javax.swing.JPanel();
        DonorSidePanel = new javax.swing.JPanel();
        RegisterDonorButton = new javax.swing.JButton();
        ViewDonorsButton = new javax.swing.JButton();
        DeleteDonorSidePanelButton = new javax.swing.JButton();
        AcceptorSidePanel = new javax.swing.JPanel();
        AddAcceptorSidepanelButton = new javax.swing.JButton();
        ViewAcceptorsSidePanelButton = new javax.swing.JButton();
        GeneralSidePanel = new javax.swing.JPanel();
        HomeButton = new javax.swing.JButton();
        BloodUrgentButton = new javax.swing.JButton();
        MiddlePanel = new javax.swing.JPanel();
        HomePanel = new javax.swing.JPanel();
        HomeImageLabel = new javax.swing.JLabel();
        BloodUrgentPanel = new javax.swing.JPanel();
        BloodUrgentSubpanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BloodUrgentBloodCombobox = new javax.swing.JComboBox<>();
        BloodUrgentDistrictCombobox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        BloodUrgentCityCombobox = new javax.swing.JComboBox<>();
        ButtonHolderPanel = new javax.swing.JPanel();
        BloodUrgentCityButton = new javax.swing.JButton();
        BloodUrgentDistrictButton = new javax.swing.JButton();
        BloodUrgentViewAllButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        AvailableDonorsTableHolderPanel = new javax.swing.JPanel();
        AvailableDonorsTableScrollPane = new javax.swing.JScrollPane();
        AvailableDonorsTable = new javax.swing.JTable();
        BloodUrgentPassInformationButton = new javax.swing.JButton();
        BloodUrgentClearfieldsButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        BloodUrgentAcceptorIDTextfield = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        BloodUrgentDueDateChooser = new com.toedter.calendar.JDateChooser();
        RegisterDonorPanel = new javax.swing.JPanel();
        RegisterDonorSubpanel = new javax.swing.JPanel();
        NameLabel = new javax.swing.JLabel();
        DonorNameTextField = new javax.swing.JTextField();
        AddressLabel = new javax.swing.JLabel();
        AdressScrollPane = new javax.swing.JScrollPane();
        AddressTextArea = new javax.swing.JTextArea();
        BloodGroupLabel = new javax.swing.JLabel();
        BloodGroupCombobox = new javax.swing.JComboBox<>();
        DistrictLabel = new javax.swing.JLabel();
        DistrictCombobox = new javax.swing.JComboBox<>();
        CityLabel = new javax.swing.JLabel();
        CityCombobox = new javax.swing.JComboBox<>();
        PhoneLabel = new javax.swing.JLabel();
        PhoneTextField = new javax.swing.JTextField();
        RegDateChooser = new com.toedter.calendar.JDateChooser();
        DateLabel = new javax.swing.JLabel();
        AgeLabel = new javax.swing.JLabel();
        AgeTextfield = new javax.swing.JTextField();
        RegisterButton = new javax.swing.JButton();
        RegisterClearButton = new javax.swing.JButton();
        ViewDonorsPanel = new javax.swing.JPanel();
        ViewDonorsSubPanel = new javax.swing.JPanel();
        ViewDonorsScrollpane = new javax.swing.JScrollPane();
        ViewDonorsTable = new javax.swing.JTable();
        SearchDonorLabel = new javax.swing.JLabel();
        ViewDonorsDistrictCombobox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        ViewDonorsCityCombobox = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        ViewDonorsCityButton = new javax.swing.JButton();
        ViewDonorsDistrictButton = new javax.swing.JButton();
        ViewDonorsBloodButton = new javax.swing.JButton();
        ViewDonorsViewAllButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ViewDonorsBloodgroupCombobox = new javax.swing.JComboBox<>();
        DeleteDonorPanel = new javax.swing.JPanel();
        DeleteDonorSubpanel = new javax.swing.JPanel();
        DeleteDonorScrollpane = new javax.swing.JScrollPane();
        DeleteDonorTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        DeleteDonorSearchTextfield = new javax.swing.JTextField();
        DeleteDonorDeleteButton = new javax.swing.JButton();
        AddAcceptorPanel = new javax.swing.JPanel();
        AddAcceptorSubPanel = new javax.swing.JPanel();
        NameLabel2 = new javax.swing.JLabel();
        AcceptorNameTextField = new javax.swing.JTextField();
        AddressLabel2 = new javax.swing.JLabel();
        AdressScrollPane2 = new javax.swing.JScrollPane();
        AcceptorAddressTextArea = new javax.swing.JTextArea();
        DistrictLabel2 = new javax.swing.JLabel();
        AcceptorDistrictCombobox = new javax.swing.JComboBox<>();
        CityLabel2 = new javax.swing.JLabel();
        AcceptorCityCombobox = new javax.swing.JComboBox<>();
        PhoneLabel2 = new javax.swing.JLabel();
        AcceptorPhoneTextField = new javax.swing.JTextField();
        AcceptorDateChooser = new com.toedter.calendar.JDateChooser();
        DateLabel2 = new javax.swing.JLabel();
        RegisterAcceptorButton = new javax.swing.JButton();
        AcceptorClearButton = new javax.swing.JButton();
        ViewAcceptorsPanel = new javax.swing.JPanel();
        ViewAcceptorsSubPanel = new javax.swing.JPanel();
        ViewAcceptorsScrollpane = new javax.swing.JScrollPane();
        ViewAcceptorsTable = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        SearchAcceptorTextfield = new javax.swing.JTextField();
        ViewAcceptorPanelButtonHolderPanel = new javax.swing.JPanel();
        PendingFeedbacksButton = new javax.swing.JButton();
        DeleteAcceptorRecordButton = new javax.swing.JButton();
        WillingFeedbacksButton = new javax.swing.JButton();
        NotWillingFeedbacksButton = new javax.swing.JButton();
        FooterPanel = new javax.swing.JPanel();
        LogoutPanel = new javax.swing.JPanel();
        LogoutButton = new javax.swing.JButton();

        AcceptorSearchDialog.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AcceptorSearchBasePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Search acceptor..", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Miriam Fixed", 0, 12))); // NOI18N

        AcceptoSearchTextfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AcceptoSearchTextfieldKeyReleased(evt);
            }
        });

        AcceptorSearchTable.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        AcceptorSearchTable.setForeground(new java.awt.Color(102, 0, 0));
        AcceptorSearchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        AcceptorSearchScrollPane.setViewportView(AcceptorSearchTable);

        AcceptSearchOKButton.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        AcceptSearchOKButton.setText("OK");
        AcceptSearchOKButton.setBorder(null);
        AcceptSearchOKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcceptSearchOKButtonActionPerformed(evt);
            }
        });

        AcceptorSearchCloseButton.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        AcceptorSearchCloseButton.setText("CLOSE");
        AcceptorSearchCloseButton.setBorder(null);
        AcceptorSearchCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcceptorSearchCloseButtonActionPerformed(evt);
            }
        });

        AcceptorSearchLabel.setFont(new java.awt.Font("Miriam Fixed", 1, 14)); // NOI18N
        AcceptorSearchLabel.setForeground(new java.awt.Color(102, 0, 0));
        AcceptorSearchLabel.setText("Search acceptor name");

        javax.swing.GroupLayout AcceptorSearchBasePanelLayout = new javax.swing.GroupLayout(AcceptorSearchBasePanel);
        AcceptorSearchBasePanel.setLayout(AcceptorSearchBasePanelLayout);
        AcceptorSearchBasePanelLayout.setHorizontalGroup(
            AcceptorSearchBasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AcceptorSearchBasePanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(AcceptorSearchLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AcceptorSearchBasePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AcceptorSearchBasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AcceptoSearchTextfield)
                    .addComponent(AcceptorSearchScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AcceptorSearchBasePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(AcceptSearchOKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AcceptorSearchCloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        AcceptorSearchBasePanelLayout.setVerticalGroup(
            AcceptorSearchBasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AcceptorSearchBasePanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(AcceptorSearchLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AcceptoSearchTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AcceptorSearchScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(AcceptorSearchBasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AcceptSearchOKButton, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(AcceptorSearchCloseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AcceptorSearchDialog.getContentPane().add(AcceptorSearchBasePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        FeedbackViewerDialog.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FeedbackViewerBasePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "View pending feedbacks...", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Miriam Fixed", 0, 12))); // NOI18N

        FeedbackViewerTable.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        FeedbackViewerTable.setForeground(new java.awt.Color(102, 0, 0));
        FeedbackViewerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Phone", "Requested_Blood", "Due date"
            }
        ));
        FeedbackViewerScrollPane.setViewportView(FeedbackViewerTable);

        FeedbackViewerCloseButton.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        FeedbackViewerCloseButton.setText("CLOSE");
        FeedbackViewerCloseButton.setBorder(null);
        FeedbackViewerCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeedbackViewerCloseButtonActionPerformed(evt);
            }
        });

        PrintFeedbackPrintButton.setBackground(new java.awt.Color(0, 102, 102));
        PrintFeedbackPrintButton.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        PrintFeedbackPrintButton.setForeground(new java.awt.Color(255, 255, 255));
        PrintFeedbackPrintButton.setText("PRINT");
        PrintFeedbackPrintButton.setEnabled(false);
        PrintFeedbackPrintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintFeedbackPrintButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FeedbackViewerBasePanelLayout = new javax.swing.GroupLayout(FeedbackViewerBasePanel);
        FeedbackViewerBasePanel.setLayout(FeedbackViewerBasePanelLayout);
        FeedbackViewerBasePanelLayout.setHorizontalGroup(
            FeedbackViewerBasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FeedbackViewerBasePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FeedbackViewerBasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FeedbackViewerScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FeedbackViewerBasePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(PrintFeedbackPrintButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(FeedbackViewerCloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        FeedbackViewerBasePanelLayout.setVerticalGroup(
            FeedbackViewerBasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FeedbackViewerBasePanelLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(FeedbackViewerScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FeedbackViewerBasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FeedbackViewerCloseButton, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(PrintFeedbackPrintButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        FeedbackViewerDialog.getContentPane().add(FeedbackViewerBasePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        HeaderPanel.setBackground(new java.awt.Color(51, 51, 51));
        HeaderPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout HeaderPanelLayout = new javax.swing.GroupLayout(HeaderPanel);
        HeaderPanel.setLayout(HeaderPanelLayout);
        HeaderPanelLayout.setHorizontalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        HeaderPanelLayout.setVerticalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        DonorSidePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Donor Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Miriam Fixed", 0, 12))); // NOI18N

        RegisterDonorButton.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        RegisterDonorButton.setText("Register Donor");
        RegisterDonorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterDonorButtonActionPerformed(evt);
            }
        });

        ViewDonorsButton.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        ViewDonorsButton.setText("View Donors");
        ViewDonorsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewDonorsButtonActionPerformed(evt);
            }
        });

        DeleteDonorSidePanelButton.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        DeleteDonorSidePanelButton.setText("Delete Donor");
        DeleteDonorSidePanelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteDonorSidePanelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DonorSidePanelLayout = new javax.swing.GroupLayout(DonorSidePanel);
        DonorSidePanel.setLayout(DonorSidePanelLayout);
        DonorSidePanelLayout.setHorizontalGroup(
            DonorSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DonorSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DonorSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ViewDonorsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteDonorSidePanelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RegisterDonorButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DonorSidePanelLayout.setVerticalGroup(
            DonorSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DonorSidePanelLayout.createSequentialGroup()
                .addComponent(RegisterDonorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ViewDonorsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeleteDonorSidePanelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        AcceptorSidePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Acceptor Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Miriam Fixed", 0, 12))); // NOI18N

        AddAcceptorSidepanelButton.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        AddAcceptorSidepanelButton.setText("Add Acceptor");
        AddAcceptorSidepanelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAcceptorSidepanelButtonActionPerformed(evt);
            }
        });

        ViewAcceptorsSidePanelButton.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        ViewAcceptorsSidePanelButton.setText("View Acceptors");
        ViewAcceptorsSidePanelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewAcceptorsSidePanelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AcceptorSidePanelLayout = new javax.swing.GroupLayout(AcceptorSidePanel);
        AcceptorSidePanel.setLayout(AcceptorSidePanelLayout);
        AcceptorSidePanelLayout.setHorizontalGroup(
            AcceptorSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AcceptorSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AcceptorSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddAcceptorSidepanelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ViewAcceptorsSidePanelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        AcceptorSidePanelLayout.setVerticalGroup(
            AcceptorSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AcceptorSidePanelLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(AddAcceptorSidepanelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(ViewAcceptorsSidePanelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        GeneralSidePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "General Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Miriam Fixed", 0, 12))); // NOI18N

        HomeButton.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        HomeButton.setText("Home");
        HomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeButtonActionPerformed(evt);
            }
        });

        BloodUrgentButton.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        BloodUrgentButton.setText("Blood URGENT!");
        BloodUrgentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BloodUrgentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GeneralSidePanelLayout = new javax.swing.GroupLayout(GeneralSidePanel);
        GeneralSidePanel.setLayout(GeneralSidePanelLayout);
        GeneralSidePanelLayout.setHorizontalGroup(
            GeneralSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GeneralSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GeneralSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GeneralSidePanelLayout.createSequentialGroup()
                        .addComponent(HomeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GeneralSidePanelLayout.createSequentialGroup()
                        .addComponent(BloodUrgentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        GeneralSidePanelLayout.setVerticalGroup(
            GeneralSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GeneralSidePanelLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(HomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BloodUrgentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        MiddlePanel.setLayout(new java.awt.CardLayout());

        HomePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Home", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Miriam Fixed", 0, 12))); // NOI18N

        HomeImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BDMS/Images/Home_image.JPG"))); // NOI18N

        javax.swing.GroupLayout HomePanelLayout = new javax.swing.GroupLayout(HomePanel);
        HomePanel.setLayout(HomePanelLayout);
        HomePanelLayout.setHorizontalGroup(
            HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HomeImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 796, Short.MAX_VALUE)
                .addContainerGap())
        );
        HomePanelLayout.setVerticalGroup(
            HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomePanelLayout.createSequentialGroup()
                .addComponent(HomeImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 483, Short.MAX_VALUE)
                .addContainerGap())
        );

        MiddlePanel.add(HomePanel, "card3");

        BloodUrgentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Blood needed urgently!", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Miriam Fixed", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        jLabel1.setText("Blood group");

        jLabel2.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        jLabel2.setText("District");

        BloodUrgentBloodCombobox.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N

        BloodUrgentDistrictCombobox.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        jLabel3.setText("City");

        BloodUrgentCityCombobox.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        BloodUrgentCityCombobox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BloodUrgentCityComboboxMouseClicked(evt);
            }
        });

        ButtonHolderPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BloodUrgentCityButton.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        BloodUrgentCityButton.setText("View by City");
        BloodUrgentCityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BloodUrgentCityButtonActionPerformed(evt);
            }
        });

        BloodUrgentDistrictButton.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        BloodUrgentDistrictButton.setText("View by District");
        BloodUrgentDistrictButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BloodUrgentDistrictButtonActionPerformed(evt);
            }
        });

        BloodUrgentViewAllButton.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        BloodUrgentViewAllButton.setText("View All");
        BloodUrgentViewAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BloodUrgentViewAllButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ButtonHolderPanelLayout = new javax.swing.GroupLayout(ButtonHolderPanel);
        ButtonHolderPanel.setLayout(ButtonHolderPanelLayout);
        ButtonHolderPanelLayout.setHorizontalGroup(
            ButtonHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonHolderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ButtonHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BloodUrgentCityButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BloodUrgentViewAllButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BloodUrgentDistrictButton, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ButtonHolderPanelLayout.setVerticalGroup(
            ButtonHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonHolderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BloodUrgentCityButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BloodUrgentDistrictButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BloodUrgentViewAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Available donors", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Miriam Fixed", 0, 12))); // NOI18N

        AvailableDonorsTable.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        AvailableDonorsTable.setForeground(new java.awt.Color(102, 0, 0));
        AvailableDonorsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Donor ID", "Name", "Phone"
            }
        ));
        AvailableDonorsTableScrollPane.setViewportView(AvailableDonorsTable);

        javax.swing.GroupLayout AvailableDonorsTableHolderPanelLayout = new javax.swing.GroupLayout(AvailableDonorsTableHolderPanel);
        AvailableDonorsTableHolderPanel.setLayout(AvailableDonorsTableHolderPanelLayout);
        AvailableDonorsTableHolderPanelLayout.setHorizontalGroup(
            AvailableDonorsTableHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(AvailableDonorsTableHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(AvailableDonorsTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE))
        );
        AvailableDonorsTableHolderPanelLayout.setVerticalGroup(
            AvailableDonorsTableHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
            .addGroup(AvailableDonorsTableHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(AvailableDonorsTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
        );

        BloodUrgentPassInformationButton.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        BloodUrgentPassInformationButton.setText("Pass Information");
        BloodUrgentPassInformationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BloodUrgentPassInformationButtonActionPerformed(evt);
            }
        });

        BloodUrgentClearfieldsButton.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        BloodUrgentClearfieldsButton.setText("Clear fields!");
        BloodUrgentClearfieldsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BloodUrgentClearfieldsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AvailableDonorsTableHolderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(BloodUrgentPassInformationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(BloodUrgentClearfieldsButton)
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(AvailableDonorsTableHolderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BloodUrgentPassInformationButton, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(BloodUrgentClearfieldsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        jLabel8.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        jLabel8.setText("Acceptor ID");

        BloodUrgentAcceptorIDTextfield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BloodUrgentAcceptorIDTextfieldMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        jLabel9.setText("Due date");

        BloodUrgentDueDateChooser.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout BloodUrgentSubpanelLayout = new javax.swing.GroupLayout(BloodUrgentSubpanel);
        BloodUrgentSubpanel.setLayout(BloodUrgentSubpanelLayout);
        BloodUrgentSubpanelLayout.setHorizontalGroup(
            BloodUrgentSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BloodUrgentSubpanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(BloodUrgentSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonHolderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(BloodUrgentSubpanelLayout.createSequentialGroup()
                        .addGroup(BloodUrgentSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addGroup(BloodUrgentSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BloodUrgentBloodCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BloodUrgentDistrictCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BloodUrgentCityCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BloodUrgentAcceptorIDTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(BloodUrgentSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BloodUrgentSubpanelLayout.createSequentialGroup()
                    .addContainerGap(140, Short.MAX_VALUE)
                    .addComponent(BloodUrgentDueDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(512, Short.MAX_VALUE)))
        );
        BloodUrgentSubpanelLayout.setVerticalGroup(
            BloodUrgentSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BloodUrgentSubpanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(BloodUrgentSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BloodUrgentBloodCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BloodUrgentSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BloodUrgentDistrictCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BloodUrgentSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BloodUrgentCityCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BloodUrgentSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BloodUrgentAcceptorIDTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonHolderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(BloodUrgentSubpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(BloodUrgentSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BloodUrgentSubpanelLayout.createSequentialGroup()
                    .addContainerGap(226, Short.MAX_VALUE)
                    .addComponent(BloodUrgentDueDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(213, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout BloodUrgentPanelLayout = new javax.swing.GroupLayout(BloodUrgentPanel);
        BloodUrgentPanel.setLayout(BloodUrgentPanelLayout);
        BloodUrgentPanelLayout.setHorizontalGroup(
            BloodUrgentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BloodUrgentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BloodUrgentSubpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        BloodUrgentPanelLayout.setVerticalGroup(
            BloodUrgentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BloodUrgentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BloodUrgentSubpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        MiddlePanel.add(BloodUrgentPanel, "card4");

        RegisterDonorPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Donor registration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Miriam Fixed", 0, 12))); // NOI18N
        RegisterDonorPanel.setPreferredSize(new java.awt.Dimension(750, 504));
        RegisterDonorPanel.setLayout(null);

        RegisterDonorSubpanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        NameLabel.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        NameLabel.setText("Name");

        DonorNameTextField.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N

        AddressLabel.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        AddressLabel.setText("Address");

        AddressTextArea.setColumns(20);
        AddressTextArea.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        AddressTextArea.setRows(5);
        AdressScrollPane.setViewportView(AddressTextArea);

        BloodGroupLabel.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        BloodGroupLabel.setText("Blood - group");

        BloodGroupCombobox.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N

        DistrictLabel.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        DistrictLabel.setText("District");

        DistrictCombobox.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        DistrictCombobox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DistrictComboboxMouseExited(evt);
            }
        });

        CityLabel.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        CityLabel.setText("City");

        CityCombobox.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        CityCombobox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CityComboboxMouseClicked(evt);
            }
        });

        PhoneLabel.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        PhoneLabel.setText("Phone no");

        PhoneTextField.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N

        RegDateChooser.setDateFormatString("yyyy-MM-dd");

        DateLabel.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        DateLabel.setText("Date");

        AgeLabel.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        AgeLabel.setText("Age");

        AgeTextfield.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N

        javax.swing.GroupLayout RegisterDonorSubpanelLayout = new javax.swing.GroupLayout(RegisterDonorSubpanel);
        RegisterDonorSubpanel.setLayout(RegisterDonorSubpanelLayout);
        RegisterDonorSubpanelLayout.setHorizontalGroup(
            RegisterDonorSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterDonorSubpanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(RegisterDonorSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(RegisterDonorSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(RegDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DonorNameTextField)
                    .addComponent(AdressScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                .addGap(86, 86, 86)
                .addGroup(RegisterDonorSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DistrictLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PhoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BloodGroupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(RegisterDonorSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BloodGroupCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CityCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DistrictCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(RegisterDonorSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(AgeTextfield, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                        .addComponent(PhoneTextField, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        RegisterDonorSubpanelLayout.setVerticalGroup(
            RegisterDonorSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterDonorSubpanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(RegisterDonorSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DonorNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BloodGroupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BloodGroupCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(RegisterDonorSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(RegisterDonorSubpanelLayout.createSequentialGroup()
                        .addGroup(RegisterDonorSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DistrictLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DistrictCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(RegisterDonorSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(RegisterDonorSubpanelLayout.createSequentialGroup()
                                .addComponent(CityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE))
                            .addComponent(CityCombobox)))
                    .addComponent(AdressScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(RegisterDonorSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PhoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(RegisterDonorSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(RegDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(RegisterDonorSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AgeLabel)
                        .addComponent(AgeTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        RegisterDonorPanel.add(RegisterDonorSubpanel);
        RegisterDonorSubpanel.setBounds(16, 26, 786, 414);

        RegisterButton.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        RegisterButton.setText("Register");
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });
        RegisterDonorPanel.add(RegisterButton);
        RegisterButton.setBounds(470, 451, 91, 33);

        RegisterClearButton.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        RegisterClearButton.setText("Clear");
        RegisterClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterClearButtonActionPerformed(evt);
            }
        });
        RegisterDonorPanel.add(RegisterClearButton);
        RegisterClearButton.setBounds(591, 451, 87, 33);

        MiddlePanel.add(RegisterDonorPanel, "card5");

        ViewDonorsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "View donors", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Miriam Fixed", 0, 12))); // NOI18N
        ViewDonorsPanel.setLayout(null);

        ViewDonorsTable.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        ViewDonorsTable.setForeground(new java.awt.Color(204, 0, 0));
        ViewDonorsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        )
    );
    ViewDonorsScrollpane.setViewportView(ViewDonorsTable);

    javax.swing.GroupLayout ViewDonorsSubPanelLayout = new javax.swing.GroupLayout(ViewDonorsSubPanel);
    ViewDonorsSubPanel.setLayout(ViewDonorsSubPanelLayout);
    ViewDonorsSubPanelLayout.setHorizontalGroup(
        ViewDonorsSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 780, Short.MAX_VALUE)
        .addGroup(ViewDonorsSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ViewDonorsScrollpane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE))
    );
    ViewDonorsSubPanelLayout.setVerticalGroup(
        ViewDonorsSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 360, Short.MAX_VALUE)
        .addGroup(ViewDonorsSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ViewDonorsScrollpane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
    );

    ViewDonorsPanel.add(ViewDonorsSubPanel);
    ViewDonorsSubPanel.setBounds(24, 135, 780, 360);

    SearchDonorLabel.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    SearchDonorLabel.setText("City");
    ViewDonorsPanel.add(SearchDonorLabel);
    SearchDonorLabel.setBounds(30, 80, 60, 30);

    ViewDonorsDistrictCombobox.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    ViewDonorsPanel.add(ViewDonorsDistrictCombobox);
    ViewDonorsDistrictCombobox.setBounds(110, 30, 200, 40);

    jLabel5.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    jLabel5.setText("District");
    ViewDonorsPanel.add(jLabel5);
    jLabel5.setBounds(30, 40, 60, 20);

    ViewDonorsCityCombobox.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    ViewDonorsCityCombobox.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            ViewDonorsCityComboboxMouseClicked(evt);
        }
    });
    ViewDonorsPanel.add(ViewDonorsCityCombobox);
    ViewDonorsCityCombobox.setBounds(110, 80, 200, 40);

    jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    ViewDonorsCityButton.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    ViewDonorsCityButton.setText("Search by City");
    ViewDonorsCityButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ViewDonorsCityButtonActionPerformed(evt);
        }
    });

    ViewDonorsDistrictButton.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    ViewDonorsDistrictButton.setText("Search by District");
    ViewDonorsDistrictButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ViewDonorsDistrictButtonActionPerformed(evt);
        }
    });

    ViewDonorsBloodButton.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    ViewDonorsBloodButton.setText("Search by Group");
    ViewDonorsBloodButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ViewDonorsBloodButtonActionPerformed(evt);
        }
    });

    ViewDonorsViewAllButton.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    ViewDonorsViewAllButton.setText("View all");
    ViewDonorsViewAllButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ViewDonorsViewAllButtonActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ViewDonorsDistrictButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ViewDonorsCityButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(ViewDonorsViewAllButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ViewDonorsBloodButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addComponent(ViewDonorsCityButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ViewDonorsBloodButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(ViewDonorsDistrictButton, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addComponent(ViewDonorsViewAllButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );

    ViewDonorsPanel.add(jPanel2);
    jPanel2.setBounds(320, 20, 330, 100);

    jLabel6.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    jLabel6.setText("Blood");
    ViewDonorsPanel.add(jLabel6);
    jLabel6.setBounds(670, 44, 40, 20);

    ViewDonorsBloodgroupCombobox.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    ViewDonorsPanel.add(ViewDonorsBloodgroupCombobox);
    ViewDonorsBloodgroupCombobox.setBounds(720, 40, 70, 30);

    MiddlePanel.add(ViewDonorsPanel, "card6");

    DeleteDonorPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Delete donor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Miriam Fixed", 0, 12))); // NOI18N
    DeleteDonorPanel.setLayout(null);

    DeleteDonorTable.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    DeleteDonorTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null},
            {null},
            {null},
            {null}
        },
        new String [] {
            "Details"
        }
    ));
    DeleteDonorScrollpane.setViewportView(DeleteDonorTable);

    javax.swing.GroupLayout DeleteDonorSubpanelLayout = new javax.swing.GroupLayout(DeleteDonorSubpanel);
    DeleteDonorSubpanel.setLayout(DeleteDonorSubpanelLayout);
    DeleteDonorSubpanelLayout.setHorizontalGroup(
        DeleteDonorSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 770, Short.MAX_VALUE)
        .addGroup(DeleteDonorSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DeleteDonorScrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE))
    );
    DeleteDonorSubpanelLayout.setVerticalGroup(
        DeleteDonorSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 365, Short.MAX_VALUE)
        .addGroup(DeleteDonorSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DeleteDonorScrollpane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
    );

    DeleteDonorPanel.add(DeleteDonorSubpanel);
    DeleteDonorSubpanel.setBounds(20, 90, 770, 365);

    jLabel7.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    jLabel7.setText("Search donor");
    DeleteDonorPanel.add(jLabel7);
    jLabel7.setBounds(30, 34, 100, 30);

    DeleteDonorSearchTextfield.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    DeleteDonorSearchTextfield.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            DeleteDonorSearchTextfieldKeyReleased(evt);
        }
    });
    DeleteDonorPanel.add(DeleteDonorSearchTextfield);
    DeleteDonorSearchTextfield.setBounds(140, 30, 240, 30);

    DeleteDonorDeleteButton.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    DeleteDonorDeleteButton.setText("Delete");
    DeleteDonorDeleteButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            DeleteDonorDeleteButtonActionPerformed(evt);
        }
    });
    DeleteDonorPanel.add(DeleteDonorDeleteButton);
    DeleteDonorDeleteButton.setBounds(590, 30, 110, 40);

    MiddlePanel.add(DeleteDonorPanel, "card7");

    AddAcceptorPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Acceptor registration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Miriam Fixed", 0, 12))); // NOI18N
    AddAcceptorPanel.setPreferredSize(new java.awt.Dimension(750, 504));
    AddAcceptorPanel.setLayout(null);

    AddAcceptorSubPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    NameLabel2.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    NameLabel2.setText("Name");

    AcceptorNameTextField.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N

    AddressLabel2.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    AddressLabel2.setText("Address");

    AcceptorAddressTextArea.setColumns(20);
    AcceptorAddressTextArea.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    AcceptorAddressTextArea.setRows(5);
    AdressScrollPane2.setViewportView(AcceptorAddressTextArea);

    DistrictLabel2.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    DistrictLabel2.setText("District");

    AcceptorDistrictCombobox.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N

    CityLabel2.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    CityLabel2.setText("City");

    AcceptorCityCombobox.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    AcceptorCityCombobox.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            AcceptorCityComboboxMouseClicked(evt);
        }
    });

    PhoneLabel2.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    PhoneLabel2.setText("Phone no");

    AcceptorPhoneTextField.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N

    AcceptorDateChooser.setDateFormatString("yyyy-MM-dd");

    DateLabel2.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    DateLabel2.setText("Date");

    javax.swing.GroupLayout AddAcceptorSubPanelLayout = new javax.swing.GroupLayout(AddAcceptorSubPanel);
    AddAcceptorSubPanel.setLayout(AddAcceptorSubPanelLayout);
    AddAcceptorSubPanelLayout.setHorizontalGroup(
        AddAcceptorSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(AddAcceptorSubPanelLayout.createSequentialGroup()
            .addGap(31, 31, 31)
            .addGroup(AddAcceptorSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AddAcceptorSubPanelLayout.createSequentialGroup()
                    .addGroup(AddAcceptorSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(NameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AddressLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DateLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(29, 29, 29)
                    .addGroup(AddAcceptorSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(AcceptorDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(AddAcceptorSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(AdressScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                            .addComponent(AcceptorNameTextField))))
                .addGroup(AddAcceptorSubPanelLayout.createSequentialGroup()
                    .addGroup(AddAcceptorSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(CityLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PhoneLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(95, 95, 95)
                    .addGroup(AddAcceptorSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(AcceptorPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AcceptorCityCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                    .addComponent(DistrictLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(34, 34, 34)
                    .addComponent(AcceptorDistrictCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(63, 63, 63))
    );
    AddAcceptorSubPanelLayout.setVerticalGroup(
        AddAcceptorSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(AddAcceptorSubPanelLayout.createSequentialGroup()
            .addGap(28, 28, 28)
            .addGroup(AddAcceptorSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(NameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(AcceptorNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(24, 24, 24)
            .addGroup(AddAcceptorSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(AddressLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(AdressScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(22, 22, 22)
            .addGroup(AddAcceptorSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DateLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(AcceptorDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(AddAcceptorSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AddAcceptorSubPanelLayout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addGroup(AddAcceptorSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DistrictLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AcceptorDistrictCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AcceptorCityCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CityLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(AddAcceptorSubPanelLayout.createSequentialGroup()
                    .addGap(25, 97, Short.MAX_VALUE)
                    .addGroup(AddAcceptorSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AcceptorPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PhoneLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(32, 32, 32))))
    );

    AddAcceptorPanel.add(AddAcceptorSubPanel);
    AddAcceptorSubPanel.setBounds(16, 26, 780, 414);

    RegisterAcceptorButton.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    RegisterAcceptorButton.setText("Register");
    RegisterAcceptorButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            RegisterAcceptorButtonActionPerformed(evt);
        }
    });
    AddAcceptorPanel.add(RegisterAcceptorButton);
    RegisterAcceptorButton.setBounds(470, 451, 91, 33);

    AcceptorClearButton.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    AcceptorClearButton.setText("Clear");
    AcceptorClearButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            AcceptorClearButtonActionPerformed(evt);
        }
    });
    AddAcceptorPanel.add(AcceptorClearButton);
    AcceptorClearButton.setBounds(591, 451, 87, 33);

    MiddlePanel.add(AddAcceptorPanel, "card5");

    ViewAcceptorsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "View acceptors", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Miriam Fixed", 0, 12))); // NOI18N
    ViewAcceptorsPanel.setLayout(null);

    ViewAcceptorsTable.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    ViewAcceptorsTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null},
            {null},
            {null},
            {null}
        },
        new String [] {
            "Details"
        }
    ));
    ViewAcceptorsScrollpane.setViewportView(ViewAcceptorsTable);

    javax.swing.GroupLayout ViewAcceptorsSubPanelLayout = new javax.swing.GroupLayout(ViewAcceptorsSubPanel);
    ViewAcceptorsSubPanel.setLayout(ViewAcceptorsSubPanelLayout);
    ViewAcceptorsSubPanelLayout.setHorizontalGroup(
        ViewAcceptorsSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 780, Short.MAX_VALUE)
        .addGroup(ViewAcceptorsSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ViewAcceptorsScrollpane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE))
    );
    ViewAcceptorsSubPanelLayout.setVerticalGroup(
        ViewAcceptorsSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 360, Short.MAX_VALUE)
        .addGroup(ViewAcceptorsSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ViewAcceptorsScrollpane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
    );

    ViewAcceptorsPanel.add(ViewAcceptorsSubPanel);
    ViewAcceptorsSubPanel.setBounds(24, 135, 780, 360);

    jLabel12.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    jLabel12.setText("Search acceptor");
    ViewAcceptorsPanel.add(jLabel12);
    jLabel12.setBounds(30, 60, 120, 30);

    SearchAcceptorTextfield.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    SearchAcceptorTextfield.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            SearchAcceptorTextfieldKeyReleased(evt);
        }
    });
    ViewAcceptorsPanel.add(SearchAcceptorTextfield);
    SearchAcceptorTextfield.setBounds(160, 60, 240, 30);

    ViewAcceptorPanelButtonHolderPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    PendingFeedbacksButton.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    PendingFeedbacksButton.setText("Pending feedbacks");
    PendingFeedbacksButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            PendingFeedbacksButtonActionPerformed(evt);
        }
    });

    DeleteAcceptorRecordButton.setBackground(new java.awt.Color(102, 0, 0));
    DeleteAcceptorRecordButton.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    DeleteAcceptorRecordButton.setForeground(new java.awt.Color(255, 255, 255));
    DeleteAcceptorRecordButton.setText("Delete record");
    DeleteAcceptorRecordButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            DeleteAcceptorRecordButtonActionPerformed(evt);
        }
    });

    WillingFeedbacksButton.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    WillingFeedbacksButton.setText("Willing feedbacks");
    WillingFeedbacksButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            WillingFeedbacksButtonActionPerformed(evt);
        }
    });

    NotWillingFeedbacksButton.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
    NotWillingFeedbacksButton.setText("Not-willing  feedbacks");
    NotWillingFeedbacksButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            NotWillingFeedbacksButtonActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout ViewAcceptorPanelButtonHolderPanelLayout = new javax.swing.GroupLayout(ViewAcceptorPanelButtonHolderPanel);
    ViewAcceptorPanelButtonHolderPanel.setLayout(ViewAcceptorPanelButtonHolderPanelLayout);
    ViewAcceptorPanelButtonHolderPanelLayout.setHorizontalGroup(
        ViewAcceptorPanelButtonHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(ViewAcceptorPanelButtonHolderPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(ViewAcceptorPanelButtonHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ViewAcceptorPanelButtonHolderPanelLayout.createSequentialGroup()
                    .addComponent(PendingFeedbacksButton)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NotWillingFeedbacksButton))
                .addGroup(ViewAcceptorPanelButtonHolderPanelLayout.createSequentialGroup()
                    .addComponent(WillingFeedbacksButton)
                    .addGap(28, 28, 28)
                    .addComponent(DeleteAcceptorRecordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGap(24, 24, 24))
    );
    ViewAcceptorPanelButtonHolderPanelLayout.setVerticalGroup(
        ViewAcceptorPanelButtonHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(ViewAcceptorPanelButtonHolderPanelLayout.createSequentialGroup()
            .addGroup(ViewAcceptorPanelButtonHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(PendingFeedbacksButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(NotWillingFeedbacksButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ViewAcceptorPanelButtonHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(WillingFeedbacksButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(DeleteAcceptorRecordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );

    ViewAcceptorsPanel.add(ViewAcceptorPanelButtonHolderPanel);
    ViewAcceptorPanelButtonHolderPanel.setBounds(420, 20, 370, 105);

    MiddlePanel.add(ViewAcceptorsPanel, "card6");

    FooterPanel.setBackground(new java.awt.Color(51, 51, 51));
    FooterPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    javax.swing.GroupLayout FooterPanelLayout = new javax.swing.GroupLayout(FooterPanel);
    FooterPanel.setLayout(FooterPanelLayout);
    FooterPanelLayout.setHorizontalGroup(
        FooterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 0, Short.MAX_VALUE)
    );
    FooterPanelLayout.setVerticalGroup(
        FooterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 41, Short.MAX_VALUE)
    );

    LogoutPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    LogoutButton.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
    LogoutButton.setText("Log out");
    LogoutButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            LogoutButtonActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout LogoutPanelLayout = new javax.swing.GroupLayout(LogoutPanel);
    LogoutPanel.setLayout(LogoutPanelLayout);
    LogoutPanelLayout.setHorizontalGroup(
        LogoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogoutPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(LogoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );
    LogoutPanelLayout.setVerticalGroup(
        LogoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(LogoutPanelLayout.createSequentialGroup()
            .addGap(26, 26, 26)
            .addComponent(LogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(24, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout BasePanelLayout = new javax.swing.GroupLayout(BasePanel);
    BasePanel.setLayout(BasePanelLayout);
    BasePanelLayout.setHorizontalGroup(
        BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(HeaderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(BasePanelLayout.createSequentialGroup()
            .addGroup(BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(GeneralSidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DonorSidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AcceptorSidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogoutPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(6, 6, 6)
            .addComponent(MiddlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addComponent(FooterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    BasePanelLayout.setVerticalGroup(
        BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(BasePanelLayout.createSequentialGroup()
            .addComponent(HeaderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(6, 6, 6)
            .addGroup(BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(BasePanelLayout.createSequentialGroup()
                    .addComponent(GeneralSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(DonorSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AcceptorSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(LogoutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(MiddlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
            .addComponent(FooterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(BasePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(BasePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeButtonActionPerformed
        // Sets the Homepanel visible
        SetVisibility(HomePanel);
    }//GEN-LAST:event_HomeButtonActionPerformed

    private void BloodUrgentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BloodUrgentButtonActionPerformed
       // Sets the BloodUrgentPanel visible
       SetVisibility(BloodUrgentPanel);
       
       // Calling methods to populate district, city and blood-group
       this.PopulateDistrictCombobox(BloodUrgentDistrictCombobox);
       this.PopulateCityCombobox(BloodUrgentCityCombobox, BloodUrgentDistrictCombobox);
       this.PopulateBlooodGroupCombobox(BloodUrgentBloodCombobox);
       
       // clearing fields
       BloodUrgentAcceptorIDTextfield.setText(null);
       ((JTextField)BloodUrgentDueDateChooser.getDateEditor().getUiComponent()).setText(null);
       
       // Setting the row count to 0
       DefaultTableModel dm = (DefaultTableModel)AvailableDonorsTable.getModel();
       dm.setRowCount(0);
    }//GEN-LAST:event_BloodUrgentButtonActionPerformed

    private void RegisterDonorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterDonorButtonActionPerformed
        // Sets the BloodUrgentPanel visible
       SetVisibility(RegisterDonorPanel);
       
       // Calling methods to populate district, city and blood-group
       this.PopulateDistrictCombobox(DistrictCombobox);
       this.PopulateCityCombobox(CityCombobox, DistrictCombobox);
       this.PopulateBlooodGroupCombobox(BloodGroupCombobox);
    }//GEN-LAST:event_RegisterDonorButtonActionPerformed

    private void ViewDonorsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewDonorsButtonActionPerformed
        // Sets the BloodUrgentPanel visible
       SetVisibility(ViewDonorsPanel);
       
       // Calling methods to populate district, city and blood-group
       this.PopulateDistrictCombobox(ViewDonorsDistrictCombobox);
       this.PopulateCityCombobox(ViewDonorsCityCombobox, ViewDonorsDistrictCombobox);
       this.PopulateBlooodGroupCombobox(ViewDonorsBloodgroupCombobox);
    }//GEN-LAST:event_ViewDonorsButtonActionPerformed

    private void DeleteDonorSidePanelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteDonorSidePanelButtonActionPerformed
        // Sets the BloodUrgentPanel visible
       SetVisibility(DeleteDonorPanel);
       
       // Setting the table details
       DataBaseManager manager = null; 
        ResultSet rs = null; 
        
        if( DeleteDonorSearchTextfield.getText().length() == 0 )
        {
            try 
            {
                manager = new DataBaseManager();
                rs = manager.RetrieveDonorOrAcceptorDetails(DeleteDonorSearchTextfield.getText(), "DONOR");
                if ( null == rs )
                {
                    
                }
                else
                {
                   DeleteDonorTable.setModel(DbUtils.resultSetToTableModel(rs));
                }
                
                // deallocation
                manager.closeConection();
                manager    = null;
                rs         = null;
                
            } 
            catch (ClassNotFoundException | SQLException ex) 
            {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_DeleteDonorSidePanelButtonActionPerformed

    private void AddAcceptorSidepanelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAcceptorSidepanelButtonActionPerformed
        // Sets the BloodUrgentPanel visible
       SetVisibility(AddAcceptorPanel);
       
       // Calling methods to populate district, city 
       this.PopulateDistrictCombobox(AcceptorDistrictCombobox);
       this.PopulateCityCombobox(AcceptorCityCombobox, AcceptorDistrictCombobox);
    }//GEN-LAST:event_AddAcceptorSidepanelButtonActionPerformed

    private void ViewAcceptorsSidePanelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewAcceptorsSidePanelButtonActionPerformed
       // Sets view acceptor panel visible
       SetVisibility(ViewAcceptorsPanel);       
       
       // populating table
        PopulateAcceptorDetails(ViewAcceptorsTable);
    }//GEN-LAST:event_ViewAcceptorsSidePanelButtonActionPerformed

    private void CityComboboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CityComboboxMouseClicked
        // Populating city combobox
        this.PopulateCityCombobox(CityCombobox, DistrictCombobox);        
    }//GEN-LAST:event_CityComboboxMouseClicked

    private void DistrictComboboxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DistrictComboboxMouseExited

    }//GEN-LAST:event_DistrictComboboxMouseExited

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
        // Registering the donor
        try
        {
            String name = DonorNameTextField.getText();
            String address = AddressTextArea.getText();
            String blood = (String)BloodGroupCombobox.getSelectedItem();
            String district = (String)DistrictCombobox.getSelectedItem();
            String city = (String)CityCombobox.getSelectedItem();
            String phoneText = PhoneTextField.getText();            
            String ageText = AgeTextfield.getText();            
        
            // Date format adjustments
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String date=((JTextField)RegDateChooser.getDateEditor().getUiComponent()).getText();
            
            
            // Validations
            if (name.isEmpty() || address.isEmpty() || blood.isEmpty() || district.isEmpty() || city.isEmpty() || phoneText.isEmpty() || 
                ageText.isEmpty() || date.isEmpty())
            {
                JOptionPane.showMessageDialog(rootPane, "Empty fields prevent the donor from registering! \n Please check again.");
            }
            else
            {
                Date regDate = formatter.parse(date);
                if (name.length() > 30)
                {
                    JOptionPane.showMessageDialog(rootPane, "Name too long...");
                }
                else if (address.length() > 100)
                {
                    JOptionPane.showMessageDialog(rootPane, "Address too long...");
                }
                else if (phoneText.length() > 10)
                {
                    JOptionPane.showMessageDialog(rootPane, "Phone number should have only 10 characters...");
                }
                else if (ageText.length() > 2)
                {
                    JOptionPane.showMessageDialog(rootPane, "Donor is not fit...");
                }
            
                // Inserting donor details into database
                else
                {
                    try
                    {
                        DataBaseManager dbmanager = new DataBaseManager();
                        dbmanager.RegisterDonor(name, address, regDate, blood, district, city, phoneText, ageText);
                    }
                    catch(ClassNotFoundException | SQLException ex)
                    {
                        JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                    }                                       
                }
        }
        }
        catch(ParseException ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
        
    }//GEN-LAST:event_RegisterButtonActionPerformed

    private void RegisterClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterClearButtonActionPerformed
        // Clearing the fields to null
        DonorNameTextField.setText(null);
        AddressTextArea.setText(null);
        ((JTextField)RegDateChooser.getDateEditor().getUiComponent()).setText(null);
        PhoneTextField.setText(null);
        AgeTextfield.setText(null);
    }//GEN-LAST:event_RegisterClearButtonActionPerformed

    private void ViewDonorsCityComboboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewDonorsCityComboboxMouseClicked
        // Populating city combobox
        this.PopulateCityCombobox(ViewDonorsCityCombobox, ViewDonorsDistrictCombobox); 
    }//GEN-LAST:event_ViewDonorsCityComboboxMouseClicked

    private void ViewDonorsCityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewDonorsCityButtonActionPerformed
        // Searching donor details by city
        String city = (String)ViewDonorsCityCombobox.getSelectedItem();        
        ResultSet rs = null;         
        if (city.isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "City not selected...");
        }
        else
        {
            try
            {
                DataBaseManager dbmanager = new DataBaseManager();
                rs = dbmanager.RetrieveDonorDetails("CITY", city);
                if (rs == null)
                {
                    JOptionPane.showMessageDialog(rootPane,"No donor exists for the current city...");                  
                }
                else
                {                    
                    ViewDonorsTable.setModel( DbUtils.resultSetToTableModel(rs));
                }
                
                // deallocation
                dbmanager.closeConection();
                dbmanager = null;
                rs = null;
            }
            catch(SQLException | ClassNotFoundException ex)
            {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }   
        }
    }//GEN-LAST:event_ViewDonorsCityButtonActionPerformed

    private void ViewDonorsViewAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewDonorsViewAllButtonActionPerformed
        // Displaying all donors
        ResultSet rs = null; 
        try
        {
            DataBaseManager dbmanager = new DataBaseManager();
            rs = dbmanager.RetrieveDonorDetails("ALL", null);            
            if (rs == null)
            {
                JOptionPane.showMessageDialog(rootPane,"Nothing to be displayed...");                  
            }
            else
            {                    
                ViewDonorsTable.setModel( DbUtils.resultSetToTableModel(rs));
            } 
            
            // deallocation
            dbmanager.closeConection();
            dbmanager = null;
            rs = null;
        }
        catch(SQLException | ClassNotFoundException ex)
        {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }         
    }//GEN-LAST:event_ViewDonorsViewAllButtonActionPerformed

    private void ViewDonorsDistrictButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewDonorsDistrictButtonActionPerformed
       // Searching donor details by District       
        String district = (String)ViewDonorsDistrictCombobox.getSelectedItem();
        ResultSet rs = null;         
        if (district.isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "District not selected...");
        }
        else
        {
            try
            {
                DataBaseManager dbmanager = new DataBaseManager();
                rs = dbmanager.RetrieveDonorDetails("DISTRICT", district);
                if (rs == null)
                {
                    JOptionPane.showMessageDialog(rootPane,"No donor exists for the current district...");                  
                }
                else
                {                    
                    ViewDonorsTable.setModel( DbUtils.resultSetToTableModel(rs));
                }
                
                // deallocation
                dbmanager.closeConection();
                dbmanager = null;
                rs = null;
            }
            catch(SQLException | ClassNotFoundException ex)
            {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }   
        }
    }//GEN-LAST:event_ViewDonorsDistrictButtonActionPerformed

    private void ViewDonorsBloodButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewDonorsBloodButtonActionPerformed
        // Searching donor details by blood group       
        String blood = (String)ViewDonorsBloodgroupCombobox.getSelectedItem();
        ResultSet rs = null;         
        if (blood.isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "Blood group not selected...");
        }
        else
        {
            try
            {
                DataBaseManager dbmanager = new DataBaseManager();
                rs = dbmanager.RetrieveDonorDetails("BLOOD", blood);
                if (rs == null)
                {
                    JOptionPane.showMessageDialog(rootPane,"No donor exists with the mentioned blood-group...");                  
                }
                else
                {                    
                    ViewDonorsTable.setModel( DbUtils.resultSetToTableModel(rs));
                }
                
                // deallocation
                dbmanager.closeConection();
                dbmanager    = null;
                rs         = null;
            }
            catch(SQLException | ClassNotFoundException ex)
            {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }   
        }
    }//GEN-LAST:event_ViewDonorsBloodButtonActionPerformed

    private void BloodUrgentCityComboboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BloodUrgentCityComboboxMouseClicked
        // Populating city combobox
        this.PopulateCityCombobox(BloodUrgentCityCombobox, BloodUrgentDistrictCombobox);         
    }//GEN-LAST:event_BloodUrgentCityComboboxMouseClicked

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        // Logging out
        new LoginForm().setVisible(true);
        this.hide();
    }//GEN-LAST:event_LogoutButtonActionPerformed

    private void AcceptorCityComboboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AcceptorCityComboboxMouseClicked
        // Populatind city combobox
        this.PopulateCityCombobox(AcceptorCityCombobox, AcceptorDistrictCombobox);
    }//GEN-LAST:event_AcceptorCityComboboxMouseClicked

    private void RegisterAcceptorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterAcceptorButtonActionPerformed
        // Registering the acceptor
        try
        {
            String name = AcceptorNameTextField.getText();
            String address = AcceptorAddressTextArea.getText();
            String district = (String)AcceptorDistrictCombobox.getSelectedItem();
            String city = (String)AcceptorCityCombobox.getSelectedItem();
            String phoneText = AcceptorPhoneTextField.getText();              
        
            // Date format adjustments
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String date=((JTextField)AcceptorDateChooser.getDateEditor().getUiComponent()).getText();
            
            
            // Validations
            if (name.isEmpty() || address.isEmpty() || district.isEmpty() || city.isEmpty() || phoneText.isEmpty() || date.isEmpty())
            {
                JOptionPane.showMessageDialog(rootPane, "Empty fields prevent the acceptor from registering! \n Please check again.");
            }
            else
            {
                Date regDate = formatter.parse(date);
                if (name.length() > 30)
                {
                    JOptionPane.showMessageDialog(rootPane, "Name too long...");
                }
                else if (address.length() > 100)
                {
                    JOptionPane.showMessageDialog(rootPane, "Address too long...");
                }
                else if (phoneText.length() > 10)
                {
                    JOptionPane.showMessageDialog(rootPane, "Phone number should have only 10 characters...");
                }
            
                // Inserting acceptor details into database
                else
                {
                    try
                    {
                        DataBaseManager dbmanager = new DataBaseManager();
                        dbmanager.RegisterAcceptor(name, address, regDate, district, city, phoneText);
                    }
                    catch(ClassNotFoundException | SQLException ex)
                    {
                        JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                    }                                       
                }
        }
        }
        catch(ParseException ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_RegisterAcceptorButtonActionPerformed

    private void AcceptorClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcceptorClearButtonActionPerformed
        // Clearing the fields
        AcceptorNameTextField.setText(null);
        AcceptorAddressTextArea.setText(null);
        ((JTextField)AcceptorDateChooser.getDateEditor().getUiComponent()).setText(null);
        AcceptorPhoneTextField.setText(null);
    }//GEN-LAST:event_AcceptorClearButtonActionPerformed

    private void SearchAcceptorTextfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchAcceptorTextfieldKeyReleased
        // When search words are typed on the search textfield
        DataBaseManager manager = null; 
        ResultSet rs = null; 
        
        if( SearchAcceptorTextfield.getText().length() > 0 )
        {
            try 
            {
                manager = new DataBaseManager();
                rs = manager.RetrieveDonorOrAcceptorDetails(SearchAcceptorTextfield.getText(), "ACCEPTOR");
                if ( null == rs )
                {
                    
                }
                else
                {
                   ViewAcceptorsTable.setModel(DbUtils.resultSetToTableModel(rs));
                }
                
                // deallocation
                manager.closeConection();
                manager    = null;
                rs         = null;
                
            } 
            catch (ClassNotFoundException | SQLException ex) 
            {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_SearchAcceptorTextfieldKeyReleased

    private void DeleteAcceptorRecordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteAcceptorRecordButtonActionPerformed
        // deleting an acceptor record
        DataBaseManager manager = null;
        ResultSet rs = null;
        int confirm = 0, deleteStatus = 0;
        if(ViewAcceptorsTable.getSelectedRow() >= 0)
        {
            // Showing a confirmation dialog
            confirm = JOptionPane.showConfirmDialog(rootPane, "Are you sure, that you want to delete record for "
                                                    +String.valueOf(ViewAcceptorsTable.getValueAt(ViewAcceptorsTable.getSelectedRow(), 1))+" ?");
            
            if (0 == confirm)
            {
                try
                {
                    manager = new DataBaseManager();
                    deleteStatus = manager.DeleteDonorOrAcceptorRecord(String.valueOf(ViewAcceptorsTable.getValueAt(ViewAcceptorsTable.getSelectedRow(), 0)), "ACCEPTOR");
                    if( 1 == deleteStatus)
                    {
                        JOptionPane.showMessageDialog(null, "Record has been deleted...");
                        rs = manager.RetrieveAcceptorDetails();
                        if ( null == rs )
                        {
                    
                        }
                        else
                        {
                            ViewAcceptorsTable.setModel(DbUtils.resultSetToTableModel(rs));
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Record could not be deleted...");
                    }   
                }
                catch (ClassNotFoundException | SQLException ex)
                {
                    Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, " Please select a row to continue...");
        }
    }//GEN-LAST:event_DeleteAcceptorRecordButtonActionPerformed

    private void DeleteDonorSearchTextfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DeleteDonorSearchTextfieldKeyReleased
        // When search words are typed on the search textfield
        DataBaseManager manager = null; 
        ResultSet rs = null; 
        
        if(DeleteDonorSearchTextfield.getText().length() > 0 )
        {
            try 
            {
                manager = new DataBaseManager();
                rs = manager.RetrieveDonorOrAcceptorDetails(DeleteDonorSearchTextfield.getText(), "DONOR");
                if ( null == rs )
                {
                    
                }
                else
                {
                   DeleteDonorTable.setModel(DbUtils.resultSetToTableModel(rs));
                }
                
                // deallocation
                manager.closeConection();
                manager    = null;
                rs         = null;
                
            } 
            catch (ClassNotFoundException | SQLException ex) 
            {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_DeleteDonorSearchTextfieldKeyReleased

    private void DeleteDonorDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteDonorDeleteButtonActionPerformed
        // deleting a donor record
        DataBaseManager manager = null;
        ResultSet rs = null;
        int confirm = 0, deleteStatus = 0;
        if(DeleteDonorTable.getSelectedRow() >= 0)
        {
            // Showing a confirmation dialog
            confirm = JOptionPane.showConfirmDialog(rootPane, "Are you sure, that you want to delete record for "
                                                    +String.valueOf(DeleteDonorTable.getValueAt(DeleteDonorTable.getSelectedRow(), 1))+" ?");
            
            if (0 == confirm)
            {
                try
                {
                    manager = new DataBaseManager();
                    deleteStatus = manager.DeleteDonorOrAcceptorRecord(String.valueOf(DeleteDonorTable.getValueAt(DeleteDonorTable.getSelectedRow(), 0)), "DONOR");
                    if( 1 == deleteStatus)
                    {
                        JOptionPane.showMessageDialog(null, "Record has been deleted...");
                        rs = manager.RetrieveDonorDetails();
                        if ( null == rs )
                        {
                    
                        }
                        else
                        {
                            DeleteDonorTable.setModel(DbUtils.resultSetToTableModel(rs));
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Record could not be deleted...");
                    }   
                }
                catch (ClassNotFoundException | SQLException ex)
                {
                    Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_DeleteDonorDeleteButtonActionPerformed

    private void AcceptoSearchTextfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AcceptoSearchTextfieldKeyReleased
        // When searched for the acceptor
        DataBaseManager manager = null;
        ResultSet rs = null; 
        
        if( AcceptoSearchTextfield.getText().length() > 0 )
        {
            try {
                manager = new DataBaseManager();
                rs = manager.RetrieveDonorOrAcceptorDetails(AcceptoSearchTextfield.getText(), "ACCEPTOR");
                if ( null == rs )
                {

                }
                else
                {
                    AcceptorSearchTable.setModel( DbUtils.resultSetToTableModel(rs));
                }

                // deallocation
                manager.closeConection();
                manager    = null;
                rs         = null;

            } 
            catch (ClassNotFoundException | SQLException ex)
            {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }//GEN-LAST:event_AcceptoSearchTextfieldKeyReleased

    private void AcceptSearchOKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcceptSearchOKButtonActionPerformed
        // On clicking the Ok button after searching the acceptor
        if( AcceptorSearchTable.getSelectedRow() >= 0)
        {
            // Set Acceptor id of blood urgent panel
            BloodUrgentAcceptorIDTextfield.setText( String.valueOf(AcceptorSearchTable.getValueAt( AcceptorSearchTable.getSelectedRow() ,0)) );
            
            // dispose the search dialog
            AcceptorSearchDialog.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select a row to continue...");
        }

    }//GEN-LAST:event_AcceptSearchOKButtonActionPerformed

    private void AcceptorSearchCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcceptorSearchCloseButtonActionPerformed
        // Disposing acceptor search dialog
        AcceptorSearchDialog.dispose();
    }//GEN-LAST:event_AcceptorSearchCloseButtonActionPerformed

    private void BloodUrgentAcceptorIDTextfieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BloodUrgentAcceptorIDTextfieldMouseClicked
        // Setting the Acceptor search dialog visibility to true
        AcceptorSearchDialog.setSize(800, 500);
        AcceptorSearchDialog.setLocationRelativeTo(this);
        AcceptorSearchDialog.setVisible(true);
        PopulateAcceptorDetails(AcceptorSearchTable);
    }//GEN-LAST:event_BloodUrgentAcceptorIDTextfieldMouseClicked

    private void BloodUrgentCityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BloodUrgentCityButtonActionPerformed
        // Details of the donors  in the given city and selected blood group
        String city = (String)BloodUrgentCityCombobox.getSelectedItem();   
        String blood = (String)BloodUrgentBloodCombobox.getSelectedItem();
        String date =((JTextField)BloodUrgentDueDateChooser.getDateEditor().getUiComponent()).getText();
        String acceptorID = BloodUrgentAcceptorIDTextfield.getText();
        ResultSet rs = null;         
        if (city.isEmpty() || blood.isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "Required fields not selected...");
        }
        else if(acceptorID.isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "Select an acceptor to continue..");            
        }
        else if(date.isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "Due date should be specified...");            
        }
        else
        {
            try
            {
                DataBaseManager dbmanager = new DataBaseManager();
                rs = dbmanager.RetrieveDonorDetailsWRTBlood("CITY", city, blood);
                if (rs == null)
                {
                    JOptionPane.showMessageDialog(rootPane,"No donor exists in "+city+" with "+blood+" blood...");                  
                }
                else
                {                    
                    AvailableDonorsTable.setModel( DbUtils.resultSetToTableModel(rs));
                }
                
                // deallocation
                dbmanager.closeConection();
                dbmanager = null;
                rs = null;
            }
            catch(SQLException | ClassNotFoundException ex)
            {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }   
        }
    }//GEN-LAST:event_BloodUrgentCityButtonActionPerformed

    private void BloodUrgentDistrictButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BloodUrgentDistrictButtonActionPerformed
        // Details of the donors  in the given District and selected blood group
        String district = (String)BloodUrgentDistrictCombobox.getSelectedItem();   
        String blood = (String)BloodUrgentBloodCombobox.getSelectedItem();
        String date =((JTextField)BloodUrgentDueDateChooser.getDateEditor().getUiComponent()).getText();
        String acceptorID = BloodUrgentAcceptorIDTextfield.getText();
        ResultSet rs = null;         
        if (district.isEmpty() || blood.isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "Required fields not selected...");
        }
        else if(acceptorID.isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "Select an acceptor to continue..");            
        }
        else if(date.isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "Due date should be specified...");            
        }
        else
        {
            try
            {
                DataBaseManager dbmanager = new DataBaseManager();
                rs = dbmanager.RetrieveDonorDetailsWRTBlood("DISTRICT", district, blood);
                if (rs == null)
                {
                    JOptionPane.showMessageDialog(rootPane,"No donor exists in "+district+" with "+blood+" blood...");                  
                }
                else
                {                    
                    AvailableDonorsTable.setModel( DbUtils.resultSetToTableModel(rs));
                }
                
                // deallocation
                dbmanager.closeConection();
                dbmanager = null;
                rs = null;
            }
            catch(SQLException | ClassNotFoundException ex)
            {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }   
        }
    }//GEN-LAST:event_BloodUrgentDistrictButtonActionPerformed

    private void BloodUrgentViewAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BloodUrgentViewAllButtonActionPerformed
        // Details of the all the donors  with selected blood group 
        String blood = (String)BloodUrgentBloodCombobox.getSelectedItem();
        String date =((JTextField)BloodUrgentDueDateChooser.getDateEditor().getUiComponent()).getText();
        String acceptorID = BloodUrgentAcceptorIDTextfield.getText();
        ResultSet rs = null;  
        
        if (blood.isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "Required fields not selected...");
        }        
        else if(acceptorID.isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "Select an acceptor to continue..");            
        }
        else if(date.isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "Due date should be specified...");            
        }
        else
        {
            try
            {
                DataBaseManager dbmanager = new DataBaseManager();
                rs = dbmanager.RetrieveDonorDetailsWRTBlood("ALL", null, blood);
                if (rs == null)
                {
                    JOptionPane.showMessageDialog(rootPane,"No donor exists with "+blood+" blood...");                  
                }
                else
                {                    
                    AvailableDonorsTable.setModel( DbUtils.resultSetToTableModel(rs));
                }
                
                // deallocation
                dbmanager.closeConection();
                dbmanager = null;
                rs = null;
            }
            catch(SQLException | ClassNotFoundException ex)
            {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }   
        }
    }//GEN-LAST:event_BloodUrgentViewAllButtonActionPerformed

    private void BloodUrgentPassInformationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BloodUrgentPassInformationButtonActionPerformed
        // On clicking the pass information button
        DataBaseManager dbmanager = null;        
        DefaultTableModel dm = (DefaultTableModel)AvailableDonorsTable.getModel();
        int allConfirm = 0;
        String donorID = null;
        String acceptorID = BloodUrgentAcceptorIDTextfield.getText();        
        int rowCount = dm.getRowCount();
        boolean check = false;
        int status = 0;
        
        // Date format adjustments
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date=((JTextField)BloodUrgentDueDateChooser.getDateEditor().getUiComponent()).getText();
        if (0 == rowCount)
        {
            JOptionPane.showMessageDialog(rootPane, "No donors available...");
        }
        else if( AvailableDonorsTable.getSelectedRow() >= 0)
        {            
            // gets the donorId from the Avaiable donors table and insert data into it.
            donorID = String.valueOf(AvailableDonorsTable.getValueAt(AvailableDonorsTable.getSelectedRow(), 0));   
            // Makes the request for blood to the donor
            try
            {
                dbmanager = new DataBaseManager();                        
                Date dueDate = formatter.parse(date);
                status = dbmanager.NewBloodRequest(acceptorID, donorID, dueDate);
                if (1 == status)
                {
                    JOptionPane.showMessageDialog(rootPane, "Request completed successfully...");
                }
                else
                {
                    JOptionPane.showMessageDialog(rootPane, "Request could not be processed...");
                }
            }
            catch(ClassNotFoundException| SQLException | ParseException ex)
            {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }         
        }
        else
        {
            allConfirm = JOptionPane.showConfirmDialog(null, "Proceeding further will pass the information to all available donors. \n Are you sure?");
            if (0 == allConfirm)
            {
                for (int i = 0; i< rowCount; i++)
                {
                    // gets the donorId from the Avaiable donors table and insert data into it.
                    donorID = String.valueOf(AvailableDonorsTable.getValueAt(i, 0));
                    
                    // Makes the request for blood to the donor
                    try
                    {
                        dbmanager = new DataBaseManager();                        
                        Date dueDate = formatter.parse(date);
                        status = dbmanager.NewBloodRequest(acceptorID, donorID, dueDate);
                        switch (status)
                        {
                            case 0: check = false;
                                    break;
                            case 1: check = true;
                        }
                    }
                    catch(ClassNotFoundException| SQLException | ParseException ex)
                    {
                        JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                    }
                }
                if (check)
                {
                    JOptionPane.showMessageDialog(rootPane, "Request completed successfully...");
                }
                else
                {
                    JOptionPane.showMessageDialog(rootPane, "Request could not be processed...");
                }
            }
        }
    }//GEN-LAST:event_BloodUrgentPassInformationButtonActionPerformed

    private void BloodUrgentClearfieldsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BloodUrgentClearfieldsButtonActionPerformed
       // clearing fields
       BloodUrgentAcceptorIDTextfield.setText(null);
       ((JTextField)BloodUrgentDueDateChooser.getDateEditor().getUiComponent()).setText(null);
       
       // Setting the row count to 0
       DefaultTableModel dm = (DefaultTableModel)AvailableDonorsTable.getModel();
       dm.setRowCount(0);
    }//GEN-LAST:event_BloodUrgentClearfieldsButtonActionPerformed

    private void FeedbackViewerCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeedbackViewerCloseButtonActionPerformed
        // hiding the form
        FeedbackViewerDialog.dispose();
    }//GEN-LAST:event_FeedbackViewerCloseButtonActionPerformed

    private void PendingFeedbacksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PendingFeedbacksButtonActionPerformed
        // On clicking the pending feedbacks button
        DataBaseManager dbmanager = null;
        ResultSet rs = null;
        DefaultTableModel dm = (DefaultTableModel)ViewAcceptorsTable.getModel();
        int rowCount = dm.getRowCount();
        if( 0 == rowCount)
        {
            JOptionPane.showMessageDialog(rootPane, "No acceptors available..."); 
        }
        else if( ViewAcceptorsTable.getSelectedRow() >= 0)
        {
            try
            {
                dbmanager = new DataBaseManager();                
                dbmanager.RetrieveFeedbacksForAcceptor(String.valueOf(ViewAcceptorsTable.getValueAt( ViewAcceptorsTable.getSelectedRow() ,0)),
                                                        "OPEN", FeedbackViewerTable);
                FeedbackViewerDialog.setSize(800, 500);
                FeedbackViewerDialog.setLocationRelativeTo(this);
                FeedbackViewerDialog.setVisible(true);
                /*
                if (rs == null)
                {
                    JOptionPane.showMessageDialog(rootPane, "No feedback for the acceptor...");                    
                }
                else
                {
                    FeedbackViewerDialog.setSize(800, 500);
                    FeedbackViewerDialog.setLocationRelativeTo(this);
                    FeedbackViewerDialog.setVisible(true);
                    FeedbackViewerTable.setModel( DbUtils.resultSetToTableModel(rs));
                }*/
            }
            catch (ClassNotFoundException | SQLException ex)
            {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select a row to continue...");
        }
    }//GEN-LAST:event_PendingFeedbacksButtonActionPerformed

    private void WillingFeedbacksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WillingFeedbacksButtonActionPerformed
        // On clicking the willing feedbacks button
        DataBaseManager dbmanager = null;
        ResultSet rs = null;
        DefaultTableModel dm = (DefaultTableModel)ViewAcceptorsTable.getModel();
        DefaultTableModel dmFeedback = (DefaultTableModel)FeedbackViewerTable.getModel();
        int rowCount = dm.getRowCount();
        if( 0 == rowCount)
        {
            JOptionPane.showMessageDialog(rootPane, "No acceptors available..."); 
        }
        else if( ViewAcceptorsTable.getSelectedRow() >= 0)
        {
            try
            {
                dbmanager = new DataBaseManager();
                FeedbackViewerDialog.setSize(800, 500);
                FeedbackViewerDialog.setLocationRelativeTo(this);
                FeedbackViewerDialog.setVisible(true);
                dbmanager.RetrieveFeedbacksForAcceptor(String.valueOf(ViewAcceptorsTable.getValueAt( ViewAcceptorsTable.getSelectedRow() ,0)),
                                                       "WILLING", FeedbackViewerTable);
                
                if(dmFeedback.getRowCount() > 0)
                {
                    PrintFeedbackPrintButton.setEnabled(true);
                }
                /*
                if (rs == null)
                {
                    JOptionPane.showMessageDialog(rootPane, "No feedback for the acceptor...");                    
                }
                else
                {
                    FeedbackViewerDialog.setSize(800, 500);
                    FeedbackViewerDialog.setLocationRelativeTo(this);
                    FeedbackViewerDialog.setVisible(true);
                    FeedbackViewerTable.setModel( DbUtils.resultSetToTableModel(rs));
                }*/
            }
            catch (ClassNotFoundException | SQLException ex)
            {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select a row to continue...");
        }
    }//GEN-LAST:event_WillingFeedbacksButtonActionPerformed

    private void NotWillingFeedbacksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotWillingFeedbacksButtonActionPerformed
        // On clicking the not willing feedbacks button
        DataBaseManager dbmanager = null;
        ResultSet rs = null;
        DefaultTableModel dm = (DefaultTableModel)ViewAcceptorsTable.getModel();
        int rowCount = dm.getRowCount();
        if( 0 == rowCount)
        {
            JOptionPane.showMessageDialog(rootPane, "No acceptors available..."); 
        }
        else if( ViewAcceptorsTable.getSelectedRow() >= 0)
        {
            try
            {
                dbmanager = new DataBaseManager();
                FeedbackViewerDialog.setSize(800, 500);
                FeedbackViewerDialog.setLocationRelativeTo(this);
                FeedbackViewerDialog.setVisible(true);                
                dbmanager.RetrieveFeedbacksForAcceptor(String.valueOf(ViewAcceptorsTable.getValueAt( ViewAcceptorsTable.getSelectedRow() ,0)),
                                                       "NOTWILLING", FeedbackViewerTable);
                /*
                if (rs == null)
                {
                    JOptionPane.showMessageDialog(rootPane, "No feedback for the acceptor...");                    
                }
                else
                {
                    FeedbackViewerDialog.setSize(800, 500);
                    FeedbackViewerDialog.setLocationRelativeTo(this);
                    FeedbackViewerDialog.setVisible(true);
                    FeedbackViewerTable.setModel( DbUtils.resultSetToTableModel(rs));
                }*/
            }
            catch (ClassNotFoundException | SQLException ex)
            {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select a row to continue...");
        }
    }//GEN-LAST:event_NotWillingFeedbacksButtonActionPerformed

    private void PrintFeedbackPrintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintFeedbackPrintButtonActionPerformed
        // Prints the feedback details
        try
        {
                     
            MessageFormat header = new MessageFormat("REPORT");
            FeedbackViewerTable.print(JTable.PrintMode.FIT_WIDTH,header,null);
        }
        catch(PrinterException ex)
        {   
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_PrintFeedbackPrintButtonActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AcceptSearchOKButton;
    private javax.swing.JTextField AcceptoSearchTextfield;
    private javax.swing.JTextArea AcceptorAddressTextArea;
    private javax.swing.JComboBox<String> AcceptorCityCombobox;
    private javax.swing.JButton AcceptorClearButton;
    private com.toedter.calendar.JDateChooser AcceptorDateChooser;
    private javax.swing.JComboBox<String> AcceptorDistrictCombobox;
    private javax.swing.JTextField AcceptorNameTextField;
    private javax.swing.JTextField AcceptorPhoneTextField;
    private javax.swing.JPanel AcceptorSearchBasePanel;
    private javax.swing.JButton AcceptorSearchCloseButton;
    private javax.swing.JDialog AcceptorSearchDialog;
    private javax.swing.JLabel AcceptorSearchLabel;
    private javax.swing.JScrollPane AcceptorSearchScrollPane;
    private javax.swing.JTable AcceptorSearchTable;
    private javax.swing.JPanel AcceptorSidePanel;
    private javax.swing.JPanel AddAcceptorPanel;
    private javax.swing.JButton AddAcceptorSidepanelButton;
    private javax.swing.JPanel AddAcceptorSubPanel;
    private javax.swing.JLabel AddressLabel;
    private javax.swing.JLabel AddressLabel2;
    private javax.swing.JTextArea AddressTextArea;
    private javax.swing.JScrollPane AdressScrollPane;
    private javax.swing.JScrollPane AdressScrollPane2;
    private javax.swing.JLabel AgeLabel;
    private javax.swing.JTextField AgeTextfield;
    private javax.swing.JTable AvailableDonorsTable;
    private javax.swing.JPanel AvailableDonorsTableHolderPanel;
    private javax.swing.JScrollPane AvailableDonorsTableScrollPane;
    private javax.swing.JPanel BasePanel;
    private javax.swing.JComboBox<String> BloodGroupCombobox;
    private javax.swing.JLabel BloodGroupLabel;
    private javax.swing.JTextField BloodUrgentAcceptorIDTextfield;
    private javax.swing.JComboBox<String> BloodUrgentBloodCombobox;
    private javax.swing.JButton BloodUrgentButton;
    private javax.swing.JButton BloodUrgentCityButton;
    private javax.swing.JComboBox<String> BloodUrgentCityCombobox;
    private javax.swing.JButton BloodUrgentClearfieldsButton;
    private javax.swing.JButton BloodUrgentDistrictButton;
    private javax.swing.JComboBox<String> BloodUrgentDistrictCombobox;
    private com.toedter.calendar.JDateChooser BloodUrgentDueDateChooser;
    private javax.swing.JPanel BloodUrgentPanel;
    private javax.swing.JButton BloodUrgentPassInformationButton;
    private javax.swing.JPanel BloodUrgentSubpanel;
    private javax.swing.JButton BloodUrgentViewAllButton;
    private javax.swing.JPanel ButtonHolderPanel;
    private javax.swing.JComboBox<String> CityCombobox;
    private javax.swing.JLabel CityLabel;
    private javax.swing.JLabel CityLabel2;
    private javax.swing.JLabel DateLabel;
    private javax.swing.JLabel DateLabel2;
    private javax.swing.JButton DeleteAcceptorRecordButton;
    private javax.swing.JButton DeleteDonorDeleteButton;
    private javax.swing.JPanel DeleteDonorPanel;
    private javax.swing.JScrollPane DeleteDonorScrollpane;
    private javax.swing.JTextField DeleteDonorSearchTextfield;
    private javax.swing.JButton DeleteDonorSidePanelButton;
    private javax.swing.JPanel DeleteDonorSubpanel;
    private javax.swing.JTable DeleteDonorTable;
    private javax.swing.JComboBox<String> DistrictCombobox;
    private javax.swing.JLabel DistrictLabel;
    private javax.swing.JLabel DistrictLabel2;
    private javax.swing.JTextField DonorNameTextField;
    private javax.swing.JPanel DonorSidePanel;
    private javax.swing.JPanel FeedbackViewerBasePanel;
    private javax.swing.JButton FeedbackViewerCloseButton;
    private javax.swing.JDialog FeedbackViewerDialog;
    private javax.swing.JScrollPane FeedbackViewerScrollPane;
    private javax.swing.JTable FeedbackViewerTable;
    private javax.swing.JPanel FooterPanel;
    private javax.swing.JPanel GeneralSidePanel;
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JButton HomeButton;
    private javax.swing.JLabel HomeImageLabel;
    private javax.swing.JPanel HomePanel;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JPanel LogoutPanel;
    private javax.swing.JPanel MiddlePanel;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JLabel NameLabel2;
    private javax.swing.JButton NotWillingFeedbacksButton;
    private javax.swing.JButton PendingFeedbacksButton;
    private javax.swing.JLabel PhoneLabel;
    private javax.swing.JLabel PhoneLabel2;
    private javax.swing.JTextField PhoneTextField;
    private javax.swing.JButton PrintFeedbackPrintButton;
    private com.toedter.calendar.JDateChooser RegDateChooser;
    private javax.swing.JButton RegisterAcceptorButton;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JButton RegisterClearButton;
    private javax.swing.JButton RegisterDonorButton;
    private javax.swing.JPanel RegisterDonorPanel;
    private javax.swing.JPanel RegisterDonorSubpanel;
    private javax.swing.JTextField SearchAcceptorTextfield;
    private javax.swing.JLabel SearchDonorLabel;
    private javax.swing.JPanel ViewAcceptorPanelButtonHolderPanel;
    private javax.swing.JPanel ViewAcceptorsPanel;
    private javax.swing.JScrollPane ViewAcceptorsScrollpane;
    private javax.swing.JButton ViewAcceptorsSidePanelButton;
    private javax.swing.JPanel ViewAcceptorsSubPanel;
    private javax.swing.JTable ViewAcceptorsTable;
    private javax.swing.JButton ViewDonorsBloodButton;
    private javax.swing.JComboBox<String> ViewDonorsBloodgroupCombobox;
    private javax.swing.JButton ViewDonorsButton;
    private javax.swing.JButton ViewDonorsCityButton;
    private javax.swing.JComboBox<String> ViewDonorsCityCombobox;
    private javax.swing.JButton ViewDonorsDistrictButton;
    private javax.swing.JComboBox<String> ViewDonorsDistrictCombobox;
    private javax.swing.JPanel ViewDonorsPanel;
    private javax.swing.JScrollPane ViewDonorsScrollpane;
    private javax.swing.JPanel ViewDonorsSubPanel;
    private javax.swing.JTable ViewDonorsTable;
    private javax.swing.JButton ViewDonorsViewAllButton;
    private javax.swing.JButton WillingFeedbacksButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
