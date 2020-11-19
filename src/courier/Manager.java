package courier;
import java.util.ArrayList;

public class Manager extends Staff{
    public static ArrayList<Manager> managerAl=new ArrayList();

    public Manager(){};
    public Manager( String id,String name, String phone, String password){
        super(id,name, phone, password);

    }

    @Override
    public void loadStaff() {
        findStaffFile("txtFile/Manager_account.txt");
        while (s.hasNext()){
            readFile();
            Manager m= new Manager(getId(),getName(),getPhone(),getPassword());
            managerAl.add(m);
        }
    }


    //manager class creation

}
