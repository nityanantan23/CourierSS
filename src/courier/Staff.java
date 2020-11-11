package courier;

import java.io.*;
import java.util.Scanner;

public abstract class Staff extends Person{
    //creating a staff
    protected String password,username;
    public static Scanner s;

    public Staff(){
        super();

    }

    public Staff( String name,Integer age, String phone,String username, String password) {
        super(name,age, phone);
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
            if (s.hasNext()) {
                s.nextLine();
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
