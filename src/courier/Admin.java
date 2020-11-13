package courier;
import java.util.ArrayList;
public class Admin extends Staff{
    public static ArrayList<Admin> adminAl=new ArrayList();

    public Admin(){}

    public Admin(String id,String name,Integer age, String phone, String password  ){
        super(id,name,age, phone,  password);

    }

    @Override
    public void loadStaff() {
        findStaffFile("txtFile/Admin_account.txt");
        while(s.hasNext()){
            readfile();
            Admin a= new Admin(getId(),getName(),getAge(),getPhone(),getPassword());
            adminAl.add(a);
        }
    }


}
