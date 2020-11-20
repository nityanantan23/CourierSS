package courier;

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



}
