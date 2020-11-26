/*
 * Created by JFormDesigner on Tue Nov 24 17:18:43 SGT 2020
 */

package courier;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import static courier.StaffLogin.resetField;

/**
 * @author unknown
 */
public class Admin_UserMatrix extends Admin {
    public Admin_UserMatrix() {

        tblUser = new JTable(tblM);
        cmbRole = new JComboBox<>();
        cmbRole.addItem("Admin");
        cmbRole.addItem("Manager");
        cmbRole.addItem("Rider");
        initComponents();
        loadTable();

        jfAdmin.setVisible(true);

    }


    public Object[][] obj;
    private static String[] col = {"StaffID", "Name", "Role"};
    private static DefaultTableModel tblM = new DefaultTableModel(col, 0) {
        public boolean isCellEditable(int row, int column) {
            return false;//This causes all cells to be not editable
        }
    };

    public static DefaultTableModel getTableStaff(){
        return tblM;
    }

    @Override
    public void loadTable() {
//        Admin a = new Admin();
//        Manager m = new Manager();
//        Rider r = new Rider();
//        a.loadStaff();
//        m.loadStaff();
//        r.loadStaff();
        tblM.setRowCount(0);


        for (int i = 0; i < Admin.adminAl.size(); i++) {
            if (Admin.adminAl.get(i).getId() != null) {
                String staffID = Admin.adminAl.get(i).getId();
                String Name = Admin.adminAl.get(i).getName();
                String Role = "Admin";
                Object[] data = {staffID, Name, Role};
                tblM.addRow(data);
            }
        }
        for (int i = 0; i < Manager.managerAl.size(); i++) {
            if (Manager.managerAl.get(i).getId() != null) {
                String staffID = Manager.managerAl.get(i).getId();
                String Name = Manager.managerAl.get(i).getName();
                String Role = "Manager";
                Object[] data = {staffID, Name, Role};
                tblM.addRow(data);
            }
        }
        for (int i = 0; i < Rider.getRiderAL().size(); i++) {
            if (Rider.getRiderAL().get(i).getId() != null) {
                String staffID = Rider.getRiderAL().get(i).getId();
                String Name = Rider.getRiderAL().get(i).getName();
                String Role = "Rider";
                Object[] data = {staffID, Name, Role};
                tblM.addRow(data);
            }
        }
        jfAdmin.setVisible(false);

    }


