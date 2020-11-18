package courier;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends Person{
    private String ic;
    private static ArrayList<Customer> customerAl= new ArrayList<>();
    private String line;
    private String[] lineV;

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
    public void readFile() {
        try {
            Scanner s= new Scanner(new File("txtFile/Customer.txt"));
            while (s.hasNext()){
                //read single line first
                line=s.nextLine();
                //split the line and store it as array
                lineV= line.split(",");
                //assigning the read variable to the object.
                setId(lineV[0]);
                setName(lineV[1]);
                setAge(Integer.parseInt(lineV[2]));
                setPhone(lineV[3]);
                setIc(lineV[4]);
                if (s.hasNext()){
                    s.next();
                }
                Customer c= new Customer(getId(),getName(),getAge(),getPhone(),getIc());
                customerAl.add(c);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
