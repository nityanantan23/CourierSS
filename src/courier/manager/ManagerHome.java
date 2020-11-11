/*
 * Created by JFormDesigner on Thu Nov 12 03:30:04 SGT 2020
 */

package courier.manager;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class ManagerHome {
    public ManagerHome() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        jfManager = new JFrame();
        pnlManager = new JPanel();
        sPnlManager = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        btnLogout = new JButton();
        sclManager = new JScrollBar();
        label3 = new JLabel();

        //======== jfManager ========
        {
            jfManager.setBackground(new Color(204, 204, 204));
            jfManager.setTitle("Manager Portal");
            var jfManagerContentPane = jfManager.getContentPane();
            jfManagerContentPane.setLayout(null);

            //======== pnlManager ========
            {
                pnlManager.setBackground(Color.white);
                pnlManager.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing
                .border.EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border.TitledBorder
                .CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.
                awt.Font.BOLD,12),java.awt.Color.red),pnlManager. getBorder()))
                ;pnlManager. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
                ){if("bord\u0065r".equals(e.getPropertyName()))throw new RuntimeException();}})
                ;
                pnlManager.setLayout(null);

                //======== sPnlManager ========
                {
                    sPnlManager.setBackground(new Color(0, 0, 51));
                    sPnlManager.setLayout(null);

                    //---- label1 ----
                    label1.setText("Manager Portal");
                    label1.setFont(new Font("Myanmar Text", Font.BOLD, 26));
                    label1.setForeground(Color.white);
                    sPnlManager.add(label1);
                    label1.setBounds(20, 15, 195, 50);

                    //---- label2 ----
                    label2.setText("Loges");
                    label2.setFont(new Font("Myanmar Text", Font.BOLD, 26));
                    label2.setForeground(Color.white);
                    sPnlManager.add(label2);
                    label2.setBounds(85, 100, 80, 35);

                    //---- button1 ----
                    button1.setText("Order");
                    button1.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                    sPnlManager.add(button1);
                    button1.setBounds(45, 160, 145, 45);

                    //---- button2 ----
                    button2.setText("text");
                    button2.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                    sPnlManager.add(button2);
                    button2.setBounds(45, 230, 145, 45);

                    //---- button3 ----
                    button3.setText("text");
                    button3.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                    sPnlManager.add(button3);
                    button3.setBounds(45, 300, 145, 45);

                    //---- button4 ----
                    button4.setText("text");
                    button4.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                    sPnlManager.add(button4);
                    button4.setBounds(45, 370, 145, 45);

                    //---- button5 ----
                    button5.setText("text");
                    button5.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                    sPnlManager.add(button5);
                    button5.setBounds(45, 435, 145, 45);

                    //---- btnLogout ----
                    btnLogout.setText("Logout");
                    btnLogout.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                    sPnlManager.add(btnLogout);
                    btnLogout.setBounds(45, 500, 145, 45);

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
                pnlManager.add(sPnlManager);
                sPnlManager.setBounds(0, 0, 255, 610);
                pnlManager.add(sclManager);
                sclManager.setBounds(1095, 0, 10, 605);

                //---- label3 ----
                label3.setText("Order");
                label3.setFont(new Font("Myanmar Text", Font.BOLD, 46));
                label3.setForeground(Color.black);
                label3.setAlignmentY(0.0F);
                pnlManager.add(label3);
                label3.setBounds(300, 35, 155, 55);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < pnlManager.getComponentCount(); i++) {
                        Rectangle bounds = pnlManager.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = pnlManager.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    pnlManager.setMinimumSize(preferredSize);
                    pnlManager.setPreferredSize(preferredSize);
                }
            }
            jfManagerContentPane.add(pnlManager);
            pnlManager.setBounds(0, 0, 1105, 610);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < jfManagerContentPane.getComponentCount(); i++) {
                    Rectangle bounds = jfManagerContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = jfManagerContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                jfManagerContentPane.setMinimumSize(preferredSize);
                jfManagerContentPane.setPreferredSize(preferredSize);
            }
            jfManager.pack();
            jfManager.setLocationRelativeTo(jfManager.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JFrame jfManager;
    private JPanel pnlManager;
    private JPanel sPnlManager;
    private JLabel label1;
    private JLabel label2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton btnLogout;
    private JScrollBar sclManager;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