    private void btnAddActionPerformed(ActionEvent e) {
        if (txtName.getText().isBlank() || txtPw.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "fields are empty!", "Invalid ", 3);
        } else if (cmbRole.getSelectedItem().toString().equals("Admin")) {
            Admin a= new Admin(Admin.generateID(),txtName.getText(),txtPh.getText()
                    ,txtPw.getText());
            Admin.adminAl.add(a);
            a.writeLine();
            JOptionPane.showMessageDialog(null, "Successfully added "
                    + cmbRole.getSelectedItem().toString() + " " + a.getName());
//            tblM.fireTableDataChanged();
            tblM.setRowCount(0);
            resetField();
            loadTable();


        } else if (cmbRole.getSelectedItem().toString().equals("Manager")) {
            Manager a= new Manager(Manager.generateID(),txtName.getText(),txtPh.getText()
                    ,txtPw.getText());
            Manager.managerAl.add(a);
            a.writeLine();
            JOptionPane.showMessageDialog(null, "Successfully added "
                    + cmbRole.getSelectedItem().toString() + " " + a.getName());
            resetField();
            tblM.setRowCount(0);
            loadTable();
        } else if (cmbRole.getSelectedItem().toString().equals("Rider")) {
            Rider a= new Rider(Rider.generateID(),txtName.getText(),txtPh.getText()
                    ,txtPw.getText());
            Rider.getRiderAL().add(a);
            a.writeLine();
            JOptionPane.showMessageDialog(null, "Successfully added "
                    + cmbRole.getSelectedItem().toString() + " " + a.getName());
            resetField();
            tblM.setRowCount(0);
            loadTable();
        }
    }


    private void btnEditActionPerformed(ActionEvent e) {
        if (tblUser.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Please select which user to edit!", "Invalid ", 3);
        } else if (tblUser.getValueAt(tblUser.getSelectedRow(), 2).equals("Admin")) {


            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to edit " +
                        tblUser.getValueAt(tblUser.getSelectedRow(), 1).toString() + "?", " Confirmation", 0);
                if (confirm == 0) {
                    for (int i = 0; i < Admin.adminAl.size(); i++) {
                        if (Admin.adminAl.get(i).getId().equals(tblUser.getValueAt(tblUser.getSelectedRow(), 0).toString())) {
                            Admin.adminAl.get(i).setName(txtName.getText().toString());
                            Admin.adminAl.get(i).setPhone(txtPh.getText().toString());
                            Admin.adminAl.get(i).setPassword(txtPw.getText().toString());
                            JOptionPane.showMessageDialog(null, "Successfully edited"
                                    + cmbRole.getSelectedItem().toString() + " " + Admin.adminAl.get(i).getName());
                            tblM.setRowCount(0);
                            loadTable();
                            cmbRole.setSelectedIndex(0);
                            Admin o = new Admin();
                            o.writeFile();
                            break;
                        }
                    }
                }
            } else if (tblUser.getValueAt(tblUser.getSelectedRow(), 2).equals("Manager")) {

                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to edit " +
                        tblUser.getValueAt(tblUser.getSelectedRow(), 1).toString() + "?", " Confirmation", 0);
                if (confirm == 0) {
                    for (int i = 0; i < Manager.managerAl.size(); i++) {
                        if (Manager.managerAl.get(i).getId().equals(tblUser.getValueAt(tblUser.getSelectedRow(), 0).toString())) {
                            Manager.managerAl.get(i).setName(txtName.getText().toString());
                            Manager.managerAl.get(i).setPhone(txtPh.getText().toString());
                            Manager.managerAl.get(i).setPassword(txtPw.getText().toString());
                            JOptionPane.showMessageDialog(null, "Successfully edited"
                                    + cmbRole.getSelectedItem().toString() + " " + Manager.managerAl.get(i).getName());
                            tblM.setRowCount(0);
                            loadTable();
                            cmbRole.setSelectedIndex(0);
                            Manager o = new Manager();
                            o.writeFile();
                            break;
                        }
                    }
                }
            } else if (tblUser.getValueAt(tblUser.getSelectedRow(), 2).equals("Rider")) {

                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to edit "+
                        tblUser.getValueAt(tblUser.getSelectedRow(), 1).toString() + "?", " Confirmation", 0);
                if (confirm == 0) {
                    for (int i = 0; i < Rider.getRiderAL().size(); i++) {
                        if (Rider.getRiderAL().get(i).getId().equals(tblUser.getValueAt(tblUser.getSelectedRow(), 0).toString())) {
                            Rider.getRiderAL().get(i).setName(txtName.getText().toString());
                            Rider.getRiderAL().get(i).setPhone(txtPh.getText().toString());
                            Rider.getRiderAL().get(i).setPassword(txtPw.getText().toString());
                            JOptionPane.showMessageDialog(null, "Successfully edited"
                                    + cmbRole.getSelectedItem().toString() + " " + Rider.getRiderAL().get(i).getName());
                            tblM.setRowCount(0);
                            loadTable();
                            cmbRole.setSelectedIndex(0);
                            Rider o = new Rider();
                            o.writeFile();
                            break;
                        }
                    }
                }
            }
        }


    private void tblUserMouseClicked(MouseEvent e) {
        for (int i = 0; i < Admin.adminAl.size(); i++) {
            if (Admin.adminAl.get(i).getId().equals(tblUser.getValueAt(tblUser.getSelectedRow(), 0).toString())) {
                txtName.setText(Admin.adminAl.get(i).getName());
                txtPh.setText(Admin.adminAl.get(i).getPhone());
                txtPw.setText(Admin.adminAl.get(i).getPassword());
                cmbRole.setSelectedIndex(0);


            }
        }
        for (int i = 0; i < Manager.managerAl.size(); i++) {
            if (Manager.managerAl.get(i).getId().equals(tblUser.getValueAt(tblUser.getSelectedRow(), 0).toString())) {
                txtName.setText(Manager.managerAl.get(i).getName());
                txtPh.setText(Manager.managerAl.get(i).getPhone());
                txtPw.setText(Manager.managerAl.get(i).getPassword());
                cmbRole.setSelectedIndex(1);

            }
        }
        for (int i = 0; i < Rider.getRiderAL().size(); i++) {
            if (Rider.getRiderAL().get(i).getId().equals(tblUser.getValueAt(tblUser.getSelectedRow(), 0).toString())) {
                txtName.setText(Rider.getRiderAL().get(i).getName());
                txtPh.setText(Rider.getRiderAL().get(i).getPhone());
                txtPw.setText(Rider.getRiderAL().get(i).getPassword());
                cmbRole.setSelectedIndex(2);

            }
        }
    }

    public JLabel getLblManagerName() {
        return lblManagerName;
    }

    public JComboBox getCmbRole() {
        return cmbRole;
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    private void btnAssignOrderActionPerformed(ActionEvent e) {
        // TODO add your code here
    }


    private void btnRemoveActionPerformed(ActionEvent e) throws IOException {
        String line;

        if (tblUser.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Please select which user to remove!", "Invalid ", 3);
        } else {
            if (tblUser.getValueAt(tblUser.getSelectedRow(), 2).equals("Admin")) {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove " +
                        tblUser.getValueAt(tblUser.getSelectedRow(), 1).toString() + "?", " Confirmation", 0);
                if (confirm == 0) {
                    File orifile = new File("txtFile/Admin_account.txt");
                    File tempFile = new File("txtFile/temp.txt");
                    try (BufferedReader reader = new BufferedReader(new FileReader(orifile));
                         BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

                        while ((line = reader.readLine()) != null) {
                            String[] information = line.split(",");
                            String Admin_id = information[0];
                            String name = information[1];
                            String ph = information[2];
                            String password = information[3];

                            if (!Admin_id.equals(tblUser.getValueAt(tblUser.getSelectedRow(), 0).toString())) {

                                writer.write(Admin_id + "," + name + "," + ph + "," + password);
                                writer.newLine();
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Successfully removed "
                                + tblUser.getValueAt(tblUser.getSelectedRow(), 1).toString());

                        reader.close();
                        writer.close();
                        boolean delete = orifile.delete();
                        boolean renameTo = tempFile.renameTo(orifile);
                        tblM.setRowCount(0);
                        loadTable();
                    }
                }

            } else if (tblUser.getValueAt(tblUser.getSelectedRow(), 2).equals("Manager")) {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove " +
                        tblUser.getValueAt(tblUser.getSelectedRow(), 1).toString() + "?", " Confirmation", 0);
                if (confirm == 0) {
                    File orifile = new File("txtFile/Manager_account.txt");
                    File tempFile = new File("txtFile/temp.txt");
                    try (BufferedReader reader = new BufferedReader(new FileReader(orifile));
                         BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

                        while ((line = reader.readLine()) != null) {
                            String[] information = line.split(",");
                            String Manager_id = information[0];
                            String name = information[1];
                            String ph = information[2];
                            String password = information[3];

                            if (!Manager_id.equals(tblUser.getValueAt(tblUser.getSelectedRow(), 0).toString())) {
                                writer.write(Manager_id + "," + name + "," + ph + "," + password);
                                writer.newLine();
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Successfully removed "
                                + tblUser.getValueAt(tblUser.getSelectedRow(), 1).toString());
                        reader.close();
                        writer.close();
                        boolean delete = orifile.delete();
                        boolean renameTo = tempFile.renameTo(orifile);
                        tblM.setRowCount(0);
                        loadTable();
                    }
                }

            } else if (tblUser.getValueAt(tblUser.getSelectedRow(), 2).equals("Rider")) {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove " +
                        tblUser.getValueAt(tblUser.getSelectedRow(), 1).toString() + "?", " Confirmation", 0);
                if (confirm == 0) {
                    File orifile = new File("txtFile/Rider_account.txt");
                    File tempFile = new File("txtFile/temp.txt");
                    try (BufferedReader reader = new BufferedReader(new FileReader(orifile));
                         BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

                        while ((line = reader.readLine()) != null) {
                            String[] information = line.split(",");
                            String Rider_id = information[0];
                            String name = information[1];
                            String ph = information[2];
                            String password = information[3];

                            if (!Rider_id.equals(tblUser.getValueAt(tblUser.getSelectedRow(), 0).toString())) {
                                writer.write(Rider_id + "," + name + "," + ph + "," + password);
                                writer.newLine();
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Successfully removed "
                                + tblUser.getValueAt(tblUser.getSelectedRow(), 1).toString());

                        reader.close();
                        writer.close();
                        boolean delete = orifile.delete();
                        boolean renameTo = tempFile.renameTo(orifile);
                        tblM.setRowCount(0);
                        loadTable();
                    }
                }

            }
        }
    }

    public static void resetField() {
        txtName.setText("");
        txtPw.setText("");
        txtName.grabFocus();
    }


    private void txtUserKeyTyped(KeyEvent e) {
        if (txtName.getText().length() > 10) {
            JOptionPane.showMessageDialog(null, "Username does not exceed 10 character.Please enter the correct username.", "Invalid Username", 2);
            e.consume();
            resetField();
        }
    }

    private void txtUserKeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void txtPwKeyTyped(KeyEvent e) {
        if (txtPw.getText().length() > 16) {
            JOptionPane.showMessageDialog(null, "Password does not exceed 16 character.Please enter the correct password.", "Invalid Password", 2);
            e.consume();
            resetField();
        }
    }

    private void txtPwKeyPressed(KeyEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        createUIComponents();

        jfAdmin = new JFrame();
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
        btnUserMatrix = new JButton();
        panel1 = new JPanel();
        pnlTitle = new JPanel();
        lblTitle = new JLabel();
        scrollPane2 = new JScrollPane();
        lblRole = new JLabel();
        lblSelOrderId = new JLabel();
        btnAdd = new JButton();
        btnRemove = new JButton();
        txtName = new JTextArea();
        lblPassword = new JLabel();
        lblName = new JLabel();
        btnEdit = new JButton();
        txtPw = new JPasswordField();
        txtPh = new JTextArea();
        lblPhoneNumber = new JLabel();

        //======== jfAdmin ========
        {
            var jfAdminContentPane = jfAdmin.getContentPane();
            jfAdminContentPane.setLayout(null);

            //======== sPnlManager ========
            {
                sPnlManager.setBackground(new Color(21, 29, 65));
                sPnlManager.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
                0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
                . BOTTOM, new java .awt .Font ("Dialo\u0067" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
                red) ,sPnlManager. getBorder( )) ); sPnlManager. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
                beans .PropertyChangeEvent e) {if ("borde\u0072" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
                sPnlManager.setLayout(null);

                //---- lblMHomeTitle ----
                lblMHomeTitle.setText("Admin Portal");
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
                btnOrder.setBounds(45, 220, 145, 45);

                //---- btnRider ----
                btnRider.setText("Rider");
                btnRider.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                sPnlManager.add(btnRider);
                btnRider.setBounds(45, 345, 145, 45);

                //---- btnReport ----
                btnReport.setText("Report");
                btnReport.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                sPnlManager.add(btnReport);
                btnReport.setBounds(45, 410, 145, 45);

                //---- btnFeedback ----
                btnFeedback.setText("Feedback");
                btnFeedback.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                sPnlManager.add(btnFeedback);
                btnFeedback.setBounds(45, 475, 145, 45);

                //---- btnLogout ----
                btnLogout.setText("Logout");
                btnLogout.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                sPnlManager.add(btnLogout);
                btnLogout.setBounds(45, 610, 145, 45);

                //---- btnAssignOrder ----
                btnAssignOrder.setText("Assign Order");
                btnAssignOrder.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnAssignOrder.addActionListener(e -> btnAssignOrderActionPerformed(e));
                sPnlManager.add(btnAssignOrder);
                btnAssignOrder.setBounds(45, 285, 145, 45);

                //---- btnUserMatrix ----
                btnUserMatrix.setText("User Matrix");
                btnUserMatrix.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                sPnlManager.add(btnUserMatrix);
                btnUserMatrix.setBounds(45, 540, 145, 45);

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
            jfAdminContentPane.add(sPnlManager);
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
                    lblTitle.setText("User Matrix");
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

                //======== scrollPane2 ========
                {

                    //---- tblUser ----
                    tblUser.setBackground(Color.white);
                    tblUser.setForeground(Color.black);
                    tblUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    tblUser.setFillsViewportHeight(true);
                    tblUser.setCellSelectionEnabled(true);
                    tblUser.setRowMargin(3);
                    tblUser.setRowHeight(35);
                    tblUser.setFont(new Font("Segoe UI", Font.PLAIN, 22));
                    tblUser.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            tblUserMouseClicked(e);
                        }
                    });
                    scrollPane2.setViewportView(tblUser);
                }
                panel1.add(scrollPane2);
                scrollPane2.setBounds(40, 150, 495, 490);

                //---- lblRole ----
                lblRole.setText("Role ");
                lblRole.setFont(new Font("Nirmala UI", Font.BOLD, 30));
                lblRole.setForeground(Color.black);
                panel1.add(lblRole);
                lblRole.setBounds(570, 470, 140, 45);

                //---- cmbRole ----
                cmbRole.setFont(cmbRole.getFont().deriveFont(cmbRole.getFont().getSize() + 9f));
                cmbRole.setBackground(Color.white);
                cmbRole.setMaximumRowCount(3);
                cmbRole.setForeground(new Color(86, 83, 83));
                panel1.add(cmbRole);
                cmbRole.setBounds(570, 520, 250, 45);

                //---- lblSelOrderId ----
                lblSelOrderId.setFont(new Font("Nirmala UI", Font.PLAIN, 25));
                lblSelOrderId.setForeground(Color.black);
                panel1.add(lblSelOrderId);
                lblSelOrderId.setBounds(255, 500, 140, 45);

                //---- btnAdd ----
                btnAdd.setText("Add");
                btnAdd.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnAdd.addActionListener(e -> btnAddActionPerformed(e));
                panel1.add(btnAdd);
                btnAdd.setBounds(625, 625, 145, 45);

                //---- btnRemove ----
                btnRemove.setText("Remove");
                btnRemove.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnRemove.addActionListener(e -> {
                    try {
                        btnRemoveActionPerformed(e);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                });
                panel1.add(btnRemove);
                btnRemove.setBounds(210, 90, 145, 45);

                //---- txtName ----
                txtName.setBackground(new Color(239, 234, 234));
                txtName.setBorder(new LineBorder(Color.black, 3, true));
                txtName.setFont(new Font("Montserrat Light", Font.PLAIN, 31));
                txtName.setForeground(Color.black);
                txtName.setToolTipText("Username");
                txtName.setMargin(new Insets(1, 1, 1, 1));
                txtName.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                txtName.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        txtUserKeyPressed(e);
                    }
                    @Override
                    public void keyTyped(KeyEvent e) {
                        txtUserKeyTyped(e);
                    }
                });
                panel1.add(txtName);
                txtName.setBounds(570, 225, 250, 40);

                //---- lblPassword ----
                lblPassword.setText("Password ");
                lblPassword.setFont(new Font("Nirmala UI", Font.BOLD, 30));
                lblPassword.setForeground(Color.black);
                panel1.add(lblPassword);
                lblPassword.setBounds(570, 270, 195, 45);

                //---- lblName ----
                lblName.setText("Name ");
                lblName.setFont(new Font("Nirmala UI", Font.BOLD, 30));
                lblName.setForeground(Color.black);
                panel1.add(lblName);
                lblName.setBounds(570, 170, 140, 45);

                //---- btnEdit ----
                btnEdit.setText("Edit");
                btnEdit.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
                btnEdit.addActionListener(e -> btnEditActionPerformed(e));
                panel1.add(btnEdit);
                btnEdit.setBounds(40, 90, 145, 45);

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
                txtPw.setBounds(570, 320, 250, 40);

                //---- txtPh ----
                txtPh.setBackground(new Color(239, 234, 234));
                txtPh.setBorder(new LineBorder(Color.black, 3, true));
                txtPh.setFont(new Font("Montserrat Light", Font.PLAIN, 31));
                txtPh.setForeground(Color.black);
                txtPh.setToolTipText("Username");
                txtPh.setMargin(new Insets(1, 1, 1, 1));
                txtPh.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                txtPh.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        txtUserKeyPressed(e);
                    }
                    @Override
                    public void keyTyped(KeyEvent e) {
                        txtUserKeyTyped(e);
                    }
                });
                panel1.add(txtPh);
                txtPh.setBounds(570, 415, 250, 40);

                //---- lblPhoneNumber ----
                lblPhoneNumber.setText("Phone number");
                lblPhoneNumber.setFont(new Font("Nirmala UI", Font.BOLD, 30));
                lblPhoneNumber.setForeground(Color.black);
                panel1.add(lblPhoneNumber);
                lblPhoneNumber.setBounds(570, 365, 260, 45);

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
            jfAdminContentPane.add(panel1);
            panel1.setBounds(255, 0, 895, 760);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < jfAdminContentPane.getComponentCount(); i++) {
                    Rectangle bounds = jfAdminContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = jfAdminContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                jfAdminContentPane.setMinimumSize(preferredSize);
                jfAdminContentPane.setPreferredSize(preferredSize);
            }
            jfAdmin.pack();
            jfAdmin.setLocationRelativeTo(jfAdmin.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JFrame jfAdmin;
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
    private static JButton btnUserMatrix;
    private JPanel panel1;
    private JPanel pnlTitle;
    protected static JLabel lblTitle;
    private JScrollPane scrollPane2;
    private static JTable tblUser;
    private JLabel lblRole;
    private static JComboBox cmbRole;
    private static JLabel lblSelOrderId;
    private static JButton btnAdd;
    private static JButton btnRemove;
    private static JTextArea txtName;
    private JLabel lblPassword;
    private JLabel lblName;
    private static JButton btnEdit;
    private static JPasswordField txtPw;
    private static JTextArea txtPh;
    private JLabel lblPhoneNumber;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
