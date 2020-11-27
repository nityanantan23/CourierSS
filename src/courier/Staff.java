package courier;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

import static courier.StaffLogin.resetField;

public abstract class Staff extends Person {
    //creating a staff
    protected String password;
    protected static Scanner s;

    public Staff(){}
    public Staff(String id ,String name , String phone,String password) {
        super(id,name,phone);
        setPassword(password);
    }

    @Override
    public void readFile() {
        String line;
        String[] lineV;
        line=s.nextLine();
        lineV=line.split(",");
        setId(lineV[0]);
        setName(lineV[1]) ;
        setPhone(lineV[2]);
        setPassword(lineV[3]);
    }

    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return password;
    }

    public void findStaffFile(String fileName){
        try {
            s = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public abstract void loadStaff() ;

    public static void credentialChecker(String  id, String pw){
        boolean pass1 = false,pass2= false;
        //check for admin first
        id=id.toUpperCase();
        for (int i=0;i<Admin.adminAl.size();i++){
            if(Admin.adminAl.get(i).getId().equals(id)&&Admin.adminAl.get(i).password.equals(pw)){
                pass1=true;
                pass2=true;
                JOptionPane.showMessageDialog(null,"Successfully login as Admin","Login Successfully",1);
                StaffLogin.getJfLogin().setVisible(false);
                StaffLogin.loggedPerson=Admin.adminAl.get(i);
                Main.adminUserMatrix= new Admin_UserMatrix();
                Main.adminUserMatrix.getJfAdmin().setVisible(true);
                break;
            }
        }
        if (pass1!=true){
            for (int i=0;i<Manager.managerAl.size();i++){
                if(Manager.managerAl.get(i).getId().equals(id)&&Manager.managerAl.get(i).password.equals(pw)){
                    pass1=true;
                    pass2=true;
                    JOptionPane.showMessageDialog(null,"Successfully login as Manager","Login Successfully",1);
                    StaffLogin.getJfLogin().setVisible(false);
                    StaffLogin.loggedPerson=Manager.managerAl.get(i);
                    Main.ManagerPage= new ManagerHome();
                    Main.ManagerPage.getJfManager().setVisible(true);
                    break;
                }
            }
        }
        if (pass2!=true){
            for (int i=0;i<Rider.getRiderAL().size();i++){
                if(Rider.getRiderAL().get(i).getId().equals(id)&&Rider.getRiderAL().get(i).password.equals(pw)){
                    pass1=true;
                    pass2=true;
                    JOptionPane.showMessageDialog(null,"Successfully login as Rider","Login Successfully",1);
                    StaffLogin.loggedPerson=Rider.getRiderAL().get(i);
                    Main.riderHome =new RiderHome();
                    StaffLogin.getJfLogin().setVisible(false);
                    break;
                }
            }
        }
        if(pass1==false&&pass2==false){
            JOptionPane.showMessageDialog(null,"Invalid Login ID or password. Please try again!","Wrong Credential",2);
            resetField();
        }

    }



    //func created a credential setter for all staff class
//    public void setCredential(String fileLocation,String username,String password){
//        FileWriter fw=null;
//        BufferedWriter bw=null;
//        PrintWriter pw=null;
//        try{
//            fw = new FileWriter(fileLocation, true);
//            bw = new BufferedWriter(fw);
//            pw = new PrintWriter(bw);
//
//            pw.print("\n"+username+"\n"+password);
//            this.password=password;
//            this.username=username;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                pw.close();
//                bw.close();
//                fw.close();
//
//            } catch (IOException e) { //instances where the i/o cannot be close
//                e.printStackTrace();
//            }
//        }
//    }

}
