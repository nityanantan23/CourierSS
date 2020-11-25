package courier;
import java.io.*;
import java.util.ArrayList;

public class Manager extends Staff{
    public static ArrayList<Manager> managerAl=new ArrayList();
    private static Integer ManagerID=100;


    public Manager(){};
    public Manager( String id,String name, String phone, String password){
        super(id,name, phone, password);

    }

    @Override
    public void loadStaff() {
        findStaffFile("txtFile/Manager_account.txt");
        while (s.hasNext()){
            readFile();
            Manager m= new Manager(getId(),getName(),getPhone(),getPassword());
            managerAl.add(m);
        }
    }

    @Override
    public void writeLine() {
        FileWriter fw=null;
        BufferedWriter bw=null;
        PrintWriter pw=null;
        try{
            fw = new FileWriter("txtFile/Manager_account.txt", true);
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
            pw = new PrintWriter(new File("txtFile/Manager_account.txt"));
            for (int i=0;i<managerAl.size()-(managerAl.size())/2;i++){
                Manager o= managerAl.get(i);
                pw.println(o.generateID()+","+o.getName()+","+o.getPhone()+","+o.getPassword());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            pw.close();

        }
    }

    public static void addAdminID(){

        ManagerID=ManagerID+1;
    }


    public static String generateID() {
        addAdminID();
        return ("M"+ ManagerID);
    }
    //manager class creation

}
