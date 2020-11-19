package courier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends Person implements IDGenerator {
    private String ic;
    private static ArrayList<Customer> customerAl= new ArrayList<>();
    private String line;
    private String[] lineV;
    private static int cusCount = 100;

    public Customer(){}
    //customer class creation
    public Customer(String id,String name,  String phone ,String ic){
        super(id,name, phone);
        setIc(ic);
    }

    public String getIc() {
        return ic;
    }
    public void setIc(String ic) {
        this.ic = ic;
    }
    public static ArrayList<Customer> getCustomerAL(){
        return customerAl;
    }
    public static Integer getCusCount(){return cusCount;};

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
                setPhone(lineV[2]);
                setIc(lineV[3]);
                if (s.hasNext()){
                    s.next();
                }
                Customer c= new Customer(getId(),getName(),getPhone(),getIc());
                customerAl.add(c);
                cusCounter();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void cusCounter(){
        cusCount=cusCount+1;
    }


    @Override
    public String generateID() {
        return null;
        //todo fix here
    }
}
