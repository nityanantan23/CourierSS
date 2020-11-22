package courier;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

import static courier.StaffLogin.resetField;

public abstract class Staff extends Person {
    //creating a staff
    protected String password;
    public static Scanner s;
    private String line;
    private String[] lineV;

    public Staff(){
        super();
    }

    public Staff(String id ,String name , String phone,String password) {
        super(id,name,phone);
        setPassword(password);
    }

    public abstract void loadStaff() ;
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

    @Override
    public void readFile() {
        line=s.nextLine();
        lineV=line.split(",");
        setId(lineV[0]);
        setName(lineV[1]) ;
        setPhone(lineV[2]);
        setPassword(lineV[3]);
    }



    public static void credentialChecker(String  id, String pw){
        boolean pass1 = false,pass2= false;
        //check for admin first
        id=id.toUpperCase();
        for (int i=0;i<Admin.adminAl.size();i++){

            if(Admin.adminAl.get(i).getId().equals(id)&&Admin.adminAl.get(i).password.equals(pw)){
                System.out.println(Admin.adminAl.get(i).getId());
                System.out.println(Admin.adminAl.get(i).password);
                pass1=true;
                pass2=true;
                JOptionPane.showMessageDialog(null,"Successfully login as Admin","Login Successfully",1);

            }
        }
        if (pass1!=true){
            for (int i=0;i<Manager.managerAl.size();i++){
                if(Manager.managerAl.get(i).getId().equals(id)&&Manager.managerAl.get(i).password.equals(pw)){
                    pass1=true;
                    pass2=true;
                    JOptionPane.showMessageDialog(null,"Successfully login as Manager","Login Successfully",1);
                    ManagerHome.getJfManager().setVisible(true);
                    ManagerHome.getLblManagerName().setText(Manager.managerAl.get(i).name);
                    StaffLogin.getJfLogin().setVisible(false);
                }
            }
        }else if (pass2!=true){
            for (int i=0;i<Rider.riderAl.size();i++){
                if(Rider.riderAl.get(i).getId().equals(id)&&Rider.riderAl.get(i).password.equals(pw)){
                    pass1=true;
                    pass2=true;
                    JOptionPane.showMessageDialog(null,"Successfully login as Rider","Login Successfully",1);
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
