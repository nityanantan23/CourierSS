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
public class Rider_profile extends GUI {
    public Rider_profile() {
        initComponents();
        loadTable((Rider)StaffLogin.loggedPerson);
        jfRiderProfile.setVisible(true);

    }

    public void loadTable(Rider m) {
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

        if (txtIPh.getText().length()<8||txtPw.getText().length()<8){
            JOptionPane.showMessageDialog(null,"Phone number must greater than 8 digits and Password must greater than 7 digit.","Invalid Input",2);
        }else {
            if (confirm == 0) {
                StaffLogin.loggedPerson.setPhone(txtIPh.getText());
                StaffLogin.loggedPerson.setPassword(txtPw.getText());
                Rider r= new Rider();
                r.writeFile();
                JOptionPane.showMessageDialog(null,"Successfully modified the data.","Modification Success",1);
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

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    private void btnLogoutActionPerformed(ActionEvent e) {
        jfRiderProfile.setVisible(false);
        Main.LoginPage= new StaffLogin();
    }

    private void btnOverviewActionPerformed(ActionEvent e) {
        jfRiderProfile.setVisible(false);
        Main.riderHome= new RiderHome();
        Main.riderHome.setVisible(true);
    }

    private void txtPwKeyPressed(KeyEvent e) {
        lengthChecker(e,"Phone",txtPw,12);
    }

    private void txtIPhKeyTyped(KeyEvent e) {
        lengthChecker(e,"Phone",txtIPh,10);
    }

    private void txtIPhKeyPressed(KeyEvent e) {
        super.numCheck(e,"Phone",txtIPh);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        jfRiderProfile = new JFrame();
        sPnlManager = new JPanel();
        lblMHomeTitle = new JLabel();
        lblManagerName = new JLabel();
        btnOverview = new JButton();
        btnLogout = new JButton();
        panel1 = new JPanel();
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
            jfRiderProfile.setTitle("Rider Profile");
            jfRiderProfile.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            var jfRiderProfileContentPane = jfRiderProfile.getContentPane();
            jfRiderProfileContentPane.setLayout(null);

            //======== sPnlManager ========
            {
                sPnlManager.setBackground(new Color(12, 36, 97));
                sPnlManager.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
                ( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing. border
                . TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
                . Color. red) ,sPnlManager. getBorder( )) ); sPnlManager. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
                propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
                ; }} );
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
                btnOverview.addActionListener(e -> btnOverviewActionPerformed(e));
                sPnlManager.add(btnOverview);
                btnOverview.setBounds(25, 220, 180, 45);

                //---- btnLogout ----
                btnLogout.setText("Logout");
                btnLogout.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnLogout.addActionListener(e -> btnLogoutActionPerformed(e));
                sPnlManager.add(btnLogout);
                btnLogout.setBounds(40, 495, 145, 45);

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
                        txtPwKeyPressed(e);
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
                btnSave.setBounds(260, 475, 170, 65);

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
                        txtIPhKeyPressed(e);
                    }
                    @Override
                    public void keyTyped(KeyEvent e) {
                        txtIPhKeyTyped(e);
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
    private static JButton btnLogout;
    private JPanel panel1;
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
