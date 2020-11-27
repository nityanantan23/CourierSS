/*
 * Created by JFormDesigner on Fri Nov 27 14:12:57 SGT 2020
 */

package courier;

import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 * @author unknown
 */
public class EditOrder extends JFrame {
    private static String[] tblCol= {"Order ID","Street","City","Postcode","State","ExpectedDeliveryDate","Order Status"};
    int[] columnsWidth = {60, 220, 90 , 80, 70, 120, 150};
    private static DefaultTableModel tblM= new DefaultTableModel(tblCol,0){
        public boolean isCellEditable(int row, int column)
        {
            return false;//This causes all cells to be not editable
        }
    };

    public EditOrder() {
        loadTable();
        tblEditOrder = new JTable(tblM);
        tblEditOrder.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        int i = 0;
        for (int width : columnsWidth) {
            TableColumn column = tblEditOrder.getColumnModel().getColumn(i++);
            column.setMinWidth(width);
            column.setMaxWidth(width);
            column.setPreferredWidth(width);
        }
        initComponents();
        lblManagerName.setText(StaffLogin.loggedPerson.name);
    }     

     private void loadTable(){
         tblM.setRowCount(0);
        for (int i=0;i<Order.getOrderAl().size() ;i++){
            if (!Order.getOrderAl().get(i).getDeliveryStatus().equals("Delivered")&&!Order.getOrderAl().get(i).getDeliveryStatus().equals("Cancelled")){
                String orderID= Order.getOrderAl().get(i).getOrderID();
                String street= Order.getOrderAl().get(i).getStreet();
                String city= Order.getOrderAl().get(i).getCity();
                Integer postcode=Order.getOrderAl().get(i).getPostcode();
                String state=Order.getOrderAl().get(i).getState();
                String expDate= Order.getOrderAl().get(i).getExpectedDelivery().getDayOfMonth()+"-"+
                        (Order.getOrderAl().get(i).getExpectedDelivery().getMonthValue())+"-"+Order.getOrderAl().get(i).getExpectedDelivery().getYear();
                String orderStatus=Order.getOrderAl().get(i).getDeliveryStatus();
                Object[] data= {orderID,street,state,city,postcode,expDate,orderStatus};
                tblM.addRow(data);
            }
        }

    }


