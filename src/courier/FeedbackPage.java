/*
 * Created by JFormDesigner on Thu Nov 12 23:31:16 SGT 2020
 */

package courier;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author unknown
 */
public class FeedbackPage {
    private static JTable tblUser;
    public FeedbackPage() {
        tblFeedback = new JTable(tbluser);
        cmbOrderID= new JComboBox<>();
        cmbRating= new JComboBox<>();
        for (int i = 0; i < Order.getOrderAl().size(); i++) {
            boolean pass=true;
            if (Order.getOrderAl().get(i).getDeliveryStatus().equals("Delivered")){
                for (int i2=0;i2<Feedback.getfeedbackAL().size();i2++){
                if (Order.getOrderAl().get(i).getOrderID().equals(Feedback.getfeedbackAL().get(i2).getOrderID())){
                    pass=false;
                    break;
                    }
                }
                if (pass!=false){
                    cmbOrderID.addItem(Order.getOrderAl().get(i).getOrderID());
                }
            }
        }

        for (int i = 1; i < 6; i++) {
            cmbRating.addItem(i);
        }

        loadTable();
        initComponents();

        btnFeedback.setEnabled(false);
        lblManagerName.setText(StaffLogin.loggedPerson.getName());
        jfFeedbackManger.setVisible(true);
    }

    public Object[][] obj;
    private static String[] col = {"ID","OrderID", "Description", "Rating"};
    private static DefaultTableModel tbluser = new DefaultTableModel(col, 0) {
        public boolean isCellEditable(int row, int column) {
            return false;//This causes all cells to be not editable
        }
    };

    public void loadTable() {
        tbluser.setRowCount(0);
        for (int i = 0; i < Feedback.getfeedbackAL().size(); i++) {
            if (Feedback.getfeedbackAL().get(i).getFeedbackID() != null) {
                String ID = Feedback.getfeedbackAL().get(i).getFeedbackID();
                String description = Feedback.getfeedbackAL().get(i).getDescription();
                String rating = Feedback.getfeedbackAL().get(i).getRating();
                String orderID = Feedback.getfeedbackAL().get(i).getOrderID();
                Object[] data = {ID, orderID, description, rating};
                tbluser.addRow(data);
            }
        }
    }


    private void tblFeedbackMouseClicked(MouseEvent e) {
        // TODO add your code here
    }


    private void btnAssignOrderActionPerformed(ActionEvent e) {
        jfFeedbackManger.setVisible(false);
        Main.assignOrderPage= new AssignOrder();
    }

    public JComboBox getCmbOrderID() {
        return cmbOrderID;
    }

    public JButton getbtnNewOrder() {
        return btnNewOrder;
    }

    public JButton getbtnAssignOrder() {
        return btnAssignOrder;
    }
    public JButton getbtnOverview() {
        return btnOverview;
    }
    public JButton getbtnProfile() {
        return btnProfile;
    }
    public JButton getbtnEdit() {
        return btnEdit;
    }
    public JLabel getlbltitle() {
        return lblMHomeTitle;
    }
   

