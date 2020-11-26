package courier;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Map;

public class Admin extends Staff{
    public static ArrayList<Admin> adminAl=new ArrayList();
    private static Integer AdminID=100;
    private static DefaultTableModel tableModel= new DefaultTableModel();


    public Admin(){}

    public Admin(String id,String name, String phone, String password  ){
        super(id,name, phone,  password);

    }


    @Override
    public void loadStaff() {
        findStaffFile("txtFile/Admin_account.txt");
        while(s.hasNext()){
            readFile();
            Admin a= new Admin(getId(),getName(),getPhone(),getPassword());
            adminAl.add(a);

        }
    }

    public static DefaultTableModel getTableStaff(){
        return tableModel ;
    }


    public void loadTable() {
//        Admin a = new Admin();
//        Manager m = new Manager();
//        Rider r = new Rider();
//        a.loadStaff();
//        m.loadStaff();
//        r.loadStaff();
        tableModel.setRowCount(0);


        for (int i = 0; i < Admin.adminAl.size(); i++) {
            if (Admin.adminAl.get(i).getId() != null) {
                String staffID = Admin.adminAl.get(i).getId();
                String Name = Admin.adminAl.get(i).getName();
                String Role = "Admin";
                Object[] data = {staffID, Name, Role};
                tableModel.addRow(data);
            }
        }
    }


    @Override
    public void writeLine() {
        FileWriter fw=null;
        BufferedWriter bw=null;
        PrintWriter pw=null;
        try{
            fw = new FileWriter("txtFile/Admin_account.txt", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.println(getId()+","+getName()+","+getPhone()+","+getPassword());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                pw.close();
                bw.close();
                fw.close();

            } catch (IOException e) { //instances where the i/o cannot be close
                e.printStackTrace();
            }
        }
    }

    @Override
    public void writeFile() {
        FileWriter fw=null;
        BufferedWriter bw=null;
        PrintWriter pw=null;
        try{
            pw = new PrintWriter(new File("txtFile/Admin_account.txt"));
            for (int i=0;i<adminAl.size()-(adminAl.size())/2;i++){
                Admin o= adminAl.get(i);
                pw.println(o.generateID()+","+o.getName()+","+o.getPhone()+","+o.getPassword());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            pw.close();

        }

    }


    public static void addAdminID(){

        AdminID=AdminID+1;
    }


    public static String generateID() {
        addAdminID();
        return ("A"+ AdminID);
    }


//    public static void main(String[] args){
//        Admin c= new Admin();
//        c.loadStaff();
//        System.out.println(adminAl.get(0).getPhone());
//        Manager m= new Manager();
//        m.loadStaff();
//        System.out.println(Manager.managerAl.get(0).getName()+" Your pass word is "+Manager.managerAl.get(0).getPassword());
//        Rider r= new Rider();
//        r.loadStaff();
//        System.out.println(Rider.riderAl.get(0).getName()+" Your pass word is "+Rider.riderAl.get(0).getPassword());
//
//    }


}
