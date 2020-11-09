package courier;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class Staff extends Person{
    //creating a staff
    public Staff(Integer age, Integer phone, String name, String username, String password) throws InvalidNameException, InvalidPhoneException, InvalidAgeException {
        super(age, phone, name);
    }


    //func created a credential setter for all staff class
    public void setCredential(String fileLocation,String username,String password){
        FileWriter fw=null;
        BufferedWriter bw=null;
        PrintWriter pw=null;
        try{
            fw = new FileWriter(fileLocation, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.println(username+","+password);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fw.close();
                bw.close();
                pw.close();
            } catch (IOException e) { //instances where the i/o cannot be close
                e.printStackTrace();
            }

        }
    }






}
