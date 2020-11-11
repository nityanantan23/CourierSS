package courier;

import java.util.ArrayList;

public class Rider extends Staff{
    public static ArrayList<Rider> riderAl=new ArrayList();

    public Rider(){}

    public Rider( String name,Integer age, String phone, String username, String password  ) {
        super(name,age, phone,  username, password);
    }//rider class creation

    @Override
    public void loadStaff() {
        findStaffFile("txtFile/Rider_account.txt");
        while (s.hasNext()){
            readfile();
            Rider r= new Rider(getName(),getAge(),getPhone(),getUsername(),getPassword());
            riderAl.add(r);
        }
    }

//    public static void main(String[] Args){
//
//
//    }

}
