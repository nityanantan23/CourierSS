/*
 * Created by JFormDesigner on Tue Nov 24 16:58:03 SGT 2020
 */

package courier;

import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 * @author unknown
 */
public class RiderHome extends JFrame {
    private static String[] riderCol= {"Order ID","Street","City","Postcode","State","ExpectedDeliveryDate","Order Status"};
    int[] columnsWidth = {60, 220, 90 , 80, 70, 120, 150};
    private static DefaultTableModel tblRiderM= new DefaultTableModel(riderCol,0){
        public boolean isCellEditable(int row, int column)
        {
            return false;//This causes all cells to be not editable
        }
    };
    public RiderHome() {

        loadTable();
        tblRiderOrder= new JTable(tblRiderM);
        tblRiderOrder.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        int i=0;
        for (int width:columnsWidth){
            TableColumn column = tblRiderOrder.getColumnModel().getColumn(i++);
            column.setMinWidth(width);
            column.setMaxWidth(width);
            column.setPreferredWidth(width);
        }
        initComponents();
        lblManagerName.setText(StaffLogin.loggedPerson.getName());
    }

    private void loadTable(){
        for (int i=0;i<Order.getOrderAl().size() ;i++){
            if (Order.getOrderAl().get(i).getRiderID().equals(StaffLogin.loggedPerson.id)&&!Order.getOrderAl().get(i).getDeliveryStatus().equals("Delivered")){
                String orderID= Order.getOrderAl().get(i).getOrderID();
                String street= Order.getOrderAl().get(i).getStreet();
                String city= Order.getOrderAl().get(i).getCity();
                Integer postcode=Order.getOrderAl().get(i).getPostcode();
                String state=Order.getOrderAl().get(i).getState();
                String expDate= Order.getOrderAl().get(i).getExpectedDelivery().getDayOfMonth()+"-"+
                        (Order.getOrderAl().get(i).getExpectedDelivery().getMonthValue())+"-"+Order.getOrderAl().get(i).getExpectedDelivery().getYear();
                String orderStatus=Order.getOrderAl().get(i).getDeliveryStatus();
                Object[] data= {orderID,street,state,city,postcode,expDate,orderStatus};
                tblRiderM.addRow(data);
            }
        }

    }




      
    private void btnOrderProceed1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }
    

    public JFrame getJfRider() {
        return jfRider;
    }

    public JLabel getLblManagerName() {
        return lblManagerName;
    }

    public JButton getBtnUpdateStatus() {
        return btnUpdateStatus;
    }

    private void tblOrderMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    private void btnAssignRiderActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    public JComboBox getCmbStatus() {
        return cmbStatus;
    }

    public JTable getTblRiderOrder() {
        return tblRiderOrder;
    }

    public JLabel getLblRSelOrderID() {
        return lblRSelOrderID;
    }

    

    private void tblRiderOrderMousePressed(MouseEvent e) {
        lblRSelOrderID.setText(tblRiderOrder.getValueAt(tblRiderOrder.getSelectedRow(),0).toString());
    }

    private void btnUpdateStatusActionPerformed(ActionEvent e) {
        if (tblRiderOrder.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null,"Please select which order to assign!","Invalid Order",3);
        }else {
            int confirm=JOptionPane.showConfirmDialog(null,"Are you sure you wan to change the status of order "
                    +tblRiderOrder.getValueAt(tblRiderOrder.getSelectedRow(),0).toString()+
                    " to "+cmbStatus.getSelectedItem().toString()+"?","Status Confirmation",0);
            if (confirm==0){
                for (int i=0;i<Order.getOrderAl().size();i++){
                    if (Order.getOrderAl().get(i).getOrderID().equals(tblRiderOrder.getValueAt(tblRiderOrder.getSelectedRow(),0).toString())){
                        Order.getOrderAl().get(i).setDeliveryStatus(cmbStatus.getSelectedItem().toString());
                        JOptionPane.showMessageDialog(null,"Successfully change the status of order "
                                +Order.getOrderAl().get(i).getOrderID()+" to "+
                                cmbStatus.getSelectedItem().toString()+"." );
                        tblRiderM.setRowCount(0);
                        loadTable();
                        cmbStatus.setSelectedIndex(0);
                        Order o= new Order();
                        o.writeFile();
                        break;
                    }
                }
            }
        }
    }

    private void btnProfileActionPerformed(ActionEvent e) {
        jfRider.setVisible(false);
        Main.riderProfile= new Rider_profile();
        
    }

    private void btnLogoutActionPerformed(ActionEvent e) {
        jfRider.setVisible(false);
        Main.LoginPage= new StaffLogin();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        createUIComponents();

        jfRider = new JFrame();
        sPnlManager = new JPanel();
        lblMHomeTitle = new JLabel();
        lblManagerName = new JLabel();
        btnProfile = new JButton();
        btnLogout = new JButton();
        panel1 = new JPanel();
        btnUpdateStatus = new JButton();
        pnlTitle = new JPanel();
        lblTitle = new JLabel();
        scrollPane1 = new JScrollPane();
        lblStatus = new JLabel();
        cmbStatus = new JComboBox<>();
        lblRSelOrderID = new JLabel();
        lblROrderID = new JLabel();

        //======== jfRider ========
        {
            jfRider.setBackground(new Color(204, 204, 204));
            jfRider.setTitle("Rider Portal");
            jfRider.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jfRider.setResizable(false);
            jfRider.setVisible(true);
            var jfRiderContentPane = jfRider.getContentPane();
            jfRiderContentPane.setLayout(null);

            //======== sPnlManager ========
            {
                sPnlManager.setBackground(new Color(12, 36, 97));
                sPnlManager.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
                swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border
                . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dialo\u0067"
                ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,sPnlManager. getBorder
                ( )) ); sPnlManager. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
                .beans .PropertyChangeEvent e) {if ("borde\u0072" .equals (e .getPropertyName () )) throw new RuntimeException
                ( ); }} );
                sPnlManager.setLayout(null);

                //---- lblMHomeTitle ----
                lblMHomeTitle.setText("Rider Portal");
                lblMHomeTitle.setFont(new Font("Myanmar Text", Font.BOLD, 27));
                lblMHomeTitle.setForeground(Color.white);
                sPnlManager.add(lblMHomeTitle);
                lblMHomeTitle.setBounds(20, 20, 210, 50);

                //---- lblManagerName ----
                lblManagerName.setText("Loges");
                lblManagerName.setFont(new Font("Myanmar Text", Font.BOLD, 26));
                lblManagerName.setForeground(Color.white);
                lblManagerName.setHorizontalAlignment(SwingConstants.CENTER);
                sPnlManager.add(lblManagerName);
                lblManagerName.setBounds(25, 80, 200, 60);

                //---- btnProfile ----
                btnProfile.setText("Profile Setting");
                btnProfile.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnProfile.addActionListener(e -> btnProfileActionPerformed(e));
                sPnlManager.add(btnProfile);
                btnProfile.setBounds(30, 215, 190, 45);

                //---- btnLogout ----
                btnLogout.setText("Logout");
                btnLogout.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnLogout.addActionListener(e -> btnLogoutActionPerformed(e));
                sPnlManager.add(btnLogout);
                btnLogout.setBounds(45, 555, 145, 45);

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
            jfRiderContentPane.add(sPnlManager);
            sPnlManager.setBounds(0, 0, 255, 760);

            //======== panel1 ========
            {
                panel1.setBackground(new Color(242, 242, 242));
                panel1.setForeground(new Color(214, 162, 232));
                panel1.setLayout(null);

                //---- btnUpdateStatus ----
                btnUpdateStatus.setText("Confirm");
                btnUpdateStatus.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
                btnUpdateStatus.setBackground(Color.black);
                btnUpdateStatus.setForeground(Color.white);
                btnUpdateStatus.addActionListener(e -> btnUpdateStatusActionPerformed(e));
                panel1.add(btnUpdateStatus);
                btnUpdateStatus.setBounds(625, 665, 170, 65);

                //======== pnlTitle ========
                {
                    pnlTitle.setBackground(new Color(192, 192, 192, 43));
                    pnlTitle.setLayout(null);

                    //---- lblTitle ----
                    lblTitle.setText("Deliver Order");
                    lblTitle.setFont(new Font("Myanmar Text", Font.BOLD, 46));
                    lblTitle.setForeground(new Color(253, 150, 68));
                    lblTitle.setAlignmentY(0.0F);
                    lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
                    lblTitle.setIconTextGap(3);
                    lblTitle.setBackground(new Color(51, 204, 255));
                    pnlTitle.add(lblTitle);
                    lblTitle.setBounds(20, 20, 295, 65);

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

                //======== scrollPane1 ========
                {
                    scrollPane1.setBackground(new Color(204, 204, 204));

                    //---- tblRiderOrder ----
                    tblRiderOrder.setRowHeight(30);
                    tblRiderOrder.setFont(new Font("Segoe UI", Font.PLAIN, 22));
                    tblRiderOrder.setRowMargin(3);
                    tblRiderOrder.setBackground(Color.white);
                    tblRiderOrder.setForeground(Color.black);
                    tblRiderOrder.setFillsViewportHeight(true);
                    tblRiderOrder.setIntercellSpacing(new Dimension(2, 3));
                    tblRiderOrder.setAutoCreateRowSorter(true);
                    tblRiderOrder.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    tblRiderOrder.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            tblRiderOrderMousePressed(e);
                        }
                    });
                    scrollPane1.setViewportView(tblRiderOrder);
                }
                panel1.add(scrollPane1);
                scrollPane1.setBounds(45, 110, 755, 420);

                //---- lblStatus ----
                lblStatus.setText("Status :");
                lblStatus.setFont(new Font("Nirmala UI", Font.BOLD, 30));
                lblStatus.setForeground(Color.black);
                panel1.add(lblStatus);
                lblStatus.setBounds(50, 655, 140, 45);

                //---- cmbStatus ----
                cmbStatus.setFont(cmbStatus.getFont().deriveFont(cmbStatus.getFont().getSize() + 9f));
                cmbStatus.setBackground(Color.white);
                cmbStatus.setMaximumRowCount(3);
                cmbStatus.setForeground(new Color(86, 83, 83));
                cmbStatus.setModel(new DefaultComboBoxModel<>(new String[] {
                    "In-Transit",
                    "Fail-to-Deliver",
                    "Delivered"
                }));
                panel1.add(cmbStatus);
                cmbStatus.setBounds(240, 660, 210, 45);

                //---- lblRSelOrderID ----
                lblRSelOrderID.setFont(new Font("Nirmala UI", Font.PLAIN, 25));
                lblRSelOrderID.setForeground(Color.black);
                panel1.add(lblRSelOrderID);
                lblRSelOrderID.setBounds(240, 575, 140, 45);

                //---- lblROrderID ----
                lblROrderID.setText("Order ID :");
                lblROrderID.setFont(new Font("Nirmala UI", Font.BOLD, 30));
                lblROrderID.setForeground(Color.black);
                panel1.add(lblROrderID);
                lblROrderID.setBounds(45, 570, 140, 45);

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
            jfRiderContentPane.add(panel1);
            panel1.setBounds(255, 0, panel1.getPreferredSize().width, 760);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < jfRiderContentPane.getComponentCount(); i++) {
                    Rectangle bounds = jfRiderContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = jfRiderContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                jfRiderContentPane.setMinimumSize(preferredSize);
                jfRiderContentPane.setPreferredSize(preferredSize);
            }
            jfRider.pack();
            jfRider.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private static JFrame jfRider;
    private static JPanel sPnlManager;
    private static JLabel lblMHomeTitle;
    private static JLabel lblManagerName;
    private static JButton btnProfile;
    private static JButton btnLogout;
    private JPanel panel1;
    private static JButton btnUpdateStatus;
    private JPanel pnlTitle;
    protected static JLabel lblTitle;
    private JScrollPane scrollPane1;
    private static JTable tblRiderOrder;
    private JLabel lblStatus;
    private static JComboBox<String> cmbStatus;
    private static JLabel lblRSelOrderID;
    private JLabel lblROrderID;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
