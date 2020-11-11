package courier;
import java.util.ArrayList;

public class Manager extends Staff{
    public static ArrayList<Manager> managerAl=new ArrayList();

    public Manager(){};
    public Manager( String name,Integer age, String phone, String username, String password){
        super(name,age, phone, username, password);

    }

    @Override
    public void loadStaff() {
        findStaffFile("txtFile/Manager_account.txt");
        while (s.hasNext()){
            readfile();
            Manager m= new Manager(getName(),getAge(),getPhone(),getUsername(),getPassword());
            managerAl.add(m);
        }

    }


    //manager class creation

}
