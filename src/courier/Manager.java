package courier;
import java.util.ArrayList;

public class Manager extends Staff{
    public static ArrayList<Manager> managerAl=new ArrayList();

    public Manager(){};
    public Manager( String id,String name,Integer age, String phone, String password){
        super(id,name,age, phone, password);

    }

    @Override
    public void loadStaff() {
        findStaffFile("txtFile/Manager_account.txt");
        while (s.hasNext()){
            readFile();
            Manager m= new Manager(getId(),getName(),getAge(),getPhone(),getPassword());
            managerAl.add(m);
        }
    }


    //manager class creation

}
