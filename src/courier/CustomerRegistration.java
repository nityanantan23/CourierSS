/*
 * Created by JFormDesigner on Fri Nov 20 01:44:54 SGT 2020
 */

package courier;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class CustomerRegistration extends GUI {
    public CustomerRegistration() {
        initComponents();
    }

    private void txtRegCusICKeyPressed(KeyEvent e) {
        super.numCheck(e,"IC",txtRegCusIC);
    }

    private void txtRegCusICKeyTyped(KeyEvent e) {
        super.lengthChecker(e,"IC",txtRegCusIC,11);
    }

    private void txtRegCNameKeyPressed(KeyEvent e) {
        super.spCharCheck(e,txtRegCName);
    }

    private void txtRegCNameKeyTyped(KeyEvent e) {
        lengthChecker(e,"Customer Name",txtRegCName,49);
    }

    private void txtRegCPhoneKeyPressed(KeyEvent e) {
        super.numCheck(e,"Phone",txtRegCPhone);
    }

    private void txtRegCPhoneKeyTyped(KeyEvent e) {
        lengthChecker(e,"Phone",txtRegCPhone,9);
    }




    public JFrame getJfCustomerRegister() {
        return jfCustomerRegister;
    }

    public JButton getBtnRegister() {
        return btnRegister;
    }

    public JButton getBtnRegisterBack() {
        return btnRegisterBack;
    }

    public JTextField getTxtRegCusIC() {
        return txtRegCusIC;
    }



    private void btnRegisterBackActionPerformed(ActionEvent e) {
        txtRegCusIC.setText("");
        txtRegCName.setText("");;
        txtRegCPhone.setText("");
        jfCustomerRegister.setVisible(false);
    }

    private void btnRegisterActionPerformed(ActionEvent e) {
        int confirm=JOptionPane.showConfirmDialog(null,"Are you sure all inputs are correct?","Confirmation",0);
        if (confirm==0){
            if(txtRegCPhone.getText().length()<10||txtRegCName.getText().length()==0||txtRegCusIC.getText().length()!=12){
                JOptionPane.showMessageDialog(null,"Please revise all inputs. All fields are required. Phone number should have more " +
                        "than 10 digits and less than or equal to 12 digits.IC must have exactly 12 digits. ","Invalid Inputs",2);
            }else {
                //todo create a writer in Person or interface that rewrite the whole file
                Customer c= new Customer(Customer.generateID(),txtRegCName.getText(),txtRegCPhone.getText()
                        ,txtRegCusIC.getText());
                Customer.getCustomerAL().add(c);
                Customer.writeLine(c);
                JOptionPane.showMessageDialog(null,"You have successfully added "+txtRegCName.getText()+".","Successful Registration",1);
                txtRegCName.setText("");
                txtRegCusIC.setText("");
                txtRegCPhone.setText("");
                jfCustomerRegister.setVisible(false);
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        jfCustomerRegister = new JFrame();
        panel2 = new JPanel();
        pnlTitleReg = new JPanel();
        lblTitle3 = new JLabel();
        txtRegCusIC = new JTextField();
        lblCIC = new JLabel();
        lblCName = new JLabel();
        lblICPhone = new JLabel();
        txtRegCName = new JTextField();
        txtRegCPhone = new JTextField();
        btnRegister = new JButton();
        btnRegisterBack = new JButton();

        //======== jfCustomerRegister ========
        {
            jfCustomerRegister.setBackground(new Color(204, 204, 204));
            jfCustomerRegister.setTitle("Manager Portal");
            jfCustomerRegister.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            jfCustomerRegister.setResizable(false);
            var jfCustomerRegisterContentPane = jfCustomerRegister.getContentPane();
            jfCustomerRegisterContentPane.setLayout(null);

            //======== panel2 ========
            {
                panel2.setBackground(Color.white);
                panel2.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
                javax.swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e",javax
                .swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java
                .awt.Font("Dialo\u0067",java.awt.Font.BOLD,12),java.awt
                .Color.red),panel2. getBorder()));panel2. addPropertyChangeListener(new java.beans.
                PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("borde\u0072".
                equals(e.getPropertyName()))throw new RuntimeException();}});
                panel2.setLayout(null);

                //======== pnlTitleReg ========
                {
                    pnlTitleReg.setBackground(new Color(186, 201, 245));
                    pnlTitleReg.setLayout(null);

                    //---- lblTitle3 ----
                    lblTitle3.setText("Customer Registration");
                    lblTitle3.setFont(new Font("Myanmar Text", Font.BOLD, 46));
                    lblTitle3.setForeground(Color.black);
                    lblTitle3.setAlignmentY(0.0F);
                    lblTitle3.setHorizontalAlignment(SwingConstants.CENTER);
                    lblTitle3.setIconTextGap(3);
                    lblTitle3.setBackground(new Color(51, 204, 255));
                    pnlTitleReg.add(lblTitle3);
                    lblTitle3.setBounds(0, 15, 510, 65);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < pnlTitleReg.getComponentCount(); i++) {
                            Rectangle bounds = pnlTitleReg.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = pnlTitleReg.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        pnlTitleReg.setMinimumSize(preferredSize);
                        pnlTitleReg.setPreferredSize(preferredSize);
                    }
                }
                panel2.add(pnlTitleReg);
                pnlTitleReg.setBounds(0, 0, 885, 80);

                //---- txtRegCusIC ----
                txtRegCusIC.setBackground(Color.white);
                txtRegCusIC.setCaretColor(Color.black);
                txtRegCusIC.setForeground(Color.black);
                txtRegCusIC.setFont(txtRegCusIC.getFont().deriveFont(txtRegCusIC.getFont().getSize() + 8f));
                txtRegCusIC.setDisabledTextColor(Color.black);
                txtRegCusIC.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        txtRegCusICKeyPressed(e);
                    }
                    @Override
                    public void keyTyped(KeyEvent e) {
                        txtRegCusICKeyTyped(e);
                    }
                });
                panel2.add(txtRegCusIC);
                txtRegCusIC.setBounds(310, 130, 195, 40);

                //---- lblCIC ----
                lblCIC.setText("Customer IC");
                lblCIC.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblCIC.setForeground(Color.black);
                panel2.add(lblCIC);
                lblCIC.setBounds(90, 125, 180, 45);

                //---- lblCName ----
                lblCName.setText("Name");
                lblCName.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblCName.setForeground(Color.black);
                panel2.add(lblCName);
                lblCName.setBounds(90, 220, 180, 45);

                //---- lblICPhone ----
                lblICPhone.setText("Phone");
                lblICPhone.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblICPhone.setForeground(Color.black);
                panel2.add(lblICPhone);
                lblICPhone.setBounds(90, 315, 180, 45);

                //---- txtRegCName ----
                txtRegCName.setBackground(Color.white);
                txtRegCName.setCaretColor(Color.black);
                txtRegCName.setForeground(Color.black);
                txtRegCName.setFont(txtRegCName.getFont().deriveFont(txtRegCName.getFont().getSize() + 8f));
                txtRegCName.setDisabledTextColor(Color.black);
                txtRegCName.setNextFocusableComponent(lblICPhone);
                txtRegCName.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        txtRegCNameKeyPressed(e);
                    }
                    @Override
                    public void keyTyped(KeyEvent e) {
                        txtRegCNameKeyTyped(e);
                    }
                });
                panel2.add(txtRegCName);
                txtRegCName.setBounds(310, 225, 405, 40);

                //---- txtRegCPhone ----
                txtRegCPhone.setBackground(Color.white);
                txtRegCPhone.setCaretColor(Color.black);
                txtRegCPhone.setForeground(Color.black);
                txtRegCPhone.setFont(txtRegCPhone.getFont().deriveFont(txtRegCPhone.getFont().getSize() + 8f));
                txtRegCPhone.setDisabledTextColor(Color.black);
                txtRegCPhone.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        txtRegCPhoneKeyPressed(e);
                    }
                    @Override
                    public void keyTyped(KeyEvent e) {
                        txtRegCPhoneKeyTyped(e);
                    }
                });
                panel2.add(txtRegCPhone);
                txtRegCPhone.setBounds(310, 310, 255, 40);

                //---- btnRegister ----
                btnRegister.setText("Register");
                btnRegister.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
                btnRegister.setBackground(Color.black);
                btnRegister.setForeground(Color.white);
                btnRegister.addActionListener(e -> btnRegisterActionPerformed(e));
                panel2.add(btnRegister);
                btnRegister.setBounds(615, 440, 170, 65);

                //---- btnRegisterBack ----
                btnRegisterBack.setText("Back");
                btnRegisterBack.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
                btnRegisterBack.setBackground(Color.black);
                btnRegisterBack.setForeground(Color.white);
                btnRegisterBack.addActionListener(e -> btnRegisterBackActionPerformed(e));
                panel2.add(btnRegisterBack);
                btnRegisterBack.setBounds(100, 445, 170, 65);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel2.getComponentCount(); i++) {
                        Rectangle bounds = panel2.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel2.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel2.setMinimumSize(preferredSize);
                    panel2.setPreferredSize(preferredSize);
                }
            }
            jfCustomerRegisterContentPane.add(panel2);
            panel2.setBounds(0, 0, 885, 550);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < jfCustomerRegisterContentPane.getComponentCount(); i++) {
                    Rectangle bounds = jfCustomerRegisterContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = jfCustomerRegisterContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                jfCustomerRegisterContentPane.setMinimumSize(preferredSize);
                jfCustomerRegisterContentPane.setPreferredSize(preferredSize);
            }
            jfCustomerRegister.pack();
            jfCustomerRegister.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private static JFrame jfCustomerRegister;
    private JPanel panel2;
    private JPanel pnlTitleReg;
    protected static JLabel lblTitle3;
    private static JTextField txtRegCusIC;
    private JLabel lblCIC;
    private JLabel lblCName;
    private JLabel lblICPhone;
    private JTextField txtRegCName;
    private JTextField txtRegCPhone;
    private static JButton btnRegister;
    private static JButton btnRegisterBack;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
