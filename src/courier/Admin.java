package courier;
import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Map;

public class Admin extends Staff{
    public static ArrayList<Admin> adminAl=new ArrayList();
    private static int AdminID=0;


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

    public static void writeFile(){
        FileWriter fw=null;
        BufferedWriter bw=null;
        PrintWriter pw=null;
        try{
            pw = new PrintWriter(new File("txtFile/temp.txt"));
            for (int i=0;i<adminAl.size()-(adminAl.size()/2);i++){
                Admin o= adminAl.get(i);
                pw.println(o.getId()+","+o.getName()+","+o.getPhone()+","+o.getPassword());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            pw.close();

        }

    }


    @Override
    public void writeLine() {
        generateID();
        FileWriter fw=null;
        BufferedWriter bw=null;
        PrintWriter pw=null;
        try{
            fw = new FileWriter("txtFile/Admin_account.txt", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.println(generateID()+","+getName()+","+getPhone()+","+getPassword());

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





    public static void addAdminID(){

        AdminID=AdminID+1;
    }


    public static String generateID() {
        addAdminID();
        return ("A"+ String.format("%04d", AdminID));
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
