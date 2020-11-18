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

    public JComboBox<String> getCmbState() {
        return cmbState;
    }

    public JButton getBtnNext1() {
        return btnNext1;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        jfManager = new JFrame();
        sPnlManager = new JPanel();
        lblMHomeTitle = new JLabel();
        lblManagerName = new JLabel();
        btnOverview = new JButton();
        btnOrder = new JButton();
        btnRider = new JButton();
        btnReport = new JButton();
        btnFeedback = new JButton();
        btnLogout = new JButton();
        pnlTitle = new JPanel();
        lblTitle = new JLabel();
        pnlOrderFirst = new JPanel();
        lblID = new JLabel();
        lblType = new JLabel();
        lblIC = new JLabel();
        lblID2 = new JLabel();
        cmbType = new JComboBox<>();
        txtIC = new JTextField();
        lblIC2 = new JLabel();
        lblIC3 = new JLabel();
        lblIC4 = new JLabel();
        lblIC5 = new JLabel();
        scrollPane1 = new JScrollPane();
        txtStreet = new JTextArea();
        txtCity = new JTextField();
        cmbState = new JComboBox<>();
        txtPost = new JTextField();
        btnNext1 = new JButton();

        //======== jfManager ========
        {
            jfManager.setBackground(new Color(204, 204, 204));
            jfManager.setTitle("Manager Portal");
            jfManager.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            var jfManagerContentPane = jfManager.getContentPane();
            jfManagerContentPane.setLayout(null);

            //======== sPnlManager ========
            {
                sPnlManager.setBackground(new Color(21, 29, 65));
                sPnlManager.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax
                . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e" , javax. swing
                .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .
                Font ( "D\u0069al\u006fg", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red
                ) ,sPnlManager. getBorder () ) ); sPnlManager. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override
                public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062or\u0064er" .equals ( e. getPropertyName (
                ) ) )throw new RuntimeException( ) ;} } );
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
            jfManagerContentPane.add(sPnlManager);
            sPnlManager.setBounds(0, 0, 255, 760);

            //======== pnlTitle ========
            {
                pnlTitle.setBackground(new Color(186, 201, 245));
                pnlTitle.setLayout(null);

                //---- lblTitle ----
                lblTitle.setText("Order Form");
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
            jfManagerContentPane.add(pnlTitle);
            pnlTitle.setBounds(255, 0, 850, 80);

            //======== pnlOrderFirst ========
            {
                pnlOrderFirst.setBackground(Color.white);
                pnlOrderFirst.setLayout(null);

                //---- lblID ----
                lblID.setText("Order ID");
                lblID.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblID.setForeground(Color.black);
                pnlOrderFirst.add(lblID);
                lblID.setBounds(new Rectangle(new Point(50, 20), lblID.getPreferredSize()));

                //---- lblType ----
                lblType.setText("Order Type");
                lblType.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblType.setForeground(Color.black);
                pnlOrderFirst.add(lblType);
                lblType.setBounds(50, 95, 135, 32);

                //---- lblIC ----
                lblIC.setText("Customer IC");
                lblIC.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblIC.setForeground(Color.black);
                pnlOrderFirst.add(lblIC);
                lblIC.setBounds(50, 155, 180, 45);

                //---- lblID2 ----
                lblID2.setText("Order ID");
                lblID2.setFont(new Font("Nirmala UI", Font.BOLD, 20));
                lblID2.setForeground(Color.black);
                lblID2.setBorder(new LineBorder(Color.black, 2, true));
                lblID2.setHorizontalAlignment(SwingConstants.CENTER);
                pnlOrderFirst.add(lblID2);
                lblID2.setBounds(210, 20, 105, 40);

                //---- cmbType ----
                cmbType.setFont(cmbType.getFont().deriveFont(cmbType.getFont().getSize() + 9f));
                cmbType.setBackground(new Color(235, 232, 232));
                cmbType.setMaximumRowCount(2);
                cmbType.setModel(new DefaultComboBoxModel<>(new String[] {
                    "Non Pickup",
                    "Pickup"
                }));
                cmbType.setForeground(new Color(86, 83, 83));
                pnlOrderFirst.add(cmbType);
                cmbType.setBounds(290, 95, 210, 40);

                //---- txtIC ----
                txtIC.setBackground(new Color(204, 204, 204));
                txtIC.setCaretColor(Color.black);
                txtIC.setForeground(Color.black);
                txtIC.setEnabled(false);
                txtIC.setFont(txtIC.getFont().deriveFont(txtIC.getFont().getSize() + 8f));
                txtIC.setDisabledTextColor(Color.black);
                pnlOrderFirst.add(txtIC);
                txtIC.setBounds(285, 160, 255, 40);

                //---- lblIC2 ----
                lblIC2.setText("Street");
                lblIC2.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblIC2.setForeground(Color.black);
                pnlOrderFirst.add(lblIC2);
                lblIC2.setBounds(50, 230, 180, 45);

                //---- lblIC3 ----
                lblIC3.setText("City");
                lblIC3.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblIC3.setForeground(Color.black);
                pnlOrderFirst.add(lblIC3);
                lblIC3.setBounds(50, 325, 180, 45);

                //---- lblIC4 ----
                lblIC4.setText("State");
                lblIC4.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblIC4.setForeground(Color.black);
                pnlOrderFirst.add(lblIC4);
                lblIC4.setBounds(50, 400, 180, 45);

                //---- lblIC5 ----
                lblIC5.setText("Postcode");
                lblIC5.setFont(new Font("Nirmala UI", Font.BOLD, 24));
                lblIC5.setForeground(Color.black);
                pnlOrderFirst.add(lblIC5);
                lblIC5.setBounds(50, 475, 180, 45);

                //======== scrollPane1 ========
                {

                    //---- txtStreet ----
                    txtStreet.setRows(1);
                    txtStreet.setBackground(Color.white);
                    txtStreet.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
                    txtStreet.setForeground(Color.black);
                    txtStreet.setLineWrap(true);
                    scrollPane1.setViewportView(txtStreet);
                }
                pnlOrderFirst.add(scrollPane1);
                scrollPane1.setBounds(290, 235, 505, 70);

                //---- txtCity ----
                txtCity.setBackground(new Color(204, 204, 204));
                txtCity.setCaretColor(Color.black);
                txtCity.setForeground(Color.black);
                txtCity.setEnabled(false);
                txtCity.setFont(txtCity.getFont().deriveFont(txtCity.getFont().getSize() + 8f));
                txtCity.setDisabledTextColor(Color.black);
                pnlOrderFirst.add(txtCity);
                txtCity.setBounds(290, 335, 255, 40);

                //---- cmbState ----
                cmbState.setFont(cmbState.getFont().deriveFont(cmbState.getFont().getSize() + 9f));
                cmbState.setBackground(new Color(235, 232, 232));
                cmbState.setMaximumRowCount(2);
                cmbState.setModel(new DefaultComboBoxModel<>(new String[] {
                    "KUL",
                    "SGR",
                    "PNG",
                    "JHR",
                    "NSN",
                    "MLK",
                    "KDH",
                    "KTN",
                    "PHG",
                    "PRK",
                    "PLS",
                    "TRG",
                    "PJY"
                }));
                cmbState.setForeground(new Color(86, 83, 83));
                pnlOrderFirst.add(cmbState);
                cmbState.setBounds(290, 400, 210, 40);

                //---- txtPost ----
                txtPost.setBackground(new Color(204, 204, 204));
                txtPost.setCaretColor(Color.black);
                txtPost.setForeground(Color.black);
                txtPost.setEnabled(false);
                txtPost.setFont(txtPost.getFont().deriveFont(txtPost.getFont().getSize() + 8f));
                txtPost.setDisabledTextColor(Color.black);
                pnlOrderFirst.add(txtPost);
                txtPost.setBounds(290, 480, 175, 40);

                //---- btnNext1 ----
                btnNext1.setText("Proceed");
                btnNext1.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnNext1.setBackground(Color.black);
                pnlOrderFirst.add(btnNext1);
                btnNext1.setBounds(625, 570, 170, 65);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < pnlOrderFirst.getComponentCount(); i++) {
                        Rectangle bounds = pnlOrderFirst.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = pnlOrderFirst.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    pnlOrderFirst.setMinimumSize(preferredSize);
                    pnlOrderFirst.setPreferredSize(preferredSize);
                }
            }
            jfManagerContentPane.add(pnlOrderFirst);
            pnlOrderFirst.setBounds(255, 80, 850, 680);

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
    private static JPanel sPnlManager;
    private static JLabel lblMHomeTitle;
    private static JLabel lblManagerName;
    private static JButton btnOverview;
    private static JButton btnOrder;
    private static JButton btnRider;
    private static JButton btnReport;
    private static JButton btnFeedback;
    private static JButton btnLogout;
    private JPanel pnlTitle;
    protected static JLabel lblTitle;
    private static JPanel pnlOrderFirst;
    private JLabel lblID;
    private JLabel lblType;
    private JLabel lblIC;
    private JLabel lblID2;
    private static JComboBox<String> cmbType;
    private JTextField txtIC;
    private JLabel lblIC2;
    private JLabel lblIC3;
    private JLabel lblIC4;
    private JLabel lblIC5;
    private JScrollPane scrollPane1;
    private JTextArea txtStreet;
    private JTextField txtCity;
    private static JComboBox<String> cmbState;
    private JTextField txtPost;
    private static JButton btnNext1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    
}
