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
public class Manager_profile {
    public Manager_profile() {

        initComponents();
        loadTable();
        jfManagerProfile.setVisible(true);
    }

    public void loadTable() {
        Manager m = new Manager();
        m.loadStaff();

        lblName.setText(m.getName());
        txtPw.setText(m.getPassword());
        txtIPh.setText(m.getPhone());

        jfManagerProfile.setVisible(false);

    }

    private void btnAssignOrderActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void txtICKeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void txtICKeyTyped(KeyEvent e) {
        // TODO add your code here
    }

    private void txtStreetKeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void txtCityKeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void txtCityKeyTyped(KeyEvent e) {
        // TODO add your code here
    }

    private void btnOrderProceed1ActionPerformed(ActionEvent e) {
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to edit " +
                lblName.getText().toString() + "?", " Confirmation", 0);
        if (confirm == 0) {
            for (int i = 0; i < Manager.managerAl.size(); i++) {
                if (Manager.managerAl.get(i).getPhone().equals(txtIPh.getText().toString())) {
                    Manager.managerAl.get(i).setName(lblName.getText().toString());
                    Manager.managerAl.get(i).setPhone(txtIPh.getText().toString());
                    Manager.managerAl.get(i).setPassword(txtPw.getText().toString());
                    JOptionPane.showMessageDialog(null, "Successfully edited" +
                            " " + Manager.managerAl.get(i).getName());
                    Manager o = new Manager();
                    o.writeFile();
                    break;
                }else {
                    System.out.println("sad");
                }
            }
        }
    }

    private void txtPkgWeightKeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void txtPkgWeightKeyTyped(KeyEvent e) {
        // TODO add your code here
    }

    private void txtPostKeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void txtPostKeyTyped(KeyEvent e) {
        // TODO add your code here
    }

    public JLabel getLblManagerName() {
        return lblManagerName;
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        jfManagerProfile = new JFrame();
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
        btnProfile = new JButton();
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
            var jfManagerProfileContentPane = jfManagerProfile.getContentPane();
            jfManagerProfileContentPane.setLayout(null);

            //======== sPnlManager ========
            {
                sPnlManager.setBackground(new Color(21, 29, 65));
                sPnlManager.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing
                        .border.EmptyBorder(0, 0, 0, 0), "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax.swing.border.TitledBorder
                        .CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("D\u0069al\u006fg", java.
                        awt.Font.BOLD, 12), java.awt.Color.red), sPnlManager.getBorder()))
                ;
                sPnlManager.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                    @Override
                    public void propertyChange(java.beans.PropertyChangeEvent e
                    ) {
                        if ("\u0062or\u0064er".equals(e.getPropertyName())) throw new RuntimeException();
                    }
                })
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
                btnLogout.setBounds(45, 620, 145, 45);

                //---- btnAssignOrder ----
                btnAssignOrder.setText("Assign Order");
                btnAssignOrder.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnAssignOrder.addActionListener(e -> btnAssignOrderActionPerformed(e));
                sPnlManager.add(btnAssignOrder);
                btnAssignOrder.setBounds(45, 300, 145, 45);

                //---- btnProfile ----
                btnProfile.setText("Profile");
                btnProfile.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                sPnlManager.add(btnProfile);
                btnProfile.setBounds(45, 560, 145, 45);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for (int i = 0; i < sPnlManager.getComponentCount(); i++) {
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
                    public void keyPressed(KeyEvent e) {
                        txtICKeyPressed(e);
                    }

                    @Override
                    public void keyTyped(KeyEvent e) {
                        txtICKeyTyped(e);
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
                        for (int i = 0; i < pnlTitle.getComponentCount(); i++) {
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
                        txtICKeyPressed(e);
                    }

                    @Override
                    public void keyTyped(KeyEvent e) {
                        txtICKeyTyped(e);
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
                    for (int i = 0; i < panel1.getComponentCount(); i++) {
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
                for (int i = 0; i < jfManagerProfileContentPane.getComponentCount(); i++) {
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
    private JFrame jfManagerProfile;
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
    private static JButton btnProfile;
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
