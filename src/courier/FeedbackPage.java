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
            cmbOrderID.addItem(Order.getOrderAl().get(i).getOrderID());
        }

        for (int i = 1; i < 6; i++) {
            cmbRating.addItem(i);
        }

        initComponents();
//        cmbRating = new JComboBox<>();
//        cmbRating.addItem("1");
//        cmbRating.addItem("2");
//        cmbRating.addItem("3");
//        cmbRating.addItem("4");
//        cmbRating.addItem("5");


        loadTable();

        jfFeedback.setVisible(true);
    }

    public Object[][] obj;
    private static String[] col = {"ID","OrderID", "Name", "Subject", "Description", "Rating"};
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
                String Name = Feedback.getfeedbackAL().get(i).getName();
                String subject = Feedback.getfeedbackAL().get(i).getSubject();
                String description = Feedback.getfeedbackAL().get(i).getDescription();
                String rating = Feedback.getfeedbackAL().get(i).getRating();
                String orderID = Feedback.getfeedbackAL().get(i).getOrderID();

                Object[] data = {ID, orderID, Name, subject, description, rating};
                tbluser.addRow(data);
            }
        }
    }


    private void tblFeedbackMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void btnAddActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void btnRemoveActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void txtUserKeyTyped(KeyEvent e) {
        // TODO add your code here
    }

    private void txtUserKeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void txtPwKeyTyped(KeyEvent e) {
        // TODO add your code here
    }

    private void txtPwKeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void btnAssignOrderActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    public JComboBox getCmbOrderID() {
        return cmbOrderID;
    }

    public JLabel getLblManagerName() {
        return lblManagerName;
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    private void btnAddFbActionPerformed(ActionEvent e) {

        if (txtName.getText().isBlank() || txtSubject.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "fields are empty!", "Invalid ", 3);

        } else {
            if (txtDescription.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "fields are empty!", "Invalid ", 3);
            } else {
                Feedback a = new Feedback(Feedback.generateID(), cmbOrderID.getSelectedItem().toString(), txtName.getText()
                        , txtSubject.getText(), txtDescription.getText(), cmbRating.getSelectedItem().toString());
                Feedback.getfeedbackAL().add(a);
                a.writeLine();
                JOptionPane.showMessageDialog(null, "Successfully added "
                        + txtSubject.getText());
                resetField();
//                loadTable();
            }

        }
    }

    public static void resetField() {
        txtName.setText("");
        txtSubject.setText("");
        txtName.grabFocus();
    }

    public JFrame getJfFeedback() {
        return jfFeedback;
    }

    public JComboBox getCmbRating() {
        return cmbRating;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        createUIComponents();

        jfFeedback = new JFrame();
        panel1 = new JPanel();
        pnlTitle = new JPanel();
        lblTitle = new JLabel();
        scrollPane2 = new JScrollPane();
        lblRole = new JLabel();
        lblSelOrderId = new JLabel();
        btnAddFb = new JButton();
        txtName = new JTextArea();
        lblPassword = new JLabel();
        lblName = new JLabel();
        lblPhoneNumber = new JLabel();
        scrollPane1 = new JScrollPane();
        txtDescription = new JTextArea();
        lblRole2 = new JLabel();
        txtSubject = new JTextArea();
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
        btnUserMatrix = new JButton();

        //======== jfFeedback ========
        {
            jfFeedback.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            var jfFeedbackContentPane = jfFeedback.getContentPane();
            jfFeedbackContentPane.setLayout(null);

            //======== panel1 ========
            {
                panel1.setBackground(Color.white);
                panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(
                new javax.swing.border.EmptyBorder(0,0,0,0), "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e"
                ,javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM
                ,new java.awt.Font("D\u0069al\u006fg",java.awt.Font.BOLD,12)
                ,java.awt.Color.red),panel1. getBorder()));panel1. addPropertyChangeListener(
                new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
                ){if("\u0062or\u0064er".equals(e.getPropertyName()))throw new RuntimeException()
                ;}});
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
                lblRole.setText("Order ID");
                lblRole.setFont(new Font("Nirmala UI", Font.BOLD, 30));
                lblRole.setForeground(Color.black);
                panel1.add(lblRole);
                lblRole.setBounds(575, 455, 140, 45);

                //---- cmbOrderID ----
                cmbOrderID.setFont(cmbOrderID.getFont().deriveFont(cmbOrderID.getFont().getSize() + 9f));
                cmbOrderID.setBackground(Color.white);
                cmbOrderID.setMaximumRowCount(3);
                cmbOrderID.setForeground(new Color(86, 83, 83));
                panel1.add(cmbOrderID);
                cmbOrderID.setBounds(570, 500, 250, 45);

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

                //---- txtName ----
                txtName.setBackground(new Color(239, 234, 234));
                txtName.setBorder(new LineBorder(Color.black, 3, true));
                txtName.setFont(new Font("Montserrat Light", Font.PLAIN, 31));
                txtName.setForeground(Color.black);
                txtName.setToolTipText("Username");
                txtName.setMargin(new Insets(1, 1, 1, 1));
                txtName.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                txtName.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        txtUserKeyPressed(e);
                    }
                    @Override
                    public void keyTyped(KeyEvent e) {
                        txtUserKeyTyped(e);
                    }
                });
                panel1.add(txtName);
                txtName.setBounds(570, 155, 250, 40);

                //---- lblPassword ----
                lblPassword.setText("Subject");
                lblPassword.setFont(new Font("Nirmala UI", Font.BOLD, 30));
                lblPassword.setForeground(Color.black);
                panel1.add(lblPassword);
                lblPassword.setBounds(570, 205, 195, 45);

                //---- lblName ----
                lblName.setText("Name ");
                lblName.setFont(new Font("Nirmala UI", Font.BOLD, 30));
                lblName.setForeground(Color.black);
                panel1.add(lblName);
                lblName.setBounds(570, 105, 140, 45);

                //---- lblPhoneNumber ----
                lblPhoneNumber.setText("Description");
                lblPhoneNumber.setFont(new Font("Nirmala UI", Font.BOLD, 30));
                lblPhoneNumber.setForeground(Color.black);
                panel1.add(lblPhoneNumber);
                lblPhoneNumber.setBounds(570, 305, 260, 45);

                //======== scrollPane1 ========
                {

                    //---- txtDescription ----
                    txtDescription.setBackground(new Color(235, 234, 234));
                    txtDescription.setBorder(LineBorder.createBlackLineBorder());
                    scrollPane1.setViewportView(txtDescription);
                }
                panel1.add(scrollPane1);
                scrollPane1.setBounds(570, 350, 235, 100);

                //---- cmbRating ----
                cmbRating.setFont(cmbRating.getFont().deriveFont(cmbRating.getFont().getSize() + 9f));
                cmbRating.setBackground(Color.white);
                cmbRating.setMaximumRowCount(3);
                cmbRating.setForeground(new Color(86, 83, 83));
                panel1.add(cmbRating);
                cmbRating.setBounds(570, 600, 250, 45);

                //---- lblRole2 ----
                lblRole2.setText("Ratings");
                lblRole2.setFont(new Font("Nirmala UI", Font.BOLD, 30));
                lblRole2.setForeground(Color.black);
                panel1.add(lblRole2);
                lblRole2.setBounds(575, 550, 140, 45);

                //---- txtSubject ----
                txtSubject.setBackground(new Color(239, 234, 234));
                txtSubject.setBorder(new LineBorder(Color.black, 3, true));
                txtSubject.setFont(new Font("Montserrat Light", Font.PLAIN, 31));
                txtSubject.setForeground(Color.black);
                txtSubject.setToolTipText("Username");
                txtSubject.setMargin(new Insets(1, 1, 1, 1));
                txtSubject.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                txtSubject.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        txtUserKeyPressed(e);
                    }
                    @Override
                    public void keyTyped(KeyEvent e) {
                        txtUserKeyTyped(e);
                    }
                });
                panel1.add(txtSubject);
                txtSubject.setBounds(565, 260, 250, 40);

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
            jfFeedbackContentPane.add(panel1);
            panel1.setBounds(255, 0, 895, 760);

            //======== sPnlManager ========
            {
                sPnlManager.setBackground(new Color(21, 29, 65));
                sPnlManager.setLayout(null);

                //---- lblMHomeTitle ----
                lblMHomeTitle.setText("Admin Portal");
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
                btnOrder.setBounds(45, 220, 145, 45);

                //---- btnRider ----
                btnRider.setText("Rider");
                btnRider.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                sPnlManager.add(btnRider);
                btnRider.setBounds(45, 345, 145, 45);

                //---- btnReport ----
                btnReport.setText("Report");
                btnReport.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                sPnlManager.add(btnReport);
                btnReport.setBounds(45, 410, 145, 45);

                //---- btnFeedback ----
                btnFeedback.setText("Feedback");
                btnFeedback.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                sPnlManager.add(btnFeedback);
                btnFeedback.setBounds(45, 475, 145, 45);

                //---- btnLogout ----
                btnLogout.setText("Logout");
                btnLogout.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                sPnlManager.add(btnLogout);
                btnLogout.setBounds(45, 610, 145, 45);

                //---- btnAssignOrder ----
                btnAssignOrder.setText("Assign Order");
                btnAssignOrder.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnAssignOrder.addActionListener(e -> btnAssignOrderActionPerformed(e));
                sPnlManager.add(btnAssignOrder);
                btnAssignOrder.setBounds(45, 285, 145, 45);

                //---- btnUserMatrix ----
                btnUserMatrix.setText("User Matrix");
                btnUserMatrix.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                sPnlManager.add(btnUserMatrix);
                btnUserMatrix.setBounds(45, 540, 145, 45);

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
            jfFeedbackContentPane.add(sPnlManager);
            sPnlManager.setBounds(0, 0, 255, 760);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < jfFeedbackContentPane.getComponentCount(); i++) {
                    Rectangle bounds = jfFeedbackContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = jfFeedbackContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                jfFeedbackContentPane.setMinimumSize(preferredSize);
                jfFeedbackContentPane.setPreferredSize(preferredSize);
            }
            jfFeedback.pack();
            jfFeedback.setLocationRelativeTo(jfFeedback.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private static JFrame jfFeedback;
    private JPanel panel1;
    private JPanel pnlTitle;
    protected static JLabel lblTitle;
    private JScrollPane scrollPane2;
    private static JTable tblFeedback;
    private JLabel lblRole;
    private static JComboBox cmbOrderID;
    private static JLabel lblSelOrderId;
    private static JButton btnAddFb;
    private static JTextArea txtName;
    private JLabel lblPassword;
    private JLabel lblName;
    private JLabel lblPhoneNumber;
    private JScrollPane scrollPane1;
    private JTextArea txtDescription;
    private static JComboBox cmbRating;
    private JLabel lblRole2;
    private static JTextArea txtSubject;
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
    private static JButton btnUserMatrix;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
