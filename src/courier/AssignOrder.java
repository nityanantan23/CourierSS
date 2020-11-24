/*
 * Created by JFormDesigner on Tue Nov 24 11:09:12 SGT 2020
 */

package courier;

import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author unknown
 */
public class AssignOrder extends JFrame {
    public AssignOrder() {
        loadTable();
        tblOrder=new JTable(tblM);
        initComponents();

    }
    public Object[][] obj;
    private static String[] col={"OrderID","PackageID","CustomerID","OrderDate","ExpectedDelivery","RiderID"};
    private static DefaultTableModel tblM= new DefaultTableModel(col,0){
        public boolean isCellEditable(int row, int column)
        {
            return false;//This causes all cells to be not editable
        }

    };


    private void btnAssignOrderActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    public JFrame getJfAssignOrder() {
        return jfAssignOrder;
    }

    public JLabel getLblManagerName() {
        return lblManagerName;

    }

    public void loadTable(){
        for (int i=0;i<Order.getOrderAl().size() ;i++){
            if (Order.getOrderAl().get(i).getRiderID().equals("null")){
                String orderID= Order.getOrderAl().get(i).getOrderID();
                String cusID= Order.getOrderAl().get(i).getCustomerID();
                String pkgID= Order.getOrderAl().get(i).getOrderPackage().getPackageID();
                String orderDate= Order.getOrderAl().get(i).getOrderDate().get(GregorianCalendar.DATE)+"-"+
                        (Order.getOrderAl().get(i).getOrderDate().get(GregorianCalendar.MONTH)+1)+"-"+Order.getOrderAl().get(i).getOrderDate().get(GregorianCalendar.YEAR);
                String expDate= Order.getOrderAl().get(i).getExpectedDelivery().get(GregorianCalendar.DATE)+"-"+
                        (Order.getOrderAl().get(i).getExpectedDelivery().get(GregorianCalendar.MONTH)+1)+"-"+Order.getOrderAl().get(i).getExpectedDelivery().get(GregorianCalendar.YEAR);
                String riderID="Unassigned";

                Object[] data= {orderID,cusID,pkgID,orderDate,expDate,riderID};
                tblM.addRow(data);
            }
        }
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        createUIComponents();

        jfAssignOrder = new JFrame();
        sPnlManager = new JPanel();
        lblMHomeTitle = new JLabel();
        lblManagerName = new JLabel();
        btnOverview = new JButton();
        btnOrder = new JButton();
        btnRider = new JButton();
        btnReport = new JButton();
        btnFeedback = new JButton();
        btnLogout = new JButton();
        btnAssignOrder = new JButton();
        panel1 = new JPanel();
        pnlTitle = new JPanel();
        lblTitle = new JLabel();
        scrollPane2 = new JScrollPane();

        //======== jfAssignOrder ========
        {
            jfAssignOrder.setBackground(new Color(204, 204, 204));
            jfAssignOrder.setTitle("Manager Portal");
            jfAssignOrder.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jfAssignOrder.setResizable(false);
            jfAssignOrder.setVisible(true);
            var jfAssignOrderContentPane = jfAssignOrder.getContentPane();
            jfAssignOrderContentPane.setLayout(null);

            //======== sPnlManager ========
            {
                sPnlManager.setBackground(new Color(21, 29, 65));
                sPnlManager.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(
                new javax.swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion"
                ,javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM
                ,new java.awt.Font("D\u0069alog",java.awt.Font.BOLD,12)
                ,java.awt.Color.red),sPnlManager. getBorder()));sPnlManager. addPropertyChangeListener(
                new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
                ){if("\u0062order".equals(e.getPropertyName()))throw new RuntimeException()
                ;}});
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

                //---- btnOverview ----
                btnOverview.setText("Overview");
                btnOverview.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                sPnlManager.add(btnOverview);
                btnOverview.setBounds(45, 160, 145, 45);

                //---- btnOrder ----
                btnOrder.setText("New Order");
                btnOrder.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                sPnlManager.add(btnOrder);
                btnOrder.setBounds(45, 235, 145, 45);

                //---- btnRider ----
                btnRider.setText("Rider");
                btnRider.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                sPnlManager.add(btnRider);
                btnRider.setBounds(45, 365, 145, 45);

                //---- btnReport ----
                btnReport.setText("Report");
                btnReport.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                sPnlManager.add(btnReport);
                btnReport.setBounds(45, 425, 145, 45);

                //---- btnFeedback ----
                btnFeedback.setText("Feedback");
                btnFeedback.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                sPnlManager.add(btnFeedback);
                btnFeedback.setBounds(45, 490, 145, 45);

                //---- btnLogout ----
                btnLogout.setText("Logout");
                btnLogout.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                sPnlManager.add(btnLogout);
                btnLogout.setBounds(45, 555, 145, 45);

                //---- btnAssignOrder ----
                btnAssignOrder.setText("Assign Order");
                btnAssignOrder.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnAssignOrder.addActionListener(e -> btnAssignOrderActionPerformed(e));
                sPnlManager.add(btnAssignOrder);
                btnAssignOrder.setBounds(45, 300, 145, 45);

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
            jfAssignOrderContentPane.add(sPnlManager);
            sPnlManager.setBounds(0, 0, 255, 760);

            //======== panel1 ========
            {
                panel1.setBackground(Color.white);
                panel1.setLayout(null);

                //======== pnlTitle ========
                {
                    pnlTitle.setBackground(new Color(186, 201, 245));
                    pnlTitle.setLayout(null);

                    //---- lblTitle ----
                    lblTitle.setText("Assign Order");
                    lblTitle.setFont(new Font("Myanmar Text", Font.BOLD, 46));
                    lblTitle.setForeground(Color.black);
                    lblTitle.setAlignmentY(0.0F);
                    lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
                    lblTitle.setIconTextGap(3);
                    lblTitle.setBackground(new Color(51, 204, 255));
                    pnlTitle.add(lblTitle);
                    lblTitle.setBounds(20, 20, 315, 65);

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

                //======== scrollPane2 ========
                {

                    //---- tblOrder ----
                    tblOrder.setBackground(Color.white);
                    tblOrder.setForeground(Color.black);
                    tblOrder.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    tblOrder.setFillsViewportHeight(true);
                    tblOrder.setCellSelectionEnabled(true);
                    tblOrder.setRowMargin(3);
                    tblOrder.setRowHeight(35);
                    tblOrder.setFont(new Font("Segoe UI", Font.PLAIN, 22));
                    scrollPane2.setViewportView(tblOrder);
                }
                panel1.add(scrollPane2);
                scrollPane2.setBounds(40, 125, 765, 400);

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
            jfAssignOrderContentPane.add(panel1);
            panel1.setBounds(255, 0, panel1.getPreferredSize().width, 760);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < jfAssignOrderContentPane.getComponentCount(); i++) {
                    Rectangle bounds = jfAssignOrderContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = jfAssignOrderContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                jfAssignOrderContentPane.setMinimumSize(preferredSize);
                jfAssignOrderContentPane.setPreferredSize(preferredSize);
            }
            jfAssignOrder.pack();
            jfAssignOrder.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private static JFrame jfAssignOrder;
    private static JPanel sPnlManager;
    private static JLabel lblMHomeTitle;
    private static JLabel lblManagerName;
    private static JButton btnOverview;
    private static JButton btnOrder;
    private static JButton btnRider;
    private static JButton btnReport;
    private static JButton btnFeedback;
    private static JButton btnLogout;
    private static JButton btnAssignOrder;
    private JPanel panel1;
    private JPanel pnlTitle;
    protected static JLabel lblTitle;
    private JScrollPane scrollPane2;
    private static JTable tblOrder;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
