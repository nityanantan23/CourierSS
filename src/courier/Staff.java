package courier;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class Staff extends Person{
    //creating a staff
    private String password,username,credentialfilelocation;

    public Staff(Integer age, String phone, String name, String username, String password,String credentialfilelocation) throws InvalidNameException, InvalidPhoneException, InvalidAgeException {
        super(age, phone, name);
        this.credentialfilelocation=credentialfilelocation;
        setCredential(this.credentialfilelocation,username,password);

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

            pw.print("\n"+username+","+password);
            this.password=password;
            this.username=username;
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
}
