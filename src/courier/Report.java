/*
 * Created by JFormDesigner on Wed Nov 25 22:28:06 SGT 2020
 */

package courier;

import com.itextpdf.text.*;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.orsoncharts.plot.PiePlot3D;
import org.jfree.chart.*;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author unknown
 */
public class Report extends JFrame {
    public Report() {
        initComponents();
        jfReport.setVisible(true);
        btnReport.setEnabled(false);
        lblManagerName.setText(StaffLogin.loggedPerson.getName());


    }


    private void btnAssignOrderActionPerformed(ActionEvent e) {
        // TODO add your code here
    }
    private static String[] col = {"StaffID", "Name", "Role"};

    private static DefaultTableModel tblM = new DefaultTableModel(col, 0) {
        public boolean isCellEditable(int row, int column) {
            return false;//This causes all cells to be not editable
        }
    };



    private void btnViewStaffActionPerformed(ActionEvent e) throws IOException, DocumentException {
        Document document =new Document();
        PdfWriter.getInstance(document, new FileOutputStream("txtFile/Report.pdf"));
        document.open();
        Image image = Image.getInstance("Pic/logo-01.png");
        document.add(image);
        document.add(new Paragraph("Staff Report", FontFactory.getFont(FontFactory.TIMES_BOLD,18,Font.BOLD, BaseColor.RED)));;
        document.add(new Paragraph(new Date().toString() ));
        document.add(new Paragraph("---------------------------------------------------------"));
        PdfPTable table = new PdfPTable(3);
        table.addCell("Staff ID");
        table.addCell("Name");
        table.addCell("Role");

        Admin_UserMatrix cls = new Admin_UserMatrix();
        cls.loadTable();

        int admin = 0;
        int manager = 0;
        int rider = 0;

        for (int i=0; i<Admin_UserMatrix.getTableStaff().getRowCount();i++){
            String column1=Admin_UserMatrix.getTableStaff().getValueAt(i,0).toString();
            String column2=Admin_UserMatrix.getTableStaff().getValueAt(i,1).toString();
            String column3=Admin_UserMatrix.getTableStaff().getValueAt(i,2).toString();
            if (Admin_UserMatrix.getTableStaff().getValueAt(i,2).toString().equals("Admin")){
                admin =admin+1;
            }else if (Admin_UserMatrix.getTableStaff().getValueAt(i,2).toString().equals("Manager")){
                manager =manager+1;
            }else if (Admin_UserMatrix.getTableStaff().getValueAt(i,2).toString().equals("Rider")){
                rider =rider+1;
            }
            table.addCell(column1);
            table.addCell(column2);
            table.addCell(column3);
        }
        document.add(table);
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("admin",admin);
        pieDataset.setValue("manager",manager);
        pieDataset.setValue("rider",rider);
        JFreeChart chart = ChartFactory.createPieChart3D("Pie chart",pieDataset,true,true,true);
        final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
        final File file1 = new File("Pic/staff_chart.png");
        ChartUtilities.saveChartAsPNG(file1,chart,600,400,info);
        Image image1 = Image.getInstance("Pic/staff_chart.png");
        document.add(image1);
        document.close();
        JOptionPane.showMessageDialog(null,"Report saved in txtFile folder");
        Desktop.getDesktop().open(new File("txtFile/Report.pdf"));
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }


    public JLabel getLblManagerName() {
        return lblManagerName;
    }

    private void btnReportActionPerformed(ActionEvent e) {
        jfReport.setVisible(false);
        Main.report= new Report();
    }

    private void btnFeedbackActionPerformed(ActionEvent e) {
        jfReport.setVisible(false);
        FeedbackPage a = new FeedbackPage();
        a.getbtnAssignOrder().setVisible(false);
        a.getbtnEdit().setVisible(false);
        a.getbtnNewOrder().setVisible(false);
        a.getbtnOverview().setVisible(false);
        a.getbtnProfile().setVisible(false);
        a.getlbltitle().setText("Admin Portal");

    }


    private void btnUserMatrixActionPerformed(ActionEvent e) {
        jfReport.setVisible(false);
        Main.adminUserMatrix= new Admin_UserMatrix();
    }

