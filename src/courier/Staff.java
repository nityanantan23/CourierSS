package courier;

import courier.manager.ManagerHome;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

import static courier.StaffLogin.resetField;

public abstract class Staff extends Person{
    //creating a staff
    protected String password,username;
    public static Scanner s;

    public Staff(){
        super();
    }

    public Staff(String id ,String name,Integer age, String phone,String username, String password) {
        super(id,name,age, phone);
        setUsername(username);
        setPassword(password);
    }

    public abstract void loadStaff() ;

    public void setUsername(String username){
        this.username=username;
    }

    public void setPassword(String password){
        this.password=password;
    }


    public String getUsername(){
        return username;
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
    public void readfile() {
            setName(s.nextLine()) ;
            setAge( Integer.parseInt(s.nextLine()));
            setPhone(s.nextLine());
            setUsername(s.nextLine());
            setPassword(s.nextLine());
            if(s.nextLine().isEmpty()){

            }
            if (s.hasNext()) {
                s.nextLine();
            }
    }
    public static void credentialChecker(String  id, String pw){
        boolean pass1 = false,pass2= false;
        //check for admin first
        for (int i=0;i<Admin.adminAl.size();i++){

            if(Admin.adminAl.get(i).username.equals(id)&&Admin.adminAl.get(i).password.equals(pw)){
                System.out.println(Admin.adminAl.get(i).username);
                System.out.println(Admin.adminAl.get(i).password);
                pass1=true;
                pass2=true;
                JOptionPane.showMessageDialog(null,"Successfully login as Admin","Login Successfully",1);

            }
        }
        if (pass1!=true){
            for (int i=0;i<Manager.managerAl.size();i++){
                if(Manager.managerAl.get(i).username.equals(id)&&Manager.managerAl.get(i).password.equals(pw)){
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
                if(Rider.riderAl.get(i).username.equals(id)&&Rider.riderAl.get(i).password.equals(pw)){
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