    public JLabel getLblManagerName() {
        return lblManagerName;
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    private void btnAddFbActionPerformed(ActionEvent e) {

        if (txtDescription.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "fields are empty!", "Invalid ", 3);

        } else {
            if (txtDescription.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "fields are empty!", "Invalid ", 3);
            } else {
                Feedback a = new Feedback(cmbOrderID.getSelectedItem().toString(),txtDescription.getText(), cmbRating.getSelectedItem().toString());
                Feedback.getfeedbackAL().add(a);
                a.writeLine();
                JOptionPane.showMessageDialog(null, "Successfully added ");
                resetField();
                tblFeedback = new JTable(tbluser);
            }

        }
    }

    public static void resetField() {
        txtDescription.setText("");
        txtDescription.grabFocus();
    }

    public JFrame getJfFeedbackManger() {
        return jfFeedbackManger;
    }

    public JComboBox getCmbRating() {
        return cmbRating;
    }

    private void btnFeedbackMenuActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void btnFeedbackActionPerformed(ActionEvent e) {
        jfFeedbackManger.setVisible(false);

    }

    private void btnProfileActionPerformed(ActionEvent e) {
        jfFeedbackManger.setVisible(false);
        Main.manager_profile= new Manager_profile();
        Main.manager_profile.getJfManagerProfile().setVisible(true);
    }

    private void btnLogoutActionPerformed(ActionEvent e) {
        jfFeedbackManger.setVisible(false);
        Main.LoginPage= new StaffLogin();
    }

    private void btnNewOrderActionPerformed(ActionEvent e) {
        jfFeedbackManger.setVisible(false);
        Main.ManagerPage= new ManagerHome();
        Main.ManagerPage.getJfManager().setVisible(true);
    }



    private void btnEditActionPerformed(ActionEvent e) {
        jfFeedbackManger.setVisible(false);
        Main.editOrder= new EditOrder();
        Main.editOrder.getJfEditOrder().setVisible(true);
    }

    private void btnOverviewActionPerformed(ActionEvent e) {
        jfFeedbackManger.setVisible(false);
        Main.orderOverview= new OrderOverview();
        Main.orderOverview.getJfOrderOverview().setVisible(true);
    }

    private void btnUserMatrixActionPerformed(ActionEvent e) {
        jfFeedbackManger.setVisible(false);
        Main.adminUserMatrix= new Admin_UserMatrix(); }

    private void btnReportActionPerformed(ActionEvent e) {
        jfFeedbackManger.setVisible(false);
        Main.report= new Report();    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        createUIComponents();

        jfFeedbackManger = new JFrame();
        panel1 = new JPanel();
        pnlTitle = new JPanel();
        lblTitle = new JLabel();
        scrollPane2 = new JScrollPane();
        lblRole = new JLabel();
        lblSelOrderId = new JLabel();
        btnAddFb = new JButton();
        lblPhoneNumber = new JLabel();
        lblRole2 = new JLabel();
        txtDescription = new JTextField();
        sPnlManager = new JPanel();
        lblMHomeTitle = new JLabel();
        lblManagerName = new JLabel();
        btnAssignOrder = new JButton();
        btnOverview = new JButton();
        btnEdit = new JButton();
        btnNewOrder = new JButton();
        btnProfile = new JButton();
        btnLogout = new JButton();
        btnUserMatrix = new JButton();
        btnFeedback = new JButton();
        btnReport = new JButton();

        //======== jfFeedbackManger ========
        {
            jfFeedbackManger.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            var jfFeedbackMangerContentPane = jfFeedbackManger.getContentPane();
            jfFeedbackMangerContentPane.setLayout(null);

            //======== panel1 ========
            {
                panel1.setBackground(Color.white);
                panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
                . EmptyBorder( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing. border. TitledBorder. CENTER, javax
                . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069al\u006fg" ,java .awt .Font .BOLD ,
                12 ), java. awt. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans
                . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062or\u0064er" .equals (e .
                getPropertyName () )) throw new RuntimeException( ); }} );
                panel1.setLayout(null);

                //======== pnlTitle ========
                {
                    pnlTitle.setBackground(new Color(186, 201, 245));
                    pnlTitle.setLayout(null);

                    //---- lblTitle ----
                    lblTitle.setText("Feedback");
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
                pnlTitle.setBounds(0, 0, 900, 80);

                //======== scrollPane2 ========
                {

                    //---- tblFeedback ----
                    tblFeedback.setBackground(Color.white);
                    tblFeedback.setForeground(Color.black);
                    tblFeedback.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    tblFeedback.setFillsViewportHeight(true);
                    tblFeedback.setCellSelectionEnabled(true);
                    tblFeedback.setRowMargin(3);
                    tblFeedback.setRowHeight(35);
                    tblFeedback.setFont(new Font("Segoe UI", Font.PLAIN, 22));
                    tblFeedback.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            tblFeedbackMouseClicked(e);
                        }
                    });
                    scrollPane2.setViewportView(tblFeedback);
                }
                panel1.add(scrollPane2);
                scrollPane2.setBounds(40, 150, 495, 490);

                //---- lblRole ----
                lblRole.setText("Unrated Order ID");
                lblRole.setFont(new Font("Nirmala UI", Font.BOLD, 30));
                lblRole.setForeground(Color.black);
                panel1.add(lblRole);
                lblRole.setBounds(575, 335, 280, 45);

                //---- cmbOrderID ----
                cmbOrderID.setFont(cmbOrderID.getFont().deriveFont(cmbOrderID.getFont().getSize() + 9f));
                cmbOrderID.setBackground(Color.white);
                cmbOrderID.setMaximumRowCount(3);
                cmbOrderID.setForeground(new Color(86, 83, 83));
                panel1.add(cmbOrderID);
                cmbOrderID.setBounds(570, 380, 250, 45);

                //---- lblSelOrderId ----
                lblSelOrderId.setFont(new Font("Nirmala UI", Font.PLAIN, 25));
                lblSelOrderId.setForeground(Color.black);
                panel1.add(lblSelOrderId);
                lblSelOrderId.setBounds(255, 500, 140, 45);

                //---- btnAddFb ----
                btnAddFb.setText("Add");
                btnAddFb.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnAddFb.addActionListener(e -> btnAddFbActionPerformed(e));
                panel1.add(btnAddFb);
                btnAddFb.setBounds(610, 675, 145, 45);

                //---- lblPhoneNumber ----
                lblPhoneNumber.setText("Description");
                lblPhoneNumber.setFont(new Font("Nirmala UI", Font.BOLD, 30));
                lblPhoneNumber.setForeground(Color.black);
                panel1.add(lblPhoneNumber);
                lblPhoneNumber.setBounds(560, 155, 260, 45);

                //---- cmbRating ----
                cmbRating.setFont(cmbRating.getFont().deriveFont(cmbRating.getFont().getSize() + 9f));
                cmbRating.setBackground(Color.white);
                cmbRating.setMaximumRowCount(3);
                cmbRating.setForeground(new Color(86, 83, 83));
                panel1.add(cmbRating);
                cmbRating.setBounds(570, 480, 250, 45);

                //---- lblRole2 ----
                lblRole2.setText("Ratings");
                lblRole2.setFont(new Font("Nirmala UI", Font.BOLD, 30));
                lblRole2.setForeground(Color.black);
                panel1.add(lblRole2);
                lblRole2.setBounds(575, 430, 140, 45);

                //---- txtDescription ----
                txtDescription.setBackground(Color.white);
                txtDescription.setForeground(Color.black);
                panel1.add(txtDescription);
                txtDescription.setBounds(565, 215, 275, 45);

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
            jfFeedbackMangerContentPane.add(panel1);
            panel1.setBounds(255, 0, 895, 760);

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

                //---- lblManagerName ----
                lblManagerName.setText("Loges");
                lblManagerName.setFont(new Font("Myanmar Text", Font.BOLD, 26));
                lblManagerName.setForeground(Color.white);
                lblManagerName.setHorizontalAlignment(SwingConstants.CENTER);
                sPnlManager.add(lblManagerName);
                lblManagerName.setBounds(25, 70, 200, 60);

                //---- btnAssignOrder ----
                btnAssignOrder.setText("Assign Order");
                btnAssignOrder.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnAssignOrder.addActionListener(e -> btnAssignOrderActionPerformed(e));
                sPnlManager.add(btnAssignOrder);
                btnAssignOrder.setBounds(50, 255, 145, 45);

                //---- btnOverview ----
                btnOverview.setText("Overview");
                btnOverview.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnOverview.addActionListener(e -> btnOverviewActionPerformed(e));
                sPnlManager.add(btnOverview);
                btnOverview.setBounds(50, 320, 145, 45);

                //---- btnEdit ----
                btnEdit.setText("Edit Order");
                btnEdit.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnEdit.addActionListener(e -> btnEditActionPerformed(e));
                sPnlManager.add(btnEdit);
                btnEdit.setBounds(50, 385, 145, 45);

                //---- btnNewOrder ----
                btnNewOrder.setText("New Order");
                btnNewOrder.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnNewOrder.addActionListener(e -> btnNewOrderActionPerformed(e));
                sPnlManager.add(btnNewOrder);
                btnNewOrder.setBounds(50, 190, 145, 45);

                //---- btnProfile ----
                btnProfile.setText("Profile");
                btnProfile.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnProfile.addActionListener(e -> btnProfileActionPerformed(e));
                sPnlManager.add(btnProfile);
                btnProfile.setBounds(50, 460, 145, 45);

                //---- btnLogout ----
                btnLogout.setText("Logout");
                btnLogout.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnLogout.addActionListener(e -> btnLogoutActionPerformed(e));
                sPnlManager.add(btnLogout);
                btnLogout.setBounds(50, 615, 145, 45);

                //---- btnUserMatrix ----
                btnUserMatrix.setText("User Matrix");
                btnUserMatrix.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnUserMatrix.addActionListener(e -> {
			btnUserMatrixActionPerformed(e);
		});
                sPnlManager.add(btnUserMatrix);
                btnUserMatrix.setBounds(50, 320, 145, 45);

                //---- btnFeedback ----
                btnFeedback.setText("Feedback");
                btnFeedback.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnFeedback.addActionListener(e -> {
			btnFeedbackActionPerformed(e);
		});
                sPnlManager.add(btnFeedback);
                btnFeedback.setBounds(50, 255, 145, 45);

                //---- btnReport ----
                btnReport.setText("Report");
                btnReport.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnReport.addActionListener(e -> {
			btnReportActionPerformed(e);
		});
                sPnlManager.add(btnReport);
                btnReport.setBounds(50, 190, 145, 45);

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
            jfFeedbackMangerContentPane.add(sPnlManager);
            sPnlManager.setBounds(0, 0, 255, 760);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < jfFeedbackMangerContentPane.getComponentCount(); i++) {
                    Rectangle bounds = jfFeedbackMangerContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = jfFeedbackMangerContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                jfFeedbackMangerContentPane.setMinimumSize(preferredSize);
                jfFeedbackMangerContentPane.setPreferredSize(preferredSize);
            }
            jfFeedbackManger.pack();
            jfFeedbackManger.setLocationRelativeTo(jfFeedbackManger.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private static JFrame jfFeedbackManger;
    private JPanel panel1;
    private JPanel pnlTitle;
    protected static JLabel lblTitle;
    private JScrollPane scrollPane2;
    private static JTable tblFeedback;
    private JLabel lblRole;
    private static JComboBox cmbOrderID;
    private static JLabel lblSelOrderId;
    private static JButton btnAddFb;
    private JLabel lblPhoneNumber;
    private static JComboBox cmbRating;
    private JLabel lblRole2;
    private static JTextField txtDescription;
    private static JPanel sPnlManager;
    private static JLabel lblMHomeTitle;
    private static JLabel lblManagerName;
    private static JButton btnAssignOrder;
    private static JButton btnOverview;
    private static JButton btnEdit;
    private static JButton btnNewOrder;
    private static JButton btnProfile;
    private static JButton btnLogout;
    private static JButton btnUserMatrix;
    private static JButton btnFeedback;
    private static JButton btnReport;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
