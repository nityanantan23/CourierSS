package courier;
import java.util.ArrayList;
public class Admin extends Staff{
    public static ArrayList<Admin> adminAl=new ArrayList();

    public Admin(){}

    public Admin(String id,String name, String phone, String password  ){
        super(id,name, phone,  password);

    }

    @Override
    public void loadStaff() {
        findStaffFile("txtFile/Admin_account.txt");
        while(s.hasNext()){
            readFile();
            Admin a= new Admin(getId(),getName(),getPhone(),getPassword());
            adminAl.add(a);
        }
    }

    public static void main(String[] args){
        Admin c= new Admin();
        c.loadStaff();
        System.out.println(adminAl.get(0).getPhone());
        Manager m= new Manager();
        m.loadStaff();
        System.out.println(Manager.managerAl.get(0).getName()+" Your pass word is "+Manager.managerAl.get(0).getPassword());
        Rider r= new Rider();
        r.loadStaff();
        System.out.println(Rider.riderAl.get(0).getName()+" Your pass word is "+Rider.riderAl.get(0).getPassword());
    }


}