    private void btnLogoutActionPerformed(ActionEvent e) {
        jfReport.setVisible(false);
        Main.LoginPage= new StaffLogin();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        jfReport = new JFrame();
        sPnlManager = new JPanel();
        lblManagerName = new JLabel();
        lblMHomeTitle = new JLabel();
        btnReport = new JButton();
        btnFeedback = new JButton();
        btnUserMatrix = new JButton();
        btnLogout = new JButton();
        panel1 = new JPanel();
        pnlTitle = new JPanel();
        lblTitle = new JLabel();
        btnViewStaff = new JButton();
        lblTitle2 = new JLabel();

        //======== jfReport ========
        {
            jfReport.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            var jfReportContentPane = jfReport.getContentPane();
            jfReportContentPane.setLayout(null);

            //======== sPnlManager ========
            {
                sPnlManager.setBackground(new Color(21, 29, 65));
                sPnlManager.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder( 0
                , 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
                , new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,
                sPnlManager. getBorder( )) ); sPnlManager. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
                ) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
                sPnlManager.setLayout(null);

                //---- lblManagerName ----
                lblManagerName.setText("Loges");
                lblManagerName.setFont(new Font("Myanmar Text", Font.BOLD, 26));
                lblManagerName.setForeground(Color.white);
                lblManagerName.setHorizontalAlignment(SwingConstants.CENTER);
                sPnlManager.add(lblManagerName);
                lblManagerName.setBounds(25, 70, 200, 60);

                //---- lblMHomeTitle ----
                lblMHomeTitle.setText("Admin Portal");
                lblMHomeTitle.setFont(new Font("Myanmar Text", Font.BOLD, 27));
                lblMHomeTitle.setForeground(Color.white);
                sPnlManager.add(lblMHomeTitle);
                lblMHomeTitle.setBounds(20, 15, 210, 50);

                //---- btnReport ----
                btnReport.setText("Report");
                btnReport.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnReport.addActionListener(e -> {
			btnReportActionPerformed(e);
			btnReportActionPerformed(e);
		});
                sPnlManager.add(btnReport);
                btnReport.setBounds(50, 170, 145, 45);

                //---- btnFeedback ----
                btnFeedback.setText("Feedback");
                btnFeedback.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnFeedback.addActionListener(e -> {
			btnFeedbackActionPerformed(e);
		});
                sPnlManager.add(btnFeedback);
                btnFeedback.setBounds(50, 240, 145, 45);

                //---- btnUserMatrix ----
                btnUserMatrix.setText("User Matrix");
                btnUserMatrix.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnUserMatrix.addActionListener(e -> {
			btnUserMatrixActionPerformed(e);
			btnUserMatrixActionPerformed(e);
		});
                sPnlManager.add(btnUserMatrix);
                btnUserMatrix.setBounds(50, 310, 145, 45);

                //---- btnLogout ----
                btnLogout.setText("Logout");
                btnLogout.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnLogout.addActionListener(e -> {
			btnLogoutActionPerformed(e);
			btnLogoutActionPerformed(e);
		});
                sPnlManager.add(btnLogout);
                btnLogout.setBounds(60, 480, 145, 45);

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
            jfReportContentPane.add(sPnlManager);
            sPnlManager.setBounds(0, 0, 255, 760);

            //======== panel1 ========
            {
                panel1.setBackground(Color.white);
                panel1.setLayout(null);

                //======== pnlTitle ========
                {
                    pnlTitle.setBackground(new Color(186, 201, 245));
                    pnlTitle.setLayout(null);

                    //---- lblTitle ----
                    lblTitle.setText("Report");
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

                //---- btnViewStaff ----
                btnViewStaff.setText("Generate Report");
                btnViewStaff.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnViewStaff.addActionListener(e -> {
                    try {
                        btnViewStaffActionPerformed(e);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (DocumentException documentException) {
                        documentException.printStackTrace();
                    }
                });
                panel1.add(btnViewStaff);
                btnViewStaff.setBounds(295, 275, 245, 45);

                //---- lblTitle2 ----
                lblTitle2.setText("Staff Report");
                lblTitle2.setFont(new Font("Myanmar Text", Font.BOLD, 46));
                lblTitle2.setForeground(Color.black);
                lblTitle2.setAlignmentY(0.0F);
                lblTitle2.setHorizontalAlignment(SwingConstants.CENTER);
                lblTitle2.setIconTextGap(3);
                lblTitle2.setBackground(new Color(51, 204, 255));
                panel1.add(lblTitle2);
                lblTitle2.setBounds(190, 175, 425, 65);

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
            jfReportContentPane.add(panel1);
            panel1.setBounds(255, 0, 895, 760);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < jfReportContentPane.getComponentCount(); i++) {
                    Rectangle bounds = jfReportContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = jfReportContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                jfReportContentPane.setMinimumSize(preferredSize);
                jfReportContentPane.setPreferredSize(preferredSize);
            }
            jfReport.pack();
            jfReport.setLocationRelativeTo(jfReport.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JFrame jfReport;
    private static JPanel sPnlManager;
    private static JLabel lblManagerName;
    private static JLabel lblMHomeTitle;
    private static JButton btnReport;
    private static JButton btnFeedback;
    private static JButton btnUserMatrix;
    private static JButton btnLogout;
    private JPanel panel1;
    private JPanel pnlTitle;
    protected static JLabel lblTitle;
    private static JButton btnViewStaff;
    protected static JLabel lblTitle2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
