package courier;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends Person{
    private String ic;
    private static ArrayList<Customer> customerAl= new ArrayList<>();

    public Customer(){}
    //customer class creation
    public Customer(String id,String name,Integer age, String phone ,String ic){
        super(id,name,age, phone);
        setIc(ic);
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    @Override
    public void readfile() {
        try {
            Scanner s= new Scanner(new File("txtFile/Customer.txt"));
            while (s.hasNext()){
                setId(s.nextLine());
                setName(s.nextLine());
                setAge(Integer.parseInt(s.nextLine()));
                setPhone(s.nextLine());
                setIc(s.nextLine());
                if (s.hasNext()){
                    s.nextLine();
                }
                Customer c= new Customer(getId(),getName(),getAge(),getPhone(),getIc());
                customerAl.add(c);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args){
//        Customer c= new Customer();
//        c.readfile();
//        System.out.println(customerAl.get(0).ic);
//    }
}
