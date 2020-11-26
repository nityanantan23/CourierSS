/*
 * Created by JFormDesigner on Thu Nov 26 18:34:21 SGT 2020
 */

package courier;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class Rider_profile {
    public Rider_profile() {
        initComponents();
        loadTable();
        jfRiderProfile.setVisible(true);
    }

    public void loadTable() {
        Rider m = new Rider();
        m.loadStaff();

        lblName.setText(m.getName());
        txtPw.setText(m.getPassword());
        txtIPh.setText(m.getPhone());

        jfRiderProfile.setVisible(false);

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

    private void btnOrderProceed1ActionPerformed(ActionEvent e) {
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to edit " +
                lblName.getText().toString() + "?", " Confirmation", 0);
        if (confirm == 0) {
            for (int i = 0; i < Rider.getRiderAL().size(); i++) {
                if (Rider.getRiderAL().get(i).getPhone().equals(txtIPh.getText().toString())) {
                    Rider.getRiderAL().get(i).setName(lblName.getText().toString());
                    Rider.getRiderAL().get(i).setPhone(txtIPh.getText().toString());
                    Rider.getRiderAL().get(i).setPassword(txtPw.getText().toString());
                    JOptionPane.showMessageDialog(null, "Successfully edited" +
                            " " + Rider.getRiderAL().get(i).getName());
                    Rider o = new Rider();
                    o.writeFile();
                    break;
                }else {
                    System.out.println("sad");
                }
            }
        }
    }

    private void btnUpdateStatusActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void tblRiderOrderMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    public JLabel getLblManagerName() {
        return lblManagerName;
    }

    public JButton getBtnUpdateStatus() {
        return btnUpdateStatus;
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        jfRiderProfile = new JFrame();
        sPnlManager = new JPanel();
        lblMHomeTitle = new JLabel();
        lblManagerName = new JLabel();
        btnOverview = new JButton();
        btnFeedback = new JButton();
        btnLogout = new JButton();
        btnProfile = new JButton();
        panel1 = new JPanel();
        btnUpdateStatus = new JButton();
        pnlTitle = new JPanel();
        lblTitle = new JLabel();
        lblPw = new JLabel();
        txtPw = new JTextField();
        btnSave = new JButton();
        lblPh = new JLabel();
        txtIPh = new JTextField();
        lblIC3 = new JLabel();
        lblName = new JLabel();

        //======== jfRiderProfile ========
        {
            var jfRiderProfileContentPane = jfRiderProfile.getContentPane();
            jfRiderProfileContentPane.setLayout(null);

            //======== sPnlManager ========
            {
                sPnlManager.setBackground(new Color(12, 36, 97));
                sPnlManager.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
                0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
                . BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
                red) ,sPnlManager. getBorder( )) ); sPnlManager. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
                beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
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

                //---- btnOverview ----
                btnOverview.setText("Delivery Order");
                btnOverview.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                sPnlManager.add(btnOverview);
                btnOverview.setBounds(45, 180, 145, 45);

                //---- btnFeedback ----
                btnFeedback.setText("Setting");
                btnFeedback.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                sPnlManager.add(btnFeedback);
                btnFeedback.setBounds(45, 250, 145, 45);

                //---- btnLogout ----
                btnLogout.setText("Logout");
                btnLogout.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                sPnlManager.add(btnLogout);
                btnLogout.setBounds(45, 460, 145, 45);

                //---- btnProfile ----
                btnProfile.setText("Profile");
                btnProfile.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                sPnlManager.add(btnProfile);
                btnProfile.setBounds(45, 320, 145, 45);

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
            jfRiderProfileContentPane.add(sPnlManager);
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
                    lblTitle.setText("Profile");
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

                //---- lblPw ----
                lblPw.setText("Password");
                lblPw.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblPw.setForeground(Color.black);
                panel1.add(lblPw);
                lblPw.setBounds(60, 230, 180, 45);

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
                txtPw.setBounds(300, 230, 255, 40);

                //---- btnSave ----
                btnSave.setText("Save");
                btnSave.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
                btnSave.setBackground(Color.black);
                btnSave.setForeground(Color.white);
                btnSave.addActionListener(e -> btnOrderProceed1ActionPerformed(e));
                panel1.add(btnSave);
                btnSave.setBounds(190, 455, 170, 65);

                //---- lblPh ----
                lblPh.setText("Phone Number");
                lblPh.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblPh.setForeground(Color.black);
                panel1.add(lblPh);
                lblPh.setBounds(60, 325, 180, 45);

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
                txtIPh.setBounds(300, 325, 255, 40);

                //---- lblIC3 ----
                lblIC3.setText("Name");
                lblIC3.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblIC3.setForeground(Color.black);
                panel1.add(lblIC3);
                lblIC3.setBounds(60, 140, 180, 45);

                //---- lblName ----
                lblName.setText("Name");
                lblName.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblName.setForeground(Color.black);
                panel1.add(lblName);
                lblName.setBounds(300, 140, 180, 45);

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
            jfRiderProfileContentPane.add(panel1);
            panel1.setBounds(255, 0, panel1.getPreferredSize().width, 760);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < jfRiderProfileContentPane.getComponentCount(); i++) {
                    Rectangle bounds = jfRiderProfileContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = jfRiderProfileContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                jfRiderProfileContentPane.setMinimumSize(preferredSize);
                jfRiderProfileContentPane.setPreferredSize(preferredSize);
            }
            jfRiderProfile.pack();
            jfRiderProfile.setLocationRelativeTo(jfRiderProfile.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JFrame jfRiderProfile;
    private static JPanel sPnlManager;
    private static JLabel lblMHomeTitle;
    private static JLabel lblManagerName;
    private static JButton btnOverview;
    private static JButton btnFeedback;
    private static JButton btnLogout;
    private static JButton btnProfile;
    private JPanel panel1;
    private static JButton btnUpdateStatus;
    private JPanel pnlTitle;
    protected static JLabel lblTitle;
    private JLabel lblPw;
    private static JTextField txtPw;
    private static JButton btnSave;
    private JLabel lblPh;
    private static JTextField txtIPh;
    private JLabel lblIC3;
    private JLabel lblName;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
