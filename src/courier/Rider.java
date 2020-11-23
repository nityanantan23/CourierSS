package courier;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Rider extends Staff{
    public static ArrayList<Rider> riderAl=new ArrayList();

    public Rider(){}

    public Rider(String id , String name, String phone,  String password  ) {
        super(id, name, phone,  password);
    }//rider class creation

    @Override
    public void loadStaff() {
        findStaffFile("txtFile/Rider_account.txt");
        while (s.hasNext()){
            readFile();
            Rider r= new Rider(getId(),getName(),getPhone(),getPassword());
            riderAl.add(r);
        }
    }


    @Override
    public void writeLine() {
        FileWriter fw=null;
        BufferedWriter bw=null;
        PrintWriter pw=null;
        try{
            fw = new FileWriter("txtFile/Rider_account.txt", true);
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
}