        private void tblRiderOrderMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void btnUpdateStatusActionPerformed(ActionEvent e) {
        if (tblEditOrder.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null,"Please select which order to assign!","Invalid Order",3);
        }else {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you wan to cancel the order "
                    + tblEditOrder.getValueAt(tblEditOrder.getSelectedRow(), 0).toString() ,"Cancel Confirmation", 0);
            if (confirm==0){
            for (int i = 0; i < Order.getOrderAl().size(); i++) {
                if (tblEditOrder.getValueAt(tblEditOrder.getSelectedRow(), 0).toString().equals(Order.getOrderAl().get(i).getOrderID())) {
                    Order.getOrderAl().get(i).setDeliveryStatus("Cancelled");
                    Order o = new Order();
                    loadTable();
                    o.writeFile();
                    break;
                }
            }
            }

        }
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    public JFrame getJfEditOrder() {
        return jfEditOrder;
    }

    public JButton getBtnCancelOrder() {
        return btnCancelOrder;
    }

    public JTable getTblEditOrder() {
        return tblEditOrder;
    }

    public JLabel getLblMSelOrderID() {
        return lblMSelOrderID;
    }

    private void btnOrderActionPerformed(ActionEvent e) {
        jfEditOrder.setVisible(false);
        Main.ManagerPage= new ManagerHome();
    }

    private void btnAssignOrderActionPerformed(ActionEvent e) {
        jfEditOrder.setVisible(false);
        Main.assignOrderPage= new AssignOrder();
    }

    private void btnFeedbackActionPerformed(ActionEvent e) {
        jfEditOrder.setVisible(false);
        Main.feedbackPage= new FeedbackPage();
        Main.feedbackPage.getJfFeedbackManger().setVisible(true);
    }

    private void btnLogoutActionPerformed(ActionEvent e) {
        jfEditOrder.setVisible(false);
        Main.LoginPage= new StaffLogin();
    }

    public JLabel getLblManagerName() {
        return lblManagerName;
    }

    public JLabel getLblMStatus() {
        return lblMStatus;
    }

    private void tblRiderOrderMouseClicked(MouseEvent e) {
        lblMSelOrderID.setText(tblEditOrder.getValueAt(tblEditOrder.getSelectedRow(),0).toString());
        lblMStatus.setText(tblEditOrder.getValueAt(tblEditOrder.getSelectedRow(),6).toString());
    }

    private void tblEditOrderMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void btnOverviewActionPerformed(ActionEvent e) {
        jfEditOrder.setVisible(false);
        Main.orderOverview= new OrderOverview();
        Main.orderOverview.getJfOrderOverview().setVisible(true);
    }

    private void btnProfileActionPerformed(ActionEvent e) {
        jfEditOrder.setVisible(false);
        Main.manager_profile= new Manager_profile();
        Main.manager_profile.getJfManagerProfile().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        createUIComponents();

        jfEditOrder = new JFrame();
        panel1 = new JPanel();
        btnCancelOrder = new JButton();
        scrollPane1 = new JScrollPane();
        lblStatus = new JLabel();
        lblMSelOrderID = new JLabel();
        lblMOrderID = new JLabel();
        pnlTitle = new JPanel();
        lblTitle = new JLabel();
        lblMStatus = new JLabel();
        sPnlManager = new JPanel();
        lblMHomeTitle = new JLabel();
        btnOrder = new JButton();
        btnAssignOrder = new JButton();
        btnOverview = new JButton();
        btnProfile = new JButton();
        btnFeedback = new JButton();
        btnLogout = new JButton();
        lblManagerName = new JLabel();

        //======== jfEditOrder ========
        {
            jfEditOrder.setBackground(new Color(204, 204, 204));
            jfEditOrder.setTitle("Manager Portal");
            jfEditOrder.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jfEditOrder.setResizable(false);
            jfEditOrder.setVisible(true);
            var jfEditOrderContentPane = jfEditOrder.getContentPane();
            jfEditOrderContentPane.setLayout(null);

            //======== panel1 ========
            {
                panel1.setBackground(new Color(242, 242, 242));
                panel1.setForeground(new Color(214, 162, 232));
                panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
                javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax
                . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
                .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
                . Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans.
                PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .
                equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
                panel1.setLayout(null);

                //---- btnCancelOrder ----
                btnCancelOrder.setText("Cancel Order");
                btnCancelOrder.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
                btnCancelOrder.setBackground(Color.black);
                btnCancelOrder.setForeground(Color.white);
                btnCancelOrder.addActionListener(e -> btnUpdateStatusActionPerformed(e));
                panel1.add(btnCancelOrder);
                btnCancelOrder.setBounds(625, 665, 200, 65);

                //======== scrollPane1 ========
                {
                    scrollPane1.setBackground(new Color(204, 204, 204));

                    //---- tblEditOrder ----
                    tblEditOrder.setRowHeight(30);
                    tblEditOrder.setFont(new Font("Segoe UI", Font.PLAIN, 22));
                    tblEditOrder.setRowMargin(3);
                    tblEditOrder.setBackground(Color.white);
                    tblEditOrder.setForeground(Color.black);
                    tblEditOrder.setFillsViewportHeight(true);
                    tblEditOrder.setIntercellSpacing(new Dimension(2, 3));
                    tblEditOrder.setAutoCreateRowSorter(true);
                    tblEditOrder.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    tblEditOrder.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            tblEditOrderMousePressed(e);
                        }
                    });
                    scrollPane1.setViewportView(tblEditOrder);
                }
                panel1.add(scrollPane1);
                scrollPane1.setBounds(45, 110, 795, 420);

                //---- lblStatus ----
                lblStatus.setText("Status :");
                lblStatus.setFont(new Font("Nirmala UI", Font.BOLD, 30));
                lblStatus.setForeground(Color.black);
                panel1.add(lblStatus);
                lblStatus.setBounds(50, 655, 140, 45);

                //---- lblMSelOrderID ----
                lblMSelOrderID.setFont(new Font("Nirmala UI", Font.PLAIN, 25));
                lblMSelOrderID.setForeground(Color.black);
                panel1.add(lblMSelOrderID);
                lblMSelOrderID.setBounds(240, 575, 140, 45);

                //---- lblMOrderID ----
                lblMOrderID.setText("Order ID :");
                lblMOrderID.setFont(new Font("Nirmala UI", Font.BOLD, 30));
                lblMOrderID.setForeground(Color.black);
                panel1.add(lblMOrderID);
                lblMOrderID.setBounds(45, 570, 140, 45);

                //======== pnlTitle ========
                {
                    pnlTitle.setBackground(new Color(186, 201, 245));
                    pnlTitle.setLayout(null);

                    //---- lblTitle ----
                    lblTitle.setText("Edit Order");
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

                //---- lblMStatus ----
                lblMStatus.setFont(new Font("Nirmala UI", Font.PLAIN, 25));
                lblMStatus.setForeground(Color.black);
                panel1.add(lblMStatus);
                lblMStatus.setBounds(205, 660, 215, 45);

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
            jfEditOrderContentPane.add(panel1);
            panel1.setBounds(255, 0, 850, 760);

            //======== sPnlManager ========
            {
                sPnlManager.setBackground(new Color(21, 29, 65));
                sPnlManager.setLayout(null);

                //---- lblMHomeTitle ----
                lblMHomeTitle.setText("Manager Portal");
                lblMHomeTitle.setFont(new Font("Myanmar Text", Font.BOLD, 27));
                lblMHomeTitle.setForeground(Color.white);
                sPnlManager.add(lblMHomeTitle);
                lblMHomeTitle.setBounds(20, 15, 210, 50);

                //---- btnOrder ----
                btnOrder.setText("New Order");
                btnOrder.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnOrder.addActionListener(e -> btnOrderActionPerformed(e));
                sPnlManager.add(btnOrder);
                btnOrder.setBounds(45, 145, 145, 45);

                //---- btnAssignOrder ----
                btnAssignOrder.setText("Assign Order");
                btnAssignOrder.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnAssignOrder.addActionListener(e -> btnAssignOrderActionPerformed(e));
                sPnlManager.add(btnAssignOrder);
                btnAssignOrder.setBounds(45, 215, 145, 45);

                //---- btnOverview ----
                btnOverview.setText("Overview");
                btnOverview.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnOverview.addActionListener(e -> btnOverviewActionPerformed(e));
                sPnlManager.add(btnOverview);
                btnOverview.setBounds(45, 280, 145, 45);

                //---- btnProfile ----
                btnProfile.setText("Profile");
                btnProfile.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnProfile.addActionListener(e -> btnProfileActionPerformed(e));
                sPnlManager.add(btnProfile);
                btnProfile.setBounds(45, 415, 145, 45);

                //---- btnFeedback ----
                btnFeedback.setText("Feedback");
                btnFeedback.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnFeedback.addActionListener(e -> btnFeedbackActionPerformed(e));
                sPnlManager.add(btnFeedback);
                btnFeedback.setBounds(45, 355, 145, 45);

                //---- btnLogout ----
                btnLogout.setText("Logout");
                btnLogout.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnLogout.addActionListener(e -> btnLogoutActionPerformed(e));
                sPnlManager.add(btnLogout);
                btnLogout.setBounds(45, 595, 145, 45);

                //---- lblManagerName ----
                lblManagerName.setText("Loges");
                lblManagerName.setFont(new Font("Myanmar Text", Font.BOLD, 26));
                lblManagerName.setForeground(Color.white);
                lblManagerName.setHorizontalAlignment(SwingConstants.CENTER);
                sPnlManager.add(lblManagerName);
                lblManagerName.setBounds(20, 70, 200, 60);

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
            jfEditOrderContentPane.add(sPnlManager);
            sPnlManager.setBounds(0, 0, 255, 760);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < jfEditOrderContentPane.getComponentCount(); i++) {
                    Rectangle bounds = jfEditOrderContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = jfEditOrderContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                jfEditOrderContentPane.setMinimumSize(preferredSize);
                jfEditOrderContentPane.setPreferredSize(preferredSize);
            }
            jfEditOrder.pack();
            jfEditOrder.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private static JFrame jfEditOrder;
    private JPanel panel1;
    private static JButton btnCancelOrder;
    private JScrollPane scrollPane1;
    private static JTable tblEditOrder;
    private JLabel lblStatus;
    private static JLabel lblMSelOrderID;
    private JLabel lblMOrderID;
    private JPanel pnlTitle;
    protected static JLabel lblTitle;
    private static JLabel lblMStatus;
    private static JPanel sPnlManager;
    private static JLabel lblMHomeTitle;
    private static JButton btnOrder;
    private static JButton btnAssignOrder;
    private static JButton btnOverview;
    private static JButton btnProfile;
    private static JButton btnFeedback;
    private static JButton btnLogout;
    private static JLabel lblManagerName;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
