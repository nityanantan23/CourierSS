/*
 * Created by JFormDesigner on Fri Nov 27 15:24:01 SGT 2020
 */

package courier;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.time.*;

/**
 * @author unknown
 */
public class OrderOverview extends JFrame {
    private static String[] tblCol= {"Order ID","Street","City","Postcode","State","ExpectedDeliveryDate","Order Status"};
    int[] columnsWidth = {60, 220, 90 , 80, 70, 120, 150};
    private static DefaultTableModel tblLateM= new DefaultTableModel(tblCol,0){
        public boolean isCellEditable(int row, int column)
        {
            return false;//This causes all cells to be not editable
        }
    };
    private static DefaultTableModel tblNonLateM= new DefaultTableModel(tblCol,0){
        public boolean isCellEditable(int row, int column)
        {
            return false;//This causes all cells to be not editable
        }
    };


    public OrderOverview() {
        loadTable();
        tblLateOrder = new JTable(tblLateM);
        tblLateOrder.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        int i = 0;
        for (int width : columnsWidth) {
            TableColumn column = tblLateOrder.getColumnModel().getColumn(i++);
            column.setMinWidth(width);
            column.setMaxWidth(width);
            column.setPreferredWidth(width);
        }
        tblNonLate= new JTable(tblNonLateM);
        tblNonLate.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        int i2 = 0;
        for (int width : columnsWidth) {
            TableColumn column = tblNonLate.getColumnModel().getColumn(i2++);
            column.setMinWidth(width);
            column.setMaxWidth(width);
            column.setPreferredWidth(width);
        }
        initComponents();
    }

    private void loadTable(){
         tblLateM.setRowCount(0);
         tblNonLateM.setRowCount(0);
         LocalDate currentTime= LocalDate.now();
        for (int i=0;i<Order.getOrderAl().size() ;i++){
            if (!Order.getOrderAl().get(i).getDeliveryStatus().equals("Delivered")&&!Order.getOrderAl().get(i).getDeliveryStatus().equals("Cancelled")){
                if (Order.getOrderAl().get(i).getExpectedDelivery().compareTo(currentTime)<=0){
                    String orderID= Order.getOrderAl().get(i).getOrderID();
                    String street= Order.getOrderAl().get(i).getStreet();
                    String city= Order.getOrderAl().get(i).getCity();
                    Integer postcode=Order.getOrderAl().get(i).getPostcode();
                    String state=Order.getOrderAl().get(i).getState();
                    String expDate= Order.getOrderAl().get(i).getExpectedDelivery().getDayOfMonth()+"-"+
                            (Order.getOrderAl().get(i).getExpectedDelivery().getMonthValue())+"-"+Order.getOrderAl().get(i).getExpectedDelivery().getYear();
                    String orderStatus=Order.getOrderAl().get(i).getDeliveryStatus();
                    Object[] data= {orderID,street,state,city,postcode,expDate,orderStatus};
                    tblLateM.addRow(data);
                }else {
                    String orderID= Order.getOrderAl().get(i).getOrderID();
                    String street= Order.getOrderAl().get(i).getStreet();
                    String city= Order.getOrderAl().get(i).getCity();
                    Integer postcode=Order.getOrderAl().get(i).getPostcode();
                    String state=Order.getOrderAl().get(i).getState();
                    String expDate= Order.getOrderAl().get(i).getExpectedDelivery().getDayOfMonth()+"-"+
                            (Order.getOrderAl().get(i).getExpectedDelivery().getMonthValue())+"-"+Order.getOrderAl().get(i).getExpectedDelivery().getYear();
                    String orderStatus=Order.getOrderAl().get(i).getDeliveryStatus();
                    Object[] data= {orderID,street,state,city,postcode,expDate,orderStatus};
                    tblNonLateM.addRow(data);

                }
            }
        }

    }

    private void btnNewOrderActionPerformed(ActionEvent e) {
        jfOrderOverview.setVisible(false);
        Main.ManagerPage= new ManagerHome();
    }



