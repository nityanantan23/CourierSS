/*
 * Created by JFormDesigner on Thu Nov 26 18:01:34 SGT 2020
 */

package courier;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class Manager_profile extends GUI{
    public Manager_profile() {

        initComponents();

        loadTable((Manager)StaffLogin.loggedPerson);

        jfManagerProfile.setVisible(true);
    }

    public void loadTable(Manager m) {
        lblManagerName.setText(m.name);
        lblName.setText(m.getName());
        txtPw.setText(m.getPassword());
        txtIPh.setText(m.getPhone());
        jfManagerProfile.setVisible(false);

    }


    private void btnOrderProceed1ActionPerformed(ActionEvent e) {
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to edit " +
                lblName.getText().toString() + "?", " Confirmation", 0);
            
        if (txtIPh.getText().length()<8||txtPw.getText().length()<8){
            JOptionPane.showMessageDialog(null,"Phone number must greater than 8 digits and Password must greater than 7 digit.","Invalid Input",2);
        }else {
            if (confirm == 0) {
                StaffLogin.loggedPerson.setPhone(txtIPh.getText());
                StaffLogin.loggedPerson.setPassword(txtPw.getText());
                Manager m= new Manager();
                m.writeFile();
                JOptionPane.showMessageDialog(null,"Successfully modified the data.","Modification Success",1);
            }
        }
            
    }


    public JLabel getLblManagerName() {
        return lblManagerName;
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public static JFrame getJfManagerProfile() {
        return jfManagerProfile;
    }

    private void btnFeedbackActionPerformed(ActionEvent e) {
        jfManagerProfile.setVisible(false);
        Main.feedbackPage= new FeedbackPage();
    }

  
    private void btnLogoutActionPerformed(ActionEvent e) {
        jfManagerProfile.setVisible(false);
        Main.LoginPage= new StaffLogin();
    }

    private void txtIPhKeyPressed(KeyEvent e) {
        super.numCheck(e,"Phone",txtIPh);
    }

    private void txtIPhKeyTyped(KeyEvent e) {
        lengthChecker(e,"Phone",txtIPh,10);
    }

    private void txtPwKeyTyped(KeyEvent e) {
        lengthChecker(e,"Phone",txtPw,12);
    }

    private void btnOrderActionPerformed(ActionEvent e) {
        jfManagerProfile.setVisible(false);
        Main.ManagerPage= new ManagerHome();
    }

    private void btnAssignOrderActionPerformed(ActionEvent e) {
        jfManagerProfile.setVisible(false);
        Main.assignOrderPage= new AssignOrder();
    }

    private void btnOverview2ActionPerformed(ActionEvent e) {
        jfManagerProfile.setVisible(false);
        Main.editOrder= new EditOrder();
        Main.editOrder.getJfEditOrder().setVisible(true);
    }

    private void btnOverviewActionPerformed(ActionEvent e) {
        jfManagerProfile.setVisible(false);
        Main.orderOverview= new OrderOverview();
        Main.orderOverview.getJfOrderOverview().setVisible(true);
    }
    
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        jfManagerProfile = new JFrame();
        sPnlManager = new JPanel();
        lblMHomeTitle = new JLabel();
        lblManagerName = new JLabel();
        btnOrder = new JButton();
        btnAssignOrder = new JButton();
        btnOverview = new JButton();
        btnReport = new JButton();
        btnFeedback = new JButton();
        btnLogout = new JButton();
        panel1 = new JPanel();
        lblPw = new JLabel();
        txtPw = new JTextField();
        btnSave = new JButton();
        pnlTitle = new JPanel();
        lblTitle = new JLabel();
        lblPh = new JLabel();
        txtIPh = new JTextField();
        lblIC3 = new JLabel();
        lblName = new JLabel();

        //======== jfManagerProfile ========
        {
            jfManagerProfile.setTitle("Manager");
            jfManagerProfile.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            var jfManagerProfileContentPane = jfManagerProfile.getContentPane();
            jfManagerProfileContentPane.setLayout(null);

            //======== sPnlManager ========
            {
                sPnlManager.setBackground(new Color(21, 29, 65));
                sPnlManager.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax
                .swing.border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing
                .border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.
                Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.red
                ),sPnlManager. getBorder()));sPnlManager. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override
                public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.getPropertyName(
                )))throw new RuntimeException();}});
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

                //---- btnReport ----
                btnReport.setText("Edit Order");
                btnReport.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnReport.addActionListener(e -> btnOverview2ActionPerformed(e));
                sPnlManager.add(btnReport);
                btnReport.setBounds(45, 340, 145, 45);

                //---- btnFeedback ----
                btnFeedback.setText("Feedback");
                btnFeedback.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnFeedback.addActionListener(e -> btnFeedbackActionPerformed(e));
                sPnlManager.add(btnFeedback);
                btnFeedback.setBounds(45, 405, 145, 45);

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
            jfManagerProfileContentPane.add(sPnlManager);
            sPnlManager.setBounds(0, 0, 255, 760);

            //======== panel1 ========
            {
                panel1.setBackground(Color.white);
                panel1.setLayout(null);

                //---- lblPw ----
                lblPw.setText("Password");
                lblPw.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblPw.setForeground(Color.black);
                panel1.add(lblPw);
                lblPw.setBounds(75, 275, 180, 45);

                //---- txtPw ----
                txtPw.setBackground(Color.white);
                txtPw.setCaretColor(Color.black);
                txtPw.setForeground(Color.black);
                txtPw.setFont(txtPw.getFont().deriveFont(txtPw.getFont().getSize() + 8f));
                txtPw.setDisabledTextColor(Color.black);
                txtPw.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        txtPwKeyTyped(e);
                    }
                });
                panel1.add(txtPw);
                txtPw.setBounds(315, 275, 255, 40);

                //---- btnSave ----
                btnSave.setText("Save");
                btnSave.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
                btnSave.setBackground(Color.black);
                btnSave.setForeground(Color.white);
                btnSave.addActionListener(e -> btnOrderProceed1ActionPerformed(e));
                panel1.add(btnSave);
                btnSave.setBounds(205, 500, 170, 65);

                //======== pnlTitle ========
                {
                    pnlTitle.setBackground(new Color(186, 201, 245));
                    pnlTitle.setLayout(null);

                    //---- lblTitle ----
                    lblTitle.setText("Profile");
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

                //---- lblPh ----
                lblPh.setText("Phone Number");
                lblPh.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblPh.setForeground(Color.black);
                panel1.add(lblPh);
                lblPh.setBounds(75, 370, 180, 45);

                //---- txtIPh ----
                txtIPh.setBackground(Color.white);
                txtIPh.setCaretColor(Color.black);
                txtIPh.setForeground(Color.black);
                txtIPh.setFont(txtIPh.getFont().deriveFont(txtIPh.getFont().getSize() + 8f));
                txtIPh.setDisabledTextColor(Color.black);
                txtIPh.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        txtIPhKeyPressed(e);
                    }
                    @Override
                    public void keyTyped(KeyEvent e) {
                        txtIPhKeyTyped(e);
                    }
                });
                panel1.add(txtIPh);
                txtIPh.setBounds(315, 370, 255, 40);

                //---- lblIC3 ----
                lblIC3.setText("Name");
                lblIC3.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblIC3.setForeground(Color.black);
                panel1.add(lblIC3);
                lblIC3.setBounds(75, 185, 180, 45);

                //---- lblName ----
                lblName.setText("Name");
                lblName.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblName.setForeground(Color.black);
                panel1.add(lblName);
                lblName.setBounds(315, 185, 180, 45);

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
            jfManagerProfileContentPane.add(panel1);
            panel1.setBounds(255, 0, panel1.getPreferredSize().width, 760);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < jfManagerProfileContentPane.getComponentCount(); i++) {
                    Rectangle bounds = jfManagerProfileContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = jfManagerProfileContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                jfManagerProfileContentPane.setMinimumSize(preferredSize);
                jfManagerProfileContentPane.setPreferredSize(preferredSize);
            }
            jfManagerProfile.pack();
            jfManagerProfile.setLocationRelativeTo(jfManagerProfile.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private static JFrame jfManagerProfile;
    private static JPanel sPnlManager;
    private static JLabel lblMHomeTitle;
    private static JLabel lblManagerName;
    private static JButton btnOrder;
    private static JButton btnAssignOrder;
    private static JButton btnOverview;
    private static JButton btnReport;
    private static JButton btnFeedback;
    private static JButton btnLogout;
    private JPanel panel1;
    private JLabel lblPw;
    private static JTextField txtPw;
    private static JButton btnSave;
    private JPanel pnlTitle;
    protected static JLabel lblTitle;
    private JLabel lblPh;
    private static JTextField txtIPh;
    private JLabel lblIC3;
    private JLabel lblName;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
