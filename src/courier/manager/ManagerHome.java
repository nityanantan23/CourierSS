/*
 * Created by JFormDesigner on Thu Nov 12 03:30:04 SGT 2020
 */

package courier.manager;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class ManagerHome {
    public ManagerHome() {
        initComponents();

    }

    public static JFrame getJfManager() {
        return jfManager;
    }

    public static JLabel getLblManagerName() {
        return lblManagerName;
    }

    private void txtUserKeyTyped(KeyEvent e) {
        // TODO add your code here
    }

    private void txtUserKeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    public JComboBox<String> getCmbType() {
        return cmbType;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        jfManager = new JFrame();
        pnlManager = new JPanel();
        sPnlManager = new JPanel();
        lblMHomeTitle = new JLabel();
        lblManagerName = new JLabel();
        btnOverview = new JButton();
        btnOrder = new JButton();
        btnRider = new JButton();
        btnReport = new JButton();
        btnFeedback = new JButton();
        btnLogout = new JButton();
        panel1 = new JPanel();
        lblTitle = new JLabel();
        lblID = new JLabel();
        lblType = new JLabel();
        lblIC = new JLabel();
        lblID2 = new JLabel();
        cmbType = new JComboBox<>();

        //======== jfManager ========
        {
            jfManager.setBackground(new Color(204, 204, 204));
            jfManager.setTitle("Manager Portal");
            jfManager.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            var jfManagerContentPane = jfManager.getContentPane();
            jfManagerContentPane.setLayout(null);

            //======== pnlManager ========
            {
                pnlManager.setBackground(Color.white);
                pnlManager.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder( 0
                , 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
                , new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,
                pnlManager. getBorder( )) ); pnlManager. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
                ) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
                pnlManager.setLayout(null);

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
                    lblManagerName.setBounds(25, 75, 200, 60);

                    //---- btnOverview ----
                    btnOverview.setText("Overview");
                    btnOverview.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                    sPnlManager.add(btnOverview);
                    btnOverview.setBounds(45, 160, 145, 45);

                    //---- btnOrder ----
                    btnOrder.setText("Order");
                    btnOrder.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                    sPnlManager.add(btnOrder);
                    btnOrder.setBounds(45, 235, 145, 45);

                    //---- btnRider ----
                    btnRider.setText("Rider");
                    btnRider.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                    sPnlManager.add(btnRider);
                    btnRider.setBounds(45, 300, 145, 45);

                    //---- btnReport ----
                    btnReport.setText("Report");
                    btnReport.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                    sPnlManager.add(btnReport);
                    btnReport.setBounds(45, 370, 145, 45);

                    //---- btnFeedback ----
                    btnFeedback.setText("Feedback");
                    btnFeedback.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                    sPnlManager.add(btnFeedback);
                    btnFeedback.setBounds(45, 435, 145, 45);

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

                //======== panel1 ========
                {
                    panel1.setBackground(new Color(186, 201, 245));
                    panel1.setLayout(null);

                    //---- lblTitle ----
                    lblTitle.setText("Order Form");
                    lblTitle.setFont(new Font("Myanmar Text", Font.BOLD, 46));
                    lblTitle.setForeground(Color.black);
                    lblTitle.setAlignmentY(0.0F);
                    lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
                    lblTitle.setIconTextGap(3);
                    lblTitle.setBackground(new Color(51, 204, 255));
                    panel1.add(lblTitle);
                    lblTitle.setBounds(20, 20, 270, 65);

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
                pnlManager.add(panel1);
                panel1.setBounds(255, 0, 850, 80);

                //---- lblID ----
                lblID.setText("Order ID");
                lblID.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblID.setForeground(Color.black);
                pnlManager.add(lblID);
                lblID.setBounds(new Rectangle(new Point(295, 95), lblID.getPreferredSize()));

                //---- lblType ----
                lblType.setText("Order Type");
                lblType.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblType.setForeground(Color.black);
                pnlManager.add(lblType);
                lblType.setBounds(310, 180, 135, 32);

                //---- lblIC ----
                lblIC.setText("Customer IC");
                lblIC.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblIC.setForeground(Color.black);
                pnlManager.add(lblIC);
                lblIC.setBounds(310, 240, 180, 45);

                //---- lblID2 ----
                lblID2.setText("Order ID");
                lblID2.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblID2.setForeground(Color.black);
                pnlManager.add(lblID2);
                lblID2.setBounds(455, 95, 99, 32);

                //---- cmbType ----
                cmbType.setFont(cmbType.getFont().deriveFont(cmbType.getFont().getSize() + 9f));
                cmbType.setBackground(new Color(235, 232, 232));
                cmbType.setMaximumRowCount(2);
                cmbType.setModel(new DefaultComboBoxModel<>(new String[] {
                    "Non Pickup",
                    "Pickup"
                }));
                cmbType.setForeground(new Color(86, 83, 83));
                pnlManager.add(cmbType);
                cmbType.setBounds(525, 180, 210, 40);

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
    private static JFrame jfManager;
    private static JPanel pnlManager;
    private static JPanel sPnlManager;
    private static JLabel lblMHomeTitle;
    private static JLabel lblManagerName;
    private static JButton btnOverview;
    private static JButton btnOrder;
    private static JButton btnRider;
    private static JButton btnReport;
    private static JButton btnFeedback;
    private static JButton btnLogout;
    private JPanel panel1;
    protected static JLabel lblTitle;
    private JLabel lblID;
    private JLabel lblType;
    private JLabel lblIC;
    private JLabel lblID2;
    private static JComboBox<String> cmbType;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    
}