    private void btnFeedbackActionPerformed(ActionEvent e) {
        jfOrderOverview.setVisible(false);
        Main.feedbackPage= new FeedbackPage();
        Main.feedbackPage.getJfFeedbackManger().setVisible(true);
    }

    private void btnProfileActionPerformed(ActionEvent e) {
        jfOrderOverview.setVisible(false);
        Main.manager_profile= new Manager_profile();
        Main.manager_profile.getJfManagerProfile().setVisible(true);
    }

    private void btnLogoutActionPerformed(ActionEvent e) {
        jfOrderOverview.setVisible(false);
        Main.LoginPage= new StaffLogin();
    }



    public JFrame getJfOrderOverview() {
        return jfOrderOverview;
    }

    public JLabel getLblManagerName() {
        return lblManagerName;
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    private void btnAssignActionPerformed(ActionEvent e) {
        jfOrderOverview.setVisible(false);
        Main.assignOrderPage= new AssignOrder();
    }

    private void btnEditActionPerformed(ActionEvent e) {
        jfOrderOverview.setVisible(false);
        Main.editOrder= new EditOrder();
        Main.editOrder.getJfEditOrder().setVisible(true);
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        createUIComponents();

        jfOrderOverview = new JFrame();
        sPnlManager = new JPanel();
        lblMHomeTitle = new JLabel();
        lblManagerName = new JLabel();
        btnNewOrder = new JButton();
        btnAssign = new JButton();
        btnEdit = new JButton();
        btnFeedback = new JButton();
        btnProfile = new JButton();
        btnLogout = new JButton();
        panel1 = new JPanel();
        scrollPane2 = new JScrollPane();
        lblTitle = new JLabel();
        lblTitle2 = new JLabel();
        scrollPane3 = new JScrollPane();

        //======== jfOrderOverview ========
        {
            jfOrderOverview.setBackground(new Color(204, 204, 204));
            jfOrderOverview.setTitle("Manager Portal");
            jfOrderOverview.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jfOrderOverview.setResizable(false);
            jfOrderOverview.setVisible(true);
            var jfOrderOverviewContentPane = jfOrderOverview.getContentPane();
            jfOrderOverviewContentPane.setLayout(null);

            //======== sPnlManager ========
            {
                sPnlManager.setBackground(new Color(21, 29, 65));
                sPnlManager.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
                EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax. swing
                . border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ),
                java. awt. Color. red) ,sPnlManager. getBorder( )) ); sPnlManager. addPropertyChangeListener (new java. beans. PropertyChangeListener( )
                { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () ))
                throw new RuntimeException( ); }} );
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
                lblManagerName.setBounds(25, 70, 200, 60);

                //---- btnNewOrder ----
                btnNewOrder.setText("New Order");
                btnNewOrder.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnNewOrder.addActionListener(e -> btnNewOrderActionPerformed(e));
                sPnlManager.add(btnNewOrder);
                btnNewOrder.setBounds(45, 160, 145, 45);

                //---- btnAssign ----
                btnAssign.setText("Assign Order");
                btnAssign.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnAssign.addActionListener(e -> btnAssignActionPerformed(e));
                sPnlManager.add(btnAssign);
                btnAssign.setBounds(45, 225, 145, 45);

                //---- btnEdit ----
                btnEdit.setText("Edit Order");
                btnEdit.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnEdit.addActionListener(e -> btnEditActionPerformed(e));
                sPnlManager.add(btnEdit);
                btnEdit.setBounds(45, 285, 145, 45);

                //---- btnFeedback ----
                btnFeedback.setText("Feedback");
                btnFeedback.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnFeedback.addActionListener(e -> btnFeedbackActionPerformed(e));
                sPnlManager.add(btnFeedback);
                btnFeedback.setBounds(45, 345, 145, 45);

                //---- btnProfile ----
                btnProfile.setText("Profile");
                btnProfile.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnProfile.addActionListener(e -> btnProfileActionPerformed(e));
                sPnlManager.add(btnProfile);
                btnProfile.setBounds(45, 410, 145, 45);

                //---- btnLogout ----
                btnLogout.setText("Logout");
                btnLogout.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnLogout.addActionListener(e -> btnLogoutActionPerformed(e));
                sPnlManager.add(btnLogout);
                btnLogout.setBounds(45, 595, 145, 45);

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
            jfOrderOverviewContentPane.add(sPnlManager);
            sPnlManager.setBounds(0, 0, 255, 760);

            //======== panel1 ========
            {
                panel1.setBackground(Color.white);
                panel1.setLayout(null);

                //======== scrollPane2 ========
                {

                    //---- tblLateOrder ----
                    tblLateOrder.setBackground(Color.white);
                    tblLateOrder.setForeground(Color.black);
                    tblLateOrder.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    tblLateOrder.setFillsViewportHeight(true);
                    tblLateOrder.setRowMargin(3);
                    tblLateOrder.setRowHeight(35);
                    tblLateOrder.setFont(new Font("Segoe UI", Font.PLAIN, 22));
                    tblLateOrder.setAutoCreateRowSorter(true);
                    scrollPane2.setViewportView(tblLateOrder);
                }
                panel1.add(scrollPane2);
                scrollPane2.setBounds(45, 70, 765, 300);

                //---- lblTitle ----
                lblTitle.setText("Late Order");
                lblTitle.setFont(new Font("Myanmar Text", Font.BOLD, 46));
                lblTitle.setForeground(Color.red);
                lblTitle.setAlignmentY(0.0F);
                lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
                lblTitle.setIconTextGap(3);
                lblTitle.setBackground(new Color(51, 204, 255));
                panel1.add(lblTitle);
                lblTitle.setBounds(20, 5, 295, 65);

                //---- lblTitle2 ----
                lblTitle2.setText("Order");
                lblTitle2.setFont(new Font("Myanmar Text", Font.BOLD, 46));
                lblTitle2.setForeground(new Color(69, 235, 152));
                lblTitle2.setAlignmentY(0.0F);
                lblTitle2.setHorizontalAlignment(SwingConstants.CENTER);
                lblTitle2.setIconTextGap(3);
                lblTitle2.setBackground(new Color(51, 204, 255));
                panel1.add(lblTitle2);
                lblTitle2.setBounds(0, 380, 210, 65);

                //======== scrollPane3 ========
                {

                    //---- tblNonLate ----
                    tblNonLate.setBackground(Color.white);
                    tblNonLate.setForeground(Color.black);
                    tblNonLate.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    tblNonLate.setFillsViewportHeight(true);
                    tblNonLate.setRowMargin(3);
                    tblNonLate.setRowHeight(35);
                    tblNonLate.setFont(new Font("Segoe UI", Font.PLAIN, 22));
                    tblNonLate.setAutoCreateRowSorter(true);
                    scrollPane3.setViewportView(tblNonLate);
                }
                panel1.add(scrollPane3);
                scrollPane3.setBounds(50, 425, 765, 300);

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
            jfOrderOverviewContentPane.add(panel1);
            panel1.setBounds(255, 0, 850, 760);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < jfOrderOverviewContentPane.getComponentCount(); i++) {
                    Rectangle bounds = jfOrderOverviewContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = jfOrderOverviewContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                jfOrderOverviewContentPane.setMinimumSize(preferredSize);
                jfOrderOverviewContentPane.setPreferredSize(preferredSize);
            }
            jfOrderOverview.pack();
            jfOrderOverview.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private static JFrame jfOrderOverview;
    private static JPanel sPnlManager;
    private static JLabel lblMHomeTitle;
    private static JLabel lblManagerName;
    private static JButton btnNewOrder;
    private static JButton btnAssign;
    private static JButton btnEdit;
    private static JButton btnFeedback;
    private static JButton btnProfile;
    private static JButton btnLogout;
    private JPanel panel1;
    private JScrollPane scrollPane2;
    private static JTable tblLateOrder;
    protected static JLabel lblTitle;
    protected static JLabel lblTitle2;
    private JScrollPane scrollPane3;
    private static JTable tblNonLate;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

