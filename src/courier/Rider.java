package courier;

import java.util.ArrayList;

public class Rider extends Staff{
    public static ArrayList<Rider> riderAl=new ArrayList();

    public Rider(){}

    public Rider(String id , String name,Integer age, String phone, String username, String password  ) {
        super(id, name,age, phone,  username, password);
    }//rider class creation

    @Override
    public void loadStaff() {
        findStaffFile("txtFile/Rider_account.txt");
        while (s.hasNext()){
            readfile();
            Rider r= new Rider(getId(),getName(),getAge(),getPhone(),getUsername(),getPassword());
            riderAl.add(r);
        }
    }

//    public static void main(String[] Args){
//
//
//    }

}
