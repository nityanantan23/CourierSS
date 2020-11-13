/*
 * Created by JFormDesigner on Wed Nov 11 22:55:45 SGT 2020
 */

package courier;

import courier.manager.ManagerHome;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class StaffLogin {
    public StaffLogin() {
        Admin a= new Admin();
        Manager m= new Manager();
        Rider r= new Rider();
        a.loadStaff();
        m.loadStaff();
        r.loadStaff();
        initComponents();
        jfLogin.setVisible(true);
    }

    private void btnLoginActionPerformed(ActionEvent e) {
        // TODO add your code here
        String id= txtUser.getText();
        String pw= String.valueOf(txtPw.getPassword());
        Staff.credentialChecker(id,pw);

    }



    public static void resetField(){
        txtUser.setText("");
        txtPw.setText("");
        txtUser.grabFocus();
    }



    private void txtUserKeyTyped(KeyEvent e) {
        if (txtUser.getText().length()>10){
            JOptionPane.showMessageDialog(null,"Username does not exceed 10 character.Please enter the correct username.","Invalid Username",2);
            e.consume();
            resetField();
        }
    }

    private void txtPwKeyTyped(KeyEvent e) {
        if (txtPw.getText().length()>16){
            JOptionPane.showMessageDialog(null,"Password does not exceed 16 character.Please enter the correct password.","Invalid Password",2);
            e.consume();
            resetField();
        }
    }

    private void txtUserKeyPressed(KeyEvent e) {
        if (e.getKeyCode()==32){
            JOptionPane.showMessageDialog(null,"User should not contain space or tab.Please enter the correct username.","Invalid Username",2);
            e.consume();
            resetField();
        }else if (e.getKeyCode()==9){
            txtUser.transferFocus();
            e.consume();
        }

    }

    private void txtPwKeyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            String id= txtUser.getText();
            String pw= String.valueOf(txtPw.getPassword());
            Staff.credentialChecker(id,pw);
            resetField();
        }

    }

    public static JFrame getJfLogin() {
        return jfLogin;
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        jfLogin = new JFrame();
        panel1 = new JPanel();
        lblLoginTitle = new JLabel();
        lblUsername = new JLabel();
        lblPassword = new JLabel();
        txtUser = new JTextArea();
        txtPw = new JPasswordField();
        btnLogin = new JButton();
        lblPic = new JLabel();
        lblPic2 = new JLabel();

        //======== jfLogin ========
        {
            jfLogin.setBackground(new Color(198, 206, 211));
            jfLogin.setTitle("Staff Login");
            jfLogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jfLogin.setFocusTraversalPolicyProvider(true);
            var jfLoginContentPane = jfLogin.getContentPane();
            jfLoginContentPane.setLayout(null);

            //======== panel1 ========
            {
                panel1.setBackground(Color.white);
                panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder
                ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border
                .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt
                . Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void
                propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( )
                ;} } );
                panel1.setLayout(null);

                //---- lblLoginTitle ----
                lblLoginTitle.setText("Staff Login");
                lblLoginTitle.setFont(new Font("Montserrat Light", Font.BOLD, 69));
                lblLoginTitle.setForeground(new Color(51, 51, 51));
                lblLoginTitle.setBackground(Color.black);
                panel1.add(lblLoginTitle);
                lblLoginTitle.setBounds(195, 30, 475, 125);

                //---- lblUsername ----
                lblUsername.setText("Username");
                lblUsername.setFont(new Font("Montserrat Light", Font.PLAIN, 38));
                lblUsername.setForeground(new Color(102, 102, 102));
                panel1.add(lblUsername);
                lblUsername.setBounds(105, 200, 245, 60);

                //---- lblPassword ----
                lblPassword.setText("Password");
                lblPassword.setFont(new Font("Montserrat Light", Font.PLAIN, 38));
                lblPassword.setForeground(new Color(102, 102, 102));
                panel1.add(lblPassword);
                lblPassword.setBounds(105, 300, 245, 60);

                //---- txtUser ----
                txtUser.setBackground(new Color(239, 234, 234));
                txtUser.setBorder(new LineBorder(Color.black, 3, true));
                txtUser.setFont(new Font("Montserrat Light", Font.PLAIN, 31));
                txtUser.setForeground(Color.black);
                txtUser.setToolTipText("Username");
                txtUser.setMargin(new Insets(1, 1, 1, 1));
                txtUser.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                txtUser.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        txtUserKeyPressed(e);
                    }
                    @Override
                    public void keyTyped(KeyEvent e) {
                        txtUserKeyTyped(e);
                    }
                });
                panel1.add(txtUser);
                txtUser.setBounds(430, 210, 285, 50);

                //---- txtPw ----
                txtPw.setBackground(new Color(221, 226, 227));
                txtPw.setBorder(new LineBorder(Color.black, 3, true));
                txtPw.setFont(new Font("Montserrat Light", Font.PLAIN, 31));
                txtPw.setForeground(Color.black);
                txtPw.setToolTipText("Password");
                txtPw.setMargin(new Insets(10, 10, 10, 10));
                txtPw.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        txtPwKeyPressed(e);
                    }
                    @Override
                    public void keyTyped(KeyEvent e) {
                        txtPwKeyTyped(e);
                    }
                });
                panel1.add(txtPw);
                txtPw.setBounds(430, 310, 290, 50);

                //---- btnLogin ----
                btnLogin.setText("Sign In");
                btnLogin.setFont(new Font("Montserrat Light", Font.BOLD, 30));
                btnLogin.setForeground(Color.black);
                btnLogin.addActionListener(e -> btnLoginActionPerformed(e));
                panel1.add(btnLogin);
                btnLogin.setBounds(325, 415, 235, 65);

                //---- lblPic ----
                lblPic.setIcon(new ImageIcon("D:\\OneDrive - Asia Pacific University\\Bachelor\\OODJ\\Lab\\CourierSS\\Pic\\bg-01.png"));
                panel1.add(lblPic);
                lblPic.setBounds(570, 365, 355, 270);

                //---- lblPic2 ----
                lblPic2.setIcon(new ImageIcon("D:\\OneDrive - Asia Pacific University\\Bachelor\\OODJ\\Lab\\CourierSS\\Pic\\logo-01.png"));
                panel1.add(lblPic2);
                lblPic2.setBounds(10, 10, 150, 155);
            }
            jfLoginContentPane.add(panel1);
            panel1.setBounds(0, 0, 920, 625);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < jfLoginContentPane.getComponentCount(); i++) {
                    Rectangle bounds = jfLoginContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = jfLoginContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                jfLoginContentPane.setMinimumSize(preferredSize);
                jfLoginContentPane.setPreferredSize(preferredSize);
            }
            jfLogin.pack();
            jfLogin.setLocationRelativeTo(jfLogin.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private static JFrame jfLogin;
    private static JPanel panel1;
    private static JLabel lblLoginTitle;
    private static JLabel lblUsername;
    private static JLabel lblPassword;
    private static JTextArea txtUser;
    private static JPasswordField txtPw;
    private static JButton btnLogin;
    private static JLabel lblPic;
    private static JLabel lblPic2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
