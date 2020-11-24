/*
 * Created by JFormDesigner on Thu Nov 12 03:30:04 SGT 2020
 */

package courier.manager;

import courier.*;
import org.apache.commons.lang3.ArrayUtils;

import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class ManagerHome extends courier.GUI{
    public ManagerHome() {
        super();
        initComponents();
        lblActID.setText("O"+ Order.getOrderCount());

    }

    public static JFrame getJfManager() {
        return jfManager;
    }

    public static JLabel getLblManagerName() {
        return lblManagerName;
    }


    private void txtICKeyPressed(KeyEvent e) {
        super.numCheck(e,"IC",txtIC);
    }

    private void txtICKeyTyped(KeyEvent e) {
        super.lengthChecker(e,"IC",txtIC,11);
    }

    private void txtCityKeyTyped(KeyEvent e) {
        lengthChecker(e,"City",txtCity,29);
    }

    private void txtCityKeyPressed(KeyEvent e) {
        super.spCharCheck(e,txtCity);
    }

    private void txtPostKeyPressed(KeyEvent e) {
        super.numCheck(e,"Postcode",txtPost);
    }

    private void txtPostKeyTyped(KeyEvent e) {
        lengthChecker(e,"Postcode",txtPost,4);
    }

    private void txtStreetKeyPressed(KeyEvent e) {
        spCharCheck(e,txtStreet);
    }

    private void btnOrderProceed1ActionPerformed(ActionEvent e) {
        int confirm=JOptionPane.showConfirmDialog(null,"Are you sure all inputs are correct?","Confirmation",0);
        if (confirm==0){
            if(txtIC.getText().length()!=12||txtStreet.getText().length()==0||txtCity.getText().length()==0||txtPost.getText().length()!=5){
                JOptionPane.showMessageDialog(null,"Please revise all inputs. All fields are required, postcode must be 5 and IC must be 12 digits.","Invalid Input",2);
                txtIC.setText("");
                txtPost.setText("");
                txtCity.setText("");
                txtStreet.setText("");
            }else{
                for(int i=0;i<Customer.getCustomerAL().size();i++){
                    if(Customer.getCustomerAL().get(i).getIc().equals(txtIC.getText())){
                        //todo add a new package here
                        //todo create new package and order
                        String id=Order.generateID();
                        GregorianCalendar g= new GregorianCalendar();
                        orderPackage op= new orderPackage(orderPackage.generateID(),id,Double.parseDouble(txtPkgWeight.getText()),cmbPkgSize.getSelectedItem().toString().toLowerCase());
                        orderPackage.getOrderPackagesAl().add(op);
                        op.writeLine();

                        Order o = new Order(id,Customer.getCustomerAL().get(i).getId(),g,null,Order.expectedDateCal(g,cmbState.getSelectedItem().toString()),
                                Order.priceCal(cmbState.getSelectedItem().toString(),op.getPackageSize(),op.getPackageWeight()),
                                op,txtStreet.getText(),txtCity.getText(),cmbState.getSelectedItem().toString(),Integer.parseInt(txtPost.getText()),"Order Placed");
                        Order.getOrderAl().add(o);
                        o.writeLine();
                        JOptionPane.showMessageDialog(null,"Successfully Generated an Order. The price is RM"+o.getOrderPrice()+" and the expected delivery date is "+
                                        o.getExpectedDelivery().get(GregorianCalendar.DATE)+"-"+(o.getExpectedDelivery().get(GregorianCalendar.MONTH)+1)+"-"+o.getExpectedDelivery().get(GregorianCalendar.YEAR)+".","Successfully Added order",1);
                        clearPage();
                        pass=true;
                        break;
                    }
                }
                if(pass==false){
                    //todo proceed to the new customer page
                    int confirmation= JOptionPane.showConfirmDialog(null,"It seems like this customer does not exist withint the database. Would you like to register this customer?","New Customer",0);
                    if (confirmation==0){
                        Main.CustomerRegister.getJfCustomerRegister().setVisible(true);
                        Main.CustomerRegister.getTxtRegCusIC().setText(txtIC.getText());
                    }
                }
            }
        }
    }

    private static void clearPage(){
        txtPkgWeight.setText("");
        txtCity.setText("");
        txtIC.setText("");
        txtPost.setText("");;
        txtStreet.setText("");
        cmbPkgSize.setSelectedIndex(0);
        cmbState.setSelectedIndex(0);
    }



    private void txtRegCPhoneKeyTyped(KeyEvent e) {
        lengthChecker(e,"Postcode",txtPost,11);
    }

    public JComboBox<String> getCmbState() {
        return cmbState;
    }

    public JButton getBtnOrderProceed1() {
        return btnOrderProceed1;
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        jfManager = new JFrame();
        sPnlManager = new JPanel();
        lblMHomeTitle = new JLabel();
        lblManagerName = new JLabel();
        btnOverview = new JButton();
        btnOrder = new JButton();
        btnRider = new JButton();
        btnReport = new JButton();
        btnFeedback = new JButton();
        btnLogout = new JButton();
        panel1 = new JPanel();
        lblID = new JLabel();
        lblType = new JLabel();
        lblIC = new JLabel();
        lblActID = new JLabel();
        cmbType = new JComboBox<>();
        txtIC = new JTextField();
        lblIC2 = new JLabel();
        lblIC3 = new JLabel();
        lblIC4 = new JLabel();
        lblIC5 = new JLabel();
        scrollPane1 = new JScrollPane();
        txtStreet = new JTextArea();
        txtCity = new JTextField();
        cmbState = new JComboBox<>();
        txtPost = new JTextField();
        btnOrderProceed1 = new JButton();
        pnlTitle = new JPanel();
        lblTitle = new JLabel();

        //======== jfManager ========
        {
            jfManager.setBackground(new Color(204, 204, 204));
            jfManager.setTitle("Manager Portal");
            jfManager.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jfManager.setResizable(false);
            jfManager.setVisible(true);
            var jfManagerContentPane = jfManager.getContentPane();
            jfManagerContentPane.setLayout(null);

            //======== sPnlManager ========
            {
                sPnlManager.setBackground(new Color(21, 29, 65));
                sPnlManager.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
                . border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder
                . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .
                awt .Font .BOLD ,12 ), java. awt. Color. red) ,sPnlManager. getBorder( )) )
                ; sPnlManager. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
                ) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
                ;
                sPnlManager.setLayout(null);

                //---- lblMHomeTitle ----
                lblMHomeTitle.setText("Manager Portal");
                lblMHomeTitle.setFont(new Font("Myanmar Text", Font.BOLD, 27));
                lblMHomeTitle.setForeground(Color.white);
                sPnlManager.add(lblMHomeTitle);
                lblMHomeTitle.setBounds(20, 15, 210, 50);

                //---- lblManagerName ----
                lblManagerName.setText("Loges");
                lblManagerName.setFont(new Font("Myanmar Text", Font.BOLD, 26));
                lblManagerName.setForeground(Color.white);
                lblManagerName.setHorizontalAlignment(SwingConstants.CENTER);
                sPnlManager.add(lblManagerName);
                lblManagerName.setBounds(25, 75, 200, 60);

                //---- btnOverview ----
                btnOverview.setText("Overview");
                btnOverview.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                sPnlManager.add(btnOverview);
                btnOverview.setBounds(45, 160, 145, 45);

                //---- btnOrder ----
                btnOrder.setText("Order");
                btnOrder.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                sPnlManager.add(btnOrder);
                btnOrder.setBounds(45, 235, 145, 45);

                //---- btnRider ----
                btnRider.setText("Rider");
                btnRider.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                sPnlManager.add(btnRider);
                btnRider.setBounds(45, 300, 145, 45);

                //---- btnReport ----
                btnReport.setText("Report");
                btnReport.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                sPnlManager.add(btnReport);
                btnReport.setBounds(45, 370, 145, 45);

                //---- btnFeedback ----
                btnFeedback.setText("Feedback");
                btnFeedback.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                sPnlManager.add(btnFeedback);
                btnFeedback.setBounds(45, 435, 145, 45);

                //---- btnLogout ----
                btnLogout.setText("Logout");
                btnLogout.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                sPnlManager.add(btnLogout);
                btnLogout.setBounds(45, 500, 145, 45);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < sPnlManager.getComponentCount(); i++) {
                        Rectangle bounds = sPnlManager.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = sPnlManager.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    sPnlManager.setMinimumSize(preferredSize);
                    sPnlManager.setPreferredSize(preferredSize);
                }
            }
            jfManagerContentPane.add(sPnlManager);
            sPnlManager.setBounds(0, 0, 255, 760);

            //======== panel1 ========
            {
                panel1.setBackground(Color.white);
                panel1.setLayout(null);

                //---- lblID ----
                lblID.setText("Order ID");
                lblID.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblID.setForeground(Color.black);
                panel1.add(lblID);
                lblID.setBounds(new Rectangle(new Point(20, 115), lblID.getPreferredSize()));

                //---- lblType ----
                lblType.setText("Order Type");
                lblType.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblType.setForeground(Color.black);
                panel1.add(lblType);
                lblType.setBounds(20, 215, 135, 32);

                //---- lblIC ----
                lblIC.setText("Customer IC");
                lblIC.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblIC.setForeground(Color.black);
                panel1.add(lblIC);
                lblIC.setBounds(20, 275, 180, 45);

                //---- lblActID ----
                lblActID.setText("Order ID");
                lblActID.setFont(new Font("Nirmala UI", Font.BOLD, 20));
                lblActID.setForeground(new Color(208, 32, 69));
                lblActID.setBorder(new LineBorder(Color.black, 2, true));
                lblActID.setHorizontalAlignment(SwingConstants.CENTER);
                panel1.add(lblActID);
                lblActID.setBounds(180, 115, 95, 35);

                //---- cmbType ----
                cmbType.setFont(cmbType.getFont().deriveFont(cmbType.getFont().getSize() + 9f));
                cmbType.setBackground(Color.white);
                cmbType.setMaximumRowCount(2);
                cmbType.setModel(new DefaultComboBoxModel<>(new String[] {
                    "Non Pickup",
                    "Pickup"
                }));
                cmbType.setForeground(new Color(86, 83, 83));
                panel1.add(cmbType);
                cmbType.setBounds(255, 215, 210, 40);

                //---- txtIC ----
                txtIC.setBackground(Color.white);
                txtIC.setCaretColor(Color.black);
                txtIC.setForeground(Color.black);
                txtIC.setFont(txtIC.getFont().deriveFont(txtIC.getFont().getSize() + 8f));
                txtIC.setDisabledTextColor(Color.black);
                txtIC.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        txtICKeyPressed(e);
                    }
                    @Override
                    public void keyTyped(KeyEvent e) {
                        txtICKeyTyped(e);
                    }
                });
                panel1.add(txtIC);
                txtIC.setBounds(255, 280, 255, 40);

                //---- lblIC2 ----
                lblIC2.setText("Street");
                lblIC2.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblIC2.setForeground(Color.black);
                panel1.add(lblIC2);
                lblIC2.setBounds(20, 350, 180, 45);

                //---- lblIC3 ----
                lblIC3.setText("City");
                lblIC3.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblIC3.setForeground(Color.black);
                panel1.add(lblIC3);
                lblIC3.setBounds(25, 470, 180, 45);

                //---- lblIC4 ----
                lblIC4.setText("State");
                lblIC4.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblIC4.setForeground(Color.black);
                panel1.add(lblIC4);
                lblIC4.setBounds(25, 550, 180, 45);

                //---- lblIC5 ----
                lblIC5.setText("Postcode");
                lblIC5.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblIC5.setForeground(Color.black);
                panel1.add(lblIC5);
                lblIC5.setBounds(25, 625, 180, 45);

                //======== scrollPane1 ========
                {

                    //---- txtStreet ----
                    txtStreet.setRows(1);
                    txtStreet.setBackground(Color.white);
                    txtStreet.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
                    txtStreet.setForeground(Color.black);
                    txtStreet.setLineWrap(true);
                    txtStreet.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            txtStreetKeyPressed(e);
                        }
                    });
                    scrollPane1.setViewportView(txtStreet);
                }
                panel1.add(scrollPane1);
                scrollPane1.setBounds(255, 350, 505, 70);

                //---- txtCity ----
                txtCity.setBackground(Color.white);
                txtCity.setCaretColor(Color.black);
                txtCity.setForeground(Color.black);
                txtCity.setFont(txtCity.getFont().deriveFont(txtCity.getFont().getSize() + 8f));
                txtCity.setDisabledTextColor(Color.black);
                txtCity.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        txtCityKeyPressed(e);
                    }
                    @Override
                    public void keyTyped(KeyEvent e) {
                        txtCityKeyTyped(e);
                    }
                });
                panel1.add(txtCity);
                txtCity.setBounds(255, 470, 405, 40);

                //---- cmbState ----
                cmbState.setFont(cmbState.getFont().deriveFont(cmbState.getFont().getSize() + 9f));
                cmbState.setBackground(Color.white);
                cmbState.setMaximumRowCount(6);
                cmbState.setModel(new DefaultComboBoxModel<>(new String[] {
                    "KUL",
                    "SGR",
                    "PNG",
                    "JHR",
                    "NSN",
                    "MLK",
                    "KDH",
                    "KTN",
                    "PHG",
                    "PRK",
                    "PLS",
                    "TRG",
                    "PJY"
                }));
                cmbState.setForeground(new Color(86, 83, 83));
                panel1.add(cmbState);
                cmbState.setBounds(255, 545, 210, 40);

                //---- txtPost ----
                txtPost.setBackground(Color.white);
                txtPost.setCaretColor(Color.black);
                txtPost.setForeground(Color.black);
                txtPost.setFont(txtPost.getFont().deriveFont(txtPost.getFont().getSize() + 8f));
                txtPost.setDisabledTextColor(Color.black);
                txtPost.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        txtPostKeyPressed(e);
                    }
                    @Override
                    public void keyTyped(KeyEvent e) {
                        txtPostKeyTyped(e);
                    }
                });
                panel1.add(txtPost);
                txtPost.setBounds(260, 625, 175, 40);

                //---- btnOrderProceed1 ----
                btnOrderProceed1.setText("Proceed");
                btnOrderProceed1.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
                btnOrderProceed1.setBackground(Color.black);
                btnOrderProceed1.setForeground(Color.white);
                btnOrderProceed1.addActionListener(e -> {
                    try {
                        btnOrderProceed1ActionPerformed(e);
                    } catch (InvalidValueException invalidValueException) {
                        invalidValueException.printStackTrace();
                    }
                });
                panel1.add(btnOrderProceed1);
                btnOrderProceed1.setBounds(605, 665, 170, 65);

                //======== pnlTitle ========
                {
                    pnlTitle.setBackground(new Color(186, 201, 245));
                    pnlTitle.setLayout(null);

                    //---- lblTitle ----
                    lblTitle.setText("Order Form");
                    lblTitle.setFont(new Font("Myanmar Text", Font.BOLD, 46));
                    lblTitle.setForeground(Color.black);
                    lblTitle.setAlignmentY(0.0F);
                    lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
                    lblTitle.setIconTextGap(3);
                    lblTitle.setBackground(new Color(51, 204, 255));
                    pnlTitle.add(lblTitle);
                    lblTitle.setBounds(20, 20, 270, 65);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < pnlTitle.getComponentCount(); i++) {
                            Rectangle bounds = pnlTitle.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = pnlTitle.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        pnlTitle.setMinimumSize(preferredSize);
                        pnlTitle.setPreferredSize(preferredSize);
                    }
                }
                panel1.add(pnlTitle);
                pnlTitle.setBounds(0, 0, 850, 80);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel1.getComponentCount(); i++) {
                        Rectangle bounds = panel1.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel1.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel1.setMinimumSize(preferredSize);
                    panel1.setPreferredSize(preferredSize);
                }
            }
            jfManagerContentPane.add(panel1);
            panel1.setBounds(255, 0, panel1.getPreferredSize().width, 760);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < jfManagerContentPane.getComponentCount(); i++) {
                    Rectangle bounds = jfManagerContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = jfManagerContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                jfManagerContentPane.setMinimumSize(preferredSize);
                jfManagerContentPane.setPreferredSize(preferredSize);
            }
            jfManager.pack();
            jfManager.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private static JFrame jfManager;
    private static JPanel sPnlManager;
    private static JLabel lblMHomeTitle;
    private static JLabel lblManagerName;
    private static JButton btnOverview;
    private static JButton btnOrder;
    private static JButton btnRider;
    private static JButton btnReport;
    private static JButton btnFeedback;
    private static JButton btnLogout;
    private JPanel panel1;
    private JLabel lblID;
    private JLabel lblType;
    private JLabel lblIC;
    private JLabel lblActID;
    private static JComboBox<String> cmbType;
    private JTextField txtIC;
    private JLabel lblIC2;
    private JLabel lblIC3;
    private JLabel lblIC4;
    private JLabel lblIC5;
    private JScrollPane scrollPane1;
    private static JTextArea txtStreet;
    private static JTextField txtCity;
    private static JComboBox<String> cmbState;
    private static JTextField txtPost;
    private static JButton btnOrderProceed1;
    private JPanel pnlTitle;
    protected static JLabel lblTitle;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    
}
